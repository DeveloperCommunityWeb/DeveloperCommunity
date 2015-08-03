package controller.experience;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ExperienceDAO;
import model.dto.ExperienceDTO;

public class AddExperience extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AddExperience() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String place="KSHRD";//request.getParameter("place");
			String position="Instructor4";//request.getParameter("position");
			String start="2015-25-25";//request.getParameter("date");
			String end="2015-20-20";//request.getParameter("end");
			int type=2;//Integer.parseInt(request.getParameter("type"));
			String skill="Web Development";//request.getParameter("skill");
			String desc="";//request.getParameter("desc");
			int empid=1;//Integer.parseInt(request.getParameter("empid"));
			
			ExperienceDTO exp=new ExperienceDTO();
			
			exp.setPlace(place);
			exp.setPostion(position);
			exp.setStart(start);
			exp.setEnd(end);
			exp.setType(type);
			exp.setSkill(skill);
			exp.setDesc(desc);
			exp.setEmpid(empid);
			
			if(new ExperienceDAO().insertExperience(exp)){
				System.out.println("Success");
			}else System.out.println("Failed");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
