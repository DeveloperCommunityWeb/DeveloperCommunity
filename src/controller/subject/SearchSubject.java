package controller.subject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SubjectDAO;
import model.dto.SubjectDTO;

import com.google.gson.Gson;

/**
 * Servlet implementation class SearchSubject
 */
@WebServlet("/SearchSubject")
public class SearchSubject extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSubject() {
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
			ArrayList<SubjectDTO> searchSub = new SubjectDAO().searchSubject("pho");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			String sub= new Gson().toJson(searchSub);
			response.getWriter().write(sub);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("sub search ");
	}

}
