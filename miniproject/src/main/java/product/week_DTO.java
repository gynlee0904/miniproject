package product;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository("wkDTO")
@Data
public class week_DTO {
	int aidx, apt_view;
	String apt_name, apt_addr, apt_type, rental_type;
	String sale_date, move_in_date, apt_filenm, apt_fileRenm, apt_imgpath;
	String apt_strc, apt_gen, apt_ea, apt_company, apt_open;
	String insert_date, modyfied_date;

}
