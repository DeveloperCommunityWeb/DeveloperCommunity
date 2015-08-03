package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ActionLogin")
public class ActionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ActionLogin() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username.equals("admin") && password.equals("admin")){
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			response.sendRedirect("/DeveloperCommunity/admin/adduser");
		}else{
			response.sendRedirect("/DeveloperCommunity/login");
		}
	}

}
