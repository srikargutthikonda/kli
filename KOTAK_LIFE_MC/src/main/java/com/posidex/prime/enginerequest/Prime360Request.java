package com.posidex.prime.enginerequest;


import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"requestID","requestInformation","matchingRule","scaleEquations","weightages",
	"residualParams","rankingOrders","processType","paramMap","requestStatus","sourceSystemName"})
public class Prime360Request {
	
	@JsonProperty("requestID")
	private String requestID;
	
	@JsonProperty("requestInformation")
	private Prime360RequestInfo requestInformation;
	
	@JsonProperty("matchingRules")
	private String matchingRule;
	
	@JsonProperty("scaleEquations")
	private String scaleEquations;	
	
	@JsonProperty("weightages")
	private String weightages;
	
	@JsonProperty("residualParams")
	private String residualParams;
	
	@JsonProperty("rankingOrders")
	private String rankingOrders;
	
	
	@JsonProperty("processType")
	private String processType;
	
	@JsonProperty("paramMap")
	private Map<String,String> paramMap;
	
	@JsonProperty("requestStatus")
	private String requestStatus;
	
	@JsonProperty("sourceSystemName")
	private String sourceSystemName;

	public String getRequestID() {
		return requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}

	public Prime360RequestInfo getRequestInformation() {
		return requestInformation;
	}

	public void setRequestInformation(Prime360RequestInfo requestInformation) {
		this.requestInformation = requestInformation;
	}

	public String getMatchingRule() {
		return matchingRule;
	}

	public void setMatchingRule(String matchingRule) {
		this.matchingRule = matchingRule;
	}

	public String getScaleEquations() {
		return scaleEquations;
	}

	public void setScaleEquations(String scaleEquations) {
		this.scaleEquations = scaleEquations;
	}

	public String getWeightages() {
		return weightages;
	}

	public void setWeightages(String weightages) {
		this.weightages = weightages;
	}

	public String getResidualParams() {
		return residualParams;
	}

	public void setResidualParams(String residualParams) {
		this.residualParams = residualParams;
	}

	public String getRankingOrders() {
		return rankingOrders;
	}

	public void setRankingOrders(String rankingOrders) {
		this.rankingOrders = rankingOrders;
	}

	public String getProcessType() {
		return processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}

	public Map<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getSourceSystemName() {
		return sourceSystemName;
	}

	public void setSourceSystemName(String sourceSystemName) {
		this.sourceSystemName = sourceSystemName;
	}

	@Override
	public String toString() {
		return "Prime360Request [requestID=" + requestID + ", requestInformation=" + requestInformation
				+ ", matchingRule=" + matchingRule + ", scaleEquations=" + scaleEquations + ", weightages=" + weightages
				+ ", residualParams=" + residualParams + ", rankingOrders=" + rankingOrders + ", processType="
				+ processType + ", paramMap=" + paramMap + ", requestStatus=" + requestStatus + ", sourceSystemName="
				+ sourceSystemName + "]";
	}

}