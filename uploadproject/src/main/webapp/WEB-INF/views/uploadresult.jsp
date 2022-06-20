<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>파일이 업로드되었습니다.</h3>
<div>${text}</div>
<!-- 이미지나 영상을 보여줄 때 절대 경로로 가져오지 않고 controller 매핑을 해서 가져오도록 수정 -->
<img src="/fileview/${fileName}" />
</body>
</html>