package com.posidex.prime.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.posidex.bean.DedupeInputBean;
import com.posidex.bean.GetCheckBoxData;
import com.posidex.bean.LifeAsiaSucessAndErrorResponses;
import com.posidex.lifeasia.stub.ClientMergeESBRequest;
import com.posidex.lifeasia.stub.ClientMergeESBRequest.Data;
import com.posidex.lifeasia.stub.ClientMergeESBRequest.Header;
import com.posidex.lifeasia.stub.ClientMergeESBResponse;
import com.posidex.prime.common.dto.ErrorCodeInfoDTO;
import com.posidex.prime.common.dto.MRProfileInfoDTO;
import com.posidex.prime.dao.CustomerDAO;
import com.posidex.prime.exception.DAOException;
import com.posidex.prime.exception.PosidexException;
import com.posidex.prime.request.RequestInfo;
import com.posidex.prime.request.TransactionData;
import com.posidex.prime.response.KLILifeAsiaDataDTO;
import com.posidex.prime.response.ProcessRsponse;

@Repository
public class CustomerDaoImpl implements CustomerDAO {

	Logger logger = Logger.getLogger(CustomerDaoImpl.class);

	@Autowired
	private Environment env;

	@Autowired
	private JdbcTemplate jdbcTemplate;

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

	private Date formatDate(String transactionData) throws ParseException {
		/*
		 * SimpleDateFormat sdf1 = new SimpleDateFormat("dd/M/yyyy"); Date
		 * d=sdf1.parse(transactionData.getDOB1()); String date = sdf1.format(new
		 * Date());
		 */
		SimpleDateFormat sdf = null;
		if (transactionData!= "") {
			System.out.println("insideParse method ***********");
			sdf = new SimpleDateFormat(env.getProperty("ws.dateformat"));
			logger.info("Date value is::"+sdf);
			logger.info("Date value is::"+sdf);
			return sdf.parse(transactionData);
		} else
			return new java.util.Date(0, 0, 0);
	}

	@Override
	public int insertRequestDetails(DedupeInputBean customerRequest, RequestInfo requestInfo, long psxId)
			throws PosidexException, DataAccessException, ParseException {

		logger.info("Insert details here >>>:: psx_ID" + psxId + " ");

		logger.info("*************Given Input to DAOIMPL for insert******************");
		logger.info(customerRequest.toString());
		logger.info(requestInfo.toString());
		logger.info("*************Given Input to DAOIMPL for insert******************");

		// For Address
		/*
		 * List<Address> listOfAddress = getAddress(customerRequest); // For Contact
		 * List<Contact> listOfContact = getContact(customerRequest); // For Email
		 * List<Email> listOfEmail = getEmail(customerRequest); TransactionData
		 * transactionData =
		 * customerRequest.getRequest().getRequestPayload().getTransactions().get(0)
		 * .getTransactionData(); RequestInfo requestInfo =
		 * customerRequest.getRequest().getRequestInfo();
		 */
		// customerRequest.getRequest().getRequestInfo();*/

		/*
		 * TransactionData transactionData=new TransactionData();
		 * transactionData.setAadhaar(aadhaar);
		 */

		// GENDER,POLICY_NUMBER,CRMS_CLIENT_ID,OFFICE_ADDRESS,

		int count = jdbcTemplate.update(env.getProperty("customer.request.insert.query"),
				new Object[] { 
						psxId,
						"P", 
						new Timestamp(System.currentTimeMillis()),
						getName(customerRequest),
						customerRequest.getMOTHER_NAME(),
						customerRequest.getFATHER_NAME(),
						formatDate(customerRequest.getDOB1()),
						customerRequest.getPAN(),
						customerRequest.getPASSPORT(),
						customerRequest.getVOTERID(),
						customerRequest.getDRIVING_LICN_NO(),
						customerRequest.getAADHAR(),
						customerRequest.getRATIONCARD_NO(),
						customerRequest.getGENDER_FLAG(),
						customerRequest.getPOLICY_NUMBER(),
						customerRequest.getCRMS_CLIENT_ID(),
						customerRequest.getOFFICE_ADDRESS(), // OFFICE_ADDRESS
						customerRequest.getOFFICE_CITY(), // OFFICE_CITY
						customerRequest.getOFFICE_STATE(), // OFFICE_STATE
						customerRequest.getCOUNTRY(), // OFFICE_COUNTRY
						customerRequest.getOFFICE_PIN(), // OFFICE_PIN
						customerRequest.getPERMANENT_ADDRESS(), // PERMANENT_ADDRESS
						customerRequest.getPERMANENT_CITY(), // PERMANENT_CITY
						customerRequest.getPERMANENT_STATE(), // PERMANENT_STATE
						customerRequest.getCOUNTRY(), // PERMANENT_COUNTRY
						customerRequest.getPERMANENT_PIN(), // PERMANENT_PIN
						customerRequest.getRESIDENCE_ADDRESS(), // RESIDENCE_ADDRESS
						customerRequest.getRESIDENCE_CITY(), // RESIDENCE_CITY
						customerRequest.getRESIDENCE_STATE(), // RESIDENCE_STATE
						customerRequest.getCOUNTRY(), // RESIDENCE_COUNTRY
						customerRequest.getRESIDENCE_PIN(), // RESIDENCE_PIN
						customerRequest.getTEMPORARY_ADDRESS(), // TEMPORARY_ADDRESS
						customerRequest.getTEMPORARY_CITY(), // TEMPORARY_CITY
						customerRequest.getTEMPORARY_STATE(), // TEMPORARY_STATE
						customerRequest.getCOUNTRY(), // TEMPORARY_COUNTRY
						customerRequest.getTEMPORARY_PIN(), // TEMPORARY_PIN
						customerRequest.getOFFICE_EMAIL(),
						customerRequest.getPERMANENT_EMAIL(),
						customerRequest.getRESIDENCE_EMAIL(),
						customerRequest.getTEMPORARY_EMAIL(),
						customerRequest.getOFFICE_PHONE(), // OFFICE_PHONE
						customerRequest.getPERMANENT_PHONE(), // PERMANENT_PHONE
						customerRequest.getRESIDENCE_PHONE(), // RESIDENCE_PHONE
						customerRequest.getTEMPORARY_PHONE(), // TEMPORARY_PHONE
						requestInfo.getCreationDate(),
						requestInfo.getCreationTime(),
						requestInfo.getRequestorToken(),
						requestInfo.getSourceInfoName(),
						requestInfo.getSource(),
						requestInfo.getTransactionId(),
						requestInfo.getUserName(),
						requestInfo.getDevice_uuid(),
						requestInfo.getLastSyncDate(),
						requestInfo.getUserEmail(),
						"requestnumner32", 
						customerRequest.getPROFILE_ID(),
						"IR32",
						customerRequest.getMAKER_ID(),
						customerRequest.getCHECKER_ID(),
						/*
						CKYCNO
						CLIENT_TYPE
						CRNNO
						GSTIN
						SOURCE_SYSTEM
						STATUS
						MOBILE
						DOI*/

						customerRequest.getCKYCNO(),
						customerRequest.getCLIENT_TYPE(),
						customerRequest.getCRNNO(),
						customerRequest.getGSTIN(),
						customerRequest.getSUB_SOURCE_SYSTEM(),
						customerRequest.getSTATUS(),
						customerRequest.getMOBILE(),
						formatDate(customerRequest.getDOC()),
						//customerRequest.getDOC(),
						
						customerRequest.getCRMS_CLIENT_ID()

						
						});
		
		logger.info("Insert succeesfully  PSX_NSP_REQUEST_T Table !! "+count);
		return count;
	}

	private Date formatDate(TransactionData transactionData) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(env.getProperty("ws.dateformat"));
		return sdf.parse(transactionData.getDob());
	}

	private String getName(TransactionData transactionData) {

		StringBuffer name = new StringBuffer("");
		if (transactionData.getFirstName() != null && !transactionData.getFirstName().trim().isEmpty())
			name.append(transactionData.getFirstName());
		name.append(" ");
		if (transactionData.getMiddleName() != null && !transactionData.getMiddleName().trim().isEmpty())
			name.append(transactionData.getMiddleName());
		name.append(" ");
		if (transactionData.getLastName() != null && !transactionData.getLastName().trim().isEmpty())
			name.append(transactionData.getLastName());
		return name.toString();
	}

	@Override
	public long getPsxIdFromSequence(String sequenceName) {
		String query = "select " + sequenceName + ".nextVal from dual";

		return jdbcTemplate.query(query, new ResultSetExtractor<Long>() {
			Long value;

			@Override
			public Long extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next())
					value = rs.getLong(1);
				return value;
			}
		});
	}

	boolean flag = false;

	@Override
	public boolean validateRequestId(String requestID) throws DAOException {
		logger.debug("jdbctemplate  " + jdbcTemplate);
		/*
		 * try {
		 * 
		 * flaglist = jdbcTemplate.query(DBQueries.VALIDATE_REQUESTID_QUERY, new
		 * Object[] { requestID }, (rs, rownum) -> { flag = true; return true; });
		 * 
		 * jdbcTemplate.query(DBQueries.VALIDATE_REQUESTID_QUERY, new Object[] {
		 * requestID }, new ResultSetExtractor<Boolean>() {
		 * 
		 * @Override public Boolean extractData(ResultSet rs) throws SQLException,
		 * DataAccessException { if (rs.next()) flag = true; return flag; } });
		 * 
		 * } catch (Exception ex) {
		 * logger.error("while fetching request_id count got an error:: " +
		 * ex.getMessage()); throw new
		 * DAOException("while fetching request_id count got an error"); }
		 */
		return true;
	}

	/*@Override
	public Map<String, MRProfileInfoDTO> getPMProfileIds(String query) throws PosidexException {
		List<MRProfileInfoDTO> mrpropfilelist = null;
		Map<String, MRProfileInfoDTO> mrProfileInfoMap = new HashMap<String, MRProfileInfoDTO>();
		try {

			// logger.debug("Prime 360 PM Profile ID Query:" + query);

			mrpropfilelist = jdbcTemplate.query(query, (rs, rownum) -> {
				MRProfileInfoDTO profileInfoDTO = new MRProfileInfoDTO();

				profileInfoDTO.setProfileId(rs.getString(1));
				profileInfoDTO.setMatchingRuleCSV(rs.getString(2));
				profileInfoDTO.setScaleTypeEquations(rs.getString(3));

				return profileInfoDTO;

			});

			for (MRProfileInfoDTO mrprofile : mrpropfilelist) {

				mrProfileInfoMap.put(mrprofile.getProfileId(), mrprofile);
			}

			// logger.info("Prime 360 mrprofile rules are " + mrpropfilelist);
		} catch (Exception ex) {
			logger.error("Exception while  getting Prime 360 profileIDs: " + ex.getMessage());//$NON-NLS-1$
			throw new PosidexException("errors.internalError");//$NON-NLS-1$
		}
		return mrProfileInfoMap;
	}*/
	
	
	
	public Map<String, MRProfileInfoDTO> getPMProfileIds(String query) throws PosidexException {
		logger.info("Inside CustomerDaoImpl class getPMProfileIds() method");
		List<MRProfileInfoDTO> mrpropfilelist = null;
		Map<String, MRProfileInfoDTO> mrProfileInfoMap = new HashMap<String, MRProfileInfoDTO>();
		try {

			logger.debug("Prime  PM Profile ID Query:" + query);

			mrpropfilelist = jdbcTemplate.query(query, (rs, rownum) -> {
				MRProfileInfoDTO profileInfoDTO = new MRProfileInfoDTO();

				profileInfoDTO.setProfileId(rs.getString(1));
				profileInfoDTO.setMatchingRuleCSV(rs.getString(2));
				profileInfoDTO.setScaleTypeEquations(rs.getString(3));
				profileInfoDTO.setRankingCsv(rs.getString(4));
				profileInfoDTO.setResidualParameters(rs.getString(5));
				profileInfoDTO.setWeightagesCsv(rs.getString(6));

				return profileInfoDTO;

			});

			for (MRProfileInfoDTO mrprofile : mrpropfilelist) {

				mrProfileInfoMap.put(mrprofile.getProfileId(), mrprofile);
			}

			logger.info("Prime 360 mrprofile rules are " + mrpropfilelist);
		} catch (Exception ex) {
			logger.error("Exception while  getting Prime 360 profileIDs: " + ex.getMessage());//$NON-NLS-1$
			throw new PosidexException("errors.internalError");//$NON-NLS-1$
		}
		return mrProfileInfoMap;
	}

	

	@Override
	public Map<String, ErrorCodeInfoDTO> getWebServiceErrorCodes(String query) throws PosidexException {

		List<ErrorCodeInfoDTO> errorCodelist = null;

		Map<String, ErrorCodeInfoDTO> errorCodeInfoMap = new HashMap<String, ErrorCodeInfoDTO>();
		try {

			logger.debug("Prime 360 Profile ID Query:" + query);

			errorCodelist = jdbcTemplate.query(query, (rs, rownum) -> {
				ErrorCodeInfoDTO errorCodeInfoDTO = new ErrorCodeInfoDTO();
				errorCodeInfoDTO.setErrorCode(rs.getString(1));
				errorCodeInfoDTO.setErrorDesc(rs.getString(2));

				return errorCodeInfoDTO;

			});

			for (ErrorCodeInfoDTO errorCode : errorCodelist) {

				errorCodeInfoMap.put(errorCode.getErrorCode(), errorCode);
			}

			logger.debug("Leaving getWebServiceErrorCodes()");

		} catch (Exception ex) {
			logger.error("Exception while getting getWebServiceErrorCodes: " + ex.getMessage());//$NON-NLS-1$
			throw new PosidexException("errors.internalError");//$NON-NLS-1$
		}

		return errorCodeInfoMap;

	}

	@Override
	public List<ProcessRsponse> getCustomerResults(String clientID) {
		logger.info("DAOIMPL getCustomerResults(String clientID)");

		logger.info("DAOIMPL getCustomer Result  given clientID:>>" + clientID);

		//String requestId = "select request_Id from PSX_NSP_REQUEST_RESULTS_CRMS where verified='N' and RECORD_TYPE='INPUT' and CRMS_CLIENT_ID=?";// '"+clientID+"'";

		// String reqId=jdbcTemplate.queryForObject(requestId,String.class);

		// ProcessRsponse prObj = (ProcessRsponse) jdbcTemplate.queryForObject(
		// requestId, new Object[] { clientID }, ProcessRsponse.class);

		// String reqId=prObj.getREQUEST_ID();

		logger.info("_____requestId_" + clientID);

		List<ProcessRsponse> response = getResponse(clientID);
		// FinalResponse frespons=new FinalResponse();
		// frespons.setResponseList(response);
		return response;
	}

	public List<ProcessRsponse> getResponse(String requestId) {

		logger.info("--------DAOIMPL getResponse()>>>-------");
		logger.info("--------DAOIMPL getResponse-------with ----'" + requestId + "'-----");
		// String query="select * from employee";

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * String countQry
		 * ="select count(1) as CNT from  PSX_NSP_REQUEST_RESULTS_CRMS where verified='N' and CRMS_CLIENT_ID='"
		 * +clientid+"'";
		 * 
		 * 
		 * int count = jdbcTemplate.queryForObject( countQry, Integer.class);
		 * 
		 * logger.info("countvalue " + count);
		 * 
		 * System.out.println("countvalue"+count);
		 * 
		 * //System.out.println(count);
		 */

		/*
		 * String
		 * query="select * from PSX_NSP_REQUEST_RESULTS_CRMS where requesT_Id in " +
		 * "(select request_Id from PSX_NSP_REQUEST_RESULTS_CRMS where verified='N' and RECORD_TYPE='INPUT' and CRMS_CLIENT_ID=?) ORDER BY RECORD_TYPE"
		 * ;
		 */

		String query = env.getProperty("get_all_match_response_after_dedupe");
		logger.info("To Get MatchResponse below  query is  executing >>>::");
		
		logger.info("RequestId **************"+requestId);
		
		logger.info(query);
		return jdbcTemplate.query(query, new Object[] { requestId }, new ResultSetExtractor<List<ProcessRsponse>>() {

			@Override
			public List<ProcessRsponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<ProcessRsponse> list = new ArrayList<ProcessRsponse>();
				logger.info("CUSTOMERDAOIMPL RESULT SIZE"+rs.getFetchSize());

				while (rs.next()) {
					ProcessRsponse response = new ProcessRsponse();
					// view page
					/*
					 * <td>${response.CRMS_CLIENT_ID}</td> <td>${response.MATCH_REASON}</td>
					 * <td>${response.MATCH_COUNT}</td> <td>${response.SCALE_TYPE}</td>
					 * <td>${response.NAME}</td> <td>${response.DOB1}</td>
					 * <td>${response.GENDER}</td> <td>${response.PERMANENT_ADDRESS}</td>
					 * <td>${response.RESIDENCE_ADDRESS}</td> <td>${response.OFFICE_ADDRESS}</td>
					 * <td>${response.PERMANENT_PHONE}</td> <td>${response.RESIDENCE_PHONE}</td>
					 * <td>${response.OFFICE_PHONE}</td> <td>${response.AADHAAR}</td>
					 */
					logger.info("inside RS Client_id"+rs.getString("CRMS_CLIENT_ID"));
					response.setCLIENT_ID(rs.getString("CRMS_CLIENT_ID"));
					response.setMATCH_COUNT(rs.getString("MATCH_COUNT"));
					response.setREQUEST_ID(rs.getString("REQUEST_ID"));
					response.setMATCH_REASON(rs.getString("MATCH_REASON"));
					response.setPSX_ID(rs.getString("PSX_ID"));
					// response.setDOB1(rs.getString("DOB1"));
					String date = rs.getString("DOB1");
				
					String Date = date.substring(0, 10);
					response.setDOB1(Date);

					response.setNAME(rs.getString("NAME"));
					response.setAADHAAR(rs.getString("AADHAAR"));
					response.setFATHER_NAME(rs.getString("FATHER_NAME"));
					response.setPERMANENT_PHONE(rs.getString("PERMANENT_PHONE"));
					response.setPERMANENT_CITY(rs.getString("PERMANENT_CITY"));
					response.setGENDER(rs.getString("GENDER"));
					response.setCRMS_CLIENT_ID(rs.getString("CRMS_CLIENT_ID"));
					response.setPERMANENT_ADDRESS(rs.getString("PERMANENT_ADDRESS"));
					response.setOFFICE_ADDRESS(rs.getString("OFFICE_ADDRESS"));
					response.setRESIDENCE_ADDRESS(rs.getString("RESIDENCE_ADDRESS"));
					response.setPERMANENT_PHONE(rs.getString("PERMANENT_PHONE"));
					response.setOFFICE_PHONE(rs.getString("OFFICE_PHONE"));
					response.setRESIDENCE_PHONE(rs.getString("RESIDENCE_PHONE"));
					response.setSELECTED(rs.getString("SELECTED"));
					response.setPERMANENT_PIN(rs.getString("PERMANENT_PIN"));
					response.setIsVerified(rs.getString("VERIFIED"));
					response.setSCALE_TYPE(rs.getString("SCALE_TYPE"));
					response.setMATCH_RULE(rs.getString("MATCH_RULE"));
					response.setREJECTED(rs.getString("REJECTED"));
					
						response.setCKYCNO(rs.getString("CKYCNO"));
						response.setCLIENT_TYPE(rs.getString("CLIENT_TYPE"));
						response.setCRNNO(rs.getString("CRNNO"));
						response.setGSTIN(rs.getString("GSTIN"));
						response.setSOURCE_SYSTEM(rs.getString("SOURCE_SYSTEM"));
						response.setSTATUS(rs.getString("STATUS"));
						response.setDOC(rs.getString("DOI"));
						

					// logger.info(rs.getString("VERIFIED"));

					list.add(response);
				}
				logger.info("response____________________________");
				logger.info(list);
				return list;
			}
		});

	}

	@Override
	public boolean updateVerify(List<GetCheckBoxData> checkBoxList,String userId) {
		// TODO Auto-generated method stub
		logger.info("From DAO IMPL>> updateVerify method obtained !!>>>>");
		logger.info("From DAO IMPL>> updateVerify method obtained  with >>" + checkBoxList);
		logger.info("Maker USER_ID: >>>>"+userId);
		// logger.info("updateverify::>>>> request"+checkBoxList[0].getRequestid()+"
		// "+checkBoxList[0].getCrmsclientid());
		// String updateQuery = "update PSX_NSP_REQUEST_RESULTS_CRMS set verified =
		// ?,SELECTED=? where CRMS_CLIENT_ID = ?";

		// String updateQuery2="UPDATE PSX_NSP_REQUEST_RESULTS_CRMS SET VERIFIED='Y'
		// WHERE REQUEST_ID=? AND RECORD_TYPE='INPUT'";

		String updateQuery = env.getProperty("update_result_seleted_with_client_id");
		String updateQuery2 = env.getProperty("update_result_verified_Y_with_request_id");
		// String query="select * from PSX_NSP_REQUEST_RESULTS_CRMS where verified='N'
		// and request_id='"+psxid+"'";
		String retainUpdate = "update PSX_NSP_REQUEST_RESULTS_CRMS set RETAIN='T', VERIFIED='Y', SELECTED='Y'  where PSX_ID=?";

		logger.info("For updating given queries executing ::");
		logger.info(updateQuery);
		logger.info(updateQuery2);
		logger.info(retainUpdate);
		
		
		
		String clearPreviousReject=env.getProperty("before_verify_clear_the_rejected_with_requestId");
		
		
		GetCheckBoxData data=(GetCheckBoxData)checkBoxList.get(0);
		String requestId=data.getRequestid();
		
		try {
			logger.info("Clearing Previous Rejected Data>>>");
			logger.info("Query is >>"+clearPreviousReject);
				logger.info("Request ID value  for updating >>>>::" + requestId);
				// jdbcTemplate.update(updateQuery, "R", getData.getCrmsclientid());
				jdbcTemplate.update(clearPreviousReject, requestId);

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		

		try {
			for (GetCheckBoxData getData : checkBoxList) {
				if (getData.getCrmsclientid() != null && getData.getRequestid() != null)// System.out.println("client ID
																						// value
																						// >>>>::"+getData.getCrmsclientid());
				{
					logger.info("checkbox updated values :" + getData.getPsx_id()+"  user:"+userId+" requestId"+getData.getRequestid());
					jdbcTemplate.update(updateQuery, "Y", "Y", getData.getPsx_id());
					jdbcTemplate.update(updateQuery2, userId, getData.getRequestid());
				}

				else if (getData.getRetain_clientid() != null) {
					logger.info("update retain value calling " + getData.getRetain_clientid());
					jdbcTemplate.update(retainUpdate, getData.getRetain_clientid());

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public List<ProcessRsponse> getAllNotVerifiedData(String clientId) {
		// TODO Auto-generated method stub
		logger.info("DAOIMPL  getAllNotVerifiedData(clientID)");
		logger.info("--------DAOIMPL getAllVerifiedData()---------given--'" + clientId + "'-----");
		// String query="select * from employee";

		/*
		 * String
		 * query="select * from PSX_NSP_REQUEST_RESULTS_CRMS where requesT_Id in (" +
		 * "select request_Id from PSX_NSP_REQUEST_RESULTS_CRMS where   (verified, columnn 2)  verified='Y' and RECORD_TYPE='INPUT' and CRMS_CLIENT_ID=?) order by RECORD_TYPE"
		 * ;
		 */

		String query = env.getProperty("get_all_not_verified_data_for_selected_view");
		logger.info("To load seleted view  below query is executing >>>>");
		logger.info(query);
		return jdbcTemplate.query(query, new Object[] { clientId }, new ResultSetExtractor<List<ProcessRsponse>>() {

			@Override
			public List<ProcessRsponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<ProcessRsponse> list = new ArrayList<ProcessRsponse>();

				while (rs.next()) {
					ProcessRsponse response = new ProcessRsponse();

					response.setAADHAAR(rs.getString("AADHAAR"));
					response.setCRMS_CLIENT_ID(rs.getString("CRMS_CLIENT_ID"));
					response.setMATCH_COUNT(rs.getString("MATCH_COUNT"));
					response.setREQUEST_ID(rs.getString("REQUEST_ID"));
					response.setMATCH_REASON(rs.getString("MATCH_REASON"));
					response.setPSX_ID(rs.getString("PSX_ID"));

					// response.setDOB1(rs.getString("DOB1"));

					String date = rs.getString("DOB1");
					System.out.println(date);
					String Date = date.substring(0, 10);
					response.setDOB1(Date);
					response.setGENDER(rs.getString("GENDER"));
					response.setNAME(rs.getString("NAME"));
					response.setFATHER_NAME(rs.getString("FATHER_NAME"));
					response.setPERMANENT_PHONE(rs.getString("PERMANENT_PHONE"));
					response.setPERMANENT_CITY(rs.getString("PERMANENT_CITY"));
					response.setIsVerified(rs.getString("VERIFIED"));
					response.setPERMANENT_ADDRESS(rs.getString("PERMANENT_ADDRESS"));
					response.setRESIDENCE_ADDRESS(rs.getString("RESIDENCE_ADDRESS"));
					response.setOFFICE_ADDRESS(rs.getString("OFFICE_ADDRESS"));
					response.setPERMANENT_PHONE(rs.getString("PERMANENT_PHONE"));
					response.setOFFICE_PHONE(rs.getString("OFFICE_PHONE"));
					response.setRESIDENCE_PHONE(rs.getString("RESIDENCE_PHONE"));

					response.setPERMANENT_PIN(rs.getString("PERMANENT_PIN"));
					response.setIsVerified(rs.getString("VERIFIED"));
					response.setSELECTED(rs.getString("SELECTED"));
					response.setIsRetain(rs.getString("RETAIN"));
					response.setSCALE_TYPE(rs.getString("SCALE_TYPE"));
					response.setMATCH_RULE(rs.getString("MATCH_RULE"));
					response.setREJECTED(rs.getString("REJECTED"));
					
					response.setCKYCNO(rs.getString("CKYCNO"));
					response.setCLIENT_TYPE(rs.getString("CLIENT_TYPE"));
					response.setCRNNO(rs.getString("CRNNO"));
					response.setGSTIN(rs.getString("GSTIN"));
					response.setSOURCE_SYSTEM(rs.getString("SOURCE_SYSTEM"));
					response.setSTATUS(rs.getString("STATUS"));
					response.setDOC(rs.getString("DOI"));


					list.add(response);
				}
				logger.info("____________response from getAllVerifiedData()_______");
				logger.info(list);
				return list;
			}
		});

	}

	@Override
	public List<ProcessRsponse> loadCheckerData(String clientId) {
		// TODO Auto-generated method stub

		logger.info("DAOIMPL loadCheckerData(clientId)");
		logger.info("--------DAOIMPL loadCheckerData() -----with------'" + clientId + "'-----");
		// String query="select * from employee";

		/*
		 * String
		 * query="select * from PSX_NSP_REQUEST_RESULTS_CRMS where requesT_Id in (" +
		 * "select request_Id from PSX_NSP_REQUEST_RESULTS_CRMS where verified='Y' and RECORD_TYPE='INPUT' and CRMS_CLIENT_ID=?) order by RECORD_TYPE"
		 * ;
		 */

		String query = env.getProperty("load_all_checker_data");
		logger.info("To load checker Data below query is executing ::>>>>");
		logger.info(query);
		return jdbcTemplate.query(query, new Object[] { clientId }, new ResultSetExtractor<List<ProcessRsponse>>() {

			@Override
			public List<ProcessRsponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<ProcessRsponse> list = new ArrayList<ProcessRsponse>();

				while (rs.next()) {
					ProcessRsponse response = new ProcessRsponse();

					response.setAADHAAR(rs.getString("AADHAAR"));
					response.setCRMS_CLIENT_ID(rs.getString("CRMS_CLIENT_ID"));
					response.setMATCH_COUNT(rs.getString("MATCH_COUNT"));
					response.setREQUEST_ID(rs.getString("REQUEST_ID"));
					response.setMATCH_REASON(rs.getString("MATCH_REASON"));
					response.setPSX_ID(rs.getString("PSX_ID"));

					// response.setDOB1(rs.getString("DOB1"));
					String date = rs.getString("DOB1");
					//System.out.println(date);
					String Date = date.substring(0, 10);
					response.setDOB1(Date);

					response.setNAME(rs.getString("NAME"));
					response.setGENDER(rs.getString("GENDER"));
					response.setFATHER_NAME(rs.getString("FATHER_NAME"));
					response.setPERMANENT_PHONE(rs.getString("PERMANENT_PHONE"));
					response.setPERMANENT_CITY(rs.getString("PERMANENT_CITY"));
					response.setIsVerified(rs.getString("VERIFIED"));
					response.setPERMANENT_ADDRESS(rs.getString("PERMANENT_ADDRESS"));
					response.setRESIDENCE_ADDRESS(rs.getString("RESIDENCE_ADDRESS"));
					response.setOFFICE_ADDRESS(rs.getString("OFFICE_ADDRESS"));
					response.setPERMANENT_PHONE(rs.getString("PERMANENT_PHONE"));
					response.setOFFICE_PHONE(rs.getString("OFFICE_PHONE"));
					response.setRESIDENCE_PHONE(rs.getString("RESIDENCE_PHONE"));

					response.setPERMANENT_PIN(rs.getString("PERMANENT_PIN"));
					response.setIsVerified(rs.getString("VERIFIED"));

					response.setSELECTED(rs.getString("SELECTED"));

					response.setIsRetain(rs.getString("RETAIN"));

					response.setSCALE_TYPE(rs.getString("SCALE_TYPE"));
					response.setMATCH_RULE(rs.getString("MATCH_RULE"));
					
					response.setCKYCNO(rs.getString("CKYCNO"));
					response.setCLIENT_TYPE(rs.getString("CLIENT_TYPE"));
					response.setCRNNO(rs.getString("CRNNO"));
					response.setGSTIN(rs.getString("GSTIN"));
					response.setSOURCE_SYSTEM(rs.getString("SOURCE_SYSTEM"));
					response.setSTATUS(rs.getString("STATUS"));
					response.setDOC(rs.getString("DOI"));
					
					
					
					list.add(response);
				}
				logger.info("response from loadcheckerDAta()____________________________");
				logger.info(list);
				return list;
			}
		});

	}

	@Override
	public boolean deleteSeleted(List<GetCheckBoxData> checkBoxList) {

		logger.info("DAOIMPL deleteSelected(checkBox) >>>>");
		logger.info("deleteSeleted() obtaind:: " + checkBoxList);

		/*
		 * String updateQuery =
		 * "update PSX_NSP_REQUEST_RESULTS_CRMS set verified = ?,SELECTED=? where CRMS_CLIENT_ID = ?"
		 * ;
		 * 
		 * String
		 * updateQuery2="UPDATE PSX_NSP_REQUEST_RESULTS_CRMS SET VERIFIED='N' WHERE REQUEST_ID=? AND RECORD_TYPE='INPUT'"
		 * ;
		 */
		String updateQuery = env.getProperty("update_verify_seleted_column_with_client_id");
		String updateQuery2 = env.getProperty("update_verified_N_with_request_id");
		// String query="select * from PSX_NSP_REQUEST_RESULTS_CRMS where verified='N'
		// and request_id='"+psxid+"'";
		logger.info("For deleting given queries executing ::");
		logger.info(updateQuery);
		logger.info(updateQuery2);
		
		
		try {
			for (GetCheckBoxData getData : checkBoxList) {
				System.out.println("client ID value  >>>>::" + getData.getCrmsclientid());

				jdbcTemplate.update(updateQuery, "N", "N", getData.getPsx_id());
				jdbcTemplate.update(updateQuery2, getData.getRequestid());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean rejectSeleted(List<GetCheckBoxData> checkBoxList,String user_Id) {
		logger.info("DAOIMP rejectSeleted(checkboxlist) >>>>:::");
		logger.info("rejectSeleted CheckBox:: " + checkBoxList);
		// String updateQuery = "update PSX_NSP_REQUEST_RESULTS_CRMS set verified = ?
		// where CRMS_CLIENT_ID = ?";

		// String updateQuery2="UPDATE PSX_NSP_REQUEST_RESULTS_CRMS SET VERIFIED='R'
		// WHERE REQUEST_ID=? AND RECORD_TYPE='INPUT'";
		String updateQuery2 = env.getProperty("update_verified_R_with_request_id");

		// String query="select * from PSX_NSP_REQUEST_RESULTS_CRMS where verified='N'
		// and request_id='"+psxid+"'";
		logger.info("For Rejecting below query is executing ::>>>>");
		logger.info(updateQuery2);

		try {
			for (GetCheckBoxData getData : checkBoxList) {

				// jdbcTemplate.update(updateQuery, "R", getData.getCrmsclientid());
				jdbcTemplate.update(updateQuery2, user_Id,  getData.getRequestid());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean approveSeleted(List<GetCheckBoxData> checkBoxList,String userId) {
		logger.info("DAOIMPL   rejectSeleted CheckBox::>>>>");
		logger.info("approve CheckBox data:: " + checkBoxList);
		// String updateQuery = "update PSX_NSP_REQUEST_RESULTS_CRMS set verified = ?
		// where CRMS_CLIENT_ID = ?";

		// String updateQuery2="UPDATE PSX_NSP_REQUEST_RESULTS_CRMS SET VERIFIED='C'
		// WHERE REQUEST_ID=? AND RECORD_TYPE='INPUT'";

		String updateQuery2 = env.getProperty("update_verifeid_C_with_request_id");
		logger.info("For seleted approve  below query is executing >>>>");
		logger.info(updateQuery2);
		// String query="select * from PSX_NSP_REQUEST_RESULTS_CRMS where verified='N'
		// and request_id='"+psxid+"'";
		try {
			for (GetCheckBoxData getData : checkBoxList) {
				logger.info("Request ID value  for updating >>>>::" + getData.getRequestid());

				// jdbcTemplate.update(updateQuery, "R", getData.getCrmsclientid());
				jdbcTemplate.update(updateQuery2,userId, getData.getRequestid());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public List<ProcessRsponse> responseList(String policy_number) {
		logger.info("DAOIMPL responseList(policynumber)>>>>>>::");
		logger.info("--------DAOIMPL responseList()---------given--'" + policy_number + "'-----");
		// String query="select * from employee";

		/*
		 * String
		 * query="select * from PSX_NSP_REQUEST_RESULTS_CRMS where requesT_Id in (" +
		 * "select request_Id from PSX_NSP_REQUEST_RESULTS_CRMS where   (verified, columnn 2)  verified='Y' and RECORD_TYPE='INPUT' and CRMS_CLIENT_ID=?) order by RECORD_TYPE"
		 * ;
		 */

		String query = env.getProperty("select_all_by_policy_number");

		return jdbcTemplate.query(query, new Object[] { policy_number },
				new ResultSetExtractor<List<ProcessRsponse>>() {

					@Override
					public List<ProcessRsponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<ProcessRsponse> list = new ArrayList<ProcessRsponse>();

						while (rs.next()) {
							ProcessRsponse response = new ProcessRsponse();

							response.setAADHAAR(rs.getString("AADHAAR"));
							response.setCRMS_CLIENT_ID(rs.getString("CRMS_CLIENT_ID"));
							response.setMATCH_COUNT(rs.getString("MATCH_COUNT"));
							response.setREQUEST_ID(rs.getString("REQUEST_ID"));
							response.setMATCH_REASON(rs.getString("MATCH_REASON"));
							response.setPSX_ID(rs.getString("PSX_ID"));
							// response.setDOB1(rs.getString("DOB1"));
							String date = rs.getString("DOB1");
							System.out.println(date);
							String Date = date.substring(0, 10);
							response.setDOB1(Date);

							response.setNAME(rs.getString("NAME"));
							response.setGENDER(rs.getString("GENDER"));
							response.setFATHER_NAME(rs.getString("FATHER_NAME"));
							response.setPERMANENT_PHONE(rs.getString("PERMANENT_PHONE"));
							response.setPERMANENT_CITY(rs.getString("PERMANENT_CITY"));
							response.setIsVerified(rs.getString("VERIFIED"));
							response.setPERMANENT_ADDRESS(rs.getString("PERMANENT_ADDRESS"));
							response.setPERMANENT_PIN(rs.getString("PERMANENT_PIN"));
							response.setIsVerified(rs.getString("VERIFIED"));
							response.setSELECTED(rs.getString("SELECTED"));
							response.setIsRetain(rs.getString("RETAIN"));
							response.setSCALE_TYPE(rs.getString("SCALE_TYPE"));
							response.setMATCH_RULE(rs.getString("MATCH_RULE"));
							
							response.setCKYCNO(rs.getString("CKYCNO"));
							response.setCLIENT_TYPE(rs.getString("CLIENT_TYPE"));
							response.setCRNNO(rs.getString("CRNNO"));
							response.setGSTIN(rs.getString("GSTIN"));
							response.setSOURCE_SYSTEM(rs.getString("SOURCE_SYSTEM"));
							response.setSTATUS(rs.getString("STATUS"));
							response.setDOC(rs.getString("DOI"));

							list.add(response);
						}
						logger.info("____________response from getAllVerifiedData()_______");
						logger.info(list);
						return list;
					}
				});

	}

	@Override
	public List<ProcessRsponse> lifeAsiaReq(List<GetCheckBoxData> checkBoxList) throws DAOException {
		
		String lifeAsiaQuery="select * from PSX_NSP_REQUEST_RESULTS_CRMS where requesT_Id=? and CRMS_CLIENT_ID=? order by record_type";
		List<ProcessRsponse> list = null;
		List<ProcessRsponse> CompleteResponseList = new ArrayList<ProcessRsponse>();
		String getSourceClientID_query="select CRMS_CLIENT_ID from PSX_NSP_REQUEST_RESULTS_CRMS where RECORD_TYPE='INPUT' and REQUEST_ID=?";
			
		
		try {
			for (GetCheckBoxData getData : checkBoxList) {
				System.out.println("client ID value  >>>>::" + getData.getCrmsclientid());
				
				list =new ArrayList<ProcessRsponse>();
				
				String sourceClientId=(String)jdbcTemplate.queryForObject(getSourceClientID_query,new Object[] {getData.getRequestid()},String.class);

				list = jdbcTemplate.query(lifeAsiaQuery,
						new Object[] { getData.getRequestid(), getData.getCrmsclientid()}, (rs, no) -> {
							ProcessRsponse response = new ProcessRsponse();
							response.setAADHAAR(rs.getString("AADHAAR"));
							response.setCRMS_CLIENT_ID(rs.getString("CRMS_CLIENT_ID"));
							response.setMATCH_COUNT(rs.getString("MATCH_COUNT"));
							response.setREQUEST_ID(rs.getString("REQUEST_ID"));
							response.setMATCH_REASON(rs.getString("MATCH_REASON"));
							response.setRECORD_TYPE(rs.getString("RECORD_TYPE"));
							response.setSourceClient_ID(sourceClientId);
							response.setPSX_ID(rs.getString("PSX_ID"));
							// response.setDOB1(rs.getString("DOB1"));
							String date = rs.getString("DOB1");
							System.out.println(date);
							String Date = date.substring(0, 10);
							response.setDOB1(Date);

							response.setNAME(rs.getString("NAME"));
							response.setGENDER(rs.getString("GENDER"));
							response.setFATHER_NAME(rs.getString("FATHER_NAME"));
							response.setPERMANENT_PHONE(rs.getString("PERMANENT_PHONE"));
							response.setPERMANENT_CITY(rs.getString("PERMANENT_CITY"));
							response.setIsVerified(rs.getString("VERIFIED"));
							response.setPERMANENT_ADDRESS(rs.getString("PERMANENT_ADDRESS"));
							response.setPERMANENT_PIN(rs.getString("PERMANENT_PIN"));
							response.setIsVerified(rs.getString("VERIFIED"));
							response.setSELECTED(rs.getString("SELECTED"));
							response.setIsRetain(rs.getString("RETAIN"));
							response.setPOLICY_NUMBER(rs.getString("POLICY_NUMBER"));
							response.setSCALE_TYPE(rs.getString("SCALE_TYPE"));
							response.setMATCH_RULE(rs.getString("MATCH_RULE"));
							response.setINSERT_TIME(rs.getString("INSERT_TIME"));

							response.setCKYCNO(rs.getString("CKYCNO"));
							response.setCLIENT_TYPE(rs.getString("CLIENT_TYPE"));
							response.setCRNNO(rs.getString("CRNNO"));
							response.setGSTIN(rs.getString("GSTIN"));
							response.setSOURCE_SYSTEM(rs.getString("SOURCE_SYSTEM"));
							response.setSTATUS(rs.getString("STATUS"));
							response.setDOC(rs.getString("DOI"));
							
							return response;
						});
				
				
				CompleteResponseList.addAll(list);

				
			}
			
			
			
			logger.info(CompleteResponseList.size()+"CompleteResponseList #####################:::"+CompleteResponseList);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("while fetching details from PSX_NSP_REQUEST_RESULTS_CRMS got an exception "+e.getMessage());
		}
		logger.info("approve listData>>>>>>>>>>>");
		

		
		return CompleteResponseList;	
	}

	@Override
	public boolean verifyClientID(String cleintID) {
	   // String sql = "SELECT count(1) FROM PSX_NSP_REQUEST_RESULTS_CRMS WHERE CRMS_CLIENT_ID = ?";
		//boolean result = false;

	/*	int count = jdbcTemplate.queryForObject(
	                        sql, new Object[] { cleintID }, Integer.class);*/
		
		logger.info("Inserting data in bckp table with this client Id >>::"+cleintID);
		String backup_insert="INSERT INTO psx_nsp_request_results_crms_b SELECT * FROM psx_nsp_request_results_crms WHERE REQUEST_ID in (select request_Id from PSX_NSP_REQUEST_RESULTS_CRMS where  RECORD_TYPE='INPUT' and CRMS_CLIENT_ID=?)"; 
		logger.info("Bckp Insert Query >>::"+backup_insert);

		try
	    {
			jdbcTemplate.update(backup_insert, cleintID);
	    }
	    catch (RuntimeException runtimeException) 
	    {
	       logger.info("Error While inserting data in backp table");
	        throw runtimeException;
	    }
		
			String deleteQuery="delete  PSX_NSP_REQUEST_RESULTS_CRMS where requesT_Id in (select request_Id from PSX_NSP_REQUEST_RESULTS_CRMS where  RECORD_TYPE='INPUT' and CRMS_CLIENT_ID=?)"; 
			logger.info("deleting existed data with this client Id:: "+cleintID);
			logger.info("Delete query:: "+deleteQuery);
		
			try
		    {
				jdbcTemplate.update(deleteQuery, cleintID);
		    }
		    catch (RuntimeException runtimeException) 
		    {
		       logger.info("Error While deleting existing results data");
		        throw runtimeException;
		    }
			
			
		//	
		
		return true;
	}

	@Override
	public List<ProcessRsponse> getDedupeReport(String startDate, String endDate)  {
	

			logger.info("--------DAOIMPL getReport()>>>-------");
			logger.info("--------DAOIMPL getReport-------with ----'" + startDate + " "+endDate);
			// String query="select * from employee";

			
		

			String query = env.getProperty("getreport_between_selected_dates");
			logger.info("To Get Report  below  query is  executing >>>::");
			
			logger.info("startDate **************"+startDate+" "+endDate);
			
			String sDate1=startDate;  
			String toDate=endDate;
		    
			
			// Date date = new Date();  
			    
			   /* System.out.println("Date Format with MM/dd/yyyy : "+strDate);  
			  
			    formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
			    strDate = formatter.format(date); */
			
			
			
			logger.info(query);
			return jdbcTemplate.query(query, new Object[] { startDate, endDate }, new ResultSetExtractor<List<ProcessRsponse>>() {

				@Override
				public List<ProcessRsponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<ProcessRsponse> list = new ArrayList<ProcessRsponse>();
					

					while (rs.next()) {
						ProcessRsponse response = new ProcessRsponse();
						// view page
						/*
						 * <td>${response.CRMS_CLIENT_ID}</td> <td>${response.MATCH_REASON}</td>
						 * <td>${response.MATCH_COUNT}</td> <td>${response.SCALE_TYPE}</td>
						 * <td>${response.NAME}</td> <td>${response.DOB1}</td>
						 * <td>${response.GENDER}</td> <td>${response.PERMANENT_ADDRESS}</td>
						 * <td>${response.RESIDENCE_ADDRESS}</td> <td>${response.OFFICE_ADDRESS}</td>
						 * <td>${response.PERMANENT_PHONE}</td> <td>${response.RESIDENCE_PHONE}</td>
						 * <td>${response.OFFICE_PHONE}</td> <td>${response.AADHAAR}</td>
						 */
						logger.info("inside RS Client_id"+rs.getString("CRMS_CLIENT_ID"));
						response.setCRMS_CLIENT_ID(rs.getString("CRMS_CLIENT_ID"));
						response.setMATCH_COUNT(rs.getString("MATCH_COUNT"));
						response.setREQUEST_ID(rs.getString("REQUEST_ID"));
						response.setMATCH_REASON(rs.getString("MATCH_REASON"));
						// response.setDOB1(rs.getString("DOB1"));
						response.setRECORD_TYPE(rs.getString("RECORD_TYPE"));
						response.setIsVerified(rs.getString("VERIFIED"));
						response.setSCALE_TYPE(rs.getString("SCALE_TYPE"));
						response.setMATCH_RULE(rs.getString("MATCH_RULE"));
						response.setIsRetain(rs.getString("RETAIN"));
						response.setIsVerified(rs.getString("VERIFIED"));
						response.setPOLICY_NUMBER(rs.getString("POLICY_NUMBER"));
						response.setSOURCE_TYPE(rs.getString("SOURCE_TYPE"));
						response.setMATCH_TYPE(rs.getString("MATCH_TYPE"));
						response.setMAKER_ID(rs.getString("MAKER_ID"));
						
						response.setCKYCNO(rs.getString("CKYCNO"));
						response.setCLIENT_TYPE(rs.getString("CLIENT_TYPE"));
						response.setCRNNO(rs.getString("CRNNO"));
						response.setGSTIN(rs.getString("GSTIN"));
						response.setSOURCE_SYSTEM(rs.getString("SOURCE_SYSTEM"));
						response.setSTATUS(rs.getString("STATUS"));
						response.setDOC(rs.getString("DOI"));
						
						// logger.info(rs.getString("VERIFIED"));

						list.add(response);
					}
					logger.info("seleted Date response____________________________");
					logger.info(list);
				
					return list;
				}
			});

		}
/*	create table client_merge_response_details
   (error_code varchar2(20),error_description varchar2(500),flag varchar2(100),
			merge_client_no varchar2(100),policy_no varchar(100),retained_client_no varchar2(100),
			destination varchar2(100),source varchar2(100),transaction_dt varchar2(100),transaction_id varchar2(100),transaction_type varchar2(200));*/
	
	@Override
	public boolean saveClientMergeDetails(List<ClientMergeESBResponse> responseList,String Request_Id) throws DAOException {
		try {
			logger.info("Inserting Life Asia Merge Response : "+responseList);
			
			logger.info("The Clientmerge response details insertion query is >>"+env.getProperty("ASIA_CLIENT_MERGE_RESPONSES_INSERT_QUERY"));
			jdbcTemplate.batchUpdate(env.getProperty("ASIA_CLIENT_MERGE_RESPONSES_INSERT_QUERY"), new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt, int i) throws SQLException {
				if(responseList !=null) {
				ClientMergeESBResponse responseObj=responseList.get(i);		
				if(responseObj!=null) {
				if(responseObj.getData()!=null) {
				pstmt.setObject(1,responseObj.getData().getErrorCode());
				pstmt.setObject(2,responseObj.getData().getErrorDescription());
				pstmt.setObject(3,responseObj.getData().getFlag());
				pstmt.setObject(4, responseObj.getData().getMergeClientNumber());
				pstmt.setObject(5,responseObj.getData().getPolicyNumber());
				pstmt.setObject(6, responseObj.getData().getRetainedClientNumber());
			
				}
				else if(responseObj.getData()==null) {
				pstmt.setObject(1,null);
				pstmt.setObject(2,null);
				pstmt.setObject(3,null);
				pstmt.setObject(4, null);
				pstmt.setObject(5,null);
				pstmt.setObject(6, null);
				}
				
				if(responseObj.getHeader()!=null) {
					
					pstmt.setObject(7,responseObj.getHeader().getDestination());
					pstmt.setObject(8,responseObj.getHeader().getSource());
					pstmt.setObject(9,responseObj.getHeader().getTransactionDT());
					pstmt.setObject(10, responseObj.getHeader().getTransactionID());
					pstmt.setObject(11,responseObj.getHeader().getTransactionType());
						
				}
				else if(responseObj.getHeader()==null) {
					
					pstmt.setObject(7,null);
					pstmt.setObject(8,null);
					pstmt.setObject(9,null);
					pstmt.setObject(10,null);
					pstmt.setObject(11,null);
						
				}
				if(Request_Id!=null)
				{
					logger.info("While updating Request Id");
					pstmt.setObject(12,Request_Id);
				}
				else {
					logger.info("While updating Request Id");
					pstmt.setObject(12,null);
				}
				}
			}
				
			}
			@Override
			public int getBatchSize() {
				
				return responseList.size();
			}

			});
			logger.info("Client Merge Response Insertion Completed !!");
			flag=true;

		}
		catch(Exception e) {
			e.printStackTrace();
			logger.error(e);
			
			throw new DAOException("while inserting Client Merge detail got an error "+e.getMessage());
						
			}
		
		
		return flag;
		
	}

	@Override
	public int getCountForRetain(String requestId) {
		// TODO Auto-generated method stub
		logger.info("DAOIMP >>>");
		logger.info("getCountForRetain");

		String countquery=env.getProperty("count_query_for_retain_and_selected");
		int count=jdbcTemplate.queryForObject(countquery,new Object[] {requestId}, Integer.class);
		logger.info("count ::"+count);
		return count;
	}

	@Override
	public String sourceClientID(String requestId) {
		// TODO Auto-generated method stub
		logger.info("Getting Source ID with "+requestId);
		String query=env.getProperty("select_source_client_id");
		String sourceclientID=jdbcTemplate.queryForObject(query,new Object[] {requestId}, String.class);
		return sourceclientID;
	}

	@Override
	public String getRetainID(String requestId) {
		// TODO Auto-generated method stub
		logger.info("Getting Retain with "+requestId);
		String query=env.getProperty("select_retain_client_id");
		try {
		String retainClientID=jdbcTemplate.queryForObject(query,new Object[] {requestId}, String.class);
		
		if ( retainClientID.isEmpty() || retainClientID==null){
			  return "";
			}else{  // list contains more than 1 elements
			  //your wish, you can either throw the exception or return 1st element.   
				return retainClientID;
			}
		
		}
		catch(EmptyResultDataAccessException e) {
			return "";
		}
		
	
	}

	@Override
	public List<ProcessRsponse> getSelectedCrmsID(String requestId) {
		// TODO Auto-generated method stub
		String query=env.getProperty("selected_client_Id");
		List<ProcessRsponse> responseList=new ArrayList<ProcessRsponse>();
		
		List<Map<String, Object>> getSeletedData=jdbcTemplate.queryForList(query,requestId);
		for(Map row:getSeletedData)
		{
			ProcessRsponse response=new ProcessRsponse();
			response.setCRMS_CLIENT_ID((String)row.get("CRMS_CLIENT_ID"));
			response.setPOLICY_NUMBER((String)row.get("POLICY_NUMBER"));
			responseList.add(response);
		}
		return responseList;
	}

	@Override
	public List<ProcessRsponse> getSelectedClientsNotInput(String requestId) {
	
		String query=env.getProperty("selected_client_id_not_input");
		List<ProcessRsponse> responseList=new ArrayList<ProcessRsponse>();
		
		List<Map<String, Object>> getSeletedData=jdbcTemplate.queryForList(query);
		for(Map row:getSeletedData)
		{
			ProcessRsponse response=new ProcessRsponse();
			response.setCRMS_CLIENT_ID((String)row.get("CRMS_CLIENT_ID"));
			response.setPOLICY_NUMBER((String)row.get("POLICY_NUMBER"));

			responseList.add(response);
		}
		return responseList;
	}

	@Override
	public String getPolicyNumber(String requestId) {
		String query=env.getProperty("select_policy_number");
		String pocilynumber=jdbcTemplate.queryForObject(query,new Object[] {requestId}, String.class);
		return pocilynumber;
	}

	@Override
	public boolean noActionRequired(String sourceClientId) {
		// TODO Auto-generated method stub
		logger.info("NoAction DAO IMPL >>>");
		logger.info("Given value ::"+sourceClientId);
		
		String updatequery=env.getProperty("no_action_required_client_id");
		logger.info("query ::"+updatequery);
		try {
		jdbcTemplate.update(updatequery, sourceClientId);		
		
		}catch(DataAccessException e)
		{
			logger.info("While updating C getting error");
			return false;
		}
		return true;
	}

	@Override
	public List<ProcessRsponse> getMISReport(String startDate, String endDate) {
		logger.info("--------DAOIMPL getReport()>>>-------");
		logger.info("--------DAOIMPL getReport-------with ----'" + startDate + " "+endDate);
		
		String query = env.getProperty("getreport_between_selected_dates");
		logger.info("To Get Report  below  query is  executing >>>::");
		
		logger.info("startDate **************"+startDate+" "+endDate);
		
		String sDate1=startDate;  
		String toDate=endDate;
	    
		
		logger.info(query);
		return jdbcTemplate.query(query, new Object[] { startDate, endDate }, new ResultSetExtractor<List<ProcessRsponse>>() {

			@Override
			public List<ProcessRsponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<ProcessRsponse> list = new ArrayList<ProcessRsponse>();
				

				while (rs.next()) {
					ProcessRsponse response = new ProcessRsponse();
					
					logger.info("inside RS Client_id"+rs.getString("CRMS_CLIENT_ID"));
					response.setCRMS_CLIENT_ID(rs.getString("CRMS_CLIENT_ID"));
					response.setMATCH_COUNT(rs.getString("MATCH_COUNT"));
					response.setREQUEST_ID(rs.getString("REQUEST_ID"));
					response.setMATCH_REASON(rs.getString("MATCH_REASON"));
					// response.setDOB1(rs.getString("DOB1"));
					response.setRECORD_TYPE(rs.getString("RECORD_TYPE"));
					response.setIsVerified(rs.getString("VERIFIED"));
					response.setSCALE_TYPE(rs.getString("SCALE_TYPE"));
					response.setMATCH_RULE(rs.getString("MATCH_RULE"));
					response.setIsRetain(rs.getString("RETAIN"));
					response.setIsVerified(rs.getString("VERIFIED"));
					response.setPOLICY_NUMBER(rs.getString("POLICY_NUMBER"));
					response.setSOURCE_TYPE(rs.getString("SOURCE_TYPE"));
					response.setMATCH_TYPE(rs.getString("MATCH_TYPE"));
					response.setMAKER_ID(rs.getString("MAKER_ID"));
					
					response.setCKYCNO(rs.getString("CKYCNO"));
					response.setCLIENT_TYPE(rs.getString("CLIENT_TYPE"));
					response.setCRNNO(rs.getString("CRNNO"));
					response.setGSTIN(rs.getString("GSTIN"));
					response.setSOURCE_SYSTEM(rs.getString("SOURCE_SYSTEM"));
					response.setSTATUS(rs.getString("STATUS"));
					response.setDOC(rs.getString("DOI"));
					
					// logger.info(rs.getString("VERIFIED"));

					list.add(response);
				}
				logger.info("seleted Date response____________________________");
				logger.info(list);
			
				return list;
			}
		});

	}

	@Override
	public List<ProcessRsponse> getAllSelectedDatawithReqId(String requestID) {
		logger.info("--------DAOIMPL getAllSelectedDatawithReqId()>>>-------");
		// String query="select * from employee";
		String query = env.getProperty("select_source_retain_selected_id");
		logger.info("To Get Report  below  query is  executing >>>::");
		
		logger.info(query);
		return jdbcTemplate.query(query, new Object[] {requestID }, new ResultSetExtractor<List<ProcessRsponse>>() {

			@Override
			public List<ProcessRsponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<ProcessRsponse> list = new ArrayList<ProcessRsponse>();
				

				while (rs.next()) {
					ProcessRsponse response = new ProcessRsponse();
					// view page
					
					
					 
					logger.info("inside RS Client_id"+rs.getString("CRMS_CLIENT_ID"));
					response.setCRMS_CLIENT_ID(rs.getString("CRMS_CLIENT_ID"));
					
					response.setRECORD_TYPE(rs.getString("RECORD_TYPE"));
					response.setIsVerified(rs.getString("VERIFIED"));
				
					response.setIsRetain(rs.getString("RETAIN"));
					response.setPOLICY_NUMBER(rs.getString("POLICY_NUMBER"));
					response.setSOURCE_TYPE(rs.getString("SOURCE_TYPE"));
			
					response.setMAKER_ID(rs.getString("MAKER_ID"));
					
					// logger.info(rs.getString("VERIFIED"));

					list.add(response);
				}
				logger.info("seleted Date response____________________________");
				logger.info(list);
			
				return list;
			}
		});
	}

	@Override
	public boolean approvewithRequestId(String requestId,String userId) {
		
		
			// TODO Auto-generated method stub
			logger.info("approvewithRequestId DAO IMPL >>>");
			logger.info("Given value ::"+requestId);			
			String updatequery=env.getProperty("update_verifeid_C_with_request_id");
			logger.info("query ::"+updatequery);
			try {
			jdbcTemplate.update(updatequery, userId,requestId);		
			
			}catch(DataAccessException e)
			{
				logger.info("While updating C getting error");
				return false;
			}
			return true;
		}
	@Override
	public List<ProcessRsponse> getAllVerifiedData(String clientId) {
		// TODO Auto-generated method stub
		logger.info("DAOIMPL  getAllVerifiedData(clientID)");
		logger.info("--------DAOIMPL getAllVerifiedData()---------given--'" + clientId + "'-----");
		// String query="select * from employee";

		/*
		 * String
		 * query="select * from PSX_NSP_REQUEST_RESULTS_CRMS where requesT_Id in (" +
		 * "select request_Id from PSX_NSP_REQUEST_RESULTS_CRMS where   (verified, columnn 2)  verified='Y' and RECORD_TYPE='INPUT' and CRMS_CLIENT_ID=?) order by RECORD_TYPE"
		 * ;
		 */

		String query = env.getProperty("get_all_verified_data_for_selected_view");
		logger.info("To load seleted view  below query is executing >>>>");
		logger.info(query);
		return jdbcTemplate.query(query, new Object[] { clientId }, new ResultSetExtractor<List<ProcessRsponse>>() {

			@Override
			public List<ProcessRsponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<ProcessRsponse> list = new ArrayList<ProcessRsponse>();

				while (rs.next()) {
					ProcessRsponse response = new ProcessRsponse();

					response.setAADHAAR(rs.getString("AADHAAR"));
					response.setCRMS_CLIENT_ID(rs.getString("CRMS_CLIENT_ID"));
					response.setMATCH_COUNT(rs.getString("MATCH_COUNT"));
					response.setREQUEST_ID(rs.getString("REQUEST_ID"));
					response.setMATCH_REASON(rs.getString("MATCH_REASON"));
					response.setPSX_ID(rs.getString("PSX_ID"));

					// response.setDOB1(rs.getString("DOB1"));

					String date = rs.getString("DOB1");
					System.out.println(date);
					String Date = date.substring(0, 10);
					response.setDOB1(Date);
					response.setGENDER(rs.getString("GENDER"));
					response.setNAME(rs.getString("NAME"));
					response.setFATHER_NAME(rs.getString("FATHER_NAME"));
					response.setPERMANENT_PHONE(rs.getString("PERMANENT_PHONE"));
					response.setPERMANENT_CITY(rs.getString("PERMANENT_CITY"));
					response.setIsVerified(rs.getString("VERIFIED"));
					response.setPERMANENT_ADDRESS(rs.getString("PERMANENT_ADDRESS"));
					response.setRESIDENCE_ADDRESS(rs.getString("RESIDENCE_ADDRESS"));
					response.setOFFICE_ADDRESS(rs.getString("OFFICE_ADDRESS"));
					response.setPERMANENT_PHONE(rs.getString("PERMANENT_PHONE"));
					response.setOFFICE_PHONE(rs.getString("OFFICE_PHONE"));
					response.setRESIDENCE_PHONE(rs.getString("RESIDENCE_PHONE"));

					response.setPERMANENT_PIN(rs.getString("PERMANENT_PIN"));
					response.setIsVerified(rs.getString("VERIFIED"));
					response.setSELECTED(rs.getString("SELECTED"));
					response.setIsRetain(rs.getString("RETAIN"));
					response.setSCALE_TYPE(rs.getString("SCALE_TYPE"));
					response.setMATCH_RULE(rs.getString("MATCH_RULE"));
					response.setCKYCNO(rs.getString("CKYCNO"));
					response.setCLIENT_TYPE(rs.getString("CLIENT_TYPE"));
					response.setCRNNO(rs.getString("CRNNO"));
					response.setGSTIN(rs.getString("GSTIN"));
					response.setSOURCE_SYSTEM(rs.getString("SOURCE_SYSTEM"));
					response.setSTATUS(rs.getString("STATUS"));
					response.setDOC(rs.getString("DOI"));

					list.add(response);
				}
				logger.info("____________response from getAllVerifiedData()_______");
				logger.info(list);
				return list;
			}
		});

	}
	
	
	@Override
	public boolean updateErrorRecordsForMakerPage(LifeAsiaSucessAndErrorResponses mergeErrorResponse) throws DAOException {
		// TODO Auto-generated method stub
		//update_verifeid_C_with_request_id=UPDATE PSX_NSP_REQUEST_RESULTS_CRMS SET VERIFIED='N' ,checker_id=?, checker_veri_ts=SYSTIMESTAMP WHERE REQUEST_ID=? AND RECORD_TYPE='INPUT'
		////update  kli_asia_req_data_tbl set merge_status='X' where client_merge_id=123 and merge_status='E'
		boolean flag=false;
		logger.info("updateErrorRecordsForMakerPage>>>>");
		try {
		String query = env.getProperty("UPDATE_VERIFIED_N_FOR_MERGEFAILED_REQUESTID");	
		logger.info("Query is ::"+query);
		
		jdbcTemplate.update(query,new Object[] {mergeErrorResponse.getUserId(),mergeErrorResponse.getRequestId()});
		
		jdbcTemplate.update(env.getProperty("UPDATING_CLIENT_MERGE_RECORS_TO_X"),new Object[] {mergeErrorResponse.getCrmsClientNum()});
		
		flag=true;
		}
		catch(Exception e) {
		logger.error("while upadating merge records got an error");
		throw new DAOException("while upadating merge records got an error"+e.getMessage());
		}
		return flag;
		
	}

	@Override
	public void saveKliAsiaRequestData(ClientMergeESBRequest request, ClientMergeESBResponse response,String crmsClientId,String requestid) {
		///insert into  air_asia_req_data_tbl(source,destination,transaction_dt,transaction_type,action,policy_no,merge_client_no,retained_client_no,sorce_client_no,res_merge_clent_no,res_policy_num,merge_status) values(?,?,?,?,?,?,?,?,?,?,?,?)
		logger.info("saveKliAsiaRequestData >>>>>");
		try {
		String query=env.getProperty("INSERTING_AIR_ASIA_CLIENT_REQUEST");
		logger.info("Query is ::>> "+query);
		String merge_status="";
		logger.info("$#$#$#$# response.getData().getErrorCode():: "+response.getData().getErrorCode());
		logger.info("$#$#$#$# response.getData().getgetFlag():: "+response.getData().getFlag());
		if("Y".equalsIgnoreCase(response.getData().getFlag())) {
			merge_status="C";
		}
		else {
			merge_status="E";
		}
		jdbcTemplate.update(query,new Object[]{
				request.getHeader().getSource(),
				request.getHeader().getDestination(),
				request.getHeader().getTransactionDT(),
				request.getHeader().getTransactionType(),
				request.getData().getAction(),
				request.getData().getPolicyNumber(),
				request.getData().getMergeClientNumber(),
				request.getData().getRetainedClientNumber(),
				request.getData().getSourceClientNumber(),
				response.getData().getMergeClientNumber(),
				response.getData().getPolicyNumber(),
				merge_status,
				crmsClientId,
				response.getData().getErrorCode(),
				response.getData().getErrorDescription(),
				response.getData().getFlag(),
				requestid
		});
		}
		catch(Exception e) {
			logger.error("while inserting life asia request info got an error "+e.getMessage());
		}
	}

	@Override
	public List<ClientMergeESBRequest> getKliFailurecasesForReposting(String purposeId) {
		// TODO Auto-generated method stub
		//FETCHING_KLI_ASIA_FAILURE_RECORDS_FOR_REPROPCESS=
		//select source,destination,transaction_dt,transaction_type,action,policy_no,merge_client_no,retained_client_no,sorce_client_no
		//from kli_asia_req_data_tbl where client_merge_id=? and merge_status='E'
		List<ClientMergeESBRequest> requestList=null;
		logger.info("getKliFailurecasesForReposting >>>");
		
		try {
		String query=env.getProperty("FETCHING_KLI_ASIA_FAILURE_RECORDS_FOR_REPROPCESS");
		logger.info("Query :: >>> "+query);

		requestList=jdbcTemplate.query(query,new Object[] {purposeId},(rs,num)-> {
			ClientMergeESBRequest req=new ClientMergeESBRequest();
			Header header=new Header();
			Data data=new Data();
			header.setSource(rs.getString(1));
			header.setDestination(rs.getString(2));
			header.setTransactionDT(rs.getString(3));
			header.setTransactionType(rs.getString(4));
			
			data.setAction(rs.getString(5));
			data.setPolicyNumber(rs.getString(6));
			data.setMergeClientNumber(rs.getString(7));
			data.setRetainedClientNumber(rs.getString(8));
			data.setSourceClientNumber(rs.getString(9));
			
			req.setHeader(header);
			req.setData(data);
			
			return req;
		});
		}catch(Exception e) {
			logger.error("while fetching error records got an error::"+e.getMessage());
		}
		
		
		return requestList;
		
	}

	@Override
	public void updateKliAsiaRequestData(ClientMergeESBRequest request, ClientMergeESBResponse response,String crmsClientId) {
		//update  kli_asia_req_data_tbl set merge_status='C' where client_merge_id=? and merge_client_no=? and ,policy_no=?
		logger.info("updateKliAsiaRequestData >>>");
		
		try {
		String query=env.getProperty("UPDATING_REPOSTED_LIFEASIA_REQUESTS");
		logger.info("Query is >> "+query);
		jdbcTemplate.update(query, new Object[] {crmsClientId,response.getData().getMergeClientNumber(),response.getData().getPolicyNumber()});
		}catch(Exception e) {
			
		logger.error("while updating reposted merge records got an error::"+e.getMessage());
		}
		
	}

	@Override
	public int validateChecker(String policynumber, String userId) {
	
		logger.info("validating maker wether existed with same policy");
		logger.info("validating checker data with user Id and policy number :"+userId+" "+policynumber);
		int  count=0;
		try {
			String query=env.getProperty("validate_userid_wether_existed_with_same_policy");
			logger.info("Query is >> "+query);
			count=jdbcTemplate.queryForObject(query, new Object[] {userId,policynumber},Integer.class);
			}catch(Exception e) {
				
			logger.error("while updating reposted merge records got an error::"+e.getMessage());
			}
		logger.info("Validate Checker count :"+count);
		return count;
	}
	
	@Override
	public int checkDedupeVerificationforChecker(String crmsClientId,String clinetRole) throws DAOException {
		
		//String cmsclientId="";
		int clineCount = 0;
		String query = null;
		System.out.println("CLINT ID"+crmsClientId);
		try {
			
			if("M".equalsIgnoreCase(clinetRole))
			{
				query =env.getProperty("DEDUPE_VERIFICATION_COUNT_CHECK_QUERY_FOR_MAKER");				
			}else if("C".equalsIgnoreCase(clinetRole))
			{
				query =env.getProperty("DEDUPE_VERIFICATION_COUNT_CHECK_QUERY_FOR_CHECKER");
			}
		
		logger.info("inside checkDedupeVerificationforChecker method");
		logger.info("dedupe verification check count query "+query);
		//String query ="select count(1) from psx_nsp_request_results_crms where crms_client_id= '6100143' and verified = 'Y' ";
		
		String crmsClientResult =	jdbcTemplate.queryForObject(query, new Object[] {crmsClientId},(rs,num)->{
		
		String value=rs.getString("aa");
				
			return  value;
			
		});
		
		clineCount=Integer.parseInt(crmsClientResult);
		
		
		
		System.out.println("clineCount"+clineCount);
		}catch(Exception e) {
			
			logger.error("while fetching crms client count got an error "+e.getMessage());
			throw new DAOException("while fetching crms client count got an error "+e.getMessage());
		}
		return clineCount;
	}
	
	@Override
	public List<KLILifeAsiaDataDTO> getKLiLifeAsiaRecords(String clientMergeId) {
		
		 List<KLILifeAsiaDataDTO>  klilist=null;
		 
		 String query=env.getProperty("SELECT_KLI_LIFE_ASIA_RECORDS");
		 
		 logger.info("select query "+query);
		/*
		 select source,destination,transaction_dt,transaction_type,
		 action,policy_no,merge_client_no,retained_client_no,sorce_client_no,
		 res_merge_clent_no,res_policy_num,merge_status,client_merge_id  from  kli_asia_req_data_tbl*/
		 try {
		 klilist=jdbcTemplate.query(query,new Object[] {clientMergeId},(rs,num)-> {
			
			KLILifeAsiaDataDTO klidto=new KLILifeAsiaDataDTO();
			klidto.setSource(rs.getString(1));
			klidto.setDestination(rs.getString(2));
			klidto.setTransactionDt(rs.getString(3));
			klidto.setTransactionType(rs.getString(4));
			klidto.setAction(rs.getString(5));
			klidto.setPolicyNo(rs.getString(6));
			klidto.setMergeClientNo(rs.getString(7));
			klidto.setRetainedClientNo(rs.getString(8));
			klidto.setSourceClientNo(rs.getString(9));
			klidto.setResMergeclientNo(rs.getString(10));
			klidto.setResPolicyNo(rs.getString(11));
			klidto.setMergeStatus(rs.getString(12));
			klidto.setClientMergeId(rs.getString(13));
			klidto.setErrorcode(rs.getString(14));
			klidto.setErrorDescription(rs.getString(15));
			klidto.setFlag(rs.getString(16));
			return klidto;
		});
		 }
		 catch(Exception e) {
			 
			 logger.error("while getting records from  kli_asia_req_data_tbl "+e.getMessage());
		 }
		
	return klilist;	
	}

	@Override
	public List<ProcessRsponse> getAllCheckerSelectedData(String selectedValue) {
		// TODO Auto-generated method stub
				logger.info("DAOIMPL  getAllSelectedDataForChecker(clientID)");
				logger.info("--------DAOIMPL getAllCheckerSelectedData()---------given--'" + selectedValue + "'-----");
				// String query="select * from employee";

				/*
				 * String
				 * query="select * from PSX_NSP_REQUEST_RESULTS_CRMS where requesT_Id in (" +
				 * "select request_Id from PSX_NSP_REQUEST_RESULTS_CRMS where   (verified, columnn 2)  verified='Y' and RECORD_TYPE='INPUT' and CRMS_CLIENT_ID=?) order by RECORD_TYPE"
				 * ;
				 */
				String query = env.getProperty("get_all_approve_data_for_checker_selected_view");
				//String query = env.getProperty("get_all_verified_data_for_selected_view");
				
				logger.info("To load seleted view  below query is executing >>>>");
				logger.info(query);
				return jdbcTemplate.query(query, new Object[] { selectedValue }, new ResultSetExtractor<List<ProcessRsponse>>() {

					@Override
					public List<ProcessRsponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<ProcessRsponse> list = new ArrayList<ProcessRsponse>();

						while (rs.next()) {
							ProcessRsponse response = new ProcessRsponse();

							response.setAADHAAR(rs.getString("AADHAAR"));
							response.setCRMS_CLIENT_ID(rs.getString("CRMS_CLIENT_ID"));
							response.setMATCH_COUNT(rs.getString("MATCH_COUNT"));
							response.setREQUEST_ID(rs.getString("REQUEST_ID"));
							response.setMATCH_REASON(rs.getString("MATCH_REASON"));
							response.setPSX_ID(rs.getString("PSX_ID"));

							// response.setDOB1(rs.getString("DOB1"));

							String date = rs.getString("DOB1");
							System.out.println(date);
							String Date = date.substring(0, 10);
							response.setDOB1(Date);
							response.setGENDER(rs.getString("GENDER"));
							response.setNAME(rs.getString("NAME"));
							response.setFATHER_NAME(rs.getString("FATHER_NAME"));
							response.setPERMANENT_PHONE(rs.getString("PERMANENT_PHONE"));
							response.setPERMANENT_CITY(rs.getString("PERMANENT_CITY"));
							response.setIsVerified(rs.getString("VERIFIED"));
							response.setPERMANENT_ADDRESS(rs.getString("PERMANENT_ADDRESS"));
							response.setRESIDENCE_ADDRESS(rs.getString("RESIDENCE_ADDRESS"));
							response.setOFFICE_ADDRESS(rs.getString("OFFICE_ADDRESS"));
							response.setPERMANENT_PHONE(rs.getString("PERMANENT_PHONE"));
							response.setOFFICE_PHONE(rs.getString("OFFICE_PHONE"));
							response.setRESIDENCE_PHONE(rs.getString("RESIDENCE_PHONE"));

							response.setPERMANENT_PIN(rs.getString("PERMANENT_PIN"));
							response.setIsVerified(rs.getString("VERIFIED"));
							response.setSELECTED(rs.getString("SELECTED"));
							response.setIsRetain(rs.getString("RETAIN"));
							response.setSCALE_TYPE(rs.getString("SCALE_TYPE"));
							response.setMATCH_RULE(rs.getString("MATCH_RULE"));
							response.setCKYCNO(rs.getString("CKYCNO"));
							response.setCLIENT_TYPE(rs.getString("CLIENT_TYPE"));
							response.setCRNNO(rs.getString("CRNNO"));
							response.setGSTIN(rs.getString("GSTIN"));
							response.setSOURCE_SYSTEM(rs.getString("SOURCE_SYSTEM"));
							response.setSTATUS(rs.getString("STATUS"));
							response.setDOC(rs.getString("DOI"));

							list.add(response);
						}
						logger.info("____________response from getAllVerifiedData()_______");
						logger.info(list);
						return list;
					}
				});
	}
}
