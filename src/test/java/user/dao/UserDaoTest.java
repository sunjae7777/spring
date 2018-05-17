package user.dao;

import static org.junit.Assert.*;

import java.util.List;


import org.junit.Test;

import user.model.UserVO;
/**
 * 
 * UserDaoTest.java
 *
 * @author "L.S.J"
 * @since 2018. 5. 15.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 15. "L.S.J" 최초 생성
 *
 * </pre>
 */
public class UserDaoTest {

	/**
	 * 
	 * Method : getUserPageListTest
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "L.S.J"
	 * 변경이력 :
	 * Method 설명 : 회원 페이지 List 조회 테스트
	 */
	@Test
	public void getUserPageListTest() {
		/***Given***/
		UserDaoInf userDao = new UserDao();
		int page = 1;
		int pageSize = 10;

		/***When***/
		List<UserVO> userList = userDao.getUserPageList(page, pageSize);
			//System.out.println(userList);
			for(UserVO user : userList)
			System.out.println(user);
		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList.size());

		
	}

}
