package mdchoice;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository("mdDTO")
@Data
public class md_DTO {
	int midx, md_view;
	String md_title, md_content;
	String md_filenm, md_fileRenm, md_imgpath, md_link;
	String insert_date, modyfied_date;
}