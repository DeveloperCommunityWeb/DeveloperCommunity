package controller.experiencetype;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ExperienceTypeDAO;
import model.dto.ExperienceTypeDTO;

public class AddExperienceType extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddExperienceType() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			ExperienceTypeDTO expt=new ExperienceTypeDTO();
			expt.setExperience_type_name("Work");
			expt.setExperience_type_desc("Describe about Work experience");
			boolean b=new ExperienceTypeDAO().addExperienceType(expt);
			if(b){
				System.out.println("Add Success");
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

}
