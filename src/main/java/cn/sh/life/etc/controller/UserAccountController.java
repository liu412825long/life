package cn.sh.life.etc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sh.life.etc.common.Constants;
import cn.sh.life.etc.convert.UserAccountConvert;
import cn.sh.life.etc.entity.UserAccount;
import cn.sh.life.etc.service.UserAccountService;
import cn.sh.life.etc.util.LoginCookieUtils;
import cn.sh.life.etc.vo.ModifyPasswordVo;
import cn.sh.life.etc.vo.UserAccountInfo;
import cn.sh.life.etc.vo.UserAccountResponse;
import cn.sh.life.etc.vo.UserAccountVo;

@Controller
public class UserAccountController {
	@Autowired
	private UserAccountService userAccountService;

	@RequestMapping(value = "/registerAccount")
	@ResponseBody
	public String registerUserAccount(UserAccountVo userAccountVo) {
		UserAccount userAccount = UserAccountConvert.toUserAccount(userAccountVo);
		int registerResult = userAccountService.insertUserAccount(userAccount);
		if (registerResult != 0) {
			return Constants.SUCCESS;
		} else {
			return Constants.ERROR;
		}
	}

	@RequestMapping(value = "/loginAccount")
	@ResponseBody
	public String login(UserAccountVo userAccountVo, HttpServletRequest request, HttpServletResponse response) {
		UserAccount condition = new UserAccount();
		condition.setUsername(userAccountVo.getUsername());
		condition.setPassword(userAccountVo.getPassword());
		UserAccount userAccount = userAccountService.login(condition);
		if (userAccount != null) {
			Cookie[] cookies = LoginCookieUtils.getLoginCookie(userAccount);
			for (Cookie cookie : cookies) {
				response.addCookie(cookie);
			}
			return Constants.SUCCESS;
		} else {
			return Constants.FAIL;
		}
	}

	@RequestMapping(value = "/validateAccount")
	@ResponseBody
	public boolean validateAccount(UserAccountVo userAccountVo) {
		UserAccount condition = new UserAccount();
		condition.setUsername(userAccountVo.getUsername());
		condition.setPassword(userAccountVo.getPassword());
		UserAccount userAccount = userAccountService.login(condition);
		if (userAccount != null) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping(value = "/showAccountDetailInfo")
	@ResponseBody
	public UserAccountInfo showAccountDetailInfo(HttpServletRequest request) {
		Integer loginUserId = LoginCookieUtils.getUserAccountIdFromCookie(request);
		UserAccount user = null;
		UserAccountInfo userInfo = new UserAccountInfo();
		if (loginUserId != null) {
			user = userAccountService.selectUserAccount(loginUserId);
			if (user != null) {
				userInfo = UserAccountConvert.toUserAccountInfo(user);
				return userInfo;
			}
		}
		return userInfo;
	}

	@RequestMapping(value = "/modifyAccountDetail")
	@ResponseBody
	public String modifyAccountDetail(UserAccountInfo userAccountInfo, HttpServletRequest request) {
		UserAccount userAccount = UserAccountConvert.toUserAccount(userAccountInfo);
		Integer loginUserId = LoginCookieUtils.getUserAccountIdFromCookie(request);
		if (loginUserId != null) {
			userAccount.setId(loginUserId);
			int result = userAccountService.updateUserAccount(userAccount);
			if (result != 0) {
				return Constants.SUCCESS;
			}
		}
		return Constants.FAIL;
	}

	@RequestMapping(value = "/modifyPassword")
	@ResponseBody
	public UserAccountResponse modifyPassword(ModifyPasswordVo modifyPasswordVo, HttpServletRequest request) {
		UserAccountResponse response = new UserAccountResponse();
		UserAccount user = null;
		Integer loginUserId = LoginCookieUtils.getUserAccountIdFromCookie(request);
		if (loginUserId != null) {
			user = userAccountService.selectUserAccount(loginUserId);
			if (user != null) {
				String oldPass = user.getPassword();
				if (oldPass.equals(modifyPasswordVo.getOldPassword())) {
					String newPass = modifyPasswordVo.getNewPassword();
					String confirmPass = modifyPasswordVo.getConfirmPassword();
					if (newPass.equals(confirmPass)) {
						user.setPassword(newPass);
						int result = userAccountService.updateUserAccount(user);
						if (result != 0) {
							response.setStatus(Constants.SUCCESS);
							response.setMessage("密码修改成功");
							return response;
						} else {
							response.setStatus(Constants.ERROR);
							response.setMessage("系统发生异常，修改密码失败");
							return response;
						}
					} else {
						response.setStatus(Constants.ERROR);
						response.setMessage("确认密码和新密码不一致");
						return response;
					}

				} else {
					response.setStatus(Constants.ERROR);
					response.setMessage("原密码不正确");
					return response;
				}
			} else {
				response.setStatus(Constants.ERROR);
				response.setMessage("您还没有注册，请注册");
				return response;
			}
		}
		response.setStatus(Constants.ERROR);
		response.setMessage("您还没有登录，请登录");
		return response;
	}

	@RequestMapping(value = "/logoutAccount")
	public String logoutAccount(HttpServletRequest request, HttpServletResponse response) {
		Cookie nameCookie = new Cookie("virtualName", null);
		nameCookie.setMaxAge(0);
		Cookie idCookie = new Cookie("userId", null);
		idCookie.setMaxAge(0);
		response.addCookie(nameCookie);
		response.addCookie(idCookie);
		return "login";
	}

}
