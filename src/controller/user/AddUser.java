package controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.dto.UserDTO;

public class AddUser extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String username=req.getParameter("username");
			String useremail=req.getParameter("useremail");
			String password=req.getParameter("password");
			int type=Integer.parseInt(req.getParameter("type"));
			UserDTO user=new UserDTO();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(useremail);
			user.setPosition(type);
			user.setStatus(1);		
			boolean b=new UserDAO().addUser(user);
			resp.setContentType("text/plain");
			
			if(b){
				System.out.println("Success");
				resp.getWriter().write("success");
				RequestDispatcher rd=req.getRequestDispatcher("/admin/viewadduser");
				rd.forward(req, resp);
			}else{
				System.out.println("False");

				resp.getWriter().write("fail");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String username=req.getParameter("username");
			String useremail=req.getParameter("useremail");
			String password=req.getParameter("password");
			int type=Integer.parseInt(req.getParameter("type"));
			UserDTO user=new UserDTO();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(useremail);
			user.setPosition(type);
			user.setStatus(1);		
			boolean b=new UserDAO().addUser(user);
			resp.setContentType("text/plain");
			
			if(b){
				System.out.println("Success");
				resp.getWriter().write("success");
				resp.sendRedirect("viewadduser");
			}else{
				System.out.println("False");
				resp.getWriter().write("fail");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
