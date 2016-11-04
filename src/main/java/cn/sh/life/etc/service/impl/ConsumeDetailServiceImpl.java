package cn.sh.life.etc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sh.life.etc.convert.ConsumeDetailConvert;
import cn.sh.life.etc.dao.ConsumeDetailMapper;
import cn.sh.life.etc.entity.Consume;
import cn.sh.life.etc.entity.ConsumeDetail;
import cn.sh.life.etc.entity.Message;
import cn.sh.life.etc.entity.UserAccount;
import cn.sh.life.etc.service.ConsumeDetailService;
import cn.sh.life.etc.service.ConsumeService;
import cn.sh.life.etc.service.MessageService;
import cn.sh.life.etc.service.UserAccountService;
import cn.sh.life.etc.type.ConsumeStatus;
import cn.sh.life.etc.type.ConsumeType;
import cn.sh.life.etc.util.DateParseUtils;
import cn.sh.life.etc.util.MessageTemplate;
import cn.sh.life.etc.vo.AddConsumeDetailVo;
import cn.sh.life.etc.vo.SharePeopleVo;
import cn.sh.life.etc.vo.ShowConsumeDetailListVo;
import cn.sh.life.etc.vo.ShowConsumeDetailVo;

@Service
public class ConsumeDetailServiceImpl implements ConsumeDetailService {

	@Autowired
	private ConsumeDetailMapper consumeDetailMapper;

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private ConsumeService consumeService;
	@Autowired
	private MessageService messageService;

	@Override
	public int insertConsumeDetail(AddConsumeDetailVo vo) {
		// TODO Auto-generated method stub
		ConsumeDetail consumeDetail = ConsumeDetailConvert.convertToConsumeDetail(vo);
		int result = consumeDetailMapper.insertSelective(consumeDetail);
		Map<Integer, String> userAccount = this.getUserAccountName();
		if (result != 0) {
			List<String> ids = vo.getShareIds();
			for (String id : ids) {
				int userId = Integer.parseInt(id);
				Consume consume = this.getConsume(consumeDetail.getId(), userId, vo.getType());
				consumeService.insertConsume(consume);
				if (consumeDetail.getPaied().intValue() != userId) {
					Message message = this.getMessage(consumeDetail, userAccount.get(consumeDetail.getPaied()), userId);
					messageService.insertMessage(message);
				}
			}
		}
		return result;
	}

	private Message getMessage(ConsumeDetail consumeDetail, String createName, Integer notifyId) {
		Message message = new Message();
		message.setUserid(consumeDetail.getPaied());
		message.setConsumedetailid(consumeDetail.getId());
		Date date = new Date();
		message.setCreatedate(date);
		message.setNotifyid(notifyId);
		String content = MessageTemplate.addMessageTemplate(createName, date, consumeDetail.getDate());
		message.setMessage(content);
		return message;

	}

	private Consume getConsume(int detailId, int userId, int typeId) {
		Consume consume = new Consume();
		consume.setConsumedetail(detailId);
		consume.setConsumetype(typeId);
		consume.setUseraccount(userId);
		return consume;

	}

	@Override
	public int deleteConsumeDetail(int id) {
		// TODO Auto-generated method stub
		return consumeDetailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public ConsumeDetail selectById(int id) {
		// TODO Auto-generated method stub
		ConsumeDetail consumeDetail = consumeDetailMapper.selectByPrimaryKey(id);
		return consumeDetail;
	}

	@Override
	public ShowConsumeDetailVo selectConsumeDetialByCondition(int id) {
		ConsumeDetail consumeDetail = this.selectById(id);
		ShowConsumeDetailVo vo = ConsumeDetailConvert.convertToShowDetailVo(consumeDetail);
		if (consumeDetail != null) {
			Map<Integer, String> userAccountMap = this.getUserAccountName();
			vo.setPayName(userAccountMap.get(consumeDetail.getPaied()));
			List<Consume> list = getConsume(consumeDetail);
			if (list != null && list.size() > 0) {
				vo.setType(ConsumeType.getEnumById(list.get(0).getConsumetype().byteValue()).getName());
				String peopleName = "";
				for (Consume c : list) {
					peopleName = peopleName + userAccountMap.get(c.getUseraccount()) + ",";
				}
				peopleName = peopleName.substring(0, peopleName.length() - 1);
				vo.setSharePeopleName(peopleName);
			}
		}
		return vo;
	}

	private List<Consume> getConsume(ConsumeDetail consumeDetail) {
		Integer detailId = consumeDetail.getId();
		Consume consume = new Consume();
		consume.setConsumedetail(detailId);
		List<Consume> list = consumeService.selectByCondition(consume);
		return list;
	}

	@Override
	public int updateConsumeDetail(ConsumeDetail consumeDetail) {
		// TODO Auto-generated method stub
		return consumeDetailMapper.updateByPrimaryKeySelective(consumeDetail);
	}

	public AddConsumeDetailVo initConsumeDetail(UserAccount userAccount) {
		AddConsumeDetailVo vo = new AddConsumeDetailVo();
		if (userAccount != null) {
			vo.setPayPeople(userAccount.getRealname());
		}
		List<UserAccount> list = userAccountService.selectAll();
		List<SharePeopleVo> share = new ArrayList<SharePeopleVo>();
		if (list != null) {
			int end = list.size() > 3 ? 3 : list.size();
			for (int i = 0; i < end; i++) {
				SharePeopleVo sharePeople = new SharePeopleVo();
				UserAccount account = list.get(i);
				sharePeople.setId(account.getId());
				sharePeople.setName(account.getRealname());
				share.add(sharePeople);
			}
		}
		vo.setShare(share);
		return vo;
	}

	@Override
	public List<ShowConsumeDetailListVo> getConsumeDetialList(ShowConsumeDetailListVo vo) {
		// TODO Auto-generated method stub
		List<ShowConsumeDetailListVo> lists = new ArrayList<ShowConsumeDetailListVo>();
		ConsumeDetail record = ConsumeDetailConvert.convertToConsumeDetail(vo);
		List<ConsumeDetail> list = consumeDetailMapper.selectByCondition(record);
		Map<Integer, String> map = this.getUserAccountName();
		for (ConsumeDetail detail : list) {
			ShowConsumeDetailListVo showVo = new ShowConsumeDetailListVo();
			BeanUtils.copyProperties(detail, showVo);
			showVo.setPayName(map.get(detail.getPaied()));
			showVo.setStatus(ConsumeStatus.getEnumById(detail.getStatue().byteValue()).getName());
			showVo.setShowDate(DateParseUtils.parseToStringDate(detail.getDate()));
			lists.add(showVo);
		}
		return lists;
	}

	private Map<Integer, String> getUserAccountName() {
		List<UserAccount> userAccountList = userAccountService.selectAll();
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (UserAccount account : userAccountList) {
			map.put(account.getId(), account.getRealname());
		}
		return map;
	}

}
