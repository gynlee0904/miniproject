package mdchoice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface md_mapper {
	List<md_DTO> md_allList(Integer pgno,Integer post_ea);  //md_choice(추천매물) 전체리스트 출력 메소드
	int md_viewcnt(String midx);  //추천매물 조회수 
	md_DTO md_oneProduct(String midx); //추천매물 게시글 상세보기
	int md_list_total(); //추천매물 게시글 총 개수 
	List<md_DTO> search_post(String md_search, Integer pgno, Integer post_ea); //추천매물 게시글 검색
	int md_slist_total(String keyword); //추천매물 게시글 총개수
	int md_board_write(md_DTO m_dto); //추천매물 게시판 글쓰기 
	
	
	
	
}

