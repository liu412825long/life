package life;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import cn.sh.life.etc.entity.ConsumeDetail;
import cn.sh.life.etc.entity.UserAccount;
import cn.sh.life.etc.service.UserAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class ConsumeDetailTest {
	@Autowired
	private UserAccountService cds;

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		RestTemplate res = new RestTemplate();
		ConsumeDetail consumeDetail = new ConsumeDetail();
		consumeDetail.setComment("aa");
		consumeDetail.setCount(2);
		consumeDetail.setDate(new Date());
		consumeDetail.setMoney(new Double("43"));
		consumeDetail.setPaied(2);
		consumeDetail.setStatue(1);
		Integer i = res.postForObject("http://localhost:8080/life/addConsumeDetail", consumeDetail, Integer.class);
		System.out.println(i);
	}

	@Test
	public void queryTest() {
		UserAccount consumeDetail = cds.selectUserAccount(1);
		System.out.println(consumeDetail);
	}

}
