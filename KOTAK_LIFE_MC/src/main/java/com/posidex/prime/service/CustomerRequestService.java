package com.posidex.prime.service;

import java.util.List;
import java.util.Map;

import com.posidex.bean.DedupeInputBean;
import com.posidex.bean.DedupeReport;
import com.posidex.bean.GetCheckBoxData;
import com.posidex.bean.LifeAsiaSucessAndErrorResponses;
import com.posidex.bean.MISReport;
import com.posidex.prime.common.dto.MRProfileInfoDTO;
import com.posidex.prime.exception.DAOException;
import com.posidex.prime.exception.PosidexException;
import com.posidex.prime.request.RequestInfo;
import com.posidex.prime.response.KLILifeAsiaDataDTO;
import com.posidex.prime.response.ProcessRsponse;

public interface CustomerRequestService {

	public int insertRequestDetails(DedupeInputBean customerRequest,RequestInfo info,long psxId) throws Exception;

//	public void processRequestDetails(CustomerRequest customerRequest,long psxId,String matchingRule) throws Exception;

	public Long getPsxIdFromSequence(String sequenceName);

	public void processRequestDetails(DedupeInputBean customerRequest, RequestInfo info,long psxId, MRProfileInfoDTO mpdto) throws Exception;
	public List<ProcessRsponse> getCustomerResults(String requestId,Map<String, String> errorCodesMap) throws DAOException, PosidexException, com.posidex.exception.PosidexException;
	boolean validateRequestId(String requestID) throws PosidexException, com.posidex.exception.PosidexException;
	public boolean updateVerify(List<GetCheckBoxData> checkBoxList,String userId);
	public List<ProcessRsponse> getAllVerifiedData(String clientId);
	public boolean deleteSeleted(List<GetCheckBoxData> checkBoxList);
	public boolean rejectSeleted(List<GetCheckBoxData> checkBoxList,String user_id);
	public List<ProcessRsponse> loadCheckerData(String clientId);
	public LifeAsiaSucessAndErrorResponses approveSeleted(List<GetCheckBoxData> checkBoxList,String userId);
	
	public List<ProcessRsponse> responseList(String policy_number);
	
	public boolean verifyClientID(String cleintID);
	
	public List<DedupeReport> getDedupeReport(String startDate, String endDate );
	public List<MISReport> getMisReport(String startDate,String endDate);
	
	public boolean noActionRequired(String sourceClientId);
	public boolean updateErrorRecordsForMakerPage(LifeAsiaSucessAndErrorResponses mergeErrorResponse);

	public boolean validateChecker(String policynumber,String userId);



	public int checkDedupeVerificationforChecker(String crmsClientId,String clinetRole) throws DAOException; 
	
	public List<KLILifeAsiaDataDTO> getKLiLifeAsiaRecords(String clientMergeId) ;
	
	public List<ProcessRsponse> getAllCheckerSelectedData(String selectedValue);
}
