package miniproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class main_controller {

	@GetMapping("/realty/index.do")
	public void index() {}
	
	@GetMapping("/realty/member/login.do")
	public void login() {}
	
	@GetMapping("/realty/member/member_join.do")
	public void member_join() {}
	
	
	
	
}


