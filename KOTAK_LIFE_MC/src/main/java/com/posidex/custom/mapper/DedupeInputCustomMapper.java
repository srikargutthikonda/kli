package com.posidex.custom.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.posidex.bean.DedupeInputBean;
import com.posidex.bean.UserRole;

public class DedupeInputCustomMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
    	DedupeInputBean bean=new DedupeInputBean();

		bean.setFIRSTNAME(rs.getString("FIRSTNAME"));
    	bean.setMIDDLENAME(rs.getString("MIDDLENAME"));
    	bean.setLASTNAME(rs.getString("LASTNAME"));
    	bean.setMOTHER_NAME(rs.getString("MOTHER_NAME"));
    	bean.setFATHER_NAME(rs.getString("FATHER_NAME"));
    	bean.setGENDER_FLAG(rs.getString("GENDER_FLAG"));
    	bean.setDOB1(rs.getString("DOB1"));
    	bean.setPAN(rs.getString("PAN"));
    	bean.setAADHAR(rs.getString("AADHAR"));
    	bean.setVOTERID(rs.getString("VOTERID"));
    	bean.setDRIVING_LICN_NO(rs.getString("DRIVING_LICN_NO"));
    	bean.setRATIONCARD_NO(rs.getString("RATIONCARD_NO"));
    	bean.setPASSPORT(rs.getString("PASSPORT"));
    	
    	bean.setPERMANENT_ADDRESS(rs.getString("PERMANENT_ADDRESS"));
    	bean.setPERMANENT_CITY(rs.getString("PERMANENT_CITY"));
    	bean.setPERMANENT_PIN(rs.getString("PERMANENT_PIN"));
    	bean.setPERMANENT_STATE(rs.getString("PERMANENT_STATE"));	      
    	bean.setPERMANENT_EMAIL(rs.getString("PERMANENT_EMAIL"));
    	bean.setPERMANENT_PHONE(rs.getString("PERMANENT_PHONE"));
    	
    	bean.setOFFICE_ADDRESS(rs.getString("OFFICE_ADDRESS"));
    	bean.setOFFICE_CITY(rs.getString("OFFICE_CITY"));
    	bean.setOFFICE_PIN(rs.getString("OFFICE_PIN"));
    	bean.setOFFICE_STATE(rs.getString("OFFICE_STATE"));	      
    	bean.setOFFICE_EMAIL(rs.getString("OFFICE_EMAIL"));
    	bean.setOFFICE_PHONE(rs.getString("OFFICE_PHONE"));
  	
    	bean.setTEMPORARY_ADDRESS(rs.getString("TEMPORARY_ADDRESS"));
    	bean.setTEMPORARY_CITY(rs.getString("TEMPORARY_CITY"));
    	bean.setTEMPORARY_PIN(rs.getString("TEMPORARY_PIN"));
    	bean.setTEMPORARY_STATE(rs.getString("TEMPORARY_STATE"));	      
    	bean.setTEMPORARY_EMAIL(rs.getString("TEMPORARY_EMAIL"));
    	bean.setTEMPORARY_PHONE(rs.getString("TEMPORARY_PHONE"));
    	
    	bean.setRESIDENCE_ADDRESS(rs.getString("RESIDENCE_ADDRESS"));
    	bean.setRESIDENCE_CITY(rs.getString("RESIDENCE_CITY"));     	
    	bean.setRESIDENCE_PIN(rs.getString("RESIDENCE_PIN"));
    	bean.setRESIDENCE_STATE(rs.getString("RESIDENCE_STATE"));	      
    	bean.setRESIDENCE_EMAIL(rs.getString("RESIDENCE_EMAIL"));
    	bean.setRESIDENCE_PHONE(rs.getString("RESIDENCE_PHONE"));
    	//
    	bean.setCKYCNO(rs.getString("CKYCNO"));
    	bean.setCLIENT_TYPE(rs.getString("CLIENT_TYPE"));
    	bean.setCRNNO(rs.getString("CRNNO"));
    	bean.setGSTIN(rs.getString("GSTIN"));
    	bean.setSOURCE_SYSTEM(rs.getString("SOURCE_SYSTEM"));
    	bean.setSTATUS(rs.getString("STATUS"));
    	bean.setMOBILE(rs.getString("MOBILE"));
    	bean.setDOC(rs.getString("DOC"));

		return bean;
	}
	
}