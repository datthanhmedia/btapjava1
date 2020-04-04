package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.ThuongHieu;
import dbconnection.ConnectionFactory;

public class ThuongHieuDAO {
	private static ThuongHieu convertToThuongHieu(ResultSet resultSet) throws SQLException {
		ThuongHieu thuongHieu = new ThuongHieu();
		thuongHieu.setIdThuongHieu(resultSet.getInt(1));
		thuongHieu.setMaThuongHieu(resultSet.getString(2));
		thuongHieu.setTenThuongHieu(resultSet.getString(3));
		thuongHieu.setGhiChu(resultSet.getString(4));
		return thuongHieu;
	}
	public ArrayList<ThuongHieu> tatCaThuongHieu(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<ThuongHieu> tatCaThuongHieu = new ArrayList<ThuongHieu>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM thuonghieu");
			while(resultSet.next()) {
				tatCaThuongHieu.add(convertToThuongHieu(resultSet));
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
		return tatCaThuongHieu;
	}
	public void themThuongHieu(ThuongHieu thuongHieu) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		String insertSQL = "INSERT INTO thuonghieu (mathuonghieu, tenthuonghieu, ghichu) VALUES(?, ?, ?)";
	try {
		connection = ConnectionFactory.getConnection();
		prepareStatement = connection.prepareStatement(insertSQL);
		prepareStatement.setString(1, thuongHieu.getMaThuongHieu());
		prepareStatement.setString(2, thuongHieu.getTenThuongHieu());
		prepareStatement.setString(3, thuongHieu.getGhiChu());
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
	public void suaThuongHieu(ThuongHieu thuongHieu) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE thuonghieu SET mathuonghieu = ?, tenthuonghieu = ?, ghichu = ? WHERE idthuonghieu = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, thuongHieu.getMaThuongHieu());
			preparedStatement.setString(2, thuongHieu.getTenThuongHieu());
			preparedStatement.setString(3, thuongHieu.getGhiChu());
			preparedStatement.setInt(4, thuongHieu.getIdThuongHieu());
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
	public void xoaThuongHieu(Integer idThuongHieu) {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "DELETE FROM thuonghieu WHERE idthuonghieu = " + idThuongHieu;
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
	public ThuongHieu getThuongHieu(int id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM thuonghieu WHERE idthuonghieu = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ThuongHieu ThuongHieu = convertToThuongHieu(resultSet);
				return ThuongHieu;
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