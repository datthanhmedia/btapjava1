package vn.datthanh.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.datthanh.bo.Order;
import vn.datthanh.dbconnection.ConnectionFactory;


public class OrderDAO {
	public void updateStatus(int id, String status, String webinfo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE `order`.orderinfo SET orderstatus = ?, webinfo = ? WHERE id = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, status);
			preparedStatement.setString(2, webinfo);
			preparedStatement.setInt(3, id);
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
	public ArrayList<Order> getOrderBySaler(String saler){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Order> orderListBySaler = new ArrayList<Order>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM `order`.orderinfo where saler = '" + saler +"'");
			while(resultSet.next()) {
				orderListBySaler.add(convertToOrder(resultSet));
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
		return orderListBySaler;
	}
	public ArrayList<Order> getOrderByDev(String dev){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Order> orderListByDev = new ArrayList<Order>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM `order`.orderinfo where dev = '" + dev +"'");
			while(resultSet.next()) {
				orderListByDev.add(convertToOrder(resultSet));
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
		return orderListByDev;
	}
	public ArrayList<Order> getAllOrder(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Order> orderList = new ArrayList<Order>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM order.orderinfo");
			while(resultSet.next()) {
				orderList.add(convertToOrder(resultSet));
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
		return orderList;
	}
	private static Order convertToOrder(ResultSet resultSet) throws SQLException {
		Order order = new Order();
		order.setId(resultSet.getInt(1));
		order.setCustomerName(resultSet.getString(2));
		order.setPhone(resultSet.getString(3));
		order.setInfo(resultSet.getString(4));
		order.setDeadline(resultSet.getDate(5));
		order.setSalerName(resultSet.getString(6));
		order.setDevName(resultSet.getString(7));
		order.setOrderStatus(resultSet.getString(8));
		order.setWebInfo(resultSet.getString(9));
		return order;
	}
	public void addOrder(Order order) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		String insertSQL = "INSERT INTO order.orderinfo (customername, phone, info, deadline, saler, dev, orderstatus, webinfo) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	try {
		connection = ConnectionFactory.getConnection();
		prepareStatement = connection.prepareStatement(insertSQL);
		prepareStatement.setString(1, order.getCustomerName());
		prepareStatement.setString(2, order.getPhone());
		prepareStatement.setString(3, order.getInfo());
		prepareStatement.setDate(4, (java.sql.Date) order.getDeadline());
		prepareStatement.setString(5, order.getSalerName());
		prepareStatement.setString(6, order.getDevName());
		prepareStatement.setString(7, order.getOrderStatus());
		prepareStatement.setString(8, order.getWebInfo());
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
	public void deleteOrder(Integer orderId) {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "DELETE FROM `order`.orderinfo WHERE id = " + orderId;
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
	public void updateOrder(Order order) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE `order`.orderinfo SET customername = ?, phone = ?, info = ?, deadline = ?, saler = ?, dev = ?, orderstatus = ?, webinfo = ? WHERE id = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, order.getCustomerName());
			preparedStatement.setString(2, order.getPhone());
			preparedStatement.setString(3, order.getInfo());
			preparedStatement.setDate(4, (java.sql.Date) order.getDeadline());
			preparedStatement.setString(5, order.getSalerName());
			preparedStatement.setString(6, order.getDevName());
			preparedStatement.setString(7, order.getOrderStatus());
			preparedStatement.setString(8, order.getWebInfo());
			preparedStatement.setInt(9, order.getId());
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
	public Order getOrder(int id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM order.orderinfo WHERE id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Order order = convertToOrder(resultSet);
				return order;
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
