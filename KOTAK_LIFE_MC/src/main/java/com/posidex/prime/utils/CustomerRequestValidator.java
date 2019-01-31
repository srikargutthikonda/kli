package com.posidex.prime.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.posidex.prime.common.dto.MRProfileInfoDTO;
import com.posidex.prime.dao.CustomerDAO;
import com.posidex.prime.exception.PosidexException;
import com.posidex.prime.request_bkp.CustomerRequest;

@Component
public class CustomerRequestValidator {

	private static Logger logger = LogManager.getLogger(CustomerRequestValidator.class);

	@Autowired
	private CustomerDAO daoi;

	@Autowired
	private Environment environment;

	// Validating request Details
	public void validateCustomerRequest(CustomerRequest customerRequest, Map<String, MRProfileInfoDTO> mrprofiles)
			throws Exception {

		logger.info("validating customer details");
		String requestNo = customerRequest.getRequest().getRequestPayload().getTransactions().get(0)
				.getTransactionData().getRequestNo().trim();
		try {

			if ("".equals(requestNo) || requestNo == null) {

				logger.error("request No is Empty or Null");
				throw new PosidexException("RequestId is required !!");
			}
			/*
			 * if (daoi.validateRequestId(requestNo)) {
			 * 
			 * throw new PosidexException("RequestId is Already existed !!"); }
			 */
			if (!mrprofiles.containsKey(customerRequest.getRequest().getRequestPayload().getTransactions().get(0)
					.getTransactionData().getProfileID())) {
				System.out.println(mrprofiles);
				logger.error("ProfileId is Empty , Null or not created in profiles");
				throw new PosidexException("profileId is required !!");
			}
			if (!validateDate(customerRequest.getRequest().getRequestPayload().getTransactions().get(0)
					.getTransactionData().getDob())) {
				logger.error("DOB validation is failed");
				throw new PosidexException("while validating date format got an exception");
			}

		} catch (PosidexException e) {
			throw new PosidexException(e.getMessage());
		}

		catch (Exception ex) {

			throw new Exception("while validating request details got an exception");

		}

	}

	private boolean validateDate(String dob) throws Exception {
		boolean flag = false;
		String dateformat = environment.getProperty("ws.dateformat");

		SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
		if (dob == null || "".equals(dob.trim())) {

			flag = true;
			return flag;
		}
		try {
			// if not valid, it will throw ParseException
			Date date = sdf.parse(dob);
			System.out.println(date);
			flag = true;
		} catch (ParseException e) {
			flag = false;
			logger.error("while validating date got an exception " + e.getMessage());
			throw new PosidexException("Date format is " + dateformat + " check date values !!");
		} catch (Exception e) {
			flag = false;
			logger.error("while validating date got an exception " + e.getMessage());
			throw new Exception("while validating date got an exception");
		}

		return flag;
	}

}
