package cn.sh.life.etc.dao;

import java.util.List;

import cn.sh.life.etc.entity.ConsumeType;

public interface ConsumeTypeMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(ConsumeType record);

	int insertSelective(ConsumeType record);

	ConsumeType selectByPrimaryKey(Integer id);

	List<ConsumeType> selectAll();

	int updateByPrimaryKeySelective(ConsumeType record);

	int updateByPrimaryKey(ConsumeType record);
}