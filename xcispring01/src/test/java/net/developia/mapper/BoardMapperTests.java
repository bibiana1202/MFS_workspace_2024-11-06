package net.developia.mapper;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
//		mapper.getList().forEach(board ->log.info(board));
		List<BoardVO> list = mapper.getList();
		assertNotEquals(null, list);
	}    
	
	// 1. create(insert) 처리
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insert(board);
		
		log.info(board);
		
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 SELECT KEY");
		board.setContent("새로 작성하는 내용 select key");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	// 2. read(select) 처리
	@Test
	public void testRead() {
		// 존재하는 게시물 번호로 테스트
		BoardVO board = mapper.read(5L);
		
		log.info(board);
	}
	
	// 3. delete 처리
//	@Transactional // 테스트 하고 자동 롤백
	@Test
	public void testDelete() {
//		log.info("delete count : "+ mapper.delete(3L));
		assertTrue(1 == mapper.delete(3L));
	}
	
	// 4. update 처리
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		// 실행 전 존재하는 번호 인지 확인 할 것
		board.setBno(5L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
//		int count = mapper.update(board);
//		log.info("UPDATE COUNT " + count);
		assertTrue(1 == mapper.update(board));
	}
	
	// 페이징 처리
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		// 10개씩 3페이지
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board.getBno()));
	}
	
	// 검색 처리
	// Criteria 객체의 type과 keyword를 넣어서 원하는 SQL이 생성되는지 확인하기 위함
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("새로");
		cri.setType("TC");
		// 20개씩 3페이지
		cri.setPageNum(3);
		cri.setAmount(20);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}
}
