package br.com.prof.twodatabases.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prof.twodatabases.events.UsersAlterado;

@Repository
public interface UsersAlteradoRepository extends JpaRepository<UsersAlterado, Long>{

}
