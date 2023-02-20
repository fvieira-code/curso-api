package br.com.dicasdeumdev.apitest.resources.exceptions;

import br.com.dicasdeumdev.apitest.services.exceptions.DataIntegratyViolationException;
import br.com.dicasdeumdev.apitest.services.exceptions.ObjectNotFoundException;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ResourceExceptionHandlerTest {

    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";
    public static final String EMAIL_JA_CADASTRADO = "Email já cadastrado";
    public static final int RETORNO_STATUS_400 = 400;
    public static final int RETORNO_STATUS_404 = 404;
    public static final String PATH = "/user/2";

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
        assertEquals(RETORNO_STATUS_404, response.getBody().getStatus());
        assertNotEquals(PATH, response.getBody().getPath());
        assertNotEquals(LocalDateTime.now(), response.getBody().getTimestamp());
    }

    @Test
    void dataIntegrityViolationException() {

        ResponseEntity<StandardError> response = exceptionHandler
                .dataIntegrityViolationException(
                        new DataIntegratyViolationException(EMAIL_JA_CADASTRADO),
                        new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(EMAIL_JA_CADASTRADO, response.getBody().getError());
        assertEquals(RETORNO_STATUS_400, response.getBody().getStatus());

    }
}