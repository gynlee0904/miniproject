package member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import miniproject.m_encry;

@Controller
public class member_controller extends m_encry{
	@Resource(name="memberDAO")
	private member_DAO m_dao;
	
	@Resource(name="memberDTO") 
	private member_DTO m_dto;
	
	String msg = "";
	
	//회원가입 메소드 
	@PostMapping("/realty/member/member_ok.do")
	public String member_ok(member_DTO m_dto, 
								@RequestParam(defaultValue="N", required=false) String[]m_agr,
								Model m) throws Exception {

		String[] m_agr_ea = new String[]{"N", "N", "N", "N"};
		if (m_agr != null) {
			for (int i = 0; i < m_agr.length && i < 4; i++) {
				m_agr_ea[i] = m_agr[i]; // 체크된 값만 반영
			}
		}
		
		m_dto.setM_agr1(m_agr_ea[0]);
		m_dto.setM_agr2(m_agr_ea[1]);
		m_dto.setM_agr3(m_agr_ea[2]);
		m_dto.setM_agr4(m_agr_ea[3]);
		
		String enc_pw = this.md5_make(m_dto.m_pass);
		m_dto.setM_pass(enc_pw);
		
		int result = this.m_dao.member_insert(m_dto);  //dto에 세팅된 값 전달 
		
		
		if(result>0) {
			this.msg="alert('회원가입이 완료되었습니다. 로그인해주세요!');"
					+"location.href='./login.do';";
		}
		m.addAttribute("msg",this.msg);
		
		return "/realty/alert_msg";
	}
	
	//로그인 메소드 
	@PostMapping("/realty/member/login_ok.do")
	public String login_ok(member_DTO m_dto, HttpServletRequest req, Model m) throws Exception {
		HttpSession se = null;
		
		String mid = m_dto.m_email;
		String mpw = m_dto.m_pass;
		
		String enc_pw = this.md5_make(mpw);
		m_dto.setM_pass(enc_pw);
		
		member_DTO loginMember = this.m_dao.member_login(m_dto); 
		
		
		//로그인 후 회원정보 세션에 저장 
		if(loginMember!= null && mid == loginMember.m_email && mpw == loginMember.m_pass) {  
			String mname = loginMember.m_name;
			
			se = req.getSession();

			se.setAttribute("mid", mid);  
			se.setAttribute("mname", mname);
			
			this.msg="alert('로그인에 성공했습니다.');";
			
		}else if(loginMember == null){  //아이디 및 패스워드가 틀릴경우 
			
			this.msg="alert('로그인에 실패했습니다.\\n아이디 및 패스워드를 다시 확인하세요!');"
							+"history.go(-1);";
		}
		
		m.addAttribute("se", se);
		m.addAttribute("msg", this.msg);
		return "/realty/index";
		
		
	}
	
}
