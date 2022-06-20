<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script	src="https://cdn.ckeditor.com/ckeditor5/32.0.0/classic/ckeditor.js"></script>
<script>
$(function(){
	ClassicEditor.create(document.querySelector("#editor"))
	.then(editor => {
		editor.setData('${content}')
	})
	.catch((error) => {
		console.error(error);
	})
});
</script>
</head>
<body>
  
<h3>결과 화면</h3>
<form action="/write" method="post">
<div>제목<input name="title" id="title" size="80" value='${title }'></div><br>
<div id="editor"></div><br>
</form>
</body>
</html>