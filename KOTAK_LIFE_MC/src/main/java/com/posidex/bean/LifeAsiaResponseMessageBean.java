package com.posidex.bean;

public class LifeAsiaResponseMessageBean {
private String policyNumber;
private String mergeClientNumber;
private String retainedClientNumber;
private String flag;
private String errorCode;
private String errorDescription;
public String getPolicyNumber() {
	return policyNumber;
}
public void setPolicyNumber(String policyNumber) {
	this.policyNumber = policyNumber;
}
public String getMergeClientNumber() {
	return mergeClientNumber;
}
public void setMergeClientNumber(String mergeClientNumber) {
	this.mergeClientNumber = mergeClientNumber;
}
public String getRetainedClientNumber() {
	return retainedClientNumber;
}
public void setRetainedClientNumber(String retainedClientNumber) {
	this.retainedClientNumber = retainedClientNumber;
}
public String getFlag() {
	return flag;
}
public void setFlag(String flag) {
	this.flag = flag;
}
public String getErrorCode() {
	return errorCode;
}
public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}
public String getErrorDescription() {
	return errorDescription;
}
public void setErrorDescription(String errorDescription) {
	this.errorDescription = errorDescription;
}
@Override
public String toString() {
	return "LifeAsiaResponseMessageBean [policyNumber=" + policyNumber + ", mergeClientNumber=" + mergeClientNumber
			+ ", retainedClientNumber=" + retainedClientNumber + ", flag=" + flag + ", errorCode=" + errorCode
			+ ", errorDescription=" + errorDescription + "]";
}




}
