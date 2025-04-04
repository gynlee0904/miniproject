package product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import mdchoice.md_DTO;

@Repository("wkDAO")
public class week_DAO implements week_mapper{
	@Resource(name="template") public SqlSessionTemplate st;
	
	//weekinfo 전체리스트 출력 메소드
	@Override
	public List<week_DTO> wk_allList() {
		List<week_DTO> wk_allList = this.st.selectList("wk_allList");
		return wk_allList;
	}

	//weekinfo 개별상품 디테일보기 메소드
	@Override
	public week_DTO week_one(String aidx, String apt_name) {
		Map<String, Object> pd_info = new HashMap<String, Object>();
		pd_info.put("aidx" , aidx);
		pd_info.put("apt_name" , apt_name);
		
		week_DTO week_one = this.st.selectOne("wk_oneProduct",pd_info);
		return week_one;
	}



	
		
}
