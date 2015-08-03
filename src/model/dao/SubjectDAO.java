package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.SubjectDTO;
import configuration.Utilities;

public class SubjectDAO {
	private Connection cnn=null;
	
	/*
	 * constructor connection to data base
	 */
	public SubjectDAO(){
		cnn= new Utilities().dbConnect();
	}
	
	/*
	 * list all subject and return by arrayList
	 */
	public ArrayList<SubjectDTO> getAllSubjects() throws SQLException{
		ArrayList<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
		try {
			String sql="SELECT S.sub_id, S.sub_name, S.sub_desc, C.cate_name FROM tb_subjects S INNER JOIN tb_categories C ON S.cate_id = C.cate_id ";
			PreparedStatement pstmt = cnn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				SubjectDTO sub = new SubjectDTO();
					sub.setSub_id(rs.getInt(1));
					sub.setSub_name(rs.getString(2));
					sub.setSub_desc(rs.getString(3));
					sub.setCate_name(rs.getString(4));
					subjects.add(sub);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return subjects;
	}
	
	/*
	 * Add record to subject
	 */
	public boolean addSubject(SubjectDTO sub) throws SQLException{
		try {
			PreparedStatement pstm=cnn.prepareStatement("Insert INTO tb_subjects ( sub_name , sub_desc, cate_id) values(?,?,?)");
			pstm.setString(1, sub.getSub_name());
			pstm.setString(2, sub.getSub_desc());
			pstm.setInt(3, sub.getCate_id());
			if(pstm.executeUpdate()>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cnn.close();
		}
		return false;
	}
	
	/*
	 * edite record in subject
	 */
	public boolean editSubject(SubjectDTO sub) throws SQLException{
		try {
			String sql ="UPDATE tb_subjects SET sub_name=? , sub_desc=?, cate_id=? WHERE sub_id=?";
			PreparedStatement pstmt = cnn.prepareStatement(sql);
			pstmt.setString(1, sub.getSub_name());
			pstmt.setString(2, sub.getSub_desc());
			pstmt.setInt(3, sub.getCate_id());
			pstmt.setInt(4, sub.getSub_id());
			pstmt.executeUpdate();
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return false;
	}
	
	/*
	 * delete record from Subject
	 */
	public boolean deleteSubject(int id) throws SQLException{
		try{
			String sql="DELETE FROM tb_subjects WHERE sub_id=?";
			PreparedStatement pstm=cnn.prepareStatement(sql);
			pstm.setInt(1, id);
			if(pstm.executeUpdate()>0){
				return true;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			cnn.close();
		}
		return false;
	}
	
	/*
	 * search subject and return by arrayList
	 */
	public ArrayList<SubjectDTO> searchSubject(String sub_name) throws SQLException{
		ArrayList<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
		try {
			String sql="SELECT S.sub_id, S.sub_name, S.sub_desc, C.cate_name FROM tb_subjects S INNER JOIN tb_categories C ON S.cate_id = C.cate_id WHERE LOWER(S.sub_name) LIKE LOWER(?)";
			PreparedStatement pstmt = cnn.prepareStatement(sql);
			pstmt.setString(1, "%"+sub_name+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				SubjectDTO sub = new SubjectDTO();
					sub.setSub_id(rs.getInt(1));
					sub.setSub_name(rs.getString(2));
					sub.setSub_desc(rs.getString(3));
					sub.setCate_name(rs.getString(4));
					subjects.add(sub);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return subjects;
	}
	
	/*
	 * list record in subject and return ArrayList
	 */
	public ArrayList<SubjectDTO> viewSubject(int id) throws SQLException{
		ArrayList<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
		try {
			String sql="SELECT S.sub_id, S.sub_name, S.sub_desc, C.cate_name FROM tb_subjects S INNER JOIN tb_categories C ON S.cate_id = C.cate_id WHERE sub_id=?";
			PreparedStatement pstmt = cnn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
					SubjectDTO sub = new SubjectDTO();
					sub.setSub_id(rs.getInt(1));
					sub.setSub_name(rs.getString(2));
					sub.setSub_desc(rs.getString(3));
					sub.setCate_name(rs.getString(4));
					subjects.add(sub);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return subjects;
	}
	
	
	
	
}
