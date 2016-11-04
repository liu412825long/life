package cn.sh.life.etc.util;

import java.util.Date;

public class MessageTemplate {
	public static String addMessageTemplate(String createName, Date createDate, Date consumeDate) {
		String content = "你的好友" + createName + "于" + DateParseUtils.parseToStringDate(createDate) + "添加了一笔"
				+ DateParseUtils.parseToStringDate(consumeDate) + "账单";
		return content;

	}

}
