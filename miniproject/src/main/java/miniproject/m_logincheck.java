package miniproject;

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
	
	public String loginck() {
		String mid = (String)this.se.getAttribute("mid");
		String mname = (String)this.se.getAttribute("mname");
		String mphone = (String)this.se.getAttribute("mphone");
		
		System.out.println("mid : " + mid);
		System.out.println("mname : " + mname);
		System.out.println("mphone : " +mphone);
		
		if(mid==null || mname==null || mphone==null ) {
			this.msg = "no";
		}
		else {
			this.msg = "ok";
		}
		return this.msg;
		
	}
	
}
