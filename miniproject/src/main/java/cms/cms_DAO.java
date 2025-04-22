package cms;

import java.util.List;

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

	@Override
	public List<cms_DTO> rental_type() {
		List<cms_DTO> rental_type = this.st.selectList("rental_type");
		return rental_type;
	}

	
	
}
