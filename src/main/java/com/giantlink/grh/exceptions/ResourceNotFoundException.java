package com.giantlink.grh.exceptions;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String message;

	public ResourceNotFoundException(String message) {
		super(message);
		this.message = message;		
	}

}
