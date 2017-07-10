package com.park.einvoice.service.eih5;

import org.springframework.stereotype.Repository;

@Repository(value="emailService")
public interface EmailService {
    
	/**
	 * 发送邮件
	 * @param requestStr 请求字符串，包含了邮件地址和发票请求流水号
	 * @return
	 */
	public String sendEmail(String requestStr);
	
}
