package miniproject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import DTO.file_DTO;

@Repository("mfile")
public class m_file {
	@Resource(name="fileDTO") file_DTO f_dto;
	
	String file_rnm = null;
	
	public file_DTO filesave(file_DTO f_dto, MultipartFile thumbImg, HttpServletRequest req, String savePath) throws IOException {
		this.file_rnm = this.file_rename(thumbImg.getOriginalFilename());  //원래파일명 리네임메소드에 전달 
		
		f_dto.setFileRenm(this.file_rnm);  //새로 붙인 파일명 dto에 저장  
		f_dto.setFilenm(thumbImg.getOriginalFilename());  // 원래파일명 dto에 저장 
		
		String filePath = req.getServletContext().getRealPath(savePath);
		
		File dir = new File(filePath);		
		if (!dir.exists()) { //해당 경로가 없을경우
		    dir.mkdirs(); // 폴더 생성
		}
		
		FileCopyUtils.copy(thumbImg.getBytes(),new File(filePath+this.file_rnm));  //웹디렉톨에 리네임한 파일명으로 저장 
		f_dto.setImgPath(savePath+this.file_rnm);  //웹디렉토리 경로+리네임 파일명 dto에 저장
		
		
		return f_dto;
	}
	
	
	//파일 리네임 메소드
	public String file_rename(String filenm) {
		//속성(파일확장자)
		int sub = filenm.lastIndexOf(".");  
		String ext = filenm.substring(sub);  
	
		Date date = new Date();  
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String today = sf.format(date);
		
		int no = (int)Math.ceil(Math.random()*1000);  
		String makeFileRenm = today+no+ext;

		return makeFileRenm;
	}
}
