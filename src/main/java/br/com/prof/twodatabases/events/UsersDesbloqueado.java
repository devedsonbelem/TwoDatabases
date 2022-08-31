package br.com.prof.twodatabases.events;

 

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.prof.twodatabases.type.TypeStatusBloqueado;
import br.com.prof.twodatabases.type.TypeStatusDesbloqueado;

@Entity
@DiscriminatorValue("DESBLOQUEADO")
public class UsersDesbloqueado extends UsersEventStatus {
	

	@Column(length=50)
	private String status;
	 
 
    
    public  UsersDesbloqueado() {
	}

	public  UsersDesbloqueado(Integer idUsers, LocalDateTime dataAtivacao, String objectUsers, String status) {
		super(idUsers, dataAtivacao, objectUsers);
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
