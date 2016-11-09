package cn.sh.life.etc.service;

import java.util.List;

import cn.sh.life.etc.entity.ConsumeDetail;
import cn.sh.life.etc.entity.UserAccount;
import cn.sh.life.etc.vo.AddConsumeDetailVo;
import cn.sh.life.etc.vo.ConsumeStatistics;
import cn.sh.life.etc.vo.ShowConsumeDetailListVo;
import cn.sh.life.etc.vo.ShowConsumeDetailVo;
import cn.sh.life.etc.vo.SingleConsumeVo;

public interface ConsumeDetailService {
	public int insertConsumeDetail(AddConsumeDetailVo vo);

	public int deleteConsumeDetail(int id);

	public ConsumeDetail selectById(int id);

	public int updateConsumeDetail(ConsumeDetail consumeDetail);

	public AddConsumeDetailVo initConsumeDetail(UserAccount userAccount);

	public ShowConsumeDetailVo selectConsumeDetialByCondition(int id);

	public List<ShowConsumeDetailListVo> getConsumeDetialList(ShowConsumeDetailListVo vo);

	public ConsumeStatistics getConsume();

	public SingleConsumeVo getSingleConsumeMoney(Integer userId);

}
