package cms;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface cms_mapper {
	int cms_insert(cms_DTO c_dto);
	
	List<cms_DTO> rental_type();
}
