<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
	<div class="weektails">
		<p>분양정보</p>
		<div id="weektails">
			<p>${week_one.apt_name}</p>
			<ul>
				<li>종류</li>
				<li>${week_one.apt_type} | ${week_one.rental_type}</li>
				<li>주소</li>
				<li>${week_one.apt_addr}</li>
				<li>규모</li>
				<li>총 ${week_one.apt_gen}세대 | 총 ${week_one.apt_ea}개동</li>
				<li>시기</li>
				<li>${week_one.sale_date} | ${week_one.move_in_date}</li>
				<li>난방구조</li>
				<li>${week_one.apt_strc}</li>
				<li>건설사</li>
				<li>${week_one.apt_company}</li>
				<li>사진정보</li>
				<li><img src="../room/${week_one.apt_fileRenm}"></li>
			</ul>
		</div>
		
		<c:choose>
			<c:when test="${rsv_ck.aidx==week_one.aidx && rsv_ck.m_phone==sessionScope.mphone && rsv_ck.reserve_yn == 'Y'}">
			<div>
				<button class="btn_close">방문예약완료</button>
			</div>
			</c:when>
			<c:otherwise>
			<div>
				<button class="btn_css" onclick="reservation_go(${week_one.aidx},'${week_one.apt_name}');">방문예약</button>
			</div>
			</c:otherwise>
		</c:choose>
		
		
	</div>
</main>

<script src="../js/product/week.js?v=4"></script>