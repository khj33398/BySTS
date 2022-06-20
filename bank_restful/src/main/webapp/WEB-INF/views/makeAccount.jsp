<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: 0 auto;
	width: 400px;
}

.container {
	padding: 10px;
	border: 1px solid;
}

.header {
	height: 40px;
}

.row {
	height: 30px;
}

.title {
	width: 70px;
	float: left;
	font-weight: bold;
}

.input {
	float: left;
}

input[type='submit'] {
	font-weight: bold;
	width: 120px;
	background-color: lightgrey;
}
</style>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function(){
	$("#submit").click(function(){
		alert($("#form").serialize());
		//var id = $("#id").val();
		//var name = $("#name").val();
		//var balance = $("#money").val();
		$.ajax({
			type:"POST",
			url:"/makeaccount",
			//data:{"id":id, "name":name, "balance":balance},
			data:$("#form").serialize(),
			success:function(data, statusText){
				alert(JSON.stringify(data));
			},
			error:function(data, statusText){
				alert(JSON.stringify(data));
			}
		});
	});
	
	$("#exist").click(function(){
		var id = $("#id").val();
		$.ajax({
			type:"GET",
			url:"/idoverlap/"+id,
			success:function(data, statusText){
				alert(JSON.stringify(data));
			},
			error:function(data, statusText){
				alert("사용 불가능한 계좌입니다.");
			}
		});
	});
});
</script>
</head>
<body>
	<center>
		<form id="form">
			<div class="header">
				<h3>계좌개설</h3>
			</div>
			<div class="container">
				<div class="row">
					<div class="title">계좌번호</div>
					<div class="input">
						<input type="text" name="id" id='id'><button type="button" id="exist">중복</button>
					</div>
				</div>
				<div class="row">
					<div class="title">이름</div>
					<div class="input">
						<input type="text" name="name" id='name'>
					</div>
				</div>
				<div class="row">
					<div class="title">입금액</div>
					<div class="input">
						<input type="text" name="money" id='money'>
					</div>
				</div>
				<div class="button">
					<!--  <input type="submit" value="개설">	-->
					<input type="button" id="submit" value="개설">
				</div>
			</div>
		</form>
	</center>
</body>
</html>