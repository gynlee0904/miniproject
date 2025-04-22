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
function insert_mdchoice(){
	var title = frm.md_title;
	var thumbImg = frm.thumbImg;
	var file = thumbImg.files[0];
	var content = CKEDITOR.instances.board_text; 

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
//			frm.action = "../board/md_board_write.do";
			frm.action = "./md_board_write.do";
			frm.enctype= "multipart/form-data";
			frm.submit();
		}
	}
	
}

//추천매물 리스트 이동
function mdchoice_list(){
	location.href="./md_board.do";
}


var http, result;
//추천매물 게시글 삭제 
function go_md_del(midx){
	if(confirm("정말 삭제하시겠습니까? \n 삭제 후에는 복구되지 않습니다.")){
		http = new XMLHttpRequest();
		http.open("DELETE","./md_delete.do/"+midx,true); 
		http.setRequestHeader("content-type","application/x-www-form-urlencoded"),
		http.onload = function () {
	        if (http.readyState == 4 && http.status == 200) { // 요청 완료
	            console.log(this.response);
				if(this.response=="ok"){
					alert("정상적으로 삭제 완료되었습니다");
					location.href="./md_board.do";
				}else{
					alert("시스템 문제로 게시글 삭제에 실패썌습니다.");
					history.go(-1);
				}
	
	        }else {
	            alert("에러가 발생했습니다");
	            console.log("상태 코드:", http.status);
	        }
	    }
		http.send(midx);
	}
}

//추천매물 게시글 수정페이지로 이동
function go_md_mdf(midx){
	var form = document.createElement("form");
    form.method = "post";
    form.action = "./md_board_modify.do";

    var input = document.createElement("input");
    input.type = "hidden";
    input.name = "midx";
    input.value = midx;

    form.append(input);
    document.body.append(form);
	form.submit();

    //submit 후 폼 제거
    document.body.remove(form);
}


var title = document.getElementById("md_title");
var thumbImg = document.getElementById("thumbImg");
var writer = document.getElementById("md_writer");

//추천매물 게시글 수정
function modify_mdchoice(midx){
	var file = thumbImg.files[0];
	var content = CKEDITOR.instances.board_text; 	
	if(title.value ==""){
		alert("제목을 입력하세요");
		title.focus();
	}
	else if(content.getData().trim() == "" ){
			alert("내용을 입력하세요");
			content.focus();
	}
	else if(file){  //새로 파일첨부를 한 경우 
		var fileSize = file.size; // 파일 크기
		var maxSize = 2 * 1024 * 1024; // 2MB제한
		
		if (!file.type.startsWith("image/")) {
    		alert("이미지 파일만 첨부 가능합니다 (jpg, png, gif 등)");
    		thumbImg.style.border = "2px dotted grey";
		}
		else if(fileSize > maxSize){
			alert("파일첨부 용량은 2MB이하만 가능합니다.");
			thumbImg.style.border = "2px dotted grey";
		}else {
			if(confirm("정말 수정하시겠습니까?")){
				this.mdfy_ajax(midx);
			}
		}
	}else {
		if(confirm("정말 수정하시겠습니까?")){
			this.mdfy_ajax(midx);
		}
	}
}

//게시글 수정(ajax)
function mdfy_ajax(midx){
	var content = CKEDITOR.instances.board_text;
	var thumbImg = document.getElementById("thumbImg");
	var file = thumbImg.files[0];

	var formData = new FormData();
	formData.append("midx", midx);
	formData.append("md_title", title.value);
	formData.append("md_content", content.getData());
	formData.append("md_writer", writer.value);

	if (file) { //새로 파일 첨부를 한 경우 
    	formData.append("thumbImg", file);
	}
	http = new XMLHttpRequest();
	http.open("POST","./md_mdf.do",true); 
	http.onload = function () {
        if (http.readyState == 4 && http.status == 200) { // 요청 완료
            console.log(this.response);
			if(this.response=="ok"){
				alert("정상적으로 수정 완료되었습니다");
				location.href="./md_board_view.do?midx="+midx;
			}else{
				alert("시스템 문제로 게시글 수정에 실패했습니다.");
				history.go(-1);
			}

        }else {
            alert("에러가 발생했습니다");
            console.log("상태 코드:", http.status);
        }
    }
	http.send(formData);
}


thumbImg.addEventListener("change", function () {
	if (this.files.length > 0) {
		document.getElementById("md_filenm").style.color = "grey";
		document.getElementById("md_filenm").style.textDecoration = "line-through";
	}
});
