//해당 게시물의 내용 확인
function product_views(no,name){
	location.href='../product/week_tails.do?aidx='+no+'&apt_name='+name;
}


//방문예약 클릭시 작동
function reservation_go(no,name){
	location.href='../cms/reservation.do?aidx='+no+'&apt_name='+name;
}


var visit_date = frm.visit_date;
var visit_time = frm.visit_time;
var m_phone = frm.m_phone;
var visit_in = frm.visit_in;
console.log(id);
//방문예약등록 클릭시 작동
function rsv_complete(){
	var selectedDate = new Date(visit_date.value);
	var today = new Date();
	today.setHours(0, 0, 0, 0);
    selectedDate.setHours(0, 0, 0, 0);

	if(visit_date.value==""){
		alert("방문하실 날짜를 선택하세요.");
		visit_date.focus();
			
	}
	else if(selectedDate < today){
		alert("오늘 이전의 날짜는 선택할 수 없습니다. 다시 선택해주세요.");
		visit_date.value="";  //선택날짜 초기화
		visit_date.focus();

	}
	else if(visit_time.value==""){
		alert("방문 시간을 선택해 주세요.");
		visit_date.focus();
	}
	else {
		for(var f=0; f<visit_in.length; f++){
			if(visit_in[f].checked == true){
				this.ajax_duplcheck(m_phone.value, id, visit_date.value, visit_time.value )
			}
		}
	}
}



//방문예약 중복체크(ajax)
function ajax_duplcheck(m_phone, aidx, visit_date, visit_time){
	var http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		
		if(http.readyState == 4 && http.status == 200){
			
			console.log(this.response)
			
			if(this.response=="ok"){  //중복 없음 
				if(confirm("예약 내용을 정확하게 입력해주셨습니까?")){
					frm.method="post";
					frm.action="../cms/reservation_ok.do";
					frm.submit();
					
				}else{
					frm.visit_in.focus();
				}
			}else { //중복 없음
				alert("이미 예약한 이력과 중복됩니다. 다시 선택해주세요");
				frm.visit_date.value="";  //입력값 초기화 
				frm.visit_time.value="";
			}
		}
		else if(http.status == 404){  //예외처리
			alert("오류 발생 \n 관리자에게 문의하세요");
		}
	}

	http.open("post","../cms/dupl_rsv.do",true);
	http.setRequestHeader("content-type","application/x-www-form-urlencoded");  
	http.send("m_phone="+m_phone+"&aidx="+aidx+"&visit_date="+visit_date+"&visit_time="+visit_time);	
}


