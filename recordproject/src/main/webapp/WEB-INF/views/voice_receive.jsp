<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function(){
	$("#play").click(function(){
		let xhr = new XMLHttpRequest();
		xhr.responseType = "blob";
		xhr.onload = function(){
			var audioURL = URL.createObjectURL(this.response);
			var audio = new Audio();
			audio.src = audioURL;
			audio.play();
		}
		xhr.open("POST", "voice");
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("fileId="+$("#fid").val());
	});
	
});
</script>
<body>
<input type="text" id="fid">
<button id="play">재생</button>
</body>
</html>