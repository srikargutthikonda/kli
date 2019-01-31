package com.posidex.prime.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requestID", "psxRequestID","matchCount", "status", "statusCode", "statusMessage" })
public class StatusInfo {
	@JsonProperty("RequestID")
	private String requestID;
	
	@JsonProperty("psxRequestID")
	private String psxRequestID;

	@JsonProperty("MatchCount")
	private String matchCount;

	@JsonProperty("Status")
	private String status;

	@JsonProperty("StatusCode")
	private String statusCode;

	@JsonProperty("StatusMessage")
	private String statusMessage;

	public String getRequestID() {
		return requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}

	
	public String getPsxRequestID() {
		return psxRequestID;
	}

	public void setPsxRequestID(String psxRequestID) {
		this.psxRequestID = psxRequestID;
	}

	public String getMatchCount() {
		return matchCount;
	}

	public void setMatchCount(String matchCount) {
		this.matchCount = matchCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	@Override
	public String toString() {
		return "StatusInfo [requestID=" + requestID + ", psxRequestID=" + psxRequestID + ", matchCount=" + matchCount
				+ ", status=" + status + ", statusCode=" + statusCode + ", statusMessage=" + statusMessage + "]";
	}

}
