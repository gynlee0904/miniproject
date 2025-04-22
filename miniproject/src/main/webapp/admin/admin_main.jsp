<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
Date date_main = new Date();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 페이지-메인</title>
<link rel="stylesheet" type="text/css" href="../css/admin/admin_top.css?v=<%=date_main%>">
<link rel="stylesheet" type="text/css" href="../css/admin/admin_main.css?v=10">
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.8/dist/chart.umd.min.js"></script>
   
</head>
<body>
	<!-- 헤더,메뉴부분 -->
	<%@ include file="./admin_top.jsp"%>
	<%@ include file="./admin_nav.jsp"%>

	<!-- 메인부분 -->
	<%@ include file="./admin_main_view.jsp"%>
	

	<!-- 푸터부분 -->
	<%@ include file="../common/copyright.jsp"%>

</body>
<script src="../js/admin/chart.js?v=<%=date_main%>"></script>

</html>