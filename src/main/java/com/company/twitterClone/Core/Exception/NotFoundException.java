package com.company.twitterClone.Core.Exception;

public class NotFoundException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 7487987444072121291L;

	private String message;

	public NotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
