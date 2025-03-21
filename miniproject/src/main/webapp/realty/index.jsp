<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>온라인 부동산 중개</title>
  <link rel="stylesheet" type="text/css" href="./css/index.css?v=7">
</head>
<body>
<!-- 헤더,메뉴부분 -->
<%@ include file="./top.jsp" %>

<!-- 메인부분 -->
<main>
	<!-- 카테고리 및 배너 -->
	<%@ include file="./banner.jsp" %>
	<!-- 퀵메뉴 -->
	<%@ include file="./quickmenu.jsp" %>
	<!-- 금주 분양 매물 정보 -->
	<%@ include file="./weekinfo.jsp" %>
	<!-- 추천 분양 정보 -->
	<%@ include file="./mdchoice.jsp" %>
</main>
<!-- 푸터부분 -->
<%@ include file="./copyright.jsp" %>
</body>
</html>