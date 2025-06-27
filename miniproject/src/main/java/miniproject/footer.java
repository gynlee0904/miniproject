package miniproject;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class footer{
	@Resource(name="template") 
	public SqlSessionTemplate st;
	
	
	@ModelAttribute
    public void footerInfo(Model m) {
		List<Map<String, Object>>footer_data =  Collections.emptyList();
		
		 try {
			 footer_data = this.st.selectList("miniproject.footer_info");
			 
			 
		 }catch(Exception e) {
			 System.err.println("footer_info 조회 실패: " + e.getMessage());
		 }
		 m.addAttribute("web_info", footer_data);
    }
}
