package com.park.einvoice.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.park.einvoice.dao.mybatis.BaseDao;
import com.park.einvoice.dao.mybatis.MyBatisRepository;
import com.park.einvoice.domain.Enterprise;
import com.park.einvoice.domain.EnterpriseRegister;

@MyBatisRepository
@Repository(value="enterpriseRegisterDao")
public interface EnterpriseRegisterDao extends BaseDao<EnterpriseRegister, Serializable> {

	/**
	 * 将注册完成的企业的企业编码和税号插入注册表中
	 * @param enterprise 传去企业对象
	 */
	public void insertReg(Enterprise enterprise);

	/**
	 * 获取已注册企业在注册表中的唯一ID
	 * @param taxpayerNum 参数为企业的税号
	 * @return 返回ID Integer
	 */
	public Integer getId(String taxpayerNum);
	
}
