package cn.sh.life.etc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sh.life.etc.dao.ConsumeMapper;
import cn.sh.life.etc.entity.Consume;
import cn.sh.life.etc.service.ConsumeService;

@Service
public class ConsumeServiceImpl implements ConsumeService {

	@Autowired
	private ConsumeMapper consumeMapper;

	@Override
	public int insertConsume(Consume consume) {
		// TODO Auto-generated method stub
		return consumeMapper.insertSelective(consume);
	}

	@Override
	public int deleteConsume(int id) {
		// TODO Auto-generated method stub
		return consumeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateConsume(Consume consume) {
		// TODO Auto-generated method stub
		return consumeMapper.updateByPrimaryKeySelective(consume);
	}

	@Override
	public Consume selectConsumeById(int id) {
		// TODO Auto-generated method stub
		return consumeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Consume> selectByCondition(Consume consume) {
		// TODO Auto-generated method stub
		return consumeMapper.selectByCondition(consume);
	}

}
