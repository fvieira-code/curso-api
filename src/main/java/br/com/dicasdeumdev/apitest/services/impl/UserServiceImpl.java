package br.com.dicasdeumdev.apitest.services.impl;

import br.com.dicasdeumdev.apitest.domain.User;
import br.com.dicasdeumdev.apitest.domain.dto.UserDTO;
import br.com.dicasdeumdev.apitest.repositories.UserRepository;
import br.com.dicasdeumdev.apitest.services.UserService;
import br.com.dicasdeumdev.apitest.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User finById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        return repository.save(mapper.map(obj, User.class));
    }
}
