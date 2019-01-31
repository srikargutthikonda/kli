package com.posidex.prime.common.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.posidex.prime.common.entity.Address;
import com.posidex.prime.common.entity.Contact;
import com.posidex.prime.common.entity.Email;

public class PSXCustomerRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String CreationDate;

	private String CreationTime;

	private String RequestorToken;

	private String SourceInfoName;

	private String Source;

	private String TransactionId;

	private String userName;

	private String device_uuid;

	private String lastSyncDate;

	private String userEmail;

	private String RequestNo;

	private String ProfileID;

	private String ClientID;

	private String FeedSysID;

	private String FirstName;
	
	private String middleName;

	private String LastName;
	
	private String fatherName;

	private Date dob;

	private String gender;

	private String Pan;
	
	private String PassportNo;
	
	private String VoterId;
	
	private String Aadhaar;
	
	
	private String DrivingLicence;
	
	private String ir;
	
	private List<Address> addresses;
	
	private List<Contact> contacts;
	
	private List<Email> emails;
	
	
	
	
	
	
	
	
	
	

}
