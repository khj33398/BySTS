<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function(){
	$('#file').change(function(event){
		var reader = new FileReader();
		reader.onload = function(e){
			$('#rep').attr('src', e.target.result);
		};
		reader.readAsDataURL(event.target.files[0]);
	});
});

</script>
</head>
<body>
<form action="fileupload" method="post" enctype="multipart/form-data" accept="image/*">
	<img id="rep" src="" width="100px" height="100px" /><br/>
	<input type="file" name="file" id="file"><br/>
	<input type="text" name="text"><br/>
	<input type="submit" value="업로드">
</form>
</body>
</html>