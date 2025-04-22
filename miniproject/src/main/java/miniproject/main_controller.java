package miniproject;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mdchoice.md_DAO;
import mdchoice.md_DTO;
import product.week_DAO;
import product.week_DTO;


@Controller
public class main_controller{
	PrintWriter pw = null;
	@Resource(name="wkDAO") week_DAO w_dao;
	@Resource(name="mdDAO") md_DAO m_dao;
	@Resource(name="loginck") m_logincheck loginck;  //로그인체크 모델 
	
	String msg = "";
	String url = null;
	
	
	//메인페이지로 접속 
	@GetMapping("/index.do")
	public void index(Model m){
		
		//weekinfo 전체리스트 출력 메소드
		List<week_DTO> wk_allList = this.w_dao.wk_allList();
		
		//md_choice 전체 출력 메소드 
		Integer post_ea = 4;
		List<md_DTO> md_allList = this.m_dao.md_allList(1,post_ea);
		
		
		m.addAttribute("wk_allList", wk_allList);
		m.addAttribute("md_allList", md_allList);
	}
	
	
	//로그인페이지로 이동
	@GetMapping("/member/login.do")
	public String login(Model m) {
		String login_yn = this.loginck.loginck();  //로그인 체크
		if(login_yn.equals("ok")){  //로그인 이미 되어있으면
			this.msg="history.go(-1);";
			m.addAttribute("msg",this.msg);
			this.url="/common/alert_msg";
		}	
		return this.url;
	}
	
	//회원가입 페이지로 이동
	@GetMapping("/member/member_join.do")
	public String member_join(Model m) {
		String login_yn = this.loginck.loginck();  //로그인 체크
		if(login_yn.equals("ok")){  //로그인 이미 되어있으면
			this.msg="history.go(-1);";
			m.addAttribute("msg",this.msg);
			this.url="/common/alert_msg";
		}	
		return this.url;
	}

	
	//(임시)추천매물 글쓰기 페이지로 이동
	@GetMapping("/board/md_board_write.do")
	public String md_board_write(Model m) {
		String adm_ck = this.loginck.adminck();  //로그인 체크
		
		if(!adm_ck.equals("adm")) {  //관리자가 아닐경우
			this.msg = "alert('관리자만 글쓰기 권한이 있습니다.'); history.go(-1);";
			m.addAttribute("msg",this.msg);
			return "/common/alert_msg";
		}
		
		return null;
	}
}


