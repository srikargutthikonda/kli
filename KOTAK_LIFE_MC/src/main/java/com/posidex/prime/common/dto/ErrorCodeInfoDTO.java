package com.posidex.prime.common.dto;

import java.io.Serializable;

public class ErrorCodeInfoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorCode;

	private String errorDesc;

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

	@Override
	public String toString() {
		return "ErrorCodeInfoDTO [errorCode=" + errorCode + ", errorDesc=" + errorDesc + "]";
	}

}
