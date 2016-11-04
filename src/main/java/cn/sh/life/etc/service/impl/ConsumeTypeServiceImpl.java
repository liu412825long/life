package cn.sh.life.etc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sh.life.etc.dao.ConsumeTypeMapper;
import cn.sh.life.etc.entity.ConsumeType;
import cn.sh.life.etc.service.ConsumeTypeService;

@Service
public class ConsumeTypeServiceImpl implements ConsumeTypeService {

	@Autowired
	private ConsumeTypeMapper consumeTypeMapper;

	@Override
	public int insertConsumeType(ConsumeType consumeType) {
		// TODO Auto-generated method stub
		return consumeTypeMapper.insertSelective(consumeType);
	}

	@Override
	public int deleteConsumeType(int id) {
		// TODO Auto-generated method stub
		return consumeTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateConsumeType(ConsumeType consumeType) {
		// TODO Auto-generated method stub
		return consumeTypeMapper.updateByPrimaryKeySelective(consumeType);
	}

	@Override
	public ConsumeType selectConsumeTypeById(int id) {
		// TODO Auto-generated method stub
		return consumeTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ConsumeType> selectAll() {
		// TODO Auto-generated method stub
		return consumeTypeMapper.selectAll();
	}

}
