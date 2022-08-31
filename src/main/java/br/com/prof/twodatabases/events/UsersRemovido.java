package br.com.prof.twodatabases.events;

 

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.prof.twodatabases.type.TypeStatusRemovido;

@Entity
@DiscriminatorValue("REMOVIDO")
public class UsersRemovido extends UsersEventStatus implements Serializable {
 
	private static final long serialVersionUID = 1L;
	@Column(length=50)
	private String status;
	 
 
    
    public UsersRemovido() {
	}

	public  UsersRemovido(Integer idUsers, LocalDateTime dataAtivacao, String objectUsers, String status) {
		super(idUsers, dataAtivacao, objectUsers);
		this.status = status;
	}
	public  UsersRemovido(  LocalDateTime dataAtivacao, String objectUsers, String status) {
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

 
