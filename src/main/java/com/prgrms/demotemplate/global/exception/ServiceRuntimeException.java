package com.prgrms.demotemplate.global.exception;

public class ServiceRuntimeException extends RuntimeException {

	protected ServiceRuntimeException() {
	}

	public ServiceRuntimeException(String message) {
		super(message);
	}

	public ServiceRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceRuntimeException(Throwable cause) {
		super(cause);
	}

	public ServiceRuntimeException(String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

