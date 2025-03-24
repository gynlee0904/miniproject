package member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface member_mapper {
	public int member_insert(member_DTO m_dto);
}
