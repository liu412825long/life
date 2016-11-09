package cn.sh.life.etc.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import cn.sh.life.etc.vo.ConsumeStatistics;
import cn.sh.life.etc.vo.SharePeopleVo;
import cn.sh.life.etc.vo.ShowConsumeDetailListVo;
import cn.sh.life.etc.vo.ShowConsumeDetailVo;
import cn.sh.life.etc.vo.SingleConsumeVo;
import cn.sh.life.etc.vo.StatisticsVo;

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

	private Map<Integer, List<ConsumeDetail>> consumeDetailStatistics(int count) {
		List<ConsumeDetail> listAll = consumeDetailMapper.selectByCount(count);
		Map<Integer, List<ConsumeDetail>> mapAll = new HashMap<Integer, List<ConsumeDetail>>();
		if (listAll != null && listAll.size() > 0) {
			for (ConsumeDetail cd : listAll) {
				Integer paied = cd.getPaied();
				if (mapAll.containsKey(paied)) {
					List<ConsumeDetail> singleList = mapAll.get(paied);
					singleList.add(cd);
				} else {
					List<ConsumeDetail> singleList = new ArrayList<ConsumeDetail>();
					singleList.add(cd);
					mapAll.put(paied, singleList);
				}
			}
		}
		return mapAll;
	}

	private ConsumeStatistics calculatorThree(ConsumeStatistics cs) {
		Map<Integer, List<ConsumeDetail>> map = this.consumeDetailStatistics(3);
		Set<Integer> set = map.keySet();
		Double sum = new Double(0);
		Double avg = new Double(0);
		Map<Integer, Double> payMap = new HashMap<Integer, Double>();
		for (Integer i : set) {
			Double payMoney = new Double(0);
			List<ConsumeDetail> detailList = map.get(i);
			for (ConsumeDetail con : detailList) {
				sum = sum + con.getMoney();
				payMoney = payMoney + con.getMoney();
			}
			payMap.put(i, payMoney);
		}
		avg = sum / 3;
		BigDecimal b = new BigDecimal(avg);
		avg = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		sum = cs.getSum() + sum;
		cs.setSum(sum);
		List<StatisticsVo> list = cs.getList();
		for (StatisticsVo vo : list) {
			Integer payId = vo.getPaied();
			Double dou = payMap.get(payId);
			vo.setPayMoney(vo.getPayMoney() + dou);
			vo.setShareMoney(vo.getShareMoney() + avg);
			calculatorResultMoney(vo);
		}
		return cs;
	}

	private StatisticsVo calculatorResultMoney(StatisticsVo vo) {
		Double payMoney = vo.getPayMoney();
		Double shareMoney = vo.getShareMoney();
		Double result = payMoney.doubleValue() - shareMoney.doubleValue();
		if (result.doubleValue() > 0) {
			vo.setInfo("减少");
		} else {
			vo.setInfo("添加");
		}
		Double d = Math.abs(result);
		BigDecimal b = new BigDecimal(d);
		double f1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		vo.setResultMoney(f1);
		System.out.println(vo);
		return vo;
	}

	public ConsumeStatistics getConsume() {
		Map<Integer, List<ConsumeDetail>> map = this.consumeDetailStatistics(2);
		Set<Integer> set = map.keySet();
		Map<Integer, Double> mapAvg = new HashMap<Integer, Double>();
		Map<Integer, StatisticsVo> voMap = new HashMap<Integer, StatisticsVo>();
		Double sum = new Double(0);
		for (Integer i : set) {
			StatisticsVo sv = new StatisticsVo();
			List<ConsumeDetail> detailList = map.get(i);
			Double payMoney = new Double(0);
			for (ConsumeDetail consumeDetail : detailList) {
				payMoney = payMoney + consumeDetail.getMoney();
				sum = sum + consumeDetail.getMoney();
				Integer detailId = consumeDetail.getId();
				List<Consume> consumeList = consumeService.selectByConsumeDetailId(detailId);
				for (Consume consume : consumeList) {
					Integer shareId = consume.getUseraccount();
					if (mapAvg.containsKey(shareId)) {
						Double money = consumeDetail.getMoney() / 2 + mapAvg.get(shareId);
						mapAvg.replace(shareId, money);
					} else {
						mapAvg.put(shareId, consumeDetail.getMoney() / 2);
					}
				}
			}
			sv.setPaied(i);
			sv.setPayMoney(payMoney);
			voMap.put(i, sv);
		}
		Set<Integer> keySet = mapAvg.keySet();
		Map<Integer, String> userAccount = this.getUserAccountName();
		List<StatisticsVo> list = new ArrayList<StatisticsVo>();
		for (Integer i : keySet) {
			StatisticsVo statis = voMap.get(i);
			if (statis != null) {
				statis.setShareMoney(mapAvg.get(i));
				statis.setName(userAccount.get(i));
			}
			list.add(statis);
		}
		ConsumeStatistics cs = new ConsumeStatistics();
		cs.setSum(sum);
		cs.setList(list);

		return this.calculatorThree(cs);
	}

	public SingleConsumeVo getSingleConsumeMoney(Integer userId) {
		SingleConsumeVo vo = new SingleConsumeVo();
		vo.setId(userId);
		ConsumeDetail consumeDetail = new ConsumeDetail();
		Map<Integer, String> userAccount = this.getUserAccountName();
		vo.setName(userAccount.get(userId));
		consumeDetail.setPaied(userId);
		consumeDetail.setCount(1);
		List<ConsumeDetail> list = consumeDetailMapper.selectByCondition(consumeDetail);
		Double sum = new Double(0);
		if (list != null) {
			for (ConsumeDetail con : list) {
				sum = sum + con.getMoney();
			}
		}
		vo.setSingleMoney(sum);
		return vo;

	}

}
