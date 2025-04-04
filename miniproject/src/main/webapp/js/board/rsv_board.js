//방문예약 취소
function rsv_cancel(no,pn){
	console.log(pn)
	if(confirm("방문예약을 취소 하시겠습니까?")){
		frm.ridx.value=no;
		frm.pn.value=pn;
		frm.method="post";
		frm.action="./reservation_cancel.do";
		frm.submit();
	}
}

//방문예약 상세보기로 이동 
function go_details(no,nm){
	location.href="../product/week_tails.do?aidx="+no+"&apt_name="+nm;
}