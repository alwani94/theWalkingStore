package com.alwani.enterprise.theWalkingStore.ExceptionHandling;

public class ErrorMessage {

	String errorCode;
	
	String errorMessage;
	
	String returnCode;

	public ErrorMessage(String errorCode, String errorMessage, String returnCode) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.returnCode = returnCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	
	
}
