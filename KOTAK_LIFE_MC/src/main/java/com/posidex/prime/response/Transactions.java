package com.posidex.prime.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"transactionData"})
public class Transactions
{
	@JsonProperty("TransactionData")
    private List<TransactionData> transactionData;

	public List<TransactionData> getTransactionData() {
		return transactionData;
	}

	public void setTransactionData(List<TransactionData> transactionData) {
		this.transactionData = transactionData;
	}

	@Override
	public String toString() {
		return "Transactions [transactionData=" + transactionData + "]";
	}

  
}