<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<main>
	<section class="sub">
		<p>추천분양 정보 게시판</p>
		<div class="boards">이번주 신규 매물정보를 한눈에 확인하실 수 있습니다.</div>
		<div class="info_board">
			<ul>
				<li>NO</li>
				<li>제목</li>
				<li>글쓴이</li>
				<li>조회수</li>
				<li>등록일</li>
			</ul>
			
			<c:if test="${fn:length(md_allList)==0}">
			<ul>
				<li class="nodata">등록된 게시물이 없습니다.</li>
			</ul>
			</c:if>
			
			<c:set var="no" value="${list_total-clickPage}" />
			<c:forEach var="md_list" items="${md_allList}" varStatus="idx">
			<ul class="data_view">
				<li>${no-idx.index}</li>
				
				<c:set var="title" value="${md_list.md_title}" />
				<c:set var="subject" value="${fn:length(title)}" />
				<c:set var="subject2" value="${fn:replace(title,'<br>','')}" />
				<c:set var="dot" value="..." />
				<li style="text-align: left;" onclick="go_md_detail('${md_list.midx}');">
					<c:choose>
						<c:when test="${subject > 30}">${fn:substring(subject2,0,30)}${dot}</c:when>
						<c:otherwise>${subject2}</c:otherwise>
					</c:choose>
				</li>
							
				<li>${md_list.md_writer}</li>
				<li>${md_list.md_view}</li>
				<li>${fn:substring(md_list.insert_date,0,10)}</li>
			</ul>
			</c:forEach>
			<form id="frm">
			<input type="hidden" name="midx" value="">
			</form>
		</div>
		
		<!-- 페이징 -->
		<c:set var="pgidx" value="${list_total / 10 + (1-(list_total/10)%1)%1}" />
		
		<div class="info_pageing">
			<ol>
			<c:forEach var="no" begin="1" end="${pgidx}"> 
				<li onclick="go_page('${keyword}','${no}')">${no}</li>
			</c:forEach>
			</ol>
		</div>
		
		<!-- 검색 -->
		<form id="sch_frm">
		<div class="info_search">
			<input type="text" class="search_text" placeholder="검색어를 입력하세요" name="keyword" value="${keyword}">
			<input type="button" value="검색" class="search_btn" onclick="go_search();">
		</div>
		</form> 
	</section>
</main>

<script src="../js/board/md_board.js?v=3"></script>