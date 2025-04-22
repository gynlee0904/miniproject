package member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface member_mapper {
	int member_insert(member_DTO m_dto);  //회원가입 메소드 
	int eml_check(String m_email);  //아이디 중복체크 메소드
	int phn_check(String m_phone);  //폰번 중복체크 메소드
	member_DTO member_login(member_DTO m_dto);  //로그인 메소드
	String kakao_yn(member_DTO m_dto);  //가입 형태 확인 
	String id_search(member_DTO m_dto);  //아이디찾기 메소드
	int pw_search(member_DTO m_dto);  //비번찾기 메소드
	int pw_modify(member_DTO m_dto);  //비번수정 메소드
}
