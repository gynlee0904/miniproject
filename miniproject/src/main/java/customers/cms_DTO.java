package customers;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository("cmsDTO")
@Data
public class cms_DTO {
	int cidx;
	String c_name, c_email, c_phone, rental_type, apt_type;
	String counsel_date, counsel_content, insert_date, complete;
}
