<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form id="frm">
<main>
	<section class="sub">
		<p>모델 하우스 사전 방문예약</p>
		<div>
			<span class="list_title"> 
				<span style="color: blue;">분양정보</span>
				<span style="color: red;">${week_one.apt_name}</span>
				
				<input type="hidden" name="aidx" value="${week_one.aidx}">
			</span>
			<ul class="sub_ul">
				<li>방문일시</li>
				<li><input type="date" class="sel_input" name="visit_date"></li>
				<li>방문시간</li>
				<li>
					<select class="sel_input2" name="visit_time">
						<option value="">방문시간선택</option>
						<option value="09:00">09:00</option>
						<option value="11:00">11:00</option>
						<option value="13:00">13:00</option>
						<option value="15:00">15:00</option>
						<option value="17:00">17:00</option>
					</select> * 해당 시간에 맞춰서 방문해 주셔야 합니다.
				</li>
				<li>방문자명</li>
				<li><input type="text" class="sel_input" readonly name="m_name" value="${mname}"></li>
				<li>방문인원</li>
				<li>
					<label><input type="radio" class="sel_check" checked name="visit_in" value="1명" checked> 1명</label> 
					<label><input type="radio" class="sel_check" name="visit_in" value="2명"> 2명</label> 
					※ 방문인원은 최대 2명까지 입니다.</li>
				<li>연락처</li>
				<li><input type="text" class="sel_input" readonly name="m_phone" value="${mphone}"></li>
			</ul>
		</div>
		<div>
			<input type="button" value="방문 예약등록" onclick="rsv_complete();">
		</div>
	</section>
</main>
</form>
<script> var id = '${week_one.aidx}';</script>
<script src="../js/reservation/reservation.js?v=2"></script>