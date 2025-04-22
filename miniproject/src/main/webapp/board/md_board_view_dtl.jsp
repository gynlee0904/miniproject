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
				<li>제&nbsp;&nbsp;&nbsp;목</li>
				
				<c:set var="title" value="${md_one.md_title}" />
				<c:set var="subject" value="${fn:length(title)}" />
				<c:set var="subject2" value="${fn:replace(title,'<br>','')}" />
				<c:set var="dot" value="..." />
				<li>
				<c:choose>
					<c:when test="${subject > 30}">${fn:substring(subject2,0,30)}${dot}</c:when>
					<c:otherwise>${subject2}</c:otherwise>
				</c:choose>
				</li>
				
				<li>글쓴이</li>
				<li> 관리자 </li>
				
				<li>등록일</li>
				<li>${fn:substring(md_one.insert_date,0,10)}</li>
				
				<li>조회수</li>
				<li>${md_one.md_view}</li>
				
				<li class="litext">내&nbsp;&nbsp;&nbsp;용</li>
				<li class="litext">
					<div class="textarea">
						<c:if test="${md_one.md_fileRenm != null}">
						<img src="../md_file/${md_one.md_fileRenm}" style="width:100%;" title="${md_one.md_filenm}">
						</c:if>
						${md_one.md_content}
					</div>
				</li>
			</ul>
		</div>
		<div class="board_btn">
			
			<div>
			<c:if test="${adminck == 'adm'}">
			<input type="button" value="수&nbsp;&nbsp;&nbsp;정" class="btns" onclick="go_md_mdf('${md_one.midx}')">
			<input type="button" value="삭&nbsp;&nbsp;&nbsp;제" class="btns" onclick="go_md_del('${md_one.midx}')">
			</c:if>
			</div>
			
			<input type="button" value="목&nbsp;&nbsp;&nbsp;록" class="btns" onclick="mdchoice_list()">
		</div>
	</section>
</main>
<!-- <script src="../js/top.js?v=3"></script> -->
<script src="../js/board/md_board.js?v=9"></script>