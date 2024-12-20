package net.developia.mapper;

import java.util.List;

import net.developia.domain.BoardVO;
import net.developia.domain.Criteria;

public interface BoardMapper {

//	@Select("select * from tbl_board where bno>0")
	public List<BoardVO> getList();
	
	// 페이징 처리
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	// 1. create(insert) 처리
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	// 2. read(select) 처리
	public BoardVO read(Long bno);
	
	// 3. delete 처리
	public int delete(Long bno);
	
	// 4. update 처리
	public int update(BoardVO board);
	
	// 전체 데이터 개수 처리
	public int getTotalCount(Criteria cri);
}
