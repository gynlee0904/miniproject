<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!--금주 분양 매물 정보 시작-->
<section>
	<div class="weekdays">
		<p>금주분양 매물정보 <br>
			<em>이번주 신규 매물정보!${wk_allList[aidx]}</em>
		</p>
		<div class="week_estates" >
			<ul id="ul_list">
				<c:forEach var="wk" items="${wk_allList}">
				<li class="p_list" onclick="product_views(${wk.aidx},'${wk.apt_name}');">
					<span>매매</span>
					<div>${wk.apt_name}</div>
					<aside>${wk.apt_addr}</aside> 
					<span>${wk.apt_type} | ${wk.rental_type}</span> 
					<label>${wk.sale_date} | ${wk.move_in_date}</label>
					<div>
						<img src="./room/${wk.apt_fileRenm}">
					</div>
				</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</section>
<!--금주 분양 매물 정보 끝-->

<script src="../js/product/week.js?v=3"></script>