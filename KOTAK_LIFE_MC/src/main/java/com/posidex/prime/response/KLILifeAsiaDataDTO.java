package com.posidex.prime.response;

import java.io.Serializable;

public class KLILifeAsiaDataDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6974684593071674663L;
	private String source;
	private String destination;
	private String transactionDt;
	private String transactionType;
	private String action;
	private String policyNo;
	private String mergeClientNo;
	private String retainedClientNo;
	private String sourceClientNo;
	private String resMergeclientNo;
	private String resPolicyNo;
	private String mergeStatus;
	private String clientMergeId;
	private String errorcode;
	private String errorDescription;
	private String flag;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTransactionDt() {
		return transactionDt;
	}
	public void setTransactionDt(String transactionDt) {
		this.transactionDt = transactionDt;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getMergeClientNo() {
		return mergeClientNo;
	}
	public void setMergeClientNo(String mergeClientNo) {
		this.mergeClientNo = mergeClientNo;
	}
	public String getRetainedClientNo() {
		return retainedClientNo;
	}
	public void setRetainedClientNo(String retainedClientNo) {
		this.retainedClientNo = retainedClientNo;
	}
	public String getSourceClientNo() {
		return sourceClientNo;
	}
	public void setSourceClientNo(String sourceClientNo) {
		this.sourceClientNo = sourceClientNo;
	}
	public String getResMergeclientNo() {
		return resMergeclientNo;
	}
	public void setResMergeclientNo(String resMergeclientNo) {
		this.resMergeclientNo = resMergeclientNo;
	}
	public String getResPolicyNo() {
		return resPolicyNo;
	}
	public void setResPolicyNo(String resPolicyNo) {
		this.resPolicyNo = resPolicyNo;
	}
	public String getMergeStatus() {
		return mergeStatus;
	}
	public void setMergeStatus(String mergeStatus) {
		this.mergeStatus = mergeStatus;
	}
	public String getClientMergeId() {
		return clientMergeId;
	}
	public void setClientMergeId(String clientMergeId) {
		this.clientMergeId = clientMergeId;
	}
	
	
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "KLILifeAsiaDataDTO [source=" + source + ", destination=" + destination + ", transactionDt="
				+ transactionDt + ", transactionType=" + transactionType + ", action=" + action + ", policyNo="
				+ policyNo + ", mergeClientNo=" + mergeClientNo + ", retainedClientNo=" + retainedClientNo
				+ ", sourceClientNo=" + sourceClientNo + ", resMergeclientNo=" + resMergeclientNo + ", resPolicyNo="
				+ resPolicyNo + ", mergeStatus=" + mergeStatus + ", clientMergeId=" + clientMergeId + ", errorcode="
				+ errorcode + ", errorDescription=" + errorDescription + ", flag=" + flag + "]";
	}
	
	
	
	
}
