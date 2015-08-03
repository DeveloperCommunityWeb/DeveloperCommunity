package controller.subject;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SubjectDAO;

public class DeleteSubject extends HttpServlet{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSubject() {
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
			boolean state =new SubjectDAO().deleteSubject(73);
			if(state){
				response.getWriter().write("true");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("subject delete");
	}
}
