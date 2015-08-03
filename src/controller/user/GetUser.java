package controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.dto.UserDTO;

@WebServlet("/GetUser")
public class GetUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GetUser() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			UserDTO usr=new UserDAO().getUser(id);
			request.setAttribute("user",usr);
//			.setAttribute("user",usr);
//			response.sendRedirect("admin/viewadduser");
			RequestDispatcher rd= request.getRequestDispatcher("viewadduser");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}
	}

}
