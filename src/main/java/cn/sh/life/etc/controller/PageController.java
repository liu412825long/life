package cn.sh.life.etc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping(value = "/page/index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/index")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/page/register")
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/page/error")
	public String error() {
		return "error";
	}

	@RequestMapping(value = "/page/addConsumeDetail")
	public String addConsumeDetail() {
		return "addConsumeDetail";
	}

	@RequestMapping(value = "/page/showConsumeDetail")
	public String showConsumeDetail() {
		return "showConsumeDetail";
	}

	@RequestMapping(value = "/page/addConsumeDetailSuccess")
	public String addConsumeDetailSuccess() {
		return "addConsumeDetailSuccess";
	}

	@RequestMapping(value = "/page/modifyPassword")
	public String modifyPassword() {
		return "modifyPassword";
	}

	@RequestMapping(value = "/page/userAccountInfo")
	public String userAccountInfo() {
		return "userAccountInfo";
	}

	@RequestMapping(value = "/page/showMessage")
	public String showMessage() {
		return "showMessage";
	}

	@RequestMapping(value = "/page/showStatistics")
	public String showStatistics() {
		return "showStatistics";
	}

}
