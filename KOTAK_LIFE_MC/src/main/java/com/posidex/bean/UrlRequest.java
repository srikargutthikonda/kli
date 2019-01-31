package com.posidex.bean;

public class UrlRequest {
	private String lifeAssuranceId;
	private String jointLifeAssuranceId;

	private String clientId;
	private String ProposedId;
	private String psdxUser;
	private String psdxPwd;
	public String getLifeAssuranceId() {
		return lifeAssuranceId;
	}
	public void setLifeAssuranceId(String lifeAssuranceId) {
		this.lifeAssuranceId = lifeAssuranceId;
	}
	public String getJointLifeAssuranceId() {
		return jointLifeAssuranceId;
	}
	public void setJointLifeAssuranceId(String jointLifeAssuranceId) {
		this.jointLifeAssuranceId = jointLifeAssuranceId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getProposedId() {
		return ProposedId;
	}
	public void setProposedId(String proposedId) {
		ProposedId = proposedId;
	}
	public String getPsdxUser() {
		return psdxUser;
	}
	public void setPsdxUser(String psdxUser) {
		this.psdxUser = psdxUser;
	}
	public String getPsdxPwd() {
		return psdxPwd;
	}
	public void setPsdxPwd(String psdxPwd) {
		this.psdxPwd = psdxPwd;
	}
	@Override
	public String toString() {
		return "UrlRequest [lifeAssuranceId=" + lifeAssuranceId + ", jointLifeAssuranceId=" + jointLifeAssuranceId
				+ ", clientId=" + clientId + ", ProposedId=" + ProposedId + ", psdxUser=" + psdxUser + ", psdxPwd="
				+ psdxPwd + "]";
	}
	

}
