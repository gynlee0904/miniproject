package member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface member_mapper {
	public int member_insert(member_DTO m_dto);  //회원가입 메소드 
	member_DTO member_login(member_DTO m_dto);  //로그인 메소드
	String id_search(member_DTO m_dto);  //아이디찾기 메소드
	int pw_search(member_DTO m_dto);  //비번찾기 메소드
	int pw_modify(member_DTO m_dto);  //비번수정 메소드
	
	
	
}
