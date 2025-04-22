<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Date date_md = new Date();
	SimpleDateFormat sf_md = new SimpleDateFormat("yyMMdd");
	String today_md = sf_md.format(date_md);
%>

<!--추천 분양 정보-->
<section>
	<div class="recommend">
		<p onclick="go_rcm_pd();">추천분양정보 <br>
			<em>실시간 추천 분양정보를 한곳에!</em>
		</p>

		<div class="md_estates">
			<ul>
				<c:forEach var="md" items="${md_allList}">
				<li onclick="go_md_detail('${md.midx}')">
					<div>
						<img src="../md_file/${md.md_fileRenm}">
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
<script src="../js/product/mdchoice.js?v=2"></script>