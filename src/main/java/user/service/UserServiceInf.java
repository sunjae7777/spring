package user.service;

import java.util.Map;

import user.model.UserVO;
/**
 * 
 * UserServiceInf.java
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
public interface UserServiceInf {
	/**
	 * 
	 * Method : loginProcesse
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "L.S.J"
	 * 변경이력 :
	 * @param userVO
	 * @return
	 * Method 설명 :로그인 프로세스
	 */
	public boolean loginProcesse(UserVO userVO);
	
	/**
	 * 
	 * Method : getUserPageList
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "L.S.J"
	 * 변경이력 :
	 * @param page
	 * @param pageSiz
	 * @return
	 * Method 설명 : 회원 페이지 List 조회
	 */
	public Map<String, Object> getUserPageList(int page, int pageSiz);
	
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
