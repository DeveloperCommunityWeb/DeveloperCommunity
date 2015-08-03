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


public class EditStatus extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(req.getParameter("ID"));
			UserDTO usr= new UserDTO();
			usr.setStatus(Integer.parseInt(req.getParameter("sta")));
			usr.setUser_id(id);
			System.out.println(usr.getUser_id()+" "+usr.getStatus());
			resp.setContentType("text/plain");
			if(new UserDAO().updateStatus(usr)){
				System.out.println("Update SUCCESS");
				resp.getWriter().write("success");
			}else{
				System.err.println("Update FAIL");
				resp.getWriter().write("fail");
			}
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			
			e.printStackTrace();
		}
	}
}
