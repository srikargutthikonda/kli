package com.posidex.prime.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("transactionData")
public class Transactions {

	@JsonProperty("TransactionData")
	private TransactionData transactionData;

	public TransactionData getTransactionData() {
		return transactionData;
	}

	public void setTransactionData(TransactionData transactionData) {
		this.transactionData = transactionData;
	}

	@Override
	public String toString() {
		return "Transactions [transactionData=" + transactionData + "]";
	}

}
