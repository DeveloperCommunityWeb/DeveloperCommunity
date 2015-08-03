package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dto.CategoryDTO;
import configuration.Utilities;

public class CategoryDAO {
	private Connection cnn=null;
	
	/*
	 * constructor connection to data base
	 */
	public CategoryDAO(){
		cnn= new Utilities().dbConnect();
	}
	
	
	/*
	 * list all Category and return by arrayList
	 */
	public ArrayList<CategoryDTO> getAllCategory() throws SQLException{
		ArrayList<CategoryDTO> categorys = new ArrayList<CategoryDTO>();
		try {
			String sql="SELECT * FROM tb_categories";
			PreparedStatement pstmt = cnn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				CategoryDTO cat = new CategoryDTO();
					cat.setCate_id(rs.getInt(1));
					cat.setCate_name(rs.getString(2));
					cat.setCate_desc(rs.getString(3));
					categorys.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return categorys;
	}
	
	/*
	 * Add Category
	 */
	public boolean addCategory(CategoryDTO cat) throws SQLException{
		try {
			PreparedStatement pstm=cnn.prepareStatement("Insert INTO tb_categories (cate_name, cate_desc) values(?,?)");
			pstm.setString(1, cat.getCate_name());
			pstm.setString(2, cat.getCate_desc());
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
	 * edite record in category
	 */
	public boolean editCategory(CategoryDTO cat) throws SQLException{
		try {
			String sql ="UPDATE tb_categories SET cate_name=?, cate_desc=? WHERE cate_id=?;";
			PreparedStatement pstmt = cnn.prepareStatement(sql);
			pstmt.setString(1, cat.getCate_name());
			pstmt.setString(2, cat.getCate_desc());
			pstmt.setInt(3, cat.getCate_id());
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
	 * delete record from category
	 */
	public boolean deleteCategory(int id) throws SQLException{
		try{
			String sql="DELETE FROM tb_categories WHERE cate_id=?";
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
	 * search record in category
	 */
	public ArrayList<CategoryDTO> searchCategory(String name) throws SQLException{
		ArrayList<CategoryDTO> categorys = new ArrayList<CategoryDTO>();
		try {
			String sql="SELECT * FROM tb_categories WHERE LOWER(cate_name) LIKE LOWER(?);";
			PreparedStatement pstmt = cnn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				CategoryDTO cat = new CategoryDTO();
					cat.setCate_id(rs.getInt(1));
					cat.setCate_name(rs.getString(2));
					cat.setCate_desc(rs.getString(3));
					categorys.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return categorys;
	}
	
	/*
	 * list record in category
	 */
	public ArrayList<CategoryDTO> listCategory(int id) throws SQLException{
		ArrayList<CategoryDTO> categorys = new ArrayList<CategoryDTO>();
		try {
			String sql="SELECT * FROM tb_categories WHERE cate_id=?";
			PreparedStatement pstmt = cnn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				CategoryDTO cat = new CategoryDTO();
					cat.setCate_id(rs.getInt(1));
					cat.setCate_name(rs.getString(2));
					cat.setCate_desc(rs.getString(3));
					categorys.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return categorys;
	}
	
	
	
	
	

}
