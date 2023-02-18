package com.prgrms.demotemplate.domain.user.exception;

import com.prgrms.demotemplate.global.exception.ServiceException;


public class UserException extends ServiceException {

	private static final String MESSAGE_KEY = "error.user";

	public UserException(String detailKey) {
		this(MESSAGE_KEY + DOT + detailKey, null);
	}

	public UserException(String detailKey, Object[] params) {
		super(MESSAGE_KEY + DOT + detailKey, params);
	}
}
