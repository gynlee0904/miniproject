package member;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class member_DAO implements member_mapper{
	
	@Resource(name="template")    
	public SqlSessionTemplate st;

	//회원가입 메소드
	@Override
	public int member_insert(member_DTO m_dto) {
		int result = this.st.insert("member_insert",m_dto);
		return result;
	}

	//로그인메소드
	@Override
	public member_DTO member_login(member_DTO m_dto) {
		Map<String, String> user_info = new HashMap<String, String>();
		user_info.put("m_email",m_dto.m_email); 
		user_info.put("m_pass",m_dto.m_pass);
		
		member_DTO loginMember = this.st.selectOne("member_login",user_info);
		return loginMember;
	}
	
}
