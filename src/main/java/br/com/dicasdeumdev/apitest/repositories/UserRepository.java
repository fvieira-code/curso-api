package br.com.dicasdeumdev.apitest.repositories;

import br.com.dicasdeumdev.apitest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
