package miniproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttribute;
	

//로그인 여부 체크 모델
@Repository("loginck")
public class m_logincheck {
	
	@Autowired 
	HttpSession se;
	
	String msg = "";
	String url = null;
	
	PrintWriter pw = null;
	
	public String loginck() {
		String mid = (String)this.se.getAttribute("mid");
		String mname = (String)this.se.getAttribute("mname");
		String mphone = (String)this.se.getAttribute("mphone");
		
		System.out.println(mid);
		System.out.println(mname);
		System.out.println(mphone);

		if(mid==null || mname==null || mphone==null ) {
			this.msg = "no";
		}
		else {
			this.msg = "ok";
		}
		return this.msg;
	}
	
//	public String loginyes()  {
//		String login_yn = this.loginck();
//		System.out.println("로그인여부 : "+login_yn);
//		
//		if(login_yn.equals("no")) {
//			this.msg="";
//
//		} else {
//			this.msg = "ok";
//			
//		}
//		return this.msg;
//		
//	}
	
	
	
}
