package cn.sh.life.etc.service;

import java.util.List;

import cn.sh.life.etc.entity.Consume;

public interface ConsumeService {

	public int insertConsume(Consume consume);

	public int deleteConsume(int id);

	public int updateConsume(Consume consume);

	public Consume selectConsumeById(int id);

	public List<Consume> selectByCondition(Consume consume);

	public List<Consume> selectByConsumeDetailId(int id);

}
