package vn.quanlykh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.quanlykh.bo.QuanTri;
import vn.quanlykh.dbconnection.ConnectionFactory;


public class QuanTriDAO {
	private static QuanTri convertToQuanTri(ResultSet resultSet) throws SQLException {
		QuanTri quanTri = new QuanTri();
		quanTri.setId(resultSet.getInt(1));
		quanTri.setTaiKhoan(resultSet.getString(2));
		quanTri.setMatKhau(resultSet.getString(3));
		quanTri.setRole(resultSet.getString(4));
		return quanTri;
	}
	public ArrayList<QuanTri> tatCaQuanTri(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<QuanTri> listQuanTri = new ArrayList<QuanTri>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM khachhang.nguoidung;");
			while(resultSet.next()) {
				listQuanTri.add(convertToQuanTri(resultSet));
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
		return listQuanTri;
	}
	public void themQuanTri(QuanTri quanTri) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String insertSQL = "INSERT INTO khachhang.nguoidung (taikhoan, matkhau, chucvu) VALUES(?, ?, ?);";
		try {
			connection = ConnectionFactory.getConnection();
			prepareStatement = connection.prepareStatement(insertSQL);
			prepareStatement.setString(1, quanTri.getTaiKhoan());
			prepareStatement.setString(2, quanTri.getMatKhau());
			prepareStatement.setString(3, quanTri.getRole());
			
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
	public void suaQuanTri(QuanTri quanTri) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE khachhang.nguoidung SET taikhoan = ?, matkhau = ?, chucvu = ? WHERE id = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, quanTri.getTaiKhoan());
			preparedStatement.setString(2, quanTri.getMatKhau());
			preparedStatement.setString(3, quanTri.getRole());
			preparedStatement.setInt(4, quanTri.getId());
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
	public QuanTri idQuanTri(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM khachhang.nguoidung WHERE id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				QuanTri quanTri = convertToQuanTri(resultSet);
				return quanTri;
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
	public void xoaQuanTri(int id) {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "DELETE FROM khachhang.nguoidung WHERE id = " + id;
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
	public QuanTri findUser(String user, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM khachhang.nguoidung WHERE taikhoan = ? AND matkhau = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				QuanTri quanTri = convertToQuanTri(resultSet);
				return quanTri;
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
