var m_name = frm.m_name;
var m_phone = frm.m_phone;
var m_email = frm.m_email;
var m_pw = frm.m_pass;
var pw_ck = document.getElementById("m_pass_ck");

var reg_nm = /^[가-힣a-zA-Z]+$/; 
var reg_pn = /^\d{10,11}$/; 
var reg_eml = /^[a-zA-Z0-9_+-]+@[a-zA-Zㄱ-힣]+\.[a-zA-Z]{2,}$/;
var reg_pw = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_-])[a-zA-Z\d!@#$%^&*()_-]{10,16}$/; 

//이메일찾기 버튼 클릭시 작동
function search_eml(){
	if(m_name.value==""){
		alert("성함을 입력하세요");
		m_name.focus();
	}
	else if(!reg_nm.test(m_name.value)){
		alert("이름을 다시한번 확인해주세요.");
		m_name.focus();
	}
	else if(m_phone.value==""){
		alert("휴대폰번호를 입력하세요");
		m_phone.focus();
	}
	else if(!reg_pn.test(m_phone.value)){
		alert("연락처를 다시 확인해주세요 \n 숫자만 입력해야합니다.");
		m_phone.focus();
	}
	else {
		frm.method="post";
		frm.action="./idsearch.do";
		frm.submit();
	}
}

//정보확인 클릭시 작동
function login_go(){
	location.href="../member/login.do";
}


//비밀번호찾기 클릭시 작동
function search_pw(){
	if(m_email.value==""){
		alert("가입하신 이메일을 입력하세요.");
		m_email.focus();
	}
	else if(!reg_eml.test(m_email.value)){
		alert("정확한 이메일을 입력해주세요.");
		m_name.focus();
	}
	else if(m_phone.value==""){
		alert("휴대폰번호를 입력하세요");
		m_phone.focus();
	}
	else if(!reg_pn.test(m_phone.value)){
		alert("연락처를 다시 확인해주세요 \n 숫자만 입력해야합니다.");
		m_phone.focus();
	}
	else {
		frm.method="post";
		frm.action="./pwsearch.do";
		frm.submit();
	}
}


//비민번호변경 버튼 클릭시 작동
function modify_pass(){
	if(m_pw.value==""){
		alert("변경할 패스워드를 입력해주세요.");
		m_pw.focus();
	}
	else if(!reg_pw.test(m_pw.value)){
		alert("패스워드를 형식에 맞게 입력해주세요. \n 10~16자(영문,숫자,특수 문자 조합)");
		m_pw.focus();
	}
	else if(pw_ck.value==""){
		alert("패스워드를 다시한번 입력해주세요.");
		pw_ck.focus();
	}
	else if(m_pw.value!=pw_ck.value){
		alert("패스워드가 맞지 않습니다.");
		pw_ck.focus();
	}else {
		frm.method="post";
		frm.action="./pwmodify.do";
		frm.submit();
	}
}


var sid = document.getElementById("sid");
var spw = document.getElementById("spw");
sid.addEventListener("click",function(){
	location.href="../member/email_search.do";
});
spw.addEventListener("click",function(){
	location.href="../member/passwd_search.do";
});

