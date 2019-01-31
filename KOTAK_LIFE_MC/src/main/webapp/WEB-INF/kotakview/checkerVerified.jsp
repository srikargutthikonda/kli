<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.posidex.prime.response.ProcessRsponse"%>

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

<style type="text/css">
.form_button_1 {
	margin-top: 17px;
	margin-left: 7px;
	width: 10%;
	float: left;
}

.dataTables_paginate {
	display: none !important;
}
</style>




<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Tabs - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<!--  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->

<script src="css/jquery-1.12.4.js"></script>
<script src="css/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>

</head>




<body>
	<header> <section id="header" class="header">
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
	</section> <nav id="menu-nav">
	<ul id="navigation ">
		<li><a href="#" class="active"> <span class="menu-text ">Checker
					Verification</span>
		</a></li>

		<li><a href="checkerSelectedview"> <span class="menu-text ">Selected
					View</span>
		</a></li>
	</ul>
	</nav> </header>
	<section id="content">
	<div id="widget" class="pd-sm text-primary" style="color: #439bfe;">Policy
		Number : ${PID}</div>

	<div id="widget-inner" class="mt-xs pd-sm" style="overflow: auto;">

		<!-- 	<form> -->
		<div class="form-box" style="overflow: auto;">
			<form action="getSeletedValueForChecker" method="GET">
				<div class="form-group w-20 pull-left">
					<label for="select">Select</label>
					<div class="select_box">

						<c:choose>
							<c:when
								test="${droplist.PROPOSED_ID == droplist.JOINT_LIFEASSURED_ID}">
								<select name="Select" id="selectedRecord1"
									class="form-control smalltext input-sm">
									<option selected="-1" value="0">--Select--</option>

									<%-- <c:forEach var="list" items="${droplist}">
                                            <option value="${list}">${list}</option>
                                            </c:forEach> --%>
									<%-- <option value="${droplist.CLIENT_ID}">CLIENT_ID(
								${droplist.CLIENT_ID} )</option> --%>

									<c:if test="${droplist.LIFEASSURED_ID!=null}">
										<option value="${droplist.LIFEASSURED_ID}">LIFEASSURANCE_ID(
											${droplist.LIFEASSURED_ID} )</option>
									</c:if>
									<c:if test="${droplist.PROPOSED_ID!=null}">
										<%-- <option value="${droplist.JOINT_LIFEASSURED_ID}">JLIFEASSURANCE_ID(
								${droplist.JOINT_LIFEASSURED_ID} )</option> --%>
										<option value="${droplist.PROPOSED_ID}">PROPOSED_ID(
											${droplist.PROPOSED_ID} )</option>
									</c:if>



								</select>


							</c:when>
							<c:when test="${droplist.LIFEASSURED_ID == droplist.PROPOSED_ID}">

								<select name="Select" id="selectedRecord1"
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
											${droplist.JOINT_LIFEASSURED_ID} )</option>
									</c:if>
									<c:if test="${droplist.PROPOSED_ID!=null}">
										<option value="${droplist.PROPOSED_ID}">PROPOSED_ID(
											${droplist.PROPOSED_ID} )</option>
									</c:if>



								</select>


							</c:when>
							<c:otherwise>
								<select name="Select" id="selectedRecord1"
									class="form-control smalltext input-sm">
									<option selected="-1" value="0">--Select--</option>

									<%-- <c:forEach var="list" items="${droplist}">
                                        <option value="${list}">${list}</option>
                                        </c:forEach> --%>
									<%-- <option value="${droplist.CLIENT_ID}">CLIENT_ID(
				${droplist.CLIENT_ID} )</option> --%>

									<c:if test="${droplist.LIFEASSURED_ID!=null}">
										<option value="${droplist.LIFEASSURED_ID}">LIFEASSURANCE_ID(
											${droplist.LIFEASSURED_ID} )</option>
									</c:if>
									<c:if test="${droplist.JOINT_LIFEASSURED_ID!=null}">
										<option value="${droplist.JOINT_LIFEASSURED_ID}">JLIFEASSURANCE_ID(
											${droplist.JOINT_LIFEASSURED_ID} )</option>
									</c:if>
									<c:if test="${droplist.PROPOSED_ID!=null}">
										<option value="${droplist.PROPOSED_ID}">PROPOSED_ID(
											${droplist.PROPOSED_ID} )</option>
									</c:if>
								</select>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="form_button_1">
					<button type="submit" id="SubmitChange"
						class="btn btn-custom btn-sm btn-none mr-xs">
						<i class="fa fa-paper-plane mr-xs"></i>Submit
					</button>
				</div>
			</form>
		</div>
	</div>
	
	<div class="loading_image mt-sm pd-sm" style="text-align:center;display:none;">
		<img src="images/loading.gif" style="width:3%;">
		<p style="font-size:14px;'">Loading...</p>
	</div>
	<!-------------------------------- tabs ------------------------------------------------------------->
	<div id="widget-inner" class="mt-xs pd-sm" style="overflow: auto;">
		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">Checker View</a></li>
				<li><a href="#tabs-2">Summary</a></li>
			</ul>
			<div id="tabs-1" class='selected' style="padding: 2px;">


				<div id="seletedview">

					<div id="datatable" style="overflow: auto;">
						<table id="example" class="dataTable" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th><input type="checkbox" id="master" disabled></th>
									<th>Client Id</th>
									<th>Match Rule</th>
									<th>Match Count</th>
									<th>Match Category</th>
									<th>Name</th>
									<th>Dob</th>
									<th>Gender</th>
									<th>Permanent Address</th>
									<th>Residence Address</th>
									<th>Office Address</th>
									<th>Residence Phone</th>
									<th>Office Phone</th>
									<th>Permanent Phone</th>
									<th>Aadhaar</th>
									<!-- <th>REQUEST_ID</th>
							<th>PSX_ID</th> -->

									<th>Ckyc No</th>
									<th>Client Type</th>
									<th>CRNNO</th>
									<th>GSTIN</th>
									<th>Source System</th>
									<th>Status</th>
									<th>Mobile</th>
									<th></th>
									<th>DOC</th>
									<th>REQUEST_ID</th>
									<th>PSX_ID</th>

								</tr>
							</thead>
							<tbody>

								<c:forEach var="response" items="${responseList}"
									varStatus="row">



									<c:if
										test="${response.SELECTED=='Y' && response.isRetain!='T'}">

										<tr>
											<td>select<input type="checkbox" class="sub_chk"
												id=${row
										} checked disabled id="test">
												Retain<input type="radio" name="selectRadio" disabled
												value="">

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
											<%-- <td>${response.REQUEST_ID}</td>
									<td>${response.PSX_ID}</td> --%>
											<td>${response.CKYCNO}</td>
											<td>${response.CLIENT_TYPE}</td>
											<td>${response.CRNNO }</td>
											<td>${response.GSTIN }
											<td>
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
											<td>Select<input type="checkbox" class="sub_chk"
												disabled id="test"> Retain<input type="radio"
												name="selectRadio" disabled value="">

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
											<%-- <td>${response.REQUEST_ID}</td>
									<td>${response.PSX_ID}</td> --%>
											<td>${response.CKYCNO}</td>
											<td>${response.CLIENT_TYPE}</td>
											<td>${response.CRNNO }</td>
											<td>${response.GSTIN }
											<td>
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
											<td>Select<input type="checkbox" class="sub_chk" checked
												disabled id="test"> Retain<input type="radio"
												name="selectRadio" checked disabled value="">

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
											<%-- <td>${response.REQUEST_ID}</td>
									<td>${response.PSX_ID}</td> --%>
											<td>${response.CKYCNO}</td>
											<td>${response.CLIENT_TYPE}</td>
											<td>${response.CRNNO }</td>
											<td>${response.GSTIN }
											<td>
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
						</table>
						<div class="form-button mt-md">
							<div class="form-button-1 pull-left">
								<button type="button" id="rejectSeleted"
									class="btn btn-custom btn-sm btn-none mr-xs">
									<i class="fa fa-paper-plane mr-xs"></i>Reject
								</button>
							</div>

							<div class="form-button-1 pull-left">
								<button type="button" id="approveSeleted"
									class="btn btn-custom btn-sm btn-none mr-xs">
									<i class="fa fa-paper-plane mr-xs"></i>Approve
								</button>
							</div>

						</div>
					</div>

				</div>
			</div>


			<div id="tabs-2" style="padding: 2px;">

				<div id="datatable" style="overflow: auto;">
		
			
			<table id="example1234" class="dataTable" cellspacing="0" width="100%">
						<thead>
							<tr>

								<th>Client Id</th>
								<th>Link Client Id</th>
								<th>Linking Date</th>
								<th>Status</th>
							<!-- <th>POLICY_NO</th> -->
								<th>ESB_Status</th>
							<th>ESB Status Description</th>
								<th>Remarks</th>
								<!-- <th>SOURCE</th>
							<th>DESTINATION</th>
							<th>TRANSACTION_DT</th>
							<th>TRANSACTION_TYPE</th>
							<th>ACTION</th>
							<th>POLICY_NO</th>
							<th>MERGE_CLIENT_NO</th>
							<th>RETAINED_CLIENT_NO</th>
							<th>SOURCE_CLIENT_NO</th>
							<th>RES_MERGE_VLIENT_NO</th>
							<th>RES_POLICY_NUM</th>
							<th>ERROR_CODE</th>
							<th>ERROR_DESCRIPTION</th>
							<th>MERGE_STATUS</th>
							<th>CLIENT_MERGE_ID</th> -->
							</tr>
						</thead>
					<tbody id="listdto">

							<c:forEach var="klidto" items="${resultslist}" varStatus="row">
								<tr>

									<td>${klidto.sourceClientNo}</td>
									<td>${klidto.clientMergeId}</td>
									<td>${klidto.transactionDt}</td>
									<td>${klidto.flag}</td>
								<%-- 	<td>${klidto.policyNo}</td> --%>
									<td>${klidto.mergeStatus}</td>
									<td>${klidto.errorcode} ${klidto.errorDescription}</td>
									<td></td>

									<%-- <td>${klidto.source}</td>
									<td>${klidto.destination}</td>
									<td>${klidto.transactionDt}</td>
									<td>${klidto.transactionType}</td>
									<td>${klidto.action}</td>
									<td>${klidto.policyNo}</td>
									<td>${klidto.mergeClientNo}</td>
									<td>${klidto.retainedClientNo}</td>
									<td>${klidto.sourceClientNo}</td>
									<td>${klidto.resMergeclientNo}</td>
									<td>${klidto.resPolicyNo}</td>
									<td>${klidto.errorcode}</td>
									<td>${klidto.errorDescription}</td>
									<td>${klidto.mergeStatus}</td>
									<td>${klidto.clientMergeId}</td> --%>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>

		</div>
	</div>

	</section>




	<footer class="footer" style="position:fixed;">
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
		$(document).ready(function() {

			/* $('#SubmitChange').click(function(){
				$('footer').css("position","relative");
				$('footer').css("bottom","0px");
				$('footer').css("margin-top","20px");
			}) */

			$("#SubmitChange").click(function() {

				$("selectedRecord").val = "";
				//var error = 0;
				var option = $('#selectedRecord1').val();

				if (option == '0') {
					// error = 1;
					alert('Please select an option !!');
					return false;
				}

			});

			$('#rejectSeleted').click(function() {
				//$('footer').css("position","absolute");
				//$('footer').css("margin-top","20px");
			})
			$('#approveSeleted').click(function() {
				//$('footer').css("position","absolute");
				//$('footer').css("margin-top","20px");
			})

			var table = $('#example').DataTable({
				"scrollX" : true,

				"paging" : false,
				"scrollY" : "250px",
				"scrollCollapse" : true,
				"ordering": false

			});
			//var data = table.row( 0 ).data();
			//alert(data);
			//var data = table.row( 0 ).addClass('redColor');
			/*  var id= $("#example").find("td:eq(1)").text();
				 if(id==="")
					 {
					
					 $('#rejectSeleted').prop('disabled',true).css('opacity',0.5);
					 $('#approveSeleted').prop('disabled',true).css('opacity',0.5);
					 } */
			$("tr:eq( 2 )").css("background-color", "#fbe6a0"); //rgb(255, 199, 164);
			$('td:nth-child(26),th:nth-child(26)').hide();
			$('td:nth-child(25),th:nth-child(25)').hide();
			//table.row(1).addClass("redColor");
			// $("#dob").datepicker();

			/* $('#master').on('click', function(e) {
			    if ($(this).is(':checked', true)) {
			        $(".sub_chk").prop('checked', true);
			        $(".sub_chk").prop('selected', true);


			    } else {
			        $(".sub_chk").prop('checked', false);
			    }
			});
			 */

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



</body>




</html>