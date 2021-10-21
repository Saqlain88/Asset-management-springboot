package com.asset.springboot.exception;

public class AlreadyAssignedException extends RuntimeException {

	public AlreadyAssignedException(String message){
		super(message);
	}
}
