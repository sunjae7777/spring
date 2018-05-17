package user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import ch.qos.logback.core.util.FileUtil;
import user.model.UserVO;
import user.service.UserService;
import user.service.UserServiceInf;

/**
 * Servlet implementation class UserInsertServlet
 */
@WebServlet("/userInsert")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*3*5)
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserServiceInf userService;
    
    public UserInsertServlet() {
        super();
        userService = new UserService();
    }

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
		
		//part에서 mem_profile정보(파일이름)
		Part mem_profilePart = request.getPart("mem_profile");
		String contentString = mem_profilePart.getHeader("Content-disposition");
		String fileName = FileUtil.getFileName(contentString);
		
		String uploadPath = getServletContext().getRealPath("/uploadFolder");
		// /uploadFoler/ryan.png
		String mem_profilePath = "/uploadFolder/" + fileName;
		String filePath = uploadPath + java.io.File.separator + fileName;
		
		mem_profilePart.write(filePath);
		mem_profilePart.delete();
		
		UserVO userVO = new UserVO(mem_id, mem_pass, mem_name, mem_bir, mem_add1, mem_add2, mem_zip, mem_profilePath, mem_alias);
		int insertCnt = userService.insertUser(userVO);
		System.out.println("insertCnt : "  +insertCnt);
		
		//정상적으로 신규 회원이 입력된 경우 : 회원 리스트 페이지로 이동
		if(insertCnt == 1){
			response.sendRedirect(request.getContextPath() + "/getUserPageList");
		}
		//정상적으로 회원 입력을 하지 못한 경우 : 신규 회원 입력 페이지
		else{
			
		}
	}

}
