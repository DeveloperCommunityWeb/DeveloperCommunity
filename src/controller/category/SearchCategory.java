package controller.category;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.dto.CategoryDTO;

import com.google.gson.Gson;

/**
 * Servlet implementation class SearchCategory
 */
@WebServlet("/SearchCategory")
public class SearchCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCategory() {
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
			ArrayList<CategoryDTO> searchCat = new CategoryDAO().searchCategory("web");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			String cat= new Gson().toJson(searchCat);
			response.getWriter().write(cat);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("category search ");
	}

}
