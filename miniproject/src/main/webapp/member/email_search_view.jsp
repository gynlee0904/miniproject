<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form id="frm">
<main>
	<section class="sub">
		<div>
			<ul>
				<li id="sid">이메일 찾기</li>
				<li id="spw">비밀번호 찾기</li>
			</ul>
		</div>
		<div class="text1">
			<div>
				<input type="text" placeholder="이름을 입력하세요" name="m_name">
			</div>
			<div>
				<input type="text" placeholder="휴대폰 번호는 - 빼고 숫자만 입력하세요" maxlength="11" name="m_phone">
			</div>
		</div>
		<div>
			<input type="button" value="이메일 찾기" onclick="search_eml();">
		</div>
	</section>
</main>
</form>
<script src="../js/member/info_search.js?v=2"></script>