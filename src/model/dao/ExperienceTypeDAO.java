package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.dto.ExperienceTypeDTO;

public class ExperienceTypeDAO {
	Connection cnn=null;
	public ExperienceTypeDAO() throws ClassNotFoundException, SQLException, NamingException {
		InitialContext initCtx = new InitialContext();
		DataSource dataSource = (DataSource) initCtx.lookup("java:comp/env/DeveloperCommunity");
		cnn = dataSource.getConnection();
		this.cnn.setAutoCommit(false);
	}
	public ArrayList<ExperienceTypeDTO> getAllExperienceType(){
		ArrayList<ExperienceTypeDTO> expts=new ArrayList<ExperienceTypeDTO>();
		try {
			PreparedStatement pstmt=cnn.prepareStatement("Select * from tb_experience_types");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				ExperienceTypeDTO dto = new ExperienceTypeDTO();
				dto.setExperience_type_id(rs.getInt("expt_id"));
				dto.setExperience_type_name(rs.getString("expt_name"));
				dto.setExperience_type_desc(rs.getString("expt_desc"));
				expts.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cnn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return expts;
	}
	public ExperienceTypeDTO getExperienceType(String expt_name){
		ExperienceTypeDTO dto=new ExperienceTypeDTO();
		try {
			PreparedStatement pstmt=cnn.prepareStatement("Select * from tb_experience_types where expt_name=?");
			pstmt.setString(1, expt_name);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				dto.setExperience_type_id(rs.getInt("expt_id"));
				dto.setExperience_type_name(rs.getString("expt_name"));
				dto.setExperience_type_desc(rs.getString("expt_desc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cnn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	public boolean updateExperienceType(ExperienceTypeDTO expt){
		try {
			PreparedStatement pstmt=cnn.prepareStatement("UPDATE tb_experience_types SET expt_name=?,expt_desc=? WHERE expt_id=?;");
			
			pstmt.setString(1,expt.getExperience_type_name());
			pstmt.setString(2, expt.getExperience_type_desc());
			pstmt.setInt(3, expt.getExperience_type_id());
			if(pstmt.executeUpdate()>0){
				cnn.commit();
				if(pstmt!=null)try{pstmt.close();}catch(SQLException e){throw e;}
				if(cnn!=null)try{cnn.close();}catch(SQLException e){throw e;}
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {				
				cnn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean addExperienceType(ExperienceTypeDTO expt){
		try {
			PreparedStatement pstmt=cnn.prepareStatement("INSERT INTO tb_experience_types(expt_name,expt_desc) VALUES(?,?)");
			
			pstmt.setString(1,expt.getExperience_type_name());
			pstmt.setString(2, expt.getExperience_type_desc());
			
			if(pstmt.executeUpdate()>0){
				cnn.commit();
				if(pstmt!=null)try{pstmt.close();}catch(SQLException e){throw e;}
				if(cnn!=null)try{cnn.close();}catch(SQLException e){throw e;}				
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cnn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public int validExperienceType(String expt_name) throws SQLException
	{
		final String SQL ="SELECT COUNT(*) FROM tb_experience_types WHERE LOWER(expt_name) = LOWER(?);";
		PreparedStatement pstmt = cnn.prepareStatement(SQL,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1, expt_name);
		int count = 0;
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
			count = rs.getInt(1);
		System.out.println(count);
		return count;
	}
	public boolean deleteExperienceType(int id) throws SQLException{
		final String SQL = "DELETE FROM tb_experience_types WHERE expt_id=?;";
		PreparedStatement pstmt = cnn.prepareStatement(SQL);
		pstmt.setInt(1, id);
		if(pstmt.executeUpdate() > 0){
			cnn.commit();
			if(pstmt!=null)try{pstmt.close();}catch(SQLException e){throw e;}
			if(cnn!=null)try{cnn.close();}catch(SQLException e){throw e;}
			return true;
		}
		return false;
	}
	public ArrayList<ExperienceTypeDTO> listExperienceType(String keyword)throws SQLException{
		ArrayList<ExperienceTypeDTO> list = new ArrayList<ExperienceTypeDTO>();
		final String SQL="SELECT * FROM tb_experience_types WHERE LOWER(expt_name) LIKE LOWER(?);";
		PreparedStatement   pstmt=cnn.prepareStatement(SQL,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1, "%" + keyword +"%");
		ResultSet rs =pstmt.executeQuery();
		while(rs.next()){
			ExperienceTypeDTO dto = new ExperienceTypeDTO();
			dto.setExperience_type_id(rs.getInt("expt_id"));
			dto.setExperience_type_name(rs.getString("expt_name"));
			dto.setExperience_type_desc(rs.getString("expt_desc"));
			list.add(dto);
		}
		return list;
	}
}
