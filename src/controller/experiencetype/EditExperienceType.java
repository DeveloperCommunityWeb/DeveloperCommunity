package controller.experiencetype;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ExperienceTypeDAO;
import model.dto.ExperienceTypeDTO;

/**
 * Servlet implementation class EditExperienceType
 */
@WebServlet("/EditExperienceType")
public class EditExperienceType extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EditExperienceType() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ExperienceTypeDTO expt=new ExperienceTypeDTO();
			expt.setExperience_type_id(4);
			expt.setExperience_type_name("School");
			expt.setExperience_type_desc("Describe about School experience");
			boolean b = new ExperienceTypeDAO().updateExperienceType(expt);
			if(b){
				System.out.println("Edit Success");
			}
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
