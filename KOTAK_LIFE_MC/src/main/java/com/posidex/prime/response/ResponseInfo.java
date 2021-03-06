package com.posidex.prime.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "creationDate", "creationTime", 
"requestorToken", "sourceInfoName", "transactionId", 
"userName", "device_uuid", "lastSyncDate", "userEmail"})
public class ResponseInfo {
	
	@JsonProperty("CreationDate")
	private String creationDate;

	@JsonProperty("CreationTime")
	private String creationTime;

	@JsonProperty("RequestorToken")
	private String requestorToken;

	@JsonProperty("SourceInfoName")
	private String sourceInfoName;

	@JsonProperty("TransactionId")
	private String transactionId;

	@JsonProperty("UserName")
	private String userName;

	@JsonProperty("device_uuid")
	private String device_uuid;

	@JsonProperty("lastSyncDate")
	private String lastSyncDate;

	@JsonProperty("userEmail")
	private String userEmail;

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getRequestorToken() {
		return requestorToken;
	}

	public void setRequestorToken(String requestorToken) {
		this.requestorToken = requestorToken;
	}

	public String getSourceInfoName() {
		return sourceInfoName;
	}

	public void setSourceInfoName(String sourceInfoName) {
		this.sourceInfoName = sourceInfoName;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDevice_uuid() {
		return device_uuid;
	}

	public void setDevice_uuid(String device_uuid) {
		this.device_uuid = device_uuid;
	}

	public String getLastSyncDate() {
		return lastSyncDate;
	}

	public void setLastSyncDate(String lastSyncDate) {
		this.lastSyncDate = lastSyncDate;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "ResponseInfo [creationDate=" + creationDate + ", creationTime=" + creationTime + ", requestorToken="
				+ requestorToken + ", sourceInfoName=" + sourceInfoName + ", transactionId=" + transactionId
				+ ", userName=" + userName + ", device_uuid=" + device_uuid + ", lastSyncDate=" + lastSyncDate
				+ ", userEmail=" + userEmail + "]";
	}

}
