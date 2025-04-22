
//추천매물 글쓰기페이지로 이동
function md_board_write(){
	location.href='../board/md_board_write.do';
}


//로고 클릭시 작동 
function go_main() {
	location.href = "../index.do";
}

//메인 카드 화면 메뉴
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