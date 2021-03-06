package com.biz.bbs.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.service.BBsService;

@SessionAttributes("bbsVO")
@RequestMapping(value="/bbs")
@Controller
public class BBsController {

	// 원래 필드생성자를 사용하는 모양새
	private final BBsService bService;

	@Autowired
	public BBsController(@Qualifier("bServiceV1")BBsService bService) {
		super();
		this.bService = bService;
	}
	// 여기까지
	
	@ModelAttribute("bbsVO")
	public BBsVO makeBBsVO() {
		return new BBsVO();
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String selectAll(Model model) {
		List<BBsVO> bbsList = bService.selectAll();
		model.addAttribute("BBS_LIST", bbsList);
		model.addAttribute("BODY", "BBS_LIST");
		return "home";
	}
	
	@RequestMapping(value="/input", method=RequestMethod.GET)
	public String input(Model model) {
		
		// java 8 이상의 새로운 날짜 시간 클래스
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		BBsVO bbsVO = BBsVO.builder()
				.bbs_date(ld.toString())
				.bbs_time(lt.format(dt))
				.build();
		model.addAttribute("bbsVO", bbsVO);
		model.addAttribute("BODY","BBS_INPUT");
		return "home";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute BBsVO bbsVO) {
		bService.save(bbsVO);
		return "redirect:/bbs/list";
	}
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(@RequestParam("bbs_id") long bbsId, Model model) {
		BBsVO bbsVO = bService.findById(bbsId);
		model.addAttribute("bbsVO", bbsVO);
		model.addAttribute("BODY", "VIEW");
		return "home";
	}
	
	@RequestMapping(value="/reply", method=RequestMethod.POST)
	public String reply(@ModelAttribute BBsVO bbsVO) {
		bbsVO = bService.reply(bbsVO);
		return "redirect:/bbs/list";
	}
}
