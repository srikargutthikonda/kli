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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.left{
     }

</style>

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

	<div class="left">
	<h4 style="color: red">| No Data Found With Given Details Please
			Try again !! <img src="images/psx_logo.png" width="130" height="50" align="left"> 
		
		</br>|${errormsg}</h4>

		
	</div>
	</nav>
</body>
</html>