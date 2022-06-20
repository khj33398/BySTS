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
	const record=document.getElementById("record"); //const record = $("#record")
	const stop=document.getElementById("stop");
	
	if(navigator.mediaDevices){
		console.log("getUserMedia supported.")
		const constraints = {audio:true};
		let chunks = [];
		navigator.mediaDevices.getUserMedia(constraints).then(stream => {
			const mediaRecorder = new MediaRecorder(stream);
			record.onclick = () => {
				chunks = [];
				mediaRecorder.start();
				record.style.background="red";
				record.style.color="black";
			}
			stop.onclick = () => {
				mediaRecorder.stop();
				record.style.background="";
				record.style.color="";	
			}
			mediaRecorder.ondataavailable = (e) => {
				chunks.push(e.data);
			}
			mediaRecorder.onstop = (e) => {
				const blob = new Blob(chunks, {
					'type':'audio/ogg codes=opus'
				});
				let formdata = new FormData();
				formdata.append("data", blob);
				let xhr = new XMLHttpRequest();
				xhr.onload = () => {
					console.log(xhr.status);
					if(xhr.status===200){
						alert(xhr.response);
					}
				}
				xhr.open("POST","/dbupload", true);
				xhr.send(formdata);
			}
		}).catch(err => {
			console.log("Err : "+err)
		});
	}
});
</script>
<body>
<button id="record">녹음</button>
<button id="stop">정지</button>
</body>
</html>