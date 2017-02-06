package fr.solocal.exceptions;

/**
 * @author scollet
 *
 */
public class PJRaceException extends Exception {

	
	private static final long serialVersionUID = -6048480108822824395L;

	
	public PJRaceException() {
	}

	public PJRaceException(String message) {
		super(message);
	}


	public PJRaceException(Throwable cause) {
		super(cause);
	}


	public PJRaceException(String message, Throwable cause) {
		super(message, cause);
	}


	public PJRaceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
