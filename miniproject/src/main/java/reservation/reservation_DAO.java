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
	public int reservation_insert(reservation_DTO r_DTO) {
		Map<String, Object> reserve_info = new HashMap<String, Object>();
		reserve_info.put("r_DTO", r_DTO);
		int result = this.st.insert("reservation_insert",r_DTO);
		return result;
	}
	
	
	//중복예약여부 확인 
	@Override
	public int dupl_rsv_ck(reservation_DTO r_DTO) {
		Map<String, Object> dupl_ck = new HashMap<String, Object>();
		dupl_ck.put("m_phone", r_DTO.m_phone);
		dupl_ck.put("aidx", r_DTO.aidx);
		dupl_ck.put("visit_date", r_DTO.visit_date);
		dupl_ck.put("visit_time", r_DTO.visit_time);
		
		int result = this.st.selectOne("dupl_ck",dupl_ck);
		return result;
	}
	
	//예약한 정보의 고유값 확인
	@Override
	public int ridx_check(reservation_DTO r_DTO) {
		Map<String, Object> ridx_ck = new HashMap<String, Object>();
		ridx_ck.put("m_phone", r_DTO.m_phone);
		ridx_ck.put("aidx", r_DTO.aidx);
		ridx_ck.put("visit_date", r_DTO.visit_date);
		ridx_ck.put("visit_time", r_DTO.visit_time);
		
		int result = this.st.selectOne("info_ck",ridx_ck);
		return result;
	}
	
//	@Override
//	public int rinfo_ck(reservation_DTO r_DTO) {
//		Map<String, Object> dupl_ck = new HashMap<String, Object>();
//		dupl_ck.put("m_phone", r_DTO.m_phone);
//		dupl_ck.put("aidx", r_DTO.aidx);
//		dupl_ck.put("visit_date", r_DTO.visit_date);
//		dupl_ck.put("visit_time", r_DTO.visit_time);
//		
//		int result = this.st.selectOne("rinfo_ck",dupl_ck);
//		return result;
//	}
		
	//방문예약 내용확인 메소드
	@Override
	public reservation_DTO reservation_check(String ridx) {
		reservation_DTO result = this.st.selectOne("reservation_check",ridx);
		return result;
	}

	
	






	

}
