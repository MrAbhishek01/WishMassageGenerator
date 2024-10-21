package com.abhi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhi.service.IWishMessageGenerator;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class WishMessageOperationController {

	@Autowired
	private IWishMessageGenerator service;

	@RequestMapping("/home")
	public String msgController() {
		// Maps to the welcome.jsp
		return "welcome";
	}

	/**
	 * (Bad Practice)Working with ModelAndView as return type of method as
	 * ModelAndView
	 */
	/*@RequestMapping("/wmg")
	public ModelAndView fetchMessage(@RequestParam("name")String name) {
	    String generatedMessage = service.generateMessage(name);
	    ModelAndView mvw = new ModelAndView();
	    mvw.addObject("wMsg", generatedMessage);
	    mvw.addObject("sysdate", new Date());
	    mvw.setViewName("checkStatus");
	    
	    return mvw;
	}*/

	/**
	 * (Bad Practice) working with Model as a method parameter
	 */

	/*@RequestMapping("/wmg")
	public String fetchMessage(@RequestParam("name") String name, Model model) {
		
		String generatedMessage = service.generateMessage(name);
		model.addAttribute("wMsg", generatedMessage);
		model.addAttribute("sysdate", new Date());
	
		return "checkStatus";
	}*/

	/**
	 * (Bad Practice) working with HashMap<String, Object> as a method parameter
	 */

	/*	@RequestMapping("/wmg")
		public String fetchMessage(@RequestParam("name") String name,HashMap<String, Object> mp) {
			System.err.println(mp.getClass());
			String generatedMessage = service.generateMessage(name);
			mp.put("wMsg", generatedMessage);
			mp.put("sysdate", new Date());
			return "checkStatus";
		}*/

	/**
	 * working with Method as a void with Map<K, V> as a method parameter
	 * 
	 * => it will take request path "wmg"as a logical view name
	 */

	/*	@RequestMapping("/wmg")
		public void fetchMessage(@RequestParam("name") String name, Map<String, Object> mp) {
			System.err.println(mp.getClass());
			String generatedMessage = service.generateMessage(name);
			mp.put("wMsg", generatedMessage);
			mp.put("sysdate", new Date());
		}*/

	/**
	 * working with Method return type as null with Map<K, V> as a method parameter
	 * 
	 * => it will take request path "wmg"as a logical view name
	 */

	/*@RequestMapping("/wmg")
	public String fetchMessage(@RequestParam("name") String name, Map<String, Object> mp) {
		System.err.println(mp.getClass());
		String generatedMessage = service.generateMessage(name);
		mp.put("wMsg", generatedMessage);
		mp.put("sysdate", new Date());
		return null;
	}*/

	/**
	 * (Bad Practice) we can directly give the response to through DispatcherServlet
	 * to the controller class without involving view resolver or view component
	 */
	/*@RequestMapping("/wmg")
	public void fetchMessage(@RequestParam("name") String name, Map<String, Object> mp, HttpServletResponse response)
			throws IOException {
		System.err.println(mp.getClass());
		PrintWriter pw = response.getWriter();
		String generatedMessage = service.generateMessage(name);
		pw.println("Wish Massage:: " + generatedMessage);
		pw.println("Generate current time and date :: " + new Date());
	}*/

	/**
	 * (Best Practice) working with Map<K, V> as a method parameter
	 */
	@RequestMapping("/wmg")
	public String fetchMessage(@RequestParam("name") String name, Map<String, Object> mp) {
		System.err.println(mp.getClass());
		String generatedMessage = service.generateMessage(name);
		mp.put("wMsg", generatedMessage);
		mp.put("sysdate", new Date());
		return "checkStatus";
	}
}
