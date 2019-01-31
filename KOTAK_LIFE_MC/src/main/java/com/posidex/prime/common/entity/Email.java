package com.posidex.prime.common.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@XmlRootElement
@XmlType(propOrder={"emailType","emailID"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"emailType","emailID"})
public class Email {


	//@XmlElement(name="EmailType")
    @JsonProperty("EmailType")
	private String emailType;
	
	//@XmlElement(name="EmailID")
    @JsonProperty("EmailID")
	private String  emailID;


	public String getEmailType() {
		return emailType;
	}


	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}


	public String getEmailID() {
		return emailID;
	}


	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}


	@Override
	public String toString() {
		return "Email [emailType=" + emailType + ", emailID=" + emailID + "]";
	}
	
	
	
	
}
