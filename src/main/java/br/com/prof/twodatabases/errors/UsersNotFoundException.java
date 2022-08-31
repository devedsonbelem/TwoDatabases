package br.com.prof.twodatabases.errors;

public class UsersNotFoundException extends RuntimeException {
 
	private static final long serialVersionUID = 1L;

	public UsersNotFoundException(Long id) {
        super("users id not found : " + id);
    }

}