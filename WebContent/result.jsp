<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Research Result</title>
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
	<link href="css/result-style.css" rel="stylesheet" type="text/css" media="all" />
	<!-- js -->
	<script src="js/jquery-1.11.1.min.js"></script>
	<!-- //js -->
	<!-- radio-buttons -->
	<link rel="stylesheet" href="css/sky-forms.css">
	<!-- //radio-buttons -->
	<link href='https://fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,900,800' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
	<%@page import="java.util.HashMap" %>
	<%@page import="java.util.ArrayList" %>
	<%@page import="java.util.List"%>
	<%@page import="java.util.Set"%>
	<%@page import="org.json.*"%>
	<%
		String queryText = (String)request.getAttribute("query_text");
		String bankName = (String)request.getAttribute("bank_name");
		String cardName = (String)request.getAttribute("card_name");
		double bonus = (double)request.getAttribute("bonus");
		
		HashMap<String, String> map = (HashMap)request.getSession().getAttribute("result");
	%>
</head>
	
<body>
	<div class="main-container">
		<!-- Heading -->
		<div class="heading">
			<h3>Credit Card Recommendation</h3>
		</div>
		<p class="tag">Your Query: </p><p class="text-body"><%=queryText %>></p>
		<!-- whole container-->
		<hr>
		<div class="one-item">
			<div class="card-image"><img src="images/citi-prestige-card.png"></div>
			<div class="information">
				<p class="tag">Bank Name: </p><p class="text-body"><%=bankName%></p>
				<br>
				<p class="tag">Card Name: </p><p class="text-body"><%=cardName%></p>
				<br>
				<p class="tag">Bonus: </p><p class="text-body"><%=bonus%></p>
			</div>
		</div>
		<hr>

		<div class="link-group">
			<h4>Related Links</h4>
			<%
			int count = 1;
			for(String s : map.keySet()) {
				out.println("----" + count + "----");
				out.println("<a href='"+ s + "' target='_blank'>" + s + "</a>");
				out.println("<p>"+ "Content: " + map.get(s) + "</p>");
			}
			%>
		</div>
	</div>

	<div class="footer-bottom">
		<p>Copyright © 2016 Developed by Zhirun Tian, Chenlei Zhao, Siying Zhang| Template by <a href="http://w3layouts.com">W3layouts</a></p>					
	</div>
</body>

</html>