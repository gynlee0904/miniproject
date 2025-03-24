package member;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class member_DAO {
	
	@Resource(name="template")    
	public SqlSessionTemplate st;
	
	public int member_join(member_DTO m_dto) {
		System.out.println(m_dto.m_email);
		int result = this.st.insert("member_insert",m_dto);
		return result;
	}
	
}
