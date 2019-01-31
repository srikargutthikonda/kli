package bkp_code;

import com.posidex.bean.DedupeInputBean;
import com.posidex.bean.UrlRequest;
import com.posidex.bean.UserRole;
import com.posidex.custom.mapper.UserDataMapper;

public class BkpMrthods {
/*	@Override
	public UserRole validate(UrlRequest request) {
		// TODO Auto-generated method stub
		String user = request.getPsdxUser();
		String pwd = request.getPsdxPwd();

		
		 * String status="Maker_Verified";
		 * 
		 * return status;
		 
		String role = "";
		String s = "";
		String sql=env.getProperty("select_role_based_login");
		System.out.println(sql+" static query from ********************");
		//String sql = "select * from KOTAK_LIFE_DEMO_USER_ROLES where USER_NAME='" + user + "' and PWD='" + pwd + "'";
		List<UserRole> users = jdbcTemplate.query(sql, new ResultSetExtractor<List<UserRole>>() {

			public List<UserRole> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<UserRole> list = new ArrayList<UserRole>();
				while (rs.next()) {
					UserRole user = new UserRole();
					user.setROLE_ID(rs.getString("ROLE_ID"));
					user.setACTIVATED_BY(rs.getString("ACTIVATED_BY"));
					user.setROLE_PURPOSE(rs.getString("ROLE_PURPOSE"));
					user.setSTATUS(rs.getString("STATUS"));
					user.setAVAILED_TYPE(rs.getString("aVAILED_TYPE"));
					user.setCREATED_BY(rs.getString("CREATED_BY"));
					user.setDISPLAY_NAME(rs.getString("DISPLAY_NAME"));
					user.setUSER_NAME(rs.getString("USER_NAME"));

					list.add(user);
				}
				return list;
			}
		});

		
	//	String sql = "select * from DEMO_KOTAK_DEDUPE_DATA_T where CLIENT_REQUEST=?";

		@SuppressWarnings("unchecked")
		UserRole userData = (UserRole) jdbcTemplate.queryForObject(sql, new Object[] { user,pwd },
				new UserDataMapper());
		System.out.println("====================userdata below===================================");
		System.out.println(userData.toString());
		System.out.println("====================userData' /\'===================================");

		return userData; 

		
		
		
		
		
		
		 * for(UserRole us:users) { if(us.getROLE_PURPOSE().equals("MAKER")) {
		 * role="MAKER"; } }
		 
		System.out.println("daoImpl uselist data");

		System.out.println(users);

		return users;

	}



//this is for ajax change data 
 * 
 * 	@Override
	public DedupeInputBean getData(String id) {

		// String sql="select * from DEMO_KOTAK_DEDUPE_DATA_T where
		// CLIENT_REQUEST='"+id+"'";

		/*
		 * List <DedupeInputBean> users = jdbcTemplate.query(sql, new
		 * ResultSetExtractor<List<DedupeInputBean>>(){
		 * 
		 * public List<DedupeInputBean> extractData( ResultSet rs) throws SQLException,
		 * DataAccessException {
		 * 
		 * List<DedupeInputBean> list = new ArrayList<DedupeInputBean>();
		 * while(rs.next()){ DedupeInputBean bean=new DedupeInputBean();
		 * bean.setFIRSTNAME(rs.getString("FIRSTNAME"));
		 * bean.setMIDDLENAME(rs.getString("MIDDLENAME"));
		 * bean.setLASTNAME(rs.getString("LASTNAME"));
		 * bean.setMOTHER_NAME(rs.getString("MOTHER_NAME"));
		 * bean.setFATHER_NAME(rs.getString("FATHER_NAME"));
		 * bean.setGENDER_FLAG(rs.getString("GENDER_FLAG"));
		 * 
		 * bean.setPAN(rs.getString("PAN")); bean.setAADHAR(rs.getString("AADHAR"));
		 * bean.setVOTERID(rs.getString("VOTERID"));
		 * bean.setDRIVING_LICN_NO(rs.getString("DRIVING_LICN_NO"));
		 * bean.setRATIONCARD_NO(rs.getString("RATIONCARD_NO"));
		 * bean.setPASSPORT(rs.getString("PASSPORT"));
		 * 
		 * 
		 * 
		 * 
		 * bean.setPERMANENT_ADDRESS(rs.getString("PERMANENT_ADDRESS"));
		 * bean.setPERMANENT_CITY(rs.getString("PERMANENT_CITY"));
		 * bean.setPERMANENT_PIN(rs.getString("PERMANENT_PIN"));
		 * bean.setPERMANENT_STATE(rs.getString("PERMANENT_STATE"));
		 * bean.setPERMANENT_EMAIL(rs.getString("PERMANENT_EMAIL"));
		 * bean.setPERMANENT_PHONE(rs.getString("PERMANENT_PHONE"));
		 * 
		 * 
		 * bean.setOFFICE_ADDRESS(rs.getString("OFFICE_ADDRESS"));
		 * bean.setOFFICE_CITY(rs.getString("OFFICE_CITY"));
		 * bean.setOFFICE_PIN(rs.getString("OFFICE_PIN"));
		 * bean.setOFFICE_STATE(rs.getString("OFFICE_STATE"));
		 * bean.setOFFICE_EMAIL(rs.getString("OFFICE_EMAIL"));
		 * bean.setOFFICE_PHONE(rs.getString("OFFICE_PHONE"));
		 * 
		 * 
		 * bean.setTEMPORARY_ADDRESS(rs.getString("TEMPORARY_ADDRESS"));
		 * bean.setTEMPORARY_CITY(rs.getString("TEMPORARY_CITY"));
		 * bean.setTEMPORARY_PIN(rs.getString("TEMPORARY_PIN"));
		 * bean.setTEMPORARY_STATE(rs.getString("TEMPORARY_STATE"));
		 * bean.setTEMPORARY_EMAIL(rs.getString("TEMPORARY_EMAIL"));
		 * bean.setTEMPORARY_PHONE(rs.getString("TEMPORARY_PHONE"));
		 * 
		 * 
		 * bean.setRESIDENCE_ADDRESS(rs.getString("RESIDENCE_ADDRESS"));
		 * bean.setRESIDENCE_CITY(rs.getString("RESIDENCE_CITY"));
		 * bean.setRESIDENCE_PIN(rs.getString("RESIDENCE_PIN"));
		 * bean.setRESIDENCE_STATE(rs.getString("RESIDENCE_STATE"));
		 * bean.setRESIDENCE_EMAIL(rs.getString("RESIDENCE_EMAIL"));
		 * bean.setRESIDENCE_PHONE(rs.getString("RESIDENCE_PHONE"));
		 * 
		 * 
		 * 
		 * bean.setDOB1(rs.getString("DOB1"));
		 * 
		 * list.add(bean); } return list; } });


*/
}
