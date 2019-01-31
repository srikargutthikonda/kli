package com.posidex.prime.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.posidex.appconfig.SendAndReceiveJMSMessage;
import com.posidex.bean.DedupeInputBean;
import com.posidex.bean.DedupeReport;
import com.posidex.bean.GetCheckBoxData;
import com.posidex.bean.LifeAsiaResponseMessageBean;
import com.posidex.bean.LifeAsiaSucessAndErrorResponses;
import com.posidex.bean.MISReport;
import com.posidex.exception.PosidexException;
import com.posidex.lifeasia.client.service.KotakWebserviceCallingdServiceImpl;
import com.posidex.lifeasia.stub.ClientMergeESBRequest;
import com.posidex.lifeasia.stub.ClientMergeESBRequest.Data;
import com.posidex.lifeasia.stub.ClientMergeESBRequest.Header;
import com.posidex.lifeasia.stub.ClientMergeESBResponse;
import com.posidex.lifeasia.test.LifeAsiaTestClient;
import com.posidex.prime.common.dto.MRProfileInfoDTO;
import com.posidex.prime.dao.CustomerDAO;
import com.posidex.prime.enginerequest.Prime360CommonTable;
import com.posidex.prime.enginerequest.Prime360Request;
import com.posidex.prime.enginerequest.Prime360RequestInfo;
import com.posidex.prime.exception.DAOException;
import com.posidex.prime.request.RequestInfo;
import com.posidex.prime.response.CustomerResponse;
import com.posidex.prime.response.KLILifeAsiaDataDTO;
import com.posidex.prime.response.ProcessRsponse;
import com.posidex.prime.service.CustomerRequestService;

@Service
public class CustomerRequestServiceImpl implements CustomerRequestService {

	private static Logger logger = Logger.getLogger(CustomerRequestServiceImpl.class);
	private static final String ACTIVEMQ_ERROR = "ActiveMQ is Down!!";
	private static final String DB_ERROR = "Database Error!!";
	private static final String INTERNAL_ERROR = "Internal Error!";
	private static final String PROCESS_COMPLETED = "Process Completed";
	private static final String RESOURCE_ARE_BUSY = "Resources are busy!";
	private static final String CHECK_PRIMEMATCH = "Check PrimeMatch/ActiveMQ Service";
	private static final String REQUEST_EXISTS = "RequestId already existed!!";
	private static final String SUCCESS = "S";
	private static final String PENDING = "P";
	private static final String FAILURE = "F";
	private static final String ERROR = "E";

	List<String> LAsuccessList = null;
	List<String> LAErrorList = null;

	@Autowired
	private CustomerDAO customerRequestDao;

	@Autowired
	private Prime360Request request;

	@Autowired
	private Prime360RequestInfo requestInfo;

	@Autowired
	private Prime360CommonTable commonRequestData;

	@Autowired
	private KotakWebserviceCallingdServiceImpl clientMergeService;

	/*
	 * @Autowired private SendAndReceiveJMSMessage jmsMessage;
	 */

	@Autowired
	private Environment environment;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private SendAndReceiveJMSMessage jmsMessage;

	@Override
	public int insertRequestDetails(DedupeInputBean customerRequest, RequestInfo info, long psxId) throws Exception {

		return customerRequestDao.insertRequestDetails(customerRequest, info, psxId);
	}

	@Override
	public Long getPsxIdFromSequence(String sequenceName) {
		return customerRequestDao.getPsxIdFromSequence(sequenceName);
	}

	@Override
	public void processRequestDetails(DedupeInputBean customerRequest, RequestInfo info, long psxId,
			MRProfileInfoDTO mpdto) throws Exception {

		logger.info("-------processRequestDetails ()----------");
		logger.info("customerREquest formData : " + customerRequest);
		logger.info("RequestInfoData formData : " + info);
		logger.info("PsxId formData : " + psxId);
		// logger.info("Matchingrule : "+matchingRule);

		try {
			String clinetMessage = buildClientMessage(customerRequest, requestInfo, psxId, mpdto);

			logger.info("------------------Before sending request client Message-----------------------------");
			logger.info(clinetMessage);

			logger.info("-----------------------------------------------");

			jmsMessage.sendMessage(clinetMessage, psxId);

			System.out.println("__________message sent successfully!!______ ");

			/*
			 * TextMessage receviedMessage =(TextMessage)jmsMessage.receiveMessage(psxId);
			 * if(receviedMessage!=null) {
			 * System.out.println("Recevied selected message is:: "+receviedMessage.getText(
			 * )); String msg=receviedMessage.getText(); RequestBean results=new
			 * RequestBean(); SourceSystemWiseResults[]
			 * sourceSystemWiseResults=results.getResultsParsed(msg); for (int i = 0; i <
			 * sourceSystemWiseResults.length; i++) { SourceSystemWiseResults
			 * sourceSystemWiseResults2 = sourceSystemWiseResults[i];
			 * System.out.println(sourceSystemWiseResults2.getOffline());
			 * System.out.println(sourceSystemWiseResults2.getOnline());
			 * 
			 * }
			 */

			// JSONObject jsonObject=new JSONObject(msg);
			// System.out.println("@@ :: "+jsonObject);
			/*
			 * Object obj = new JsonParser().parse(msg);
			 * 
			 * // typecasting obj to JSONObject ObjectMapper objma = new ObjectMapper();
			 * objma.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			 * 
			 * Prime360Response ronaldo = objma.readValue(msg, Prime360Response.class);
			 * 
			 * System.out.println(ronaldo.getResults().toString());
			 */

			// Prime360Response prime360Response = (Prime360Response)jo;
			// logger.info("REsponse:: " + srv1.getResults());
			// logger.info("REsponse:: " + srv1.getRequestID());
			// logger.info("REsponse:: " + srv1.getRequestStatus());

			// System.out.println(jo.get("requestStatus"));

			/*
			 * } else { System.out.println("Recevied selected message is null"); }
			 */

		} catch (PosidexException e) {
			logger.info("-----------Problem with Engine Response---------------------");
			throw new PosidexException(e.getMessage());

		}

	}

	public String buildClientMessage(DedupeInputBean customerRequest, Prime360RequestInfo requestInfo2, long psxId,
			MRProfileInfoDTO mpdto) throws JsonProcessingException, PosidexException {

		logger.info("-----------buildClientMessage()------");

		logger.info("-----------Preparing Client Message------");
		String jsonInString = "";
		List<Prime360CommonTable> list;

		/*
		 * TransactionData transactionData =
		 * customerRequest.getRequest().getRequestPayload().getTransactions().get(0)
		 * .getTransactionData();
		 */

		try {
			list = new ArrayList<Prime360CommonTable>();
			request.setRequestID(String.valueOf(psxId));
			commonRequestData.setPsxId(String.valueOf(psxId));
			commonRequestData.setName(getName(customerRequest));
			commonRequestData.setFatherName(customerRequest.getFATHER_NAME());
			commonRequestData.setMotherName(customerRequest.getMOTHER_NAME());
			commonRequestData.setGender(customerRequest.getGENDER_FLAG());
			commonRequestData.setDob(getFormattedDOB(customerRequest));

			commonRequestData.setAadhaar(customerRequest.getAADHAR());
			commonRequestData.setDrivingLic(customerRequest.getDRIVING_LICN_NO());
			commonRequestData.setVoterId(customerRequest.getVOTERID());
			commonRequestData.setPan(customerRequest.getPAN());
			commonRequestData.setRationcardNo(customerRequest.getRATIONCARD_NO());
			commonRequestData.setPassport(customerRequest.getPASSPORT());

			commonRequestData.setPermenantAddress(customerRequest.getPERMANENT_ADDRESS());
			commonRequestData.setOfficeAddress(customerRequest.getOFFICE_ADDRESS());
			commonRequestData.setResidenceAddress(customerRequest.getRESIDENCE_ADDRESS());
			commonRequestData.setTemporaryAddress(customerRequest.getTEMPORARY_ADDRESS());

			commonRequestData.setPermenantEmail(customerRequest.getPERMANENT_EMAIL());
			commonRequestData.setOfficeEmail(customerRequest.getOFFICE_EMAIL());
			commonRequestData.setResidenceEmail(customerRequest.getRESIDENCE_EMAIL());
			commonRequestData.setTemporaryEmail(customerRequest.getTEMPORARY_EMAIL());

			commonRequestData.setPermenantContact(customerRequest.getPERMANENT_PHONE());
			commonRequestData.setResidenceContact(customerRequest.getRESIDENCE_PHONE());
			commonRequestData.setOfficeContact(customerRequest.getOFFICE_PHONE());
			commonRequestData.setTemporaryContact(customerRequest.getTEMPORARY_PHONE());

			commonRequestData.setPermenantCity(customerRequest.getPERMANENT_CITY());
			commonRequestData.setOfficeCity(customerRequest.getOFFICE_CITY());
			commonRequestData.setResidenceCity(customerRequest.getRESIDENCE_CITY());
			commonRequestData.setTemporaryCity(customerRequest.getTEMPORARY_CITY());

			commonRequestData.setPermenantPincode(customerRequest.getPERMANENT_PIN());
			commonRequestData.setOfficePincode(customerRequest.getOFFICE_PIN());
			commonRequestData.setResidencePincode(customerRequest.getRESIDENCE_PIN());
			commonRequestData.setTemporaryPincode(customerRequest.getTEMPORARY_PIN());

			commonRequestData.setPermenantState(customerRequest.getPERMANENT_STATE());
			commonRequestData.setOfficeState(customerRequest.getOFFICE_STATE());
			commonRequestData.setResidenceState(customerRequest.getRESIDENCE_STATE());
			commonRequestData.setTemporaryState(customerRequest.getTEMPORARY_STATE());

			commonRequestData.setPermenantCountry("");
			commonRequestData.setOfficeCountry("");
			commonRequestData.setResidenceCountry("");
			commonRequestData.setTemporaryCountry("");

			list.add(commonRequestData);

			/*
			 * requestInfo.setCDAP(list); request.setRequestInformation(requestInfo);
			 * request.setMatchingRule(matchingRule); request.setParamMap(new
			 * HashMap<String, String>()); request.setProcessType("matchingProcess");
			 * request.setRequestStatus("P"); request.setSourceSystemName("PRIME360");
			 * request.setScaleEquations("");
			 */
			logger.info("From service Impple before sending request*******");
			logger.info(mpdto);
			Map<String, String> paramMap = new HashMap<String,String>();
			paramMap.put("requestId", psxId+"");       
			request.setParamMap(paramMap);
			requestInfo.setCDAP(list);
			request.setRequestInformation(requestInfo);
			request.setMatchingRule(mpdto.getMatchingRuleCSV());
			request.setScaleEquations(mpdto.getScaleTypeEquations());
			request.setWeightages(mpdto.getWeightagesCsv());
			request.setResidualParams(mpdto.getResidualParameters());
			request.setRankingOrders(mpdto.getRankingCsv());
			request.setProcessType("matchingProcess");
			request.setParamMap(new HashMap<String, String>());
			request.setRequestStatus("P");
			request.setSourceSystemName("PRIME360");

			Gson mapper = new Gson();
			jsonInString = mapper.toJson(request, Prime360Request.class);
			logger.info("**Engine Format json Prepared***");
			logger.info("Builded ClientMessage :: " + jsonInString);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonInString;
	}

	private String getName(DedupeInputBean transactionData) {
		StringBuffer name = new StringBuffer("");
		if (transactionData.getFIRSTNAME() != null && !transactionData.getFIRSTNAME().trim().isEmpty())
			name.append(transactionData.getFIRSTNAME());
		name.append(" ");
		if (transactionData.getMIDDLENAME() != null && !transactionData.getMIDDLENAME().trim().isEmpty())
			name.append(transactionData.getMIDDLENAME());
		name.append(" ");
		if (transactionData.getLASTNAME() != null && !transactionData.getLASTNAME().trim().isEmpty())
			name.append(transactionData.getLASTNAME());
		return name.toString();
	}

	private String getFormattedDOB(DedupeInputBean transactionData) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(environment.getProperty("ws.dateformat"));
		Date date1 = sdf.parse(transactionData.getDOB1());
		sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(date1);
		return date;
	}

	@Override
	public List<ProcessRsponse> getCustomerResults(String requestId, Map<String, String> errorCodesMap)
			throws DAOException, PosidexException {

		List<ProcessRsponse> respnseList = null;

		CustomerResponse response = null;
		// FinalResponse respnseList=null;

		try {
			logger.info("---ServiceImpl--------getCustomerResults()----------------");
			response = new CustomerResponse();
			respnseList = customerRequestDao.getCustomerResults(requestId);

			// String status =
			// response.getResponse().getResponsePayload().getStatusInfo().getStatus();
			// ProcessResponse status=respnseList.getResponseList();

			// matchedCustomers = daoi.getMatchedCustomers(requestID,
			// Integer.parseInt(environment.getProperty("results.limit")));
			// custResult = populateWSCustomerList(matchedCustomers);
			// response.setCustResults(custResult);
		} catch (Exception ex) {
			ex.printStackTrace();

		}

		logger.info("----ServiceImpl---------Response from ServieImpl---------");
		logger.info(response);

		return respnseList;
	}

	@Override
	public boolean validateRequestId(String requestID) throws PosidexException {
		boolean flag = false;
		if (requestID == null || "".equals(requestID.trim())) {
			throw new PosidexException("RequestId is Required!");
		}
		try {
			if (!customerRequestDao.validateRequestId(requestID)) {
				throw new PosidexException("Invalid RequestId!");
			}
		} catch (PosidexException pse) {
			logger.error("validating request got an error i,e ::" + pse.getMessage());
			throw new PosidexException(pse.getMessage());
		} catch (Exception ex) {
			logger.error("Error While executing operation(PosidexService.getResponse)" + ex.getMessage());
			throw new PosidexException(INTERNAL_ERROR);
		}
		return flag;
	}

	@Override
	public boolean updateVerify(List<GetCheckBoxData> checkBoxList, String userId) {
		// TODO Auto-generated method stub

		boolean verifiedstatus = customerRequestDao.updateVerify(checkBoxList, userId);

		return verifiedstatus;
	}

	@Override
	public List<ProcessRsponse> getAllVerifiedData(String clientId) {
		// TODO Auto-generated method stub
		List<ProcessRsponse> getVerifiedData = customerRequestDao.getAllVerifiedData(clientId);
		return getVerifiedData;
	}

	@Override
	public boolean deleteSeleted(List<GetCheckBoxData> checkBoxList) {
		boolean verifiedstatus = customerRequestDao.deleteSeleted(checkBoxList);

		return verifiedstatus;
	}

	@Override
	public boolean rejectSeleted(List<GetCheckBoxData> checkBoxList,String user_Id) {
		// TODO Auto-generated method stub
		boolean rejectStatus = customerRequestDao.rejectSeleted(checkBoxList,user_Id);
		return rejectStatus;
	}

	@Override
	public List<ProcessRsponse> loadCheckerData(String clientId) {
		List<ProcessRsponse> list = customerRequestDao.loadCheckerData(clientId);
		return list;
	}

	@Override
	public LifeAsiaSucessAndErrorResponses approveSeleted(List<GetCheckBoxData> checkBoxList, String userId) {
		LifeAsiaResponseMessageBean resp=null;
		boolean approvetStatus = false;
		boolean LAStatus=false;
		// ===
		ClientMergeESBRequest request = null;
		Data requestdata = null;
		Header requestHeader = null;
		ClientMergeESBResponse response = null;
		List<LifeAsiaResponseMessageBean> mergeSuccessResponseList=new ArrayList<LifeAsiaResponseMessageBean>();
		List<LifeAsiaResponseMessageBean> mergeErrorResponseList=new ArrayList<LifeAsiaResponseMessageBean>();
		LifeAsiaSucessAndErrorResponses sucecessAndErrorResults=new LifeAsiaSucessAndErrorResponses();	
		LifeAsiaResponseMessageBean opMerge=null;
		List<ClientMergeESBResponse> clientmergeresponseList = null;
		
		String requestid=checkBoxList.get(0).getRequestid();
		String statusMessage="";
		String LAtatusMessage="";
		String crmsClientId=checkBoxList.get(0).getCrmsclientid();
		
		String retain = customerRequestDao.getRetainID(requestid);		
		if(crmsClientId.equals(retain))
		{
			approvetStatus = customerRequestDao.approveSeleted(checkBoxList, userId);
		}

		try {
			sucecessAndErrorResults.setRequestId(requestid);
			sucecessAndErrorResults.setUserId(userId);
			sucecessAndErrorResults.setCrmsClientNum(crmsClientId);
			LifeAsiaTestClient client = new LifeAsiaTestClient();
			logger.info("sending Data to Life Asia WS >>>>>" + checkBoxList);
			logger.info("Life Asia URL >>>>>>>>>>>" + environment.getProperty("LIFE_ASIA_URL"));
			clientmergeresponseList = new ArrayList<ClientMergeESBResponse>();
			request = new ClientMergeESBRequest();
			List<ProcessRsponse> responseList = customerRequestDao.lifeAsiaReq(checkBoxList);
			String policyNumber = customerRequestDao.getPolicyNumber(requestid);
			logger.info("Policy number ::: " + policyNumber);
			String insertTime = "";
			for (ProcessRsponse formRequest : responseList) {
				insertTime = formRequest.getINSERT_TIME();
			}
		
			logger.info(
					"query >>:: select count(1) from PSX_NSP_REQUEST_RESULTS_CRMS where RECORD_TYPE!='INPUT' and (SELECTED ='Y' or RETAIN='T')");
			// calling webservice
			
			List<ClientMergeESBRequest> requestList=customerRequestDao.getKliFailurecasesForReposting(crmsClientId);
			if(requestList.size()>0) {
				for(ClientMergeESBRequest kliasiaReq:requestList) {
				logger.info("LA web service calling for reverfiy case for >>>>" + kliasiaReq);
				kliasiaReq.getData().setPolicyNumber(null);
				response = clientMergeService.callWebserviceMethod(kliasiaReq);
				logger.info("LA web service called for reverfiy case >>>>" + response);
				customerRequestDao.updateKliAsiaRequestData(kliasiaReq,response,crmsClientId);
				}
			}else
			{
				String source_Client_ID = customerRequestDao.sourceClientID(requestid);
				String retain_client_ID = customerRequestDao.getRetainID(requestid);				
				int count = customerRequestDao.getCountForRetain(requestid);
			
			
			if (count == 0) {
				logger.info("No Target Data found updating status with source !!!");
				approvetStatus = customerRequestDao.approveSeleted(checkBoxList, userId);
				logger.info("only source approved!!");
				statusMessage="Approved successfully !!";
				LAStatus=true;
				opMerge=new LifeAsiaResponseMessageBean();
				opMerge.setRetainedClientNumber(source_Client_ID);
				opMerge.setMergeClientNumber(retain_client_ID);
				opMerge.setFlag("Y");
				

				mergeSuccessResponseList.add(opMerge);
				logger.info(opMerge);
				logger.info(mergeSuccessResponseList);
			//return approvetStatus;
			} else{

			List<ProcessRsponse> seletedIDList = customerRequestDao.getSelectedCrmsID(requestid);
				logger.info(
						"query>>:: select CRMS_CLIENT_ID from PSX_NSP_REQUEST_RESULTS_CRMS where SELECTED='Y' and RETAIN is null");
				logger.info("Selected list size() --: " + seletedIDList.size());
				logger.info("The Seleted Ids are  ::" + seletedIDList);

				int size = seletedIDList.size();
				for(ProcessRsponse mergeData:seletedIDList)
				{
					logger.info("seleted Merged Ids one by one");
					logger.info("mergeData :"+mergeData.getCRMS_CLIENT_ID());
				}
				
					if (size == 0) {
					
					/* for(ProcessRsponse data:seletedIDListNotInput) {*/
					 
					logger.info("when selected size==0");
					requestdata = new Data();
					requestdata.setAction("A");
					requestdata.setMergeClientNumber(source_Client_ID);
					//requestdata.setPolicyNumber(policyNumber);
					requestdata.setRetainedClientNumber(retain_client_ID);
					requestdata.setSourceClientNumber(source_Client_ID);
					logger.info("=========Before Sending Request Data=======");
					logger.info("MergeClientId ::" + source_Client_ID);
					logger.info("retain_client_ID ::" + retain_client_ID);
					logger.info("policyNumber ::" + policyNumber);
					logger.info("source_Client_ID ::" + source_Client_ID);
					logger.info(requestdata.toString());
					request.setData(requestdata);
					requestHeader = new Header();
					requestHeader.setDestination("LA");
					requestHeader.setSource("IONE");
					requestHeader.setTransactionDT(insertTime);
					requestHeader.setTransactionType("LAClientMerge");
					request.setHeader(requestHeader);
					logger.info("LA Calling ###### >>>>");
					response = clientMergeService.callWebserviceMethod(request);
					request.getData().setPolicyNumber(policyNumber);
					customerRequestDao.saveKliAsiaRequestData(request,response,source_Client_ID,requestid);
					logger.info("LA web service called ###### >>>>" + response);
					if (response != null) {
						clientmergeresponseList.add(response);
					}
				}

				else if (size == 1) {
					logger.info("When seleted  Size ==1");
					if(!source_Client_ID.equals(retain_client_ID)) {
					 logger.info("When source and client not equal");
					requestdata = new Data();
					requestdata.setAction("A");
					requestdata.setMergeClientNumber(source_Client_ID);
					//requestdata.setPolicyNumber(policyNumber);
					requestdata.setRetainedClientNumber(retain_client_ID);
					requestdata.setSourceClientNumber(source_Client_ID);
					logger.info("=========Before Sending Request Data=======");
					logger.info("MergeClientId ::" + source_Client_ID);
					logger.info("retain_client_ID ::" + retain_client_ID);
					logger.info("policyNumber ::" + policyNumber);
					logger.info("source_Client_ID ::" + source_Client_ID);
					logger.info(requestdata.toString());
					request.setData(requestdata);
					requestHeader = new Header();
					requestHeader.setDestination("LA");
					requestHeader.setSource("IONE");
					requestHeader.setTransactionDT(insertTime);
					requestHeader.setTransactionType("LAClientMerge");
					logger.info("sending header to LifeAsaia WS:: >>>>" + request);
					request.setHeader(requestHeader);
					logger.info("LA Calling ###### >>>>");
					response = clientMergeService.callWebserviceMethod(request);
					logger.info("LA web service called ###### >>>>" + response);
					request.getData().setPolicyNumber(policyNumber);
					customerRequestDao.saveKliAsiaRequestData(request,response,source_Client_ID,requestid);
					if (response != null) {
						clientmergeresponseList.add(response);
					}
					}
					for (ProcessRsponse data : seletedIDList) {
						logger.info("Merge IDs::"+data.getCRMS_CLIENT_ID());
						requestdata = new Data();
						requestdata.setAction("A");
						requestdata.setMergeClientNumber(data.getCRMS_CLIENT_ID());
						//requestdata.setPolicyNumber(policyNumber);
						requestdata.setRetainedClientNumber(retain_client_ID);
						requestdata.setSourceClientNumber(source_Client_ID);
						logger.info("=========Before Sending Request Data=======");
						logger.info("MergeClientId ::" + data.getCRMS_CLIENT_ID());
						logger.info("retain_client_ID ::" + retain_client_ID);
						logger.info("policynumber ::" + policyNumber);
						logger.info("source_Client_ID ::" + source_Client_ID);
						logger.info(requestdata.toString());
						logger.info("requestData=======================");
						request.setData(requestdata);
						requestHeader = new Header();
						requestHeader.setDestination("LA");
						requestHeader.setSource("IONE");
						requestHeader.setTransactionDT(insertTime);
						requestHeader.setTransactionType("LAClientMerge");
						request.setHeader(requestHeader);
						logger.info("LA Calling ###### >>>>");
						response = clientMergeService.callWebserviceMethod(request);
						logger.info("LA web service called ###### >>>>" + response);
						request.getData().setPolicyNumber(policyNumber);
						customerRequestDao.saveKliAsiaRequestData(request,response,source_Client_ID,requestid);
						if (response != null) {
							clientmergeresponseList.add(response);
						}

					}

				}
				
				else if (size > 1) {
					logger.info("when seleted Size >1 ");
					if(!source_Client_ID.equals(retain_client_ID)) {					
					requestdata = new Data();
					requestdata.setAction("A");
					requestdata.setMergeClientNumber(source_Client_ID);
					//requestdata.setPolicyNumber(policyNumber);
					requestdata.setRetainedClientNumber(retain_client_ID);
					requestdata.setSourceClientNumber(source_Client_ID);
					logger.info("=========Before Sending Request Data=======");
					logger.info("MergeClientId ::" + source_Client_ID);
					logger.info("retain_client_ID ::" + retain_client_ID);
					logger.info("policyNumber ::" + policyNumber);
					logger.info("source_Client_ID ::" + source_Client_ID);
					logger.info(requestdata.toString());
					request.setData(requestdata);
					requestHeader = new Header();
					requestHeader.setDestination("LA");
					requestHeader.setSource("IONE");
					requestHeader.setTransactionDT(insertTime);
					requestHeader.setTransactionType("LAClientMerge");
					request.setHeader(requestHeader);
					logger.info("LA Calling ###### >>>>");
					response = clientMergeService.callWebserviceMethod(request);
					logger.info("LA web service called ###### >>>>" + response);
					request.getData().setPolicyNumber(policyNumber);
					customerRequestDao.saveKliAsiaRequestData(request,response,source_Client_ID,requestid);					
					if (response != null) {
						clientmergeresponseList.add(response);
					}
					}
					for (ProcessRsponse data : seletedIDList) {
						requestdata = new Data();
						requestdata.setAction("A");
						
						logger.info("Expecting Merge Data is"+data.getCRMS_CLIENT_ID());
						requestdata.setMergeClientNumber(data.getCRMS_CLIENT_ID());
						//requestdata.setPolicyNumber(policyNumber);
						requestdata.setRetainedClientNumber(retain_client_ID);
						requestdata.setSourceClientNumber(source_Client_ID);
						logger.info("=========Before Sending Request Data=======");
						logger.info("MergeClientId ::" + data.getCRMS_CLIENT_ID());
						logger.info("retain_client_ID ::" + retain_client_ID);
						logger.info("policynumber ::" + policyNumber);
						logger.info("source_Client_ID ::" + source_Client_ID);
						logger.info(requestdata.toString());
						request.setData(requestdata);
						requestHeader = new Header();
						requestHeader.setDestination("LA");
						requestHeader.setSource("IONE");
						requestHeader.setTransactionDT(insertTime);
						requestHeader.setTransactionType("LAClientMerge");
						logger.info("sending header to LifeAsaia WS:: >>>>");
						request.setHeader(requestHeader);
						logger.info("LA Calling ###### >>>>");
						response = clientMergeService.callWebserviceMethod(request);
						logger.info("LA web service called ###### >>>>:: "+response);
						request.getData().setPolicyNumber(policyNumber);
						customerRequestDao.saveKliAsiaRequestData(request,response,source_Client_ID,requestid);
						if (response != null) {
							clientmergeresponseList.add(response);
						}

					}

				}
			}
			}
		} catch (Exception e) {
			logger.error("while processing LifeAsia operation got an error " + e.getMessage());
			e.printStackTrace();
			
		}


		boolean flag = false;
	    String JsonResponse="";
		try {
			logger.info("the client merge response list   "+clientmergeresponseList.size());
			logger.info("the client merge response list   "+clientmergeresponseList);
			if (clientmergeresponseList.size() > 0) {
				logger.info("Inside When response >0****");
				logger.info("Inserting status ****");
				logger.info("ResponseList >>"+clientmergeresponseList);
				
				approvetStatus = customerRequestDao.saveClientMergeDetails(clientmergeresponseList,requestid);
				try {
				logger.info("Approve status updating in CRMS_Results table");
				logger.info("updating status with :"+checkBoxList+" RequestId"+requestid+" User_Id"+userId);
				//approvetStatus = customerRequestDao.approveSeleted(checkBoxList, userId);
				boolean updateStatus=customerRequestDao.approvewithRequestId(requestid, userId);			
				}
				catch(Exception e)
				{
					logger.info("Getting Error while updating approve status in CRMS_RESULTS");
					e.printStackTrace();
				}
				
				
				for(ClientMergeESBResponse mergerResponse:clientmergeresponseList)
				{	
					opMerge=new LifeAsiaResponseMessageBean();
					if("Y".equalsIgnoreCase(response.getData().getFlag())) {

						logger.info("LA Response when getFlag is Not Null>>>>");
						logger.info("Preparing Success Response object ");
						opMerge.setRetainedClientNumber(mergerResponse.getData().getMergeClientNumber());
						opMerge.setMergeClientNumber(mergerResponse.getData().getMergeClientNumber());
						opMerge.setPolicyNumber(mergerResponse.getData().getPolicyNumber());
						opMerge.setFlag(mergerResponse.getData().getPolicyNumber());
						mergeSuccessResponseList.add(opMerge);
						logger.info("LA Status success response List :>>"+mergeSuccessResponseList);	
					}
					else 
					{
						logger.info("LA Response when ERROR_CODE is Not Null>>>>");
						logger.info("Preparing Error Response object ");
						opMerge.setRetainedClientNumber(mergerResponse.getData().getMergeClientNumber());
						opMerge.setMergeClientNumber(mergerResponse.getData().getMergeClientNumber());
						opMerge.setPolicyNumber(mergerResponse.getData().getPolicyNumber());
						opMerge.setErrorCode(mergerResponse.getData().getErrorCode());
						opMerge.setErrorDescription(mergerResponse.getData().getErrorDescription());
						mergeErrorResponseList.add(opMerge);
						logger.info("LA Status Error response List :>>"+mergeErrorResponseList);
							
					}
			//===========
					//for LA-Web-service live
					/*for(ClientMergeESBResponse mergerResponse:clientmergeresponseList)
					{	
						opMerge=new LifeAsiaResponseMessageBean();
						if(mergerResponse.getData().getErrorCode()!=null || mergerResponse.getData().getErrorCode()!=""  )
						{	logger.info("LA Response when ERROR_CODE is Not Null>>>>");
							logger.info("Preparing Error Response object ");
							opMerge.setRetainedClientNumber(mergerResponse.getData().getMergeClientNumber());
							opMerge.setMergeClientNumber(mergerResponse.getData().getMergeClientNumber());
							opMerge.setPolicyNumber(mergerResponse.getData().getPolicyNumber());
							opMerge.setErrorCode(mergerResponse.getData().getErrorCode());
							opMerge.setErrorDescription(mergerResponse.getData().getErrorDescription());
							mergeErrorResponseList.add(opMerge);
							logger.info("LA Status Error response List :>>"+mergeErrorResponseList);	
						}
						else 
						{
							logger.info("LA Response when getFlag is Not Null>>>>");
							logger.info("Preparing Success Response object ");
							opMerge.setRetainedClientNumber(mergerResponse.getData().getMergeClientNumber());
							opMerge.setMergeClientNumber(mergerResponse.getData().getMergeClientNumber());
							opMerge.setPolicyNumber(mergerResponse.getData().getPolicyNumber());
							opMerge.setFlag(mergerResponse.getData().getPolicyNumber());
							mergeSuccessResponseList.add(opMerge);
							logger.info("LA Status success response List :>>"+mergeSuccessResponseList);	

						}*/			
					
					
					
				/*	if(mergerResponse.getData().getErrorCode()!=null || mergerResponse.getData().getErrorCode()!=""  )
					{	
						logger.info("Inside If Error code validation ");
						statusMessage="Merge Failed !!";
						LAStatus=false;
						flag=false;
					}
					else if(mergerResponse.getData().getFlag()!=null || mergerResponse.getData().getFlag()!="" )
					{
						logger.info("Inside Else Flag not null or not empty");
						if(mergerResponse.getData().getFlag().equalsIgnoreCase("Y"))
								{	
								statusMessage="Approved successfully !!";
								LAStatus=true;
								flag=true;								
								}
							else {
								statusMessage="Merge Failed !!";
								LAStatus=false;
								flag=false;		
							}
					}*/
					
			/*	}
				
				
			}
			
			
		
	
			
			
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			LAtatusMessage = ow.writeValueAsString(MergeresponseList);
			logger.info("LA Status response from serviceImpl:>>"+LAtatusMessage);	*/
					
					/*
					ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
					//LAtatusMessage = ow.writeValueAsString(MergeresponseList);
					LAtatusMessage = ow.writeValueAsString(sucecessAndErrorResults);
					
					logger.info("LA Status response from serviceImpl:>>"+LAtatusMessage);*/	
					
				} 
					//manual testing purpose
					
				/*	for(int i=0;i<8;i++) {
						opMerge=new LifeAsiaResponseMessageBean();
						if(i<2)
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
					
				}*/
				
				sucecessAndErrorResults.setMergeErrorResponseList(mergeErrorResponseList);
				sucecessAndErrorResults.setMergeSuccessResponseList(mergeSuccessResponseList);
				logger.info("Success And Error Results ::"+mergeErrorResponseList);
				logger.info("Success And Error Results ::"+mergeSuccessResponseList);
				
				//ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
				//LAtatusMessage = ow.writeValueAsString(MergeresponseList);
				//LAtatusMessage = ow.writeValueAsString(sucecessAndErrorResults);
				
				logger.info("LA Status response from serviceImpl:>>"+sucecessAndErrorResults);
				
			}
			
		} catch (Exception ex) {
			logger.error("While performing clinetmerge operation got an error " + ex.getMessage());
			ex.printStackTrace();
	
		}
		
		// ClientMergeESBResponse response = client.processWs(responseList);
		
		logger.info("Return value After LA Response : "+sucecessAndErrorResults);
		return sucecessAndErrorResults;
		
	}

	@Override
	public List<ProcessRsponse> responseList(String policy_number) {
		// TODO Auto-generated method stub

		List<ProcessRsponse> responseList = customerRequestDao.responseList(policy_number);
		return responseList;
	}

	@Override
	public boolean verifyClientID(String cleintID) {
		boolean status = customerRequestDao.verifyClientID(cleintID);
		return status;
	}

	@Override
	public List<DedupeReport> getDedupeReport(String startDate, String endDate) {
		// TODO Auto-generated method stub
		List<ProcessRsponse> list = customerRequestDao.getDedupeReport(startDate, endDate);
		List<DedupeReport> dedupeReportList = new ArrayList<DedupeReport>();

		for (ProcessRsponse response : list) {
			DedupeReport report = new DedupeReport();
			logger.info(response.getRECORD_TYPE());
			if (response.getRECORD_TYPE() != null && response.getRECORD_TYPE().equalsIgnoreCase("INPUT")) {
				report.setSOURCE_CLIENT_ID(response.getCRMS_CLIENT_ID());
			} else {
				report.setSOURCE_CLIENT_ID("");
			}
			if (response.getIsRetain() != null && response.getIsRetain().equalsIgnoreCase("T")) {
				report.setRETAINED_CLIENT_ID(response.getCRMS_CLIENT_ID());
			} else {
				report.setRETAINED_CLIENT_ID("");
			}
			if (response.getRECORD_TYPE() != null && response.getIsVerified().equalsIgnoreCase("Y")) {
				report.setMERGED_CLIENT_ID(response.getCRMS_CLIENT_ID());
			}
			if (response.getPOLICY_NUMBER() != null) {
				report.setPROPOSAL_NO(response.getPOLICY_NUMBER());
			}
			report.setEXISTING_CLIENT_ID(response.getCRMS_CLIENT_ID());
			report.setCOUNT_OF_MATCHING_CLIENT_ID(response.getMATCH_COUNT());
			report.setAUTO_MANUAL_SELECTION("AUTO");
			report.setCONFIDENCE_LEVEL_MATCH("");
			report.setRULES(response.getMATCH_RULE());
			report.setTYPE_OF_SYSTEM("");
			report.setACTIVITY_COMPLETED("C");
			logger.info("Maker*******" + response.getMAKER_ID());
			if (response.getMAKER_ID() != null && response.getRECORD_TYPE().equals("INPUT")) {
				logger.info("inside if Maker*******" + response.getMAKER_ID());
				report.setUSER_ID(response.getMAKER_ID());
			} else {
				report.setUSER_ID("");
			}
			/*
			 * if(response.getCHECKER_ID()!=null) {
			 * report.setUSER_ID(response.getCHECKER_ID()); }
			 */
			report.setSIMULTANEOUS_POLICY_LIST("");
			if (response.getMAKER_ID() != null) {
				report.setDECISION_TAKEN(response.getMAKER_ID());
			} else {
				report.setDECISION_TAKEN("");
			}

			dedupeReportList.add(report);
		}
		logger.info("########Request Service#########");
		logger.info(dedupeReportList);
		return dedupeReportList;
	}

	@Override
	public List<MISReport> getMisReport(String startDate, String endDate) {
		// TODO Auto-generated method stub
		List<ProcessRsponse> resploseList = customerRequestDao.getMISReport(startDate, endDate);
		List<MISReport> misReportList = new ArrayList<MISReport>();
		for (ProcessRsponse response : resploseList) {
			MISReport misReport = new MISReport();
			misReport.setCustomer_id(response.getCRMS_CLIENT_ID());
			misReport.setPolicy_number(response.getPOLICY_NUMBER());
			misReport.setStatus("C");
			misReportList.add(misReport);
		}
		return misReportList;
	}

	@Override
	public boolean noActionRequired(String sourceClientId) {
		// TODO Auto-generated method stub
		boolean flag = customerRequestDao.noActionRequired(sourceClientId);

		return flag;
	}

	@Override
	public boolean updateErrorRecordsForMakerPage(LifeAsiaSucessAndErrorResponses mergeErrorResponse) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
		 flag=customerRequestDao.updateErrorRecordsForMakerPage(mergeErrorResponse);
		 
		}catch(Exception e) {
			flag=false;
			logger.error(e.getMessage());
		}
		
		return flag;
		
	}

	@Override
	public boolean validateChecker(String policynumber, String userId) {
		
		boolean status;
		int  count=customerRequestDao.validateChecker(policynumber, userId);
		if(count >0)
		return true;
		else return false;
	}

	@Override
	public int checkDedupeVerificationforChecker(String crmsClientId,String clinetRole) throws DAOException {
		
		return customerRequestDao.checkDedupeVerificationforChecker(crmsClientId,clinetRole);
	}
	
	@Override
	public List<KLILifeAsiaDataDTO> getKLiLifeAsiaRecords(String clientMergeId) {
		
		return customerRequestDao.getKLiLifeAsiaRecords(clientMergeId);
	}

	@Override
	public List<ProcessRsponse> getAllCheckerSelectedData(String selectedValue) {
		List<ProcessRsponse> getselectedData = customerRequestDao.getAllCheckerSelectedData(selectedValue);
		return getselectedData;
	}

}
