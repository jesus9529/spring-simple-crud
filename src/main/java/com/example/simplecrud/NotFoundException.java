package com.example.simplecrud;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String detail) {
		super(detail);
	}
}
