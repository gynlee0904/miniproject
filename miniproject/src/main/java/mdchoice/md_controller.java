package mdchoice;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import miniproject.api_controller;

@Repository("md_controller")
@Controller
public class md_controller  {
	@Resource(name="mdDAO") md_DAO m_dao;
	@Resource(name="mdDTO") md_DTO m_dto;

	PrintWriter pw = null;
	
	
	
	

}
