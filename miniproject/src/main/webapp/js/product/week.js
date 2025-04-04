//해당 게시물의 내용 확인
function product_views(no,name){
	location.href='../product/week_tails.do?aidx='+no+'&apt_name='+name;
}


//방문예약 클릭시 작동
function reservation_go(no,name){
	location.href='../reservation/reservation.do?aidx='+no+'&apt_name='+name;
}


