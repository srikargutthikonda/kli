package com.posidex.bean;

import java.io.Serializable;
import java.util.List;

public class LifeAsiaSucessAndErrorResponses implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 11234987L;
	private List<LifeAsiaResponseMessageBean> mergeSuccessResponseList;
	private List<LifeAsiaResponseMessageBean> mergeErrorResponseList;
	private String requestId;
	private String userId;
	private String crmsClientNum;
	
	public String getCrmsClientNum() {
		return crmsClientNum;
	}
	public void setCrmsClientNum(String crmsClientNum) {
		this.crmsClientNum = crmsClientNum;
	}
	public List<LifeAsiaResponseMessageBean> getMergeSuccessResponseList() {
		return mergeSuccessResponseList;
	}
	public void setMergeSuccessResponseList(List<LifeAsiaResponseMessageBean> mergeSuccessResponseList) {
		this.mergeSuccessResponseList = mergeSuccessResponseList;
	}
	public List<LifeAsiaResponseMessageBean> getMergeErrorResponseList() {
		return mergeErrorResponseList;
	}
	public void setMergeErrorResponseList(List<LifeAsiaResponseMessageBean> mergeErrorResponseList) {
		this.mergeErrorResponseList = mergeErrorResponseList;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
