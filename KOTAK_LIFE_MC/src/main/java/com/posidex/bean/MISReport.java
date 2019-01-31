package com.posidex.bean;

public class MISReport {

	private String policy_number;
	private String customer_id;
	private String status;
	
	
	
	public String getPolicy_number() {
		return policy_number;
	}



	public void setPolicy_number(String policy_number) {
		this.policy_number = policy_number;
	}



	public String getCustomer_id() {
		return customer_id;
	}



	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "MISReport [policy_number=" + policy_number + ", customer_id=" + customer_id + ", status=" + status
				+ "]";
	}
	
}
