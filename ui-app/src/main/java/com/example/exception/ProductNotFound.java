package com.example.exception;

public class ProductNotFound extends RuntimeException {

	private String message;

	public ProductNotFound() {

	}

	public ProductNotFound(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
	
}
