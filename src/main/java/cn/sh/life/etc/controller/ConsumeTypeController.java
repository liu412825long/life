package cn.sh.life.etc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sh.life.etc.common.Constants;
import cn.sh.life.etc.entity.ConsumeType;
import cn.sh.life.etc.service.ConsumeTypeService;

@RequestMapping(value = "/consumeType")
@Controller
public class ConsumeTypeController {
	@Autowired
	private ConsumeTypeService consumeTypeService;

	@RequestMapping(value = "/addConsumeType")
	@ResponseBody
	public String addConsumeType(@RequestBody ConsumeType consumeType) {
		int result = consumeTypeService.insertConsumeType(consumeType);
		if (result != 0) {
			return Constants.SUCCESS;
		} else {
			return Constants.FAIL;
		}
	}

	@RequestMapping(value = "/queryAllConsumeType")
	@ResponseBody
	public List<ConsumeType> queryAllConsumeType() {
		List<ConsumeType> consumeTypeList = consumeTypeService.selectAll();
		if (consumeTypeList != null) {
			return consumeTypeList;
		}
		return new ArrayList<ConsumeType>();
	}

}
