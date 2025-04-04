<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Date date_wkd = new Date();
	SimpleDateFormat sf_wkd = new SimpleDateFormat("yyMMdd");
	String today_wkd = sf_wkd.format(date_wkd);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>금주 분양 매물 정보</title>
<link rel="stylesheet" type="text/css" href="../css/index.css?v=<%=today_wkd%>">
<link rel="stylesheet" type="text/css" href="../css/product/week_tails.css?v=<%=today_wkd%>">
</head>
<body>
<!-- 헤더,메뉴부분 -->
<%@ include file="../common/top.jsp" %>

<!-- 메인부분 -->
<%@ include file="./week_tails_view.jsp" %>

<!-- 푸터부분 -->
<%@ include file="../common/copyright.jsp" %>
</body>
</html>