package product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import miniproject.m_logincheck;
import reservation.reservation_DAO;
import reservation.reservation_DTO;

@Controller
public class week_controller {
	@Autowired 
	HttpSession se;
	
	@Resource(name="wkDAO") week_DAO w_dao;
	@Resource(name="wkDTO") week_DTO w_dto;
	@Resource(name="rsvDAO") reservation_DAO r_dao;
	@Resource(name="loginck") m_logincheck loginck;
	
	PrintWriter pw = null;
	String msg =""; 

	
	//weekinfo 상세보기 메소드
	@GetMapping("/product/week_tails.do")
	public String week_tails(@RequestParam String aidx,
							@RequestParam String apt_name, 
							@SessionAttribute(name="mphone", required=false) String mphone,
							Model m) throws IOException {
	
		String login_yn = this.loginck.loginck();  //로그인 체크
		String admin_yn = this.loginck.adminck();  //관리자여부 체크
		String url = null;
		
		if(login_yn.equals("ok") || admin_yn.equals("adm")){  //로그인 되어있으면
			week_DTO week_one = this.w_dao.week_one(aidx, apt_name);
			
			if(week_one.equals(null)) {  //일치하는 결과값이 없을때
				
				this.msg = "alert('시스템문제가 발생했습니다 \\n 관리자에게 문의하세요'); history.go(-1);";
				url = "/common/alert_msg";
				
			}else {  // 결과가 있을 때
				reservation_DTO rsv_ck = this.r_dao.rsv_ck(mphone, aidx);  //예약여부 확인 메소드
				
				if(rsv_ck != null) {  //예약한 건이 있으면 전송 
					m.addAttribute("rsv_ck", rsv_ck);
				}
				
				m.addAttribute("week_one", week_one);
			}		
			
		}
		else {  //로그인 안되어있을 경우
			this.msg = "alert('로그인 후 상세보기 가능합니다. \\n 로그인 해주세요!'); "
					+ "location.href='../member/login.do';";
			
			m.addAttribute("msg", this.msg);
			url =  "/common/alert_msg";
			
		}	
		return url;

	}
	
	
}
