package vn.quanlykh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.quanlykh.bo.TenMien;
import vn.quanlykh.dbconnection.ConnectionFactory;

public class TenMienDAO {
	private static TenMien convertToTenMien(ResultSet resultSet) throws SQLException {
		TenMien tenMien = new TenMien();
		tenMien.setId(resultSet.getInt(1));
		tenMien.setTenMien(resultSet.getString(2));
		tenMien.setTrangThai(resultSet.getString(3));
		tenMien.setNgayDangKy(resultSet.getString(4));
		tenMien.setNgayHetHan(resultSet.getString(5));
		tenMien.setHosting(resultSet.getString(6));
		return tenMien;
	}
	public ArrayList<TenMien> tatCaTenMien(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<TenMien> listTenMien = new ArrayList<TenMien>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM khachhang.tenmien;");
			while(resultSet.next()) {
				
				listTenMien.add(convertToTenMien(resultSet));
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
		return listTenMien;
	}
	public void themTenMien(TenMien tenMien) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String insertSQL = "INSERT INTO khachhang.tenmien (tenmien, trangthai, ngaydangky, ngayhethan, hosting) VALUES(?, ?, ?, ?, ?);";
		try {
			connection = ConnectionFactory.getConnection();
			prepareStatement = connection.prepareStatement(insertSQL);
			prepareStatement.setString(1, tenMien.getTenMien());
			prepareStatement.setString(2, tenMien.getTrangThai());
			prepareStatement.setString(3, tenMien.getNgayDangKy());
			prepareStatement.setString(4, tenMien.getNgayHetHan());
			prepareStatement.setString(5, tenMien.getHosting());
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
	public void suaTenMien(TenMien tenMien) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE khachhang.tenmien SET tenmien = ?, trangthai = ?, ngaydangky = ?, ngayhethan = ?, hosting = ? WHERE id = ?;";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, tenMien.getTenMien());
			preparedStatement.setString(2, tenMien.getTrangThai());
			preparedStatement.setString(3, tenMien.getNgayDangKy());
			preparedStatement.setString(4, tenMien.getNgayHetHan());
			preparedStatement.setString(5, tenMien.getHosting());
			preparedStatement.setInt(6, tenMien.getId());
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
	public TenMien idTenMien(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM khachhang.tenmien WHERE id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TenMien tenMien = convertToTenMien(resultSet);
				return tenMien;
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
	public void xoaTenMien(int id) {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "DELETE FROM khachhang.tenmien WHERE id = " + id;
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
	public ArrayList<TenMien> timKiemTenMien(String tukhoa){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<TenMien> listTenMien = new ArrayList<TenMien>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM khachhang.tenmien where id like '%" + tukhoa +"%' or tenmien like '%" + tukhoa + "%';");
			while(resultSet.next()) {
				listTenMien.add(convertToTenMien(resultSet));
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
		return listTenMien;
	}	
	public void giaHanTenMien(TenMien tenMien) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE khachhang.tenmien SET ngaydangky = ?, ngayhethan = ? WHERE id = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, tenMien.getNgayDangKy());
			preparedStatement.setString(2, tenMien.getNgayHetHan());
			preparedStatement.setInt(3, tenMien.getId());
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
	public void capNhatTrangThai(TenMien tenMien) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE khachhang.tenmien SET trangthai = ? WHERE id = ?;";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, tenMien.getTrangThai());
			preparedStatement.setInt(2, tenMien.getId());
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
	public ArrayList<TenMien> tenMienSapHetHan(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<TenMien> listTenMien = new ArrayList<TenMien>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM khachhang.tenmien where trangthai = 'Sắp Hết Hạn';");
			while(resultSet.next()) {
				
				listTenMien.add(convertToTenMien(resultSet));
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
		return listTenMien;
	} 
	public ArrayList<TenMien> tenMienHetHan(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<TenMien> listTenMien = new ArrayList<TenMien>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM khachhang.tenmien where trangthai = 'Hết Hạn';");
			while(resultSet.next()) {
				
				listTenMien.add(convertToTenMien(resultSet));
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
		return listTenMien;
	} 
}