<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Date date_adm = new Date();
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>온라인 부동산 중개-관리자 페이지</title>
  <link rel="stylesheet" type="text/css" href="../css/admin/admin_top.css?v=4">
   <link rel="stylesheet" type="text/css" href="../css/admin/admin_login.css?v=3">
</head>
<body>
<!-- 헤더,메뉴부분 -->
<%@ include file="./admin_top.jsp" %>

<!-- 메인부분 -->
<main>
	<!-- 로그인화면 -->
	<%@ include file="./admin_login_view.jsp" %>	
</main>

<!-- 푸터부분 -->
<%@ include file="../common/copyright.jsp" %>
</body>
<script src="../js/admin/admin.js?v=1"></script>
</html>