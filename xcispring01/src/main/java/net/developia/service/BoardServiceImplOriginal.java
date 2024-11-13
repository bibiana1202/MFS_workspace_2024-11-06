package net.developia.service;

import java.util.List;

import lombok.extern.log4j.Log4j;
import net.developia.domain.BoardVO;
import net.developia.mapper.BoardMapper;

@Log4j
//@Service // 비즈니스 레이어가 된다~
//@AllArgsConstructor // 내부에 있는 필드를 가지고 생성자를 자동으로 만들어줌. (constructor injection)
public class BoardServiceImplOriginal implements BoardService {
	
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) throws Exception {
		try {
			log.info("register....."+board);
			mapper.insertSelectKey(board);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(null);
		}
	}

	@Override
	public BoardVO get(Long bno) throws Exception {
		try {
			log.info("get......"+bno);
			BoardVO board = mapper.read(bno);
			if(board == null) throw new RuntimeException(bno + "게시물이 없음");
			return board;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean modify(BoardVO board) throws Exception {
		try {
			log.info("modify...."+board);
			
			if( mapper.update(board) == 0) 
				throw new RuntimeException(board.getBno()+"번 게시물이 수정되지 않음");
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean remove(Long bno) throws Exception {
		try {
			log.info("remove...."+bno);
			
			if( mapper.delete(bno) == 0) 
				throw new RuntimeException(bno+"번 게시물이 삭제되지 않음");
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public List<BoardVO> getList() throws Exception {
		
		try {
			log.info("getList......");
			return mapper.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			throw e;
		}
	}



}
