package br.com.prof.twodatabases.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prof.twodatabases.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
