<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Date date_mdb = new Date();
	SimpleDateFormat sf_mdb = new SimpleDateFormat("yyMMdd");
	String today_mdb = sf_mdb.format(date_mdb);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천분양 정보 게시판</title>
<link rel="stylesheet" type="text/css" href="../css/index.css?v=<%=today_mdb%>">
<link rel="stylesheet" type="text/css" href="../css/board/md_board.css?v=<%=today_mdb+1%>">
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
<%@ include file="./md_board_list.jsp" %>

<!-- 푸터부분 -->
<%@ include file="../common/copyright.jsp" %>
</body>
</html>