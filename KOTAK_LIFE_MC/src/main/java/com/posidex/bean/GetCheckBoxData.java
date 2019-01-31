package com.posidex.bean;

public class GetCheckBoxData {
	
	/* jsonData
         "crmsclientid": $td[1].innerHTML,
         "matchreason": $td[2].innerHTML,
         "matchcount": $td[3].innerHTML,
         "scaletype": $td[4].innerHTML,
         "name": $td[5].innerHTML,
         "dob": $td[6].innerHTML,
         "gender": $td[7].innerHTML,
         "p_address": $td[8].innerHTML,
         "o_address": $td[9].innerHTML,
         "r_address": $td[10].innerHTML,
         "o_phone": $td[11].innerHTML,
         "taxid": $td[12].innerHTML,
         "taxid": $td[13].innerHTML
    */
	
	
	private String crmsclientid;
	private String requestid;
	public String getRequestid() {
		return requestid;
	}
	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}
	private String matchreason;
	private String matchcount;
	private String scaletype;
	private String name;
	private String dob;
	private String gender;
	private String p_address;
	private String o_address;
	private String r_address;
	private String o_phone;
	private String taxid;
	private String aadhaar;
	private String retain_clientid;
	private String retain_requestid;
	private String source_clientid;
	private String psx_id;
	
	
	public String getPsx_id() {
		return psx_id;
	}
	public void setPsx_id(String psx_id) {
		this.psx_id = psx_id;
	}
	public String getSource_clientid() {
		return source_clientid;
	}
	public void setSource_clientid(String source_clientid) {
		this.source_clientid = source_clientid;
	}
	public String getRetain_clientid() {
		return retain_clientid;
	}
	public void setRetain_clientid(String retain_clientid) {
		this.retain_clientid = retain_clientid;
	}
	public String getRetain_requestid() {
		return retain_requestid;
	}
	public void setRetain_requestid(String retain_requestid) {
		this.retain_requestid = retain_requestid;
	}
	@Override
	public String toString() {
		return "GetCheckBoxData [crmsclientid=" + crmsclientid + ", requestid=" + requestid + ", matchreason="
				+ matchreason + ", matchcount=" + matchcount + ", scaletype=" + scaletype + ", name=" + name + ", dob="
				+ dob + ", gender=" + gender + ", p_address=" + p_address + ", o_address=" + o_address + ", r_address="
				+ r_address + ", o_phone=" + o_phone + ", taxid=" + taxid + ", aadhaar=" + aadhaar
				+ ", retain_clientid=" + retain_clientid + ", retain_requestid=" + retain_requestid
				+ ", source_clientid=" + source_clientid + ", psx_id=" + psx_id + "]";
	}
	public String getCrmsclientid() {
		return crmsclientid;
	}
	public void setCrmsclientid(String crmsclientid) {
		this.crmsclientid = crmsclientid;
	}
	public String getMatchreason() {
		return matchreason;
	}
	public void setMatchreason(String matchreason) {
		this.matchreason = matchreason;
	}
	public String getMatchcount() {
		return matchcount;
	}
	public void setMatchcount(String matchcount) {
		this.matchcount = matchcount;
	}
	public String getScaletype() {
		return scaletype;
	}
	public void setScaletype(String scaletype) {
		this.scaletype = scaletype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getP_address() {
		return p_address;
	}
	public void setP_address(String p_address) {
		this.p_address = p_address;
	}
	public String getO_address() {
		return o_address;
	}
	public void setO_address(String o_address) {
		this.o_address = o_address;
	}
	public String getR_address() {
		return r_address;
	}
	public void setR_address(String r_address) {
		this.r_address = r_address;
	}
	public String getO_phone() {
		return o_phone;
	}
	public void setO_phone(String o_phone) {
		this.o_phone = o_phone;
	}
	public String getTaxid() {
		return taxid;
	}
	public void setTaxid(String taxid) {
		this.taxid = taxid;
	}
	public String getAadhaar() {
		return aadhaar;
	}
	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}
	

}
