package com.posidex.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.posidex.bean.DedupeInputBean;
import com.posidex.bean.DropDownBean;
import com.posidex.bean.UrlRequest;
import com.posidex.bean.UserRole;
import com.posidex.custom.mapper.DedupeInputCustomMapper;
import com.posidex.custom.mapper.DropDownBeanMapper;
import com.posidex.custom.mapper.UserDataMapper;

@Repository
public class ValidateUserDaoImpl implements IValidateUserDao {

	@Autowired
	private Environment env;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public UserRole validate(UrlRequest request) {
		// TODO Auto-generated method stub
		String user = request.getPsdxUser();
		String pwd = request.getPsdxPwd();

		String role = "";
		String s = "";
		String sql = env.getProperty("select_role_based_login");
		System.out.println(sql + " static query from ********************");
		try {
			@SuppressWarnings("unchecked")
			UserRole userData = (UserRole) jdbcTemplate.queryForObject(sql, new Object[] { user, pwd },
					new UserDataMapper());
			System.out.println(userData.toString());
			

			return userData;
		} catch (EmptyResultDataAccessException e) {
			System.out.println(" came to catch block");
			return null;
		}

	}

	@Override
	public DedupeInputBean getData(String id) {
		System.out.println("from DAO IMPL getData()" + id);
		// String sql = "select * from DEMO_KOTAK_DEDUPE_DATA_T where CLIENT_REQUEST=?";
		String sql = env.getProperty("select_max_timestamp_with_client");
		try {
		@SuppressWarnings("unchecked")
		
		DedupeInputBean deDupedata = (DedupeInputBean) jdbcTemplate.queryForObject(sql, new Object[] { id, id },
				new DedupeInputCustomMapper());
		System.out.println("====================DedupeData below===================================");
		System.out.println(deDupedata);
		
		return deDupedata;
		
		}
		 catch (EmptyResultDataAccessException e) {
				return null;
			}	

	}

	@Override
	public DropDownBean getDropDownList(String Propsal_ID) {
		// TODO Auto-generated method stub

		try{// int P_ID=Integer.parseInt(Propsal_ID);
		String sql = env.getProperty("select_view_dropdown_list");
		System.out.println("Propsal_ID from DAOIMPL "+Propsal_ID);
		@SuppressWarnings("unchecked")
	
		DropDownBean dropDwondata = (DropDownBean) jdbcTemplate.queryForObject(sql, new Object[] { Propsal_ID },
				new DropDownBeanMapper());
		System.out.println("====================dropDown values below===================================");
		System.out.println(dropDwondata);
		System.out.println("====================DedupeData below===================================");
		return dropDwondata;
		}
		catch(EmptyResultDataAccessException ex)
		{
			return null;
		}
	}

	@Override
	public String checkVerifiedColumn(String id) {
		// TODO Auto-generated method stub
		String sql = "SELECT ID,STREET_NAME FROM table WHERE ID=?";
/*
	    String streetName = (String) jdbcTemplate.queryForObject(
	            sql, new Object[] { id }, String.class);

	    return streetName;*/
		
		
		return "";
	}

}
