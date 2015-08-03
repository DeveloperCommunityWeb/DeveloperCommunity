package controller.file;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FilesDAO;
import model.dto.FilesDTO;

public class GetAllFiles extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GetAllFiles() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			ArrayList<FilesDTO> files=new ArrayList<FilesDTO>();
			files=new FilesDAO().getAllFiles();
			for(int i=0;i<files.size();i++){
				System.out.println(files.get(i).getFile_id()+" "+files.get(i).getTitle()+" "+files.get(i).getUrl());
			}
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
