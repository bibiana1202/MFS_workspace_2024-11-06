package net.developia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.developia.domain.BoardVO;
import net.developia.domain.Criteria;
import net.developia.domain.PageDTO;
import net.developia.service.BoardService;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Criteria cri ,Model model) {
		try {
			log.info("list......."+ cri);
			model.addAttribute("list",service.getList(cri));
			//model.addAttribute("pageMaker", new PageDTO(cri,123)); //전체데이터수 123
			
			// 전체 데이터 수 처리
			int total = service.getTotal(cri);
			log.info("total:"+total);
			model.addAttribute("pageMaker",new PageDTO(cri, total));
			
		} catch (Exception e) {
			// 유저에게 보여줄 메시지 리턴
			// 이동 할 곳도 지정할수도
			e.printStackTrace();
			
			
		}
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		try {
			log.info("register!!!!!!: "+board);
			service.register(board);
			rttr.addFlashAttribute("result",board.getBno()); // 값 유지 하기 위해서 RedirectAttributes -> 세션 사용
			return "redirect:/board/list"; // 새로운 화면으로 ,url 재이동
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	// 수정/삭제 가 가능한 화면으로 이동하는 것은 조회 페이지와 같습니다 ! 
	// @ModelAttribute 는 자동으로 Model에 데이터를 지정한 이름으로 담아준다.
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno,@ModelAttribute("cri") Criteria cri, Model model) {
		try {
			log.info("/get or modify");
			model.addAttribute("board",service.get(bno));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board,@ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		try {
			log.info("modify:" + board);
			
			if(service.modify(board)) {
				rttr.addFlashAttribute("result","success");
			}
			
//			rttr.addAttribute("pageNum",cri.getPageNum());
//			rttr.addAttribute("amount",cri.getAmount());
//			rttr.addAttribute("type",cri.getType());
//			rttr.addAttribute("keyword",cri.getKeyword());
//			return "redirect:/board/list";
			
			return "redirect:/board/list" + cri.getListLink();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno ,@ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		try {
			log.info("remove...."+bno);
			if(service.remove(bno)) {
				rttr.addFlashAttribute("result","success");
			}
//			rttr.addAttribute("pageNum",cri.getPageNum());
//			rttr.addAttribute("amount",cri.getAmount());
//			rttr.addAttribute("type",cri.getType());
//			rttr.addAttribute("keyword",cri.getKeyword());
//			return "redirect:/board/list";
			return "redirect:/board/list" + cri.getListLink();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
