package cn.sh.life.etc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sh.life.etc.common.Constants;
import cn.sh.life.etc.entity.Message;
import cn.sh.life.etc.entity.UserAccount;
import cn.sh.life.etc.service.ConsumeDetailService;
import cn.sh.life.etc.service.MessageService;
import cn.sh.life.etc.service.UserAccountService;
import cn.sh.life.etc.util.LoginCookieUtils;
import cn.sh.life.etc.vo.AddConsumeDetailVo;
import cn.sh.life.etc.vo.ConsumeStatistics;
import cn.sh.life.etc.vo.ShowConsumeDetailListVo;
import cn.sh.life.etc.vo.ShowConsumeDetailListVoPage;
import cn.sh.life.etc.vo.ShowConsumeDetailVo;
import cn.sh.life.etc.vo.SingleConsumeVo;
import cn.sh.life.etc.vo.StatisticsVo;

@RequestMapping(value = "/consumeDetail")
@Controller
public class ConsumeDetailController {
	@Autowired
	private ConsumeDetailService consumeDetailService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/initConsumeDetail")
	@ResponseBody
	public AddConsumeDetailVo initConsumeDetail(HttpServletRequest request) {
		Integer id = LoginCookieUtils.getUserAccountIdFromCookie(request);
		UserAccount userAccount = null;
		if (id != null && id != 0) {
			userAccount = userAccountService.selectUserAccount(id);
		}
		AddConsumeDetailVo vo = new AddConsumeDetailVo();
		if (userAccount != null) {
			vo = consumeDetailService.initConsumeDetail(userAccount);
		}
		return vo;

	}

	@RequestMapping(value = "/queryConsumeDetailById")
	@ResponseBody
	public ShowConsumeDetailVo getConsumeDetailById(AddConsumeDetailVo vo) {
		ShowConsumeDetailVo showConsumeDetailVo = new ShowConsumeDetailVo();
		if (vo.getId() != null) {
			showConsumeDetailVo = consumeDetailService.selectConsumeDetialByCondition(vo.getId());
			if (vo.getMessageId() != null) {
				Message message = new Message();
				message.setId(vo.getMessageId());
				message.setStatus(2);
				messageService.updateMessage(message);
			}
		}
		return showConsumeDetailVo;
	}

	@RequestMapping(value = "/queryAllConsumeDetail")
	@ResponseBody
	public ShowConsumeDetailListVoPage getAllConsumeDetail(ShowConsumeDetailListVo vo) {
		ShowConsumeDetailListVoPage page = consumeDetailService.getConsumeDetialList(vo);
		return page;
	}

	@RequestMapping(value = "/addConsumeDetail")
	@ResponseBody
	public String addConsumeDetail(AddConsumeDetailVo vo, HttpServletRequest request) {
		Integer id = LoginCookieUtils.getUserAccountIdFromCookie(request);
		if (id != null) {
			vo.setPaied(id);
		}
		int result = consumeDetailService.insertConsumeDetail(vo);
		if (result != 0) {
			return Constants.SUCCESS;
		}
		return Constants.FAIL;
	}

	@RequestMapping(value = "/getConsume")
	@ResponseBody
	public ConsumeStatistics getConsume() {
		ConsumeStatistics cs = consumeDetailService.getConsume();
		return cs;
	}

	@RequestMapping(value = "/getSingleConsume")
	@ResponseBody
	public SingleConsumeVo getSingleConsume(HttpServletRequest request) {
		Integer id = LoginCookieUtils.getUserAccountIdFromCookie(request);
		SingleConsumeVo vo = null;
		if (id != null) {
			vo = consumeDetailService.getSingleConsumeMoney(id);
		}
		ConsumeStatistics cs = consumeDetailService.getConsume();
		List<StatisticsVo> list = cs.getList();
		for (StatisticsVo sv : list) {
			if (sv.getPaied().intValue() == id.intValue()) {
				vo.setMoney(sv.getPayMoney());
				vo.setSum(vo.getSingleMoney() + sv.getPayMoney());
				break;
			}
		}

		return vo;
	}

}
