package br.com.dicasdeumdev.apitest.resources;

import br.com.dicasdeumdev.apitest.domain.dto.UserDTO;
import br.com.dicasdeumdev.apitest.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    public static final String ID = "/{id}";

    @Autowired
    private UserService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = ID)
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(service.finById(id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll()
                .stream()
                .map(dto -> mapper.map(dto, UserDTO.class))
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create( @RequestBody UserDTO obj) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path(ID)
                .buildAndExpand(service.create(obj))
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = ID)
    public ResponseEntity<UserDTO> update(@PathVariable Integer id,
                                              @RequestBody UserDTO obj) {
        obj.setId(id);
        return ResponseEntity.ok().body(
                mapper.map(service.update(obj), UserDTO.class)
        );
    }

    @DeleteMapping(value = ID)
    public ResponseEntity<UserDTO> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
