package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.dto.EmployeeDTO;

public class EmployeeDAO {
	Connection cnn = null;

	public EmployeeDAO() throws ClassNotFoundException, SQLException,
			NamingException {
		InitialContext initCtx = new InitialContext();
		DataSource dataSource = (DataSource) initCtx
				.lookup("java:comp/env/DeveloperCommunity");
		cnn = dataSource.getConnection();
		this.cnn.setAutoCommit(false);
	}

	public ArrayList<EmployeeDTO> getAllEmployees() {
		ArrayList<EmployeeDTO> emps = new ArrayList<EmployeeDTO>();
		try {
			PreparedStatement pstmt = cnn
					.prepareStatement("Select * from tb_employees");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmployee_id(rs.getInt("emp_id"));
				dto.setFirst_name(rs.getString("emp_firstname"));
				dto.setLast_name(rs.getString("emp_lastname"));
				dto.setSex(rs.getInt("emp_gender"));
				dto.setDOB(rs.getDate("emp_dob"));
				dto.setAddress(rs.getString("emp_address"));
				dto.setPOB(rs.getString("emp_pob"));
				dto.setPhone(rs.getString("emp_phone"));
				dto.setEmail(rs.getString("emp_email"));
				dto.setSocial_network(rs.getString("emp_socialnet"));
				dto.setNationality(rs.getString("emp_nationality"));
				dto.setMarital_status(rs.getInt("emp_marrital"));
				dto.setUser_id(rs.getInt("user_id"));
				emps.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cnn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emps;
	}

	public EmployeeDTO getEmployee(String emp_name) {
		EmployeeDTO dto = new EmployeeDTO();
		try {
			PreparedStatement pstmt = cnn
					.prepareStatement("Select * from tb_employees where emp_name=?");
			pstmt.setString(1, emp_name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				dto.setEmployee_id(rs.getInt("emp_id"));
				dto.setFirst_name(rs.getString("emp_firstname"));
				dto.setLast_name(rs.getString("emp_lastname"));
				dto.setSex(rs.getInt("emp_gender"));
				dto.setDOB(rs.getDate("emp_dob"));
				dto.setAddress(rs.getString("emp_address"));
				dto.setPOB(rs.getString("emp_pob"));
				dto.setPhone(rs.getString("emp_phone"));
				dto.setEmail(rs.getString("emp_email"));
				dto.setSocial_network(rs.getString("emp_socialnet"));
				dto.setNationality(rs.getString("emp_nationality"));
				dto.setMarital_status(rs.getInt("emp_marrital"));
				dto.setUser_id(rs.getInt("user_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cnn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	public boolean updateEmployee(EmployeeDTO emp) {
		try {
			PreparedStatement pstmt = cnn
					.prepareStatement("UPDATE tb_employees SET emp_firstname=?,emp_lastname=?emp_gender=?,emp_dob=?,emp_address=?,emp_pob=?,emp_phone=?,emp_email=?,emp_socialnet=?,emp_nationality=?,emp_marrital=?,user_id=? WHERE emp_id=?;");

			pstmt.setString(1, emp.getFirst_name());
			pstmt.setString(2, emp.getLast_name());
			pstmt.setInt(3, emp.getSex());
			pstmt.setDate(4, emp.getDOB());
			pstmt.setString(5, emp.getAddress());
			pstmt.setString(6, emp.getPOB());
			pstmt.setString(7, emp.getPhone());
			pstmt.setString(8, emp.getEmail());
			pstmt.setString(9, emp.getSocial_network());
			pstmt.setString(10, emp.getNationality());
			pstmt.setInt(11, emp.getMarital_status());
			pstmt.setInt(12, emp.getUser_id());
			pstmt.setInt(13, emp.getEmployee_id());

			if (pstmt.executeUpdate() > 0) {
				cnn.commit();
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						throw e;
					}
				if (cnn != null)
					try {
						cnn.close();
					} catch (SQLException e) {
						throw e;
					}
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cnn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public int validEmployeeName(String empName) throws SQLException {
		final String SQL = "SELECT COUNT(*) FROM tb_employees WHERE LOWER(CONCAT(emp_firstname,' ',emp_lastname) = LOWER(?);";
		PreparedStatement pstmt = cnn.prepareStatement(SQL,
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1, empName);
		int count = 0;
		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			count = rs.getInt(1);
		System.out.println(count);
		return count;
	}

	public boolean deleteEmployee(int id) throws SQLException {
		final String SQL = "DELETE FROM tb_employees WHERE emp_id=?;";
		PreparedStatement pstmt = cnn.prepareStatement(SQL);
		pstmt.setInt(1, id);
		if (pstmt.executeUpdate() > 0) {
			cnn.commit();
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw e;
				}
			if (cnn != null)
				try {
					cnn.close();
				} catch (SQLException e) {
					throw e;
				}
			return true;
		}
		return false;
	}

	public ArrayList<EmployeeDTO> listEmployee(String keyword)
			throws SQLException {
		ArrayList<EmployeeDTO> emps = new ArrayList<EmployeeDTO>();
		final String SQL = "SELECT * FROM tb_employees WHERE LOWER(user_name) LIKE LOWER(?);";
		PreparedStatement pstmt = cnn.prepareStatement(SQL,
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1, "%" + keyword + "%");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			EmployeeDTO dto = new EmployeeDTO();
			dto.setEmployee_id(rs.getInt("emp_id"));
			dto.setFirst_name(rs.getString("emp_firstname"));
			dto.setLast_name(rs.getString("emp_lastname"));
			dto.setSex(rs.getInt("emp_gender"));
			dto.setDOB(rs.getDate("emp_dob"));
			dto.setAddress(rs.getString("emp_address"));
			dto.setPOB(rs.getString("emp_pob"));
			dto.setPhone(rs.getString("emp_phone"));
			dto.setEmail(rs.getString("emp_email"));
			dto.setSocial_network(rs.getString("emp_socialnet"));
			dto.setNationality(rs.getString("emp_nationality"));
			dto.setMarital_status(rs.getInt("emp_marrital"));
			dto.setUser_id(rs.getInt("user_id"));
			emps.add(dto);
		}
		return emps;
	}

	public boolean addUser(EmployeeDTO emp) {
		try {
			final String sql = "INSERT INTO tb_employees(emp_firstname,emp_lastname,emp_gender,emp_dob,emp_address,emp_pob,emp_phone,emp_email,emp_socialnet,emp_nationality,emp_marrital,user_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = cnn.prepareStatement(sql);

			pstmt.setString(1, emp.getFirst_name());
			pstmt.setString(2, emp.getLast_name());
			pstmt.setInt(3, emp.getSex());
			pstmt.setDate(4, emp.getDOB());
			pstmt.setString(5, emp.getAddress());
			pstmt.setString(6, emp.getPOB());
			pstmt.setString(7, emp.getPhone());
			pstmt.setString(8, emp.getEmail());
			pstmt.setString(9, emp.getSocial_network());
			pstmt.setString(10, emp.getNationality());
			pstmt.setInt(11, emp.getMarital_status());
			pstmt.setInt(12, emp.getUser_id());

			if (pstmt.executeUpdate() > 0) {
				cnn.commit();
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						throw e;
					}
				if (cnn != null)
					try {
						cnn.close();
					} catch (SQLException e) {
						throw e;
					}
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cnn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
