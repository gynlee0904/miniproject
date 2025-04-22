<%@page import="java.util.logging.SimpleFormatter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Date date_top = new Date();
%>
<header>
	<div class="top">
		<ul class="tops_ul">
			<li onclick="go_main();"><img src="../logo/e_click_logo.png"></li>
			
			<c:if test="${aid!=null || aname!=null}">
			<li class="logins" onmouseleave="myinfo_menu(2)">
				
				<span title="회원정보" onclick="myinfo_menu(1)"> 
				<img src="../ico/login.svg">
					<ul class="login_info" id="login_info" style="display: none;">
						<li>${aname} 관리자님</li>
						<li><a href="">[마이페이지]</a></li>
						<li><a href="../admin/logout.do">[로그아웃]</a></li>
					</ul>
				</span>
				
			</li>
			</c:if>
		</ul>
	</div>
</header>
<!--메뉴끝-->
<script src="../js/admin/admin_top.js?v=<%=date_top%>"></script>