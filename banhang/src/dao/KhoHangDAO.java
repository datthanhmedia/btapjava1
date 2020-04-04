package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.KhoHang;
import dbconnection.ConnectionFactory;

public class KhoHangDAO {
	private static KhoHang convertToKhoHang(ResultSet resultSet) throws SQLException {
		KhoHang khoHang = new KhoHang();
		khoHang.setId(resultSet.getInt(1));
		khoHang.setMaSanPham(resultSet.getString(2));
		khoHang.setChietKhau(resultSet.getInt(3));
		khoHang.setKieu(resultSet.getString(4));
		khoHang.setNgay(resultSet.getString(5));
		khoHang.setTonKho(resultSet.getInt(6));
		khoHang.setGhiChu(resultSet.getString(7));
		khoHang.setSoLuongXuat(resultSet.getInt(8));
		khoHang.setSoLuongNhap(resultSet.getInt(9));
		return khoHang;
	}
	public ArrayList<KhoHang> tatCaKhoHang(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<KhoHang> tatCaKhoHang = new ArrayList<KhoHang>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM khohang");
			while(resultSet.next()) {
				tatCaKhoHang.add(convertToKhoHang(resultSet));
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
		return tatCaKhoHang;
	}
	public void themKhoHang(KhoHang khoHang) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		String insertSQL = "INSERT INTO khohang (masanpham, chietkhau, kieu, ngay, tonkho, ghichu, soluongxuat, soluongnhap)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	try {
		connection = ConnectionFactory.getConnection();
		prepareStatement = connection.prepareStatement(insertSQL);
		prepareStatement.setString(1, khoHang.getMaSanPham());
		prepareStatement.setInt(2, khoHang.getChietKhau());
		prepareStatement.setString(3, khoHang.getKieu());
		prepareStatement.setString(4, khoHang.getNgay());
		prepareStatement.setInt(5, khoHang.getTonKho());
		prepareStatement.setString(6, khoHang.getGhiChu());
		prepareStatement.setInt(7, khoHang.getSoLuongXuat());
		prepareStatement.setInt(8, khoHang.getSoLuongNhap());
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
	
	public void suaKhoHang(KhoHang khoHang) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		String insertSQL = "UPDATE khohang SET masanpham = ?, chietkhau = ?, tonkho = ?, ghichu = ? Where masanpham=? And kieu =?";
	try {
		connection = ConnectionFactory.getConnection();
		prepareStatement = connection.prepareStatement(insertSQL);
		prepareStatement.setString(1, khoHang.getMaSanPham());
		prepareStatement.setInt(2, khoHang.getChietKhau());
		prepareStatement.setInt(3, khoHang.getTonKho());
		prepareStatement.setString(4, khoHang.getGhiChu());
		prepareStatement.setString(5, khoHang.getMaSanPham());
		prepareStatement.setString(6, "Nhập");
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
	public ArrayList<KhoHang> getKhoHang(String maSanPham){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<KhoHang> khoHang = new ArrayList<KhoHang>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM khohang WHERE masanpham = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, maSanPham);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				khoHang.add(convertToKhoHang(resultSet));
				
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
		
		return khoHang;
	}	
	public void xoaKhoHang(Integer idKhoHang) {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "DELETE FROM khohang WHERE idkhohang = " + idKhoHang;
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
}
