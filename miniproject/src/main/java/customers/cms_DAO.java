package customers;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("cmsDAO")
public class cms_DAO {
	@Resource(name="template") public SqlSessionTemplate st;
	
	
}
