//추천매물 게시글 내용보기
function go_md_detail(no){
	frm.midx.value=no;
	frm.method="get"
	frm.action="./md_board_view.do";
	frm.submit();
}

//추천매물 게시판 페이징 
function go_page(kw,no){
	if(!kw || kw == ""){  //검색어가 없는경우 
		location.href="../board/md_board.do?pageno="+no;
	}else {  //검색어가 있는경우 
		location.href="../board/md_board.do?keyword="+kw+"&pageno="+no;
	}
	
}


//추천매물 게시판 검색 
function go_search(){
	sch_frm.method="get"
	sch_frm.action="./md_board.do";
	sch_frm.submit();
}



//추천매물 게시글 작성
var title = frm.md_title;
var thumbImg = frm.thumbImg;

function insert_mdchoice(){
var content = CKEDITOR.instances.board_text; 
var file = thumbImg.files[0];

	if(title.value ==""){
		alert("제목을 입력하세요");
		title.focus();
	}	
	else if(thumbImg.value == ""){
		alert("썸네일은 반드시 첨부해주셔야 합니다.");
		// 파일 입력 필드 강조
        thumbImg.style.border = "2px dotted grey";
	}
	else if(file){  //파일 첨부 후 
		var fileSize = file.size; // 파일 크기
		var maxSize = 2 * 1024 * 1024; // 2MB제한
		
		if (!file.type.startsWith("image/")) {
        	alert("이미지 파일만 첨부 가능합니다 (jpg, png, gif 등)");
        	thumbImg.style.border = "2px dotted grey";
    	}
		else if(fileSize > maxSize){
			alert("파일첨부 용량은 2MB이하만 가능합니다.");
			thumbImg.style.border = "2px dotted grey";
		}
		else if(content.getData() == "" ){
			alert("내용을 입력하세요");
			content.focus();
		}
		else {
			frm.method = "post"
			frm.action = "../board/md_board_write.do";
			frm.enctype= "multipart/form-data";
			frm.submit();
		}
	}
	
}
