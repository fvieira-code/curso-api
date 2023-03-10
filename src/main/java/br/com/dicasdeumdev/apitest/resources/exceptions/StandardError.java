package br.com.dicasdeumdev.apitest.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StandardError {

    private LocalDateTime timestamp;
    private Integer status;
    private String Error;
    private String path;
}
