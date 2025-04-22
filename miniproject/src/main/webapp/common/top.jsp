<%@page import="java.util.logging.SimpleFormatter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Date date_top = new Date();
%>
<!--최상단-->
<header>
	<div class="top_banner"></div>
</header>
<!--최상단끝-->
<!--메뉴-->
<nav>
	<div class="menus">
		<ul class="menus_ul">
			<li onclick="go_main();"><img src="../logo/e_click_logo.png"></li>
			<li>일반매물</li>
			<li onclick="go_rcm_pd();">추천매물</li>
			<li>중계의뢰</li>
			<li onclick="go_counsel();">상담신청</li>
			<li>업체의뢰</li>
			<li onclick="go_write();">의뢰현황</li>
			<li class="logins" onmouseleave="myinfo_menu(2)">
				<span title="회원정보" onclick="myinfo_menu(1)"> 
				<img src="../ico/login.svg">
					<ul class="login_info" id="login_info" style="display: none;">
						<c:choose>
							<c:when test="${mname==null || mid==null}">
							<li><a href="../member/login.do">로그인</a> / <a href="../member/member_join.do">회원가입</a></li>
							</c:when>
							
							<c:otherwise>
							<li>${mname}님 <a href="javascript:member_logout()">[로그아웃]</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</span> 
				<span title="모델 하우스 사전예약 리스트" onclick="reserve_page()">
				<img src="../ico/reserve_list.svg"></span>
			</li>
		</ul>
	</div>
</nav>
<!--메뉴끝-->
<script src="https://t1.kakaocdn.net/kakao_js_sdk/v1/kakao.js"></script>
<script src="../js/top.js?v=<%=date_top%>"></script>