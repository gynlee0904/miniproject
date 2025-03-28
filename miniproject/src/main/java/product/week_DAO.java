package product;

import java.util.List;

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
		
}
