package com.posidex.prime.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"clientDetails"})
public class TransactionData {
	@JsonProperty("ClientDetails")
	private List<ClientDetails> clientDetails;

	public List<ClientDetails> getClientDetails() {
		return clientDetails;
	}

	public void setClientDetails(List<ClientDetails> clientDetails) {
		this.clientDetails = clientDetails;
	}

	@Override
	public String toString() {
		return "TransactionData [clientDetails=" + clientDetails + "]";
	}

}
