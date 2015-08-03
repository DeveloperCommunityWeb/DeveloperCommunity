package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.dto.FilesDTO;

public class FilesDAO {
	Connection cnn=null;
	public FilesDAO() throws ClassNotFoundException, SQLException, NamingException {
		InitialContext initCtx = new InitialContext();
		DataSource dataSource = (DataSource) initCtx.lookup("java:comp/env/DeveloperCommunity");
		cnn = dataSource.getConnection();
		this.cnn.setAutoCommit(false);
	}
	public ArrayList<FilesDTO> getAllFiles(){
		ArrayList<FilesDTO> files=new ArrayList<FilesDTO>();
		try {
			PreparedStatement pstmt=cnn.prepareStatement("Select * from tb_files");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				FilesDTO dto = new FilesDTO();
				dto.setFile_id(rs.getInt("file_id"));
				dto.setTitle(rs.getString("file_title"));
				dto.setUrl(rs.getString("file_url"));
				dto.setDescription(rs.getString("file_desc"));
				dto.setEmployee_id(rs.getInt("emp_id"));
				files.add(dto);
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
		return files;
	}
	public FilesDTO getFile(String title){
		FilesDTO file=new FilesDTO();
		try {
			PreparedStatement pstmt=cnn.prepareStatement("Select * from tb_files where file_title=?");
			pstmt.setString(1, title);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				file.setFile_id(rs.getInt("file_id"));
				file.setTitle(rs.getString("file_title"));
				file.setUrl(rs.getString("file_url"));
				file.setDescription(rs.getString("file_desc"));
				file.setEmployee_id(rs.getInt("emp_id"));
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
		return file;
	}
	public boolean updateFile(FilesDTO file){
		try {
			PreparedStatement pstmt=cnn.prepareStatement("UPDATE tb_files SET file_title=?,file_url=?,file_desc=?,emp_id=? WHERE file_id=?;");
			
			pstmt.setString(1, file.getTitle());
			pstmt.setString(2, file.getUrl());
			pstmt.setString(3, file.getDescription());
			pstmt.setInt(4, file.getEmployee_id());
			pstmt.setInt(5, file.getFile_id());
			
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
	public boolean addFile(FilesDTO file){
		try {
			PreparedStatement pstmt=cnn.prepareStatement("INSERT INTO tb_files(file_title,file_url,file_desc,emp_id) VALUES(?,?,?,?)");
			
			pstmt.setString(1, file.getTitle());
			pstmt.setString(2, file.getUrl());
			pstmt.setString(3, file.getDescription());
			pstmt.setInt(4, file.getEmployee_id());
			
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
	public int validTitle(String title) throws SQLException
	{
		final String SQL ="SELECT COUNT(*) FROM tb_files WHERE LOWER(file_title) = LOWER(?);";
		PreparedStatement pstmt = cnn.prepareStatement(SQL,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1, title);
		int count = 0;
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
			count = rs.getInt(1);
		System.out.println(count);
		return count;
	}
	public boolean deleteFile(int id) throws SQLException{
		final String SQL = "DELETE FROM tb_files WHERE file_id=?;";
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
	public ArrayList<FilesDTO> listFile(String keyword)throws SQLException{
		ArrayList<FilesDTO> files = new ArrayList<FilesDTO>();
		final String SQL="SELECT * FROM tb_files WHERE LOWER(file_title) LIKE LOWER(?);";
		PreparedStatement   pstmt=cnn.prepareStatement(SQL,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1, "%" + keyword +"%");
		ResultSet rs =pstmt.executeQuery();
		while(rs.next()){
			FilesDTO dto = new FilesDTO();
			dto.setFile_id(rs.getInt("file_id"));
			dto.setTitle(rs.getString("file_title"));
			dto.setUrl(rs.getString("file_url"));
			dto.setDescription(rs.getString("file_desc"));
			dto.setEmployee_id(rs.getInt("emp_id"));
			files.add(dto);
		}
		return files;
	}
}
