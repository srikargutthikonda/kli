package com.posidex.prime.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "response" })
public class FinalResponse {
	@JsonProperty("responselist")
	private List<ProcessRsponse> responseList;

	public List<ProcessRsponse> getResponseList() {
		return responseList;
	}

	public void setResponseList(List<ProcessRsponse> responseList) {
		this.responseList = responseList;
	}

	@Override
	public String toString() {
		return "FinalResponse [responseList=" + responseList + "]";
	}
	
	
	
}
