package DTO;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository("fileDTO")
@Data
public class file_DTO {
	String filenm, fileRenm, imgPath;
}
