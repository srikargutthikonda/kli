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

<link href="css/makerbody.css" rel="stylesheet">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style type="text/css">
	body{
		color: ;
		background: ;
		font-family: 'Roboto', sans-serif;
	}
    .form-control{
		height: 40px;
		box-shadow: none;
		color: #969fa4;
	}
	.form-control:focus{
		border-color: #5cb85c;
	}
    .form-control, .btn{        
        border-radius: 3px;
    }
	.signup-form{
		width: 400px;
		margin: 0 auto;
		padding: 30px 0;
	}
	.signup-form h2{
		color: #636363;
        margin: 0 0 15px;
		position: relative;
		text-align: center;
    }
	.signup-form h2:before, .signup-form h2:after{
		content: "";
		height: 2px;
		width: 30%;
		background: #d4d4d4;
		position: absolute;
		top: 50%;
		z-index: 2;
	}	
	.signup-form h2:before{
		left: 0;
	}
	.signup-form h2:after{
		right: 0;
	}
    .signup-form .hint-text{
		color: #999;<style type="text/css">
	body{
		color: #fff;
		background: #63738a;
		font-family: 'Roboto', sans-serif;
	}
    .form-control{
		height: 40px;
		box-shadow: none;
		color: #969fa4;
	}
	.form-control:focus{
		border-color: #5cb85c;
	}
    .form-control, .btn{        
        border-radius: 3px;
    }
	.signup-form{
		width: 400px;
		margin: 0 auto;
		padding: 30px 0;
	}
	.signup-form h2{
		color: #636363;
        margin: 0 0 15px;
		position: relative;
		text-align: center;
    }
	.signup-form h2:before, .signup-form h2:after{
		content: "";
		height: 2px;
		width: 30%;
		background: #d4d4d4;
		position: absolute;
		top: 50%;
		z-index: 2;
	}	
	.signup-form h2:before{
		left: 0;
	}
	.signup-form h2:after{
		right: 0;
	}
    .signup-form .hint-text{
		color: #999;
		margin-bottom: 30px;
		text-align: center;
	}
    .signup-form form{
		color: #999;
		border-radius: 3px;
    	margin-botto
		margin-bottom: 30px;
		text-align: center;
	}
    .signup-form form{
		color: #999;
		border-radius: 3px;
    	margin-bottom: 15px;
        background: #f2f3f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
	.signup-form .form-group{
		margin-bottom: 20px;
	}
	.signup-form input[type="checkbox"]{
		margin-top: 3px;
	}
	.signup-form .btn{        
        font-size: 16px;
        font-weight: bold;		
		min-width: 140px;
        outline: none !important;
    }
	.signup-form .row div:first-child{
		padding-right: 10px;
	}
	.signup-form .row div:last-child{
		padding-left: 10px;
	}    	
    .signup-form a{
		color: #fff;
		text-decoration: underline;
	}
    .signup-form a:hover{
		text-decoration: none;
	}
	.signup-form form a{
		color: #5cb85c;
		text-decoration: none;
	}	
	.signup-form form a:hover{
		text-decoration: underline;
	}  
</style>


</head>

<script>
$(document).ready(function(){
	//alert("ajax loading");
	
	
	$(function () {
        $("#selectedRecord").change(function () {
            var selectedText = $(this).find("option:selected").text();
            var selectedValue = $(this).val();
           // alert("Selected Text: " + selectedText + " Value: " + selectedValue);
            var data = "";
            $.ajax({
                type:"GET",
                url : "inputfromdropdown",
                data : "seletedvalue="+$(this).val(),
                async: false,
                success : function(response) {
                	alert(response)
                	data = response;
                	var json = JSON.parse(data);
                   // alert(json.firstName)
					$('#firstname').val(json.firstName);
                    $('#lastname').val(json.lastName);
                    $('#email').val(json.email);
                    $('#fathername').val(json.fatherName);
                    $('#city').val(json.city);
                    $('#contact').val(json.contact);

                    
                    return response;
                },
                error: function() {
                    alert('Error occured');
                }
            });
        
        
        });
    });
	
	
	 $.ajax({ url: "/posidex.crms",
			type:"GET",
	        success: function(data){
	        	console.log(data);
		          alert(data);
                 
	        	
	        }}); 
	});



</script>
<body>

	<nav class="navbar navbar-inverse">
	<div style="float: left">
		<img src="images/logo_posidex_0.png" width="50" height="50" border="0"
			usemap="#chart" />&nbsp;&nbsp
	</div>
	<ul class="nav navbar-nav">
		<li><a href="#">Maker_Verification</a></li>
				<li><a href="#">Checker_Verification</a></li>
		
	</ul>
	<p class="navbar-text">Some text</p>
	</nav>
	<div class="container" align>
		<select id="selectedRecord" name="selectedRecord">
			<c:forEach var="list" items="${droplist}">
				<option value="${list}">${list}</option>
			</c:forEach>
		</select> 

		
	</div>
	<div>
	<div class="signup-form">
	 <form action="/examples/actions/confirmation.php" method="post">
		<h2></h2>
		<p class="hint-text"></p>
        <div class="form-group">
			<div class="row">
			
				<div class="col-xs-6"><input type="text" class="form-control" name="first_name" placeholder="First Name" id="firstname" value='${dgData.firstName}'></div>
				<div class="col-xs-6"><input type="text" class="form-control" name="last_name" placeholder="last_name" id="lastname" value='${dgData.lastName}'></div>
				
			</div>        	
        </div>
        <div class="form-group">
			<div class="row">
				<div class="col-xs-6"><input type="text" class="form-control" name="fathername" placeholder="fathername" id="fathername" value='${dgData.fatherName}'></div>
				<div class="col-xs-6"><input type="text" class="form-control" name="city" placeholder="city" id="city" value='${dgData.city}'></div>
			</div>        	
        </div>
        <div class="form-group">
			<div class="row">
				<div class="col-xs-6"><input type="text" class="form-control" name="contact" placeholder="contact" id="contact" value='${dgData.contact}'></div>
				<div class="col-xs-6"><input type="text" class="form-control" name="email" placeholder="email" id="email" value='${dgData.email}'></div>
			</div>        	
        </div>
             
       
		<div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">SUBMIT</button>
        </div>
    </form>
	</div>
	
	
	</div>



</body>
</html>