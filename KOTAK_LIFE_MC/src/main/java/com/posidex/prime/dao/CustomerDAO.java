package com.posidex.prime.dao;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.posidex.bean.DedupeInputBean;
import com.posidex.bean.GetCheckBoxData;
import com.posidex.bean.LifeAsiaSucessAndErrorResponses;
import com.posidex.lifeasia.stub.ClientMergeESBRequest;
import com.posidex.lifeasia.stub.ClientMergeESBResponse;
import com.posidex.prime.common.dto.ErrorCodeInfoDTO;
import com.posidex.prime.common.dto.MRProfileInfoDTO;
import com.posidex.prime.exception.DAOException;
import com.posidex.prime.exception.PosidexException;
import com.posidex.prime.request.RequestInfo;
import com.posidex.prime.response.KLILifeAsiaDataDTO;
import com.posidex.prime.response.ProcessRsponse;

public interface CustomerDAO {

	public int insertRequestDetails(DedupeInputBean customerRequest,RequestInfo info,long psxId) throws PosidexException, DataAccessException, ParseException;


	public Map<String, MRProfileInfoDTO> getPMProfileIds(String query) throws PosidexException;

	public Map<String, ErrorCodeInfoDTO> getWebServiceErrorCodes(String query) throws PosidexException;


	public boolean validateRequestId(String requestID) throws DAOException;
	
	public long getPsxIdFromSequence(String sequenceName);
	
	public List<ProcessRsponse> getCustomerResults(String requestI) throws DAOException, PosidexException, com.posidex.exception.PosidexException;
	public boolean updateVerify(List<GetCheckBoxData> checkBoxList,String userId);

	public List<ProcessRsponse> getAllVerifiedData(String clientId);

	public boolean deleteSeleted(List<GetCheckBoxData> checkBoxList);

	public boolean rejectSeleted(List<GetCheckBoxData> checkBoxList,String user_Id);
	public List<ProcessRsponse> loadCheckerData(String clientId);
	public boolean approveSeleted(List<GetCheckBoxData> checkBoxList,String userId);
	public boolean approvewithRequestId(String requestId,String user_id);
	public List<ProcessRsponse> responseList(String policy_number);
	
	public List<ProcessRsponse> lifeAsiaReq(List<GetCheckBoxData> checkBoxList) throws DAOException;
	
	public boolean verifyClientID(String cleintID);
	public List<ProcessRsponse> getDedupeReport(String startDate, String endDate );
	public List<ProcessRsponse> getMISReport(String startDate, String endDate );


	public boolean saveClientMergeDetails(List<ClientMergeESBResponse> responseList,String request_Id) throws Exception;
	
	public int getCountForRetain(String requestId);
	public String sourceClientID(String requestId);
	public String getRetainID(String requestId);
	List<ProcessRsponse> getSelectedCrmsID(String requestId);
	List<ProcessRsponse> getSelectedClientsNotInput(String requestId);
	public String getPolicyNumber(String requestId);
	public boolean noActionRequired(String sourceClientId);
	public 	 List<ProcessRsponse>  getAllSelectedDatawithReqId (String requestID);
	public List<ProcessRsponse> getAllNotVerifiedData(String clientId);
	
	public boolean updateErrorRecordsForMakerPage(LifeAsiaSucessAndErrorResponses mergeErrorResponse) throws DAOException;


	public void saveKliAsiaRequestData(ClientMergeESBRequest request, ClientMergeESBResponse response,String crmsClientId,String requestid);


	public List<ClientMergeESBRequest> getKliFailurecasesForReposting(String string);
	
	
	public void updateKliAsiaRequestData(ClientMergeESBRequest request, ClientMergeESBResponse response,String crmsClientId);
	
	public int validateChecker(String policynumber,String userId);

	public int checkDedupeVerificationforChecker(String crmsClientId,String clientRole) throws DAOException;
	
	public List<KLILifeAsiaDataDTO> getKLiLifeAsiaRecords(String clientMergeId);
	public List<ProcessRsponse> getAllCheckerSelectedData(String selectedValue);


}
