package cn.sh.life.etc.dao;

import java.util.List;

import cn.sh.life.etc.entity.ConsumeDetail;

public interface ConsumeDetailMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(ConsumeDetail record);

	int insertSelective(ConsumeDetail record);

	ConsumeDetail selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ConsumeDetail record);

	int updateByPrimaryKey(ConsumeDetail record);

	List<ConsumeDetail> selectByCondition(ConsumeDetail record);

	List<ConsumeDetail> selectByCount(int count);
}