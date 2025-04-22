package admin;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("admDTO")
public class admin_DTO {
	int aidx;
	String aid, apass, aname, aphone, aemail, admin_yn;
	
}
