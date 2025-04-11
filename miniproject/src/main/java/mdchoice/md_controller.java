package mdchoice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import DTO.file_DTO;
import admin.admin_DAO;
import admin.admin_DTO;
import miniproject.m_file;
import miniproject.m_logincheck;
import miniproject.m_paging;

@Repository("md_controller")
@Controller
public class md_controller  {
	@Resource(name="mdDAO") md_DAO m_dao;
	@Resource(name="mdDTO") md_DTO m_dto;
	@Resource(name="admDAO") admin_DAO a_dao;
	@Resource(name="admDTO") admin_DTO a_dto;
	
	@Resource(name="loginck") m_logincheck loginck;  //로그인체크 모델 
	@Resource(name="mfile") m_file mfile;  //파일첨부, 파일명리네임 모델 
	@Resource(name="fileDTO") file_DTO f_dto;
	@Resource(name="paging") m_paging paging;
	
	PrintWriter pw = null;
	String msg = "";
	String url = null;
	int result = 0;
	
	//md_board 리스트로 이동 
	@GetMapping("/board/md_board.do")
	public String md_board_list(Model m, 
								@RequestParam(defaultValue="", required=false)String keyword,
								@RequestParam(defaultValue="1", required=false)Integer pageno) {
		
		String login_yn = this.loginck.loginck();  //로그인 체크
		String admin_yn = this.loginck.adminck();  //관리자여부 체크
		
		if(login_yn.equals("ok") || admin_yn.equals("adm")) {  //로그인 되어있으면 추천매물 페이지로 이동
			Integer post_ea = 10;  //한페이지당 보여줄 게시물 개수 
			
			int list_total = this.m_dao.md_list_total();  //게시물 총 개수 
			int clickPage = this.paging.serial_no(pageno, post_ea);  
			Map<String, Object> paging = this.paging.page_ea(pageno, post_ea, list_total);

			//총 게시물 리스트
			List<md_DTO> md_allList = null;
			if(keyword.equals("")) { //검색어가 없을 경우
				md_allList = this.m_dao.md_allList(pageno,post_ea);  //인자값=>사용자가 클릭한 페이지번호 전달
				
			}else {  //검색어가 있을 경우 
				list_total = this.m_dao.md_slist_total(keyword);  //검색된 게시물 총 개수
				md_allList = this.m_dao.search_post(keyword, pageno, post_ea);
				paging = this.paging.page_ea(pageno, post_ea, list_total);
				System.out.println("paging : "+paging);
			}
			
			
			m.addAttribute("paging",paging);
			m.addAttribute("pageno",pageno);
			m.addAttribute("clickPage",clickPage);  //페이지번호 클릭시 나오는 게시글 일련번호
			m.addAttribute("list_total",list_total);  //데이터 전체개수 
			m.addAttribute("keyword",keyword); //검색어 
			m.addAttribute("md_allList", md_allList);  //게시글 총 리스트
			
		}
		else if(login_yn.equals("no") || !admin_yn.equals("adm")){  //로그인 안되어있으면
			this.msg = "alert('로그인 후 이용 가능합니다. \\n 로그인 해주세요!'); "
					+ "location.href='../member/login.do';";

			m.addAttribute("msg", this.msg);
			this.url =  "/common/alert_msg";
		
		}

		return this.url;
	}
	
	//추천매물 게시글 상세보기
	@GetMapping("/board/md_board_view.do")
	public String md_detail(@RequestParam String midx, Model m) {
		String login_yn = this.loginck.loginck();  //로그인 체크

		
		if(login_yn.equals("no")){  //로그인 안되어있으면
			this.msg = "alert('로그인 후 이용 가능합니다. \\n 로그인 해주세요!'); "
								+ "location.href='../member/login.do';";
			
			m.addAttribute("msg", this.msg);
			this.url =  "/common/alert_msg";
			
		} else {
			
			this.result  = this.m_dao.md_viewcnt(midx);  //조회수 +1
			md_DTO md_one = this.m_dao.md_oneProduct(midx);  //특정게시물 내용 가져오기
//			String admin_yn = this.a_dao.adminck();
			
			if(md_one.equals(null)) {

				this.msg = "alert('시스템문제가 발생했습니다 \\n 관리자에게 문의하세요'); history.go(-1);";
				this.url =  "/common/alert_msg";
				
			}else {
//				m.addAttribute("adminck", admin_yn);
				m.addAttribute("md_one", md_one);
			}
		}
		return this.url;
		
	}
	
	
	//추천매물 게시판 글쓰기 
	@PostMapping("/board/md_board_write.do")
	public String md_board_write(md_DTO m_dto, MultipartFile thumbImg,
								HttpServletRequest req, Model m) throws IOException {
		String savePath = "/md_file/";
		
		//파일첨부
		this.f_dto = this.mfile.filesave(this.f_dto, thumbImg, req, savePath);
		m_dto.setMd_filenm(this.f_dto.getFilenm());
		m_dto.setMd_fileRenm(this.f_dto.getFileRenm());
		m_dto.setMd_imgpath(this.f_dto.getImgPath());
		
		this.result = this.m_dao.md_board_write(m_dto);
		if(this.result > 0) {  //글 등록 완료 
			this.msg = "alert('추천분양 정보 게시판 게시물이 추가 되었습니다'); location.href='../board/md_board.do';";
			
		}else {  //등록 실패 
			this.msg = "alert('시스템 문제로 글 등록에 실패했습니다 \\n 관리자에게 문의해주세요.'); history.go(-1);";
		}
		
		m.addAttribute("msg",this.msg);
		return "/common/alert_msg";
	}
	
	
	
	
	

}
