package br.com.prof.twodatabases.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prof.twodatabases.events.UsersRemovido;

public interface UsersRemovidoRepository  extends JpaRepository<UsersRemovido, Long>{

}
