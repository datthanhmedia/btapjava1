package vn.datthanh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.datthanh.bo.User;
import vn.datthanh.dbconnection.ConnectionFactory;

public class UserDAO {
	public ArrayList<User> getUser(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<User> userList = new ArrayList<User>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM `order`.`user`");
			while(resultSet.next()) {
				userList.add(convertToUser(resultSet));
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
		return userList;
	}
	public void insertUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertSQL = "INSERT INTO `order`.user (username,userinfo,useracc,password,role) VALUES (?,?,?,?,?)";
		try {
			connection = ConnectionFactory.getConnection();	
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getUserInfo());
			preparedStatement.setString(3, user.getUserAcc());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole());
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
	public void updateUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE order.user SET username = ?, userinfo = ?, useracc = ?, password = ?, role = ? WHERE id = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getUserInfo());
			preparedStatement.setString(3, user.getUserAcc());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setInt(6, user.getIduser());
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
	public void deleteUser(int userId) {
		Connection connection = null;
		Statement statement = null;
		try {
			String sql = "DELETE FROM `order`.`user` WHERE iduser =" + userId;
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			//Handle errors for JDBC
			e.printStackTrace();
		} finally {
			//finally block used to close resources
            if (statement != null) {
            	try {
            		statement.close();
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
	public User findUserByUsernameAndPassword(String username, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM `order`.`user` WHERE useracc = ? AND password = ?";
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
	
	private static User convertToUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setIduser(rs.getInt(1));		
		user.setUserName(rs.getString(2));	
		user.setUserInfo(rs.getString(3));
		user.setUserAcc(rs.getString(4));
		user.setPassword(rs.getString(5));		
		user.setRole(rs.getString(6));
		return user;
	}
}
