package mdchoice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import miniproject.m_paging;

@Repository("mdDAO")
public class md_DAO implements md_mapper {
	@Resource(name="template") 
	public SqlSessionTemplate st;
	
	@Resource(name="paging") 
	public m_paging pg;
	
	//게시글 총 개수
	@Override
	public int md_list_total(String condition, String keyword) {
		Map<String, Object> info = new HashMap<String, Object>();
		if(condition.equals("yester")) {
			info.put("part", "yesterday");
			
		}else if(condition.equals("daily")) {
			info.put("part", "today");
			
		}else if(condition.equals("lastweekly")) {
			info.put("part", "lastweek");
			
		}else if(condition.equals("thisweekly")) {
			info.put("part", "thisweek");
			
		}else if(condition.equals("search")) {
			info.put("part", "search");
			info.put("md_search", keyword);
		}else {
			info.put("part", "total");
		}
		int result = this.st.selectOne("md_list_total",info);
		return result;
	}
	
	//md_choice 전체리스트 출력 메소드
	@Override
	public List<md_DTO> md_allList(Integer pgno,Integer post_ea) { 
		Map<String, Object> info = this.pg.paging(pgno, post_ea);
		
		List<md_DTO> md_allList = this.st.selectList("md_allList",info);
		return md_allList;
	}


	//추천매물게시글 조회수 
	@Override
	public int md_viewcnt(String midx) {
		int result = this.st.update("md_viewcnt", midx);
		return result;
	}

	//추천매물 게시글 상세보기
	@Override
	public md_DTO md_oneProduct(String midx) {
		md_DTO md_one = this.st.selectOne("md_oneProduct", midx);
		return md_one;
	}

	
	//추천매물 게시글 검색
	@Override
	public List<md_DTO> search_post(String md_search, Integer pgno, Integer post_ea) {

		Map<String, Object> search_info = this.pg.paging(pgno, post_ea);
		search_info.put("md_search" , md_search);  //검색어

		List<md_DTO> search_list = this.st.selectList("md_search_post", search_info);
		return search_list;
	}

	//추천매물 게시판 글쓰기 
	@Override
	public int md_board_write(md_DTO m_dto) {
		int result = this.st.insert("md_board_write",m_dto);
		return result;
	}

	//추천매물 검색게시글 총개수
//	@Override
//	public int md_slist_total(String keyword) {
//		int result = this.st.selectOne("md_search_total", keyword);
//		return result;
//	}

	
	//추천매물 게시글 삭제
	@Override
	public int md_board_delete(String midx) {
		int result = this.st.delete("md_board_delete", midx);
		return result;
	}

	//추천매물 게시글 수정
	@Override
	public int md_board_modify(md_DTO mdto) {
		int result = this.st.update("md_modify", mdto);
		return result;
	}

	


	

}
