package cn.sh.life.etc.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import cn.sh.life.etc.entity.UserAccount;

public class LoginCookieUtils {

	public static Cookie[] getLoginCookie(UserAccount userAccount) {
		Cookie[] cookies = new Cookie[2];
		if (userAccount != null) {
			Cookie cookieName = null;
			try {
				cookieName = new Cookie("virtualName", URLEncoder.encode(userAccount.getVirtualname(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cookieName.setMaxAge(60 * 30);
			cookies[0] = cookieName;
			Cookie cookieId = new Cookie("userId", userAccount.getId().toString());
			cookieId.setMaxAge(60 * 30);
			cookies[1] = cookieId;
		}
		return cookies;
	}

	public static Integer getUserAccountIdFromCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String value = null;
		if (cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if (name.equals("userId")) {
				value = cookie.getValue();
				break;
			}
		}
		if (value != null) {
			Integer id = new Integer(value);
			return id;
		}

		return null;
	}

}
