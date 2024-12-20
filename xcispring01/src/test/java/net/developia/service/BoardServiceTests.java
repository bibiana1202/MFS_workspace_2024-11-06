package net.developia.service;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;
import net.developia.domain.BoardVO;
import net.developia.domain.Criteria;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:**/*-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	// 1. 등록 작업의 구현 과 테스트
	@Test
	public void testRegister() throws Exception {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호" + board.getBno());
	}
	 
	// 2.목록(리스트) 작업의 구현과 테스트
	@Test
	public void testGetList() throws Exception {
//		service.getList().forEach(board->log.info(board));
		service.getList(new Criteria(2,10)).forEach(board ->log.info(board));
	}

	
	//3. 조회 작업의 구현과 테스트
	public void testGet() throws Exception{
		log.info(service.get(1L));
	}
	
	//4.삭제/수정 구현과 테스트
	@Test
	public void testDelete() throws Exception {
		log.info("REMOVE RESULT: " + service.remove(4L));
	}
	
	@Test
	public void testUpdate() throws Exception {
		
		BoardVO board = service.get(1L);
		if(board == null) {
			return;
		}
		
		board.setTitle("제목 수정합니다");
		log.info("MODIFY RESULT: " + service.modify(board));
		
	}
}
