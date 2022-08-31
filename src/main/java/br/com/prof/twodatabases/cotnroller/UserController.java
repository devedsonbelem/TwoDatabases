package br.com.prof.twodatabases.cotnroller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.prof.twodatabases.database.UsersEventDao;
import br.com.prof.twodatabases.entity.Users;
import br.com.prof.twodatabases.events.UsersAtivado;
import br.com.prof.twodatabases.events.UsersBloqueado;
import br.com.prof.twodatabases.model.UsersEvent;
import br.com.prof.twodatabases.repository.UsersBloqueadoRepository;
import br.com.prof.twodatabases.repository.UsersEventAtivadoRepository;
import br.com.prof.twodatabases.repository.UsersRepository;

@ResponseBody
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UsersRepository repository;

	@Autowired
	UsersEventAtivadoRepository repositorypostgreativado;

	@Autowired
	UsersBloqueadoRepository repositorybloqueado;

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Users users) {
		try {
			Users resp = repository.save(users);
			if (resp == null) {
				throw new Exception("nao consegui");
			}
			Date d = new Date();
			UsersEvent event = new UsersEvent(String.valueOf(resp.getId()), "NOVOUSUARIO", "USUARIO_GRAVADO",
					new java.sql.Date(d.getTime()));
			event.setUsers(users.getName());

			new UsersEventDao().save(event); // Mongodb (Evento gravado no Mongodb)

			UsersAtivado ativado = resp.ativado(resp);

			repositorypostgreativado.save(ativado); // Evento gravado no Postgre

			Map<String, Object> mapa = new HashMap<String, Object>();
			mapa.put("users", users); // postgre
			mapa.put("event", event); // mongod
			mapa.put("obj", ativado); /// postgre o evento
			return ResponseEntity.status(200).body(mapa);
		} catch (Exception ex) {
			try {
				Date d = new Date();
				UsersEvent events = new UsersEvent(UUID.randomUUID().toString(), "NOVOUSUARIO", "USUARIO_NAOGRAVADO",
						new java.sql.Date(d.getTime()));
				events.setUsers("users-not-Save");
				new UsersEventDao().save(events);

				UsersBloqueado bloqueado = users.bloqueado(users);
				repositorybloqueado.save(bloqueado);

				return ResponseEntity.status(500).body("error:" + ex.getMessage());
			} catch (Exception ex3) {
				return ResponseEntity.status(401).body("error:" + ex.getMessage());
			}
		}

	}

	@GetMapping("/list")
	public ResponseEntity<?> findAll() {
		try {

			return ResponseEntity.status(200).body(new UsersEventDao().findAll());
		} catch (Exception ex) {
			return ResponseEntity.status(500).body("error:" + ex.getMessage());
		}

	}

//
//         private final ParticipanteService participanteService;
//
//         public ParticipanteController(ParticipanteService participanteService) {
//             this.participanteService = participanteService;
//         }
//
//         @PostMapping
//         public ResponseEntity<ResultadoRegistro> registrarParticipante(@RequestBody RegistroParticipante registroParticipante) {
//             try {
//                 return ResponseEntity.ok(this.participanteService.realizarRegistro(registroParticipante));
//             } catch (ParticipanteException e) {
//                 return ResponseEntity.badRequest().build();
//             }
//         }
//
//         @PutMapping("/ativar/{id}")
//         public ResponseEntity<ResultadoAtivacao> ativarParticipante(@PathVariable("id") Integer id) {
//             try {
//                 return ResponseEntity.ok(this.participanteService.ativarParticipante(id));
//             } catch (ParticipanteException e) {
//                 return ResponseEntity.badRequest().build();
//             }
//         }

}
