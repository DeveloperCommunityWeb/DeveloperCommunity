package controller.experience;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ExperienceDAO;
import model.dto.ExperienceDTO;

public class GetAllExperiences extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ArrayList<ExperienceDTO> list=new ExperienceDAO().getAllExperience();
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i).getPostion());
			}
		}else System.out.println("No data");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	}
	
}

