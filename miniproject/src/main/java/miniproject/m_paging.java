package miniproject;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("paging")
public class m_paging {

	int startp = 0; //limit시작번호 
	int clickPage = 0;  //사용자가 클릭한 페이지번호에 맞는 게시글 순차번호 계산값
	
	//게시물 일련번호 계산
	public int serial_no(int pageno, Integer post_ea)  {
		
		if(pageno == 1) {
			this.clickPage = 0;
		}else {  //1외의 다른 페이지를 클릭시
			this.clickPage = (pageno -1) * post_ea;
		}
		
		return this.clickPage;
	}
	
	
	public Map<String, Object> paging (Integer pageno, Integer post_ea)  {
		/* 1p 클릭 => limit 0,10
		   2p 클릭 => limit 10,10
		   3p 클릭 => limit 20,10
		   ...
		*/
		this.startp = (pageno-1)* post_ea;  //limit 시작번호
		
		Map<String, Object> page = new HashMap<String, Object>(); 
		page.put("start_p" , this.startp);  //limit의 시작번호 
		page.put("post_ea" , post_ea);  //limit의 두번째 번호
		
		return page;
	}
}
