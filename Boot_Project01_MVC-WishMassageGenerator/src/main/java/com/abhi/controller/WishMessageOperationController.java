package com.abhi.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abhi.service.IWishMessageGenerator;

@Controller
public class WishMessageOperationController {
    
    @Autowired
    private IWishMessageGenerator service;

    
    @RequestMapping("/home")
    public String msgController() {
        // Maps to the welcome.jsp
        return "welcome";
    }

    @RequestMapping("/wmg")
    public ModelAndView fetchMessage(@RequestParam("name")String name) {
        String generatedMessage = service.generateMessage(name);
        ModelAndView mvw = new ModelAndView();
        mvw.addObject("wMsg", generatedMessage);
        mvw.addObject("sysdate", new Date());
        mvw.setViewName("checkStatus");
        
        return mvw;
    }
}
