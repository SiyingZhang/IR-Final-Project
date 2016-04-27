<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Find your credit card|Home</title>
	<!-- for-mobile-apps -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="application/x-javascript"> 
		addEventListener("load", function() { 
			setTimeout(hideURLbar, 0); 
		}, 
		false);
		function hideURLbar(){ 
			window.scrollTo(0,1); 
		} 
	</script>
	<!-- //for-mobile-apps -->
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/search-style.css" rel="stylesheet" type="text/css" media="all" />
	<!-- js -->
	<script src="js/jquery-1.11.1.min.js"></script>
	<!-- //js -->
	<link href='https://fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,900,800' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
	<!-- Get all values from input components -->
	<%
	String queryText = (String)request.getAttribute("query_text");
	if(queryText == null) {
		queryText = "";
	}
	String creditScore = (String)request.getAttribute("credit_score");
	if(creditScore == null) {
		creditScore = "";
	}
	String monthlySpend = (String)request.getAttribute("monthly_spend");
	if(monthlySpend == null) {
		monthlySpend = "";
	}
	String network = (String)request.getAttribute("network");
	if(network == null) {
		network = "";
	}
	String issuer = (String)request.getAttribute("issuer");
	if(issuer == null) {
		issuer = "";
	}
	%>
</head>
	
<body>
	<div class="main-container">
		<!-- Heading -->
		<div class="heading">
			<h1>Find Suitable Credit Card</h1>
			<h3>Input your requirements below, let us help you to realize your goal.</h3>
		</div>
		<form action="QueryServlet" method="post">
		<!-- whole container-->
		<div class="container-fluid">
			<div class="search-conditions">
				<!-- text search box -->
				<div class="search-box">
					<input type="text" name="query_text" id="queryContent" placeholder="Search Query" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your requirements/Keywords';}">
				</div>
				<!-- search button -->
				<input id="queryContent" type="submit" value="SEARCH">
			</div>
			<!-- Personal Status: Dropdown box -->
			<div class="personal-status">
				<hr>
				<div class="personal-group">
					<div class="left-dropdown-box">
						<p class="subtitle">CREDIT SCORE</p>
						<span class="custom-dropdown big">
						    <select name="credit_score" class="select-box">   
						        <option>Excellent (720-850)</option>
						        <option>Good (690-719)</option>  
						        <option>Average (630-689)</option>
						        <option>Poor (350-629)</option>
						    </select>
						</span>
					</div>
					<div class="right-dropdown-box">
						<p class="subtitle">MONTHLY SPEND</p>
						<span class="custom-dropdown big">
						    <select name="monthly_spend" class="select-box">    
						        <option>$200 - $500</option>
						        <option>$501 - $800</option>  
						        <option>$801 - $1200</option>
						        <option>$1201 - $1700</option>
						        <option>$1701 - $2000</option>
						        <option>$2001 - $5000</option>
						    </select>
						</span>
					</div>
				</div>
			</div>
			<div class="card-information">
				<hr>
				<div class="cardinfo-group">
					<div class="left-dropdown-box">
						<p class="subtitle">NETWORK</p>
						<span class="custom-dropdown big">
						    <select name="network" class="select-box">    
						        <option>American Express</option>
						        <option>Discover</option>
						        <option>Visa</option>
						        <option>MasterCard</option>
						    </select>
						</span>
					</div>
					<div class="right-dropdown-box">
						<p class="subtitle">ISSUER</p>
						<span class="custom-dropdown big">
						    <select name="issuer" class="select-box">    
						        <option>American Express</option>
						        <option>Bank of America</option>  
						        <option>Barclaycard</option>
						        <option>Capital One</option>
						        <option>Chase</option>
						        <option>Citibank</option>
						        <option>Discover</option>
						        <option>Other Banks</option>
						        <option>U.S. Bank</option>
						    </select>
						</span>
					</div>
				</div>
			</div>
			<script type="text/javascript" src="js/script.js"></script>
	</div>
	</form>
		<div class="footer-bottom">
			<p>Copyright © 2016 Developed by Zhirun Tian, Chenlei Zhao, Siying Zhang| Template by <a href="http://w3layouts.com">W3layouts</a></p>					
		</div>
	</div>
</body>

</html>
