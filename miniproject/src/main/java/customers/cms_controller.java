package customers;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import member.loginckeck;

@Controller
public class cms_controller {
	@Resource(name="cmsDAO") cms_DAO c_dao;
	@Resource(name="cmsDTO") cms_DTO c_dto;
	@Resource(name="loginck") loginckeck loginck;
	
	PrintWriter pw = null;
	String msg = "";
	int result= 0;
	
	
	//상담신청 페이지로 이동 
	@GetMapping("/cms/counsel.do")
	public String go_counsel(Model m, HttpSession session){
		String result = this.loginck.loginck(session);  //로그인 체크 
		if(result.equals("no")){  //로그인 안되어있으면
			this.msg = "alert('로그인 후 이용 가능합니다. \\n 로그인 해주세요!'); "
								+ "location.href='../member/login.do';";
			
			m.addAttribute("msg", this.msg);
			return "/common/alert_msg";
		}
		else {  //로그인 되어있으면
			return null;	
		}
	}
	
	//상담신청
	@PostMapping("/cms/request_cms.do")
	public String request_cms(cms_DTO c_dto, Model m, HttpSession session){
		String result = this.loginck.loginck(session);  //로그인 체크
		
		if(result.equals("no")){  //로그인 안되어있으면
			this.msg = "alert('로그인 후 이용 가능합니다. \\n 로그인 해주세요!'); "
								+ "location.href='../member/login.do';";
			
			m.addAttribute("msg", this.msg);
			return "/common/alert_msg";
		}
		else {  //로그인 되어있으면
			this.result = this.c_dao.cms_insert(c_dto);  //dto에 세팅된 값 전달 
			if(this.result>0 ) {
				this.msg="alert('담당자가 확인 후 해당 상담일시에 맞춰서 연락 드립니다.');"
						+"location.href='../index.do';";
			}
			m.addAttribute("msg",this.msg);
			
			return "/common/alert_msg";
			

		}
	}
	
	
	
	
	

}
