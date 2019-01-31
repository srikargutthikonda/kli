package com.posidex.lifeasia.client.service;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.posidex.lifeasia.stub.BizTalkServiceInstance;
import com.posidex.lifeasia.stub.ClientMerge;
import com.posidex.lifeasia.stub.ClientMergeESBRequest;
import com.posidex.lifeasia.stub.ClientMergeESBResponse;


@Component
public class KotakWebserviceCallingdServiceImpl {
	
	@Autowired
	private Environment environment;
		
	static ClientMerge clientPortInfo;
    static BizTalkServiceInstance serviceInfo;
    
    private static Logger logger = Logger.getLogger(KotakWebserviceCallingdServiceImpl.class);
   
    public static ClientMerge getPortObject() {
       
        if(clientPortInfo==null) {
           
            if(serviceInfo==null) {
               
                serviceInfo=new BizTalkServiceInstance();
            }
            clientPortInfo=serviceInfo.getBasicHttpBindingITwoWayAsync();
            
            //below code for dynamically changing wsdl url
 	       
    	      //  BindingProvider bindingProvider = (BindingProvider) serviceInfo;
    	       
    	         //   bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"http://mum-bo-s288.kli.kotakgroup.com/Services/ClientMerge.svc?wsdl");
    	     
        }
       
       
        return clientPortInfo;
       
    }
	
	
	
	public ClientMergeESBResponse callWebserviceMethod(ClientMergeESBRequest request) {

		/*//creating service class object
		BizTalkServiceInstance service=new BizTalkServiceInstance();
		//creating service class end point
		
		ClientMerge clientPort=service.getBasicHttpBindingITwoWayAsync();*/
		 ClientMergeESBResponse response=null;
		try {
		
		  if(clientPortInfo==null) {
	           
	            clientPortInfo=getPortObject();
	            
	            BindingProvider bindingProvider = (BindingProvider) clientPortInfo;
	    	       
	            bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,environment.getProperty("ASIA_WEBSERVICE_WSDL"));
	            logger.info("got objects for clientPortInfo:::"+clientPortInfo);
	        }   
	  //Sending/calling customer request to posidex dedupe web service
		
		  logger.info("clientPortInfo:::"+clientPortInfo);
		  logger.info("wsdl url:::"+environment.getProperty("ASIA_WEBSERVICE_WSDL"));
	
		  logger.info("calling webservice method");  
	
		  response=clientPortInfo.clientMerge(request);
		
		  logger.info("got response from webservice provider "+response);
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
			logger.error("while calling webservice got an error::"+e.getMessage());
		}
		
				
		return response;
		
	}
	

}
