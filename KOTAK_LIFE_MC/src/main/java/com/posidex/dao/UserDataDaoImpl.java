package com.posidex.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.posidex.bean.KotakUser;
import com.posidex.bean.UserModel;
import com.posidex.custom.mapper.KotakUSerCustomMapper;
import com.posidex.custom.mapper.UserModelCustomRowMapper;

@Repository
public class UserDataDaoImpl implements USerDataDao{

	
	@Autowired
	private Environment env;

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public UserModel getValidUserData(String username) {
		// TODO Auto-generated method stub
		System.out.println("getValidUserDAta Impl class**");
		String sql = env.getProperty("get_valid_user");
		System.out.println(sql+"input value --> ("+username + ") obtained getValidUserData ********************");
		try {
			@SuppressWarnings("unchecked")
			UserModel userData = (UserModel) jdbcTemplate.queryForObject(sql, new Object[] { username},
					new UserModelCustomRowMapper());
			System.out.println("====================userdata below===================================");
			System.out.println(userData.toString());
			System.out.println("====================userData' /\'===================================");

			return userData;
		} catch (EmptyResultDataAccessException e) {
			System.out.println(" came to catch block");
			return null;
		}
		
		
	}
	@Override
	public KotakUser getKotakUSer(String kotakUsername) {
		String sql = env.getProperty("get_valid_kotak_user");
		System.out.println(sql+"input value --> ("+kotakUsername + ") obtained getValidUserData ********************");
		try {
			@SuppressWarnings("unchecked")
			KotakUser userData = (KotakUser) jdbcTemplate.queryForObject(sql, new Object[] { kotakUsername},
					new KotakUSerCustomMapper());
			System.out.println("====================Kotak user is below below===================================");
			System.out.println(userData.toString());
			System.out.println("====================userData' /\'===================================");

			return userData;
		} catch (EmptyResultDataAccessException e) {
			System.out.println(" came to catch block");
			return null;
		}
	}
}
