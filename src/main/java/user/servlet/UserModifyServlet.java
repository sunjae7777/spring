package user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import user.model.UserVO;
import user.service.UserService;
import user.service.UserServiceInf;

/**
 * Servlet implementation class UserModifyServlet
 */
@WebServlet("/modifyUser")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*3*5)
public class UserModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserServiceInf userService;
    
    public UserModifyServlet() {
        super();
       userService = new UserService();
    }
    
    //사용자 수정 폼 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		//서비스 객체를 통해서 getUser
		UserVO userVO = userService.getUser(mem_id);
		
		//request 객체에 user 정보를 setAttribute
		request.setAttribute("userVO", userVO);
		
		//foward(/user/userModify.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("/user/userModify.jsp");
		rd.forward(request, response);
		
	}

	//사용자 정보 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mem_id = request.getParameter("mem_id");
		String mem_name = request.getParameter("mem_name");
		String mem_alias = request.getParameter("mem_alias");
		String mem_pass = request.getParameter("mem_pass");
		String mem_add1 = request.getParameter("mem_add1");
		String mem_add2 = request.getParameter("mem_add2");
		String mem_zip = request.getParameter("mem_zip");
		String mem_bir = request.getParameter("mem_bir");
		
		String mem_profilePath = "";
		
		//part에서 mem_profile 정보(파일 이름)
		Part mem_profilePart = request.getPart("mem_profilePart");
		
		if(mem_profilePart.getSize() > 0){
			String contentString = mem_profilePart.getHeader("Content-disposition");
		}
	}

}
