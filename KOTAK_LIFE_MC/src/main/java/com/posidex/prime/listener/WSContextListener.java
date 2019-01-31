package com.posidex.prime.listener;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.posidex.prime.common.dto.ErrorCodeInfoDTO;
import com.posidex.prime.common.dto.MRProfileInfoDTO;
import com.posidex.prime.dao.CustomerDAO;


/**
 * @author Harinadh Nerella
 */


@Component
public class WSContextListener implements ServletContextListener//,EnvironmentAware
{   
	Logger logger =Logger.getLogger(WSContextListener.class);



	@Autowired
	private CustomerDAO customerDao;
	
	@Autowired
	private Environment environment;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public Connection con;	

public Connection checkConnection()
{
	try {
		con=jdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e) {
			logger.info("Connection faild");
			e.printStackTrace();
	}
		if(con==null)
		{
			logger.info("Connection not established !!");
		}
		return con;
	
}
	public void contextDestroyed( ServletContextEvent event )
	{
		
		ServletContext application = event.getServletContext();		
		application.removeAttribute("MRProfileInfoMap");
		application.removeAttribute("errorcodes");
		}

	public void contextInitialized( ServletContextEvent event )
	{
		if (logger.isDebugEnabled()) logger.debug("In contextInitialized()..");
		ServletContext application = event.getServletContext();
		Map<String,ErrorCodeInfoDTO> errorCodesMap=null;
		try
		{
			
				try
			{				
				try
				{	
					Map<String,MRProfileInfoDTO> mrProfileInfoMap=customerDao.getPMProfileIds(environment.getProperty("pm360.profile.ids.query"));
					logger.info("PM Profile IDs Count:"+mrProfileInfoMap.size());
					if(mrProfileInfoMap!=null && mrProfileInfoMap.isEmpty())
					{
						logger.info("There Should be Atleast One ProfileID Info in psx_mr_profiles_t");
						throw new Exception("There Should be Atleast One ProfileID Info in psx_mr_profiles_t");
					}
					application.setAttribute("MRProfileInfoMap", mrProfileInfoMap);
					
					
					errorCodesMap=customerDao.getWebServiceErrorCodes(environment.getProperty("pm360.error.codes.query"));
					logger.info("Error codes Count:" + errorCodesMap.size());
					if (errorCodesMap != null && errorCodesMap.isEmpty())
					{
						throw new Exception("There Should be Atleast One Error code Info in PSX_WEBSERVICE_ERROR_CODES_T");
					}
					application.setAttribute("errorcodes", errorCodesMap);
					
				}
				catch (Exception e)
				{
					throw e;
				}
			}
			catch (IOException ex)
			{
				logger.error("Could not load the WSResources.properties file from the location: src/main/resources, exception message:" + ex.getMessage());
				logger.error(ex, ex);
				throw ex;
			}
		}
		catch (Exception e)
		{
			logger.error("Could not initialize the required resources!!" + e.getMessage());
			logger.error(e, e);
			System.exit(1);
		}
	}

	
	
	}
