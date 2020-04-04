package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.DanhMuc;
import dbconnection.ConnectionFactory;

public class DanhMucDAO {
	private static DanhMuc convertToDanhMuc(ResultSet resultSet) throws SQLException {
		DanhMuc danhMuc = new DanhMuc();
		danhMuc.setIdDanhMuc(resultSet.getInt(1));
		danhMuc.setMaDanhMuc(resultSet.getString(2));
		danhMuc.setTenDanhMuc(resultSet.getString(3));
		danhMuc.setGhiChu(resultSet.getString(4));
		return danhMuc;
	}
	public ArrayList<DanhMuc> tatCaDanhMuc(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<DanhMuc> tatCaDanhMuc = new ArrayList<DanhMuc>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM danhmuc");
			while(resultSet.next()) {
				tatCaDanhMuc.add(convertToDanhMuc(resultSet));
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
		return tatCaDanhMuc;
	}
	public void themDanhMuc(DanhMuc danhMuc) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		String insertSQL = "INSERT INTO danhmuc (madanhmuc, tendanhmuc, ghichu) VALUES(?, ?, ?)";
	try {
		connection = ConnectionFactory.getConnection();
		prepareStatement = connection.prepareStatement(insertSQL);
		prepareStatement.setString(1, danhMuc.getMaDanhMuc());
		prepareStatement.setString(2, danhMuc.getTenDanhMuc());
		prepareStatement.setString(3, danhMuc.getGhiChu());
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
	public void suaDanhMuc(DanhMuc danhMuc) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE danhmuc SET madanhmuc = ?, tendanhmuc = ?, ghichu = ? WHERE iddanhmuc = ?;";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, danhMuc.getMaDanhMuc());
			preparedStatement.setString(2, danhMuc.getTenDanhMuc());
			preparedStatement.setString(3, danhMuc.getGhiChu());
			preparedStatement.setInt(4, danhMuc.getIdDanhMuc());
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
	public void xoaDanhMuc(Integer idDanhMuc) {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "DELETE FROM danhmuc WHERE iddanhmuc = " + idDanhMuc;
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
	public DanhMuc getDanhMuc(int id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM danhmuc WHERE iddanhmuc = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				DanhMuc danhMuc = convertToDanhMuc(resultSet);
				return danhMuc;
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
}

