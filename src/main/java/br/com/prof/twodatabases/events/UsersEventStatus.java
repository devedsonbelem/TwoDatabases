package br.com.prof.twodatabases.events;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "status", length = 255, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("INATIVO")
public class UsersEventStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsers;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime dataAtivacao;
	
	@Column(length = 255)
	private String objectUsers;
	
	@Column(insertable = false, updatable = false)
	private String status;
	
 

	public UsersEventStatus(LocalDateTime dataAtivacao, String objectUsers) {
		super();
		this.dataAtivacao = dataAtivacao;
		this.objectUsers = objectUsers;
	}

	public UsersEventStatus(LocalDateTime dataAtivacao, String objectUsers, String status) {
		super();
		this.dataAtivacao = dataAtivacao;
		this.objectUsers = objectUsers;
		this.status = status;
	}

	public UsersEventStatus(Integer idUsers, LocalDateTime dataAtivacao, String objectUsers) {
		super();
		this.idUsers = idUsers;
		this.dataAtivacao = dataAtivacao;
		this.objectUsers = objectUsers;
	}

 

	public UsersEventStatus(Integer idUsers, LocalDateTime dataAtivacao, String objectUsers, String status) {
		super();
		this.idUsers = idUsers;
		this.dataAtivacao = dataAtivacao;
		this.objectUsers = objectUsers;
		this.status = status;
	}

	public UsersEventStatus(Integer idUsers, LocalDateTime dataAtivacao, String objectUsers, String status,
			String motivo) {
		super();
		this.idUsers = idUsers;
		this.dataAtivacao = dataAtivacao;
		this.objectUsers = objectUsers;
		this.status = status;
	}

	public UsersEventStatus() {

	}

	public LocalDateTime getDataAtivacao() {
		return dataAtivacao;
	}

	public void setDataAtivacao(LocalDateTime dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}

	public String getObjectUsers() {
		return objectUsers;
	}

	public void setObjectUsers(String objectUsers) {
		this.objectUsers = objectUsers;
	}

	public Integer getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(Integer idUsers) {
		this.idUsers = idUsers;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

 
}
