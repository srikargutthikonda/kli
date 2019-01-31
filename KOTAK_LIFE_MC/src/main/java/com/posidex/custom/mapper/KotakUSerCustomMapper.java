package com.posidex.custom.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.posidex.bean.KotakUser;

	public class KotakUSerCustomMapper implements RowMapper{

		
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	KotakUser kotakuser=new KotakUser();
	    	kotakuser.setACTIVE(rs.getString("ACTIVE"));
	    	kotakuser.setUSER_ID(rs.getString("USER_ID"));
	    	kotakuser.setUSER_NAME(rs.getString("USER_NAME"));

	    
			/*user.setClientId(rs.getInt("CLIENT_ID"));
			user.setLogInTime(rs.getDate("LOG_IN_TIME"));
			user.setLogOutTime(rs.getDate("LOG_OUT_TIME"));
			user.setLoginStatus(rs.getString("LOG_IN_STATUS"));
			user.setCreatedOn(rs.getString("CREATED_ON"));
			user.setUpdatedOn(rs.getString("UPDATED_ON"));
			user.setFailedLoginAttempts(rs.getInt("FAILED_LOGIN_ATTEMPTS"));
			user.setDataSource(rs.getString("DATA_SOURCE"));
			user.setLogintype(rs.getString("LOGIN_TYPE"));
			user.setActivationDate(rs.getString("ACTIVATION_DATE"));
			user.setRoleId(rs.getString("ROLE_ID"));
			*/
			return kotakuser;
		}
	}