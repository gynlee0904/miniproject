package reservation;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("rsvDAO")
public class reservation_DAO implements reservation_mapper  {
	
	@Resource(name="template") public SqlSessionTemplate st;

	 //방문예약등록 메소드
	@Override
	public int reservation_insert(reservation_DTO r_DTO, String m_email) {
		Map<String, Object> reserve_info = new HashMap<String, Object>();
		reserve_info.put("r_DTO", r_DTO);
		reserve_info.put("m_email", m_email);
		int result = this.st.insert("reservation_insert",reserve_info);
		return result;
	}

	
	//방문예약 내용확인 메소드
	@Override
	public reservation_DTO reservation_check(reservation_DTO r_DTO) {
	
		return null;
	}

	

}
