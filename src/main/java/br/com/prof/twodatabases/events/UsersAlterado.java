package br.com.prof.twodatabases.events;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ALTERADO")
public class UsersAlterado extends UsersEventStatus {

	private static final long serialVersionUID = 1L;
	@Column(length = 50)
	private String status;

	public UsersAlterado(Integer idUsers, LocalDateTime dataAtivacao, String objectUsers, String status) {
		super(idUsers, dataAtivacao, objectUsers);
		this.status = status;
	}

	public UsersAlterado() {
	}

	@Override
	public String toString() {
		return "UsersEvent [idUsers=" + getIdUsers() + ", dataAtivacao=" + getDataAtivacao() + ", objectUsers="
				+ getObjectUsers() + status + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
