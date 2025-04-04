package reservation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import mdchoice.md_DTO;
import product.week_DTO;

@Repository("rsvDAO")
public class reservation_DAO implements reservation_mapper  {
	
	@Resource(name="template") public SqlSessionTemplate st;

	 //방문예약등록 메소드
	@Override
	public int reservation_insert(reservation_DTO r_DTO) {
		int result = this.st.insert("reservation_insert",r_DTO);
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
	
	@Override
	public Map<String,String> rinfo_ck(reservation_DTO r_DTO) {
		Map<String, Object> dupl_ck = new HashMap<String, Object>();
		dupl_ck.put("m_phone", r_DTO.m_phone);
		dupl_ck.put("aidx", r_DTO.aidx);
		dupl_ck.put("visit_date", r_DTO.visit_date);
		dupl_ck.put("visit_time", r_DTO.visit_time);
		
		Map<String,String> result = this.st.selectOne("rinfo_ck",dupl_ck);
		return result;
	}
		
	//방문예약 내용확인 메소드
	@Override
	public Map<String, String> reservation_check(String ridx) {
		Map<String, String> result = this.st.selectOne("reservation_check",ridx);
		return result;
	}

	//예약여부 확인 메소드 
	@Override
	public reservation_DTO rsv_ck(String mphone, String aidx) {
		Map<String, Object> rsv_ck = new HashMap<String, Object>();
		rsv_ck.put("m_phone", mphone);
		rsv_ck.put("aidx", aidx);
		reservation_DTO result = this.st.selectOne("rsv_ck",rsv_ck);
		return result;
	}


	//방문예약리스트 확인 메소드
	@Override
	public List<reservation_DTO> rsv_myList(String m_phone) {
		List<reservation_DTO> rsv_myList = this.st.selectList("rsv_myList",m_phone);
		return rsv_myList;
	}


	@Override
	public int rsv_cancel(String m_phone, String ridx) {
		Map<String, String> cancel_info = new HashMap<String, String>();
		cancel_info.put("m_phone", m_phone);
		cancel_info.put("ridx", ridx);
		
		int result = this.st.update("rsv_cancel",cancel_info);
		return result;
	}


	




	
	






	

}
