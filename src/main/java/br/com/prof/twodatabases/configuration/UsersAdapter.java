package br.com.prof.twodatabases.configuration;

import org.bson.Document;

import br.com.prof.twodatabases.model.UsersEvent;

public class UsersAdapter {

	 public static Document toDocument(UsersEvent event) {
		  Document doc = new Document();
		   doc.append("code", event.getCode());
		   doc.append("event", event.getEvent());
		   doc.append("status", event.getStatus());
		   doc.append("name",event.getUsers());
		   doc.append("data", event.getDataEvent());
		   return doc;
	 }


	 public static Document toDocumentUpdate(UsersEvent event) {
		  Document doc = new Document();
		   doc.append("_id", event.getId());
		   doc.append("code", event.getCode());
		   doc.append("event", event.getEvent());
		   doc.append("status", event.getStatus());
		   doc.append("user", event.getUsers());
		   doc.append("data", event.getDataEvent());
		   return doc;
	 }
	 
	 
	  public static UsersEvent getObjects(Document doc) {
		   UsersEvent users= new UsersEvent(doc.get("_id"),
				           doc.getString("code"),
				           doc.getString("event"), 
				           doc.getString("status"), 
				           doc.getString("user"),
				           doc.getDate("data"));
		  return users;
	  }
	 
	 
}
