package fr.solocal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import fr.solocal.exceptions.PJRaceException;
import fr.solocal.exceptions.PJRaceRuntimeException;

/**
 * Controller de gestion des Exceptions retournées par l'API. Mapping de ces Exceptions avec des codes retour HTTP.
 * @author scollet
 *
 */
public class ExceptionController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class.getName());
	
    @ExceptionHandler (PJRaceException.class)
    @ResponseStatus (HttpStatus.BAD_REQUEST)
    public String handleBadRequestExceptions(PJRaceException ex) {
    	logger.error(ex.getMessage(), ex);
        return ex.getMessage();
    }
    
    @ExceptionHandler (PJRaceRuntimeException.class)
    @ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleRuntimeExceptions(PJRaceRuntimeException ex) {
    	logger.error(ex.getMessage(), ex);
        return ex.getMessage();
    }
    

    
}