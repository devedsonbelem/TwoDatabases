package br.com.prof.twodatabases.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prof.twodatabases.events.UsersBloqueado;

public interface UsersBloqueadoRepository  extends JpaRepository<UsersBloqueado, Long>{

}
