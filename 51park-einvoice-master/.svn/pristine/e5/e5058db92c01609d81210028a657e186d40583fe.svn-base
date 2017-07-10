package com.park.einvoice.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.park.einvoice.common.GetRequestJsonTools;
import com.park.einvoice.service.BlueInvoiceService;

@Controller
@RequestMapping("/blueInvoice")
public class BlueInvoiceController {
	
	@Resource(name="blueInvoiceServiceImpl")
	private BlueInvoiceService blueInvoiceService;
	
	@ResponseBody
	@RequestMapping(value="/searchInvoiceResult", produces="text/html;charset=UTF-8")
	public String searchInvoiceResult(HttpServletRequest request, HttpServletResponse response){
		String requestJsonStr = null;
		requestJsonStr = request.getParameter("params");
		return blueInvoiceService.searchInvoiceResult(requestJsonStr);
	}
	
	@ResponseBody
	@RequestMapping(value = "/blueinvoicepush", produces = "text/html;charset=UTF-8")
	public String blueInvoicePush(HttpServletRequest request, HttpServletResponse response){
		String requestJsonStr = null;
		try {
			requestJsonStr = GetRequestJsonTools.getRequestJsonString(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return blueInvoiceService.dealBlueInvoicePush(requestJsonStr);
	}
	
	@ResponseBody
	@RequestMapping(value = "/blueInvoice", produces = "text/html;charset=UTF-8")
	public String blueInvoice(HttpServletRequest request, HttpServletResponse response){
		String requestJsonStr = null;
		requestJsonStr = request.getParameter("params");
		return blueInvoiceService.blueInvoice(requestJsonStr);
	}
	
}
