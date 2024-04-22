package br.com.neurotech.challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends Throwable {
    public ClientNotFoundException(Long clientId) { super("Could not find order " + clientId);
    }
}
