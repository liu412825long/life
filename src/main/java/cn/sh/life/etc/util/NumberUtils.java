package cn.sh.life.etc.util;

import java.math.BigDecimal;

public class NumberUtils {

	public static double numberFormat(Double d) {
		if (d == null) {
			return 0;
		}
		BigDecimal b = new BigDecimal(d);
		double f1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}

}
