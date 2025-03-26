
//약관동의내용 로드 
window.onload=function(){
	var http = new XMLHttpRequest();  //ajax통신
	http.open("GET","../txt/agree1.txt",false);  
	http.send();  
	document.getElementById("agree1").innerHTML = http.response;
	
	var http2 = new XMLHttpRequest();  
	http2.open("GET","../txt/agree2.txt",false);
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


var email = f.m_email;
var pw = f.m_pass;
var pw_ck = document.getElementById("m_pass_ck");
var mname = f.m_name;
var phone = f.m_phone;
var m_agr = f.m_agr;
var reg_eml = /^[a-zA-Z0-9_+-]+@[a-zA-Zㄱ-힣]+\.[a-zA-Z]{2,}$/;
var reg_pw = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_-])[a-zA-Z\d!@#$%^&*()_-]{10,16}$/; 
var reg_nm = /^[가-힣a-zA-Z]+$/; 
var reg_pn = /^\d{10,11}$/; 


//이메일 중복체크
function email_ck(){
	
	alert("ss")
}

//회원가입버튼 누르면 작동
function member_join(){
	if(email.value==""){
		alert("가입할 이메일을 입력해주세요.");
		email.focus();
	}
	else if(!reg_eml.test(email.value)){
		alert("이메일을 정확하게 입력해주세요.");
		email.focus();
	}
	else if(pw.value==""){
		alert("패스워드를 입력해주세요.");
		pw.focus();
	}
	else if(!reg_pw.test(pw.value)){
		alert("패스워드를 형식에 맞게 입력해주세요. \n 10~16자(영문,숫자,특수 문자 조합)");
		pw.focus();
	}
	else if(pw_ck.value==""){
		alert("패스워드를 다시한번 입력해주세요.");
		pw_ck.focus();
	}
	else if(pw.value!=pw_ck.value){
		alert("패스워드가 맞지 않습니다.");
		pw_ck.focus();
	}
	else if(mname.value==""){
		alert("이름을 입력해주세요.");
		mname.focus();
	}
	else if(!reg_nm.test(mname.value)){
		alert("이름을 다시한번 확인해주세요.");
		mname.focus();
	}
	else if(phone.value==""){
		alert("연락처를 입력해주세요.");
		phone.focus();
	}
	else if(!reg_pn.test(phone.value)){
		alert("연락처를 다시 확인해주세요 \n 숫자만 입력해야합니다.");
		phone.focus();
	}
	else {
		var requiredIndexes = [0, 1, 2];
		var allChecked = true;
        for (var i = 0; i < requiredIndexes.length; i++) {
            if (!m_agr[requiredIndexes[i]].checked) {
                allChecked = false;
                break;
            }
        }
        if (!allChecked) {
            alert("필수사항에 모두 동의하셔야 합니다");
        } else {
//            alert("통과!");
			f.action="./member_ok.do";
			f.submit();
        }
	}
}