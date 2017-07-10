package com.park.einvoice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.park.einvoice.common.DateTools;
import com.park.einvoice.dao.DemoDao;
import com.park.einvoice.domain.Demo;
import com.park.einvoice.service.DemoService;
@Repository(value="demoServiceImpl")
public class DemoServiceImpl implements DemoService {
	
	@Resource(name="demoDao")
	private DemoDao demoDao;
	
	public Demo get(int id) {
		return demoDao.get(Demo.class, id);
	}
	
	public List<Demo> findAll() {
		return demoDao.findAll(Demo.class);
	}
	

	public int add(Demo demo) {
		return demoDao.insert(demo);
	}

	public int update(Demo demo) {
		return demoDao.update(demo);
	}

	public int delete(int id) {
		return demoDao.deleteById(Demo.class, id);
	}


	public void testTask(){
		System.out.println("hello task!"+ DateTools.Date());
	}
}
