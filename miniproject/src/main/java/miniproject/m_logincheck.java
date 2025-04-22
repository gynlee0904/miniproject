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
	
	
	PrintWriter pw = null;
	
	public String loginck() {
		String mid = (String)this.se.getAttribute("mid");
		String mname = (String)this.se.getAttribute("mname");
		String mphone = (String)this.se.getAttribute("mphone");
		
		if(mid==null || mname==null || mphone==null) {
			this.msg = "no";
			
		}
		else {
			
			this.msg = "ok";
		}
		
		System.out.println("lgin.msg : "+this.msg);
		return this.msg;
	}
	
	//관리자
	public String adminck() {
 
		String admin_yn = (String)this.se.getAttribute("admin_yn");

		if(admin_yn != null && admin_yn.equals("adms")){
			this.msg = "adm";
			
		}else {
			
			this.msg = "no";
		}
		System.out.println("this.admin_yn : "+admin_yn);
		System.out.println("adm.msg : "+this.msg);
		return this.msg;
	}
	
	
	

	
	
}
