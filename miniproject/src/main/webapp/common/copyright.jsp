<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 카피라이터 -->
<footer>
	<div class="copyright">
		<ol>
			<li><img src="../logo/e_click_logo.png" class="logos"></li>
			<li>
				<ul>
					<li>회사소개</li>
					<li>이용약관</li>
					<li>위치기반서비스 약관</li>
					<li>제휴문의</li>
					<li>개인정보처리방침</li>
					<li>신고센터</li>
				</ul>
			</li>
			<li>
				<ul>
					<li>저작권규약</li>
					<li>책임한계 및 법적고지</li>
					<li>이메일 무단수집거부</li>
					<li>고객센터문의</li>
					<li onclick="location.href='/admin/admin.do';"></li>
					<li></li>
				</ul>
			</li>
			<li>
			<c:forEach var="info" items="${web_info}">
				<ul>
					<li>${info.corp_name} | 대표 : ${info.corp_ceo}</li>
					<li>${info.corp_addr}</li>
					<li>사업자번호 : ${info.corp_bno} | 통신판매업 : ${info.corp_type}</li>
					<li>정보보호책임자 : ${info.corp_manager}</li>
					<li>영업문의 : ${info.corp_Inquiry}</li>
					<li>팩스번호 : ${info.corp_fax}</li>
				</ul>
			</c:forEach>
			</li>
		</ol>
	</div>
</footer>