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

public class SanPhamDAO {
	private static SanPham convertToSanPham(ResultSet resultSet) throws SQLException {
		SanPham sanPham = new SanPham();
		sanPham.setId(resultSet.getInt(1));
		sanPham.setMaVach(resultSet.getString(2));
		sanPham.setMaSanPham(resultSet.getString(3));
		sanPham.setTenSanPham(resultSet.getString(4));
		sanPham.setGiaVon(resultSet.getInt(5));
		sanPham.setGiaBan(resultSet.getInt(6));
		sanPham.setGiaBuon(resultSet.getInt(7));
		sanPham.setSoLuong(resultSet.getInt(8));
		sanPham.setDonVi(resultSet.getString(9));
		sanPham.setVat(resultSet.getInt(10));
		sanPham.setDanhMuc(resultSet.getString(11));
		sanPham.setThuongHieu(resultSet.getString(12));
		sanPham.setNhaCungCap(resultSet.getString(13));
		sanPham.setConLai(resultSet.getInt(14));
		return sanPham;
	}
	private static SanPhamDaBan convertToGioHang(ResultSet resultSet) throws SQLException {
		SanPhamDaBan sanPham = new SanPhamDaBan();
		sanPham.setId(resultSet.getInt(1));
		sanPham.setMaSanPham(resultSet.getString(2));
		sanPham.setSoLuong(resultSet.getInt(3));
		sanPham.setGiaBan(resultSet.getInt(4));
		sanPham.setChietKhau(resultSet.getInt(5));
		sanPham.setVat(resultSet.getInt(6));
		return sanPham;
	}
	public ArrayList<SanPham> tatCaSanPham(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<SanPham> tatCaSanPham = new ArrayList<SanPham>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM sanpham");
			while(resultSet.next()) {
				tatCaSanPham.add(convertToSanPham(resultSet));
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
		return tatCaSanPham;
	}
	
	public void themSanPham(SanPham sanPham) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		String insertSQL = "INSERT INTO sanpham (mavach, masanpham, tensanpham, giavon, giaban, giabuon, soluong, donvi, vat, danhmuc, thuonghieu, ncc, conlai)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	try {
		connection = ConnectionFactory.getConnection();
		prepareStatement = connection.prepareStatement(insertSQL);
		prepareStatement.setString(1, sanPham.getMaVach());
		prepareStatement.setString(2, sanPham.getMaSanPham());
		prepareStatement.setString(3, sanPham.getTenSanPham());
		prepareStatement.setInt(4, sanPham.getGiaVon());
		prepareStatement.setInt(5, sanPham.getGiaBan());
		prepareStatement.setInt(6, sanPham.getGiaBuon());
		prepareStatement.setInt(7, sanPham.getSoLuong());
		prepareStatement.setString(8, sanPham.getDonVi());
		prepareStatement.setInt(9, sanPham.getVat());
		prepareStatement.setString(10, sanPham.getDanhMuc());
		prepareStatement.setString(11, sanPham.getThuongHieu());
		prepareStatement.setString(12, sanPham.getNhaCungCap());
		prepareStatement.setInt(13, sanPham.getSoLuong());
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
	public ArrayList<SanPhamDaBan> gioHang(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<SanPhamDaBan> gioHang = new ArrayList<SanPhamDaBan>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM giohang");
			while(resultSet.next()) {
				gioHang.add(convertToGioHang(resultSet));
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
		return gioHang;
	}
	
	public void themGioHang(SanPham sanPham) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		String insertSQL = "INSERT INTO giohang (masanpham, soluong, dongia, chietkhau, vat)"
				+ "VALUES(?, ?, ?, ?, ?)";
	try {
		connection = ConnectionFactory.getConnection();
		prepareStatement = connection.prepareStatement(insertSQL);
		prepareStatement.setString(1, sanPham.getMaSanPham());
		prepareStatement.setInt(2, sanPham.getSoLuong());
		prepareStatement.setInt(3, sanPham.getGiaBan());
		prepareStatement.setInt(4, sanPham.getChietKhau());
		prepareStatement.setInt(5, sanPham.getVat());
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
	public void xoaDonHang(int id) {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "DELETE FROM giohang WHERE idgiohang = " + id;
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
	public void xoaGioHang() {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "TRUNCATE TABLE giohang";
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
	public void banHang(int conLai, String maSanPham) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE sanpham SET conlai = ? WHERE masanpham = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setInt(1, conLai);
			preparedStatement.setString(2, maSanPham);
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
	
	public void suaSanPham(SanPham sanPham) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE sanpham SET mavach = ?, masanpham = ?, tensanpham = ?, giavon = ?, giaban = ?, giabuon = ?, soluong = ?, donvi = ?, vat = ?, danhmuc = ?, thuonghieu = ?, ncc = ?, conlai = ? WHERE idsanpham = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, sanPham.getMaVach());
			preparedStatement.setString(2, sanPham.getMaSanPham());
			preparedStatement.setString(3, sanPham.getTenSanPham());
			preparedStatement.setInt(4, sanPham.getGiaVon());
			preparedStatement.setInt(5, sanPham.getGiaBan());
			preparedStatement.setInt(6, sanPham.getGiaBuon());
			preparedStatement.setInt(7, sanPham.getSoLuong());
			preparedStatement.setString(8, sanPham.getDonVi());
			preparedStatement.setInt(9, sanPham.getVat());
			preparedStatement.setString(10, sanPham.getDanhMuc());
			preparedStatement.setString(11, sanPham.getThuongHieu());
			preparedStatement.setString(12, sanPham.getNhaCungCap());
			preparedStatement.setInt(13, sanPham.getSoLuong());
			preparedStatement.setInt(14, sanPham.getId());
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
	public void xoaSanPham(String maSanPham) {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "DELETE FROM sanpham WHERE masanpham = '" + maSanPham +"'";
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
	public SanPham getSanPham(String maSanPham){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM sanpham WHERE masanpham = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, maSanPham);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				SanPham sanPham = convertToSanPham(resultSet);
				return sanPham;
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
