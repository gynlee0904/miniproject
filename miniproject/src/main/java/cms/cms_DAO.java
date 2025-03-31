package cms;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("cmsDAO")
public class cms_DAO implements cms_mapper {
	@Resource(name="template") public SqlSessionTemplate st;

	@Override
	public int cms_insert(cms_DTO c_dto) {
		int result = this.st.insert("counsel_insert",c_dto);
		return result;
	}

	
	
}
