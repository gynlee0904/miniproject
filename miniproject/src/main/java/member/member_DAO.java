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
	
	//아이디 중복체크
	@Override
	public int eml_check(String m_email) {
		int result = this.st.selectOne("id_check",m_email);
		return result;
	}

	//폰번 중복체크
	@Override
	public int phn_check(String m_phone) {
		int result = this.st.selectOne("phn_check",m_phone);
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

	//아이디찾기 메소드
	@Override
	public String id_search(member_DTO m_dto) {
		Map<String, String> user_info = new HashMap<String, String>();
		user_info.put("m_name",m_dto.m_name); 
		user_info.put("m_phone",m_dto.m_phone);

		String user_email = this.st.selectOne("id_search",user_info);
		return user_email;
	}

	//비밀번호 찾기 메소드
	@Override
	public int pw_search(member_DTO m_dto) {
		Map<String, String> user_info = new HashMap<String, String>();
		user_info.put("m_email",m_dto.m_email); 
		user_info.put("m_phone",m_dto.m_phone);

		int user_pw = this.st.selectOne("pw_search",user_info);
		return user_pw;
	}

	//비밀번호 수정 메소드
	@Override
	public int pw_modify(member_DTO m_dto) {
		Map<String, Object> user_info = new HashMap<String, Object>();
		user_info.put("m_pass",m_dto.m_pass); 
		user_info.put("midx",m_dto.midx); 
		user_info.put("m_email",m_dto.m_email); 
		user_info.put("m_phone",m_dto.m_phone);
		
		int result = this.st.update("pw_modify",user_info);
		return result;
	}

	




	
	
}
