package br.com.prof.twodatabases.service;

 

import org.springframework.stereotype.Service;

import br.com.prof.twodatabases.entity.Users;
import br.com.prof.twodatabases.repository.UsersRepository;

 
@Service
public class UsersService {

	 
	    private final UsersRepository usersRepository;
	
	    public UsersService(UsersRepository usersRepository) {
	        this.usersRepository = usersRepository;
	    } 
	
//	    public Object realizarRegistro(Users registro) throws ParticipanteException {
//	        try {
//	            Users participante = Users.criar(registroParticipante);
//	            participanteRepository.saveAndFlush(participante);
//	            return new ResultadoRegistro(participante.getId(), participante.getEstado());
//	        } catch(Exception e) {
//	            log.error("Falha ao criar participante", e);
//	            throw new ParticipanteException("Falha ao registrar participante");
//	        }
//	    }
	
//	    public ResultadoAtivacao ativarParticipante(Integer id) throws ParticipanteException {
//	        Participante participante = participanteRepository
//	                .findById(id).orElseThrow( () -> new ParticipanteException("Participante não encontrado!") );
//	        participanteRepository.save(participante.ativado());
//	        return new ResultadoAtivacao(participante.getId(), participante.getEstado());
//	    }
	
	 
}
