<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 -->  
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<script>
$(document).ready(function(){
	//alert("ajax loading");
	/* $.ajax({ url: "/",
			type:"GET",
	        success: function(data){
	        	console.log(data);
		          alert(data);
                 
	        	$("#result").html(data);
	        }}); */
	});



</script>
<body>

<nav class="navbar navbar-inverse">
<div style="float: left">
				<img src="images/logo_posidex_0.png" width="50" height="50"
					border="0" usemap="#chart" />&nbsp;&nbsp
			</div>
  <!-- <ul class="nav navbar-nav">
    <li><a href="#">User_Verification</a></li>
    <li><a href="#">Link</a></li>
  </ul>
  <p class="navbar-text">Some text</p>
</nav> -->

<div class="container">
  <h3>Invalid User Please try again !!</h3>
<%-- <c:forEach var="user" items="${dropdown}">
<h2>
${{user}}
</h2>
</c:forEach> --%>
<div id="result"></div>
</div>













</body>
</html>