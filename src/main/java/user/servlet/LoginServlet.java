package user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.UserVO;
import user.service.UserService;
import user.service.UserServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		
		UserVO user = new UserVO();
		user.setUserId(userId);
		user.setPassword(password);
		
		System.out.println("remember :" + remember);
		
		UserServiceInf service = new UserService();
		boolean loginResult = service.loginProcesse(new UserVO("", userId, password));
		if(loginResult){
			//쿠키 설정 파라미터가 넘어온 경우  쿠키값을 설정한다.
			setCookie(remember, userId, response);
			
			request.setAttribute("userId", userId);
			
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("user", user);
			
			ServletContext sc = getServletContext();
			sc.setAttribute("userId", "APPLICATION");
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect("login/login.jsp");
		}
	}
	
	
	private void setCookie(String remember, String userId, HttpServletResponse response) {
		//쿠키를 설정하는 경우(remember 값이 check 인 경우) 
		if(remember !=null && remember.equals("check")){
			Cookie cookie = new Cookie("userId", userId);
			cookie.setMaxAge(30 * 24 * 60 * 60);
			
			Cookie rememberCookie = new Cookie("remember", remember);
			rememberCookie.setMaxAge(30 * 24 * 60 * 60);
			
			response.addCookie(cookie);
			response.addCookie(rememberCookie);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
