package cn.sh.life.etc.service;

import java.util.List;

import cn.sh.life.etc.entity.Message;

public interface MessageService {

	public int insertMessage(Message message);

	public int deleteMessage(int id);

	public int updateMessage(Message message);

	public Message selectMessageById(int id);

	public List<Message> selectByNotifyId(Message message);

}
