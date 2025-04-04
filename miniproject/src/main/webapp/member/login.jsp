<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Date date_lgi = new Date();
	SimpleDateFormat sf_lgi = new SimpleDateFormat("yyMMdd");
	String today_lgi = sf_lgi.format(date_lgi);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="../css/index.css?v=<%=today_lgi%>">
<link rel="stylesheet" type="text/css" href="../css/member/login.css?v=<%=today_lgi%>">
<style>
.box {
   width: 800px;
   height: 300px;
   border: 1px solid black;
   overflow: auto;
}

</style>
</head>
<body>
<!-- 헤더,메뉴부분 -->
<%@ include file="../common/top.jsp" %>

<!-- 메인부분 -->
<%@ include file="./login_view.jsp" %>

<!-- 푸터부분 -->
<%@ include file="../common/copyright.jsp" %>
</body>
</html>