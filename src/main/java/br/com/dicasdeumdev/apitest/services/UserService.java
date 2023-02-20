package br.com.dicasdeumdev.apitest.services;

import br.com.dicasdeumdev.apitest.domain.User;
import br.com.dicasdeumdev.apitest.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    User finById(Integer id);

    List<User> findAll();

    User create(UserDTO obj);
}
