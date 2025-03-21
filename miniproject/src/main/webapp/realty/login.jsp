<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="./css/member/login.css?v=2">
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
<%@ include file="./top.jsp" %>

<!-- 메인부분 -->
<%@ include file="./login_view.jsp" %>

<!-- 푸터부분 -->
<%@ include file="./copyright.jsp" %>
</body>
</html>