package com.posidex.bean;

public class KotakUser {

	
private String	ACTIVE;
private String	APPROVAL_REJECTED;
private String	CREATIONAL_PASSWORD;
private String	EMAIL_ID;
private String	JOINING_DATE;
private String	LCHGTIME;
private String	PASSWORD;
private String	ROLE;
private String	ROLE_ID;
private String	USER_ID;
private String	USER_NAME;
@Override
public String toString() {
	return "KotakUser [ACTIVE=" + ACTIVE + ", APPROVAL_REJECTED=" + APPROVAL_REJECTED + ", CREATIONAL_PASSWORD="
			+ CREATIONAL_PASSWORD + ", EMAIL_ID=" + EMAIL_ID + ", JOINING_DATE=" + JOINING_DATE + ", LCHGTIME="
			+ LCHGTIME + ", PASSWORD=" + PASSWORD + ", ROLE=" + ROLE + ", ROLE_ID=" + ROLE_ID + ", USER_ID=" + USER_ID
			+ ", USER_NAME=" + USER_NAME + "]";
}
public String getACTIVE() {
	return ACTIVE;
}
public void setACTIVE(String aCTIVE) {
	ACTIVE = aCTIVE;
}
public String getAPPROVAL_REJECTED() {
	return APPROVAL_REJECTED;
}
public void setAPPROVAL_REJECTED(String aPPROVAL_REJECTED) {
	APPROVAL_REJECTED = aPPROVAL_REJECTED;
}
public String getCREATIONAL_PASSWORD() {
	return CREATIONAL_PASSWORD;
}
public void setCREATIONAL_PASSWORD(String cREATIONAL_PASSWORD) {
	CREATIONAL_PASSWORD = cREATIONAL_PASSWORD;
}
public String getEMAIL_ID() {
	return EMAIL_ID;
}
public void setEMAIL_ID(String eMAIL_ID) {
	EMAIL_ID = eMAIL_ID;
}
public String getJOINING_DATE() {
	return JOINING_DATE;
}
public void setJOINING_DATE(String jOINING_DATE) {
	JOINING_DATE = jOINING_DATE;
}
public String getLCHGTIME() {
	return LCHGTIME;
}
public void setLCHGTIME(String lCHGTIME) {
	LCHGTIME = lCHGTIME;
}
public String getPASSWORD() {
	return PASSWORD;
}
public void setPASSWORD(String pASSWORD) {
	PASSWORD = pASSWORD;
}
public String getROLE() {
	return ROLE;
}
public void setROLE(String rOLE) {
	ROLE = rOLE;
}
public String getROLE_ID() {
	return ROLE_ID;
}
public void setROLE_ID(String rOLE_ID) {
	ROLE_ID = rOLE_ID;
}
public String getUSER_ID() {
	return USER_ID;
}
public void setUSER_ID(String uSER_ID) {
	USER_ID = uSER_ID;
}
public String getUSER_NAME() {
	return USER_NAME;
}
public void setUSER_NAME(String uSER_NAME) {
	USER_NAME = uSER_NAME;
}
}
