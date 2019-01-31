package com.posidex.custom.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.posidex.bean.DedupeInputBean;
import com.posidex.bean.UserRole;

public class UserDataMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
    	UserRole bean=new UserRole();

		bean.setDISPLAY_NAME(rs.getString("DISPLAY_NAME"));
		bean.setROLE_PURPOSE(rs.getString("ROLE_PURPOSE"));
		bean.setSTATUS(rs.getString("STATUS"));
		
		return bean;
	}
	
}