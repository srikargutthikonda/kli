package com.posidex.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.posidex.bean.DedupeInputBean;
import com.posidex.bean.DropDownBean;
import com.posidex.bean.UrlRequest;
import com.posidex.bean.UserRole;


public interface IValidateUserDao {
	public UserRole validate(UrlRequest request);
	public DedupeInputBean getData(String id);
	
	public DropDownBean getDropDownList(String Propsal_ID);

	public String checkVerifiedColumn(String id);

}
