package br.com.dicasdeumdev.apitest.services.impl;

import br.com.dicasdeumdev.apitest.domain.User;
import br.com.dicasdeumdev.apitest.repositories.UserRepository;
import br.com.dicasdeumdev.apitest.services.UserService;
import br.com.dicasdeumdev.apitest.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User finById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
