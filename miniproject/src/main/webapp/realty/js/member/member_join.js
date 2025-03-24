
//약관동의내용 로드 
window.onload=function(){
	var http = new XMLHttpRequest;  //ajax통신
	http.open("GET","../../realty/agree1.txt",false);  
	http.send();  
	document.getElementById("agree1").innerHTML = http.response;
	
	var http2 = new XMLHttpRequest;  
	http2.open("GET","../../realty/agree2.txt",false);
	http2.send();
	document.getElementById("agree2").innerHTML = http2.response;
}

var ob =  f.m_agr; //name이 m_agr인 체크박스
var ea = ob.length;  //name이 m_agr인 박스 전체 개수

//전체동의 체크시 모든 체크박스 선택
function ck_all(v){
	for(var f=0; f<ea; f++){  //전체선택 클릭시 아래 체크박스 모두 선택되도록 작동 
		ob[f].checked = v ;  //같은 이름의 name값은 배열로 순차적으로 처리됨 
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

var email = f.m_email;
var pw = f.m_pass;
var pw_ck = document.getElementById("m_pass_ck");
var mname = f.m_name;
var phone = f.m_phone;
var m_agr = f.m_agr;
var reg_eml = /^[a-zA-Z0-9_+-]+@[a-zA-Zㄱ-힣0-9.-]+\.[a-zA-Zㄱ-힣]{2,}$/;
var reg_pw = / /; 
var reg_nm = / /; 
var reg_pn = / /; 

function member_join(){
	if(email.value==""){
		alert("가입할 이메일을 입력해주세요");
		email.focus();
	}
	else if(reg_eml.test(email.value)==false){
		alert("이메일을 정확하게 입력해주세요");
		pw.focus();
	}
	else if(pw.value==""){
		alert("패스워드를 입력해주세요");
		pw.focus();
	}
	else if(pw_ck.value==""){
		alert("패스워드를 다시한번 입력해주세요");
		pw_ck.focus();
	}
	else if(pw.value!=pw_ck.value){
		alert("패스워드가 맞지 않습니다");
		pw_ck.focus();
	}
	else if(mname.value==""){
		alert("이름을 입력해주세요");
		mname.focus();
	}
	else if(phone.value==""){
		alert("연락처를 입력해주세요");
		phone.focus();
	}
	else if(m_agr[0].checked==false || m_agr[1].checked==false || m_agr[2].checked==false ){
		alert("필수사항에 모두 동의하셔야 합니다");
	}
	else {
		f.submit();
	}
}