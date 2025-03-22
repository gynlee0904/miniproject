<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main>
<form id="frm" method="post" action="#">
	<aside class="login_pg">
		<p>이메일로 시작하기</p>
		<div>
			<input type="text" name="lemail" placeholder="이메일 주소">
		</div>
		<div>
			<input type="password" name="lpass" placeholder="비밀번호">
		</div>
		<div>
			<input type="button" value="로그인" onclick="logincheck();">
		</div>
		<div>
			<span>이메일 찾기</span> 
			<span>비밀번호 찾기</span>
		</div>
	</aside>
</form>
</main>

<script src="./js/member/login.js?v=1"></script>