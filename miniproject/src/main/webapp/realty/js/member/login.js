var email = frm.lemail;
var pass = frm.lpass;
var reg_em = /^[a-zA-Z0-9._%+-](a-zA-Z0-9._%+-)+@[a-zA-Z0-9.-ㄱ-힣]+\.[a-zA-Zㄱ-힣]{2,}/g;

function logincheck(){
	if(email.value==""){
		alert("이메일을 입력하세요");
	}else if(reg_em.test(email.value)==false){
		console.log(reg_em.test(email.value))	
		alert("이메일이 정확한지 확인해주세요");
	}else if(pass.value==""){
		alert("비밀번호를 입력하세요");
	}else {
		
		alert("통과")
	
	}
	
}