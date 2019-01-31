<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- for model dilogue 8th nov -->



<link rel="icon" type="image/png" href="/images/logo_posidex_0.png" />


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" charset="utf8"
	src="//cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>




<style>

/* Modal styles */
.modal .modal-dialog {
	max-width: 400px;
}

.modal .modal-header, .modal .modal-body, .modal .modal-footer {
	padding: 20px 30px;
}

.modal .modal-content {
	border-radius: 3px;
}

.modal .modal-footer {
	background: #ecf0f1;
	border-radius: 0 0 3px 3px;
}

.modal .modal-title {
	display: inline-block;
}

.modal .form-control {
	border-radius: 2px;
	box-shadow: none;
	border-color: #dddddd;
}

.modal textarea.form-control {
	resize: vertical;
}

.modal .btn {
	border-radius: 2px;
	min-width: 100px;
}

.modal form label {
	font-weight: normal;
}

.title {
	color: #ec5216;
}

.form-control {
	height: 40px;
	box-shadow: none;
	color: #969fa4;
}

.form-control:focus {
	border-color: #5cb85c;
}

.form-control, .btn {
	border-radius: 3px;
}
</style>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="css/jquery.datatable.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />


<script>
	$(document).ready(function() {

	
		$("").click(function() {
			alert("edit button clicked");
			$('#dialog').dialog('open');
		});
		//$(".contactForm").hide();

		$('#example').DataTable({
			dom : 'Bfrtip',
			buttons : [ 'copyHtml5', 'excelHtml5', 'csvHtml5', 'pdfHtml5' ],

		});

		var role = $("#role").val();
		if (role != 'admin') {

			var table = $('#example').DataTable();

			table.column(4).visible(false);
			table.column(5).visible(false);

			//	$('.delete').hide();
			//$('.edit').hide();
			//	$('#deleteHeader').hide();
			//$('#editHeader').hide();
			$('#register').hide();
			$('#showall').hide();
			//	$('#editform').hide();

		}
	
		var table = $('#example').DataTable();
		 
		$('#example tbody').on( 'click', 'tr', '.edit', function () {
		    var d = table.row( this ).data();
		     var name=d[0];
		     var email=d[1];
		     var mobile=d[2];
		     var ext=d[3];
		     $('#name').val(name);
		     $('#email').val(email);
		     $('#contact').val(mobile);
		     $('#ext').val(ext);

		     
		    alert(d[0]);
		} );
		
		
		
		

	});

</script>





</head>
<body style="background-color: #ccccff">


	<div class="navbar navbar-inverse">

		<div class="container"
			style="width: 100%; padding-left: 0px; background-color: #626af6">

			<div style="float: left">
				<img src="/images/logo_posidex_0.png" width="50" height="50"
					border="0" usemap="#chart" />&nbsp;&nbsp
			</div>
			<div style="float: left">
				<a class="navbar-brand" href="#">&nbsp;&nbsp;<b class="title">POSIDEX_CONTACT_REPO**</b></a>
			</div>

			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li>
						<!-- 			<img src="images/logo_posidex_0.png"></img>
 -->
					</li>
					<li><a id="register" href="/register"><font color=""><b>ADD
									EMPLOYEE</b></font></a></li>
					<!-- 					<li><a id="showall" href="/view">Show All</a></li>
 -->
					<li><a href="#"LoggedBy:${email}> Logged By:${email}</a></li>


					<li><a href="/logout"> <span
							class="glyphicon glyphicon-log-out"></span> Log out
					</a></li>


				</ul>
			</div>
		</div>
	</div>
	<input id="role" type="hidden" value="${sessionrole}" />
	</nav>

	<div class="contactEdit">

		<a id="edit" href="singleEdit?name=${email}"
			class="btn btn-warning btn-sm"> <span
			class="glyphicon glyphicon-pencil">Edit_Your_Data</span></a>



	</div>
	<div align="center">

		<table border="2" id="example" class="display" style="width: 98%">
			<thead align="center">
				<tr bgcolor="#626af6">
					<th><span class="glyphicon glyphicon-user">_NAME</span></th>

					<th><span class="glyphicon glyphicon-envelope">_EMAIL</span></th>
					<th><span class="glyphicon glyphicon-earphone">_CONTACT</span></th>
					<th><span class="glyphicon glyphicon-phone-alt">_EXT</span></th>

					<th id="editHeader">Edit</th>

					<th id="deleteHeader">DELETE</th>
					<th>Active</th>

				</tr>
			</thead>
			<tbody>

				<c:forEach var="user" items="${list}">
					<tr align="center">
						<td>${user.usertname}</td>
						<td>${user.desk}</td>
						
						<td>${user.ext}</td>
						
						<td>${user.email}</td>
						<td>${user.birthDate}</td>
						<td>${user.profession}</td>

						<td>${user.name}</td>

						<td>${user.email}</td>
						<td>${user.contact}</td>

						<td>${user.ext}</td>


						<td>
							<a href="<c:url value='/edit/${user.username}' />">Edit</a>

							<!-- edit working fine section --> 	<span class="edit" data-toggle="modal" data-target="#modalRegisterForm"> <a id="edit"
								href="edit?name=${user.email}" class="btn btn-warning btn-sm">
									<span class="glyphicon glyphicon-pencil">EDIT</span>
							</a>
							<!-- model closed here -->
							
						</span> <a href="#editEmployeeModal" class="edit"
							data-toggle="modal">EDIT</a>

						</td>
						<td align="center"></span> <span class="delete"> <a
								id="alertbox" href="/remove?email=${user.email}"
								class="btn btn-danger btn-sm"> <span
									class="glyphicon glyphicon-trash"></span> DELETE
							</a>


						</span></td>
						<td>
							<!-- till here --> <a id="active" href="#"
							class="btn btn-primary btn-sm"> <span
								class="glyphicon glyphicon-eye-open"></span> Active
						</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- Edit Modal HTML -->
		<div id="editEmployeeModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">

					 <form>
						<div class="modal-header">
							<h4 class="modal-title">Edit Employee</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								 <input id="name" type="text" class="form-control"
									required>
							</div>
							<div class="form-group">
								<input id="email" type="email" class="form-control"
									required>
							</div>
							
							<div class="form-group">
								 <input id="contact" type="text" class="form-control"
									required>
							</div>
							
														<div class="form-group">
								 <input id="ext" type="text" class="form-control"
									required>
							</div>
							
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								value="Cancel"> <input type="submit"
								class="btn btn-info" value="Save">
						</div>
					</form>
 			
 
 
 <form:form modelAttribute="employeeContact" action="saveContact"
			method="post" onsubmit="openModal()" id="myForm">
			<table border="2" style="background: #33bed2">
				<tr>
					<td colspan="2" align="center"><h2>EMPLOYEE DATA</h2></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><form:input  id="name" path="name"
							required="true" /></td>
				</tr>

				<tr>
					<td>Email:</td>
					<td><form:input id="email" path="email" 
							readonly="true" required="true" /></td>
				</tr>

				<tr>
					<td>Contact:</td>
					<td><form:input id="contact" path="contact" 
							required="true" /></td>
				</tr>
				<tr>
					<td>Ext:</td>
					<td><form:input id="ext" path="ext"
							required="true" /></td>
				</tr>

				<tr>
					<td>Role:</td>
					                    <td><form:input path="profession" /></td>

					<td><form:select path="role" required="true">
							<form:option value="${employee.role}" label="${employee.role}" />
							<form:option value="Developer">Developer</form:option>
							<form:option value="admin">Taster</form:option>
							<form:option value="TeamLead">TeamLead</form:option>
							<form:option value="Manager">Manager</form:option>
						</form:select></td>


				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register" id="submit" /></td>
				</tr>
			</table>
		</form:form>

 
 
 
 
 
 
 </div>
			</div>
		</div>










				<div id="editform" class="contactForm">

			<form:form id="myform" class="myform" modelAttribute="command"
				action="saveContact" method="post">

				<table border="2" style="background: #8d88e3">
					<tr>
						<td colspan="2" align="center"><h2>Employee Details</h2></td>
					</tr>
					<tr>
						<td>User Name:</td>
						<td><form:input path="name" value='${employee.name}'
								required="true" readonly="true" /></td>
					</tr>

					<tr>
						<td>EMAIL:</td>
						<td><form:input path="email" value='${employee.email}'
								required="true" /></td>
					</tr>

					<tr>
						<td>CONTACT:</td>
						<td><form:input path="contact" value='${employee.contact}'
								required="true" /></td>
					</tr>
					<tr>
						<td>Ext:</td>
						<td><form:input path="ext" value='${employee.ext}'
								required="true" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Register" id="submit" /></td>
					</tr>
				</table>
			</form:form>

		</div>



	</div>



	</div>









</body>
</html> --%>