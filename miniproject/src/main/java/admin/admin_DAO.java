package admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import DTO.chart_DTO;

@Repository("admDAO")
public class admin_DAO {
	@Resource(name="template")    
	public SqlSessionTemplate st;

	
	public admin_DTO admin_login(admin_DTO a_dto) {
		Map<String, String> admin_info = new HashMap<String, String>();
		admin_info.put("aid",a_dto.aid); 
		admin_info.put("apass",a_dto.apass);
		admin_info.put("admin_yn",a_dto.admin_yn);
		
		admin_DTO loginAdmin = this.st.selectOne("admin_login",admin_info);
		return loginAdmin;
	}
	
	
	public String adminck() {
		String adminck = this.st.selectOne("admin_ck");
		return adminck;
	}
	
	
	public List<chart_DTO> dayCountList() {
		List<chart_DTO> dayCountList = this.st.selectList("dayCountList");
		return dayCountList;
	}

}
