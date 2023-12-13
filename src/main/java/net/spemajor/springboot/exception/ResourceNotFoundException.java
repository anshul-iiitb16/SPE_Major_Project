package net.spemajor.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Whenever any record does not exist in the database, then our application should throw and exception
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException 
{
    private static final Logger logger =
			LogManager.getLogger(ResourceNotFoundException.class);

    public ResourceNotFoundException(String message)
    {
        super(message);
        logger.error("This is an error message - Resource Not Found");
    }
}
