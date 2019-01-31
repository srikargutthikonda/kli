package com.posidex.prime.enginerequest;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"psxId","name","motherName","fatherName","dob","gender","pan","passport"
	,"voterId","aadhaar","drivingLic","rationcardNo"
	,"officeAddress","permenantAddress","residenceAddress","temporaryAddress"
	,"officeCity","permenantCity","residenceCity","temporaryCity"
	,"officeState","permenantState","residenceState","temporaryState"
	,"officeCountry","permenantCountry","residenceCountry","temporaryCountry"
	,"officePincode","permenantPincode","residencePincode","temporaryPincode"
	,"officeContact","permenantContact","residenceContact","temporaryContact"
	,"officeEmail","permenantEmail","residenceEmail","temporaryEmail"
	})
public class Prime360CommonTable {
	
	
	@SerializedName("PSX_ID")
    private String psxId;
	@SerializedName("NAME")
	private String name;
	@SerializedName("MOTHER_NAME")
    private String motherName;
	@SerializedName("FATHER_NAME")
    private String fatherName;
	@SerializedName("DOB1")
    private String dob;
	@SerializedName("GENDER")
    private String gender;
	@SerializedName("PAN")
    private String pan;
	@SerializedName("PASSPORT")
    private String passport;
	@SerializedName("VOTERID")
    private String voterId;
	@SerializedName("AADHAAR")
    private String aadhaar;
	@SerializedName("DRIVINGLIC")
    private String drivingLic;
	@SerializedName("RATIONCARD_NO")
    private String rationcardNo;
	@SerializedName("OFFICE_ADDRESS")
    private String officeAddress;
	@SerializedName("PERMANENT_ADDRESS")
	private String permenantAddress;
	@SerializedName("RESIDENCE_ADDRESS")
	private String residenceAddress;
	@SerializedName("TEMPORARY_ADDRESS")
	private String temporaryAddress;
	@SerializedName("OFFICE_CITY")
    private String officeCity;
	@SerializedName("PERMANENT_CITY")
	private String permenantCity;
	@SerializedName("RESIDENCE_CITY")
	private String residenceCity;
	@SerializedName("TEMPORARY_CITY")
	private String temporaryCity;
	@SerializedName("OFFICE_STATE")
    private String officeState;
	@SerializedName("PERMANENT_STATE")
	private String permenantState;
	@SerializedName("RESIDENCE_STATE")
	private String residenceState;
	@SerializedName("TEMPORARY_STATE")
	private String temporaryState;
	@SerializedName("OFFICE_COUNTRY")
    private String officeCountry;
	@SerializedName("PERMANENT_COUNTRY")
	private String permenantCountry;
	@SerializedName("RESIDENCE_COUNTRY")
	private String residenceCountry;
	@SerializedName("TEMPORARY_COUNTRY")
	private String temporaryCountry;
	@SerializedName("OFFICE_PIN")
    private String officePincode;
	@SerializedName("PERMANENT_PIN")
	private String permenantPincode;
	@SerializedName("RESIDENCE_PIN")
	private String residencePincode;
	@SerializedName("TEMPORARY_PIN")
	private String temporaryPincode;
	@SerializedName("OFFICE_CONTACT")
    private String officeContact;
	@SerializedName("PERMANENT_CONTACT")
	private String permenantContact;
	@SerializedName("RESIDENCE_CONTACT")
	private String residenceContact;
	@SerializedName("TEMPORARY_CONTACT")
	private String temporaryContact;
	@SerializedName("OFFICE_EMAIL")
    private String officeEmail;
	@SerializedName("PERMANENT_EMAIL")
    private String permenantEmail;
	@SerializedName("RESIDENCE_EMAIL")
    private String residenceEmail;
	@SerializedName("TEMPORARY_EMAIL")
    private String temporaryEmail;
	
	public String getPsxId() {
		return psxId;
	}
	public void setPsxId(String psxId) {
		this.psxId = psxId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
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
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
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
	public String getDrivingLic() {
		return drivingLic;
	}
	public void setDrivingLic(String drivingLic) {
		this.drivingLic = drivingLic;
	}
	public String getRationcardNo() {
		return rationcardNo;
	}
	public void setRationcardNo(String rationcardNo) {
		this.rationcardNo = rationcardNo;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getPermenantAddress() {
		return permenantAddress;
	}
	public void setPermenantAddress(String permenantAddress) {
		this.permenantAddress = permenantAddress;
	}
	public String getResidenceAddress() {
		return residenceAddress;
	}
	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}
	public String getTemporaryAddress() {
		return temporaryAddress;
	}
	public void setTemporaryAddress(String temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
	}
	public String getOfficeCity() {
		return officeCity;
	}
	public void setOfficeCity(String officeCity) {
		this.officeCity = officeCity;
	}
	public String getPermenantCity() {
		return permenantCity;
	}
	public void setPermenantCity(String permenantCity) {
		this.permenantCity = permenantCity;
	}
	public String getResidenceCity() {
		return residenceCity;
	}
	public void setResidenceCity(String residenceCity) {
		this.residenceCity = residenceCity;
	}
	public String getTemporaryCity() {
		return temporaryCity;
	}
	public void setTemporaryCity(String temporaryCity) {
		this.temporaryCity = temporaryCity;
	}
	public String getOfficeState() {
		return officeState;
	}
	public void setOfficeState(String officeState) {
		this.officeState = officeState;
	}
	public String getPermenantState() {
		return permenantState;
	}
	public void setPermenantState(String permenantState) {
		this.permenantState = permenantState;
	}
	public String getResidenceState() {
		return residenceState;
	}
	public void setResidenceState(String residenceState) {
		this.residenceState = residenceState;
	}
	public String getTemporaryState() {
		return temporaryState;
	}
	public void setTemporaryState(String temporaryState) {
		this.temporaryState = temporaryState;
	}
	public String getOfficeCountry() {
		return officeCountry;
	}
	public void setOfficeCountry(String officeCountry) {
		this.officeCountry = officeCountry;
	}
	public String getPermenantCountry() {
		return permenantCountry;
	}
	public void setPermenantCountry(String permenantCountry) {
		this.permenantCountry = permenantCountry;
	}
	public String getResidenceCountry() {
		return residenceCountry;
	}
	public void setResidenceCountry(String residenceCountry) {
		this.residenceCountry = residenceCountry;
	}
	public String getTemporaryCountry() {
		return temporaryCountry;
	}
	public void setTemporaryCountry(String temporaryCountry) {
		this.temporaryCountry = temporaryCountry;
	}
	public String getOfficePincode() {
		return officePincode;
	}
	public void setOfficePincode(String officePincode) {
		this.officePincode = officePincode;
	}
	public String getPermenantPincode() {
		return permenantPincode;
	}
	public void setPermenantPincode(String permenantPincode) {
		this.permenantPincode = permenantPincode;
	}
	public String getResidencePincode() {
		return residencePincode;
	}
	public void setResidencePincode(String residencePincode) {
		this.residencePincode = residencePincode;
	}
	public String getTemporaryPincode() {
		return temporaryPincode;
	}
	public void setTemporaryPincode(String temporaryPincode) {
		this.temporaryPincode = temporaryPincode;
	}
	public String getOfficeContact() {
		return officeContact;
	}
	public void setOfficeContact(String officeContact) {
		this.officeContact = officeContact;
	}
	public String getPermenantContact() {
		return permenantContact;
	}
	public void setPermenantContact(String permenantContact) {
		this.permenantContact = permenantContact;
	}
	public String getResidenceContact() {
		return residenceContact;
	}
	public void setResidenceContact(String residenceContact) {
		this.residenceContact = residenceContact;
	}
	public String getTemporaryContact() {
		return temporaryContact;
	}
	public void setTemporaryContact(String temporaryContact) {
		this.temporaryContact = temporaryContact;
	}
	public String getOfficeEmail() {
		return officeEmail;
	}
	public void setOfficeEmail(String officeEmail) {
		this.officeEmail = officeEmail;
	}
	public String getPermenantEmail() {
		return permenantEmail;
	}
	public void setPermenantEmail(String permenantEmail) {
		this.permenantEmail = permenantEmail;
	}
	public String getResidenceEmail() {
		return residenceEmail;
	}
	public void setResidenceEmail(String residenceEmail) {
		this.residenceEmail = residenceEmail;
	}
	public String getTemporaryEmail() {
		return temporaryEmail;
	}
	public void setTemporaryEmail(String temporaryEmail) {
		this.temporaryEmail = temporaryEmail;
	}
	@Override
	public String toString() {
		return "Prime360CommonTable [psxId=" + psxId + ", name=" + name + ", motherName=" + motherName + ", fatherName="
				+ fatherName + ", dob=" + dob + ", gender=" + gender + ", pan=" + pan + ", passport=" + passport
				+ ", voterId=" + voterId + ", aadhaar=" + aadhaar + ", drivingLic=" + drivingLic + ", rationcardNo="
				+ rationcardNo + ", officeAddress=" + officeAddress + ", permenantAddress=" + permenantAddress
				+ ", residenceAddress=" + residenceAddress + ", temporaryAddress=" + temporaryAddress + ", officeCity="
				+ officeCity + ", permenantCity=" + permenantCity + ", residenceCity=" + residenceCity
				+ ", temporaryCity=" + temporaryCity + ", officeState=" + officeState + ", permenantState="
				+ permenantState + ", residenceState=" + residenceState + ", temporaryState=" + temporaryState
				+ ", officeCountry=" + officeCountry + ", permenantCountry=" + permenantCountry + ", residenceCountry="
				+ residenceCountry + ", temporaryCountry=" + temporaryCountry + ", officePincode=" + officePincode
				+ ", permenantPincode=" + permenantPincode + ", residencePincode=" + residencePincode
				+ ", temporaryPincode=" + temporaryPincode + ", officeContact=" + officeContact + ", permenantContact="
				+ permenantContact + ", residenceContact=" + residenceContact + ", temporaryContact=" + temporaryContact
				+ ", officeEmail=" + officeEmail + ", permenantEmail=" + permenantEmail + ", residenceEmail="
				+ residenceEmail + ", temporaryEmail=" + temporaryEmail + "]";
	}
    
}
