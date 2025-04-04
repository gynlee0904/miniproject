package reservation;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface reservation_mapper {
	reservation_DTO rsv_ck(String mphone, String aidx);  //예약여부 확인 메소드
	int reservation_insert(reservation_DTO r_DTO);  //방문예약등록 메소드
	int ridx_check(reservation_DTO r_DTO);  //예약한 정보의 고유값 확인
	Map<String,String> rinfo_ck(reservation_DTO r_DTO);
	Map<String, String> reservation_check(String ridx);  //방문예약 내용확인 메소드
	List<reservation_DTO> rsv_myList(String m_phone);  //방문예약리스트 확인 메소드
	int rsv_cancel(String pn, String ridx);  //방문예약 취소 메소드 
}
