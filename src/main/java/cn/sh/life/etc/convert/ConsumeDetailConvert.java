package cn.sh.life.etc.convert;

import java.util.List;

import org.springframework.beans.BeanUtils;

import cn.sh.life.etc.entity.ConsumeDetail;
import cn.sh.life.etc.type.ConsumeStatus;
import cn.sh.life.etc.util.DateParseUtils;
import cn.sh.life.etc.vo.AddConsumeDetailVo;
import cn.sh.life.etc.vo.ShowConsumeDetailListVo;
import cn.sh.life.etc.vo.ShowConsumeDetailVo;

public class ConsumeDetailConvert {

	public static ConsumeDetail convertToConsumeDetail(AddConsumeDetailVo vo) {
		ConsumeDetail consumeDetial = new ConsumeDetail();
		BeanUtils.copyProperties(vo, consumeDetial);
		List<String> shareIds = vo.getShareIds();
		if (shareIds != null) {
			consumeDetial.setCount(shareIds.size());
		}
		return consumeDetial;
	}

	public static ConsumeDetail convertToConsumeDetail(ShowConsumeDetailListVo vo) {
		ConsumeDetail consumeDetial = new ConsumeDetail();
		consumeDetial.setDate(vo.getDate());
		consumeDetial.setPaied(vo.getPaied());
		consumeDetial.setCount(vo.getCount());
		return consumeDetial;
	}

	public static ShowConsumeDetailVo convertToShowDetailVo(ConsumeDetail consumeDetail) {
		ShowConsumeDetailVo vo = new ShowConsumeDetailVo();
		BeanUtils.copyProperties(consumeDetail, vo);
		vo.setShowDate(DateParseUtils.parseToStringDate(consumeDetail.getDate()));
		vo.setStatus(ConsumeStatus.getEnumById(consumeDetail.getStatue().byteValue()).getName());
		return vo;
	}

}
