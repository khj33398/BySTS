<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: 0 auto;
	width: 552px;
}

.container {
	/* padding:10px; 
	border: 1px solid;*/
}

.header {
	height: 40px;
}

.row {
	height: 30px;
}

.title {
	font-weight: bold;
	background-color: lightgrey;
}

.colume {
	padding: 5px;
	width: 150px;
	float: left;
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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function(){
	function queryAccs(){
		$.ajax({
			type:"GET",
			async:false,
			url:"all",
			dataType:"json",
			success:function(data, textStatus){
				$.each(data, function(i, v){ 
					$("#container").append('<div class="row"><div class="colume">'+v.id+'</div><div class="colume">'
							+v.name+'</div><div class="colume">'+v.balance+'</div></div>')
				})
			}
		});
	};
	queryAccs();
});
</script>
</head>
<body>

	<center>
		<form>
			<div class="header">
				<h3>전체 계좌 조회</h3>
			</div>
			<div class="container" id="container">
				<div class="row">
					<div class="title colume">계좌번호</div>
					<div class="title colume">이름</div>
					<div class="title colume">잔액</div>
				</div>
				
				<!-- 
				<c:forEach items="${accs}" var="acc">
				<div class = "row">
					<div class="colume">${acc.id}</div>
					<div class="colume">${acc.name}</div>
					<div class="colume">${acc.balance}</div>
				</div>
				</c:forEach>
				-->
			</div>
		</form>
	</center>
</body>
</html>