package br.com.prof.twodatabases.events;

 

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.prof.twodatabases.type.TypeStatusAtivado;

 

@Entity
@DiscriminatorValue("ATIVADO")
public class UsersAtivado  extends UsersEventStatus{
	
	 
	private static final long serialVersionUID = 1L;
	
	
	@Column(length=50)
	private String status;
	 
 
    
    public UsersAtivado() {
	}

    public UsersAtivado(  LocalDateTime dataAtivacao, String objectUsers, String status) {
		super( dataAtivacao, objectUsers);
		this.status = status;
	}
    
	public UsersAtivado(Integer idUsers, LocalDateTime dataAtivacao, String objectUsers, String status) {
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
