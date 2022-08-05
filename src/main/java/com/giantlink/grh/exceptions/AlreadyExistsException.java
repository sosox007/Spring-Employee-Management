package com.giantlink.grh.exceptions;

import lombok.Getter;

@Getter
public class AlreadyExistsException extends Exception{

	private static final long serialVersionUID = 1L;


	private String object;
	private String message;

	public AlreadyExistsException(String object, String message) {
		super(message);
		this.object = object;
		this.message = message;
	}

}

