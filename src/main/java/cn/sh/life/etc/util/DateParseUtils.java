package cn.sh.life.etc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.sh.life.etc.common.Constants;

public class DateParseUtils {
	public static String parseToStringDate(Date date) {
		if (date != null) {
			SimpleDateFormat sd = new SimpleDateFormat(Constants.DATAFORMAT_UNDERLINE);
			return sd.format(date);
		}
		return "";
	}

}
