package br.com.dicasdeumdev.apitest.resources.exceptions;

import br.com.dicasdeumdev.apitest.services.exceptions.ObjectNotFoundException;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ResourceExceptionHandlerTest {

    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";
    public static final int RETORNO_STATUS = 404;
    @InjectMocks
    private ResourceExceptionHandler exceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenObjectNotFoundExceptionThenReturnAnResponseEntity() {
        ResponseEntity<StandardError> response = exceptionHandler
                .objectNotFound(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO),
                new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(OBJETO_NAO_ENCONTRADO, response.getBody().getError());
        assertEquals(RETORNO_STATUS, response.getBody().getStatus());
    }

    @Test
    void dataIntegratyViolationException() {
    }
}