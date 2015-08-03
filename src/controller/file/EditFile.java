package controller.file;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FilesDAO;
import model.dto.FilesDTO;

public class EditFile extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			FilesDTO file=new FilesDTO();
			file.setTitle("Rachna");
			file.setUrl("www.facebook.com/rachna");
			file.setDescription("Book about Rachna");
			file.setEmployee_id(1);
			file.setFile_id(4);
			boolean b=new FilesDAO().updateFile(file);
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
