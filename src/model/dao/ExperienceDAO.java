package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.ExperienceDTO;
import configuration.Utilities;

public class ExperienceDAO {
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	public ExperienceDAO(){
		con=new Utilities().dbConnect();
	}
	public boolean insertExperience(ExperienceDTO exp){
		String sql="INSERT INTO tb_experiences (exp_place, exp_position, exp_startdate, exp_enddate,"
				 + " exp_skill, exp_desc, expt_id, emp_id) VALUES(?,?,?,?,?,?,?,?);";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, exp.getPlace());
			pstmt.setString(2, exp.getPostion());
			pstmt.setDate(3,Date.valueOf(exp.getStart()));
			pstmt.setDate(4,Date.valueOf(exp.getEnd()));
			pstmt.setString(5, exp.getSkill());
			pstmt.setString(6, exp.getDesc());
			pstmt.setInt(7, exp.getType());
			pstmt.setInt(8, exp.getEmpid());
			con.setAutoCommit(false);
			if(pstmt.executeUpdate()>0){ con.commit();return true;}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateExperience(ExperienceDTO exp){
		String sql="UPDATE tb_experiences SET exp_place=?, exp_position=?, exp_startdate=?,exp_enddate=?,exp_skill=?,"
				+ "exp_desc=?,expt_id=?,emp_id=? WHERE exp_id=?";
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, exp.getPlace());
			pstmt.setString(2, exp.getPostion());
			pstmt.setDate(3, Date.valueOf(exp.getStart()));
			pstmt.setDate(4, Date.valueOf(exp.getEnd()));
			pstmt.setString(5, exp.getSkill());
			pstmt.setString(6, exp.getDesc());
			pstmt.setInt(7, exp.getType());
			pstmt.setInt(8, exp.getEmpid());
			pstmt.setInt(9, exp.getId());
			con.setAutoCommit(false);
			if(pstmt.executeUpdate()>0){con.commit(); return true;}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean deleteExperience(int id){
		String sql="DELETE FROM tb_experiences WHERE exp_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			con.setAutoCommit(false);
			if(pstmt.executeUpdate()>0){con.commit();return true;}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {pstmt.close(); con.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return false;
	}
	public ArrayList<ExperienceDTO> getAllExperience(){
		String sql="SELECT * FROM tb_experiences;";
		ArrayList<ExperienceDTO> list=new ArrayList<ExperienceDTO>();
		try{
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ExperienceDTO exp=new ExperienceDTO();
				exp.setId(rs.getInt(1));
				exp.setPlace(rs.getString(2));
				exp.setPostion(rs.getString(3));
				exp.setStart(rs.getDate(4).toString());
				exp.setEnd(rs.getDate(5).toString());
				exp.setSkill(rs.getString(6));
				exp.setDesc(rs.getString(7));
				exp.setType(rs.getInt(8));
				exp.setEmpid(rs.getInt(9));
				list.add(exp);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {rs.close(); pstmt.close(); con.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return list;
	}
	
	}

