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
				<li><input type="text" class="board_in2" name="md_title" id="md_title" value="${md_one.md_title}"></li>
				<li>글쓴이</li>
				<li><input type="text" class="board_in1"  value="관리자" readonly><span>&nbsp;&nbsp; 이전작성자 : ${md_one.md_writer}</span></li>
				<li>썸네일 이미지</li>
				<li>
				<span id="md_filenm">${md_one.md_filenm}</span>&nbsp;&nbsp;  
				<input type="file" name="thumbImg" id="thumbImg" accept="image/*" >
				</li>
				<li class="litext">내&nbsp;&nbsp;&nbsp;용</li>
				<li class="litext">
					<textarea id="board_text" name="md_content">
					${md_one.md_content}
					</textarea>
				</li>
				<li>최종 수정일</li>
				<li>${md_one.modyfied_date}</li>
			</ul>
			<input type="hidden" name="md_writer" id="md_writer" value="${aname}"> 
		</div>
		<div class="board_btn">
			<input type="button" value="취&nbsp;&nbsp;&nbsp;소" class="btns" onclick="history.go(-1);">
			<input type="button" value="수&nbsp;&nbsp;&nbsp;정" class="btns" onclick="modify_mdchoice('${md_one.midx}');">
		</div>
	</section>
	<script>
		window.onload = function() {
			CKEDITOR.replace('board_text', {
				height : 360
			});
		};
	</script>
</main>
<script>
var thumb = "${md_one.md_fileRenm}";  //jstl,JSP => JS변수에 넣을 때 "" 꼭 넣을것 
</script>
<script src="../js/board/md_board.js?v=13"></script>