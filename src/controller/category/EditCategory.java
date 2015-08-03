package controller.category;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.dto.CategoryDTO;

public class EditCategory extends HttpServlet{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * @see HttpServlet#HttpServlet()
     */
    public EditCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doprocess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doprocess(request, response);
	}
	
	
	protected void doprocess(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		try {
			CategoryDTO cat=new CategoryDTO();
			cat.setCate_id(10);
			cat.setCate_name("test cat");
			cat.setCate_desc("test desc");
			boolean state= new CategoryDAO().editCategory(cat);
			if(state){
				response.getWriter().write("true was edite");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("category edite");
	}
}
