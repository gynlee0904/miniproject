var email = frm.m_email;
var pass = frm.m_pass;

function login_go(){
	if(email.value==""){
		alert("이메일을 입력하세요");
		email.focus();
		
	}else if(pass.value==""){
		alert("비밀번호를 입력하세요");
		pass.focus();
		
	}else {
		frm.method="post";
		frm.action="./login_ok.do";
		frm.submit();
	}
}


var idsearch = document.getElementById("idsearch");
var pwsearch = document.getElementById("pwsearch");

//아이디찾기 클릭시 작동 
idsearch.addEventListener("click", function() {
    idsearch.href = "./email_search.do"; 
});

//비밀번호찾기 클릭시 작동 
pwsearch.addEventListener("click", function() {
    pwsearch.href = "./passwd_search.do"; 
});