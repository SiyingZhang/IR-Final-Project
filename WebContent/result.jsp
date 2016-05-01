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
	<link href='https://fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,900,800' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
	<%@page import="java.util.HashMap" %>
	<%@page import="java.util.ArrayList" %>
	<%@page import="java.util.List"%>
	<%@page import="java.util.Set"%>
	<%@page import="org.json.*"%>
	<%@page import="org.apache.lucene.document.Document" %>
	<%
		String queryText = (String)request.getAttribute("query_text");
		if(queryText == null){
			queryText = "";
		}
		
		String bankName = (String)request.getAttribute("bank_name");
		if(bankName == null){
			bankName = "AE";
		}
		
		String cardName = (String)request.getAttribute("card_name");
		if(cardName == null){
			cardName = "AE";
		}
		
		String cardImg = (String)request.getAttribute("path");
		if(cardImg == null){
			cardImg = "/3.png";
		}
		
		double bonus = (double)request.getAttribute("bonus");
		if(request.getAttribute("bonus") == null){
			bonus = 6;
		}
		
		List<Document> docList = (ArrayList)request.getSession().getAttribute("result");
		/* if(request.getSession().getAttribute("result") == null){
			System.out.println("result is null");
		} */
	%>
</head>
	
<body>
	<div class="main-container">
		<!-- Heading -->
		<div class="heading">
			<h3>Credit Card Recommendation</h3>
		</div>
		<!-- whole container-->
		
		<div class="one-item">
			<p class="tag">Your Query: </p><p class="text-body"><%=queryText %></p>
			<hr>
			<div class="card-image"><img src="images/<%=cardImg %>"></div>
			<div class="information">
				<p class="tag">Bank Name: </p><p class="text-body"><%=bankName %></p>
				<br>
				<p class="tag">Card Name: </p><p class="text-body"><%=cardName %></p>
				<br>
				<p class="tag">Bonus: </p><p class="text-body"><%=bonus %></p>
			</div>
		</div>

		<div class="link-group">
			<hr>
			<h4>Related Links</h4>
			<%
			int count = 1;
			for(Document d : docList) {
				out.println("<p>----------------" + count + "----------------</p><br>");
				out.println("<a href='"+ d.get("link") + "' target='_blank'>" + d.get("title") + "</a><br>");
				out.println("<p>"+ "Abstract: " + d.get("abstract") + "</p><br>");
				count++;
			}
			%>
		</div>
	</div>

	<div class="footer-bottom">
		<p>Copyright © 2016 Developed by Zhirun Tian, Chenlei Zhao, Siying Zhang | Template by <a href="http://w3layouts.com">W3layouts</a></p>					
	</div>
</body>

</html>