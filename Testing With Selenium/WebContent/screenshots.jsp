<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Selenium Screenshots</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	var topBottom = ["Top", "Middle", "Bottom"];
	var leftRight = ["Left", "Center", "Right"];
	
	$(document).ready(function(){
		if($(window).width() <= 700){
			for(var i = 1; i <= topBottom.length; i++){
				$("header + div:nth-child(2) > div:nth-child("+i+")").text(topBottom[i-1]);
			}
		}else{
			for(var i = 1; i <= leftRight.length; i++){
				$("header + div:nth-child(2) > div:nth-child(+ i +)").text(leftRight[i-1]);
			}
		}
	});
	$(window).resize(function(){
		if($(window).width() <= 700){
			for (var i = 1; i <= topBottom.length; i++){
				$("header + div:nth-child(2) > div:nth-child(+ i + )").text(topBottom[i-1]);
			}
		}else{
			for(var i = 1; i <= leftRight.length; i++){
				$("header + div:nth-child(2) > div:nth-child("+ i +")").text(leftRight[i-1]);
			}
		}
	});
</script>
<style>
	header + div:nth-child(2) {
		width: 100%;
		text-align: center;
	}
	header + div:nth-child(2) > div {
		color: #c00;
		display: inline-block;
		width: 25%;
		text-align: center;
		padding: 25px;
		border: 1px solid #aaa;
	}
	@media screen and (max-width: 700px){
		header, footer{
			text-align: center;
		}
		header + div:nth-child(2) > div {
			color: green;
			display: block;
			position: relative;
			left: 50%;
			transform: translate(-50%);
			width: 75%;
		}
	}
</style>
</head>
<body>
	<header>
		<h1>Selenium Screenshot Demonstration Page</h1>
	</header>
	<div>
		<div>Left</div>
		<div>Center</div>
		<div>Right</div>
	</div>
	<%@ include file="footer.html" %>
</body>
</html>