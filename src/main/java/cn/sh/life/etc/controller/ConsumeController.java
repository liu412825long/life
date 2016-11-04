package cn.sh.life.etc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.sh.life.etc.service.ConsumeService;

@Controller
public class ConsumeController {
	@Autowired
	private ConsumeService consumeService;

}
