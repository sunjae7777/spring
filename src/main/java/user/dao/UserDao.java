package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.model.UserVO;

/**
 * 
 * UserDao.java
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
public class UserDao implements UserDaoInf {
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDao() {
		String resource= "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Method : getUserPageList
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "L.S.J"
	 * 변경이력 :
	 * @param page
	 * @param pageSize
	 * @return
	 * Method 설명 : 회원 페이지 List 조회
	 */
	@Override
	public List<UserVO> getUserPageList(int page, int pageSize) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserVO> userList = sqlSession.selectList("user.getUserPageList", paramMap);
		sqlSession.close();
		
		return userList;
	}
	
	/**
	 * 
	 * Method : getUserTotalCnt
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "L.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 유저 건수 조회
	 */
	@Override
	public int getUserTotalCnt() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int userTotalCnt = sqlSession.selectOne("user.getUserTotalCnt");
		sqlSession.close();
		
		return userTotalCnt;
	}
	
	
	/**
	 * 
	 * Method : getUser
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "L.S.J"
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 회원 상세정보 조회
	 */
	@Override
	public UserVO getUser(String mem_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserVO userVO = sqlSession.selectOne("user.getUser", mem_id);
		sqlSession.close();
		
		return userVO;
	}
	
	/**
	 * 
	 * Method : insertUser
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "L.S.J"
	 * 변경이력 :
	 * @param userVO
	 * @return
	 * Method 설명 : 사용자 신규 입력
	 */
	@Override
	public int insertUser(UserVO userVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insertCnt = sqlSession.insert("user.insertUser", userVO);
		sqlSession.commit();
		sqlSession.close();
		
		return insertCnt;
	}
	
	/**
	 * 
	 * Method : deleteUser
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "L.S.J"
	 * 변경이력 :
	 * @param userVO
	 * @return
	 * Method 설명 : 사용자 정보 삭제
	 */
	@Override
	public int deleteUser(UserVO userVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int deleteCnt = sqlSession.delete("user.deleteUser", userVO);
		sqlSession.commit();
		sqlSession.close();
		
		return deleteCnt;
	}
	
	/**
	 * 
	 * Method : modifyUser
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "L.S.J"
	 * 변경이력 :
	 * @param userVO
	 * @return
	 * Method 설명 : 사용자 정보 수정 
	 */
	@Override
	public int modifyUser(UserVO userVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int updateCnt = sqlSession.update("user.modifyUser", userVO);
		
		sqlSession.commit();
		sqlSession.close();
		
		return updateCnt;
	}




}
