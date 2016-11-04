package cn.sh.life.etc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sh.life.etc.dao.UserAccountMapper;
import cn.sh.life.etc.entity.UserAccount;
import cn.sh.life.etc.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private UserAccountMapper userAccountMapper;

	@Override
	public UserAccount selectUserAccount(int id) {
		// TODO Auto-generated method stub
		return userAccountMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insertUserAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		return userAccountMapper.insertSelective(userAccount);
	}

	@Override
	public int updateUserAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		return userAccountMapper.updateByPrimaryKeySelective(userAccount);
	}

	@Override
	public int deleteUserAccount(int id) {
		// TODO Auto-generated method stub
		return userAccountMapper.deleteByPrimaryKey(id);
	}

	@Override
	public UserAccount login(UserAccount userAccount) {
		// TODO Auto-generated method stub
		return userAccountMapper.selectByCondition(userAccount);
	}

	@Override
	public List<UserAccount> selectAll() {
		// TODO Auto-generated method stub
		return userAccountMapper.selectAll();
	}

}
