package cn.com.annotation.test;

import org.junit.Test;

import cn.sh.list.etc.annotation.TestAnno;

public class AnnoMain {

	@Test
	public void test1() {
		Anno am = new Anno();
		am.test1();
		System.out.println(TestAnno.class.getAnnotations());

	}

}
