package controller.employeesubject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmployeeSubjectDAO;
import model.dto.EmployeeSubjectDTO;

import com.google.gson.Gson;

/**
 * Servlet implementation class veiewEmployeeSubject
 */
@WebServlet("/veiewEmployeeSubject")
public class ViewEmployeeSubject extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmployeeSubject() {
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
			ArrayList<EmployeeSubjectDTO> listEmp = new EmployeeSubjectDAO().veiewEmployeeSubject(1);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			String emp= new Gson().toJson(listEmp);
			response.getWriter().write(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("emp list");
	}

}
