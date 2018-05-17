package user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.UserVO;
import user.service.UserService;
import user.service.UserServiceInf;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/getUser")
public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserServiceInf userService;
   
    public GetUserServlet() {
        super();
        userService = new UserService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		
		UserVO userVO = userService.getUser(mem_id);
		request.setAttribute("userVO", userVO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/usr.jsp");
		rd.forward(request, response);
	}


}
