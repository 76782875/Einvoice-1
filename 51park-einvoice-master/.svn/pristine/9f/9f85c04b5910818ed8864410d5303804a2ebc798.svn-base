package com.park.einvoice.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.park.einvoice.common.ResultTools;
import com.park.einvoice.common.constants.CodeConstants;
import com.park.einvoice.domain.Demo;
import com.park.einvoice.service.DemoService;

@Controller
@RequestMapping("/demo")
public class DemoController {
	@Resource(name="demoServiceImpl")
	private DemoService demoService;
	
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/find")
	public String find(){
		
		Demo demo =demoService.get(1);
		if (null !=demo) {
			System.out.println("GET方法：姓名："+demo.getName()+  "年龄："+demo.getAge());
			//return "success";	
		}
		List list =demoService.findAll();
		@SuppressWarnings("unchecked")
		String result =ResultTools.setObjectListResponse(CodeConstants.成功.getCode(), list);
		System.out.println("FINDALL方法："+result);
		Demo demo2 =new Demo();
		demo2.setAge(12);
		demo2.setId(1);
		demo2.setName("PayCenter测试1");
//		else {
//			//return "查询结果为空";	
//		}
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value="/add")
	public String add(){
		
		Demo demo =new Demo();
		demo.setAge(22);
		demo.setName("张三");		
		logger.info("添加成功");		
		demoService.add(demo);
		return "success";	
	}
	
	@ResponseBody
	@RequestMapping(value="/update")
	public String update(){
		
		Demo demo =new Demo();
		demo.setAge(33);
		demo.setName("测试修改名称");		
		demo.setId(3);		
		demoService.update(demo);
		return "success";	
	}
	
	@ResponseBody
	@RequestMapping(value="/delete")
	public String delete(){
		demoService.delete(5);
		logger.error("测试日志");
		return "success";		
		
	}
   
}
