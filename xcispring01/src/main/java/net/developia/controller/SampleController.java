package net.developia.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.java.Log;
import net.developia.domain.SampleDTO;
import net.developia.domain.SampleDTOList;
import net.developia.domain.TodoDTO;

@Controller
@RequestMapping("/sample/*")
@Log
public class SampleController {

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	
	// 메소드 단위로 호출 가능
	@RequestMapping(value = "") // 모든 request 메소드 가능
	public void basic() {
		log.info("basic.......");
	}
	
	@RequestMapping(value="/basic",method= {RequestMethod.GET,RequestMethod.POST})
	public void basicGet() {
		log.info("basic...get....");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get onlt get......");
	}
	
	@GetMapping("/ex01")
	public String ex01(@ModelAttribute("dto") SampleDTO dto
			,Model model) { //command object
		log.info(""+dto);
		model.addAttribute("dto",dto); // 주석 처리 해도 된다도 함....
		return "ex";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age
			,Model model) {
		log.info("name:" + name);
		log.info("age:"+age);
		model.addAttribute("name",name); 
		model.addAttribute("age",age);
		
		return "ex";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids: "+ ids);		
		return "ex02Array";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(@ModelAttribute SampleDTOList list) {
		log.info("list dtos :" + list);
		return "ex02Bean";
	}
	
    @GetMapping("/ex03")
    public String ex03(@ModelAttribute TodoDTO todo) {
       log.info("todo: " + todo);
       return "ex03";
    }
	
	@GetMapping("/exsp")
	public ModelAndView exsp() {
		ModelAndView mav = new ModelAndView("ex");
		mav.addObject("name","name sp");
		mav.addObject("age",99);
		return mav;
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() { 
		// @ResponseBody : 비즈니스 로직 뷰 로 보내 랜더링 안보내는 경우도 있는데 
		// , ajax 경우 데이터만 보내서 일부분만 바꾸고 싶은 경우에
		// 뷰안거치고 데이터만 바로 브라우저로 보내는 restful, api 같은거
		log.info("/ex06....");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		// xml 형태로 보내짐(.xml)
		// .json 하면 json
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		log.info("ex07......");
		
		String msg= "{\"name\":\"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg,header,HttpStatus.OK);
	}
}
