package controller.employee;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmployeeDAO;
import model.dto.EmployeeDTO;

public class AddEmployee extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			java.util.Date utilDate = new java.util.Date(System.currentTimeMillis()); 
            java.sql.Date sqlDate2 = new java.sql.Date(utilDate.getTime()); 
			EmployeeDTO emp=new EmployeeDTO();
			emp.setFirst_name("Po");
			emp.setLast_name("Dara");
			emp.setSex(1);
			emp.setAddress("Takhmao Kandal");
			emp.setDOB(sqlDate2);
			emp.setEmail("dara@gmail.com");
			emp.setMarital_status(1);
			emp.setNationality("Cambodian");
			emp.setPhone("093757044");
			emp.setPOB("Takhmao Kandal");
			emp.setUser_id(2);
			emp.setSocial_network("Facebook.com/dara.po.129");
			boolean b= new EmployeeDAO().addUser(emp);
			if(b){
				System.out.println("Add Employee Success");
			}
		} catch (ClassNotFoundException | SQLException | NamingException e) {
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

	public AddEmployee() {
		super();
	}
	
}
