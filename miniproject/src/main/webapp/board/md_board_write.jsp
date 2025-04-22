<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천분양 정보 게시판</title>
<!-- <link rel="stylesheet" type="text/css" href="../css/index.css?v=1"> -->
<link rel="stylesheet" type="text/css" href="../css/board/md_board_view.css?v=1">
<link rel="stylesheet" type="text/css" href="../css/admin/admin_top.css?v=1">
<link rel="stylesheet" type="text/css" href="../css/admin/admin_main.css?v=6">
<script src="./ckeditor/ckeditor.js"></script>
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
<%@ include file="../admin/admin_top.jsp" %>
<%@ include file="../admin/admin_nav.jsp" %>

<!-- 메인부분 -->
<%@ include file="./md_board_write_view.jsp" %>

<!-- 푸터부분 -->
<%@ include file="../common/copyright.jsp" %>
</body>
</html>