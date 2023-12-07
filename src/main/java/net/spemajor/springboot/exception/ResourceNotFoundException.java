package net.spemajor.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Whenever any record does not exist in the database, then our application should throw and exception
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException 
{
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
