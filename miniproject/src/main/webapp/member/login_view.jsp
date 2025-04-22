<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Date login = new Date();
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
			<input type="button" value="카카오로그인" class="kakao_btn" onclick="kakao_login()">
		</div>
		<div>
			<span><a id="memberjoin" href="./member_join.do">회원가입</a></span>
			<span class="find"><a href="./email_search.do" id="idsearch">이메일 찾기</a></span> 
			<span class="find"><a href="./passwd_search.do">비밀번호 찾기</a></span>
		</div>
	</aside>
	<input type="hidden" name="m_type" value="WEB">
	<input type="hidden" name="kakao_id" value="">
	<input type="hidden" name="kakao_nm" value="">
</form>
<p id="token-result"></p>
</main>

<script src="https://t1.kakaocdn.net/kakao_js_sdk/v1/kakao.js"></script>
<script src="../js/member/login.js?v=<%=login%>"></script>
