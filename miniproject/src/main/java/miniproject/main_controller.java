package miniproject;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mdchoice.md_DAO;
import mdchoice.md_DTO;
import product.week_DAO;
import product.week_DTO;


@Controller
public class main_controller {
	PrintWriter pw = null;
	@Resource(name="wkDAO") week_DAO w_dao;
	@Resource(name="mdDAO") md_DAO m_dao;
	
	String msg = "";
	
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
	public void login() {}
	
	//회원가입 페이지로 이동
	@GetMapping("/member/member_join.do")
	public void member_join() {}

	
	//(임시)추천매물 글쓰기 페이지로 이동
	@GetMapping("/board/md_board_write.do")
	public void md_board_write() {}
	
	
	
}


