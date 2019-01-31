

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta charset="UTF-8">
      <title>Kotak Life - Posidex Technologies</title>
      <meta name="description" content="POSIDEX Technologies Pvt. Ltd." />
      <meta http-equiv="X-UA-Compatible" content="IE=10" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="shortcut icon" sizes="196x196" href="images/fav-icon.png">
      <link rel="stylesheet" type='text/css'
         href="fonts/font-awesome/css/font-awesome.min.css">
      <link rel="stylesheet" type='text/css'
         href="css/jquery.dataTables.min.css">
      <link rel='stylesheet' type='text/css' href='css/jquery-ui.css' />
      <link rel="stylesheet" type='text/css' href="css/style.css">
<!--       <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
 -->      

      <style>
         .trData {
         background-color: "orange", disabled
         }
         /* Modal CSS */
         .modal {
         display: none; /* Hidden by default */
         position: fixed; /* Stay in place */
         z-index: 1; /* Sit on top */
         padding-top: 100px; /* Location of the box */
         left: 0;
         top: 0;
         width: 100%; /* Full width */
         height: 100%; /* Full height */
         overflow: auto; /* Enable scroll if needed */
         background-color: rgb(0, 0, 0); /* Fallback color */
         background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
         }
       .dataTables_paginate
       {
       	display:none !important;
       }
         
      <style>
         .ui-widget-header,.ui-state-default, ui-button {
            background:#b9cd6d;
            border: 1px solid #b9cd6d;
            color: #FFFFFF;
            font-weight: bold;
         }
         
         .form_button_1 {
	margin-top: 17px;
	margin-left: 7px;
	width: 10%;
	float: left;
}
      </style>
      
      <!-- Javascript -->
 
         
         
         
         
         
<script type="text/javascript" >
$(document).ready(function() {
 	
 		
 		$("#ManualSubmitChange").hide();

</script> 
         
         
    
   </head>
   
     
      					
      			
      			
      			
      			
      			

   <body>
      <header>
         <section id="header" class="header">
            <div class="logo">
               <img src="images/psxlogo.png" width="" height="" alt=" Posidex Logo"
                  title=" Posidex  Logo " />
            </div>
            <div class="header_side_icon" style="margin: 13px 0">
               <nav id="nav">
                  <ul id="navigation">
                     <li class="nav-item fz-sm mr-md"><i
                        class="fa fa-user mr-xs text-muted"></i>Welcome <span
                        class="text-custom fw-600">'${kotakUser}'</span> <i
                        class="fa fa-history mr-xs ml-sm text-muted"></i> <span
                        class="text-custom fw-600"></span></li>
                     <li></li>
                  </ul>
               </nav>
            </div>
         </section>
         <nav id="menu-nav">
            <ul id="navigation ">
               <li><a href="makerHome" class="active"> <span
                  class="menu-text ">Maker Verification</span>
                  </a>
               </li>
               <li><a href="selectedview"> <span class="menu-text ">Selected
                  View</span>
                  </a>
               </li>
 
              
               
               
            </ul>
         </nav>
      </header>
      <section id="content">
         <div id="widget" class="pd-sm text-primary" style="color: #439bfe;">Policy Number : ${PID}
         </div>
         <div id="widget-inner" class="mt-sm pd-sm" style="overflow: auto;">
         <div class="form-box" style="overflow: auto;">
        <!--  action="dropdownSubmit" method="get" -->
            <form action="dropdownSubmit" method="get">
                  <div class="form-group w-20 pull-left">
                     <label for="select">Select</label>
                     <div class="select_box">
                        <%-- 					
                           <c:if test=${droplist.PROPOSED_ID == droplist.JOINT_LIFEASSURED_ID}>
                           
                           
                           	<select name="Select" id="selectedRecord"
                           		class="form-control smalltext input-sm">
                           		<option selected="-1">--Select--</option>
                           
                           		<c:forEach var="list" items="${droplist}">
                                                                  <option value="${list}">${list}</option>
                                                                  </c:forEach>
                           		<option value="${droplist.CLIENT_ID}">CLIENT_ID(
                           			${droplist.CLIENT_ID} )</option>
                           			
                           				
                           		<option value="${droplist.LIFEASSURED_ID}">LIFEASSURANCE_ID(
                           			${droplist.LIFEASSURED_ID} )</option>
                           		<option value="${droplist.JOINT_LIFEASSURED_ID}">JLIFEASSURANCE_ID(
                           			${droplist.JOINT_LIFEASSURED_ID} )</option>
                           		<option value="${droplist.PROPOSED_ID}">PROPOSED_ID(
                           			${droplist.PROPOSED_ID} )</option>
                           
                           
                           
                           	</select>
                           	</c:if>
                           	
                           	
                           	<c:if test=${droplist.LIFEASSURED_ID == droplist.PROPOSED_ID}>
                           
                           
                           	<select name="Select" id="selectedRecord"
                           		class="form-control smalltext input-sm">
                           		<option selected="-1">--Select--</option>
                           
                           		<c:forEach var="list" items="${droplist}">
                                                                  <option value="${list}">${list}</option>
                                                                  </c:forEach>
                           		<option value="${droplist.CLIENT_ID}">CLIENT_ID(
                           			${droplist.CLIENT_ID} )</option>
                           			
                           				
                           		<option value="${droplist.LIFEASSURED_ID}">LIFEASSURANCE_ID(
                           			${droplist.LIFEASSURED_ID} )</option>
                           		 <option value="${droplist.JOINT_LIFEASSURED_ID}">JLIFEASSURANCE_ID(
                           			${droplist.JOINT_LIFEASSURED_ID} )</option>
                           		<option value="${droplist.PROPOSED_ID}">PROPOSED_ID(
                           			${droplist.PROPOSED_ID} )</option>
                           
                           
                           
                           	</select>
                           	</c:if>
                           	
                           	
                           		
                           	 --%>
                        <c:choose>
                           <c:when
                              test="${droplist.PROPOSED_ID == droplist.JOINT_LIFEASSURED_ID}">
                              <select name="Select" id="makerDropDown"
                                 class="form-control smalltext input-sm">
                                 <option selected="-1" value="0">--Select--</option>
                                 <%-- <c:forEach var="list" items="${droplist}">
                                    <option value="${list}">${list}</option>
                                    </c:forEach> --%>
                                 <%-- <option value="${droplist.CLIENT_ID}">CLIENT_ID(
                                    ${droplist.CLIENT_ID} )</option> --%>
                                 <c:if test="${droplist.LIFEASSURED_ID!=null}">
	                                 <option value="${droplist.LIFEASSURED_ID}">LIFEASSURANCE_ID(
	                                    ${droplist.LIFEASSURED_ID} )
	                                 </option>
                                 </c:if>
                                 <%-- <option value="${droplist.JOINT_LIFEASSURED_ID}">JLIFEASSURANCE_ID(
                                    ${droplist.JOINT_LIFEASSURED_ID} )</option> --%>
                                 <c:if test="${droplist.PROPOSED_ID!=null}">
                                 <option value="${droplist.PROPOSED_ID}">PROPOSED_ID(
                                    ${droplist.PROPOSED_ID} )
                                 </option>
                                 </c:if>
                              </select>
                           </c:when>
                           <c:when test="${droplist.LIFEASSURED_ID == droplist.PROPOSED_ID}">
                      
                              <select name="Select" id="makerDropDown"
                                 class="form-control smalltext input-sm">
                                 <option selected="-1" value="0">--Select--</option>
                                 <%-- <c:forEach var="list" items="${droplist}">
                                    <option value="${list}">${list}</option>
                                    </c:forEach> --%>
                                 <%-- <option value="${droplist.CLIENT_ID}">CLIENT_ID(
                                    ${droplist.CLIENT_ID} )</option> --%>
                                 <%-- 		
                                    <option value="${droplist.LIFEASSURED_ID}">LIFEASSURANCE_ID(
                                    	${droplist.LIFEASSURED_ID} )</option> --%>
                              	<c:if test="${droplist.JOINT_LIFEASSURED_ID!=null}">
                                 <option value="${droplist.JOINT_LIFEASSURED_ID}">JLIFEASSURANCE_ID(
                                    ${droplist.JOINT_LIFEASSURED_ID} )
                                 </option>
                                 </c:if>
                                 <c:if test="${droplist.PROPOSED_ID!=null}">
                                 <option value="${droplist.PROPOSED_ID}">PROPOSED_ID(
                                    ${droplist.PROPOSED_ID} )
                                 </option>
                                 </c:if>
                              </select>
                           </c:when>
                           <c:otherwise>
                              <select name="Select" id="makerDropDown"
                                 class="form-control smalltext input-sm">
                                 <option selected="-1" value="0">--Select--</option>
                                 <%-- <c:forEach var="list" items="${droplist}">
                                    <option value="${list}">${list}</option>
                                    </c:forEach> --%>
                                 <%-- <option value="${droplist.CLIENT_ID}">CLIENT_ID(
                                    ${droplist.CLIENT_ID} )</option> --%>
                                 <c:if test="${droplist.LIFEASSURED_ID!=null}">
                                 <option value="${droplist.LIFEASSURED_ID}">LIFEASSURANCE_ID(
                                    ${droplist.LIFEASSURED_ID} )
                                 </option>
                                 </c:if>
                                 <c:if test="${droplist.JOINT_LIFEASSURED_ID!=null}">
                                 <option value="${droplist.JOINT_LIFEASSURED_ID}">JLIFEASSURANCE_ID(
                                    ${droplist.JOINT_LIFEASSURED_ID} )
                                 </option>
                                 </c:if>
                                 <c:if test="${droplist.PROPOSED_ID!=null}">
                                 <option value="${droplist.PROPOSED_ID}">PROPOSED_ID(
                                    ${droplist.PROPOSED_ID} )
                                 </option>
                                 </c:if>
                              </select>
                           </c:otherwise>
                        </c:choose>
                     </div>
                </div>
                
				<div class="form_button_1">
					<button type="submit" id="ManualSubmitChange"
						class="btn btn-custom btn-sm btn-none mr-xs">
						<i class="fa fa-paper-plane mr-xs"></i>Get Result
					</button>
				</div>
					
				
				
			</form>
			</div>
		</div>

         <div id="formDiv">
            <div id="widget-inner" id="input" class="mt-sm pd-sm"
               style="overflow: auto;">
               <div alignment="center" class="formDiv">
                  <form action="saveData" name="inputForm" id="inputForm"
                     method="post">
                     <div class="form-box" style="overflow: auto;">
                        <div class="form-group w-20 pull-left mr-sm">
                           <label for="name">First Name:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="FIRSTNAME"
                              value='${dgData.FIRSTNAME}' id="firstname" ="Enter the
                              Name" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div id="inputId" class="form-group w-20 pull-left">
                           <label for="father_name">Middle Name:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="MIDDLENAME"
                              value='${dgData.MIDDLENAME}' id="middilename" ="Enter the
                              Father Name" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div id="inputId" class="form-group w-20 pull-left ml-sm">
                           <label for="father_name">Last Name:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="LASTNAME"
                              value='${dgData.LASTNAME}' id="lastname" ="Enter the Father
                              Name" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <!-- 				<div class="form-group w-20 pull-left ml-sm">
                           <label for="dob">DOB</label>
                           <div class="input-group mt-xs">
                           	<input class="form-control  pd-xs" name="dob"
                           		="Select the Date" type="text" id="dob">
                           </div>
                           </div> -->
                        <div class="form-group w-20 pull-left ml-sm">
                           <label for="address">Father Name:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="FATHER_NAME"
                              value='${dgData.FATHER_NAME}' id="fathername" ="Enter the
                              Address" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left mt-sm">
                           <label for="city">Mother Name</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="MOTHER_NAME"
                              value='${dgData.MOTHER_NAME}' id="mothername" ="Enter the
                              City" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">DOB:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="DOB1"
                                 value='${dgData.DOB1}' id="dob" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Gender:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="GENDER_FLAG"
                                 value='${dgData.GENDER_FLAG}' id="gender" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">PAN:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="PAN"
                                 value='${dgData.PAN}' id="pan" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left mt-sm">
                           <label for="city">Passport</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="PASSPORT"
                              value='${dgData.PASSPORT}' id="passport" ="Enter the
                              City" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Voter Id:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="VOTERID"
                                 value='${dgData.VOTERID}' id="voterid" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Aadhaar:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="AADHAR"
                                 value='${dgData.AADHAR}' id="adharnumber" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Driving licence:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="DRIVING_LICN_NO"
                                 value='${dgData.DRIVING_LICN_NO}' id="dlicence" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left mt-sm">
                           <label for="city">Ration Card :</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="RATIONCARD_NO"
                              value='${dgData.RATIONCARD_NO}' id="rationnumber" ="Enter the
                              City" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Office Address:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="OFFICE_ADDRESS"
                                 value='${dgData.OFFICE_ADDRESS}' id="officeaddrres" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Office City:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="OFFICE_CITY"
                                 value='${dgData.OFFICE_CITY}' id="officecity" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Office Pincode:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="OFFICE_PIN"
                                 value='${dgData.OFFICE_PIN}' id="officepincode" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left mt-sm">
                           <label for="city">Office state:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="OFFICE_STATE"
                              value='${dgData.OFFICE_STATE}' id="officestate" ="Enter the
                              City" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Permanent Address:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="PERMANENT_ADDRESS"
                                 value='${dgData.PERMANENT_ADDRESS}' id="paddress" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Permanent City:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="PERMANENT_CITY"
                                 value='${dgData.PERMANENT_CITY}' id="pcity" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Permanent Pincode:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="PERMANENT_PIN"
                                 value='${dgData.PERMANENT_PIN}' id="ppincode" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left mt-sm">
                           <label for="city">Permanent state:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="PERMANENT_STATE"
                              value='${dgData.PERMANENT_STATE}' id="pstate" ="Enter the
                              City" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Temporary Address:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="TEMPORARY_ADDRESS"
                                 value='${dgData.TEMPORARY_ADDRESS}' id="taddress" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Temporary City:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="TEMPORARY_CITY"
                                 value='${dgData.TEMPORARY_CITY}' id="tcity" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Temporary Pincode:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="TEMPORARY_PIN"
                                 value='${dgData.TEMPORARY_PIN}' id="tpincode" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left mt-sm">
                           <label for="city">Temporary state:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="TEMPORARY_STATE"
                              value='${dgData.TEMPORARY_STATE}' id="tstate" ="Enter the
                              City" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Residence Address:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="RESIDENCE_ADDRESS"
                                 value='${dgData.RESIDENCE_ADDRESS}' id="raddress" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Residence City:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="RESIDENCE_CITY"
                                 value='${dgData.RESIDENCE_CITY}' id="rcity" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Residence Pincode:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="RESIDENCE_PIN"
                                 value='${dgData.RESIDENCE_PIN}' id="rpincode" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left mt-sm">
                           <label for="city">Residence state:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="RESIDENCE_STATE"
                              value='${dgData.RESIDENCE_STATE}' id="rstate" ="Enter the
                              City" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Office Contact:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="OFFICE_PHONE"
                                 value='${dgData.OFFICE_PHONE}' id="officecontact" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Permanent Contact:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="PERMANENT_PHONE"
                                 value='${dgData.PERMANENT_PHONE}' id="pcontact" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Temporary Contact:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="TEMPORARY_PHONE"
                                 value='${dgData.TEMPORARY_PHONE}' id="tcontact" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left mt-sm">
                           <label for="city">Residence Contact:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="RESIDENCE_PHONE"
                              value='${dgData.RESIDENCE_PHONE}' id="rcontact" ="Enter the
                              City" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Office Email:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="OFFICE_EMAIL"
                                 value='${dgData.OFFICE_EMAIL}' id="officeemail" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Permanent Email:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="pemail"
                                 value='${dgData.OFFICE_EMAIL}' id="PERMANENT_EMAIL" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Temporary Email:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="TEMPORARY_EMAIL"
                                 value='${dgData.TEMPORARY_EMAIL}' id="temail" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        <div class="form-group w-20 pull-left  mt-sm">
                           <label for="pincode">Residence Email:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="RESIDENCE_EMAIL"
                                 value='${dgData.RESIDENCE_EMAIL}' id="remail" type="text">
                           </div>
                           
                           
                           <!-- New added files -->
                           
                        </div>
                        <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">CKYC:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="CKYC"
                                 value='${dgData.CKYCNO}' id="CKYC" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                          <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">Client Type:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="CLIENT_TYPE"
                                 value='${dgData.CLIENT_TYPE}' id="CLIENT_TYPE" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                          <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="CRNNO">CRNNO:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="CRNNO"
                                 value='${dgData.CRNNO}' id="CRNNO" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                          <div class="form-group w-20 pull-left  mt-sm">
                           <label for="pincode">GSTIN:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="GSTIN"
                                 value='${dgData.GSTIN}' id="GSTIN" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                          <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">SOURCE_SYSTEM:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="SOURCE_SYSTEM"
                                 value='${dgData.SOURCE_SYSTEM}' id="SOURCE_SYSTEM" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                          <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">STATUS:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="STATUS"
                                 value='${dgData.STATUS}' id="STATUS" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        
                          <div class="form-group w-20 pull-left ml-sm mt-sm">
                           <label for="pincode">MOBILE:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="MOBILE"
                                 value='${dgData.MOBILE}' id="MOBILE" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                         <div class="form-group w-20 pull-left  mt-sm">
                           <label for="pincode">DOC:</label>
                           <div class="input-group mt-xs">
                              <input class="form-control  pd-xs" name="doc"
                                 value='${dgData.DOC}' id="doc" type="text">
                           </div>
                           <!-- /input-group -->
                        </div>
                        
                      <!-- added above -->  
                     </div>
                     <div class="form-button mt-md">
                        <div class="form-button-1 pull-left">
                           <input type="submit" id="submit" value="SAVE DEDUPE"
                              class="btn btn-custom btn-sm btn-none mr-xs" />
                        </div>
                        <!--  <div class="form-button-2 pull-left">
                           <button type="reset" class="btn btn-default btn-sm btn-none">
                               <i class="fa fa-remove mr-xs"></i>Clear
                           </button>
                           </div> -->
                     </div>
                  </form>
               </div>
            </div>
         </div>
         <div id="widget-inner" class="mt-sm pd-sm" style="overflow: auto;">
            <span><b>${processMessage}</b></span>
            <div class="" id="datatable" style="overflow: auto;">
               <table id="example"  class="dataTable" cellspacing="0" width="100%">
                  <thead>
                     <tr>
                        <th>Select All<input type="checkbox" id="master"></th>
                        <th>CLIENT_ID</th>
                        <th>MATCH_RULE</th>
                        <th>MATCH_COUNT</th>
                        <th>MATCH_CATEGORY</th>
                        <th>NAME</th>
                        <th>DOB</th>
                        <th>GENDER</th>
                        <th>PERMANENT_ADDRESS</th>
                        <th>RESIDENCE_ADDRESS</th>
                        <th>OFFICE_ADDRESS</th>
                        <th>RESIDENCE_PHONE</th>
                        <th>OFFICE_PHONE</th>
                        <th>PERMANENT_PHONE</th>
                        <th>AADHAAR</th>
                       
                        <!--  -->
                        <th>CKYCNO</th>
						<th>CLIENT_TYPE</th>
						<th>CRNNO</th>
						<th>GSTIN</th>
						<th>SOURCE_SYSTEM</th>
						<th>STATUS</th>
						<th>MOBILE</th>
						<th></th>
						<th>DOC</th>
						 <th>REQUEST_ID</th>
                        <th>PSX_ID</th>
                     </tr>
                  </thead>
                  
              
             
         <%--  	<c:out value="${ responseList.size() }"></c:out> --%>
             <%--    <c:if test="${fn:length(responseList) eq 0}">  --%>
               
            <c:if test="${DedupeCompleted==false}">
                <tbody>
                     <c:forEach var="response" items="${responseList}"
                        varStatus="theCount">                      
                           
								<tr>
                           <td>Select<input type="checkbox" name="checkbox"  class="sub_chk"
                           	id="checkbox${theCount.count}"> Retain<input
                           	type="radio" class="radio"  id="radio${theCount.count}"
                           	name="selectRadio" onclick="checkboxCheckng(checkbox${theCount.count})" value="">
                           
                           </td>
                           <td>${response.CRMS_CLIENT_ID}</td>
							<td>${response.MATCH_RULE}</td>
                           <td>${response.MATCH_COUNT}</td>
                           <td>${response.SCALE_TYPE}</td>
                           <td>${response.NAME}</td>
                           <td>${response.DOB1}</td>
                           <td>${response.GENDER}</td>
                           <td>${response.PERMANENT_ADDRESS}</td>
                           <td>${response.RESIDENCE_ADDRESS}</td>
                           <td>${response.OFFICE_ADDRESS}</td>
                           <td>${response.OFFICE_PHONE}</td>
                           <td>${response.RESIDENCE_PHONE}</td>
                           <td>${response.PERMANENT_PHONE}</td>
                           <td>${response.AADHAAR}</td>
                                            
                            <td>${response.CKYCNO}</td>
                            <td>${response.CLIENT_TYPE}</td>
                            <td>${response.CRNNO }</td>
                            <td>${response.GSTIN }<td>
                            <td>${response.SOURCE_SYSTEM}</td>
                            <td>${response.STATUS}</td>
                            <td>${response.MOBILE}</td>
                            <td>${response.DOC}</td>
                             <td>${response.REQUEST_ID}</td>
                           <td>${response.PSX_ID}</td>        
                           </tr>
						   
                       
                     </c:forEach>
                  </tbody> 
                  </c:if>
                  <c:if test="${DedupeCompleted==true}">
                  <tbody>
						<c:forEach var="response" items="${responseList}"   varStatus="theCount">
							<c:if
								test="${response.SELECTED=='Y' && response.isRetain!='T'}">
								<tr>
									<td>select<input type="checkbox" name="checkbox" class="sub_chk"  checked 	id="checkbox${theCount.count}"> Retain<input
										type="radio" name="selectRadio" id="radio${theCount.count}"
                           	name="selectRadio" onclick="checkboxCheckng(checkbox${theCount.count})">

									</td>
									<td>${response.CRMS_CLIENT_ID}</td>
									<td>${response.MATCH_RULE}</td>
									<td>${response.MATCH_COUNT}</td>
									<td>${response.SCALE_TYPE}</td>
									<td>${response.NAME}</td>
									<td>${response.DOB1}</td>
									<td>${response.GENDER}</td>
									<td>${response.PERMANENT_ADDRESS}</td>
									<td>${response.RESIDENCE_ADDRESS}</td>
									<td>${response.OFFICE_ADDRESS}</td>
									<td>${response.OFFICE_PHONE}</td>
									<td>${response.RESIDENCE_PHONE}</td>
									<td>${response.PERMANENT_PHONE}</td>
									<td>${response.AADHAAR}</td>
									
									<td>${response.CKYCNO}</td>
                            <td>${response.CLIENT_TYPE}</td>
                            <td>${response.CRNNO }</td>
                            <td>${response.GSTIN }<td>
                            <td>${response.SOURCE_SYSTEM}</td>
                            <td>${response.STATUS}</td>
                            <td>${response.MOBILE}</td>
                            <td>${response.DOC}</td>
                            <td>${response.REQUEST_ID}</td>
									<td>${response.PSX_ID}</td>
								</tr>

							</c:if>


							<c:if test="${response.SELECTED=='N'}">

								<tr>
									<td>Select<input type="checkbox" name="checkbox" class="sub_chk" 
											id="checkbox${theCount.count}"> Retain<input type="radio"
										name="selectRadio" id="radio${theCount.count}"
                           	name="selectRadio" onclick="checkboxCheckng(checkbox${theCount.count})"  value="">

									</td>
									<td>${response.CRMS_CLIENT_ID}</td>
									<td>${response.MATCH_RULE}</td>
									<td>${response.MATCH_COUNT}</td>
									<td>${response.SCALE_TYPE}</td>
									<td>${response.NAME}</td>
									<td>${response.DOB1}</td>
									<td>${response.GENDER}</td>
									<td>${response.PERMANENT_ADDRESS}</td>
									<td>${response.RESIDENCE_ADDRESS}</td>
									<td>${response.OFFICE_ADDRESS}</td>
									<td>${response.OFFICE_PHONE}</td>
									<td>${response.RESIDENCE_PHONE}</td>
									<td>${response.PERMANENT_PHONE}</td>
									<td>${response.AADHAAR}</td>
									
									<td>${response.CKYCNO}</td>
                            <td>${response.CLIENT_TYPE}</td>
                            <td>${response.CRNNO }</td>
                            <td>${response.GSTIN }<td>
                            <td>${response.SOURCE_SYSTEM}</td>
                            <td>${response.STATUS}</td>
                            <td>${response.MOBILE}</td>
                            <td>${response.DOC}</td>
                            <td>${response.REQUEST_ID}</td>
									<td>${response.PSX_ID}</td>
								</tr>

							</c:if>
							<%-- 							<c:if test="${ISAJAX == 0 && ISDATE == 0}">
 --%>
							<c:if
								test="${response.isRetain=='T' &&  response.SELECTED=='Y' }">

								<tr>
									<td>Select<input type="checkbox" name="checkbox" class="sub_chk" checked
											id="checkbox${theCount.count}"> Retain<input type="radio"
										name="selectRadio" checked  id="radio${theCount.count}"
                           		name="selectRadio" onclick="checkboxCheckng(checkbox${theCount.count})"  value="">

									</td>
									<td>${response.CRMS_CLIENT_ID}</td>
									<td>${response.MATCH_RULE}</td>
									<td>${response.MATCH_COUNT}</td>
									<td>${response.SCALE_TYPE}</td>
									<td>${response.NAME}</td>
									<td>${response.DOB1}</td>
									<td>${response.GENDER}</td>
									<td>${response.PERMANENT_ADDRESS}</td>
									<td>${response.RESIDENCE_ADDRESS}</td>
									<td>${response.OFFICE_ADDRESS}</td>
									<td>${response.OFFICE_PHONE}</td>
									<td>${response.RESIDENCE_PHONE}</td>
									<td>${response.PERMANENT_PHONE}</td>
									<td>${response.AADHAAR}</td>
									
									<td>${response.CKYCNO}</td>
                            <td>${response.CLIENT_TYPE}</td>
                            <td>${response.CRNNO }</td>
                            <td>${response.GSTIN }<td>
                            <td>${response.SOURCE_SYSTEM}</td>
                            <td>${response.STATUS}</td>
                            <td>${response.MOBILE}</td>
                            <td>${response.DOC}</td>
									<td>${response.REQUEST_ID}</td>
									<td>${response.PSX_ID}</td>
								</tr>

							</c:if>

						</c:forEach>
					</tbody>
                  </c:if>
                  
                  
               </table>
               <div class="form-button mt-md">
                  <div class="form-button-1 pull-left">
                     <button type="submit" id="getData"
                        class="btn btn-custom btn-sm btn-none mr-xs">
                     <i class="fa fa-check-circle mr-xs"></i>Verify
                     </button>
                     <button type="submit" id="noAction"
                        class="btn btn-custom btn-sm btn-none mr-xs">
                     <i class="fa fa fa-times-circle-o mr-xs"></i>No Action Required
                     </button>
                     
                  </div>
               </div>
            </div>
         </div>
      </section>
      <footer>
         <div class="copyright">© 2018 - Posidex Technologies</div>
         <div class="powered">
            <div class="powered-inner">
               <span class="footer-text">Powered By:</span> <span class=" ">
               <img src="images/powered-logo.png" class=" mi-lg" alt="Footer Logo"
                  title="Footer Logo" />
               </span>
            </div>
         </div>
      </footer>
    
      <script src="js/jquery-1.12.4.js"></script>
      <script src="js/jquery.dataTables.min.js"></script>
      <script>
         function checkboxCheckng(value)
         {
        	 $(document).ready(function() {
        		// $('input[name=checkbox]').attr('checked', false);
        		 $( 'input[name=checkbox]' ).prop( "disabled", false );
        	 });
       // document.getElementsByName("checkbox").removeAttr("disabled"); 
         var checId = document.getElementById(value.id);
         checId.checked=true;
      	 document.getElementById(value.id).disabled = true;
     //  alert(value.id);
         }
         
         
         	$(document).ready(function() {
         	/* 	$(function(){
         		    $("tbody").each(function(elem,index){
         		      var arr = $.makeArray($("tr",this).detach());
         		      arr.reverse();
         		        $(this).append(arr);
         		    });
         		}); */
         		
         		$("#ManualSubmitChange").hide();
         		 $("#ManualSubmitChange").click(function() {

    				$("selectedRecord").val = "";
    				var error = 0;
    				var option = $('#selectedRecord').val();
    				
    				if (option == '0') {
    					// error = 1;
    					alert('Please select option !!');
    					return false;
    				}
    				

    			}); 
         		
         		
         		$('#example').DataTable({
         			"scrollX" : true,
         			"paging": false
         			/* "columnDefs": [
         	            {
         	                "targets": [ 15 ],
         	                "visible": false,
         	                "searchable": false
         	            } *///,
         	            /* {
         	                "targets": [ 3 ],
         	                "visible": false
         	            } */
         	       // ]
         		});
         		$("tr:eq( 2 )").css({
         			'background-color' : " #fbe6a0 ;"
         			//'disabled' : "disabled"
         		});
         		/* var data=$("td:eq(0) input").val();
         		if(data!=undefined){
         		$("td:eq(0)").append(
         			'Retain <input type=radio id="radio" name=radio>');
         		} */
         			//'disabled' : "disabled"
         		//});
         		//$('td:nth-child(15),th:nth-child(15)').hide();
         		$('td:nth-child(26),th:nth-child(26)').hide(); 
         		$('td:nth-child(25),th:nth-child(25)').hide(); 
         	
         		/* $('#radio').click(function(){
         			$('#checkbox').prop('checked',true);
         			
         			
         		}); */
         		
         		
         		//$("tr:eq(2)").find('input').prop('disabled', true);         		
         		/* $("#example tr:has(input[type=radio]:checked)").map(function() {
         	            var $tr = $(this);
         	            var $td = $tr.find("td");
         	            		$("td").find('input').prop('checked',true);
         	           	         	        }).get(); */
         	/*(".radio").click(function(){
         		$("#example tr:has(input[type=radio]:checked)").map(function() {
         			alert("radiobutton clicked !!");
                     var $tr = $(this);
                     var $td = $tr.find("td");
                   if($(this).prop("checked") == true){
                    			$("td").find('input[type=checkbox]').prop('checked',true);
                 }).get();
         	})	;
         		 */
         		//$("#dob").datepicker();
         		
         		 $( "#dob" ).datepicker({
         			  dateFormat: "yy-mm-dd"
         			});
         		var startdate="";
 			 	var endDate="";
         		
     /*     			  $('input[name="daterange"]').daterangepicker({
         			    opens: 'left',
         			   locale: {
         		            "format": 'DD-MM-YYYY',
         		          	 separator: 'To'
         		          
         		        }
         			  }, function(start, end, label) {
         			 	var startdate=start.format('YYYY-MM-DD');
         			 	var endDate=end.format('YYYY-MM-DD');
         			 	
         			 //   alert(startdate+" "+endDate);
         			  });
         		
         			  
         			  $("#datesubmit").click(function(){
         				  
         				  var date=$("#daterange").val();
         				 // alert(date);
         				  
         				  
         			  }) */
         		  
         			  
         		//$( "tr:eq( 2 )" ).css( "background-color", "orange" );
         		$('#master').on('click', function(e) {
         			if ($(this).is(':checked', true)) {
         				$(".sub_chk").prop('checked', true);
         				$(".sub_chk").prop('selected', true);
         
         			} else {
         				
         				$(".sub_chk").prop('checked', false);
         				$(".radio").prop('checked', false);
         				 $( 'input[name=checkbox]' ).prop( "disabled", false );
         			}
         		});
         		
         		
         
         		$("#preview").click(function() {
         			$("#showPreview").show();
         
         		});
         
         		// var table = $('#example').DataTable();
         
         		/* $('#example tbody').on( 'click', 'tr', function () {
         		alert( table.row( this ).data());
         		} ); 
         		
         		 */
         
         	});
         
         	$(window).scroll(function() {
         		if ($(window).scrollTop() >= 300) {
         			$('header').addClass('fixed-header');
         		} else {
         			$('header').removeClass('fixed-header');
         		}
         	});
      </script>
      <script type="text/javascript" charset="utf8"
         src="js/kotakjs/Maker_verification.js"></script>
      <script type="text/javascript" charset="utf8"
         src="js/kotakjs/formsubmit.js"></script>
      <script src="js/jquery-ui.js"></script>
        <!--  <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
            -->
    
      
   </body>
</html>

