package reservation;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository("rsvDTO")
@Data
public class reservation_DTO {
	int ridx, aidx;
	String visit_date, visit_time, m_name, visit_in, m_phone,reserve_yn;
	String insert_date, modyfied_date;
	
	String aptnm;  //아파트 이름 
}
