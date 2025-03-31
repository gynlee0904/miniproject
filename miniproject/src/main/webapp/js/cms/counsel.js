var rental_type = frm.rental_type;
var apt_type = frm.apt_type;
var counsel_date = frm.counsel_date;
var counsel_content = frm.counsel_content;

function counsel_go(){
	//임대형태 선택여부 확인 
	var rental_cnt = 0;
	var w=0;
	while(w<rental_type.length){
		if(rental_type[w].checked==true){
			rental_cnt++;
		}
		w++;
	}
	if(rental_cnt<=0){
		alert("임대형태는 최소 1개는 선택되어야 합니다.");
		rental_type.focus();
	}else {
		check_apt();  //주거형태 선택 	
	}
}

//주거형태 선택여부 확인 	
function check_apt(){
	var apt_cnt = 0;
	var w=0;
	while(w<apt_type.length){
		if(apt_type[w].checked==true){
			apt_cnt++;
		}
		w++;
	}
	if(apt_cnt<=0){
		alert("주거형태는 최소 1개는 선택되어야 합니다.");
		apt_type.focus();
	}else {
		check_date();  //날짜 선택 	
	}
	
}

//날짜 선택여부 확인 
function check_date(){
	var selectedDate = new Date(counsel_date.value);
	var today = new Date();

	// 시간을 00:00:00으로 초기화하여 날짜만 비교
    today.setHours(0, 0, 0, 0);
    selectedDate.setHours(0, 0, 0, 0);

	if(counsel_date.value==""){
		alert("상담받으실 날짜를 선택하세요.");
		counsel_date.focus();
		
	}else if(selectedDate < today){
		alert("오늘 이전의 날짜는 선택할 수 없습니다. 다시 선택해주세요")
		counsel_date.value="";  //선택날짜 초기화
		counsel_date.focus();
		
	}else if(counsel_content.value==""){
		alert("상담내용을 입력해주세요");
		counsel_content.focus();
		
	}else if(counsel_content.value.trim().length<11){
		alert("상담내용은 최소 10자 이상 입력해야 합니다.");
		counsel_content.focus();
		
	}else {
		
		frm.method="post";
		frm.action="../cms/request_cms.do";

		frm.submit();
	}
}