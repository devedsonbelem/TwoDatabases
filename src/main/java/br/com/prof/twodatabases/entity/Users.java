package br.com.prof.twodatabases.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.prof.twodatabases.events.UsersAlterado;
import br.com.prof.twodatabases.events.UsersAtivado;
import br.com.prof.twodatabases.events.UsersBloqueado;
import br.com.prof.twodatabases.events.UsersRegistrado;
import br.com.prof.twodatabases.events.UsersRemovido;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
public class Users extends AbstractAggregateRoot<Users> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	@Column(length = 80)
	private String email;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime dataAtivacao=LocalDateTime.now();
	@Column(length = 250)
	private String estado;

	public Users() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDataAtivacao() {
		return dataAtivacao;
	}

	public void setDataAtivacao(LocalDateTime dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	private Users(UsersBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		;
		this.email = builder.email;
		this.estado = builder.estado;
	}

	public Users(LocalDateTime dataAtivacao, String name) {
		super();
		this.dataAtivacao = dataAtivacao;
		this.name = name;
	}

	public Users(LocalDateTime dataAtivacao, String name, String estado) {
		super();
		this.dataAtivacao = dataAtivacao;
		this.name = name;
		this.estado = estado;
	}

	public Users(Integer id, LocalDateTime dataAtivacao, String name) {
		super();
		this.id = id;
		this.dataAtivacao = dataAtivacao;
		this.name = name;
	}

	public Users(Integer id, LocalDateTime dataAtivacao, String name, String estado) {
		super();
		this.id = id;
		this.dataAtivacao = dataAtivacao;
		this.estado = estado;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", estado=" + estado + "]";
	}

	public static class UsersBuilder {

		private Integer id;
		private String name;
		private String email;
		private String estado;

		public UsersBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public UsersBuilder name(String name) {
			this.name = name;
			return this;
		}

		public UsersBuilder email(String email) {
			this.email = email;
			return this;
		}

		public UsersBuilder estado(String estado) {
			this.estado = estado;
			return this;
		}

		public Users build() {
			Users user = new Users(this);
			return user;
		}
	}

	public UsersAlterado alterado(Users users) {
		UsersAlterado eventpostgre = new UsersAlterado(users.id, LocalDateTime.now(), users.toString(), "ALTERADO");
		this.registerEvent(eventpostgre);
		return eventpostgre;
	}

	public UsersBloqueado bloqueado(Users users) {
		UsersBloqueado eventpostgre = new UsersBloqueado(users.id, LocalDateTime.now(), users.toString(), "BLOQUEADO");
		this.registerEvent(new UsersBloqueado(this.id, LocalDateTime.now(), users.toString(), "BLOQUEADO"));
		return eventpostgre;
	}

	public Users registrado(Users users) {
		this.registerEvent(new UsersRegistrado(LocalDateTime.now(), users.toString(), "REGISTRADO"));
		return this;
	}

	public Users removido(Users users) {
		this.registerEvent(new UsersRemovido(LocalDateTime.now(), users.toString(), "REMOVIDO"));
		return this;
	}

	
	
	public UsersAtivado ativado(Users users) {
		this.estado = "ATIVO";
		UsersAtivado ativopostgre = 
				new UsersAtivado(users.id, LocalDateTime.now(), users.toString(), "ATIVADO");
		this.registerEvent(new UsersAtivado(users.id, LocalDateTime.now(), users.toString(), "ATIVADO"));
		return ativopostgre;
	}
	
	
	
	
	

}
