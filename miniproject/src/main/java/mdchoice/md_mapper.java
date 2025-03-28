package mdchoice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface md_mapper {
	List<md_DTO> md_allList();  //md_choice 전체리스트 출력 메소드
}

