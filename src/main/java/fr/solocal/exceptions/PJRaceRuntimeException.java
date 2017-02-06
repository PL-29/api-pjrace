package fr.solocal.exceptions;

/**
 * @author scollet
 *
 */
public class PJRaceRuntimeException extends RuntimeException {


	private static final long serialVersionUID = 475103085517799579L;


	public PJRaceRuntimeException() {
	}


	public PJRaceRuntimeException(String message) {
		super(message);
	}


	public PJRaceRuntimeException(Throwable cause) {
		super(cause);
	}


	public PJRaceRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}


	public PJRaceRuntimeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
