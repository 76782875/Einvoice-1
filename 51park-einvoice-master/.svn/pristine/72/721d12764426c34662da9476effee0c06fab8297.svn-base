package com.park.einvoice.dao.eih5;

import org.springframework.stereotype.Repository;

import com.park.einvoice.domain.vo.EmailInvoice;

/**
 * 用于邮件中查询发票信息
 * @author WangYuefei
 *
 */
@Repository(value="emailDao")
public interface EmailDao {
	/**
	 * 用发票请求流水号查询邮件中需要的发票信息
	 * @param invoiceReqSerialNo
	 * @return
	 */
	public EmailInvoice selectEmailInvoice(String invoiceReqSerialNo);
}
