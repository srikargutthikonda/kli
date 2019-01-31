package com.posidex.prime.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requestInfo","requestPayload","type"})
public class Request {

	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo;

	@JsonProperty("RequestPayload")
	private RequestPayload requestPayload;

	@JsonProperty("Type")
	private String type;

	public RequestInfo getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}

	public RequestPayload getRequestPayload() {
		return requestPayload;
	}

	public void setRequestPayload(RequestPayload requestPayload) {
		this.requestPayload = requestPayload;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Request [requestInfo=" + requestInfo + ", requestPayload=" + requestPayload + ", type=" + type + "]";
	}

	
}
