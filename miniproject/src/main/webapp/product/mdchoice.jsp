<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!--추천 분양 정보-->
<section>
	<div class="recommend">
		<p>추천분양정보 <br>
			<em>실시간 추천 분양정보를 한곳에!</em>
		</p>
		<div class="md_estates">
			<ul>
				<c:forEach var="md" items="${md_allList}">
				<li>
					<div>
						<img src="./md_room/${md.md_fileRenm}">
					</div> 
					<span>${md.md_title}</span>
					<div>
						${md.md_content}
					</div>
				</li>
				</c:forEach>
			</ul>
		</div>
	</div>

</section>
<!--추천 분양 정보 끝-->
<script src="../js/product/mdchoice.js?v=1"></script>