package com.posidex.prime.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Prime360Response {
	
	    private String sourceSystemName;

	    private String requestID;

	    private String processType;

	    private String requestStatus;

	    private List<Prime360Results> results;

	    private Prime360ParamMap paramMap;

		public String getSourceSystemName() {
			return sourceSystemName;
		}

		public void setSourceSystemName(String sourceSystemName) {
			this.sourceSystemName = sourceSystemName;
		}

		public String getRequestID() {
			return requestID;
		}

		public void setRequestID(String requestID) {
			this.requestID = requestID;
		}

		public String getProcessType() {
			return processType;
		}

		public void setProcessType(String processType) {
			this.processType = processType;
		}

		public String getRequestStatus() {
			return requestStatus;
		}

		public void setRequestStatus(String requestStatus) {
			this.requestStatus = requestStatus;
		}

		

		public List<Prime360Results> getResults() {
			return results;
		}

		public void setResults(List<Prime360Results> results) {
			this.results = results;
		}

		public Prime360ParamMap getParamMap() {
			return paramMap;
		}

		public void setParamMap(Prime360ParamMap paramMap) {
			this.paramMap = paramMap;
		}

		@Override
		public String toString() {
			return "Prime360Response [sourceSystemName=" + sourceSystemName + ", requestID=" + requestID
					+ ", processType=" + processType + ", requestStatus=" + requestStatus + ", results=" + results
					+ ", paramMap=" + paramMap + "]";
		}

		

}

