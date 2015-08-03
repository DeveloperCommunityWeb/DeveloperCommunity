package controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.dto.UserDTO;

public class EditUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			UserDTO user=new UserDTO();
			user.setUsername("Rachna");
			user.setPassword("123456");
			user.setEmail("rachna@gamil.com");
			user.setPosition(0);
			user.setStatus(1);
			user.setUser_id(4);
			boolean b=new UserDAO().updateUser(user);
			if(b) System.out.println("Update Success");
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
