package org.kuali.student.core.exception;

public class ReadOnlyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public ReadOnlyException() {
        super();
    }

    public ReadOnlyException(String message) {
        super(message);
    }

}
