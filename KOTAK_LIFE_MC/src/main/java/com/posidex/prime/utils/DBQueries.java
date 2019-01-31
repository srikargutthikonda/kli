package com.posidex.prime.utils;

public class DBQueries {
	
	
	public static String VALIDATE_REQUESTID_QUERY = "select 1 from  psx_request_t where request_id=?";

	public static  String MATCH_RESULT_QUERY = "select request_status,match_count,psx_id  from psx_request_t  where request_id=?";
	
	
	/*
	 //MySql Queries
	  
	public static  String DG_RESULTS_QUERY="select  a.psx_id,a.name,a.MOTHER_NAME,a.DOB,a.PAN,a.PASSPORT_NO, a.EXTRA_NAME_1,a.EXTRA_NAME_2,a.EXTRA_NAME_3,a.EXTRA_NAME_4, a.DRIVING_LICN_NO,a.VOTERID,a.SOURCE_SYS_ID,a.CUST_ID,a.CUST_ID_PART_1, a.EXTRA_EQ_COLUMN1,a.EXTRA_EQ_COLUMN3,a.EXTRA_EQ_COLUMN5,a.CUST_TYPE_FLAG,a.SPOUSE_NAME,a.GENDER_FLAG,a.FATHER_NAME,a.MARITAL_STATUS_FLAG,a.AADHAAR_NO, b.match_type,a.cust_unq_id,b.SCALE_TYPE,b.matching_rules,a.rationcard_no from PSX_CUST_DG_BULK_TRG_T  a, (select b.trgcol11,b.match_type,b.scale_type,b.matching_rules  from psx_request_t a join psx_results b on (a.psx_id=b.srccol11 and a.request_id=?))  b where a.psx_id=b.trgcol11 order by a.psx_id asc limit ? ";
	public static  String ADDRESS_RESULTS_QUERY="SELECT  psx_id, ADDRESS_TYPE_FLAG, address, city, state, COUNTRY, pincode, landmark FROM   PSX_CUST_ADDR_BULK_TRG_T where psx_id in (select psx_Id from PSX_CUST_DG_BULK_TRG_T where psx_id = ?) ";
	public static  String CONTACT_RESULTS_QUERY="SELECT   psx_id,  phone_type,  phone FROM  PSX_CUST_CONTACT_BULK_TRG_T  where psx_id in (select psx_id from   PSX_CUST_DG_BULK_TRG_T WHERE psx_id = ?)";
	public static  String EMAIL_RESULTS_QUERY=" SELECT   psx_id,  email_type,  email_id FROM  PSX_CUST_EMAIL_BULK_TRG_T where psx_id in (select psx_id from  PSX_CUST_DG_BULK_TRG_T WHERE psx_id = ? ) ";
    
    
    public static String DG_RESULTS_QUERY_BULK_REQ="select  a.psx_id,a.name,a.MOTHER_NAME,a.DOB,a.PAN,a.PASSPORT_NO, a.DRIVING_LICN_NO,a.VOTERID,a.CUST_ID,a.SPOUSE_NAME,a.GENDER_FLAG,a.FATHER_NAME,a.AADHAAR_NO, b.match_type,a.cust_id,b.SCALE_TYPE,b.matching_rules,a.rationcard_no from PSX_CUST_DG_BULK_REQ_T  a, (select b.trgcol11,b.match_type,b.scale_type,b.matching_rules  from psx_request_t a join psx_results b on (a.psx_id=b.srccol11 and a.request_id=?))  b where a.psx_id=b.trgcol11 order by a.psx_id asc limit ? ";
	public static String ADDRESS_RESULTS_QUERY_BULK_REQ="SELECT  psx_id, ADDRESS_TYPE_FLAG, address, city, state, COUNTRY, pincode, landmark FROM   PSX_CUST_ADDR_BULK_REQ_T where psx_id in (select psx_Id from PSX_CUST_DG_BULK_REQ_T where psx_id = ?) ";
	public static String CONTACT_RESULTS_QUERY_BULK_REQ="SELECT   psx_id,  phone_type,  phone FROM  PSX_CUST_CONTACT_BULK_REQ_T  where psx_id in (select psx_id from   PSX_CUST_DG_BULK_REQ_T WHERE psx_id = ?)";
	public static String EMAIL_RESULTS_QUERY_BULK_REQ=" SELECT   psx_id,  email_type,  email_id FROM  PSX_CUST_EMAIL_BULK_REQ_T where psx_id in (select psx_id from  PSX_CUST_DG_BULK_REQ_T WHERE psx_id = ? ) ";

    */
	
	//Oracle queries
	
	public static String DG_RESULTS_QUERY = "select psx_id,name,MOTHER_NAME,dob,pan,passport_no,extra_name_1,extra_name_2,extra_name_3,extra_name_4,driving_licn_no,voterid,source_sys_id,cust_id,cust_id_part_1,extra_eq_column1,extra_eq_column3,extra_eq_column5,cust_type_flag,SPOUSE_NAME,GENDER_FLAG,FATHER_NAME,MARITAL_STATUS_FLAG,AADHAAR_NO,match_type,cust_unq_id,SCALE_TYPE,matching_rules,rationcard_no,EXTRA_EQ_COLUMN6,EXTRA_EQ_COLUMN7,EXTRA_EQ_COLUMN8,EXTRA_EQ_COLUMN11,FLAG3,EXTRA_DATE_1 from(select row_number() over(order by a.psx_id,d.scale_type desc) rnk,a.psx_id,a.name,a.MOTHER_NAME,a.dob,a.pan,a.passport_no,a.extra_name_1,a.extra_name_2,a.extra_name_3,a.extra_name_4,a.driving_licn_no,a.voterid,a.source_sys_id,a.cust_id,a.cust_id_part_1,a.extra_eq_column1,a.extra_eq_column3,a.extra_eq_column5,a.cust_type_flag,a.SPOUSE_NAME,a.GENDER_FLAG,a.FATHER_NAME,a.MARITAL_STATUS_FLAG,a.AADHAAR_NO,d.match_type,a.cust_unq_id,d.SCALE_TYPE,d.matching_rules,a.rationcard_no,a.EXTRA_EQ_COLUMN6,a.EXTRA_EQ_COLUMN7,a.EXTRA_EQ_COLUMN8,a.EXTRA_EQ_COLUMN11,a.FLAG3,a.EXTRA_DATE_1 from PSX_CUST_DG_BULK_TRG_T a,psx_request_t c,psx_results d where a.psx_id=d.trgcol11 and c.psx_id=d.srccol11 and c.request_id=?) a where a.rnk<?";
	public static String ADDRESS_RESULTS_QUERY = "select psx_id,ADDRESS_TYPE_FLAG,address,city,state,COUNTRY,pincode,LANDMARK,AREA_VILLAGE_NAME from (select a.psx_id,a.ADDRESS_TYPE_FLAG,a.address,a.city,a.state,a.COUNTRY,a.pincode,a.landmark,a.AREA_VILLAGE_NAME from PSX_CUST_ADDR_BULK_TRG_T a,PSX_CUST_DG_BULK_TRG_T b where a.psx_id=b.psx_Id and b.psx_id=?)";
	public static String CONTACT_RESULTS_QUERY = "select psx_id,phone_type,phone,STD_CODE from (select a.psx_id,a.phone_type,a.phone,a.STD_CODE from PSX_CUST_CONTACT_BULK_TRG_T a,PSX_CUST_DG_BULK_TRG_T b where a.psx_id=b.psx_Id and b.psx_id=?)";
	public static String EMAIL_RESULTS_QUERY = "select psx_id,email_type,email_id from (select a.psx_id,a.email_type,a.email_id from PSX_CUST_EMAIL_BULK_TRG_T a,PSX_CUST_DG_BULK_TRG_T b where a.psx_id=b.psx_Id and b.psx_id=?)";
	public static String REPORT_RESULTS_QUERY ="select psx_id,NAME_OF_FIRM,REGISTRATION_NUMBER,MACHINE_SRNO,VEHICLE_RGD_NO,NREGA,AADHAR_TOKEN_NO from (select a.psx_id,a.NAME_OF_FIRM,a.REGISTRATION_NUMBER,a.MACHINE_SRNO,a.VEHICLE_RGD_NO,a.NREGA,AADHAR_TOKEN_NO from PSX_CUST_REPORT_BULK_TRG_T a,PSX_CUST_DG_BULK_TRG_T b where a.psx_id=b.psx_Id and b.psx_id=?)";

	
	
	public static String DG_RESULTS_QUERY_BULK_REQ="select psx_id,name,MOTHER_NAME,dob,pan,passport_no,extra_name_1,extra_name_2,extra_name_3,extra_name_4,driving_licn_no,voterid,source_sys_id,cust_id,cust_id_part_1,extra_eq_column1,extra_eq_column3,extra_eq_column5,cust_type_flag,SPOUSE_NAME,GENDER_FLAG,FATHER_NAME,MARITAL_STATUS_FLAG,AADHAAR_NO,match_type,cust_unq_id,SCALE_TYPE,matching_rules,rationcard_no,EXTRA_EQ_COLUMN6,EXTRA_EQ_COLUMN7,EXTRA_EQ_COLUMN8,EXTRA_EQ_COLUMN11,FLAG3,EXTRA_DATE_1 from(select row_number() over(order by a.psx_id,d.scale_type desc) rnk,a.psx_id,a.name,a.MOTHER_NAME,a.dob,a.pan,a.passport_no,a.extra_name_1,a.extra_name_2,a.extra_name_3,a.extra_name_4,a.driving_licn_no,a.voterid,a.source_sys_id,a.cust_id,a.cust_id_part_1,a.extra_eq_column1,a.extra_eq_column3,a.extra_eq_column5,a.cust_type_flag,a.SPOUSE_NAME,a.GENDER_FLAG,a.FATHER_NAME,a.MARITAL_STATUS_FLAG,a.AADHAAR_NO,d.match_type,a.cust_unq_id,d.SCALE_TYPE,d.matching_rules,a.rationcard_no,a.EXTRA_EQ_COLUMN6,a.EXTRA_EQ_COLUMN7,a.EXTRA_EQ_COLUMN8,a.EXTRA_EQ_COLUMN11,a.FLAG3,a.EXTRA_DATE_1 from PSX_CUST_DG_BULK_REQ_T a,psx_request_t c,psx_results d where a.psx_id=d.trgcol11 and c.psx_id=d.srccol11 and c.request_id=?) a where a.rnk<?";
	public static String ADDRESS_RESULTS_QUERY_BULK_REQ="select psx_id,ADDRESS_TYPE_FLAG,address,city,state,COUNTRY,pincode,LANDMARK,AREA_VILLAGE_NAME from (select a.psx_id,a.ADDRESS_TYPE_FLAG,a.address,a.city,a.state,a.COUNTRY,a.pincode,a.landmark,a.AREA_VILLAGE_NAME from PSX_CUST_ADDR_BULK_REQ_T a,PSX_CUST_DG_BULK_TRG_T b where a.psx_id=b.psx_Id and b.psx_id=?)";
	public static String CONTACT_RESULTS_QUERY_BULK_REQ="select psx_id,phone_type,phone,STD_CODE from (select a.psx_id,a.phone_type,a.phone,a.STD_CODE from PSX_CUST_CONTACT_BULK_REQ_T a,PSX_CUST_DG_BULK_REQ_T b where a.psx_id=b.psx_Id and b.psx_id=?)";
	public static String EMAIL_RESULTS_QUERY_BULK_REQ="select psx_id,email_type,email_id from (select a.psx_id,a.email_type,a.email_id from PSX_CUST_EMAIL_BULK_REQ_T a,PSX_CUST_DG_BULK_TRG_T b where a.psx_id=b.psx_Id and b.psx_id=?)";
	public static String REPORT_RESULTS_QUERY_REQ ="select psx_id,NAME_OF_FIRM,REGISTRATION_NUMBER,MACHINE_SRNO,VEHICLE_RGD_NO,NREGA,AADHAR_TOKEN_NO from (select a.psx_id,a.NAME_OF_FIRM,a.REGISTRATION_NUMBER,a.MACHINE_SRNO,a.VEHICLE_RGD_NO,a.NREGA,AADHAR_TOKEN_NO from PSX_CUST_REPORT_BULK_REQ_T a,PSX_CUST_DG_BULK_REQ_T b where a.psx_id=b.psx_Id and b.psx_id=?)";
	
	    
	public static String	WEBSERVICE_ERROR_CODE_QUERY	= "select ERROR_CODE from psx_webservice_error_codes_t";

	
	public static String POSIDEX_PM_REQUEST_INSERT_QUERY = "insert into psx_request_t(REQUEST_ID,REQUEST_TYPE,REQUEST_STATUS,PROFILE_ID,PROFILE_NAME,PSX_ID,FEED_SYS_ID,PSX_BATCH_ID) values (?,?,?,?,?,?,?,?)";
	
	public static String DG_REQ_T_INSERT_QUERY = "insert into psx_cust_dg_req_t(FATHER_NAME,SPOUSE_NAME,DRIVING_LICN_NO,name,MOTHER_NAME,psx_id,request_id,dui_flag,DOB,PAN,PASSPORT_NO,VOTERID,cust_id,GENDER_FLAG,AADHAAR_NO,RATIONCARD_NO,CUST_UNQ_ID,psx_batch_id,EXTRA_EQ_COLUMN11,extra_eq_column1,EXTRA_EQ_COLUMN3,EXTRA_EQ_COLUMN5,EXTRA_EQ_COLUMN6,EXTRA_EQ_COLUMN7,EXTRA_EQ_COLUMN8,FLAG3,EXTRA_DATE_1,EXTRA_EQ_COLUMN9,INSERT_TS,LCHG_TIME) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,current_timestamp,current_timestamp)";
	public static String ADDRESS_REQ_T_INSERT_QUERY = "insert into psx_cust_addr_req_t(address,city,state,country,pincode,source_sys_id,psx_id,request_id,dui_flag,CUST_ID,feed_sys_id,INSERT_TS,LCHG_TIME,address_type_flag,CUST_UNQ_ID,psx_batch_id,LANDMARK,HOUSE_NO,AREA_VILLAGE_NAME) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String CONTACT_REQ_T_INSERT_QUERY = "insert into psx_cust_contact_req_t(phone,source_sys_id,psx_id,request_id,dui_flag,CUST_ID,phone_type,INSERT_TS,LCHG_TIME,CUST_UNQ_ID,psx_batch_id,STD_CODE) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String EMAIL_REQ_T_INSERT_QUERY = "insert into psx_cust_email_stg_t(email_id,source_sys_id,psx_id,request_id,dui_flag,CUST_ID,INSERT_TS,LCHG_TIME,email_type,CUST_UNQ_ID,psx_batch_id) values(?,?,?,?,?,?,?,?,?,?,?)";
    public static String REPORT_REQ_T_INSERT_QUERY="insert into psx_cust_report_req_t(NAME_OF_FIRM,REGISTRATION_NUMBER,MACHINE_SRNO,VEHICLE_RGD_NO,psx_id,request_id,dui_flag,CUST_ID,INSERT_TS,LCHG_TIME,NREGA,AADHAR_TOKEN_NO,CUST_UNQ_ID,psx_batch_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	
	public static String DG_TRG_T_INSERT_QUERY = "insert into psx_cust_dg_stg_t(FATHER_NAME,SPOUSE_NAME,DRIVING_LICN_NO,name,MOTHER_NAME,psx_id,request_id,dui_flag,DOB,PAN,PASSPORT_NO,VOTERID,cust_id,GENDER_FLAG,AADHAAR_NO,RATIONCARD_NO,CUST_UNQ_ID,psx_batch_id,EXTRA_EQ_COLUMN11,extra_eq_column1,EXTRA_EQ_COLUMN3,EXTRA_EQ_COLUMN5,EXTRA_EQ_COLUMN6,EXTRA_EQ_COLUMN7,EXTRA_EQ_COLUMN8,FLAG3,EXTRA_DATE_1,EXTRA_EQ_COLUMN9) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String ADDRESS_TRG_T_INSERT_QUERY = "insert into psx_cust_addr_stg_t(address,city,state,country,pincode,source_sys_id,psx_id,request_id,dui_flag,CUST_ID,feed_sys_id,address_type_flag,CUST_UNQ_ID,psx_batch_id,LANDMARK,HOUSE_NO,AREA_VILLAGE_NAME) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String CONTACT_TRG_T_INSERT_QUERY = "insert into psx_cust_contact_stg_t(phone,source_sys_id,psx_id,request_id,dui_flag,CUST_ID,phone_type,CUST_UNQ_ID,psx_batch_id,STD_CODE) values(?,?,?,?,?,?,?,?,?,?)";
	public static String EMAIL_TRG_T_INSERT_QUERY = "insert into psx_cust_email_stg_t(email_id,source_sys_id,psx_id,request_id,dui_flag,CUST_ID,email_type,CUST_UNQ_ID,psx_batch_id) values(?,?,?,?,?,?,?,?,?)";
	public static String REPORT_TRG_T_INSERT_QUERY="insert into psx_cust_report_stg_t(NAME_OF_FIRM,REGISTRATION_NUMBER,MACHINE_SRNO,VEHICLE_RGD_NO,psx_id,request_id,dui_flag,NREGA,AADHAR_TOKEN_NO,CUST_ID,CUST_UNQ_ID,psx_batch_id) values(?,?,?,?,?,?,?,?,?,?,?,?)";

	
	////=============================================
	private static String MATCH_TYPE_AUDIT_INSERT_QUERY = "insert into MATCH_TYPE_RES_AUDIT_T(REQUEST_ID,PSX_ID,MATCH_TYPE,MATCH_COUNT,REFERENCE_COUNT) values(?,?,?,?,?)";
	
	private static String GET_PSX_ID_QUERY = "select psx_id from psx_request_t where request_id=?";

	private static String GET_MATCH_TYPE_QUERY = "select matching_rules,trgcol11 tag_psx_id from psx_results where srccol11=? ";

	
	private static String MATCH_AND_REMATCH_COUNT_REQUESTID_QUERY = "select  REQUEST_ID,MATCH_COUNT,RE_MATCH_COUNT,PSX_ID,REQUEST_STATUS,Fraud_Detection,Refereefraud  from psx_request_t where REQUEST_ID=?";

	private static String MATCH_AND_REMATCH_COUNT_PSXID_QUERY = "select  REQUEST_ID,MATCH_COUNT,RE_MATCH_COUNT,PSX_ID,REQUEST_STATUS,Fraud_Detection,Refereefraud from psx_request_t where PSX_ID=?";

	private static String MATCH_COUNT_QUERY = "select  MATCH_COUNT from psx_request_t where psx_id=?";

	private static String VALIDATE_CLIENTID_QUERY_1 = "select 1 from  psx_cust_dg_req_t where cust_unq_id=?";
 
	private static String VALIDATE_CLIENTID_QUERY_2 = "select 1 from  psx_cust_dg_bulk_trg_t where cust_unq_id=?";
	
	private static String REPORTCOLUMNS_REQ_T_INSERT_QUERY = "INSERT INTO PSX_CUST_REPORT_REQ_T ( CUST_UNQ_ID,REPORT_COUNTER,REQUEST_ID,PSX_ID,FILLER_STRING_1,FILLER_STRING_2,FILLER_STRING_3,FILLER_STRING_4,FILLER_STRING_5,FILLER_STRING_6,BATCH_ID,INSERT_TS,FILLER_DATE_1,FILLER_DATE_2,FILLER_DATE_3,FILLER_DATE_4,LCHG_TIME,FILLER_NUMBER_1,FILLER_NUMBER_2,FILLER_NUMBER_3,FILLER_NUMBER_4,FILLER_NUMBER_5,UCID,CUST_ID,CUST_ID_PART_1,CUST_ID_PART_2,CUST_ID_PART_3,CUST_ID_PART_4,DUI_FLAG,PSX_BATCH_ID,SOURCE_SYS_ID,FEED_SYS_ID)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private static String REPORTCOLUMNS_TRG_T_INSERT_QUERY = "INSERT INTO psx_cust_report_stg_t ( CUST_UNQ_ID,REPORT_COUNTER,REQUEST_ID,PSX_ID,FILLER_STRING_1,FILLER_STRING_2,FILLER_STRING_3,FILLER_STRING_4,FILLER_STRING_5,FILLER_STRING_6,BATCH_ID,INSERT_TS,FILLER_DATE_1,FILLER_DATE_2,FILLER_DATE_3,FILLER_DATE_4,LCHG_TIME,FILLER_NUMBER_1,FILLER_NUMBER_2,FILLER_NUMBER_3,FILLER_NUMBER_4,FILLER_NUMBER_5,UCID,CUST_ID,CUST_ID_PART_1,CUST_ID_PART_2,CUST_ID_PART_3,CUST_ID_PART_4,DUI_FLAG,PSX_BATCH_ID,SOURCE_SYS_ID,FEED_SYS_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


	

	//public static String ASIA_CLIENT_MERGE_RESPONSES_INSERT_QUERY="insert into client_merge_response_details(error_code,error_description,flag,merge_client_no,policy_no,retained_client_no,destination,source,transaction_dt,transaction_id,transaction_type)values(?,?,?,?,?,?,?,?,?,?,?)";
		
		
	

	
}
