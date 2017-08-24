package com.deyond.fileUpload.module.channel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deyond.fileUpload.module.channel.entity.page.ChannelPage;
import com.deyond.fileUpload.module.channel.service.ChannelService;

@Controller
@RequestMapping("channel")
public class ChannelController {
	
	@Autowired
	ChannelService channelService;
	
	/**
	 * 跳转列表页面
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findListUI", method = { RequestMethod.GET })
	public String findListUI(ModelMap map, HttpServletRequest request, HttpServletResponse response)
	{
		return "about";
	}
	
	@RequestMapping(value = "/findList")
	@ResponseBody
	public String findList(ModelMap map, HttpServletRequest request, HttpServletResponse response)
	{	
		ChannelPage page = new ChannelPage();
		channelService.findList(page);
		return "about";
	}
}
