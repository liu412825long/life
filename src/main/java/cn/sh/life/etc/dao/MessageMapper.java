package cn.sh.life.etc.dao;

import java.util.List;
import java.util.Map;

import cn.sh.life.etc.entity.Message;

public interface MessageMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Message record);

	int insertSelective(Message record);

	Message selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Message record);

	int updateByPrimaryKey(Message record);

	List<Message> selectByNotifyId(Map<String, Object> map);

}