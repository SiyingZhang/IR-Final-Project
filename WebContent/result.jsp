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
	<%
		String bankName = (String)request.getAttribute("");
		String cardName = (String)request.getAttribute("");
		String bonus = (String)request.getAttribute("");
	%>
</head>
	
<body>
	<div class="main-container">
		<!-- Heading -->
		<div class="heading">
			<h3>Credit Card Recommendation</h3>
		</div>
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
		<!--
		<div class="one-item">
			<div class="card-image"><img src="images/ritz_carlton_card.png"></div>
			<div class="information">
				<p class="tag">Bank Name: </p> <p class="text-body">Chase</p>
				<br>
				<p class="tag">Card Name: </p> <p class="text-body">Ritz-carlton</p>
				<br>
				<p class="tag">Bonus: </p> <p class="text-body">Gold elite status  at  Ritz Carlton reward program.</p>
			</div>
		</div>
		<hr>-->
		<div class="link-group">
			<h4>Related Links</h4>
			<a href="http://www.flyertalk.com/forum/citi-thankyou-rewards/1735992-citi-prestige-change-concierge-operator-ten-aspire.html" target="_blank">Citi Prestige - change in concierge operator (Ten to Aspire)</a>
			<br>
			<a href="http://www.flyertalk.com/forum/citi-thankyou-rewards/1184201-typ-flight-redemptions-prestige-0-0133-0-016-pt-premier-0-0125-pt.html" target="_blank">TYP flight redemptions: Prestige $0.0133 or $0.016/pt., Premier $0.0125/pt.</a>
			<br>
			<a href="http://www.flyertalk.com/forum/citi-thankyou-rewards/1632562-citi-aa-platinum-gold-business-cards.html" target="_blank"> Citi AA Platinum, Gold and Business cards</a>
			<br>
			<a href="http://www.flyertalk.com/forum/alaska-airlines-mileage-plan/1462859-alaska-airlines-visa.html" target="_blank">Alaska Airlines Visa</a>
			<br>
			<a href="http://www.flyertalk.com/forum/intercontinental-hotels-ihg-rewards-club-intercontinental-ambassador/1731896-ihg-accelerate-2016-promotion.html" target="_blank">Citi Prestige Priority Pass Select membership.</a>
			<br>
			<a href="http://www.flyertalk.com/forum/luxury-hotels/1704812-luxury-hotels-japan.html" target="_blank">Luxury Hotels of Japan</a>
			<br>
			<a href="http://www.flyertalk.com/forum/citi-thankyou-rewards/1612811-changes-citi-card-insurance-11-23-14-5-15-2016-a.html" target="_blank">Changes to Citi card insurance 11/23/14 and 5/15/2016.</a>

		</div>
	</div>

	<div class="footer-bottom">
		<p>Copyright © 2016 Developed by Zhirun Tian, Chenlei Zhao, Siying Zhang| Template by <a href="http://w3layouts.com">W3layouts</a></p>					
	</div>
	</div>
</body>

</html>