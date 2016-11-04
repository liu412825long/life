package cn.sh.life.etc.dao;

import java.util.List;

import cn.sh.life.etc.entity.UserAccount;

public interface UserAccountMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(UserAccount record);

	int insertSelective(UserAccount record);

	UserAccount selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(UserAccount record);

	int updateByPrimaryKey(UserAccount record);

	UserAccount selectByCondition(UserAccount record);

	List<UserAccount> selectAll();

}