package cn.sh.life.etc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sh.life.etc.entity.Message;
import cn.sh.life.etc.service.MessageService;
import cn.sh.life.etc.util.LoginCookieUtils;

@RequestMapping(value = "/message")
@Controller
public class MessageController {
	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/getMessage")
	@ResponseBody
	public List<Message> getMessage(Message message, HttpServletRequest request) {
		Integer currentUserId = LoginCookieUtils.getUserAccountIdFromCookie(request);
		List<Message> list = null;
		if (currentUserId != null) {
			message.setNotifyid(currentUserId);
			list = messageService.selectByNotifyId(message);
		}
		return list;
	}

}
