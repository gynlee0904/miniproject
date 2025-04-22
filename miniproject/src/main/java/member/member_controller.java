package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import miniproject.m_encry;
import miniproject.m_logincheck;

@CrossOrigin(origins="*", allowedHeaders = "*")
@Controller
public class member_controller{
	@Autowired HttpSession session;
	
	@Resource(name="memberDAO") private member_DAO m_dao;
	@Resource(name="memberDTO") private member_DTO m_dto;
	@Resource(name="loginck") m_logincheck loginck;  //로그인체크 모델 
	@Resource(name="m_encry") m_encry encry;
	
	PrintWriter pw =null;	
	String msg = "";
	int result= 0;
	String url = null;
	
	
	//회원가입 메소드 
	@PostMapping("/member/member_ok.do")
	public String member_ok(member_DTO m_dto, 
								String[]m_agr,
								Model m) throws Exception {
		
		m_dto.setM_agr1(m_agr[0]);
		m_dto.setM_agr2(m_agr[1]);
		m_dto.setM_agr3(m_agr[2]);
		if(m_agr.length==3) { 
			m_dto.setM_agr4("N"); 
		}else {
			m_dto.setM_agr4(m_agr[3]);
		}

		String enc_pw = this.encry.md5_make(m_dto.m_pass);
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
	public String login_ok(member_DTO m_dto, @RequestParam(value="", required=false) String kakao_nm, 
							HttpServletRequest req, Model m) throws Exception {
		
		member_DTO loginMember = null; 
		
		//일반로그인일 때 
		if(m_dto.getM_type().equals("WEB")) {  
			String mid = m_dto.m_email;  //사용자 입력 id
			String mpw = m_dto.m_pass;  //사용자 입력 pw
			
			String enc_pw = this.encry.md5_make(mpw);//입력한 pw md5변환
			m_dto.setM_pass(enc_pw);  //dto에 세팅
			
			loginMember = this.m_dao.member_login(m_dto); 
			
			if(loginMember == null){  //아이디 및 패스워드가 틀릴경우 	
				this.msg="alert('로그인에 실패했습니다.\\n 아이디 및 패스워드를 다시 확인하세요!'); "
						+ "history.go(-1);";
			}
			else {    //로그인 후 회원정보 세션에 저장 
				String mname = loginMember.m_name;		
				String mphone = loginMember.m_phone;
				
				this.session.setAttribute("mid", mid);  //이메일  
				this.session.setAttribute("mname", mname);  //이름
				this.session.setAttribute("mphone", mphone);  //연락처
				
				this.msg="alert('"+mname+"님 환영합니다!'); "
						+ "location.href='../index.do';";
			} 
		}
		//카카오 로그인일때 
		else if(m_dto.getM_type().equals("KAKAO")) {  
			String kakao_id = m_dto.getKakao_id();
			
			loginMember = this.m_dao.member_login(m_dto); 
			
			if(loginMember == null){  //미가입 회원인 경우
				this.msg="alert('카카오 사용자로 로그인시 먼저 회원가입이 필요합니다.'); "
						+ "sessionStorage.setItem('mid','"+kakao_id+"');"
						+ "sessionStorage.setItem('mnick','"+kakao_nm+"');"
						+ "location.href='./member_join.do';";
			}
			else {    //로그인 후 회원정보 세션에 저장 
				String mid = loginMember.m_email; 
				String mname = loginMember.m_name;		
				String mphone = loginMember.m_phone;
				
				this.session.setAttribute("mid", mid); 
				this.session.setAttribute("mname", mname);
				this.session.setAttribute("mphone", mphone);
				
				this.msg="alert('"+mname+"님 환영합니다!'); "
						+ "location.href='../index.do';";
			} 		
		}
		
		m.addAttribute("msg", this.msg);
		
		return "/common/alert_msg";
	}
	
	
	//로그아웃 메소드 
	@GetMapping("/member/logout.do")
	public String logout(Model m) {
		
		this.session.invalidate(); //세션에 저장된 정보들 파기 
		
		this.msg="alert('로그아웃 되었습니다.'); "
				+ "location.href='../index.do';";
		
		m.addAttribute("msg", this.msg);
		
		return "/common/alert_msg";
	}
	
	
	//아이디찾기 페이지로 이동
	@GetMapping("/member/email_search.do")
	public String email_search(Model m) {
		this.url = null; //url변수 초기화
		String login_yn = this.loginck.loginck();  //로그인 체크
		
		if(login_yn.equals("ok")){ //로그인 이미 되어있으면
			this.msg="history.go(-1);";
			m.addAttribute("msg",this.msg);
			this.url="/common/alert_msg";
		}	
		return this.url;
	}
	
	//아이디찾기 메소드 
	@PostMapping("/member/idsearch.do")
	public String idsearch(member_DTO m_dto, Model m) {
		String kakao_yn = this.m_dao.kakao_yn(m_dto); 
		
		if(kakao_yn != null && kakao_yn.equals("KAKAO")) {  //카카오로그인 회원인 경우 
			this.msg="alert('님은 카카오 로그인 회원입니다. \\n 카카오로 로그인하세요.');"
					+ "location.href='./login.do';";
			m.addAttribute("msg",this.msg);
			this.url = "/common/alert_msg";
			
		}else {
			String searchEmail = this.m_dao.id_search(m_dto); 
			if(searchEmail == null) {
				m.addAttribute("memail","가입하신 정보는 확인 되지 않습니다.");
				this.url = "/WEB-INF/views/search_myinfo";
			}else {
				m.addAttribute("memail",searchEmail);
				this.url = "/WEB-INF/views/search_myinfo";
			}
		}
		
		return this.url;
	}
	
	
	//비번찾기 페이지로 이동
	@GetMapping("/member/passwd_search.do")
	public String passwd_search(Model m) {
		this.url = null;  //url변수 초기화
		String login_yn = this.loginck.loginck();  //로그인 체크
		
		if(login_yn.equals("ok")){  //로그인 이미 되어있으면
			this.msg="history.go(-1);";
			m.addAttribute("msg",this.msg);
			this.url="/common/alert_msg";
		}	
		return this.url;
	}
	
	//비번찾기 메소드(가입한 회원이 있는지 확인) 
	@PostMapping("/member/pwsearch.do")
	public String pwsearch(member_DTO m_dto, Model m) {
		String kakao_yn = this.m_dao.kakao_yn(m_dto); 
		
		if(kakao_yn != null && kakao_yn.equals("KAKAO")) {
			this.msg="alert('님은 카카오 로그인 회원입니다. \\n 카카오로 로그인하세요.');"
					+ "location.href='./login.do';";
			m.addAttribute("msg",this.msg);
			this.url = "/common/alert_msg";
			
		}else {
			int searchPw = this.m_dao.pw_search(m_dto); 
			
			if(searchPw == 0) {
				m.addAttribute("searchPw",searchPw);
				m.addAttribute("msg","입력하신 정보와 일치하는 회원이 없습니다.");
				this.url = "/WEB-INF/views/search_mypass";
			}
			else {
				m.addAttribute("memail",m_dto.m_email);
				m.addAttribute("mphone",m_dto.m_phone);
				this.url = "/WEB-INF/views/search_mypass";
			}
		}
		
		return this.url;
	}
	
	
	//비번변경 메소드 
	@PostMapping("/member/pwmodify.do")
	public String pwmodify(member_DTO m_dto, Model m) {
		
		String enc_pw = this.encry.md5_make(m_dto.m_pass);
		m_dto.setM_pass(enc_pw);
		
		int result = this.m_dao.pw_modify(m_dto);  //dto에 세팅된 값 전달 
		
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
