package com.posidex.custom.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.posidex.bean.DropDownBean;

public class DropDownBeanMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		DropDownBean bean=new DropDownBean();
		bean.setJOINT_LIFEASSURED_ID(rs.getString("JOINT_LIFEASSURED_ID"));
		bean.setLIFEASSURED_ID(rs.getNString("LIFEASSURED_ID"));
		bean.setPROPOSED_ID(rs.getString("PROPOSED_ID"));
		bean.setPROPOSAL_NUMBER(rs.getString("PROPOSAL"));
		//bean.setCLIENT_ID(rs.getString("CLIENT_ID"));
		
		return bean;
	}

}
