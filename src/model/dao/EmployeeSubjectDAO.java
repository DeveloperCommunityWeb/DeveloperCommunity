package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.EmployeeSubjectDTO;
import model.dto.SubjectDTO;
import configuration.Utilities;

public class EmployeeSubjectDAO {
	private Connection cnn = null;

	/*
	 * constructor connection to data base
	 */
	public EmployeeSubjectDAO() {
		cnn = new Utilities().dbConnect();
	}

	
	
	/*
	 * list all employee subject and return by arrayList
	 */
	public ArrayList<EmployeeSubjectDTO> getAllEmployeeSubject() throws SQLException {
		ArrayList<EmployeeSubjectDTO> employeeSubjects = new ArrayList<EmployeeSubjectDTO>();
		try {
			String sql = "SELECT E.emp_id, E.sub_id, E.empsub_rate, E.empsub_desc, S.sub_name, S.sub_desc, C.cate_name FROM tb_subjects S "
					+ "INNER JOIN tb_categories C ON S.cate_id = C.cate_id "
					+ "INNER JOIN tb_empsubjects E ON E.sub_id = S.sub_id";
			PreparedStatement pstmt = cnn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeSubjectDTO emp = new EmployeeSubjectDTO();
					emp.setEmp_id(rs.getInt(1));
					emp.setSub_id(rs.getInt(2));
					emp.setEmpsub_rate(rs.getInt(3));
					emp.setEmpsub_desc(rs.getString(4));
						SubjectDTO sub=new SubjectDTO();
							sub.setSub_name(rs.getString(5));
							sub.setSub_desc(rs.getString(6));
							sub.setCate_name(rs.getString(7));
							emp.setSubjectDTO(sub);
					employeeSubjects.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cnn.close();
		}
		return employeeSubjects;
	}
	
	/*
	 * Add Employee Subject
	 */
	public boolean addEmployeeSubject(EmployeeSubjectDTO empSub) throws SQLException{
		try {
			PreparedStatement pstm=cnn.prepareStatement("Insert INTO tb_empsubjects (emp_id, sub_id, empsub_rate, empsub_desc) values(?,?,?,?)");
			pstm.setInt(1, empSub.getEmp_id());
			pstm.setInt(2, empSub.getSub_id());
			pstm.setInt(3, empSub.getEmpsub_rate());
			pstm.setString(4, empSub.getEmpsub_desc());
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
	 * edite record in EmployeeSubject
	 */
	public boolean editeEmployeeSubject(EmployeeSubjectDTO empSub) throws SQLException{
		try {
			PreparedStatement pstm=cnn.prepareStatement("UPDATE tb_empsubjects SET sub_id=?, empsub_rate=?, empsub_desc=?  WHERE emp_id=? AND sub_id=?");
			pstm.setInt(1, empSub.getNewSubject());
			pstm.setInt(2, empSub.getEmpsub_rate());
			pstm.setString(3, empSub.getEmpsub_desc());
			pstm.setInt(4, empSub.getEmp_id());
			pstm.setInt(5, empSub.getSub_id());
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
	 * delete record from employeeSubject
	 */
	public boolean deleteEmployeeSubject(int emp_id, int sub_id) throws SQLException{
		try{
			String sql="DELETE FROM tb_empsubjects WHERE emp_id=? AND sub_id=?";
			PreparedStatement pstm=cnn.prepareStatement(sql);
			pstm.setInt(1, emp_id);
			pstm.setInt(2, sub_id);
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
	 * search employee subject and return by arrayList
	 */
	public ArrayList<EmployeeSubjectDTO> searchEmployeeSubject(String subj) throws SQLException {
		ArrayList<EmployeeSubjectDTO> employeeSubjects = new ArrayList<EmployeeSubjectDTO>();
		try {
			String sql = "SELECT E.emp_id, E.sub_id, E.empsub_rate, E.empsub_desc, S.sub_name, S.sub_desc, C.cate_name FROM tb_subjects S "
					+ "INNER JOIN tb_categories C ON S.cate_id = C.cate_id "
					+ "INNER JOIN tb_empsubjects E ON E.sub_id = S.sub_id "
					+ "WHERE LOWER(S.sub_name) LIKE LOWER(?)";
			PreparedStatement pstmt = cnn.prepareStatement(sql);
			pstmt.setString(1, "%"+subj+"%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeSubjectDTO emp = new EmployeeSubjectDTO();
					emp.setEmp_id(rs.getInt(1));
					emp.setSub_id(rs.getInt(2));
					emp.setEmpsub_rate(rs.getInt(3));
					emp.setEmpsub_desc(rs.getString(4));
						SubjectDTO sub=new SubjectDTO();
							sub.setSub_name(rs.getString(5));
							sub.setSub_desc(rs.getString(6));
							sub.setCate_name(rs.getString(7));
							emp.setSubjectDTO(sub);
					employeeSubjects.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cnn.close();
		}
		return employeeSubjects;
	}
	
	
	/*
	 * search employee subject  and rate and return by arrayList
	 */
	public ArrayList<EmployeeSubjectDTO> searchEmployeeSubjectAndRAte(String subj, int rate) throws SQLException {
		ArrayList<EmployeeSubjectDTO> employeeSubjects = new ArrayList<EmployeeSubjectDTO>();
		try {
			String sql = "SELECT E.emp_id, E.sub_id, E.empsub_rate, E.empsub_desc, S.sub_name, S.sub_desc, C.cate_name FROM tb_subjects S "
					+ "INNER JOIN tb_categories C ON S.cate_id = C.cate_id "
					+ "INNER JOIN tb_empsubjects E ON E.sub_id = S.sub_id "
					+ "WHERE LOWER(S.sub_name) LIKE LOWER(?) AND E.empsub_rate=?";
			PreparedStatement pstmt = cnn.prepareStatement(sql);
			pstmt.setString(1, "%"+subj+"%");
			pstmt.setInt(2, rate);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeSubjectDTO emp = new EmployeeSubjectDTO();
					emp.setEmp_id(rs.getInt(1));
					emp.setSub_id(rs.getInt(2));
					emp.setEmpsub_rate(rs.getInt(3));
					emp.setEmpsub_desc(rs.getString(4));
						SubjectDTO sub=new SubjectDTO();
							sub.setSub_name(rs.getString(5));
							sub.setSub_desc(rs.getString(6));
							sub.setCate_name(rs.getString(7));
							emp.setSubjectDTO(sub);
					employeeSubjects.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cnn.close();
		}
		return employeeSubjects;
	}
	
	/*
	 * view employee subject and return by arrayList
	 */
	public ArrayList<EmployeeSubjectDTO> veiewEmployeeSubject(int id) throws SQLException {
		ArrayList<EmployeeSubjectDTO> employeeSubjects = new ArrayList<EmployeeSubjectDTO>();
		try {
			String sql = "SELECT E.emp_id, E.sub_id, E.empsub_rate, E.empsub_desc, S.sub_name, S.sub_desc, C.cate_name FROM tb_subjects S "
					+ "INNER JOIN tb_categories C ON S.cate_id = C.cate_id "
					+ "INNER JOIN tb_empsubjects E ON E.sub_id = S.sub_id "
					+ "WHERE E.emp_id=?";
			PreparedStatement pstmt = cnn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeSubjectDTO emp = new EmployeeSubjectDTO();
					emp.setEmp_id(rs.getInt(1));
					emp.setSub_id(rs.getInt(2));
					emp.setEmpsub_rate(rs.getInt(3));
					emp.setEmpsub_desc(rs.getString(4));
						SubjectDTO sub=new SubjectDTO();
							sub.setSub_name(rs.getString(5));
							sub.setSub_desc(rs.getString(6));
							sub.setCate_name(rs.getString(7));
							emp.setSubjectDTO(sub);
					employeeSubjects.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cnn.close();
		}
		return employeeSubjects;
	}
	
	
	/*
	 * view employee subject and return by arrayList
	 */
	public ArrayList<EmployeeSubjectDTO> rateEmployeeSubject(int id) throws SQLException {
		ArrayList<EmployeeSubjectDTO> employeeSubjects = new ArrayList<EmployeeSubjectDTO>();
		try {
			String sql = "SELECT E.emp_id, E.sub_id, E.empsub_rate, E.empsub_desc, S.sub_name, S.sub_desc, C.cate_name FROM tb_subjects S "
					+ "INNER JOIN tb_categories C ON S.cate_id = C.cate_id "
					+ "INNER JOIN tb_empsubjects E ON E.sub_id = S.sub_id "
					+ "WHERE E.empsub_rate=?";
			PreparedStatement pstmt = cnn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeSubjectDTO emp = new EmployeeSubjectDTO();
					emp.setEmp_id(rs.getInt(1));
					emp.setSub_id(rs.getInt(2));
					emp.setEmpsub_rate(rs.getInt(3));
					emp.setEmpsub_desc(rs.getString(4));
						SubjectDTO sub=new SubjectDTO();
							sub.setSub_name(rs.getString(5));
							sub.setSub_desc(rs.getString(6));
							sub.setCate_name(rs.getString(7));
							emp.setSubjectDTO(sub);
					employeeSubjects.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cnn.close();
		}
		return employeeSubjects;
	}
	
	
}
