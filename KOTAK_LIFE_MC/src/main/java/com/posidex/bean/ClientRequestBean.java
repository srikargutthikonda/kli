package com.posidex.bean;

import java.io.Serializable;

public class ClientRequestBean implements Serializable {
	static final long serialVersionUID = -687991492884005033L;
	
	private String POLICY_NUMBER;
	private String client_user_id;
	private String psdx_pwd;
	private String clientid;
	private String givenRole;
	
	public String getClient_user_id() {
		return client_user_id;
	}
	public void setClient_user_id(String client_user_id) {
		this.client_user_id = client_user_id;
	}
	
	public String getGivenRole() {
		return givenRole;
	}
	public void setGivenRole(String givenRole) {
		this.givenRole = givenRole;
	}
	public String getClientid() {
		return clientid;
	}
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	public String getPOLICY_NUMBER() {
		return POLICY_NUMBER;
	}
	public void setPOLICY_NUMBER(String policy_Id) {
		POLICY_NUMBER = policy_Id;
	}

	public String getPsdx_pwd() {
		return psdx_pwd;
	}
	public void setPsdx_pwd(String psdx_pwd) {
		this.psdx_pwd = psdx_pwd;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ClientRequestBean [POLICY_NUMBER=" + POLICY_NUMBER + ", client_user_id=" + client_user_id
				+ ", psdx_pwd=" + psdx_pwd + ", clientid=" + clientid + ", givenRole=" + givenRole + "]";
	}

	
}
