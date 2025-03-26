package miniproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class main_controller {

	//메인페이지로 이동
	@GetMapping("/index.do")
	public void index() {}
	
	//로그인페이지로 이동
	@GetMapping("/member/login.do")
	public void login() {}
	
	//회원가입 페이지로 이동
	@GetMapping("/member/member_join.do")
	public void member_join() {}

	
	
}


