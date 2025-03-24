package member;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class member_controller {
	@Resource(name="memberDAO")
	private member_DAO m_dao;
	
	@Resource(name="memberDTO") 
	private member_DTO m_dto;
	
	//회원가입 메소드 
	@PostMapping("/realty/member/member_ok.do")
	public String macbook_ok(member_DTO m_dto, Model m) throws Exception {
		int result = this.m_dao.member_join(m_dto);  //dto에 세팅된 값 전달 
//		String answer = "";
//		if(result>0) {
//			answer="alert('회원가입이 완료되었습니다');"
//					+"location.href='./realty/index.do';";
//		}
//		m.addAttribute("answer",answer);
		
		return "/realty/msg";
	}
	
}
