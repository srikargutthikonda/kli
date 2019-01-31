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
      <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />

<style type="text/css">


.form_button_1 {
	margin-top: 14px;
	margin-left: 7px;
	width: 10%;
	float: left;
}
.dataTables_paginate
       {
       	display:none !important;
       }
       .tableInfo{
       width:30%;
       }
</style>

</head>




<body>
	<header> <section id="header" class="header">
	<div class="logo">
		<img src="images/psxlogo.png" width="" height="" alt=" Posidex Logo"
			title=" Posidex  Logo " />

	</div>
	<div class="header_side_icon" style="margin: 13px 0">
	<!--  <nav id="nav">
		<ul id="navigation">

			
		</ul>
		</nav>  -->
	</div>
	</section> <nav id="menu-nav">
	<ul id="navigation ">
		
		<li>
		<a href="#" class="active"> <span
                  class="menu-text ">Reports</span>
                  </a>
		</li>
		
               <li>
               
               </li>
	</ul>
	</nav> </header>
	<section id="content">
	
	  <div id="widget-inner" class="mt-sm pd-sm" style="overflow: auto;">
         
           <form action="getReport" method="post">
           <div id="reportcontent" align="center">
           <table class="tableInfo">
		<tr><td>Select Report Type </td><td><select name="SelectReport" id="report" class="form-control smalltext input-sm">
		<option selected="-1" value="0">--Select--</option>
				<option  value="dedupereport">Dedupe Report</option>
				<option  value="misreport">MIS Report</option>
		</select></td></tr>
		<tr><td>From </td>
		<td><input type="text" name="daterange" id="daterange" value="" size="35" /> </td></tr>
		<tr>	<td></td>	<td>	<button type="submit" id="getReport"
						class="btn btn-custom btn-sm btn-none mr-xs">
						<i class="fa fa-paper-plane mr-xs"></i>Get Report
					</button></td>
					</tr>
					</table>
					</div>
				</form>
       </div>
       
	
	
	<div id="deDupeReport">
		<div id="widget-inner" class="mt-sm pd-sm" style="overflow: auto;">
			<div id="datatable" style="overflow: auto;">
				<table id="example" class="dataTable" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>SNO</th>
							<th>SOURCE</th>
							<th>PROPOSAL NO</th>							
							<th>NEW_CLIENT_CREATED</th>
							<th>SOURCE_CID</th>
							<th>RETAIN_CID</th>
							<th>MERGER_CID</th>
							<th>EXISTING_CID</th>
							<th>COUNT_OF_MATCHING_CID</th>
							<th>AUTO/MANUAL SELECTION<th>
							<th>RULES</th>
							<th>CONFIDENCE_LEVEL_MATCH</th>
							<th>ACTIVITY_COMPLETED</th>
							
							<th>USER_ID</th>
						<th>TYPE_OF_SYSTEM</th>
							<th>DECISION TAKEN</th>
								<th>SIMULTANEOUS POLICY LIST</th>
							

						</tr>
					</thead>
					<tbody>
					
						<c:forEach var="response" items="${responseList}" varStatus="theCount">
									<tr>
									<td>${theCount.count}</td>
									<td>${response.SOURCE}</td>
									<td>${response.PROPOSAL_NO}</td>
									<td></td>
									<td>${response.SOURCE_CLIENT_ID}</td>
									<td>${response.RETAINED_CLIENT_ID}</td>
									<td>${response.MERGED_CLIENT_ID}</td>
									<td>${response.EXISTING_CLIENT_ID }</td>
									<td>${response.COUNT_OF_MATCHING_CLIENT_ID}</td>
									<td>${response.AUTO_MANUAL_SELECTION}</td>
									<td>${response.CONFIDENCE_LEVEL_MATCH}</td>
									<td>${response.RULES}</td>
									<td>${response.TYPE_OF_SYSTEM}</td>
									<td>${response.ACTIVITY_COMPLETED}</td>
									<td>${response.USER_ID}</td>
									<td>${response.SIMULTANEOUS_POLICY_LIST}</td>
									<td>${response.DECISION_TAKEN}</td>
									<td></td>
								</tr>


							
				</c:forEach>

					</tbody>
				</table>








			
			</div>
		</div>
	</div>
	<span>
	<div id="misReport">
		<div id="widget-inner" class="mt-sm pd-sm" style="overflow: auto;">
			<div id="datatable" style="overflow: auto;">
				<table id="misReportTable" class="dataTable" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>SNO</th>
							<th>POLICYNUMBER</th>
							<th>CUSTOMERID</th>
							<th>STATUS</th>
							
							

						</tr>
					</thead>
					<tbody>
					
						<c:forEach var="response" items="${misreportList}" varStatus="theCount">
<tr>
								 <td>${theCount.count}</td>
									<td>${response.policy_number}</td>
									<td>${response.customer_id}</td> 
									<td>${response.status}</td> 
									
								</tr>


							
				</c:forEach>

					</tbody>
				</table>

			
			</div>
		</div>
	</div>
	</span>
	

	</section>




	<script src="js/jquery-1.12.4.js"></script>
	<script src="js/jquery.dataTables.min.js"></script>
<script>
 
</script>
	<script>
		$(document).ready(function() {
			
			$("#deDupeReport").hide();
			 $("#misReport").hide();
	var selectedValue;
		$("#report").change(function() {
				 selectedValue = $(this).val();
				 //  alert(selectedValue);
					
				   /* if(selectedValue==='dedupereport')
					   {
					 $("#misReport").hide();
					 $("#deDupeReport").show();
					   }
				   if(selectedValue==='misreport')
				   {
					$("#deDupeReport").hide();
					 $("#misReport").show();
				   }  */
				   
			 });
			
		
		
			
			
			
			//$("#reportview").hide();
		/* 	$("#getReport").click(function(){
				$("#reportview").show();

     		});
			 */
			
			
			
			var table = $('#example').DataTable({
				"scrollX" : true,
				"scrollY" : true,
				"bPaginate": false,
		        "bFilter": false,
		        "bInfo": false,
				 dom: 'Bfrtip',
			        buttons: [
			            'csvHtml5'
			           /*  'pdfHtml5' */
			        ]
			});
			
			var table = $('#misReportTable').DataTable({
				"scrollX" : true,
				"scrollY" : true,
				"bPaginate": false,
		        "bFilter": false,
		        "bInfo": false,
				 dom: 'Bfrtip',
			        buttons: [
			            'csvHtml5'
			           /*  'pdfHtml5' */
			        ]
			        
			});
			
			
    		 var dedupeId= $("#example").find("td:eq(2)").text();
    		
    		 
    		
    		 
    		 var misId1= $("#misReportTable").find("td:eq(2)").text();
    	

    		 $("#getReport").click(function(){
         		
 				
         		//var error = 0;
                 var selectedValue = $('#report').val();
 				
                 if (selectedValue == '0') {
                    // error = 1;
                     alert('Please select report type !!');
                     return false;
                 }
                
                 
         	});
    		 
    		 if(dedupeId==="" && misId1!=="" )
    			 {
    				alert("dedupe =="" and misId!=");
    				$("#deDupeReport").hide();
    				 $("#misReport").show();
    			 }
    		 if(dedupeId!=="" && misId1==="" )
			 {
 				alert("dedupe !=="" and misId!=");
 		

				$("#deDupeReport").show();
				 $("#misReport").hide();
			 }
    		 
			
			/* $('#misReportTable').dataTable({
				   //initialization params as usual
				   fnInitComplete : function() {
				      if ($(this).find('tbody tr').length<=1) {
				         $(this).parent().hide();
				      }
				   } 
				}); */
			
			
			
			
			
			
			
			//var data = table.row( 0 ).data();
			//alert(data);
			//var data = table.row( 0 ).addClass('redColor');
			

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

			 var startdate="";
			 	var endDate="";
      		
      			  $('input[name="daterange"]').daterangepicker({
      			    opens: 'left',
      			   locale: {
      		            "format": 'DD-MM-YYYY',
      		          	 separator: '  To  '
      		          
      		        }
      			  }, function(start, end, label) {
      			    console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
      			 	var startdate=start.format('YYYY-MM-DD');
      			 	var endDate=end.format('YYYY-MM-DD');
      			 	
      			 //   alert(startdate+" "+endDate);
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
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js"></script> 
        <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
    


</body>




</html>