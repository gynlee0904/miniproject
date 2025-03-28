package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import miniproject.m_encry;

@CrossOrigin(origins="*", allowedHeaders = "*")
@Controller
public class member_controller extends m_encry{
	@Resource(name="memberDAO") private member_DAO m_dao;
	@Resource(name="memberDTO") private member_DTO m_dto;
	
	PrintWriter pw =null;	
	String msg = "";
	int result= 0;
	
	
	//회원가입 메소드 
	@PostMapping("/member/member_ok.do")
	public String member_ok(member_DTO m_dto, 
								String[]m_agr,
								Model m) throws Exception {
		System.out.println(m_agr.length);
		m_dto.setM_agr1(m_agr[0]);
		m_dto.setM_agr2(m_agr[1]);
		m_dto.setM_agr3(m_agr[2]);
		if(m_agr.length==3) { 
			m_dto.setM_agr4("N"); 
		}else {
			m_dto.setM_agr4(m_agr[3]);
		}

		String enc_pw = this.md5_make(m_dto.m_pass);
		m_dto.setM_pass(enc_pw);
		
		int result = this.m_dao.member_insert(m_dto);  //dto에 세팅된 값 전달 
		if(result>0 ) {
			this.msg="alert('회원가입이 완료되었습니다. 로그인해주세요!');"
					+"location.href='./login.do';";
		}
		m.addAttribute("msg",this.msg);
		
		return "/common/alert_msg";
	}
	
	//폰번중복체크 메소드
	@GetMapping("/member/phncheck.do")
	public String phncheck(@RequestParam String m_phone, HttpServletResponse res) throws IOException {
		this.pw = res.getWriter();
		
		int result = this.m_dao.phn_check(m_phone);
		if(result>0) {
			this.msg = "no";	//휴대폰 중복
		}else {
			this.msg = "ok";  //휴대폰 중복x
		}
	
		this.pw.print(this.msg);
		return null;
	}
	
	//아이디중복체크 메소드
	@GetMapping("/member/idcheck.do")
	public String idcheck(@RequestParam String m_email, HttpServletResponse res) throws IOException {
		this.pw = res.getWriter();
		
		int result = this.m_dao.eml_check(m_email);

		if(result>0) {
			this.msg = "no";	//이메일 중복
		}else {
			this.msg = "ok";  //이메일 사용가능
		}
		
		this.pw.print(this.msg);
		return null;
	}
	
	
	//로그인 메소드 
	@PostMapping("/member/login_ok.do")
	public String login_ok(member_DTO m_dto, HttpServletRequest req, Model m) throws Exception {
		HttpSession session = null;
		
		String mid = m_dto.m_email;  //사용자 입력 id
		String mpw = m_dto.m_pass;  //사용자 입력 pw
		
		String enc_pw = this.md5_make(mpw);
		m_dto.setM_pass(enc_pw);
		
		member_DTO loginMember = this.m_dao.member_login(m_dto); 
		//loginMember는 db에 저장되어있는 값임. 
		
		if(loginMember == null){  //아이디 및 패스워드가 틀릴경우 	
			
			this.msg="alert('로그인에 실패했습니다.\\n아이디 및 패스워드를 다시 확인하세요!'); "
					+ "history.go(-1);";
		}
		else {    //로그인 후 회원정보 세션에 저장 
//			if(mid.equals(loginMember.m_email) && enc_pw.equals(loginMember.m_pass)) {  //=> where조건이 하나만 있을떄 사용 
			String mname = loginMember.m_name;		
			String mphone = loginMember.m_phone;

			session = req.getSession();

			session.setAttribute("mid", mid);  //이메일  
			session.setAttribute("mname", mname);  //이름
			session.setAttribute("mphone", mphone);  //연락처
			
			this.msg="alert('"+mname+"님 환영합니다!'); "
					+ "location.href='../index.do';";
//			}else {
//				this.msg="alert('로그인에 실패했습니다.\\n아이디 및 패스워드를 다시 확인하세요!'); history.go(-1);";
//			}
		} 
		m.addAttribute("msg", this.msg);
		
		return "/common/alert_msg";
	}
	
	
	//로그아웃 메소드 
	@GetMapping("/member/logout.do")
	public String logout(HttpServletRequest req, Model m) {
		
		HttpSession session = req.getSession();
		session.invalidate(); //세션에 저장된 정보들 파기 
		
		this.msg="alert('로그아웃 되었습니다.'); "
				+ "location.href='../index.do';";
		
		m.addAttribute("msg", this.msg);
		
		return "/common/alert_msg";
	}
	
	
	//아이디찾기 페이지로 이동
	@GetMapping("/member/email_search.do")
	public void email_search() {}
	
	//아이디찾기 메소드 
	@PostMapping("/member/idsearch.do")
	public String idsearch(member_DTO m_dto, Model m) {
		String searchEmail = this.m_dao.id_search(m_dto); 
		
		if(searchEmail == null) {
			m.addAttribute("memail","가입하신 정보는 확인 되지 않습니다.");
		}else {
			m.addAttribute("memail",searchEmail);
		}
		return "/WEB-INF/views/search_myinfo";
	}
	
	
	//비번찾기 페이지로 이동
	@GetMapping("/member/passwd_search.do")
	public void passwd_search() {}
	
	//비번찾기 메소드(가입한 회원이 있는지 확인) 
	@PostMapping("/member/pwsearch.do")
	public String pwsearch(member_DTO m_dto, Model m) {
		int searchPw = this.m_dao.pw_search(m_dto); 

		if(searchPw == 0) {
			m.addAttribute("searchPw",searchPw);
			m.addAttribute("msg","입력하신 정보와 일치하는 회원이 없습니다.");
		}
		else {
			m.addAttribute("memail",m_dto.m_email);
			m.addAttribute("mphone",m_dto.m_phone);
		}
		
		return "/WEB-INF/views/search_mypass";
	}
	
	
	//비번변경 메소드 
	@PostMapping("/member/pwmodify.do")
	public String pwmodify(member_DTO m_dto, Model m) {
		
		String enc_pw = this.md5_make(m_dto.m_pass);
		m_dto.setM_pass(enc_pw);
		
		int result = this.m_dao.pw_modify(m_dto);  //dto에 세팅된 값 전달 
		System.out.println("result : " + result);
		
		if(result>0) {
			this.msg = "alert('비밀번호 변경이 완료되었습니다. 로그인해주세요!');"
							+"location.href='./login.do';";
		}else {
			this.msg = "alert('시스템문제로 비밀번호 변경에 실패했습니다\\n관리자에게 문의하세요');"
							+"history.go(-1);";
		}
		m.addAttribute("msg",this.msg);
		
		return "/common/alert_msg";
	}
	
}
