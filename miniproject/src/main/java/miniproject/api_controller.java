package miniproject;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mdchoice.md_DAO;
import mdchoice.md_DTO;


@RestController
public class api_controller<T> {
	@Resource(name="mdDAO") md_DAO m_dao;
	@Resource(name="mdDTO") md_DTO m_dto;
	
	PrintWriter pw = null; 

	
	@GetMapping("/api_angry.do")
	public String api_angry(HttpServletResponse res)throws Exception {
		res.setContentType("text/html;charset=utf-8");
		this.pw = res.getWriter();
		
		
		
		
		
		return null;
	}
	
//	@GetMapping("/")
//    public ResponseEntity<?> view() {
//        return new ResponseEntity<>(this.m_dao.md_allList(), HttpStatus.OK);
//    }


}
