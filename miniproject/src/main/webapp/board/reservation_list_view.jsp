<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<main>
	<section class="sub">
		<p>모델 하우스 방문 예약 리스트</p>
		<div class="boards">모델 하우스 방문 예약한 정보를 한눈에 확인 하실 수 있습니다.</div>
		<div class="info_board">
			<ul>
				<li>NO</li>
				<li>아파트명</li>
				<li>방문일자</li>
				<li>방문시간</li>
				<li>인원수</li>
				<li>취소</li>
			</ul>
			
			<c:if test="${fn:length(rsv_myList)==0}">
<!-- 			<ul style="display: block;"> -->
			<ul>
				<li class="nodata">등록된 방문 예약이 없습니다.</li>
			</ul>
			</c:if>
			
			<c:set var="no" value="${list_total}" />
			<c:forEach var="rsv_list" items="${rsv_myList}" varStatus="idx">
			<ul class="data_view">
				<li>${no - idx.count + 1}</li>
				<li style="text-align: left;" onclick="go_details('${rsv_list.aidx}','${rsv_list.aptnm}');">${rsv_list.aptnm}</li>
				<li>${rsv_list.visit_date}</li>
				<li>${rsv_list.visit_time}</li>
				<li>${rsv_list.visit_in}</li>
				<li><input type="button" value="취소" class="cancel_btn" onclick="rsv_cancel('${rsv_list.ridx}','${mphone}');"></li>
			</ul>
			</c:forEach>
			<form id="frm">
			<input type="hidden" name="ridx" value="">
			<input type="hidden" name="pn" value="">
			</form>
		</div>
	</section>
</main>
<script src="../js/board/rsv_board.js?v=2"></script>