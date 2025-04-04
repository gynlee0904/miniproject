<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form id="frm">
<main>
	<section class="sub">
		<p>추천분양 정보 게시판</p>
		<div class="boards">이번주 신규 매물정보를 한눈에 확인하실 수 있습니다.</div>
		<div class="info_board">
			<ul>
				<li>제&nbsp;&nbsp;&nbsp;목</li>
				<li><input type="text" class="board_in2" name="md_title"></li>
				<li>글쓴이</li>
				<li><input type="text" class="board_in1" name="md_writer" value="관리자" readonly></li>
				<li>썸네일 이미지</li>
				<li><input type="file" name="thumbImg" accept="image/*"></li>
				<li class="litext">내&nbsp;&nbsp;&nbsp;용</li>
				<li class="litext"><textarea id="board_text" name="md_content"></textarea></li>
			</ul>
		</div>
		<div class="board_btn">
			<input type="button" value="등&nbsp;&nbsp;&nbsp;록" class="btns" onclick="insert_mdchoice();">
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
</form>
<script src="../js/board/md_board.js?v=3"></script>