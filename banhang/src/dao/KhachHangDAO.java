package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.KhachHang;
import dbconnection.ConnectionFactory;

public class KhachHangDAO {
	private static KhachHang convertToKhachHang(ResultSet resultSet) throws SQLException {
		KhachHang khachHang = new KhachHang();
		khachHang.setIdKhachHang(resultSet.getInt(1));
		khachHang.setMaKhachHang(resultSet.getString(2));
		khachHang.setHoTen(resultSet.getString(3));
		khachHang.setLoai(resultSet.getString(4));
		khachHang.setDienThoai(resultSet.getString(5));
		khachHang.setEmail(resultSet.getString(6));
		khachHang.setFacebook(resultSet.getString(7));
		khachHang.setNgaySinh(resultSet.getString(8));
		khachHang.setGioiTinh(resultSet.getString(9));
		khachHang.setDiaChi(resultSet.getString(10));
		khachHang.setMST(resultSet.getString(11));
		khachHang.setCMND(resultSet.getString(12));
		khachHang.setGhiChu(resultSet.getString(13));
		khachHang.setNhanVien(resultSet.getString(14));
		return khachHang;
	}
	public ArrayList<KhachHang> tatCaKhachHang(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<KhachHang> tatCaKhachHang = new ArrayList<KhachHang>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM khachhang");
			while(resultSet.next()) {
				tatCaKhachHang.add(convertToKhachHang(resultSet));
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
		return tatCaKhachHang;
	}
	public void themKhachHang(KhachHang khachHang) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		String insertSQL = "INSERT INTO khachhang (makhachhang, hoten, loai, dienthoai, email, facebook, ngaysinh, gioitinh, diachi, mst, cmnd, ghichu, nvphutrach) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	try {
		connection = ConnectionFactory.getConnection();
		prepareStatement = connection.prepareStatement(insertSQL);
		prepareStatement.setString(1, khachHang.getMaKhachHang());
		prepareStatement.setString(2, khachHang.getHoTen());
		prepareStatement.setString(3, khachHang.getLoai());
		prepareStatement.setString(4, khachHang.getDienThoai());
		prepareStatement.setString(5, khachHang.getEmail());
		prepareStatement.setString(6, khachHang.getFacebook());
		prepareStatement.setString(7, khachHang.getNgaySinh());
		prepareStatement.setString(8, khachHang.getGioiTinh());
		prepareStatement.setString(9, khachHang.getDiaChi());
		prepareStatement.setString(10, khachHang.getMST());
		prepareStatement.setString(11, khachHang.getCMND());
		prepareStatement.setString(12, khachHang.getGhiChu());
		prepareStatement.setString(13, khachHang.getNhanVien());
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
			
			String updateSql = "UPDATE khachhang SET makhachhang = ?, hoten = ?, loai = ?, dienthoai = ?, email = ?, facebook = ?, ngaysinh = ?, gioitinh = ?, diachi = ?, mst = ?, cmnd = ?, ghichu = ?, nvphutrach = ? WHERE makhachhang = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, khachHang.getMaKhachHang());
			preparedStatement.setString(2, khachHang.getHoTen());
			preparedStatement.setString(3, khachHang.getLoai());
			preparedStatement.setString(4, khachHang.getDienThoai());
			preparedStatement.setString(5, khachHang.getEmail());
			preparedStatement.setString(6, khachHang.getFacebook());
			preparedStatement.setString(7, khachHang.getNgaySinh());
			preparedStatement.setString(8, khachHang.getGioiTinh());
			preparedStatement.setString(9, khachHang.getDiaChi());
			preparedStatement.setString(10, khachHang.getMST());
			preparedStatement.setString(11, khachHang.getCMND());
			preparedStatement.setString(12, khachHang.getGhiChu());
			preparedStatement.setString(13, khachHang.getNhanVien());
			preparedStatement.setString(14, khachHang.getMaKhachHang());
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
	public void xoaKhachHang(Integer idKhachHang) {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "DELETE FROM khachhang WHERE idkhachhang = " + idKhachHang;
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
	public KhachHang getKhachHangByMa(String maKhachHang){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM khachhang WHERE makhachhang ='" + maKhachHang+"'");
			while(resultSet.next()) {
				KhachHang khachHang = convertToKhachHang(resultSet);
				return khachHang;
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
		return null;
	}
}
