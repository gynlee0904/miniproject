
//약관동의내용 로드 
window.onload=function(){
	var http = new XMLHttpRequest;  //ajax통신
	http.open("GET","../../realty/agree1.txt",false);  
	http.send();  
	document.getElementById("agree1").innerHTML = http.response;
	
	var http2 = new XMLHttpRequest;  //객체를 따로 만들어서 로드해야함
	http2.open("GET","../../realty/agree2.txt",false);
	http2.send();
	document.getElementById("agree2").innerHTML = http2.response;
}

//전체동의 체크시 모든 체크박스 선택
var agree ="";
var ea = agree.length;  //name이 m_agr인 박스 전체 개수
function ck_all(v){   //전체선택 클릭시 아래 체크박스 모두 선택되도록 작동 
	for(var n=1; n<5; n++){
		agree = "f.m_agr"+n;  //name이 m_agr인 체크박스
		agree.checked = v ;  //같은 이름의 name값은 배열로 순차적으로 처리됨
	}
}
 



//체크박스 하나라도 해제되었을 경우 전체동의 체크를 해제 
function agree_ck(){
	var all = document.getElementById("all_agree");
	var count=0;
	for(var f=0; f<ea; f++){
		if(ob[f].checked == true){
			count++;
		}
	}
	if(ea==count){  //agree_ck가 모드 체크된경우
		all.checked = true;  //전체동의 체크 
	}else{  //하나라도 빠진경우
		all.checked = false;  //전체동의 체크 해제 
	}
}

function email_ck(){
	
	alert("ss")
}


function member_join(){
	f.submit();
	
}