package net.developia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.developia.domain.BoardVO;
import net.developia.mapper.BoardMapper;

@Log4j
@Service // 비즈니스 레이어가 된다~
@AllArgsConstructor // 내부에 있는 필드를 가지고 생성자를 자동으로 만들어줌. (constructor injection)
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) throws Exception {
		log.info("register....."+board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) throws Exception {
		log.info("get......"+bno);
		BoardVO board = mapper.read(bno);
		if(board == null) throw new RuntimeException(bno + "게시물이 없음");
		return board;
	}

	@Override
	public boolean modify(BoardVO board) throws Exception {
		log.info("modify...."+board);
		
		if( mapper.update(board) == 0) 
			throw new RuntimeException(board.getBno()+"번 게시물이 수정되지 않음");
		return true;
	}

	@Override
	public boolean remove(Long bno) throws Exception {
		log.info("remove...."+bno);
		
		if( mapper.delete(bno) == 0) 
			throw new RuntimeException(bno+"번 게시물이 삭제되지 않음");
		return true;
	}

	@Override
	public List<BoardVO> getList() throws Exception {
		log.info("getList......");
		return mapper.getList();
	}



}
