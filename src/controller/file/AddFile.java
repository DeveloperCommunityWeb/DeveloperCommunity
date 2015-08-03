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

public class AddFile extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			FilesDTO file=new FilesDTO();
			file.setEmployee_id(1);
			file.setTitle("Dara");
			file.setUrl("www.dropbox.com/myrachna");
			file.setDescription("This book is talk about my love");
			boolean b=new FilesDAO().addFile(file);
			if(b) System.out.println("Add File Success");
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
