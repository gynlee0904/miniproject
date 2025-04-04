<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Date date_es = new Date();
	SimpleDateFormat sf_es = new SimpleDateFormat("yyMMdd");
	String today_es = sf_es.format(date_es);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 찾기</title>
<link rel="stylesheet" type="text/css" href="../css/index.css?v=<%=today_es%>">
<link rel="stylesheet" type="text/css" href="../css/member/email_search.css?v=<%=today_es%>">
</head>
<body>
<!-- 헤더,메뉴부분 -->
<%@ include file="../common/top.jsp" %>

<!-- 메인부분 -->
<%@ include file="./email_search_view.jsp" %>

<!-- 푸터부분 -->
<%@ include file="../common/copyright.jsp" %>
</body>
</html>