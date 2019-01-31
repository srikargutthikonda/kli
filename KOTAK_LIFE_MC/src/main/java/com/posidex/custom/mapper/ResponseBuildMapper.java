package com.posidex.custom.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.posidex.bean.UserModel;
import com.posidex.prime.response.ProcessRsponse;

public class ResponseBuildMapper implements RowMapper {

	@Override
	public ProcessRsponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ProcessRsponse response=new ProcessRsponse();

    	response.setAADHAAR(rs.getString("AADHAAR"));
    	response.setCKYCNO(rs.getString("CKYCNO"));
    	response.setCORPORATELICENCE(rs.getString("cORPORATELICENCE"));
    	response.setCRNNO(rs.getString("CRNNO"));
    	response.setDOB1(rs.getString("DOB1"));
		response.setREQUEST_ID(rs.getString("REQUEST_ID"));
		response.setNAME(rs.getString("NAME"));
		response.setFATHER_NAME(rs.getString("FATHER_NAME"));
		response.setPERMANENT_PHONE(rs.getString("PERMANENT_PHONE"));
		response.setPERMANENT_ADDRESS(rs.getString("PERMANENT_ADDRESS"));
		response.setPERMANENT_PIN(rs.getString("PERMANENT_PIN"));
		
		
		return response;
	}


}
