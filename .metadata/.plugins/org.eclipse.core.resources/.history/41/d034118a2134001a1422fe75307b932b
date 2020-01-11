package vn.quanlykh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.quanlykh.bo.KhachHang;
import vn.quanlykh.dbconnection.ConnectionFactory;
public class KhachHangDAO {
	private static KhachHang convertToKhachHang(ResultSet resultSet) throws SQLException {
		KhachHang khachhang = new KhachHang();
		khachhang.setId(resultSet.getInt(1));
		khachhang.setTenKH(resultSet.getString(2));
		khachhang.setThongTin(resultSet.getString(3));
		khachhang.setTrangThai(resultSet.getString(4));
		khachhang.setSdt(resultSet.getString(5));
		khachhang.setTenMien(resultSet.getString(6));
		khachhang.setNgay(resultSet.getString(7));
		khachhang.setSale(resultSet.getString(8));
		return khachhang;
	}
	public ArrayList<KhachHang> tatCaKhachHang(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM khachhang.thongtinkhachhang;");
			while(resultSet.next()) {
				listKhachHang.add(convertToKhachHang(resultSet));
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
		return listKhachHang;
	}
	public void themKhachHang(KhachHang khachHang) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String insertSQL = "INSERT INTO khachhang.thongtinkhachhang (tenkhachhang, thongtin, trangthai, sodienthoai, tenmien, ngay, sale) VALUES(?, ?, ?, ?, ?, ?, ?);";
		try {
			connection = ConnectionFactory.getConnection();
			prepareStatement = connection.prepareStatement(insertSQL);
			prepareStatement.setString(1, khachHang.getTenKH());
			prepareStatement.setString(2, khachHang.getThongTin());
			prepareStatement.setString(3, khachHang.getTrangThai());
			prepareStatement.setString(4, khachHang.getSdt());
			prepareStatement.setString(5, khachHang.getTenMien());
			prepareStatement.setString(6, khachHang.getNgay());
			prepareStatement.setString(7, khachHang.getSale());
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
	public void suaKhachHang(KhachHang khachHang) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE khachhang.thongtinkhachhang SET tenkhachhang = ?, thongtin = ?, trangthai = ?, sodienthoai = ?, tenmien = ?, ngay = ?, sale = ? WHERE id = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, khachHang.getTenKH());
			preparedStatement.setString(2, khachHang.getThongTin());
			preparedStatement.setString(3, khachHang.getTrangThai());
			preparedStatement.setString(4, khachHang.getSdt());
			preparedStatement.setString(5, khachHang.getTenMien());
			preparedStatement.setString(6, khachHang.getNgay());
			preparedStatement.setString(7, khachHang.getSale());
			preparedStatement.setInt(8, khachHang.getId());
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
	public KhachHang idKhachHang(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM khachhang.thongtinkhachhang WHERE id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				KhachHang khachHang = convertToKhachHang(resultSet);
				return khachHang;
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
	public void xoaKhachHang(int id) {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "DELETE FROM khachhang.thongtinkhachhang WHERE id = " + id;
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
	public ArrayList<KhachHang> timKiemKhachHang(String tukhoa){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM khachhang.thongtinkhachhang where id like '%" + tukhoa +"%' or tenkhachhang like '%" + tukhoa +"%' or thongtin like '%" + tukhoa +"%' or trangthai like '%" + tukhoa +"%' or sodienthoai like '%" + tukhoa +"%' or tenmien like '%" + tukhoa +"%' or ngay like '%" + tukhoa +"%' or sale like '%" + tukhoa +"%' ;");
			while(resultSet.next()) {
				listKhachHang.add(convertToKhachHang(resultSet));
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
		return listKhachHang;
	}
}

