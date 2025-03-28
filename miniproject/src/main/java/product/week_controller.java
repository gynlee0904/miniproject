package product;

import java.io.PrintWriter;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller
public class week_controller {
	@Resource(name="wkDAO") week_DAO w_dao;
	@Resource(name="wkDTO") week_DTO w_dto;
	
	PrintWriter pw = null;

}
