package controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;

public class DeleteUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeleteUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			int id= Integer.parseInt(req.getParameter("id"));
			
			UserDAO dao;
			dao = new UserDAO();
			if(dao.deleteUser(id)){
				System.out.println("Delete Succesfull");
			}else{
				System.out.println("Delete UnSuccesfull");
			}
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			
			e.printStackTrace();
		}
		
	}
	

}
