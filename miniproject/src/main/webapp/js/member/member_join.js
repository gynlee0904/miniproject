var email = f.m_email;
var eml_ckok = document.getElementById("eml_ckok");
var pw = f.m_pass;
var pw_ck = document.getElementById("m_pass_ck");
var mname = f.m_name;
var phone = document.getElementById("phone");
var m_agr = f.m_agr;
var reg_eml = /^[a-zA-Z0-9_+-]+@[a-zA-Zㄱ-힣]+\.[a-zA-Z]{2,}$/;
var reg_pw = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_-])[a-zA-Z\d!@#$%^&*()_-]{10,16}$/; 
var reg_nm = /^[가-힣a-zA-Z!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?`~ ]+$/; 
var reg_pn = /^01\d{8,9}$/;
var http, http2;  //ajax용 변수
var reg_kakaoid = /^\d+$/;

//약관동의내용 로드 
window.onload=function(){
	http = new XMLHttpRequest();  //ajax통신
	http.open("GET","../txt/agree1.txt",false);  
	http.send();  
	document.getElementById("agree1").innerHTML = http.response;
	
	http2 = new XMLHttpRequest();  
	http2.open("GET","../txt/agree2.txt",false);
	http2.send();
	document.getElementById("agree2").innerHTML = http2.response;
}


//아이디 중복체크  
function email_ck(){
	if(email.value==""){
		alert("가입할 이메일을 입력해주세요.");
		email.focus();
	}
	else if(!reg_eml.test(email.value)){
		alert("이메일을 정확하게 입력해주세요.");
		email.focus();
	}
	else {
		this.ajax_idcheck(email.value); //아이디 중복체크
	}
}

//이메일 중복체크(ajax)
function ajax_idcheck(email){
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState == 4 && http.status == 200){
			console.log(this.response)
			if(this.response=="ok"){
				alert("해당 이메일은 사용가능합니다");
				f.m_email.readOnly = true; 
				f.m_email.style.backgroundColor = "#ccc" 
				eml_ckok.value="ok"	
				document.getElementById("dp_btn").style.backgroundColor = "#ccc";  //버튼 안보이게 처리 
				document.getElementById("dp_btn").style.border = "1px solid #ccc";
				document.getElementById("dp_btn").style.cursor = "default";
				document.getElementById("dp_btn").disabled = true;
				
			}else {
				alert("해당 이메일은 이미 가입중입니다");
				f.m_email.value = "";  //입력값 초기화 
			}
		}
		else if(http.status == 404){  //예외처리
//			console.log(http.status)
			alert("오류 발생 \n 관리자에게 문의하세요");
		}
	}

	http.open("get","./idcheck.do?m_email="+email,true);
	http.send();	
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


//회원가입버튼 누르면 작동
function member_join(){
	if(email.value==""){
		alert("이메일을 입력해주세요.");
		email.focus();
	}
	else if(!reg_eml.test(email.value)){  //이메일 형식이 아닌 경우 
		alert("이메일을 정확하게 입력해주세요.");
		email.focus();
	}
	else if(eml_ckok.value !="ok"){
		alert("이메일 중복 체크를 해주세요.");
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
		alert("휴대폰번호를 입력해주세요.");
		phone.focus();
	}
	else if(!reg_pn.test(phone.value)){
		alert("휴대폰번호를 정확하게 입력해주세요.");
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
			this.ajax_phncheck(phone.value) //폰번중복체크
        }
	}
}

//카카오로그인을 위한 회원가입 
var kakao_id = sessionStorage.getItem("mid");
var kakao_nm = sessionStorage.getItem("mnick");
//console.log(kakao_id)

if(kakao_id != null){  //세션스토리지에 값이 있을때 
	f.m_type.value="KAKAO";
	f.kakao_id.value=kakao_id;
	
	pw.value=kakao_id+"a!";   //패스워드는 임의로 처리 
	pw.readOnly = true;
	pw.style.backgroundColor = "#f0f0f0";
	
	pw_ck.value=kakao_id+"a!";
	pw_ck.readOnly = true;
	pw_ck.style.backgroundColor = "#f0f0f0";
}


//폰번중복체크(ajax)
function ajax_phncheck(phone){
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState == 4 && http.status == 200){
			if(this.response=="ok"){
				f.m_phone.readOnly = true;  
				f.action="./member_ok.do";
				f.submit();
			}else {
				alert("이미 가입되어있는 휴대폰번호 입니다. \n 휴대폰번호를 다시 확인해주세요.");
				f.m_phone.focus();  
			}
		}
		else if(http.status == 404){  //예외처리
			console.log(http.status)
			alert("오류 발생 \n 관리자에게 문의하세요");
		}
	}

	http.open("get","./phncheck.do?m_phone="+phone,true);
	http.send();
}