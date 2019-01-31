package com.posidex.prime.common.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@XmlRootElement
@XmlType(propOrder={"phoneType","phone"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"phoneType","phone"})
public class Contact {
	
	//@XmlElement(name="PhoneType")
	@JsonProperty("PhoneType")
	private String phoneType;

	//@XmlElement(name="Phone")
	@JsonProperty("Phone")
	private String phone;

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Contact [phoneType=" + phoneType + ", phone=" + phone + "]";
	}

}
