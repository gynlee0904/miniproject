package product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import mdchoice.md_DTO;

@Mapper
public interface week_mapper {
	List<week_DTO> wk_allList();  //weekinfo 전체리스트 출력 메소드
	
	week_DTO week_one(String aidx, String apt_name);  //weekinfo 개별상품 디테일보기 메소드
	
}
