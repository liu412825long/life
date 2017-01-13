package cn.com.annotation.test;

import cn.sh.list.etc.annotation.TestAnno;

public class Anno {
	@TestAnno
	private String str;

	@TestAnno
	public void test1() {
		// System.out.println(str);
	}

}
