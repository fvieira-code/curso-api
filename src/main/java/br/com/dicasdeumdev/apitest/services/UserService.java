package br.com.dicasdeumdev.apitest.services;

import br.com.dicasdeumdev.apitest.domain.User;

public interface UserService {
    User finById(Integer id);
}
