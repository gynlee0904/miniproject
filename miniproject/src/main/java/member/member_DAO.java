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
	
	Map<String, String> user_info = null;

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
		this.user_info = new HashMap<String, String>();
		
		if(m_dto.getM_type().equals("WEB")) {  //web가입자일 때 
			this.user_info.put("part", "web_login");
			this.user_info.put("m_email", m_dto.getM_email());
			this.user_info.put("m_pass", m_dto.getM_pass());
			
		}else if(m_dto.getM_type().equals("KAKAO")){  //kakao가입자일 때
			this.user_info.put("part", "kakao_login");
			this.user_info.put("kakao_id", m_dto.getKakao_id());
	
		}else {
			this.user_info.put("part", "member_info");
			this.user_info.put("m_email", m_dto.getM_email());
		}
		
		member_DTO loginMember = this.st.selectOne("member_login",this.user_info);
		return loginMember;
	}

	
	//가입형태 확인 
	@Override
	public String kakao_yn(member_DTO m_dto) {
		this.user_info = new HashMap<String, String>();
		System.out.println("m_email : "+ m_dto.getM_email());
		System.out.println("phone : "+ m_dto.getM_phone());
		System.out.println("name : "+ m_dto.getM_name());
		
		if(m_dto.getM_email()==null) {  //아이디찾기할때
			this.user_info.put("part", "idsearch");
			this.user_info.put("m_name", m_dto.getM_name());
			this.user_info.put("m_phone", m_dto.getM_phone());
			
		}else if(m_dto.getM_name()==null){  //비번찾기할때
			this.user_info.put("part", "pwsearch");
			this.user_info.put("m_email", m_dto.getM_email());
			this.user_info.put("m_phone", m_dto.getM_phone());
			
		}
		
		String m_type_ck = this.st.selectOne("mtypeck",this.user_info);
		return m_type_ck;
	}
	
	
	//아이디찾기 메소드
	@Override
	public String id_search(member_DTO m_dto) {
		this.user_info = new HashMap<String, String>();
		
		this.user_info.put("m_name",m_dto.m_name); 
		this.user_info.put("m_phone",m_dto.m_phone);

		String user_email = this.st.selectOne("id_search",this.user_info);
		return user_email;
	}

	//비밀번호 찾기 메소드
	@Override
	public int pw_search(member_DTO m_dto) {
		this.user_info = new HashMap<String, String>();
		this.user_info.put("m_email",m_dto.m_email); 
		this.user_info.put("m_phone",m_dto.m_phone);

		int user_pw = this.st.selectOne("pw_search",this.user_info);
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
