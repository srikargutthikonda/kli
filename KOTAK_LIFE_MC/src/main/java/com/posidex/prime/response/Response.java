package com.posidex.prime.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"responseInfo","responsePayload"})
public class Response
{
	@JsonProperty("ResponseInfo")
	private ResponseInfo responseInfo;

	@JsonProperty("ResponsePayload")
    private ResponsePayload responsePayload;

	public ResponseInfo getResponseInfo() {
		return responseInfo;
	}

	public void setResponseInfo(ResponseInfo responseInfo) {
		this.responseInfo = responseInfo;
	}

	public ResponsePayload getResponsePayload() {
		return responsePayload;
	}

	public void setResponsePayload(ResponsePayload responsePayload) {
		this.responsePayload = responsePayload;
	}

	@Override
	public String toString() {
		return "Response [responseInfo=" + responseInfo + ", responsePayload=" + responsePayload + "]";
	}

    
}