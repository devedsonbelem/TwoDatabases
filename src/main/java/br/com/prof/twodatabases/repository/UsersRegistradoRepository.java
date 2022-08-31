package br.com.prof.twodatabases.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prof.twodatabases.events.UsersRegistrado;

public interface UsersRegistradoRepository  extends JpaRepository<UsersRegistrado, Long> {

}
