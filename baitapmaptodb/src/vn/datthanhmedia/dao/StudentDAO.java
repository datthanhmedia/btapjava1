package vn.datthanhmedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.datthanhmedia.bo.Students;
import vn.datthanhmedia.utils.ConnectionFactory;



public class StudentDAO {
	public ArrayList<Students> getAllStudent(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Students> studentsList = new ArrayList<Students>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM student");
			while(resultSet.next()) {
				studentsList.add(convertToStudents(resultSet));
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
		return studentsList;
	}

	private static Students convertToStudents(ResultSet resultSet) throws SQLException {
		Students students = new Students();
		students.setId(resultSet.getInt(1));
		students.setFirst_name(resultSet.getString(2));
		students.setLast_name(resultSet.getString(3));
		students.setGender(resultSet.getString(4));
		students.setAge(resultSet.getInt(5));
		students.setTelephone(resultSet.getString(6));
		students.setScores(resultSet.getInt(7));
		return students;
	}
	
	public void addStudentsPrepareStatement(Students student) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String insertSQL = "INSERT INTO student (first_name, last_name, gender, age, telephone, score)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
	
	
	try {
		connection = ConnectionFactory.getConnection();
		prepareStatement = connection.prepareStatement(insertSQL);
		prepareStatement.setString(1, student.getFirst_name());
		prepareStatement.setString(2, student.getLast_name());
		prepareStatement.setString(3, student.getGender());
		prepareStatement.setInt(4, student.getAge());
		prepareStatement.setString(5, student.getTelephone());
		prepareStatement.setInt(6, student.getScores());
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
}
