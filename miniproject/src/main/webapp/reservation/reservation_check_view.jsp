<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main>
	<section class="sub">
		<p>모델 하우스 사전 방문예약 확인</p>
		<div>
			<span class="list_title"> 
				<span style="color: blue;">분양정보</span>
				<span style="color: red;">${rsv_ck.get("an")}</span>
			</span>
			<ul class="sub_ul">
				<li>방문일시</li>
				<li><input type="text" class="sel_input" disabled value="${rsv_ck.visit_date}"></li>
				<li>방문시간</li>
				<li>
					<input class="sel_input2" disabled value="${rsv_ck.visit_time}">
					* 해당 시간에 맞춰서 방문해 주셔야 합니다.
				</li>
				<li>방문자명</li>
				<li><input type="text" class="sel_input" disabled value="${rsv_ck.m_name}"></li>
				<li>방문인원</li>
				<li>${rsv_ck.visit_in} ※ 방문인원은 최대 2명까지 입니다.</li>
				<li>연락처</li>
				<li><input type="text" class="sel_input" disabled value="${rsv_ck.m_phone}"></li>
			</ul>
		</div>
		<div>
			<input type="button" value="메인페이지로 이동" onclick="go_main();">
		</div>
	</section>
</main>
<script src="../js/top.js?v=3"></script>