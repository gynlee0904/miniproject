package miniproject;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class footer{
	@Resource(name="template") public SqlSessionTemplate st;
	
	
	@ModelAttribute
    public void footerInfo(Model m) {
		List<String>footer_data = this.st.selectList("miniproject.footer_info");
        m.addAttribute("web_info", footer_data);
    }
}
