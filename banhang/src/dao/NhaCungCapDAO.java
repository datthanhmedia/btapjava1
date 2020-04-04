package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.NhaCungCap;
import dbconnection.ConnectionFactory;

public class NhaCungCapDAO {
	private static NhaCungCap convertToNhaCungCap(ResultSet resultSet) throws SQLException {
		NhaCungCap nhaCungCap = new NhaCungCap();
		nhaCungCap.setIdNhaCungCap(resultSet.getInt(1));
		nhaCungCap.setMaNhaCungCap(resultSet.getString(2));
		nhaCungCap.setTenNhaCungCap(resultSet.getString(3));
		nhaCungCap.setLoai(resultSet.getString(4));
		nhaCungCap.setLienHe(resultSet.getString(5));
		nhaCungCap.setGhiChu(resultSet.getString(6));
		return nhaCungCap;
	}
	public ArrayList<NhaCungCap> tatCaNhaCungCap(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<NhaCungCap> tatCaNhaCungCap = new ArrayList<NhaCungCap>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM banhang.nhacungcap");
			while(resultSet.next()) {
				tatCaNhaCungCap.add(convertToNhaCungCap(resultSet));
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
		return tatCaNhaCungCap;
	}
	public void themNhaCungCap(NhaCungCap nhaCungCap) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		String insertSQL = "INSERT INTO banhang.nhacungcap (mancc, tenncc, loai, lienhe, ghichu) VALUES(?, ?, ?, ?, ?)";
	try {
		connection = ConnectionFactory.getConnection();
		prepareStatement = connection.prepareStatement(insertSQL);
		prepareStatement.setString(1, nhaCungCap.getMaNhaCungCap());
		prepareStatement.setString(2, nhaCungCap.getTenNhaCungCap());
		prepareStatement.setString(3, nhaCungCap.getLoai());
		prepareStatement.setString(4, nhaCungCap.getLienHe());
		prepareStatement.setString(5, nhaCungCap.getGhiChu());
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
	public void suaNhaCungCap(NhaCungCap nhaCungCap) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE banhang.nhacungcap SET mancc = ?, tenncc = ?, loai = ?, lienhe = ?, ghichu = ? WHERE idncc = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, nhaCungCap.getMaNhaCungCap());
			preparedStatement.setString(2, nhaCungCap.getTenNhaCungCap());
			preparedStatement.setString(3, nhaCungCap.getLoai());
			preparedStatement.setString(4, nhaCungCap.getLienHe());
			preparedStatement.setString(5, nhaCungCap.getGhiChu());
			preparedStatement.setInt(6, nhaCungCap.getIdNhaCungCap());
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
	public void xoaNhaCungCap(Integer idNhaCungCap) {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "DELETE FROM banhang.nhacungcap WHERE idncc = " + idNhaCungCap;
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
	public NhaCungCap getNhaCungCap(int id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM banhang.nhacungcap WHERE idncc = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				NhaCungCap nhaCungCap = convertToNhaCungCap(resultSet);
				return nhaCungCap;
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
