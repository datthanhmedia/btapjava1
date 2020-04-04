package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.SanPham;
import bo.SanPhamDaBan;
import dbconnection.ConnectionFactory;

public class SanPhamDaBanDAO {
	private static SanPhamDaBan convertToSanPhamDaBan(ResultSet resultSet) throws SQLException {
		SanPhamDaBan sanPhamDaBan = new SanPhamDaBan();
		sanPhamDaBan.setId(resultSet.getInt(1));
		sanPhamDaBan.setMaVach(resultSet.getString(2));
		sanPhamDaBan.setMaSanPham(resultSet.getString(3));
		sanPhamDaBan.setTenSanPham(resultSet.getString(4));
		sanPhamDaBan.setGiaVon(resultSet.getInt(5));
		sanPhamDaBan.setGiaBan(resultSet.getInt(6));
		sanPhamDaBan.setSoLuong(resultSet.getInt(7));
		sanPhamDaBan.setChietKhau(resultSet.getInt(8));
		sanPhamDaBan.setKhachHang(resultSet.getString(9));
		sanPhamDaBan.setGhiChu(resultSet.getString(10));
		sanPhamDaBan.setNgay(resultSet.getString(11));
		sanPhamDaBan.setNhanVien(resultSet.getString(12));
		return sanPhamDaBan;
	}
	public ArrayList<SanPhamDaBan> tatCaSanPhamDaBan(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<SanPhamDaBan> tatCaSanPhamDaBan = new ArrayList<SanPhamDaBan>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM sanphamdaban");
			while(resultSet.next()) {
				tatCaSanPhamDaBan.add(convertToSanPhamDaBan(resultSet));
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
		return tatCaSanPhamDaBan;
	}
	public void themSanPhamDaBan(SanPhamDaBan sanPhamDaBan) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		String insertSQL = "INSERT INTO sanphamdaban (mavach, masanpham, tensanpham, giavon, giaban, soluong, chietkhau, makhachhang, ghichu, ngay, nhanvien)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	try {
		connection = ConnectionFactory.getConnection();
		prepareStatement = connection.prepareStatement(insertSQL);
		prepareStatement.setString(1, sanPhamDaBan.getMaVach());
		prepareStatement.setString(2, sanPhamDaBan.getMaSanPham());
		prepareStatement.setString(3, sanPhamDaBan.getTenSanPham());
		prepareStatement.setInt(4, sanPhamDaBan.getGiaVon());
		prepareStatement.setInt(5, sanPhamDaBan.getGiaBan());
		prepareStatement.setInt(6, sanPhamDaBan.getSoLuong());
		prepareStatement.setInt(7, sanPhamDaBan.getChietKhau());
		prepareStatement.setString(8, sanPhamDaBan.getKhachHang());
		prepareStatement.setString(9, sanPhamDaBan.getGhiChu());
		prepareStatement.setString(10, sanPhamDaBan.getNgay());
		prepareStatement.setString(11, sanPhamDaBan.getNhanVien());
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
	public void banHang(SanPham sanPham) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE sanpham SET conlai = ? WHERE masanpham = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setInt(1, sanPham.getConLai());
			preparedStatement.setString(2, sanPham.getMaSanPham());
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
	
	public void suaSanPhamDaBan(SanPhamDaBan sanPhamDaBan) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE sanphamdaban SET mavach = ?, masanpham = ?, tensanpham = ?, giavon = ?, giaban = ?, soluong = ?, chietkhau = ?, makhachhang = ?, ghichu = ?, ngay = ?, nhanvien = ? WHERE idspdb = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, sanPhamDaBan.getMaVach());
			preparedStatement.setString(2, sanPhamDaBan.getMaSanPham());
			preparedStatement.setString(3, sanPhamDaBan.getTenSanPham());
			preparedStatement.setInt(4, sanPhamDaBan.getGiaVon());
			preparedStatement.setInt(5, sanPhamDaBan.getGiaBan());
			preparedStatement.setInt(6, sanPhamDaBan.getSoLuong());
			preparedStatement.setInt(7, sanPhamDaBan.getChietKhau());
			preparedStatement.setString(8, sanPhamDaBan.getKhachHang());
			preparedStatement.setString(9, sanPhamDaBan.getGhiChu());
			preparedStatement.setString(10, sanPhamDaBan.getNgay());
			preparedStatement.setString(11, sanPhamDaBan.getNhanVien());
			preparedStatement.setInt(12, sanPhamDaBan.getId());
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
	public void xoaSanPhamDaBan(Integer idSanPhamDaBan) {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "DELETE FROM sanphamdaban WHERE idspdb = " + idSanPhamDaBan;
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
	public ArrayList<SanPhamDaBan> getSanPhamDaBan(String maSanPhamDaBan){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<SanPhamDaBan> sanPhamDaBan = new ArrayList<SanPhamDaBan>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM sanphamdaban WHERE masanpham = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, maSanPhamDaBan);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				sanPhamDaBan.add(convertToSanPhamDaBan(resultSet));
				
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
		
		return sanPhamDaBan;
	}	

}
