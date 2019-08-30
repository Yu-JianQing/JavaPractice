package ch9x8;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DaoUser {
	
	public List<POUser> selectUserByUname(POUser user);
	
}
