package com.posidex.prime.enginerequest;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"CDAP"})
public class Prime360RequestInfo {

	
	private List<Prime360CommonTable> CDAP;
	@JsonProperty("CDAP")
	public List<Prime360CommonTable> getCDAP() {
		return CDAP;
	}

	public void setCDAP(List<Prime360CommonTable> cDAP) {
		CDAP = cDAP;
	}

	@Override
	public String toString() {
		return "Prime360RequestInfo [CDAP=" + CDAP + "]";
	}

	

	

	
	
	
}
