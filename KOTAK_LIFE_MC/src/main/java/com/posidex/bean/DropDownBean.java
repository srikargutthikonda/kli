package com.posidex.bean;

public class DropDownBean {
private String	PROPOSED_ID;
private String	LIFEASSURED_ID;
private String	JOINT_LIFEASSURED_ID;
private String CLIENT_ID;
public String getCLIENT_ID() {
	return CLIENT_ID;
}
public void setCLIENT_ID(String cLIENT_ID) {
	CLIENT_ID = cLIENT_ID;
}
private String	PROPOSAL_NUMBER;
public String getPROPOSED_ID() {
	return PROPOSED_ID;
}
public void setPROPOSED_ID(String pROPOSED_ID) {
	PROPOSED_ID = pROPOSED_ID;
}
public String getLIFEASSURED_ID() {
	return LIFEASSURED_ID;
}
public void setLIFEASSURED_ID(String lIFEASSURED_ID) {
	LIFEASSURED_ID = lIFEASSURED_ID;
}
public String getJOINT_LIFEASSURED_ID() {
	return JOINT_LIFEASSURED_ID;
}
public void setJOINT_LIFEASSURED_ID(String jOINT_LIFEASSURED_ID) {
	JOINT_LIFEASSURED_ID = jOINT_LIFEASSURED_ID;
}


public String getPROPOSAL_NUMBER() {
	return PROPOSAL_NUMBER;
}
public void setPROPOSAL_NUMBER(String pROPOSAL_NUMBER) {
	PROPOSAL_NUMBER = pROPOSAL_NUMBER;
}
@Override
public String toString() {
	return "DropDownBean [PROPOSED_ID=" + PROPOSED_ID + ", LIFEASSURED_ID=" + LIFEASSURED_ID + ", JOINT_LIFEASSURED_ID="
			+ JOINT_LIFEASSURED_ID + ", CLIENT_ID=" + CLIENT_ID + ", PROPOSAL_NUMBER=" + PROPOSAL_NUMBER + "]";
}


}
