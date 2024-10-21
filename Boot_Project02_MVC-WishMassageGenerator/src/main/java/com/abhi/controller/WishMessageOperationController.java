package com.abhi.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhi.service.IWishMessageGenerator;

@Controller
public class WishMessageOperationController {

	@Autowired
	private IWishMessageGenerator service;

	/**
	 * =>if we take handler method with "/" request path to launch the home
	 * page..then there is not need of taking index.jsp separate to send the
	 * implicit request, More over this technique works in both external tomcat
	 * server deployment and embedded tomcat server deployment of spring boot app.
	 */
	@RequestMapping("/")
	public String msgController() {
		// Maps to the welcome.jsp
		return "welcome";
	}

	@RequestMapping("/wmg")
	public String fetchMessage(@RequestParam("name") String name, Map<String, Object> mp) {
		System.err.println(mp.getClass());
		String generatedMessage = service.generateMessage(name);
		mp.put("wMsg", generatedMessage);
		mp.put("sysdate", new Date());
		return "checkStatus";
	}
}
