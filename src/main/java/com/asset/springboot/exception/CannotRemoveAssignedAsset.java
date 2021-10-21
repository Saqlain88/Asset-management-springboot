package com.asset.springboot.exception;

public class CannotRemoveAssignedAsset extends RuntimeException {
	
	public CannotRemoveAssignedAsset(String message) {
		super(message);
	}

}
