package br.com.prof.twodatabases.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prof.twodatabases.events.UsersEventStatus;

public interface UsersEventStatusRepository  extends JpaRepository<UsersEventStatus, Long>{

}
