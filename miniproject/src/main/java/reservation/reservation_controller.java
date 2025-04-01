package reservation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import miniproject.m_logincheck;
import product.week_DAO;
import product.week_DTO;

@Controller
public class reservation_controller {
	@Autowired 
	HttpSession se;
	
	@Resource(name="rsvDAO") reservation_DAO r_dao;
	@Resource(name="rsvDTO") reservation_DTO r_dto;
	@Resource(name="loginck") m_logincheck loginck;
	@Resource(name="wkDAO") week_DAO w_dao;
	
	PrintWriter pw = null;
	String msg = "";
	int result= 0;
	
	
	//방문예약 페이지 이동 메소드
	@GetMapping("/cms/reservation.do")
	public String reservation(@RequestParam String aidx,
								@RequestParam String apt_name, 
								Model m) {

		week_DTO week_one = this.w_dao.week_one(aidx, apt_name);
		
		if(week_one.equals(null)) {  //일치하는 결과값이 없을때
			this.msg = "alert('시스템문제가 발생했습니다 \\n 관리자에게 문의하세요'); history.go(-1);";
			return "/common/alert_msg";
		
		}else {  // 결과가 있을 때
			m.addAttribute("week_one", week_one);
			return null;
		}		
	}
	
	//중복예약방지 메소드
	@PostMapping("/cms/dupl_rsv.do")
	public String dupl_rsv(reservation_DTO r_dto,
							HttpServletResponse res) throws IOException {
		this.pw = res.getWriter();
		
		int result = this.r_dao.dupl_rsv_ck(r_dto);
//		int result = this.r_dao.rinfo_ck(r_dto);
		
		if(result>0) {
			this.msg = "no";	//중복있음
		}else {
			this.msg = "ok";  //중복여부 없음 
		}
	
		this.pw.print(this.msg);
		return null;
	}
	

	//방문예약등록 메소드
	@PostMapping("/cms/reservation_ok.do")
	public String reservation_ok(reservation_DTO r_DTO,
									@RequestParam(defaultValue = "N", required=true) String rsv_yn, 
									Model m) {
		
		this.result = this.r_dao.reservation_insert(r_DTO); 

		if(this.result>0) {
			this.se.setAttribute("rsv_yn", rsv_yn);
			
			int ridx = this.r_dao.ridx_check(r_DTO);
//			int ridx = this.r_dao.rinfo_ck(r_DTO); 
			
			this.msg = "alert('방문예약이 완료되었습니다.'); "
					+ "location.href='../cms/reservation_check.do?ridx=" + ridx + "';";
			
		}else {
			this.msg="alert('방문예약에 실패했습니다. \\n 관리자에게 문의하세요.');"
							+"history.go(-1);";
		}
		
		m.addAttribute("msg",this.msg);
		return "/common/alert_msg";
	}
	
	
	//방문예약 내용확인 메소드
	@GetMapping("/cms/reservation_check.do")
	public String reservation_check(@RequestParam String ridx, Model m) {
		
		reservation_DTO rsv_ck = this.r_dao.reservation_check(ridx); 

		if(rsv_ck == null) {  //결과값이 없을 때 
			this.msg = "alert('시스템 문제가 발생했습니다. \\n 관리자에게 문의하세요.');"
							+"history.go(-1);";
			
			m.addAttribute("msg",this.msg);
			return "/common/alert_msg";
			
		}else {  //결과값이 있을때
			m.addAttribute("rsv_ck",rsv_ck);
			return null;
		}
	}
	
	
	
	
}
