package reservation;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import miniproject.m_logincheck;
import miniproject.m_paging;
import product.week_DAO;
import product.week_DTO;

@Controller
public class reservation_controller {
	@Resource(name="rsvDAO") reservation_DAO r_dao;
	@Resource(name="rsvDTO") reservation_DTO r_dto;
	@Resource(name="loginck") m_logincheck loginck;
	@Resource(name="paging") m_paging paging;
	@Resource(name="wkDAO") week_DAO w_dao;
	
	
	PrintWriter pw = null;
	String msg = "";
	int result= 0;
	String url = null;
	
	//방문예약 페이지 이동 메소드
	@GetMapping("/reservation/reservation.do")
	public String reservation(@RequestParam String aidx,
								@RequestParam String apt_name, 
								Model m) {
		
		String login_yn = this.loginck.loginck();  //로그인 체크
		if(login_yn.equals("no")){  //로그인 안되어있으면
			this.msg = "alert('로그인 후 이용 가능합니다. \\n 로그인 해주세요!'); "
								+ "location.href='../member/login.do';";
			
			m.addAttribute("msg", this.msg);
			this.url = "/common/alert_msg";
			
		}
		else {  //로그인 되어있으면 해당 페이지로 이동
			
			week_DTO week_one = this.w_dao.week_one(aidx, apt_name);  //상품고유번호와 상품명이 일치하는 값 가져오는 메소드
			
			if(week_one.equals(null)) {  //일치하는 결과값이 없을때
				
				this.msg = "alert('시스템문제가 발생했습니다 \\n 관리자에게 문의하세요'); history.go(-1);";
				this.url = "/common/alert_msg";
			
			}else{  // 결과가 있을 때
				m.addAttribute("week_one", week_one);
				
			}		
		}
		return this.url;
	}
	
	
	//방문예약등록 메소드
	@PostMapping("/reservation/reservation_ok.do")
	public String reservation_ok(reservation_DTO r_DTO,	Model m) {
		
		this.result = this.r_dao.reservation_insert(r_DTO); 
		if(this.result>0) {
			int ridx = this.r_dao.ridx_check(r_DTO); //예약등록된 컬럼의 고유번호 확인 
			this.msg = "alert('방문예약이 완료되었습니다.'); "
					+ "location.href='./reservation_check.do?ridx=" + ridx + "';";
			
		}else {
			this.msg="alert('방문예약에 실패했습니다. \\n 관리자에게 문의하세요.');"
							+"history.go(-1);";
		}
		
		m.addAttribute("msg",this.msg);
		return "/common/alert_msg";
	}
	
	
	//방문예약 내용확인 메소드
	@GetMapping("/reservation/reservation_check.do")
	public String reservation_check(@RequestParam String ridx, Model m) {
		
		Map<String,String> rsv_ck = this.r_dao.reservation_check(ridx); 
		 
		if(rsv_ck == null){  //결과값이 없을 때
			this.msg = "alert('시스템 문제가 발생했습니다. \\n 관리자에게 문의하세요.');"
					 	+"history.go(-1);";			
			m.addAttribute("msg",this.msg);
			this.url = "/common/alert_msg";
			
		}else {  //결과값이 있을때
			m.addAttribute("rsv_ck",rsv_ck);
		}
		
		return this.url;
	}
	
	
	//방문예약리스트 확인 메소드
	@GetMapping("/board/reservation_list.do")
	public String reservation_list(@SessionAttribute(name="mphone", required = false) String mphone, Model m) {
		String login_yn = this.loginck.loginck();  //로그인 체크
		if(login_yn.equals("no")){  //로그인 안되어있으면
			this.msg = "alert('로그인 후 이용 가능합니다. \\n 로그인 해주세요!'); "
								+ "location.href='../member/login.do';";
			
			m.addAttribute("msg", this.msg);
			this.url = "/common/alert_msg";
			return this.url;
			
		}
		else {  //로그인 되어있으면 해당 페이지로 이동	
			this.result = this.r_dao.check_date();  //날짜지난건 리스트 삭제 
			int list_total = this.r_dao.rsv_mytotal(mphone);  //내 예약리스트 총개수 
			int sno = this.paging.serial_no(1, 10);
			List<reservation_DTO> rsv_myList = this.r_dao.rsv_myList(mphone);
			
			m.addAttribute("sno",sno); 
			m.addAttribute("list_total", list_total);
			m.addAttribute("rsv_myList", rsv_myList);	
		}
		return null;
	}
	
	
	//방문예약 취소 메소드
	@PostMapping("/board/reservation_cancel.do")
	public String reservation_cancel(@SessionAttribute(name="mphone", required = false) String mphone,
									@RequestParam String ridx,
									@RequestParam String pn, Model m) {
		
		this.result = this.r_dao.rsv_cancel(pn, ridx);
		if(this.result>0) {
			this.msg = "alert('모델하우스 방문예약이 취소 완료되었습니다.'); "
						+ "location.href='./reservation_list.do';";
			m.addAttribute("msg", this.msg);
			
		}else {
			this.msg = "alert('시스템문제로 방문예약이 취소되지 않았습니다. \\n 관리자에게 문의해주세요.'); "
						+ "history.go(-1);";
			m.addAttribute("msg", this.msg);
		}
		
		return "/common/alert_msg";
	}
	

	
	
	
}
