var logout = document.getElementById("logout");
var login = document.getElementById("login");
var http;

//로고 클릭시 작동 
function go_main(){
	location.href = "../index.do"; 
	
}




//로그아웃 클릭시 작동
logout.addEventListener("click", function() {
    logout.href = "../member/logout.do"; 
});



