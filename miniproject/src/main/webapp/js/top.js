var logout = document.getElementById("logout");
var login = document.getElementById("login");
var http;

//로고 클릭시 작동 
function go_main() {
	location.href = "../index.do";
}


//추천매물 메뉴 클릭시 작동(추천매물 리스트 이동) 
function go_rcm_pd() {
	location.href = "../board/md_board.do";
//	location.href = "./md_board.do";
}

//상담신청 메뉴 클릭시 작동 
function go_counsel() {
	location.href = "../cms/counsel.do";
}

//(임시)추천매물 글쓰기 이동 
function go_write() {
	location.href = "../board/md_board_write.do";
}


//방문예약 확인 리스트로 이동.
function reserve_page() {
	location.href = "../board/reservation_list.do";
//	location.href = "./reservation_list.do";
}


//로그아웃 클릭시 
var kakao_id = sessionStorage.getItem("mid");
var kakao_nm = sessionStorage.getItem("mnick");

Kakao.init('c834ce50f389b8f8b20e938ddfc7ea37');
function member_logout(){
	if(!Kakao.Auth.getAccessToken()){ //일반 로그인일 때 
		location.href = "../member/logout.do";
		
	}else {  //카카오 로그인일 때 
		Kakao.Auth.setAccessToken(undefined);
		sessionStorage.clear();  //세션스토리지 비우기 
		localStorage.clear();  //로컬스토리지 비우기 
		location.href="../member/logout.do";
	}
}


//사람모양 아이콘 클릭시 메뉴 보임
function myinfo_menu(part) {
	var log_menu = document.getElementById("login_info");
	if (part == 1) {
		if (log_menu.style.display == "none") {
			log_menu.style.display = "block";
		}
		else {
			log_menu.style.display = "none";
		}
	}
	else {
		log_menu.style.display = "none";
	}
}


