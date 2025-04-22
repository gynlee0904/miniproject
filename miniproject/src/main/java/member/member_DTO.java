package member;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository("memberDTO")
public class member_DTO {
	int midx;
	String m_email, m_pass, m_name, m_phone;
	String m_agr1, m_agr2, m_agr3, m_agr4;
	String insert_date, modified_date; 
	String m_type;
	String kakao_id;

}
