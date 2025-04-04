


var visit_date = frm.visit_date;
var visit_time = frm.visit_time;
var m_phone = frm.m_phone;
var visit_in = frm.visit_in;

//방문예약등록 클릭시 작동
function rsv_complete(){
	var selectedDate = visit_date.value;  //사용자가 선택한 날짜 
	var today = new Date();  //현재 날짜 
	var thisday = today.toISOString().split('T')[0];
	
	var thistime = today.getHours() * 100 + today.getMinutes();  
	var usertime = visit_time.value;  //사용자가 선택한 시간 
	usertime = parseInt(usertime.replaceAll(":", ""));

	if(visit_date.value==""){
		alert("방문하실 날짜를 선택하세요.");
		visit_date.focus();
	}
	else if(selectedDate < thisday){
		alert("오늘 이전의 날짜는 선택할 수 없습니다.\n다시 선택해주세요.");
		visit_date.value="";  //선택날짜 초기화
		visit_date.focus();
	}
	else if(visit_time.value==""){
		alert("방문 시간을 선택해 주세요.");
		visit_time.focus();
	}
	else if(selectedDate==thisday && usertime < thistime){  //1300 < 2045
		alert("현재 시간 이전의 시간은 선택할 수 없습니다.\n다시 선택해주세요.");
		visit_time.focus();
	}
	else {
		for(var f=0; f<visit_in.length; f++){
			if(visit_in[f].checked == true){
				if(confirm("예약 내용을 정확하게 입력해주셨습니까?")){
					frm.method="post";
					frm.action="../reservation/reservation_ok.do";
					frm.submit();
					
				}else{
					frm.visit_in.focus();
				}
			}
		}
	}
}