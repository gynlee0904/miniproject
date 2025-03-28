package miniproject;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository("mfile")
public class m_file {
	public String file_rename(String filenm) {
	
		
		//속성(파일확장자)
		int com = filenm.lastIndexOf(".");  //.기준으로 앞의 글자 개수 확인
		String fnm = filenm.substring(com); //.확장자 
	
		Date day = new Date();  //날짜 가져옴
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String today = sf.format(day);
		
		int no = (int)Math.ceil(Math.random()*1000);  //랜덤숫자 
		String makeFileRenm = today+no+fnm;

		return makeFileRenm;
	}
}
