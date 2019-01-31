package com.posidex.prime.common.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@XmlRootElement
@XmlType(propOrder={"addressType","address","city","state","country","pincode"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"addressType","address","city","state","country","pincode"})
public class Address {

	@XmlElement(name="AddressType")
	@JsonProperty("AddressType")
	private String				addressType;

	@XmlElement(name="Address")
	@JsonProperty("Address")
	private String				address;

	@XmlElement(name="City")
	@JsonProperty("City")
	private String				city;

	@XmlElement(name="State")
	@JsonProperty("State")
	private String				state;

	@XmlElement(name="Country")
	@JsonProperty("Country")
	private String				country;

	@XmlElement(name="Pincode")
	@JsonProperty("Pincode")
	private String				pincode;

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [addressType=" + addressType + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", pincode=" + pincode + "]";
	}
	
	
	
	
	
}
