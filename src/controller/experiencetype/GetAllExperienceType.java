package controller.experiencetype;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ExperienceTypeDAO;
import model.dto.ExperienceTypeDTO;

/**
 * Servlet implementation class GetAllExperienceType
 */
@WebServlet("/GetAllExperienceType")
public class GetAllExperienceType extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GetAllExperienceType() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ArrayList<ExperienceTypeDTO> expt=new ArrayList<ExperienceTypeDTO>();
			expt=new ExperienceTypeDAO().getAllExperienceType();
			for(int i=0;i<expt.size();i++){
				System.out.println(expt.get(i).getExperience_type_id()+" "+expt.get(i).getExperience_type_name()+" "+expt.get(i).getExperience_type_desc());
			}
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
