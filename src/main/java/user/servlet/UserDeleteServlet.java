package user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.UserVO;
import user.service.UserService;
import user.service.UserServiceInf;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/deleteUser")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private UserServiceInf userService;
	
    public UserDeleteServlet() {
        super();
       userService = new UserService();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.회원 아이디를 받는다.
		String mem_id = request.getParameter("mem_id");
		
		//2.회원삭제를 한다
		UserVO userVO = new UserVO();
		userVO.setMem_id(mem_id);
		int deleteCnt = userService.deleteUser(userVO);
		
		//3.페이지이동(List)
		if(deleteCnt == 1){
			response.sendRedirect(request.getContextPath() + "/getUserPageList");
		}
		else{
			
		}
	}

}
