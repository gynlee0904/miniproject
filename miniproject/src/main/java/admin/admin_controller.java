package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import DTO.chart_DTO;
import cms.cms_DAO;
import cms.cms_DTO;
import mdchoice.md_DAO;
import mdchoice.md_DTO;
import miniproject.m_logincheck;
import reservation.reservation_DTO;

@CrossOrigin(origins="*", allowedHeaders = "*") 
@Controller
public class admin_controller {
	@Autowired 
	HttpSession se;
	
	@Resource(name="admDAO") admin_DAO a_dao;
	@Resource(name="mdDAO") md_DAO m_dao;
	@Resource(name="cmsDAO") cms_DAO c_dao;
	@Resource(name="loginck") m_logincheck loginck;  //로그인체크 모델 
	
	PrintWriter pw =null;	
	String msg = "";
	int result= 0;

	
	//관리자페이지 로그인화면 이동 
	@GetMapping("/admin/admin.do")
	public String admin_login(Model m) {
		String login_yn = this.loginck.adminck();  //로그인 체크
		if(login_yn.equals("adm")){  //로그인 이미 되어있으면
			
			return "redirect:/admin/admin_main.do";
		}	
		return "/admin/admin_login";
	}
		
	//관리자 로그인 메소드 
	@PostMapping("/admin/admin_login_ok.do")
	public String login_ok(admin_DTO a_dto, HttpServletRequest req, Model m) throws Exception {
		
		admin_DTO loginAdmin = this.a_dao.admin_login(a_dto); 
		
		if(loginAdmin == null){  //아이디 및 패스워드가 틀릴경우 	
			
			this.msg="alert('로그인에 실패했습니다.\\n 아이디 및 패스워드를 다시 확인하세요!'); "
					+ "history.go(-1);";
			
		}
		else {    //로그인 후 회원정보 세션에 저장 
			String aid = loginAdmin.aid;	
			String aname = loginAdmin.aname;
			String admin_yn = loginAdmin.admin_yn;

			this.se.setAttribute("aid", aid);  //아이디  
			this.se.setAttribute("aname", aname);  //이름
			this.se.setAttribute("admin_yn", admin_yn);  //관리자여부
			
			this.msg="alert('"+aname+"관리자님 환영합니다!'); "
					+ "location.href='./admin_main.do';";

		} 
		m.addAttribute("msg", this.msg);
		
		return "/common/alert_msg";
	}
	
	
	//관리자 로그아웃 메소드 
	@GetMapping("/admin/logout.do")
	public String logout(Model m) {
				
		this.se.invalidate(); //세션에 저장된 정보들 파기 
		
		this.msg="alert('로그아웃 되었습니다.'); "
				+ "location.href='./admin.do';";
		
		m.addAttribute("msg", this.msg);
		
		return "/common/alert_msg";
	}
	
	
	//관리자페이지 메인 이동 
	@GetMapping("/admin/admin_main.do")
	public String adm_main(Model m) {
		//전일 등록된 추천매물수 
		int yesterday_total = this.m_dao.md_list_total("yester","");
		//당일 등록된 추천매물수 
		int today_total = this.m_dao.md_list_total("daily","");

		m.addAttribute("yesterday_total",yesterday_total);
		m.addAttribute("today_total",today_total);
		
		return null;
	}
	
	
	//오늘 등록된 추천매물수(ajax)
//	@ResponseBody  //응답에 대한 결과값을 해당 메소드에 바로 출력할 때 사용 
	@GetMapping("/admin/md_compare.do")
	public String product_today(HttpServletResponse res) throws IOException {
		this.pw = res.getWriter();
		
		//전일 등록된 추천매물수 
		int yesterday_total = this.m_dao.md_list_total("yester","");
		//당일 등록된 추천매물수 
		int today_total = this.m_dao.md_list_total("daily","");
		
		JSONObject mdCntData = new JSONObject();
		mdCntData.put("yesterday_total",yesterday_total);
		mdCntData.put("today_total",today_total);
	
		this.pw.print(mdCntData);
		this.pw.close();
		
		return null;
	}
	
	//이번주 등록된 추천매물수(ajax)
	@GetMapping("/admin/md_compare_week.do")
	public String product_week (HttpServletResponse res) throws IOException {
		this.pw = res.getWriter();
		
		int lastweekly_total = this.m_dao.md_list_total("lastweekly","");
		int thisweekly_total = this.m_dao.md_list_total("thisweekly","");
		
		JSONObject mdCntData = new JSONObject();
		mdCntData.put("lastweekly_total",lastweekly_total);
		mdCntData.put("thisweekly_total",thisweekly_total);
		
		this.pw.print(mdCntData);
		this.pw.close();
		
		return null;
	}
	

	//상담문의건 임대형태 수량비교
	@GetMapping("/admin/donut_chart1.do")
	public String donut_chart1(Model m, HttpServletResponse res) throws IOException {
		res.setContentType("text/html;charset=utf-8");
		this.pw = res.getWriter();
		
		List<cms_DTO> rental_type = this.c_dao.rental_type();

		JSONObject jo = new JSONObject();  //대표키 만드는 애
		JSONObject jo2 = new JSONObject();  //보조키(서브키) 만드는애 
		JSONArray ja = new JSONArray();  //데이터 배열[]
		JSONArray ja2 = new JSONArray();
		for(int f=0; f<rental_type.size(); f++) {
			ja.put(rental_type.get(f).getCategory());  
			ja2.put(rental_type.get(f).getCnt());    
			
		}
		jo.put("category", ja);
		jo.put("count", ja2);
		
		jo2.put("rental",jo);  
		
		this.pw.print(jo2);
		this.pw.close();
		
		return null;
	}
	
	
	
	
	//날짜별 매물등록수, 방문예약수
	@GetMapping("/admin/column_chart.do")
	public String column_chart(HttpServletResponse res, md_DTO mdto, reservation_DTO rdto) throws IOException {
		res.setContentType("text/html;charset=utf-8");
		this.pw = res.getWriter();

		List<chart_DTO> dayCountList = this.a_dao.dayCountList();
		
		JSONObject jo = new JSONObject();  //보조키(서브키)
		JSONObject jo2 = new JSONObject();  //대표키
		JSONArray ja = new JSONArray();  //데이터 배열[]
		JSONArray ja2 = new JSONArray();
		JSONArray ja3 = new JSONArray();
		
		for(int f=0; f<dayCountList.size(); f++) {
			ja.put(dayCountList.get(f).getDate());  
			ja2.put(dayCountList.get(f).getMd_cnt());   
			ja3.put(dayCountList.get(f).getRv_cnt()); 
			
		}
		jo.put("date", ja);
		jo.put("md_cnt", ja2);
		jo.put("rv_cnt", ja3);
		
		jo2.put("dayCountList",jo); 

		this.pw.print(jo2);
		this.pw.close();
		
		return null;
	}
	
	
}
