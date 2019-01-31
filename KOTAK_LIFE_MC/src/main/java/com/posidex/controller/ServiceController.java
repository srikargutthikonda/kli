package com.posidex.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.posidex.bean.ClientRequestBean;
import com.posidex.bean.DedupeInputBean;
import com.posidex.bean.DedupeReport;
import com.posidex.bean.DropDownBean;
import com.posidex.bean.GetCheckBoxData;
import com.posidex.bean.KotakUser;
import com.posidex.bean.LifeAsiaResponseMessageBean;
import com.posidex.bean.LifeAsiaSucessAndErrorResponses;
import com.posidex.bean.MISReport;
import com.posidex.bean.UserModel;
import com.posidex.bean.UserRole;
import com.posidex.exception.PosidexException;
import com.posidex.prime.common.dto.ErrorCodeInfoDTO;
import com.posidex.prime.common.dto.MRProfileInfoDTO;
import com.posidex.prime.dao.CustomerDAO;
import com.posidex.prime.exception.DAOException;
import com.posidex.prime.request.CustomerRequest;
import com.posidex.prime.request.RequestInfo;
import com.posidex.prime.response.FinalResponse;
import com.posidex.prime.response.KLILifeAsiaDataDTO;
import com.posidex.prime.response.ProcessRsponse;
import com.posidex.prime.service.CustomerRequestService;
import com.posidex.prime.utils.CustomerRequestValidator;
import com.posidex.service.IValidateService;
import com.posidex.validate.ValidUserData;

@RestController
public class ServiceController {

	private static final String FAILURE = "F";
	private static final String ERROR = "E";
	private static final String FAILUREORERRORMATCHCOUNT = "-1";
	List<ProcessRsponse> verifyList = new ArrayList<>();
	@Autowired
	IValidateService service;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private CustomerRequestService customerService;
	
	@Autowired
	private CustomerDAO Dao;

	@Autowired
	private Environment environment;
	@Autowired
	private CustomerRequestValidator validator;

	@Autowired
	ValidUserData validateUser;
	Map<String, Object> map = new HashMap<String, Object>();

	Map<String, String> errorCodesMap;
	ServletContext context;
	// CustomerResponse response;
	FinalResponse response;
	List<ProcessRsponse> presponse;
	UserModel userData;
	KotakUser kotakUSer;
	public static DropDownBean dropDownBean;
	public static DedupeInputBean dgData;
	String kotakusername;
	private static Logger logger = Logger.getLogger(ServiceController.class);

	// http://localhost:8010/posidex.crms/?Client_Id=Cid_123&JLA_ID=JLA_123&PropId=Pro_32&userId=admin&pwd=admin123
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome(@RequestParam("PID") String policy_Id, @RequestParam("USERID") String userId,
			/* @RequestParam("pwd") String pwd, */ @RequestParam("Role") String givenrole, HttpSession session)
			throws IOException, PosidexException {
		logger.info("request Obtained with URL(/) >>>");
		logger.info("Given Details :>>   PID::" + policy_Id + " USERID" + userId + " givenrole " + givenrole);
		// suresh!!@123
		String pwd = environment.getProperty("POSIDEX_PWD");
		
		
		
		// String pwd="posidex";
		userData = null;
		
		//logger.info(message);
		
		try {
			if(jdbcTemplate.getDataSource().getConnection()==null)
			{
				return new ModelAndView("ERROR","errormsg","Server Unreachable !!");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (session == null) {
			return new ModelAndView("ERROR");
		}
		// System.out.println("given URL>>>::"+givenrole);
		if (pwd == "") {
			logger.info("Due to Wrong Password !! ");
			return new ModelAndView("ERROR");
		} else {
			logger.info("Going to validate userData >>>");
			
			userData = validateUser.getValidUserData(givenrole, pwd);
			
			if(givenrole.equals("R") && userData.getPrimaryRole().equals("report")) {
				//givenrole="M";
				logger.info("Report data");
				return new ModelAndView("reportView");
				}
			
			
			kotakUSer=validateUser.getkotakUser(userId);
			if(kotakUSer!=null)	{	
			kotakusername=kotakUSer.getUSER_NAME();
			session.setAttribute("kotakUser", kotakusername);
			}
			else {
				kotakusername="";
			
			}
			//session.setAttribute("kotakUser", kotakUSer);
			session.setAttribute("userData", userData);
		}
		
		//validate userid wether existed with same policy or not
		if(givenrole.equals("C")) {
		boolean status=customerService.validateChecker(policy_Id, userId);
		if(status)
		{
			return new ModelAndView("ERROR", "errormsg", "Checker Id same as  Maker Id cannot be access !!");

		}
		}
		
		if (userData != null && kotakusername!="") {

			String role = "";
			// System.out.println(policy_Id + " " + userId + " "+givenrole);

			ClientRequestBean rqBean = new ClientRequestBean();
			rqBean.setPOLICY_NUMBER(policy_Id);
			rqBean.setClient_user_id(userId);
			rqBean.setPsdx_pwd(pwd);
			rqBean.setClientid("");
			rqBean.setGivenRole(givenrole);
			logger.info("requestData:" + rqBean);
			session.setAttribute("urlData", rqBean);
			System.out.println("************Policynumber PID********" + policy_Id);
			dropDownBean = service.getDropDownList(policy_Id);

			/*
			 * if(dropDownBean.getLIFEASSURED_ID().equals(dropDownBean.
			 * getJOINT_LIFEASSURED_ID()))
			 * 
			 * { dropDownBean.setPROPOSED_ID(dropDownBean.getJOINT_LIFEASSURED_ID());
			 * 
			 * }
			 * 
			 * else
			 * if(dropDownBean.getLIFEASSURED_ID().equals(dropDownBean.getPROPOSED_ID())) {
			 * dropDownBean.setPROPOSED_ID(dropDownBean.getJOINT_LIFEASSURED_ID()); } else
			 * if(dropDownBean.getPROPOSED_ID().equals(dropDownBean.getJOINT_LIFEASSURED_ID(
			 * ))) { dropDownBean.setPROPOSED_ID(dropDownBean.getJOINT_LIFEASSURED_ID());
			 * 
			 * }
			 */

			logger.info("DropDown List values:: " + dropDownBean);
			// System.out.println(dropDownBean);

			// boolean verified=false;
			if (dropDownBean != null) {
				session.setAttribute("dropdownList", dropDownBean);
				
				// session.setAttribute("default_policyId", dropDownBean.getLIFEASSURED_ID());
				String verifiedStatus = "";
			} else {
				logger.info("No Client Ids found with given PID Please Enter correct PID!!");
				return new ModelAndView("ERROR", "errormsg", "Client Ids not available with given policy (*_*)");

			}
			// dgData = service.getData(dropDownBean.getLIFEASSURED_ID());

			logger.info("Data Fetching>>>::");
			logger.info(dgData);
			session.setAttribute("clientID", dropDownBean.getLIFEASSURED_ID());
			ObjectWriter obj = new ObjectMapper().writer();
			String jsonResponse = obj.writeValueAsString(dgData);

			logger.info("____primary role:: >>" + userData.getPrimaryRole());

			String policy_N = String.valueOf(policy_Id);
			// List<ProcessRsponse> response = customerService.responseList(policy_N);

			/*
			 * if(response.size()>=0) { return new ModelAndView("ERROR"); }
			 */

			if (givenrole.equals("M") || givenrole.equals("C")) {
				if (givenrole.equals("M") && userData.getPrimaryRole().equals("maker")) {
					
					ModelAndView home = new ModelAndView("psdxhome");
					/*
					 * makerview.addObject("droplist", dropDownBean); makerview.addObject("dgData",
					 * dgData);
					 */
					home.addObject("userData", userData);
					kotakusername=(String)session.getAttribute("kotakUser");
					logger.info("Kotak user name");
					home.addObject("kotakUser", kotakusername);
					logger.info("returning psdxhome page>>>");
					return home;
				}

				/*
				 * if ((dgData != null) && userData.getPrimaryRole().equals("M")) { ModelAndView
				 * makerview = new ModelAndView("maker_verification2");
				 * makerview.addObject("droplist", dropDownBean);
				 * 
				 * makerview.addObject("dgData", dgData);
				 * 
				 * return makerview; }
				 */
				else if (givenrole.equals("C") && userData.getPrimaryRole().equals("checker")) {
					ModelAndView checkerView = new ModelAndView("checkerVerified");
					checkerView.addObject("droplist", dropDownBean);
					checkerView.addObject("userData", userData);
					kotakusername=(String)session.getAttribute("kotakUser");
					ClientRequestBean reqbean=(ClientRequestBean)session.getAttribute("urlData");		
					checkerView.addObject("PID", reqbean.getPOLICY_NUMBER());
					checkerView.addObject("kotakUser", kotakusername);
					logger.info("returning checker page>>>");

					return checkerView;
				}
			} else
				return new ModelAndView("ERROR");
		} else {
			logger.info("No user Data !!");
			return new ModelAndView("ERROR", "errormsg", "Invalid User Data (*_*)");

		}
		return new ModelAndView("ERROR");
	}

	// @RequestMapping(value = "/backToMakerHome", method = RequestMethod.GET)
	@RequestMapping(value = "/makerHome", method = RequestMethod.GET)
	public ModelAndView home(/*
								 * @RequestParam("PID") int policy_Id, @RequestParam("USERID") String userId,
								 * 
								 * @RequestParam("pwd") String pwd, @RequestParam("Role") String givenrole,
								 */HttpSession session) throws IOException, PosidexException {
		// suresh!!@123

		logger.info("Request /makerHome Back to Home >>>");

		UserModel sessionModel = (UserModel) session.getAttribute("userData");

		if (sessionModel == null) {
			return new ModelAndView("ERROR", "errormsg", "Session Expired (*_*)");

		}
		/*
		 * //System.out.println("given URL>>>::"+givenrole);
		 * 
		 * 
		 * logger.info("Given data ID>>: " + policy_Id + " USERID:" + userId + " Role:"
		 * + givenrole); ModelAndView mv=new ModelAndView("maker_verification2.jsp");
		 * UserModel userData = validateUser.getValidUserData(givenrole, pwd); if
		 * (userData != null) { session.setAttribute("userData", userData); String role
		 * = ""; //System.out.println(policy_Id + " " + userId + " "+givenrole);
		 * 
		 * ClientRequestBean rqBean = new ClientRequestBean();
		 * rqBean.setPOLICY_NUMBER(policy_Id); rqBean.setClient_user_id(userId);
		 * rqBean.setPsdx_pwd(pwd); rqBean.setClientid("");
		 * rqBean.setGivenRole(givenrole); logger.info("requestData:" + rqBean);
		 * session.setAttribute("urlData", rqBean);
		 * 
		 * 
		 * }
		 */

		dropDownBean = (DropDownBean) session.getAttribute("dropdownList");
		// dgData = (DedupeInputBean) session.getAttribute("dgData");
		userData = (UserModel) session.getAttribute("userData");

		ModelAndView makerview = new ModelAndView("maker_verification2");
		makerview.addObject("droplist", dropDownBean);
		// makerview.addObject("dgData", dgData);
		makerview.addObject("userData", userData);
		makerview.addObject("kotakUser", kotakusername);
		ClientRequestBean reqbean=(ClientRequestBean)session.getAttribute("urlData");
		
		makerview.addObject("PID", reqbean.getPOLICY_NUMBER());
		logger.info("maker page loading with droplist, dgData and userdata :: >>>");
		return makerview;
	}

	/**
	 * This is to obtain ajax changes from maker screen dropdown !!
	 * 
	 * @param value
	 * @param session
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 */

	@RequestMapping(value = "/inputfromdropdown", method = RequestMethod.GET)
	public String dropdownpopulate(@RequestParam("seletedvalue") String value, HttpSession session,
			HttpServletRequest request) throws JsonProcessingException {

		logger.info("Request /inputfromdropdown (String value)= " + value);
		UserRole sessionData = (UserRole) session.getAttribute("UserSession");
		System.out.println(sessionData + " session data printing here *****");
		session.setAttribute("clientID", value);
		List<ProcessRsponse> listData = customerService.getAllVerifiedData(value);
		logger.info("validating crms dedupe data from crms result table");
		logger.info(listData);
		logger.info("after changing dropdown values **");
		DedupeInputBean dgData = null;
		String dgDataJson = "";

		String verifiedJSon = "";

		/*
		 * dgData = service.getData(value); ObjectWriter ow = new
		 * ObjectMapper().writer().withDefaultPrettyPrinter(); dgDataJson =
		 * ow.writeValueAsString(dgData);
		 * 
		 * ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
		 * verifiedJSon = ow.writeValueAsString(listData); if(listData.contains("N"))
		 * return dgDataJson; else return verifiedJSon;
		 */

		/*
		 * for(ProcessRsponse pr:listData) { if(pr.getIsVerified().equals("N")) dgData =
		 * service.getData(value);
		 * 
		 * }
		 */

		// dgData = service.getData(value);
		logger.info("Not verified Data$$$$$$$$$$$$$$$$");
		List<ProcessRsponse> responseList=Dao.getAllNotVerifiedData(value);
		if(responseList.size()>0)
		{
			logger.info("If already dedupe completed redirecting to finalpage");
			return "DedupeCompleted";
			
		}
		else 
		{

		logger.info("sending dropdown values to dao>>");
	
		dgData = service.getData(value);
		
		

		logger.info("This is after changing the dropdown");
		// logger.info(dgData);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(dgData);
		logger.info("Onchange Response::" + json);
		return json;
		}
	}

	@RequestMapping(value = "/dropdownSubmit", method = RequestMethod.GET)
	public ModelAndView dropdownSubmit(HttpServletRequest request,HttpSession session) throws JsonProcessingException {

		String value=request.getParameter("Select");
		
		logger.info("seleted value from dropdown is:: "+value);
		logger.info("Request /inputfromdropdown (String value)= " + value);
		UserRole sessionData = (UserRole) session.getAttribute("UserSession");
		System.out.println(sessionData + " session data printing here *****");
		session.setAttribute("clientID", value);
		List<ProcessRsponse> listData = customerService.getAllVerifiedData(value);
		logger.info("validating crms dedupe data from crms result table");
		logger.info(listData);
		logger.info("after changing dropdown values **");
		DedupeInputBean dgData = null;
		String dgDataJson = "";

		String verifiedJSon = "";

		/*
		 * dgData = service.getData(value); ObjectWriter ow = new
		 * ObjectMapper().writer().withDefaultPrettyPrinter(); dgDataJson =
		 * ow.writeValueAsString(dgData);
		 * 
		 * ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
		 * verifiedJSon = ow.writeValueAsString(listData); if(listData.contains("N"))
		 * return dgDataJson; else return verifiedJSon;
		 */

		/*
		 * for(ProcessRsponse pr:listData) { if(pr.getIsVerified().equals("N")) dgData =
		 * service.getData(value);
		 * 
		 * }
		 */

		// dgData = service.getData(value);
		logger.info("Not verified Data$$$$$$$$$$$$$$$$");
		List<ProcessRsponse> responseList=Dao.getAllNotVerifiedData(value);
		/*if(responseList.size()>0)
		{
			logger.info("If already dedupe completed redirecting to finalpage");
			//ModelAndView mv=new ModelAndVeiw()
			//finalPage(value,session);
				
		//return "redirect:/final_page";
			return "forward:/final_page";
			
		}
		else 
			return "";*/
		logger.info(responseList);
		
		logger.info("sending dropdown values to dao>>");
	
		dgData = service.getData(value);
		logger.info("This is after changing the dropdown");
		// logger.info(dgData);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(dgData);
		logger.info("Onchange Response::" + json);
		//return json;
		logger.info("Inside final page url*****");
		dropDownBean = (DropDownBean) session.getAttribute("dropdownList");
		// dgData = (DedupeInputBean) session.getAttribute("dgData");
		userData = (UserModel) session.getAttribute("userData");

		ModelAndView makerview = new ModelAndView("maker_verification2");
		makerview.addObject("droplist", dropDownBean);
		// makerview.addObject("dgData", dgData);
		//List<ProcessRsponse> responseList=Dao.getAllNotVerifiedData(value);
		makerview.addObject("userData", userData);
		makerview.addObject("dgData", dgData);
		makerview.addObject("DedupeCompleted", true);
		ClientRequestBean reqbean=(ClientRequestBean)session.getAttribute("urlData");
		
		makerview.addObject("PID", reqbean.getPOLICY_NUMBER());
		makerview.addObject("responseList", responseList);
		
		logger.info("maker page loading with droplist, dgData and userdata :: >>>");
		return makerview;

		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@RequestMapping(value = "/final_page", method = RequestMethod.GET)

	public ModelAndView finalPage(String value,HttpSession session) {
		logger.info("Inside final page url*****");
		dropDownBean = (DropDownBean) session.getAttribute("dropdownList");
		// dgData = (DedupeInputBean) session.getAttribute("dgData");
		userData = (UserModel) session.getAttribute("userData");

		ModelAndView makerview = new ModelAndView("maker_verification2");
		makerview.addObject("droplist", dropDownBean);
		// makerview.addObject("dgData", dgData);
		List<ProcessRsponse> responseList=Dao.getAllNotVerifiedData(value);
		makerview.addObject("userData", userData);
		makerview.addObject("responseList", responseList);
		logger.info("maker page loading with droplist, dgData and userdata :: >>>");
		return makerview;

}*/
	
	/**
	 * 
	 * This method is used to obtained userinput data and insert into
	 * PSX_NSP_REQUEST and process the data
	 * 
	 * @param inputForm
	 * @param result
	 * @param session
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 * @throws PosidexException
	 */
	@RequestMapping(value = "/saveData", method = RequestMethod.POST)
	public ModelAndView processDedupeForm(@ModelAttribute("inputForm") DedupeInputBean inputForm, BindingResult result,
			HttpSession session, HttpServletRequest request) throws JsonProcessingException, PosidexException {
		logger.info("Request  /saveData URL >>>::");

		UserModel sessionModel = (UserModel) session.getAttribute("userData");

		if (sessionModel == null) {
			return new ModelAndView("ERROR", "errormsg", "Session Expired (*_*)");

		}
		logger.info("Save and Dedupe button clicked !!");
		ModelAndView mv = new ModelAndView("maker_verification2");
		DropDownBean list = (DropDownBean) session.getAttribute("dropdownList");
		mv.addObject("droplist", list);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(inputForm);

		logger.info("Save and Dedupe Form Data >>>" + json);
		long psxId = 0;
		ServletContext context = null;
		Map<String, ErrorCodeInfoDTO> errorcodes = null;
		Map<String, MRProfileInfoDTO> mrprofiles = null;

		CustomerRequest customerRequest = new CustomerRequest();
		UserModel userData = (UserModel) session.getAttribute("userData");

		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setCreationDate(new Timestamp(System.currentTimeMillis()).toString());
		requestInfo.setCreationTime(new Timestamp(System.currentTimeMillis()).toString());
		requestInfo.setDevice_uuid("UNIQUE_DEVICE_ID_287CHBE873JB");
		requestInfo.setLastSyncDate(new Timestamp(System.currentTimeMillis()).toString());
		requestInfo.setRequestorToken("4312");
		requestInfo.setSource("GUI");
		requestInfo.setTransactionId("TransactionId");
		requestInfo.setSourceInfoName("GUI");
		// requestInfo.setUserEmail(userData.getEmail());
		requestInfo.setUserName(userData.getFullName());
		String sessionClientID = (String) session.getAttribute("clientID");
		requestInfo.setClient_Id(sessionClientID);
		System.out.println("session client ID" + sessionClientID);
		System.out.println("requestInfo object================");
		System.out.println(requestInfo);
		logger.info("session ClientID" + sessionClientID);
		try {
			logger.info("Fetching PSXID Sequence ");
			psxId = customerService.getPsxIdFromSequence(environment.getProperty("sequence.name"));
			logger.info("PSxId from Sequence >>>::" + psxId);
			session.setAttribute("PSX_ID", psxId + "");
			if (psxId == 0)
				throw new PosidexException("psxid not generated");
		} catch (Exception e) {
			logger.error("Got exception while generating psxId in Posidex Sequence :: " + e.getMessage());
			e.printStackTrace();
		}
		context = request.getServletContext();
		errorcodes = (Map<String, ErrorCodeInfoDTO>) context.getAttribute("errorcodes");
		mrprofiles = (Map<String, MRProfileInfoDTO>) context.getAttribute("MRProfileInfoMap");
		/*
		 * try { validator.validateCustomerRequest(customerRequest, mrprofiles); } catch
		 * (Exception e) {
		 * logger.error("Got exception while Validating the request and Dob :: " +
		 * e.getMessage()); e.printStackTrace(); }
		 */
		ClientRequestBean sessionReq = (ClientRequestBean) session.getAttribute("urlData");
		String sourceClient = sessionReq.getClientid();
		String policynum = String.valueOf(sessionReq.getPOLICY_NUMBER());
		System.out.println("sourceClientID  " + sourceClient + "    policy   " + policynum);
		logger.info("policyId" + policynum + "  sourceClient" + sourceClient);
		inputForm.setCRMS_CLIENT_ID(sessionClientID);
		inputForm.setCLIENT_ID(sessionClientID);
		inputForm.setPOLICY_NUMBER(policynum);
		// ClientRequestBean rqBean=(ClientRequestBean)session.getAttribute("urlData");
		String givenRole = sessionReq.getGivenRole();
		String givenClientUSerID = sessionReq.getClient_user_id();
		UserModel sessionUser = (UserModel) session.getAttribute("userData");
		logger.info("inserting session USERID>> ::" + givenClientUSerID);
		if (givenRole.equals("M") && sessionUser.getPrimaryRole().equals("maker"))
			inputForm.setMAKER_ID(givenClientUSerID);
		else
			inputForm.setMAKER_ID("");

		if (givenRole.equals("C") && sessionUser.getPrimaryRole().equals("checker"))
			inputForm.setCHECKER_ID(givenClientUSerID);
		else
			inputForm.setCHECKER_ID("");
		logger.info("Before Insert  complete Inputdata from controller >> ::" + inputForm);

		logger.info("Fetching ProfileId form Prop File >>> ::");
		String profileId = environment.getProperty("PSX_NSP_PROFILE_ID");
		logger.info("Given Profile ID::" + profileId);
		MRProfileInfoDTO mpdto = mrprofiles.get(profileId);

		if (mpdto == null) {
			mv.addObject("processMessage", "No Matches found due to wrong profile ID !!");

			return mv;

		}

		logger.info("Given  Profile Id  ???_" + mpdto.getProfileId() + "__");
		logger.info(mpdto);

		inputForm.setPROFILE_ID(profileId);

		String matchingRule = mpdto.getMatchingRuleCSV();
		/*
		 * Insert given details *********************
		 */

		try {
			int count = customerService.insertRequestDetails(inputForm, requestInfo, psxId);
			if (count < 0)
				throw new PosidexException("error while inserting the request data");
		} catch (Exception e) {
			logger.error("Got exception In insertRequestDetails method :: " + e.getMessage());
			e.printStackTrace();
			throw new PosidexException(e.getMessage());
		}

		// Validating wether dedup done or not !!
		try {
			boolean status = customerService.verifyClientID(sessionClientID);
		} catch (Exception e) {
			throw new PosidexException(e.getMessage());
		}

		/*
		 * building Engine Request
		 */
		try {
			logger.info("Build Engine ProcessRequest >> ::");
			customerService.processRequestDetails(inputForm, requestInfo, psxId, mpdto);
			logger.info("ProcessRequest completed from controller!!");
		} catch (Exception e) {
			logger.error("Got exception In processRequestDetails method :: " + e.getMessage());
			e.printStackTrace();
		}

		errorCodesMap = (Map<String, String>) context.getAttribute("errorcodes");

		String Psx_ID = String.valueOf(psxId);

		/*
		 * Getting Match Result
		 */
		try {

			// presponse = getReponse(sessionClientID, errorCodesMap);

			logger.info("from Controller PSXID" + psxId);
			presponse = getReponse(psxId + "", errorCodesMap);
			logger.info("After dedupe matching data is ");
			logger.info(presponse);

		} catch (Exception e) {
			e.printStackTrace();

		}
		logger.info("##################After Processing Response from controller ::####################");

		logger.info(presponse);
		if (presponse.isEmpty() || presponse.size() == 0) {
			mv.addObject("processMessage", "No Matches found at this time !!");

		}
		ClientRequestBean reqbean=(ClientRequestBean)session.getAttribute("urlData");
		
		mv.addObject("PID", reqbean.getPOLICY_NUMBER());
		mv.addObject("responseList", presponse);
		mv.addObject("DedupeCompleted", false);

		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String responseJson = writer.writeValueAsString(response);
		logger.info("------------------return json response from controller-------------");
		logger.info(responseJson);
		logger.info("--------------------------------");

		logger.info("_________dropdown value___________");

		logger.info(list);
		logger.info("_________dropdown value___________");

		// String default_Id = (String) session.getAttribute("default_policyId");

		// DedupeInputBean dgData = service.getData(default_Id);
		logger.info("SaveData and Matching Process Complete from controller !!");
		// map.put("dgData", dgData);
		// mv.addObject("response",responseJson);

		// mv.addObject("dgData", dgData);
		return mv;// new ModelAndView("maker_verification2", "droplist", list);
	}

	/**
	 * Here we are getting seleted checkbox data and radiobutton data From maker Screen
	 * 
	 * @param value
	 * @param session
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 */

	@RequestMapping(value = "/getCheckBoxData", method = RequestMethod.POST)
	public String checkBoxData(@RequestBody List<Object> value, HttpSession session, HttpServletRequest request)
			throws JsonProcessingException {

		List<GetCheckBoxData> listData = null;
		logger.info("Obtained :: /getCheckBoxData >>>");
		logger.info(" Input checkbox data>>>");
		
		// List<GetCheckBoxData> data=(List<GetCheckBoxData>)value;
		// System.out.println("CheckBoxData from " + data.getCrmsclientid());
		/*
		 * for (GetCheckBoxData person : data) {
		 * System.out.println(person.getCrmsclientid()); }
		 */
		// customerService.updateVerify(data);
		// System.out.println(dgData);
		
		ClientRequestBean req=(ClientRequestBean)session.getAttribute("urlData");
		String user_id=req.getClient_user_id();
		logger.info("Maker USER_ID: >>>>"+user_id);

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(value);
		logger.info("Selected Checkbox and radio button  json data::  >>" + json);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			listData = objectMapper.readValue(json, new TypeReference<List<GetCheckBoxData>>() {
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("From controller sending seleted checkbox data to DAO");
		customerService.updateVerify(listData,user_id);
		return json;
	}

	/*
	 * This is calling from another controller method to get response::
	 */
	public List<ProcessRsponse> getReponse(String requestId, Map<String, String> errodcode)
			throws DAOException, PosidexException {
		logger.info("Inside getResponse method -->>    " + requestId);
		
		try {
			// context = request.getServletContext();
			// response = new CustomerResponse();
			response = new FinalResponse();
			logger.info(errorCodesMap);
			customerService.validateRequestId(requestId);

			logger.info("from service controller ");
			presponse = customerService.getCustomerResults(requestId, errorCodesMap);
			logger.info("Respone:: " + response);
		} catch (PosidexException pex) {
			logger.error("got error in get response " + pex.getMessage());
		} catch (Exception dsex) {
			logger.error("Error While executing operation(PosidexService.getResponse)" + dsex.getMessage());
			if (dsex.getMessage().contains("Closed Connection")) {
				// response = buildFindCustomerErrorResponse(response, requestId, "Closed
				// Connection!", ERROR,
				// FAILUREORERRORMATCHCOUNT,
				// Integer.parseInt(errorCodesMap.get("INTERNALEXCEPTION")));
			} else {

				// response = buildFindCustomerErrorResponse(response, "-1", dsex.getMessage(),
				// ERROR,
				// FAILUREORERRORMATCHCOUNT,
				// Integer.parseInt(errorCodesMap.get("INTERNALEXCEPTION")));
			}
			return presponse;
		}
		return presponse;
	}

	/**
	 * This is for seleted view TAB
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/selectedview", method = RequestMethod.GET)
	public ModelAndView seletedView(HttpSession session) {

		UserModel sessionModel = (UserModel) session.getAttribute("userData");
		if (sessionModel == null) {
			return new ModelAndView("ERROR", "errormsg", "Session Expired (*_*)");

		}
		logger.info("Request /selectedView obtained >>");
		// dropDownBean = (DropDownBean) session.getAttribute("dropdownList");
		ModelAndView mv = new ModelAndView("selectedview");
		// dropDownBean = (DropDownBean) session.getAttribute("dropdownList");// ,
		// dropDownBean);
		// mv.addObject("response", presponse);

		ClientRequestBean sessionReq = (ClientRequestBean) session.getAttribute("urlData");
		dropDownBean = service.getDropDownList(sessionReq.getPOLICY_NUMBER());
		ClientRequestBean reqbean=(ClientRequestBean)session.getAttribute("urlData");
		
		mv.addObject("PID", reqbean.getPOLICY_NUMBER());
		mv.addObject("droplist", dropDownBean);
		// mv.addObject("dgData", dgData);
		return mv;

	}

	/**
	 * This is from seleted View page to get value
	 * 
	 * @param value
	 * @param session
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/verifiedinputfromdropdown", method = RequestMethod.GET)
	public String getdropdownpopulate(@RequestParam("seletedvalue") String value, HttpSession session,
			HttpServletRequest request) throws JsonProcessingException {
		logger.info("Request /verifiedinputfromdropdown  obtained >>");
		logger.info("Seleted value is  :" + value);
		UserRole sessionData = (UserRole) session.getAttribute("UserSession");
		List<ProcessRsponse> listData = customerService.getAllVerifiedData(value);
		logger.info("Seleted Response from selected view page onchange::");
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(listData);
		logger.info("********************************************");
		System.out.println(json);
		logger.info("********************************************");
		return json;
	}

	/**
	 * Temporary not using
	 * 
	 * @param clientId
	 * @return
	 */
	@RequestMapping(value = "/selectedValue", method = RequestMethod.GET)
	public ModelAndView getSeletedData(@RequestParam("id") String clientId,HttpSession session) {
		logger.info("seleted value from controller>>>>>::" + clientId);
		ModelAndView mv = new ModelAndView("selectedView");
		ClientRequestBean reqbean=(ClientRequestBean)session.getAttribute("urlData");		
		mv.addObject("PID", reqbean.getPOLICY_NUMBER());
		return mv;
	}

	/**
	 * Temporary method not in use
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/makerScreen", method = RequestMethod.GET)
	public ModelAndView backMakerScreen(HttpSession session) {
		ClientRequestBean rqbean = (ClientRequestBean) session.getAttribute("urlData");
		System.out.println("seleted value from controller>>>>>");
		ModelAndView mv = new ModelAndView("selectedView");
		ClientRequestBean reqbean=(ClientRequestBean)session.getAttribute("urlData");		
		mv.addObject("PID", reqbean.getPOLICY_NUMBER());
		return mv;
	}

	/**
	 * to load checker Data
	 * 
	 * @param value
	 * @param session
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/onchangeGetCheckerData", method = RequestMethod.GET)
	public String getCheckerDropdown(@RequestParam("seletedvalue") String value, HttpSession session,
			HttpServletRequest request) throws JsonProcessingException {
		logger.info("Request  /onchangeGetCheckerData  Obtained >>>");
		logger.info("Given value from checker dropdown (String value)= " + value);
		UserRole sessionData = (UserRole) session.getAttribute("UserSession");
		List<ProcessRsponse> listData = customerService.loadCheckerData(value);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(listData);
		logger.info("********************************************");
		logger.info(json);
		logger.info("********************************************");
		return json;
	}

	/**
	 * delete seleted checbox data from checker screen !!
	 * 
	 * @param value
	 * @param session
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/deleteSeletedCheckBox", method = RequestMethod.POST)
	public String deletecheckBoxData(@RequestBody List<Object> value, HttpSession session, HttpServletRequest request)
			throws JsonProcessingException {
		logger.info("Request /deleteSeletedCheckBox Obtained");
		List<GetCheckBoxData> listData = null;
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(value);
		logger.info("Given seleted data to delete >> :: ");
		logger.info("*****************************");
		logger.info(json);
		logger.info("*****************************");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			listData = objectMapper.readValue(json, new TypeReference<List<GetCheckBoxData>>() {
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Sending data DAO IMPL to delete");
		boolean deletestatus = customerService.deleteSeleted(listData);
		return json;
	}

	/**
	 * This is for rejectCheckBoxData from checkerScreen !!
	 * 
	 * @param value
	 * @param session
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/rejectSeletedCheckBox", method = RequestMethod.POST)
	public String rejectcheckBoxData(@RequestBody List<Object> value, HttpSession session, HttpServletRequest request)
			throws JsonProcessingException {
		logger.info("Request /rejectSeletedCheckBox Obtained >> ");
		List<GetCheckBoxData> listData = null;
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(value);
		logger.info("Given seleted data to Reject >> :: ");
		logger.info("*****************************");
		logger.info(json);
		logger.info("*****************************");
		ObjectMapper objectMapper = new ObjectMapper();
		ClientRequestBean req=(ClientRequestBean)session.getAttribute("urlData");
		String user_id=req.getClient_user_id();
		
		try {
			listData = objectMapper.readValue(json, new TypeReference<List<GetCheckBoxData>>() {
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Sending to to DAO IMPL to Reject");
		boolean deletestatus = customerService.rejectSeleted(listData,user_id);
		return json;
	}

	/**
	 * This is for Approve Seleted Data from checker screen !!
	 * 
	 * @param value
	 * @param session
	 * @param request
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/approveSeletedCheckBox", method = RequestMethod.POST)
	public String approvecheckBoxData(@RequestBody List<Object> value, HttpSession session, HttpServletRequest request)
			throws JsonProcessingException {
		logger.info("Approve Seleted checkboxdata !!");		
		logger.info("Request  /approveSeletedCheckBox Obtained >>>::");
		List<GetCheckBoxData> listData = null;
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(value);
		logger.info("Given seleted data to Approve >> :: ");
		logger.info("*****************************");
		logger.info(json);
		logger.info("*****************************");
		
		ClientRequestBean req=(ClientRequestBean)session.getAttribute("urlData");
		String user_id=req.getClient_user_id();
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			listData = objectMapper.readValue(json, new TypeReference<List<GetCheckBoxData>>() {

			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Input data from  form *************");
		logger.info(listData);
		logger.info("Sending data to ServiceImpl for Seleted Approve !!");
		LifeAsiaSucessAndErrorResponses sucecessAndErrorResults = customerService.approveSeleted(listData,user_id);
		logger.info("the approveSeleted status from controller:: "+sucecessAndErrorResults);
		
		
	/*	/////////////////
		List<LifeAsiaResponseMessageBean> mergeErrorResponseList=new ArrayList<>();
		List<LifeAsiaResponseMessageBean> mergeSuccessResponseList=new ArrayList<>();
		LifeAsiaSucessAndErrorResponses sucecessAndErrorResults=new LifeAsiaSucessAndErrorResponses();
		LifeAsiaResponseMessageBean opMerge=null;
		for(int i=0;i<8;i++) {
			opMerge=new LifeAsiaResponseMessageBean();
			if(i<1)
			{	logger.info("LA Response when ERROR_CODE is Not Null>>>>");
				logger.info("Preparing Error Response object ");
				opMerge.setRetainedClientNumber("retainnum00"+i);
				opMerge.setMergeClientNumber("mergeclientnum00"+i);
				opMerge.setPolicyNumber("policynum00"+i);
				opMerge.setErrorCode("300");
				opMerge.setErrorDescription("while merging got an error");
				mergeErrorResponseList.add(opMerge);
				logger.info("LA Status Error response List :>>"+mergeErrorResponseList);	
			}
			else 
			{
				logger.info("LA Response when getFlag is Not Null>>>>");
				logger.info("Preparing Success Response object ");
				opMerge.setRetainedClientNumber("retainclinetnumber00"+i);
				opMerge.setMergeClientNumber("merclinetnum00"+i);
				opMerge.setPolicyNumber("policynum00"+i);
				opMerge.setFlag("flag");
				mergeSuccessResponseList.add(opMerge);
				logger.info("LA Status success response List :>>"+mergeSuccessResponseList);	

			}
		
			
			System.out.println("the record count is  "+i);
			System.out.println("the merge errorlist is"+mergeErrorResponseList);
			System.out.println("the merge success list is"+mergeSuccessResponseList);
		
	}
	
	sucecessAndErrorResults.setMergeErrorResponseList(mergeErrorResponseList);
	sucecessAndErrorResults.setMergeSuccessResponseList(mergeSuccessResponseList);
	logger.info("Success And Error Results ::"+mergeErrorResponseList);
	logger.info("Success And Error Results ::"+mergeSuccessResponseList);
	
	ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
	//LAtatusMessage = ow.writeValueAsString(MergeresponseList);
	//String LAtatusMessage = ow1.writeValueAsString(sucecessAndErrorResults);
		//logger.info("LAtatusMessage"+LAtatusMessage);
		
		////////////////////////
*/		
		ArrayList list =new ArrayList<>();
		
		logger.info("the request_id for fetching LA table"+listData.get(0).getRequestid());
		List<KLILifeAsiaDataDTO> kliList= customerService.getKLiLifeAsiaRecords(listData.get(0).getRequestid());
		list.add(sucecessAndErrorResults);
		list.add(kliList);
		ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String kliTableSelectedRecords = ow2.writeValueAsString(list);
		
		logger.info("approveselected  "+kliTableSelectedRecords);
		return kliTableSelectedRecords;
	}

	@RequestMapping(value = "/landing", method = RequestMethod.GET)
	public ModelAndView rejectcheckBoxData() {
		return new ModelAndView("ERROR");
	}

	@RequestMapping(value = "/getSeletedValue", method = RequestMethod.GET)
	public ModelAndView getSeletedValue(HttpServletRequest request, HttpSession session) {
		String selectedValue = request.getParameter("Select");

		if (session == null) {
			return new ModelAndView("ERROR", "errormsg", "Session Expired (*_*)");
		}
		System.out.println(selectedValue);

		String psxid = (String) session.getAttribute("PSX_ID");
		List<ProcessRsponse> listData = customerService.getAllVerifiedData(selectedValue);

		// listData= listData.stream().filter( distinctByKey(p -> p.getCRMS_CLIENT_ID())
		// ).collect( Collectors.toList() );

		ModelAndView mv = new ModelAndView("selectedview");
		ClientRequestBean reqbean=(ClientRequestBean)session.getAttribute("urlData");		
		mv.addObject("PID", reqbean.getPOLICY_NUMBER());
		mv.addObject("droplist", dropDownBean);
		mv.addObject("responseList", listData);
		logger.info("======================================");
		return mv;
	}

	@RequestMapping(value = "/getSeletedValueForChecker", method = RequestMethod.GET)
	public ModelAndView getSeletedValueforchecker(HttpServletRequest request, HttpSession session) {
		String selectedValue = request.getParameter("Select");
		System.out.println(selectedValue);
		UserModel sessionModel = (UserModel) session.getAttribute("userData");
		if (sessionModel == null) {
			return new ModelAndView("ERROR", "errormsg", "Session Expired (*_*)");
		}

		
		
		List<ProcessRsponse> listData = customerService.loadCheckerData(selectedValue);
		//List<KLILifeAsiaDataDTO> kliList= customerService.getKLiLifeAsiaRecords(selectedValue);
		ModelAndView mv = new ModelAndView("checkerVerified");
		ClientRequestBean reqbean=(ClientRequestBean)session.getAttribute("urlData");		
		mv.addObject("PID", reqbean.getPOLICY_NUMBER());
		mv.addObject("droplist", dropDownBean);
		mv.addObject("responseList", listData);
		//mv.addObject("kliDtoList", kliList);
		logger.info("======================================");
		return mv;
	}

	/*
	 * //@RequestMapping(value = "/backToMakerHome", method = RequestMethod.GET)
	 * 
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public ModelAndView
	 * home(@RequestParam("PID") int policy_Id, @RequestParam("USERID") String
	 * userId,
	 * 
	 * @RequestParam("pwd") String pwd, @RequestParam("Role") String
	 * givenrole,HttpSession session) throws IOException, PosidexException { //
	 * suresh!!@123 String pwd="posidex";
	 * logger.info("request Obtained with URL(/) >>>");
	 * 
	 * //System.out.println("given URL>>>::"+givenrole);
	 * 
	 * 
	 * logger.info("Given data ID>>: " + policy_Id + " USERID:" + userId + " Role:"
	 * + givenrole); ModelAndView mv=new ModelAndView("maker_verification2.jsp");
	 * UserModel userData = validateUser.getValidUserData(givenrole, pwd); if
	 * (userData != null) { session.setAttribute("userData", userData); String role
	 * = ""; //System.out.println(policy_Id + " " + userId + " "+givenrole);
	 * 
	 * ClientRequestBean rqBean = new ClientRequestBean();
	 * rqBean.setPOLICY_NUMBER(policy_Id); rqBean.setClient_user_id(userId);
	 * rqBean.setPsdx_pwd(pwd); rqBean.setClientid("");
	 * rqBean.setGivenRole(givenrole); logger.info("requestData:" + rqBean);
	 * session.setAttribute("urlData", rqBean);
	 * 
	 * 
	 * } else return new ModelAndView("ERROR");
	 * 
	 * return mv; }
	 */
	
	

	@RequestMapping(value = "/getReport", method = RequestMethod.POST)
	public ModelAndView getReport(HttpServletRequest request, HttpSession session) {
		String date = request.getParameter("daterange");
		String option=request.getParameter("SelectReport");
		System.out.println("date report **************");
		System.out.println("given option report **************"+option);
		System.out.println(date);

		String[] dates=date.split("To");
		String startDate=dates[0];
		String toDate=dates[1];
		System.out.println(startDate+"  "+toDate);
		List<DedupeReport> reportList=null;
		List<MISReport> misreportList=null;
		UserModel sessionModel = (UserModel) session.getAttribute("userData");
		/*if (sessionModel == null) {
			return new ModelAndView("ERROR", "errormsg", "Session Expired (*_*)");
		}*/
		String seletedvalue="";
		
		//dropDownBean = (DropDownBean) session.getAttribute("dropdownList");
		// dgData = (DedupeInputBean) session.getAttribute("dgData");
		userData = (UserModel) session.getAttribute("userData");

		ModelAndView repotrview = new ModelAndView("reportView");
		if(option.equals("dedupereport"))
		{
			reportList=customerService.getDedupeReport(startDate, toDate);
			repotrview.addObject("userData", userData);
			repotrview.addObject("responseList", reportList);
			return repotrview;
			}
	
		
		else if(option.equals("misreport")) {
			misreportList=customerService.getMisReport(startDate, toDate);
			repotrview.addObject("userData", userData);
			repotrview.addObject("misreportList", misreportList);
			return repotrview;
		}
		
		
		//repotrview.addObject("droplist", dropDownBean);
		// makerview.addObject("dgData", dgData);
		repotrview.addObject("userData", userData);
		repotrview.addObject("responseList", reportList);
		logger.info("maker page loading with droplist, dgData and userdata :: >>>");
		return repotrview;
	}
	
	
	@RequestMapping(value = "/noAction", method = RequestMethod.GET)
	public boolean noActionRequired(@RequestParam("sourceClientId") String sourceClientId ,HttpServletRequest request, HttpSession session) {
		logger.info("noAction url from controller >>>");
		logger.info("sourceClientId ::"+sourceClientId);
		UserModel sessionModel = (UserModel) session.getAttribute("userData");
		if (sessionModel == null) {
			//return new ModelAndView("ERROR", "errormsg", "Session Expired (*_*)");
		}
		boolean status =customerService.noActionRequired(sourceClientId);
		
		logger.info("======================================");
		return status;
	}
	
	@PostMapping(value="sendingErrorecodatoMaker",consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean updateRecordsForMakerPage(@RequestBody LifeAsiaSucessAndErrorResponses mergeErrorResponse) {
		
		boolean flag=false;
		System.out.println("sdhgfjdsgfgds");
		System.out.println("the error response list is "+ mergeErrorResponse.getUserId()+"::::"+mergeErrorResponse.getRequestId());
		flag=customerService.updateErrorRecordsForMakerPage(mergeErrorResponse);
		
		return flag;
		
	}
	
	
	@GetMapping(value="crmsClientIdDedupeVerification/{clinetRole}/{crmsClientId}")
	public String crmsClientStatusVerification(@PathVariable String clinetRole,@PathVariable String crmsClientId,HttpSession httpSession) throws DAOException, PosidexException {
		//[PROPOSED_ID=6100153, LIFEASSURED_ID=6100154, JOINT_LIFEASSURED_ID=6100143, CLIENT_ID=null, PROPOSAL_NUMBER=101]
		
		String str="";
		System.out.println("dropDownBean"+dropDownBean);
		DropDownBean dropDownBean123=(DropDownBean) httpSession.getAttribute("dropdownList");
		
		System.out.println("dropDownBean123  "+dropDownBean123);
		//var ss=<%= Session["dropdownList"] %>
		System.out.println("the crms client id is "+crmsClientId);
		int crmsClientstatus=0;
		;
		try {
			
		if(!crmsClientId.equalsIgnoreCase(dropDownBean.getJOINT_LIFEASSURED_ID())) {	
			
		 int i=customerService.checkDedupeVerificationforChecker(dropDownBean.getJOINT_LIFEASSURED_ID(),clinetRole);
		 if(i==0) {				
			 str=str+dropDownBean.getJOINT_LIFEASSURED_ID();
			}
		
		}
		if(!crmsClientId.equalsIgnoreCase(dropDownBean.getLIFEASSURED_ID())) {
			int i=customerService.checkDedupeVerificationforChecker(dropDownBean.getLIFEASSURED_ID(),clinetRole);
			
			 if(i==0) {	
				 if(str.length()>0)
				 str=str+","+dropDownBean.getLIFEASSURED_ID();
				 else
					 str=str+dropDownBean.getLIFEASSURED_ID(); 
				}
		}
		
		if(!crmsClientId.equalsIgnoreCase(dropDownBean.getPROPOSED_ID())) {
			int i=customerService.checkDedupeVerificationforChecker(dropDownBean.getPROPOSED_ID(),clinetRole);
			 if(i==0) {	
				 if(str.length()>0)
				 str=str+","+dropDownBean.getPROPOSED_ID();
				 else
					 str=str+dropDownBean.getPROPOSED_ID();
				}
		}
	
		 str = str.replace("null,", "");
		 str = str.replace("null", "");
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		 str = ow.writeValueAsString(str);
		}
		catch(DAOException e){
			e.printStackTrace();
			if(e.getMessage().contains("SQL must not be null")) {
				logger.warn("only source retain and selected");
			}else {
			throw new DAOException("while checking more dedupe cases got an error");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("e.getMessage "+e.getMessage());
			if(e.getMessage().contains("SQL must not be null")) {
				logger.warn("only source retain and selected");
			}else {
				throw new PosidexException("while checking more dedupe cases got an error");
			}
			
		}
		
		if(str.length()==0) {
			str="000";
		}
		
		System.out.println("the output is "+str);
		return str;
	}
	//For Checker Selecte view::
	@RequestMapping(value = "/checkerSelectedview", method = RequestMethod.GET)
	public ModelAndView checkerSelectedview(HttpSession session) {

		UserModel sessionModel = (UserModel) session.getAttribute("userData");
		if (sessionModel == null) {
			return new ModelAndView("ERROR", "errormsg", "Session Expired (*_*)");

		}
		logger.info("Request /CheckerselectedView obtained >>");
		// dropDownBean = (DropDownBean) session.getAttribute("dropdownList");
		ModelAndView mv = new ModelAndView("Checker_selectedview");
		// dropDownBean = (DropDownBean) session.getAttribute("dropdownList");// ,
		// dropDownBean);
		// mv.addObject("response", presponse);

		ClientRequestBean sessionReq = (ClientRequestBean) session.getAttribute("urlData");
		//DropDownBean drop=(DropDownBean)session.getAttribute("dropDownBean");
		dropDownBean = (DropDownBean) session.getAttribute("dropdownList");
		logger.info("session value drop down values for checker seleted values:"+dropDownBean.toString());
		
		dropDownBean = service.getDropDownList(sessionReq.getPOLICY_NUMBER());
		ClientRequestBean reqbean=(ClientRequestBean)session.getAttribute("urlData");
		
		mv.addObject("PID", reqbean.getPOLICY_NUMBER());
		mv.addObject("droplist", dropDownBean);
		// mv.addObject("dgData", dgData);
		return mv;

	}
	
	@RequestMapping(value = "/c_selectedview_opdownsubmit", method = RequestMethod.GET)
	public ModelAndView checkerSelectedDropdown(HttpServletRequest request, HttpSession session) {
		String selectedValue = request.getParameter("Select");

		if (session == null) {
			return new ModelAndView("ERROR", "errormsg", "Session Expired (*_*)");
		}
		System.out.println(selectedValue);

		String psxid = (String) session.getAttribute("PSX_ID");
	//	List<ProcessRsponse> listData = customerService.getAllVerifiedData(selectedValue);
		List<ProcessRsponse> listData = customerService.getAllCheckerSelectedData(selectedValue);
		// listData= listData.stream().filter( distinctByKey(p -> p.getCRMS_CLIENT_ID())
		// ).collect( Collectors.toList() );

		ModelAndView mv = new ModelAndView("Checker_selectedview");
		ClientRequestBean reqbean=(ClientRequestBean)session.getAttribute("urlData");		
		mv.addObject("PID", reqbean.getPOLICY_NUMBER());
		mv.addObject("droplist", dropDownBean);
		mv.addObject("responseList", listData);
		logger.info("======================================");
		return mv;
	}
	
	@RequestMapping(value = "/checkerHome", method = RequestMethod.GET)
	public ModelAndView checkerHome(/*
								 * @RequestParam("PID") int policy_Id, @RequestParam("USERID") String userId,
								 * 
								 * @RequestParam("pwd") String pwd, @RequestParam("Role") String givenrole,
								 */HttpSession session) throws IOException, PosidexException {
		// suresh!!@123

		logger.info("Request /makerHome Back to Home >>>");

		UserModel sessionModel = (UserModel) session.getAttribute("userData");

		if (sessionModel == null) {
			return new ModelAndView("ERROR", "errormsg", "Session Expired (*_*)");

		}
		/*
		 * //System.out.println("given URL>>>::"+givenrole);
		 * 
		 * 
		 * logger.info("Given data ID>>: " + policy_Id + " USERID:" + userId + " Role:"
		 * + givenrole); ModelAndView mv=new ModelAndView("maker_verification2.jsp");
		 * UserModel userData = validateUser.getValidUserData(givenrole, pwd); if
		 * (userData != null) { session.setAttribute("userData", userData); String role
		 * = ""; //System.out.println(policy_Id + " " + userId + " "+givenrole);
		 * 
		 * ClientRequestBean rqBean = new ClientRequestBean();
		 * rqBean.setPOLICY_NUMBER(policy_Id); rqBean.setClient_user_id(userId);
		 * rqBean.setPsdx_pwd(pwd); rqBean.setClientid("");
		 * rqBean.setGivenRole(givenrole); logger.info("requestData:" + rqBean);
		 * session.setAttribute("urlData", rqBean);
		 * 
		 * 
		 * }
		 */

		dropDownBean = (DropDownBean) session.getAttribute("dropdownList");
		// dgData = (DedupeInputBean) session.getAttribute("dgData");
		userData = (UserModel) session.getAttribute("userData");

		ModelAndView makerview = new ModelAndView("checkerVerified");
		makerview.addObject("droplist", dropDownBean);
		// makerview.addObject("dgData", dgData);
		makerview.addObject("userData", userData);
		makerview.addObject("kotakUser", kotakusername);
		ClientRequestBean reqbean=(ClientRequestBean)session.getAttribute("urlData");
				makerview.addObject("PID", reqbean.getPOLICY_NUMBER());
		logger.info("maker page loading with droplist, dgData and userdata :: >>>");
		return makerview;
	}
	
	
	
}
