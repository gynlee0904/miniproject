<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="../../realty/css/index.css?v=1">
  <link rel="stylesheet" type="text/css" href="../../realty/css/member/member_join.css?v=1">
<style>
.box {
   width: 800px;
   height: 300px;
   border: 1px solid black;
   overflow: auto;
}
</style>
<title>회원가입</title>
</head>
<body>
<!-- 헤더,메뉴부분 -->
<%@ include file="../../realty/common/top.jsp" %>

<!-- 메인부분 -->
<%@ include file="./member_join_view.jsp" %>

<!-- 푸터부분 -->
<%@ include file="../../realty/common/copyright.jsp" %>
</body>
</html>