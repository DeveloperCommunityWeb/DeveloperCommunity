package controller.experience;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ExperienceDAO;
import model.dto.ExperienceDTO;

public class EditExperience extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		String place="RUPP";req.getParameter("place");
		String position="Student";//req.getParameter("position");
		String start="2011-05-20";req.getParameter("date");
		String end="2015-08-25";//req.getParameter("end");
		int type=1;//Integer.parseInt(req.getParameter("type"));
		String skill="Information Technology";//req.getParameter("skill");
		String desc="";req.getParameter("desc");
		int empid=1;//Integer.parseInt(req.getParameter("empid"));
		int id=6;//Integer.parseInt(req.getParameter("expid"));
		ExperienceDTO exp=new ExperienceDTO();
		exp.setPlace(place);
		try {
			exp.setPostion(position);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			exp.setStart(start);
		} catch (Exception e) {
			e.printStackTrace();
		}
		exp.setEnd(end);
		exp.setType(type);
		exp.setSkill(skill);
		exp.setDesc(desc);
		exp.setEmpid(empid);
		exp.setId(id);
		
		if(new ExperienceDAO().updateExperience(exp))System.out.println("Success");
		else System.out.println("Failed");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
	}
	
}
