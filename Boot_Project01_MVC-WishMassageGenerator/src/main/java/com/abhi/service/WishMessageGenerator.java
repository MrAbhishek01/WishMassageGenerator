package com.abhi.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class WishMessageGenerator implements IWishMessageGenerator {

	@Override
	public String generateMessage(String name) {
		LocalDateTime now = LocalDateTime.now();
		String msg;
		int hour = now.getHour();

		if (hour < 12)
			msg = "Good Morning";
		else if (hour < 17)
			msg = "Good Afternoon";
		else if (hour < 21)
			msg = "Good Evening";
		else
			msg = "Good Night";

		return msg + " 	Mr/Miss " + name;
	}
}
