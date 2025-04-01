package reservation;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface reservation_mapper {
	int reservation_insert(reservation_DTO r_DTO);  //방문예약등록 메소드
	int dupl_rsv_ck(reservation_DTO r_DTO);  //중복예약확인 메소드
	int ridx_check(reservation_DTO r_DTO);  //예약한 정보의 고유값 확인
//	int rinfo_ck(reservation_DTO r_DTO);
	reservation_DTO reservation_check(String ridx);  //방문예약 내용확인 메소드
}
