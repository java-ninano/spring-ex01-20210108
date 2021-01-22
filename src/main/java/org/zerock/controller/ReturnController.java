package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.Member;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/return/*")
@Log4j
public class ReturnController {
	
	@RequestMapping("/ex1")
	public String method1() { 
		//string으로 리턴하면 =view(jsp)의 이름 -->servlet.context.xml Internal~설정 파일 때문에
		log.info("method1");
		return "returnView1"; //forward
	}
	
	@RequestMapping("/ex2")
	public String method2() { 
		log.info("method2");
		
		// 일을 마치면 forward or redirect
		return "redirect:/sample/"; //현재 servlet-context path로 redirect, context path 지정 안해도 됨
	}
	
	@RequestMapping("/ex3")
	public @ResponseBody String method3() { //text 값이 응답자체가 됨 @ResponseBody== returnValue3 hi there~~~~~~
		log.info("method3");
		
		return "returnValue3 hi there~~~~~~";
	}
	
	
	@RequestMapping("/ex4")
	public void method4() {
		log.info("method4"); //void 일 경우 : 요청경로가 jsp 파일 경로가 됨
	}
	
	@RequestMapping("/ex5")
	public @ResponseBody Member method5() {
		log.info("method5");
		Member member = new Member();
		
		member.setName("selah");
		member.setAge(20);
		
	
		//jason, 146page
		// {"name":"selah", "age":20} 
		
		return member;
	}

}
