package user.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import user.model.UserVO;

public class UserServiceTest {

	
	@Test
	public void getUserPageListTest() {
		/***Given***/
		UserServiceInf userService = new UserService();
		int page =1;
		int pageSize =10;

		/***When***/
		Map<String, Object> resultMap = userService.getUserPageList(page, pageSize);

		/***Then***/
		//1.회원 페이지 List에 대한 검증
		List<UserVO> userList =(List<UserVO>) resultMap.get("userList"); 
		
		assertNotNull(userList);
		
		
		

	}

}
