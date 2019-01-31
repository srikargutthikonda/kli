<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Kotak Life - Posidex Technologies</title>
<meta name="description" content="POSIDEX Technologies Pvt. Ltd." />
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" sizes="196x196" href="images/fav-icon.png">
<link rel="stylesheet" type='text/css'
	href="fonts/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type='text/css' href="css/style.css">


<style>
footer {
	position: absolute;
	margin-top: 20px;
}

.welcome_page_block {
	width: 30%;
display: block;
height: auto;
margin: 0 auto;
overflow: auto;
}

.column_left, .column_right {
	width: 40%;
	float: left;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	text-align: center;
}

.column_right {
	margin-left: 10px;
}

.column_left a, .column_right a {
	color: #707070;
	text-align: center;
}

.column_left img, .column_right img {
	width: 55%;
}

.column_left h5, .column_right h5 {
	margin-top: 13px;
}
.logo
{
	margin-top:0px;
}
</style>



</head>





<body>
	<header>
		<section id="header" class="header">
			<div class="logo">
				<img src="images/psxlogo.png" alt=" Posidex Logo"
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
	</header>
	<section id="content">
		<div id="widget-inner" class="mt-sm pd-sm" style="overflow: auto;">
			<div class="welcome_page_block">
				<div class="column_left">
					<a href="makerHome"> <img src="images/dedupe2.png"
						alt=" DEDUPE" title=" DEDUPE ">
						<h5>DEDUPE</h5>
					</a>

				</div>
				<div class="column_right">
					<a href="selectedview"> <img src="images/listview.png"
						alt=" SELETED VIEW" title=" SELETED VIEW " />
						<h5>SELECTED VIEW</h5>
					</a>
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


</body>


</html>