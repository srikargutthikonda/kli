package com.posidex.prime.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.posidex.prime.common.entity.Address;
import com.posidex.prime.common.entity.Contact;
import com.posidex.prime.common.entity.Email;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requestNo", "profileID", "clientID", "FeedSysID", "firstName", "middleName", "lastName","motherName",
		"fatherName", "dob", "gender", "pan", "passportNo", "voterId", "aadhaar", "drivingLicence","rationCardNo", "ir", "address",
		"contact", "email" })
public class TransactionData {

	@JsonProperty("RequestNo")
	private String requestNo;

	@JsonProperty("ProfileID")
	private String profileID;

     @JsonProperty("ClientID")
     private String clientID;

    @JsonProperty("FeedSysID")
    private String feedSysID;

	@JsonProperty("FirstName")
	private String firstName;

	@JsonProperty("MiddleName")
	private String middleName;

	@JsonProperty("LastName")
	private String lastName;

	@JsonProperty("MotherName")
	private String motherName;

	@JsonProperty("FatherName")
	private String fatherName;

	@JsonProperty("DOB")
	private String dob;

	@JsonProperty("Gender")
	private String gender;

	@JsonProperty("Pan")
	private String pan;

	@JsonProperty("PassportNo")
	private String passportNo;

	//@XmlElement(name="VoterId")
	@JsonProperty("VoterId")
	private String voterId;

	@JsonProperty("Aadhaar")
	private String aadhaar;

	@JsonProperty("DrivingLicence")
	private String drivingLicence;

	@JsonProperty("RationCardNo")
	private String rationCardNo;

	@JsonProperty("IR")
	private String ir;

	@JsonProperty("Address")
	private List<Address> address;

	@JsonProperty("Contact")
	private List<Contact> contact;

	@JsonProperty("Email")
	private List<Email> email;

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getProfileID() {
		return profileID;
	}

	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
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

	public String getIr() {
		return ir;
	}

	public void setIr(String ir) {
		this.ir = ir;
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

	public String getFeedSysID() {
		return feedSysID;
	}

	public void setFeedSysID(String feedSysID) {
		this.feedSysID = feedSysID;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
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
		return "TransactionData [requestNo=" + requestNo + ", profileID=" + profileID + ", clientID=" + clientID
				+ ", feedSysID=" + feedSysID + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", motherName=" + motherName + ", fatherName=" + fatherName + ", dob=" + dob + ", gender="
				+ gender + ", pan=" + pan + ", passportNo=" + passportNo + ", voterId=" + voterId + ", aadhaar="
				+ aadhaar + ", drivingLicence=" + drivingLicence + ", rationCardNo=" + rationCardNo + ", ir=" + ir
				+ ", address=" + address + ", contact=" + contact + ", email=" + email + "]";
	}

	
}
