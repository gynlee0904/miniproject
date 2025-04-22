package DTO;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("chart_DTO")
public class chart_DTO {

	String date;
	int md_cnt, rv_cnt;
}
