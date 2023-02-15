package com.prgrms.demotemplate.global.exception;

import lombok.Getter;

@Getter
public abstract class ServiceRuntimeException extends RuntimeException {

	protected static final String DOT = ".";

	private final String messageKey;

	private final Object[] params;

	protected ServiceRuntimeException(String messageKey, Object[] params) {
		this.messageKey = messageKey;
		this.params = params;
	}
}

