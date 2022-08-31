package br.com.prof.twodatabases.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prof.twodatabases.events.UsersAtivado;

public interface UsersEventAtivadoRepository  extends JpaRepository<UsersAtivado, Long> {

}
