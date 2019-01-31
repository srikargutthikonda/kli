package com.posidex.prime.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.posidex.prime.common.entity.Address;
import com.posidex.prime.common.entity.Contact;
import com.posidex.prime.common.entity.Email;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "clientID", "matchReason", "matchCategory", "source", "subSource", "firstName", "middleName",
		"lastName", "motherName", "fatherName", "dob", "pan", "gender", "passportNo", "voterId", "aadhaar",
		"drivingLicence", "rationCardNo", "searchID", "address", "contact", "email" })
public class ClientDetails {

	@JsonProperty("ClientID")
	private String clientID;

	@JsonProperty("MatchReason")
	private String matchReason;

	@JsonProperty("MatchCategory")
	private String matchCategory;

	@JsonProperty("Source")
	private String source;

	@JsonProperty("SubSource")
	private String subSource;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("MotherName")
	private String motherName;

	@JsonProperty("FatherName")
	private String fatherName;

	@JsonProperty("DOB")
	private String dob;

	@JsonProperty("PAN")
	private String pan;

	@JsonProperty("Gender")
	private String gender;

	// private String DeDupeRules;

	@JsonProperty("PassportNo")
	private String passportNo;

	@JsonProperty("VoterId")
	private String voterId;

	@JsonProperty("Aadhaar")
	private String aadhaar;

	@JsonProperty("DrivingLicence")
	private String drivingLicence;

	@JsonProperty("RationCardNo")
	private String rationCardNo;

	@JsonProperty("SearchID")
	private String searchID;

	@JsonProperty("Address")
	private List<Address> address;

	@JsonProperty("Contact")
	private List<Contact> contact;

	@JsonProperty("Email")
	private List<Email> email;

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getMatchReason() {
		return matchReason;
	}

	public void setMatchReason(String matchReason) {
		this.matchReason = matchReason;
	}

	public String getMatchCategory() {
		return matchCategory;
	}

	public void setMatchCategory(String matchCategory) {
		this.matchCategory = matchCategory;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSubSource() {
		return subSource;
	}

	public void setSubSource(String subSource) {
		this.subSource = subSource;
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

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSearchID() {
		return searchID;
	}

	public void setSearchID(String searchID) {
		this.searchID = searchID;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}

	public List<Email> getEmail() {
		return email;
	}

	public void setEmail(List<Email> email) {
		this.email = email;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public String getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}

	public String getDrivingLicence() {
		return drivingLicence;
	}

	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}

	public String getRationCardNo() {
		return rationCardNo;
	}

	public void setRationCardNo(String rationCardNo) {
		this.rationCardNo = rationCardNo;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@Override
	public String toString() {
		return "ClientDetails [clientID=" + clientID + ", matchReason=" + matchReason + ", matchCategory="
				+ matchCategory + ", source=" + source + ", subSource=" + subSource + ", name=" + name + ", motherName="
				+ motherName + ", fatherName=" + fatherName + ", dob=" + dob + ", pan=" + pan + ", gender=" + gender
				+ ", passportNo=" + passportNo + ", voterId=" + voterId + ", aadhaar=" + aadhaar + ", drivingLicence="
				+ drivingLicence + ", rationCardNo=" + rationCardNo + ", searchID=" + searchID + ", address=" + address
				+ ", contact=" + contact + ", email=" + email + "]";
	}
	
}
