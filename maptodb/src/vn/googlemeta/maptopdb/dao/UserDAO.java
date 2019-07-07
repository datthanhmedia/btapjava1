package vn.googlemeta.maptopdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.googlemeta.maptopdb.bo.User;
import vn.googlemeta.maptopdb.utils.ConnectionFactory;

public class UserDAO {
	public ArrayList<User> getAllUser(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<User> userList = new ArrayList<User>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM user");
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
	
	private static User convertToUser(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setId(resultSet.getInt(1));
		user.setName(resultSet.getString(2));
		user.setPass(resultSet.getString(3));
		user.setAge(resultSet.getInt(4));
		return user;
	}
	public void addUser(User user) {
		Connection connection = null;
		Statement statement = null;
		String insertSQL = "INSERT INTO user (name, pass, age) VALUES('" + user.getName() + "','"
				+ user.getPass() + "','"
				+ user.getAge() + "')";
		
	
	try {
		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();
		statement.executeUpdate(insertSQL);
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
	public void addUserPrepareStatement(User user) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String insertSQL = "INSERT INTO user (name, pass, age) VALUES(?, ?, ?)";
	try {
		connection = ConnectionFactory.getConnection();
		prepareStatement = connection.prepareStatement(insertSQL);
		prepareStatement.setString(1, user.getName());
		prepareStatement.setString(2, user.getPass());
		prepareStatement.setInt(3, user.getAge());
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
	
	public ArrayList<User> findUserByUsername(String username){
		ArrayList<User> listUser = new ArrayList<User>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM baitap1.user WHERE name = '" + username + "';");
			while(resultSet.next()) {
				listUser.add(convertToUser(resultSet));
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
		return listUser;
	}
	public void deleteUser(Integer userId) {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "DELETE FROM user WHERE id = " + userId;
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
	public void updatePass(String pass, Integer id) {
		Connection connection = null;
		Statement statement = null;
		String updatePass = "UPDATE user SET pass = '"+ pass +"' WHERE id = '" + id + "'";
	try {
		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();
		statement.executeUpdate(updatePass);
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
}
