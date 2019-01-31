/**
 * 
 */
package com.posidex.prime.common.dto;


/**
 * 
 */


import java.io.Serializable;

public class MRProfileInfoDTO implements Serializable
{

	private static final long	serialVersionUID	= 7540253771177309201L;

	private String				profileId;
	private String				matchingRuleCSV;
	private String				scaleTypeEquations;
	private String				rankingCsv;
	private String				residualParameters;
	private String				weightagesCsv;
	
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public String getMatchingRuleCSV() {
		return matchingRuleCSV;
	}
	public void setMatchingRuleCSV(String matchingRuleCSV) {
		this.matchingRuleCSV = matchingRuleCSV;
	}
	public String getScaleTypeEquations() {
		return scaleTypeEquations;
	}
	public void setScaleTypeEquations(String scaleTypeEquations) {
		this.scaleTypeEquations = scaleTypeEquations;
	}
	public String getRankingCsv() {
		return rankingCsv;
	}
	public void setRankingCsv(String rankingCsv) {
		this.rankingCsv = rankingCsv;
	}
	public String getResidualParameters() {
		return residualParameters;
	}
	public void setResidualParameters(String residualParameters) {
		this.residualParameters = residualParameters;
	}
	public String getWeightagesCsv() {
		return weightagesCsv;
	}
	public void setWeightagesCsv(String weightagesCsv) {
		this.weightagesCsv = weightagesCsv;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "MRProfileInfoDTO [profileId=" + profileId + ", matchingRuleCSV=" + matchingRuleCSV
				+ ", scaleTypeEquations=" + scaleTypeEquations + ", rankingCsv=" + rankingCsv + ", residualParameters="
				+ residualParameters + ", weightagesCsv=" + weightagesCsv + "]";
	}
	
	
}