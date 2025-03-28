package mdchoice;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("mdDAO")
public class md_DAO implements md_mapper {
	@Resource(name="template") public SqlSessionTemplate st;

	//md_choice 전체리스트 출력 메소드
	@Override
	public List<md_DTO> md_allList() {
		List<md_DTO> md_allList = this.st.selectList("md_allList");
		return md_allList;
	}

	
	

}
