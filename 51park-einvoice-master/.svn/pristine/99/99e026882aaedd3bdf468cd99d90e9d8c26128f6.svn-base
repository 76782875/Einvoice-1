package com.park.einvoice.controller.eih5;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.park.einvoice.service.eih5.EmailService;

@Controller
@RequestMapping("/email")
public class EmailController {
	
	@Resource(name="emailServiceImpl")
	private EmailService emailService;
	
	@ResponseBody
	@RequestMapping(value="/sendEmail", produces="text/html;charset=UTF-8")
	public String sendEmail(HttpServletRequest request){
		String requestStr = request.getParameter("params");
		return emailService.sendEmail(requestStr);
	}
	
}
