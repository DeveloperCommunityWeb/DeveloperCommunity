package controller.employeesubject;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmployeeSubjectDAO;
import model.dto.EmployeeSubjectDTO;

public class EditEmployeeSubject extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeSubject() {
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
			EmployeeSubjectDTO empSub=new EmployeeSubjectDTO();
			empSub.setEmp_id(1);
			empSub.setSub_id(17);
			empSub.setEmpsub_rate(5);
			empSub.setEmpsub_desc("edit test emp");
			empSub.setNewSubject(22);
			boolean state = new EmployeeSubjectDAO().editeEmployeeSubject(empSub);
			if(state){
				response.getWriter().write("true");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("empsub was added");
	}
}
