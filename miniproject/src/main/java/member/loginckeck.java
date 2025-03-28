package member;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
//로그인 여부 체크 모델
@Repository("loginck")
public class loginckeck {
	public String loginck(HttpSession session) {
		String mid = (String)session.getAttribute("mid");
		String mname = (String)session.getAttribute("mname");
		String mphone = (String)session.getAttribute("mphone");
		
		String msg = "";
		if(mid==null || mname==null || mphone==null ) {
			msg = "no";
		}
		else {
			msg = "ok";
		}
		return msg;
		
	}
}
