package user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import user.dao.UserDao;
import user.dao.UserDaoInf;
import user.model.UserVO;

public class UserService implements UserServiceInf {
	
	private UserDaoInf userDao;
	
	private List<UserVO> userList;
	
	public UserService(){
		userDao = new UserDao();
		
		userList = new ArrayList<UserVO>();
		userList.add(new UserVO("brown", "brown", "brownpass"));
		userList.add(new UserVO("cony", "cony", "conypass"));
		userList.add(new UserVO("sally", "brownsally", "sallypass"));
		userList.add(new UserVO("moon", "moon", "moonpass"));
	}
	/**
	 * 
	 * Method : loginProcesse
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "L.S.J"
	 * 변경이력 :
	 * @param userVO
	 * @return
	 * Method 설명 : 로그인 프로세스
	 */
	@Override
	public boolean loginProcesse(UserVO userVO) {
		boolean loginResult =false;
		for(UserVO vo : userList){
			if(vo.equals(userVO)){
				loginResult = true;
				break;
			}
		}
		return loginResult;
	}
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
	@Override
	public Map<String, Object> getUserPageList(int page, int pageSiz) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String pageNav = makePageNav(page, userDao.getUserTotalCnt());
		
		resultMap.put("userList", userList);
		resultMap.put("pageNav", pageNav);
	
		return resultMap;
	}
	
	/**
	 * 
	 * Method : makePageNav
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "L.S.J"
	 * 변경이력 :
	 * @param page
	 * @param userTotalCnt
	 * @return
	 * Method 설명 : 페이지 내비게이션 생성
	 */
	private String makePageNav(int page, int userTotalCnt){
		int pageTotalCnt = (int)Math.ceil((double)userTotalCnt / 10);
		
		StringBuffer pageNav = new StringBuffer();
		pageNav.append("<nav>");
		pageNav.append("	<ul class=\"pagination\">");
		pageNav.append("		<li>");
		pageNav.append("			<a href=\"getUserPageList?page=1&pageSize=10\" aria-label=\"Previous\">");
		pageNav.append("				<span aria-hidden=\"true\">&laquo;</span>");
		pageNav.append("			</a>");
		pageNav.append("		</li>");
		
		for(int i=1; i<=pageTotalCnt; i++){
			if(i == page)
				pageNav.append("		<li class=\"active\"><a href=\"getUserPageList?page=" + i + "&pageSize=10\">" + i + "</a></li>");
			else
				pageNav.append("		<li ><a href=\"getUserPageList?page=" + i + "&pageSize=10\">" + i + "</a></li>");	
		}
		
		pageNav.append("		<li>");
		pageNav.append("			<a href=\"getUserPageList?page=" + pageTotalCnt + "&pageSize=10\" aria-label=\"Next\">");
		pageNav.append("				<span aria-hidden=\"true\">&raquo;</span>");
		pageNav.append("			</a>");
		pageNav.append("		</li>");
		pageNav.append("	</ul>");
		pageNav.append("</nav>");
		return pageNav.toString();
		
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
		return userDao.getUser(mem_id);
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
		return userDao.insertUser(userVO);
	}
	
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
	@Override
	public int deleteUser(UserVO userVO) {
		return userDao.deleteUser(userVO);
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
		return userDao.modifyUser(userVO);
	}

}
