package net.developia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ClassicMVC extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String msg = "Spring MVC~!";
		ModelAndView mav = new ModelAndView();
		mav.setViewName("classic"); // 뷰리졸버 에게 전달
		mav.addObject("msg",msg); // 키,오브젝트
		return mav;
	}

}
