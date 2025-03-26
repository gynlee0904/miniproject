<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<form id="frm">
<main>
	<section class="sub">
		<c:choose>
			<c:when test="${searchPw==0}">
			<div class="notmember">
				<ul>
					<li>${msg}</li>
				</ul>
			</div>
			</c:when>
			<c:otherwise>
			<div>
				<ul>
					<li>회원가입 정보에 따른 패스워드 변경</li>
				</ul>
			</div>
			<div class="text1 repass">
				<div>
					<input type="password" placeholder="최소 10 ~ 16자 (영문,숫자,특수 문자 조합)로 입력해주세요." class="passin" autocomplete="none" name="m_pass">
				</div>
				<div>
					<input type="password" placeholder="동일한 비밀번호를 입력하세요" class="passin" autocomplete="none" id="m_pass_ck">
				</div>
			</div>
			<div>
				<input type="button" value="비밀번호 변경" class="search_submit" onclick="modify_pass();">
			</div>
			</c:otherwise>
		</c:choose>
		<input type="hidden" name="m_email" value="${memail}">
		<input type="hidden" name="m_phone" value="${mphone}">
	</section>
</main>
</form>
<script src="../js/member/info_search.js?v=1"></script>