package mdchoice;

import java.io.PrintWriter;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository("md_controller")
@Controller
public class md_controller  {
	@Resource(name="mdDAO") md_DAO m_dao;
	@Resource(name="mdDTO") md_DTO m_dto;

	PrintWriter pw = null;
	
	
	
	

}
