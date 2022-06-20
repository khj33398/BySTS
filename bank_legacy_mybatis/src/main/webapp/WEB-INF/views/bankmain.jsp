<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        * {margin: 0 auto;}
        #menu {
            background-color: lightcyan;
        }
        .title {
            height: 60px;
            background-color:navajowhite;
            border-color:navajowhite;
        }

    </style>
</head>
<body>
   <table style="width:800px;height: 400px;">
        <thead>
            <tr class="title"><th colspan="2">메타은행</th></tr>
        </thead>
        <tbody>
            <tr>
                <th id="menu">
                    <a href="login" target="content">로그인</a><br><br>
                    <a href="join" target="content">회원가입</a><br><br>
                	<a href="makeaccount" target="content">계좌개설</a><br><br>
                    <a href="deposit" target="content">입금</a><br><br>
                    <a href="withdraw" target="content">출금</a><br><br>
                    <a href="accountinfo" target="content">계좌조회</a><br><br>
                    <a href="allaccountinfo" target="content">전체 계좌 조회</a>
                </th>
                <td  style="width:70%;" colspan="3"><iframe style="width:100%;height:100%;align-content: center;" name="content"></iframe></td>
            </tr>
        </tbody>
    </table>
</body>
</html>