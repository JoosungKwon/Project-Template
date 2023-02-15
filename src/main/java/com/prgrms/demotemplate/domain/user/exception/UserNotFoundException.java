package com.prgrms.demotemplate.domain.user.exception;

public class UserNotFoundException extends UserException{

	private static final String detailKey = "notfound";

	public UserNotFoundException() {
		this(null);
	}

	public UserNotFoundException(String[] params) {
		super(detailKey, params);
	}

}

