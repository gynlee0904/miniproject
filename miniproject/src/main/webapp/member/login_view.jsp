<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Date date_lg = new Date();
	SimpleDateFormat sf_lg = new SimpleDateFormat("yyMMdd");
	String today_lg = sf_lg.format(date_lg);
%>
<main>
<form id="frm">
	<aside class="login_pg">
		<p>이메일로 시작하기</p>
		<div>
			<input type="text" name="m_email" placeholder="이메일 주소">
		</div>
		<div>
			<input type="password" name="m_pass" placeholder="비밀번호">
		</div>
		<div>
			<input type="button" value="로그인" onclick="login_go();">
		</div>
		<div>
			<input type="button" value="카카오로그인" class="kakao_btn">
		</div>
		<div>
			<span ><a id="memberjoin" href="./member_join.do">회원가입</a></span>
			<span class="find"><a id="idsearch">이메일 찾기</a></span> 
			<span class="find"><a id="pwsearch">비밀번호 찾기</a></span>
		</div>
	</aside>
</form>
</main>

<script src="../js/member/login.js?v=<%=today_lg%>"></script>