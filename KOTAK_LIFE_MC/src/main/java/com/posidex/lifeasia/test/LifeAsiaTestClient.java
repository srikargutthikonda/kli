package com.posidex.lifeasia.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.posidex.lifeasia.client.service.KotakWebserviceCallingdServiceImpl;
import com.posidex.lifeasia.stub.ClientMergeESBRequest;
import com.posidex.lifeasia.stub.ClientMergeESBRequest.Data;
import com.posidex.lifeasia.stub.ClientMergeESBRequest.Header;
import com.posidex.lifeasia.stub.ClientMergeESBResponse;
import com.posidex.prime.response.ProcessRsponse;

public class LifeAsiaTestClient {
	
	@Autowired
	private KotakWebserviceCallingdServiceImpl clientService;
//	public static void main(String[] args) throws InterruptedException {
		
	private static Logger logger = Logger.getLogger(LifeAsiaTestClient.class);
	public ClientMergeESBResponse processWs(List<ProcessRsponse> listofRequest) {
		KotakWebserviceCallingdServiceImpl serviceImpl= null;
		ClientMergeESBRequest request=null;
		 Data requestdata=null;
		 Header requestHeader=null;
		 ClientMergeESBResponse response=null;
		 
		 List<ClientMergeESBResponse> responseList=null;
		
		logger.info("Obtained LifeAsaia WS:: >>>>");
		
		//Sample Request::
		/*
		<?xml version="1.0" encoding="UTF-8"?>
		<ClientMergeESBRequest xmlns="http://KLI.ESB.LA.ClientMerge.Schemas.ClientMerge_ESB_Req">
		   <Header xmlns="">
		      <Source>IONE</Source>
		      <Destination>LA</Destination>
		      <TransactionDT>12102018</TransactionDT>
		      <TransactionType>LAClientMerge</TransactionType>
		   </Header>
		   <Data xmlns="">
		      <Action>A</Action>
		      <MergeClientNumber>55016705</MergeClientNumber>
		      <RetainedClientNumber>55016804</RetainedClientNumber>
		      <SourceClientNumber>55016715</SourceClientNumber>
		   </Data>
		</ClientMergeESBRequest>
*/
		
		
		
		
		
		
		serviceImpl= new KotakWebserviceCallingdServiceImpl();
		
		 request=new ClientMergeESBRequest();
		 for(ProcessRsponse Formrequest:listofRequest)
		 { 
		 requestdata=new Data();
		 
		 requestdata.setAction("A");
		 requestdata.setMergeClientNumber(Formrequest.getCRMS_CLIENT_ID());
		 requestdata.setPolicyNumber(Formrequest.getPOLICY_NUMBER());
		 requestdata.setRetainedClientNumber(Formrequest.getCRMS_CLIENT_ID());
		 requestdata.setSourceClientNumber(Formrequest.getCRMS_CLIENT_ID());
		 logger.info("sending requestdata to LifeAsaia WS:: >>>>");
		 request.setData(requestdata);
		 }

		 
		 
		 
		 for(ProcessRsponse Formrequest:listofRequest)
		 { 
		 requestHeader=new Header();
		
		requestHeader.setDestination("LA");
		requestHeader.setSource("IONE");
		requestHeader.setTransactionDT(Formrequest.getCRMS_CLIENT_ID());
		requestHeader.setTransactionType("LAClientMerge");
		
		logger.info("sending header to LifeAsaia WS:: >>>>");
		request.setHeader(requestHeader);
		
		 response=serviceImpl.callWebserviceMethod(request);
		 responseList.add(response);
		 }
		System.out.println("going call webservice provider method");
		System.out.println("Response List :::");
		System.out.println(responseList);
		
		System.out.println("the response is  "+response);
	//}
return response;
}
}
