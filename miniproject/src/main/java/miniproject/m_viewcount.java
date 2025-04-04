package miniproject;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import mdchoice.md_DAO;

@Repository("viewcnt")
public class m_viewcount {
	@Resource(name="mdDAO") md_DAO m_dao;

	int result = 0;
	public int view_count(String idx) {
		
		this.result = this.m_dao.md_viewcnt(idx);
		
		return this.result;
	}
	
}
