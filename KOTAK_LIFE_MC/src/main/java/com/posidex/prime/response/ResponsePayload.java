package com.posidex.prime.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "statusInfo", "transactions", "type" })
public class ResponsePayload {
	@JsonProperty("StatusInfo")
	private StatusInfo statusInfo;

	@JsonProperty("Transactions")
	private List<Transactions> transactions;

	@JsonProperty("Type")
	private String type;

	public StatusInfo getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(StatusInfo statusInfo) {
		this.statusInfo = statusInfo;
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ResponsePayload [statusInfo=" + statusInfo + ", transactions=" + transactions + ", type=" + type + "]";
	}

}