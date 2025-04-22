<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<main class="dashboard">
	<section class="left_section">

		<!-- Left side columns -->
		<article class="top_side">
			<div class="card_body">
				<div class="card_title">
					<h5 id="card_title"> 매물 등록수 <span class="date">| Today</span> </h5>
					<div class="dot_icon" onmouseleave="cardinfo_menu('card_menu',2)">
						<img src="../ico/three-dots.svg" onclick="cardinfo_menu('card_menu',1)">
						<ul class="card_menu" id="card_menu" style="display: none;">
							<li><a href="javascript:dailyProduct()" >Today</a></li>
							<li><a href="javascript:weeklyProduct()">This Week</a></li>
						</ul>
					</div>
				</div>

				<div class="card_main">
					<div class="card_icon">
						<img class="card_icon2" src="../ico/building-add.svg">
					</div>
					<div class="card_content">
						<!-- 총 등록된 매물 수  -->
						<h6 id="allCnt">${today_total} 개</h6>

						<div>
							<!-- 오늘 등록된 매물 수  -->
							<span id="insert_pd_result"> 
							<c:set var="todayInsertProduct" value="${ today_total }" />
							<c:set var="yesterdayInsertProduct" value="${yesterday_total}" /> 
							<c:choose>
								<c:when test="${yesterdayInsertProduct != 0 }">
									<fmt:formatNumber value="${Math.abs(((todayInsertProduct - yesterdayInsertProduct) / yesterdayInsertProduct) * 100)}"
											maxFractionDigits="0" />% 
									
					    		</c:when>
					    		 <c:otherwise>
							        <c:out value="어제 등록된 추천매물 게시물은 0개입니다" />
							    </c:otherwise>
							</c:choose>
							</span> 
							<span id="change_result"> 
								<span> 
								<c:if test="${todayInsertProduct > yesterdayInsertProduct }">increase</c:if>
								<c:if test="${todayInsertProduct < yesterdayInsertProduct}">decrease</c:if>
								<c:if test="${todayInsertProduct == yesterdayInsertProduct}">same</c:if>
								</span>
							</span>
							
						</div>
					</div>
				</div>
			</div>



			<div class="card_body">
				<div class="card_title">
					<h5 id="card_title2"> 방문자수 <span class="date">| Today</span> </h5>
					<div class="dot_icon" onmouseleave="cardinfo_menu('card_menu2', 2)">
						<img src="../ico/three-dots.svg" onclick="cardinfo_menu('card_menu2', 1)">
						<ul class="card_menu" id="card_menu2" style="display: none;">
							<li><a href="javascript:void(0)" >Today</a></li>
							<li><a href="javascript:void(0)">This Week</a></li>
						</ul>
					</div>
				</div>
				<div class="card_main">
					<div class="card_icon">
						<img class="card_icon2" src="../ico/person-fill-add.svg">
					</div>
					<div class="card_content">
						<h6 id="allCnt2">50 개</h6>
						<div>
							<span id="insert_pd_result2"> 100% </span> 
							<span id="change_result2"> increase </span>
						</div>
					</div>
				</div>
			</div>


			<div class="card_body">
				<div class="card_title">
					<h5 id="card_title3"> 의뢰수 <span class="date">| Today</span> </h5>
					<div class="dot_icon" onmouseleave="cardinfo_menu('card_menu3',2)">
						<img src="../ico/three-dots.svg" onclick="cardinfo_menu('card_menu3',1)">
						<ul class="card_menu" id="card_menu3" style="display: none;">
							<li><a href="javascript:void(0)" >Today</a></li>
							<li><a href="javascript:void(0)">This Week</a></li>
						</ul>
					</div>
				</div>
				<div class="card_main">
					<div class="card_icon">
						<img class="card_icon2" src="../ico/feather.svg">
					</div>
					<div class="card_content">
						<h6 id="allCnt3">50 개</h6>
						<div>
							<!-- 오늘 등록된 매물 수  -->
							<span id="insert_pd_result3"> 200% </span> 
							<span id="change_result3"> decrease </span>
						</div>
					</div>
				</div>
			</div>
		</article>



		<article class="bottom_side">
			<!-- 컬럼챠트 -->
			<h5>날짜별 등록 및 방문예약 수</h5>
			<div class="chart_body">
				<div id="columnchart_material" ></div>
			</div>
		</article>
	</section>
	<!-- End Left side columns -->




	<!-- Right side columns -->
	<section class="right_section">
		<div class="donut donut1">
			<h5>상담접수_임대형태 문의비율</h5>
			<div class="donut_chart">
				<canvas id="donut_chart1"></canvas>
			</div>
		</div>



		<div class="donut">
			<h5 class="card-title">상담접수</h5>
			<div class="donut_chart">
				<canvas id="donut_chart2"></canvas>
			</div>
		</div>
	</section>
	<!-- End Right side columns -->
</main>
