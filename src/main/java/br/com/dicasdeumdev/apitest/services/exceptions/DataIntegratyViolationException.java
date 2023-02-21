package br.com.dicasdeumdev.apitest.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException{
    public DataIntegratyViolationException(String message) {

        super(message);
    }
}
