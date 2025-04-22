<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main>
<form id="frm" onsubmit="adm_login();">
	<aside class="login_pg" >
		<p>관리자 로그인</p>
		<div>
			<input type="text" name="aid" placeholder="관리자 아이디">
		</div>
		<div>
			<input type="password" name="apass" placeholder="비밀번호">
		</div>
		<div>
			<input type="submit" value="로그인" >
		</div>
		<div>
			<span class="find"><a id="idsearch">아이디 찾기</a></span> 
			<span class="find"><a >비밀번호 찾기</a></span>
		</div>
	</aside>
</form>
</main>

