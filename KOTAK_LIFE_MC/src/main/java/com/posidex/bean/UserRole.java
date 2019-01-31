package com.posidex.bean;

public class UserRole {
	
private String	USER_ROLE;
private String	DISPLAY_NAME;
private String	USER_NAME;
private String	PWD;
private String	ROLE_ID;
private String	ROLE_DESC;
private String	ROLE_PURPOSE;
private String	STATUS;
private String	CREATED_ON;
private String	UPDATED_ON;
private String	CREATED_BY;
private String	ACTIVATED_BY;
private String	AVAILED_TYPE;
private String	UPDATED_BY;
public String getUSER_ROLE() {
	return USER_ROLE;
}
public void setUSER_ROLE(String uSER_ROLE) {
	USER_ROLE = uSER_ROLE;
}
public String getDISPLAY_NAME() {
	return DISPLAY_NAME;
}
public void setDISPLAY_NAME(String dISPLAY_NAME) {
	DISPLAY_NAME = dISPLAY_NAME;
}
public String getUSER_NAME() {
	return USER_NAME;
}
public void setUSER_NAME(String uSER_NAME) {
	USER_NAME = uSER_NAME;
}
public String getPWD() {
	return PWD;
}
public void setPWD(String pWD) {
	PWD = pWD;
}
public String getROLE_ID() {
	return ROLE_ID;
}
public void setROLE_ID(String rOLE_ID) {
	ROLE_ID = rOLE_ID;
}
public String getROLE_DESC() {
	return ROLE_DESC;
}
public void setROLE_DESC(String rOLE_DESC) {
	ROLE_DESC = rOLE_DESC;
}
public String getROLE_PURPOSE() {
	return ROLE_PURPOSE;
}
public void setROLE_PURPOSE(String rOLE_PURPOSE) {
	ROLE_PURPOSE = rOLE_PURPOSE;
}
public String getSTATUS() {
	return STATUS;
}
public void setSTATUS(String sTATUS) {
	STATUS = sTATUS;
}
public String getCREATED_ON() {
	return CREATED_ON;
}
public void setCREATED_ON(String cREATED_ON) {
	CREATED_ON = cREATED_ON;
}
public String getUPDATED_ON() {
	return UPDATED_ON;
}
public void setUPDATED_ON(String uPDATED_ON) {
	UPDATED_ON = uPDATED_ON;
}
public String getCREATED_BY() {
	return CREATED_BY;
}
public void setCREATED_BY(String cREATED_BY) {
	CREATED_BY = cREATED_BY;
}
public String getACTIVATED_BY() {
	return ACTIVATED_BY;
}
public void setACTIVATED_BY(String aCTIVATED_BY) {
	ACTIVATED_BY = aCTIVATED_BY;
}
public String getAVAILED_TYPE() {
	return AVAILED_TYPE;
}
public void setAVAILED_TYPE(String aVAILED_TYPE) {
	AVAILED_TYPE = aVAILED_TYPE;
}
public String getUPDATED_BY() {
	return UPDATED_BY;
}
public void setUPDATED_BY(String uPDATED_BY) {
	UPDATED_BY = uPDATED_BY;
}
@Override
public String toString() {
	return "UserRole [USER_ROLE=" + USER_ROLE + ", DISPLAY_NAME=" + DISPLAY_NAME + ", USER_NAME=" + USER_NAME + ", PWD="
			+ PWD + ", ROLE_ID=" + ROLE_ID + ", ROLE_DESC=" + ROLE_DESC + ", ROLE_PURPOSE=" + ROLE_PURPOSE + ", STATUS="
			+ STATUS + ", CREATED_ON=" + CREATED_ON + ", UPDATED_ON=" + UPDATED_ON + ", CREATED_BY=" + CREATED_BY
			+ ", ACTIVATED_BY=" + ACTIVATED_BY + ", AVAILED_TYPE=" + AVAILED_TYPE + ", UPDATED_BY=" + UPDATED_BY + "]";
}


}
