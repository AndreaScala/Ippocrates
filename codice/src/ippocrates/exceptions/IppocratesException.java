package ippocrates.exceptions;

import java.lang.Exception;

public class IppocratesException extends Exception {
	private String exceptionName;
	
	public IppocratesException (String s) {
		exceptionName=s;
	}
	
	public String getName() {
		return exceptionName;
	}
	
	public void setName(String s) {
		exceptionName=s;
	}
}
