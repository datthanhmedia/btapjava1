package vn.datthanhmedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.datthanhmedia.bo.Book;
import vn.datthanhmedia.bo.User;
import vn.datthanhmedia.dbconnection.ConnectionFactory;

public class UserDAO {
	private static User convertToUser(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setId(resultSet.getInt(1));
		user.setUser(resultSet.getString(2));
		user.setPassword(resultSet.getString(3));
		user.setRole(resultSet.getInt(4));
		return user;
	}
	public void insertUser(User user) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String insertSQL = "INSERT INTO book (user, password, role) VALUES(?, ?, ?)";
	try {
		connection = ConnectionFactory.getConnection();
		prepareStatement = connection.prepareStatement(insertSQL);
		prepareStatement.setString(1, user.getUser());
		prepareStatement.setString(2, user.getPassword());
		prepareStatement.setInt(3, user.getRole());
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
	public void deleteUser(int userId) {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "DELETE FROM jspseverlet.user WHERE id = " + userId;
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
	
	public void updateUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE jspseverlet.user SET user = ?, password = ?, role = ? WHERE id = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, user.getUser());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getRole());
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
	public User findUserByUsernameAndPassword(String userName, String password){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM jspseverlet.user WHERE user = ? AND password = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,userName);
			preparedStatement.setString(2,password);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = convertToUser(resultSet);
				return user;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
		
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
}
