package com.posidex.bean;



import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;



/**
 * @author K Vijaya Laxmi,G Vijaya Laxmi,Murali Krishna
 */
public class UserModel implements Serializable
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private Integer				userId;
	private Integer				clientId;
	private String				username;
	private String				password;
	private String				confirmPassword;
	private String				salt;
	private String				firstname;
	private String				lastname;
	private String				landingPage;
	private long				loginId;
	private String				status;
	private Date				fromDate;
	private Date				toDate;
	private String				email;
	private Integer				createdBy;
	private String				jobTitle;
	private String				department;
	private String				primaryRole;
	private String				userType;
	private String				createdOn;
	private String				mobile;
	private Date				logInTime;
	private Date				logOutTime;

	private String				loginStatus;
	private boolean				isNewUser;
	private int					failedLoginAttempts;
	private String				activate;
	private String				dataSource;
	private String				queuePriority;
	private String				minRange;
	private String				maxRange;
	private String				activationDate;
	private String				systemIp;
	private String				roleId;
	private String				approveType;
	private String				uniqueId;

	public String getRoleId()
	{
		return roleId;
	}

	public void setRoleId( String roleId )
	{
		this.roleId = roleId;
	}

	public String getActivationDate()
	{
		return activationDate;
	}

	public void setActivationDate( String activationDate )
	{
		this.activationDate = activationDate;
	}

	public String getSystemIp()
	{
		return systemIp;
	}

	public void setSystemIp( String systemIp )
	{
		this.systemIp = systemIp;
	}

	public String getQueuePriority()
	{
		return queuePriority;
	}

	public void setQueuePriority( String queuePriority )
	{
		this.queuePriority = queuePriority;
	}

	public String getMinRange()
	{
		return minRange;
	}

	public void setMinRange( String minRange )
	{
		this.minRange = minRange;
	}

	public String getMaxRange()
	{
		return maxRange;
	}

	public void setMaxRange( String maxRange )
	{
		this.maxRange = maxRange;
	}

	public String getDataSource()
	{
		return dataSource;
	}

	public void setDataSource( String dataSource )
	{
		this.dataSource = dataSource;
	}
	/* added for calculating uxer account expiry*/
	private String	updatedOn;
	private String	logintype;

	/**
	 * @return the clientId
	 */

	public Integer getClientId()
	{
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId( Integer clientId )
	{
		this.clientId = clientId;
	}

	/**
	 * @return the logInTime
	 */
	public Date getLogInTime()
	{
		return logInTime;
	}

	/**
	 * @param logInTime the logInTime to set
	 */
	public void setLogInTime( Date logInTime )
	{
		this.logInTime = logInTime;
	}

	/**
	 * @return the logOutTime
	 */
	public Date getLogOutTime()
	{
		return logOutTime;
	}

	/**
	 * @param logOutTime the logOutTime to set
	 */
	public void setLogOutTime( Date logOutTime )
	{
		this.logOutTime = logOutTime;
	}

	/**
	 * @return the loggedInTime
	 */
	public Date getLoggedInTime()
	{
		return logInTime;
	}

	/**
	 * @param loggedInTime the loggedInTime to set
	 */
	public void setLoggedInTime( Date loggedInTime )
	{
		this.logInTime = loggedInTime;
	}

	/**
	 * @return the loginStatus
	 */
	public String getLoginStatus()
	{
		return loginStatus;
	}

	/**
	 * @param loginStatus the loginStatus to set
	 */
	public void setLoginStatus( String loginStatus )
	{
		this.loginStatus = loginStatus;
	}

	public Date getFromDate()
	{
		return fromDate;
	}

	public void setFromDate( Date fromDate )
	{
		this.fromDate = fromDate;
	}

	public Date getToDate()
	{
		return toDate;
	}

	public void setToDate( Date toDate )
	{
		this.toDate = toDate;
	}

	public static List<String> getUserHeaderList()
	{
		return Arrays.asList(new String[] { "LoginId", "Name", "Email", "Mobile", "Job Title", "Department", "Primary Role", "Creation Date" });
	}

	public long getLoginId()
	{
		return loginId;
	}

	public void setLoginId( long loginId )
	{
		this.loginId = loginId;
	}

	public String getLandingPage()
	{
		return landingPage;
	}

	public void setLandingPage( String landingPage )
	{
		this.landingPage = landingPage;
	}

	public String getConfirmPassword()
	{
		return confirmPassword;
	}

	public void setConfirmPassword( String confirmPassword )
	{
		this.confirmPassword = confirmPassword;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus( String status )
	{
		this.status = status;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile( String mobile )
	{
		this.mobile = mobile;
	}

	public String getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn( String createdOn )
	{
		this.createdOn = createdOn;
	}

	public String getJobTitle()
	{
		return jobTitle;
	}

	public void setJobTitle( String jobTitle )
	{
		this.jobTitle = jobTitle;
	}

	public String getDepartment()
	{
		return department;
	}

	public void setDepartment( String department )
	{
		this.department = department;
	}

	public String getPrimaryRole()
	{
		return primaryRole;
	}

	public void setPrimaryRole( String primaryRole )
	{
		this.primaryRole = primaryRole;
	}

	public String getUserType()
	{
		return userType;
	}

	public void setUserType( String userType )
	{
		this.userType = userType;
	}

	public void setCreatedBy( Integer createdBy )
	{
		this.createdBy = createdBy;
	}

	/**
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername( String username )
	{
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail( String email )
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword( String password )
	{
		this.password = password;
	}

	public String getSalt()
	{
		return salt;
	}

	/**
	 * @param password the password to set
	 */
	public void setSalt( String salt )
	{
		this.salt = salt;
	}

	public Integer getCreatedBy()
	{
		return createdBy;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname()
	{
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname( String firstname )
	{
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname()
	{
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname( String lastname )
	{
		this.lastname = lastname;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId()
	{
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId( Integer userId )
	{
		this.userId = userId;
	}

	

	public String getFullName()
	{
		return firstname + " " + lastname;
	}

	public boolean isNewUser()
	{
		return isNewUser;
	}

	public void setNewUser( boolean isNewUser )
	{
		this.isNewUser = isNewUser;
	}

	/**
	 * @return the failedLoginAttempts
	 */
	public int getFailedLoginAttempts()
	{
		return failedLoginAttempts;
	}

	/**
	 * @param failedLoginAttempts the failedLoginAttempts to set
	 */
	public void setFailedLoginAttempts( int failedLoginAttempts )
	{
		this.failedLoginAttempts = failedLoginAttempts;
	}

	public String getActivate()
	{
		return activate;
	}

	public void setActivate( String activate )
	{
		this.activate = activate;
	}

	public void setUpdatedOn( String updatedOn )
	{
		this.updatedOn = updatedOn;
	}

	public String getUpdatedOn()
	{
		return updatedOn;
	}

	public String getLogintype()
	{
		return logintype;
	}

	public void setLogintype( String logintype )
	{
		this.logintype = logintype;
	}

	public String getApproveType()
	{
		return approveType;
	}

	public void setApproveType( String approveType )
	{
		this.approveType = approveType;
	}

	public String getUniqueId()
	{
		return uniqueId;
	}

	public void setUniqueId( String uniqueId )
	{
		this.uniqueId = uniqueId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "UserModel [userId=" + userId + ", clientId=" + clientId + ", username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword + ", salt=" + salt + ", firstname=" + firstname + ", lastname=" + lastname + ", landingPage=" + landingPage + ", loginId=" + loginId + ", status=" + status + ", fromDate=" + fromDate + ", toDate=" + toDate + ", email=" + email + ", createdBy=" + createdBy + ", jobTitle=" + jobTitle + ", department=" + department + ", primaryRole=" + primaryRole + ", userType=" + userType + ", createdOn=" + createdOn + ", mobile=" + mobile + ", logInTime=" + logInTime + ", logOutTime=" + logOutTime + ", loginStatus=" + loginStatus + ", isNewUser=" + isNewUser + ", failedLoginAttempts=" + failedLoginAttempts + ", activate=" + activate + ", dataSource=" + dataSource + ", queuePriority=" + queuePriority + ", minRange=" + minRange + ", maxRange=" + maxRange + ", activationDate=" + activationDate + ", systemIp=" + systemIp + ", roleId=" + roleId + ", approveType=" + approveType + ", uniqueId=" + uniqueId + ", updatedOn=" + updatedOn + ", logintype=" + logintype + "]";
	}

}

