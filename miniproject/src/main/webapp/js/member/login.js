var email = frm.m_email;
var pass = frm.m_pass;

function login_go(){
	if(email.value==""){
		alert("이메일을 입력하세요");
	}else if(pass.value==""){
		alert("비밀번호를 입력하세요");
	}else {
		frm.submit();
	}
}