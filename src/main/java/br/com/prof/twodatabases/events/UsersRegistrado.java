package br.com.prof.twodatabases.events;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@DiscriminatorValue("REGISTRADO")
public class UsersRegistrado extends UsersEventStatus {
 
	private static final long serialVersionUID = 1L;
	@Column(length=50)
	private String status;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDate data;
 
    
    public UsersRegistrado() {
	}

	public  UsersRegistrado(Integer idUsers, LocalDateTime dataAtivacao, String objectUsers, String status) {
		super(idUsers, dataAtivacao, objectUsers);
		this.status = status;
	}

	public  UsersRegistrado(LocalDateTime dataAtivacao, String objectUsers, String status) {
		super(dataAtivacao, objectUsers);
		this.status = status;
	}

	@Override
	public String toString() {
		return "UsersEvent [idUsers=" + getIdUsers() + ", dataAtivacao=" + getDataAtivacao() + ", objectUsers=" + getObjectUsers()
				+  status + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

 
    
    
    
}
