package reservation;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository("rsvDTO")
@Data
public class reservation_DTO {
	int ridx, aidx;
	String apt_name, visit_date, visit_time, m_name, visit_in, m_phone;
	String insert_date, modyfied_date;
}
