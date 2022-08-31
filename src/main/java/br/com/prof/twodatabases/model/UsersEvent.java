package br.com.prof.twodatabases.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsersEvent {
 
	private Object   id;
	private String   code;
	private String   event;
	private String   status;
	private String   users;
	private Date     dataEvent;
	
	
	public UsersEvent() {
	}

	 
	
	public UsersEvent(String code, String event, String status, Date data) {
		super();
		this.code = code;
		this.event = event;
		this.status = status;
		this.dataEvent = data;
	}



	public UsersEvent(Object id, String code, String event, String status, String users, Date dataEvent) {
		super();
		this.id = id;
		this.code = code;
		this.event = event;
		this.status = status;
		this.users = users;
		this.dataEvent = dataEvent;
	}



	public UsersEvent(Object id, String code, String event, String status, Date data ) {
		super();
		this.id = id;
		this.code = code;
		this.event = event;
		this.status = status;
		this.dataEvent = data;
	}

    

	@Override
	public String toString() {
		return "UsersEvent [id=" + id + ", code=" + code + ", event=" + event + 
				", status=" + status + ",name ="  + users + ", dataEvent="
	+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dataEvent) + "]";
	}



	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

  

	public Date getDataEvent() {
		return dataEvent;
	}



	public String getUsers() {
		return users;
	}



	public void setUsers(String users) {
		this.users = users;
	}



	public void setDataEvent(Date dataEvent) {
		this.dataEvent = dataEvent;
	}

	
	
	
}
