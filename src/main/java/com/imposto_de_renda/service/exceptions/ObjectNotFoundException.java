package com.imposto_de_renda.service.exceptions;

public class ObjectNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String message) 
	{
		super(message);
	}
}
