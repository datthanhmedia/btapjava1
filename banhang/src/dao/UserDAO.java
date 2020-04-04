package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.User;
import dbconnection.ConnectionFactory;

public class UserDAO {
	private static User convertToUser(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setId(resultSet.getInt(1));
		user.setUserName(resultSet.getString(2));
		user.setPassWord(resultSet.getString(3));
		user.setRole(resultSet.getString(4));
		user.setHoten(resultSet.getString(5));
		user.setNgaySinh(resultSet.getString(6));
		user.setDienThoai(resultSet.getString(7));
		user.setCMND(resultSet.getString(8));
		user.setEmail(resultSet.getString(9));
		user.setChucVu(resultSet.getString(10));
		return user;
	}
	public ArrayList<User> tatCaUser(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<User> tatCaUser = new ArrayList<User>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM user");
			while(resultSet.next()) {
				tatCaUser.add(convertToUser(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(resultSet !=null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(statement !=null) {
				try {
					statement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(connection !=null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		return tatCaUser;
	}
	public void themUser(User user) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		String insertSQL = "INSERT INTO user (username, password, role, hoten, ngaysinh, cmnd, sdt, email, chucvu) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	try {
		connection = ConnectionFactory.getConnection();
		prepareStatement = connection.prepareStatement(insertSQL);
		prepareStatement.setString(1, user.getUserName());
		prepareStatement.setString(2, user.getPassWord());
		prepareStatement.setString(3, user.getRole());
		prepareStatement.setString(4, user.getHoten());
		prepareStatement.setString(5, user.getNgaySinh());
		prepareStatement.setString(6, user.getCMND());
		prepareStatement.setString(7, user.getDienThoai());
		prepareStatement.setString(8, user.getEmail());
		prepareStatement.setString(9, user.getChucVu());
		prepareStatement.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		
		if(prepareStatement !=null) {
			try {
				prepareStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(connection !=null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	}
	public void suaUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE user SET username = ?, password = ?, role = ?, hoten = ?, ngaysinh = ?, cmnd = ?, sdt = ?, email = ?, chucvu = ? WHERE iduser = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassWord());
			preparedStatement.setString(3, user.getRole());
			preparedStatement.setString(4, user.getHoten());
			preparedStatement.setString(5, user.getNgaySinh());
			preparedStatement.setString(6, user.getCMND());
			preparedStatement.setString(7, user.getDienThoai());
			preparedStatement.setString(8, user.getEmail());
			preparedStatement.setString(9, user.getChucVu());
			preparedStatement.setInt(10, user.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			//Handle errors for JDBC
			e.printStackTrace();
		} finally {
			//finally block used to close resources
			if (preparedStatement != null) {
            	try {
            		preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }


            if (connection != null) {
            	try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
		}
	}
	public void xoaUser(String userName) {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "DELETE FROM user WHERE username = " + userName;
	try {
		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();
		statement.executeUpdate(deleteColumn);
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		
		if(statement !=null) {
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(connection !=null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	}
	public ArrayList<User> getUserByRole(int role){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<User> nhanVien = new ArrayList<User>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM user WHERE role =" + role);
			while(resultSet.next()) {
				nhanVien.add(convertToUser(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(resultSet !=null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(statement !=null) {
				try {
					statement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(connection !=null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		return nhanVien;
	}
	public User findUserByUsernameAndPassword(String username, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = convertToUser(resultSet);
				return user;
			}
		} catch (SQLException e) {
			//Handle errors for JDBC
			e.printStackTrace();
		} finally {
			//finally block used to close resources
	        if (resultSet != null) {
                try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }

            if (preparedStatement != null) {
            	try {
            		preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }

            if (connection != null) {
            	try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
		}
		
		return null;
	}
	public boolean findUser(String username) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM user WHERE username = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			if(!resultSet.next()) {
				return false;
			}
		} catch (SQLException e) {
			//Handle errors for JDBC
			e.printStackTrace();
		} finally {
			//finally block used to close resources
	        if (resultSet != null) {
                try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }

            if (preparedStatement != null) {
            	try {
            		preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }

            if (connection != null) {
            	try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
		}
		
		return true;
	}
}
