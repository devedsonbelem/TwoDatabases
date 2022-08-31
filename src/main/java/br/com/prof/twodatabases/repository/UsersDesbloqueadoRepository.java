package br.com.prof.twodatabases.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prof.twodatabases.events.UsersDesbloqueado;

public interface UsersDesbloqueadoRepository   extends JpaRepository<UsersDesbloqueado, Long>{

}
