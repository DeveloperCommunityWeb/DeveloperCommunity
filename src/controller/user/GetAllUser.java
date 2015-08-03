package controller.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.dto.UserDTO;

public class GetAllUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GetAllUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			ArrayList<UserDTO> users=new ArrayList<UserDTO>();
			users=new UserDAO().getAllUsers();
			req.setAttribute("allUser",users);
			RequestDispatcher rd= req.getRequestDispatcher("listuser.jsp");
			rd.forward(req, resp);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
