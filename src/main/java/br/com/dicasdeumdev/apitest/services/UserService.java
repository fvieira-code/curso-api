package br.com.dicasdeumdev.apitest.services;

import br.com.dicasdeumdev.apitest.domain.User;

import java.util.List;

public interface UserService {
    User finById(Integer id);

    List<User> findAll();
}
