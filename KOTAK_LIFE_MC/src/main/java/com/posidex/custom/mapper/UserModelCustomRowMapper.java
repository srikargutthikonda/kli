package com.posidex.custom.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.posidex.bean.UserModel;

public class UserModelCustomRowMapper implements RowMapper{

	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
    	UserModel user=new UserModel();

    	user = new UserModel();
		user.setUserId(rs.getInt("USER_ID"));
		user.setUsername(rs.getString("USERNAME"));
		user.setPassword(rs.getString("HASHED_PASSWORD"));
		user.setSalt(rs.getString("SALT"));
		user.setFirstname(rs.getString("FIRSTNAME"));
		user.setLastname(rs.getString("LASTNAME"));
		user.setEmail(rs.getString("EMAIL"));
		user.setUserType(rs.getString("USER_TYPE"));
		user.setPrimaryRole(rs.getString("USER_ROLE"));
		user.setLandingPage(rs.getString("USER_LANDING_PAGE"));
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
		return user;
	}
}

