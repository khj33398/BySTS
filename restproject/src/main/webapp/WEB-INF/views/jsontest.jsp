<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
//window load 후 실행되도록 함
$(function(){
	$("#checkJson1").click(function(){
		let article = {articleNo:"114", writer:"박지성", title:"안녕하세요", content:"상품소개 글입니다."}
		$.ajax({
			type:"POST",
			url:"/boards",
			contentType:"application/json; charset=utf-8",
			data:JSON.stringify(article),
			success:function(data, statusText){
				alert(data);
			},
			error:function(data, statusText){
				alert("에러 발생");
			}
		});
	});
	
	//조회
	$("#checkJson2").click(function(){
		$.ajax({
			type:"GET",
			url:"/boards/115",
			success:function(data, statusText){
				alert(data);
				alert(JSON.stringify(data));
			},
			error:function(data, statusText){
				alert("에러 발생");
			}
		});
	});
	
	//수정
	$("#checkJson3").click(function(){
		let article = {articleNo:"114", writer:"박지성", title:"날쌘돌이의 일상", content:"축구와 늘 함께합니다."}
		$.ajax({
			type:"PUT",
			url:"/boards/114",
			contentType:"application/json; charset=utf-8",
			data:JSON.stringify(article),
			success:function(data, statusText){
				console.log(data);
				alert(data);
			},
			error:function(data, statusText){
				alert("에러 발생");
			}
		});
	});
	
	//삭제
	$("#checkJson4").click(function(){
		$.ajax({
			type:"DELETE",
			url:"/boards/114",
			success:function(data, statusText){
				alert(data);
			},
			error:function(data, statusText){
				alert("에러 발생");
			}
		});
	});
});
</script>
</head>
<body>
	<input type="button" id="checkJson1" value="새글 쓰기">
	<br />
	<br />
	<input type="button" id="checkJson2" value="조회">
	<br />
	<br />
	<input type="button" id="checkJson3" value="수정">
	<br />
	<br />
	<input type="button" id="checkJson4" value="삭제">
	<br />
	<br />
</body>
</html>