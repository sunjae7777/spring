package user.dao;

import java.util.List;


import user.model.UserVO;

public interface UserDaoInf {
	/**
	 * 
	 * Method : getUserPageList
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "L.S.J"
	 * 변경이력 :
	 * @param page
	 * @param pageSize
	 * @return
	 * Method 설명 :
	 */
	public List<UserVO> getUserPageList(int page, int pageSize);
	
	/**
	 * 
	 * Method : getUserPageList
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "L.S.J"
	 * 변경이력 :
	 * @param page
	 * @param pageSiz
	 * @return
	 * Method 설명 : 전체 유저 건수 조회
	 */
	public int getUserTotalCnt();
	
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
	public UserVO getUser(String mem_id);
	
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
	public int insertUser(UserVO userVO);
	
	/**
	 * 
	 * Method : deleteUser
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "L.S.J"
	 * 변경이력 :
	 * @param userVO
	 * @return
	 * Method 설명 : 회원 정보 삭제
	 */
	public int deleteUser(UserVO userVO);
	
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
	public int modifyUser(UserVO userVO);
	
	
	
}
