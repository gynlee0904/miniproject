<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!--최상단-->
<header>
	<div class="top_banner"></div>
</header>
<!--최상단끝-->
<!--메뉴-->
<nav>
	<div class="menus">
		<ul class="menus_ul">
			<li><a href="../../realty/index.do" class="home"><img src="../../realty/logo/e_click_logo.png"></a></li>
			<li><a href="#">일반매물</a></li>
			<li><a href="#">추천매물</a></li>
			<li><a href="#">중계의뢰</a></li>
			<li><a href="#">상담신청</a></li>
			<li><a href="#">업체의뢰</a></li>
			<li><a href="#">의뢰현황</a></li>
			<li class="logins">
			<c:choose>
				<c:when test="${se!=null}">
					<span> ${se.mname} 님 환영합니다. <a href="">[로그아웃]</a> </span> 
				</c:when>
				<c:when test="${se==null}">
					<span title="로그인"><a href="../../realty/member/login.do"><img src="../../realty/ico/login.svg"></a></span> 
		        	<span title="회원가입"><a href="../../realty/member/member_join.do"><img src="../../realty/ico/membership.svg"></a></span>
				</c:when>
				
			</c:choose>
				
			</li>
		</ul>
	</div>
</nav>
<!--메뉴끝-->
