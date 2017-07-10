package com.park.einvoice.controller.eih5;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.park.einvoice.service.eih5.OrderInvoiceService;

@Controller
@RequestMapping("/orderInvoice")
public class OrderInvoiceController {
	
	@Resource(name="orderInvoiceServiceImpl")
	private OrderInvoiceService orderInvoiceService;
	
	@ResponseBody
	@RequestMapping(value="/getOrderInvoiceStatus", produces = "text/html;charset=UTF-8")
	public String getOrderInvoiceStatus(HttpServletRequest request, HttpServletResponse response){
		String requestStr = request.getParameter("params");
		return orderInvoiceService.getOrderInvoiceStatus(requestStr);
	}
	
}
