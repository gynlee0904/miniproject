var logout = document.getElementById("logout");
var login = document.getElementById("login");
var http;

//로고 클릭시 작동 
function go_main() {
	location.href = "../index.do";
}


//추천매물 메뉴 클릭시 작동 
function go_rcm_pd() {
	location.href = "../board/md_board.do";
//	location.href = "./md_board.do";
}

//상담신청 메뉴 클릭시 작동 
function go_counsel() {
	location.href = "../cms/counsel.do";
}

//추천매물 글쓰기 이동 
function go_write() {
	location.href = "../board/md_board_write.do";
}


//방문예약 확인 리스트로 이동.
function reserve_page() {
	location.href = "../board/reservation_list.do";
//	location.href = "./reservation_list.do";
}



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


