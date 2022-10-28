package com.example.exception;

import java.util.Map;

public class ErrorResponse {

	private String errorCode;
	private String errorDesc;
	private Map<String, String> errrors;

	public ErrorResponse() {

	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public Map<String, String> getErrrors() {
		return errrors;
	}

	public void setMaperrrors(Map<String, String> errrors) {
		this.errrors = errrors;
	}

}
