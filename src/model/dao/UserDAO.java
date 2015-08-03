package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import configuration.Utilities;
import model.dto.UserDTO;

public class UserDAO {
	Connection cnn = null;

	public UserDAO() throws ClassNotFoundException, SQLException,
			NamingException {
		InitialContext initCtx = new InitialContext();
		DataSource dataSource = (DataSource) initCtx
				.lookup("java:comp/env/DeveloperCommunity");
		cnn = dataSource.getConnection();
		this.cnn.setAutoCommit(false);
	}

	public boolean updateStatus(UserDTO usr) throws SQLException {
		Connection con=new Utilities().dbConnect();
		System.out.println(usr.getStatus());
		System.out.println(usr.getUser_id());
		PreparedStatement ps = con
				.prepareStatement("UPDATE tb_users SET user_status=? WHERE user_id=?");
		ps.setInt(1, usr.getStatus());
		ps.setInt(2, usr.getUser_id());
		System.out.println(ps.toString());
		int i = ps.executeUpdate();
		System.out.println("Effect:"+i);
		if (i > 0) {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					throw e;
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					throw e;
				}
			return true;
		}
		return false;
	}

	public ArrayList<UserDTO> getAllUsers() {
		ArrayList<UserDTO> users = new ArrayList<UserDTO>();
		try {
			PreparedStatement pstmt = cnn
					.prepareStatement("Select * from tb_users");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setUser_id(rs.getInt("user_id"));
				dto.setUsername(rs.getString("user_name"));
				dto.setPassword(rs.getString("user_pwd"));
				dto.setEmail(rs.getString("user_email"));
				dto.setStatus(rs.getInt("user_status"));
				dto.setPosition(rs.getInt("user_type"));
				users.add(dto);
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
		return users;
	}

	public UserDTO getUser(int id) {
		UserDTO user = new UserDTO();
		try {
			PreparedStatement pstmt = cnn
					.prepareStatement("Select * from tb_users where user_id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setUser_id(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPosition(rs.getInt(5));
				user.setStatus(rs.getInt(6));
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
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
		return user;
	}

	public boolean updateUser(UserDTO user) {
		try {
			PreparedStatement pstmt = cnn
					.prepareStatement("UPDATE tb_users SET user_name=?,user_pwd=?,user_email=?,user_type=?,user_status=? WHERE user_id=?;");

			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setInt(4, user.getPosition());
			pstmt.setInt(5, user.getStatus());
			pstmt.setInt(6, user.getUser_id());

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

	public boolean addUser(UserDTO user) {
		try {
			PreparedStatement pstmt = cnn
					.prepareStatement("INSERT INTO tb_users(user_name,user_pwd,user_email,user_type,user_status) VALUES(?,?,?,?,?)");

			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setInt(4, user.getPosition());
			pstmt.setInt(5, user.getStatus());

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

	public int validUserName(String userName) throws SQLException {
		final String SQL = "SELECT COUNT(*) FROM tb_users WHERE LOWER(user_name) = LOWER(?);";
		PreparedStatement pstmt = cnn.prepareStatement(SQL,
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1, userName);
		int count = 0;
		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			count = rs.getInt(1);
		System.out.println(count);
		return count;
	}

	public boolean deleteUser(int id) throws SQLException {
		final String SQL = "DELETE FROM tb_users WHERE user_id=?;";
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

	public ArrayList<UserDTO> listUser(String keyword) throws SQLException {
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();
		final String SQL = "SELECT * FROM tb_users WHERE LOWER(user_name) LIKE LOWER(?);";
		PreparedStatement pstmt = cnn.prepareStatement(SQL,
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1, "%" + keyword + "%");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			UserDTO dto = new UserDTO();
			dto.setUser_id(rs.getInt("user_id"));
			dto.setUsername(rs.getString("user_name"));
			dto.setPassword(rs.getString("user_pwd"));
			dto.setEmail(rs.getString("user_email"));
			dto.setStatus(rs.getInt("user_status"));
			dto.setPosition(rs.getInt("user_type"));
			list.add(dto);
		}
		return list;
	}
}
