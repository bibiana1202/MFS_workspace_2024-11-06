package net.developia.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	// 구현체를 안만들게 해놓음 ... 만들어준다는뜻~~  MyBatis-Spring
	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	public String getTime2();
}
