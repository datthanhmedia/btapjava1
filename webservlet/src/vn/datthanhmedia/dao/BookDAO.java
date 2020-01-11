package vn.datthanhmedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import vn.datthanhmedia.bo.Book;
import vn.datthanhmedia.dbconnection.ConnectionFactory;

public class BookDAO {
	public ArrayList<Book> getAllBook(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Book> BookList = new ArrayList<Book>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM book");
			while(resultSet.next()) {
				BookList.add(convertToBook(resultSet));
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
		return BookList;
	}
	public Book getBook(int id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM book WHERE id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = convertToBook(resultSet);
				return book;
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
	
	private static Book convertToBook(ResultSet resultSet) throws SQLException {
		Book Book = new Book();
		Book.setId(resultSet.getInt(1));
		Book.setName(resultSet.getString(2));
		Book.setAuthor(resultSet.getString(3));
		Book.setPublisher(resultSet.getString(4));
		Book.setPrice(resultSet.getInt(5));
		return Book;
	}
	public void addBook(Book book) {
		Connection connection = null;
		Statement statement = null;
		String insertSQL = "INSERT INTO Book (name, author, publisher, price) VALUES('" + book.getName() + "','"
				+ book.getAuthor() + "','"
				+ book.getPublisher() +
				+ book.getPrice() +"')";
		
	
	try {
		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();
		statement.executeUpdate(insertSQL);
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
	public void addBookPrepareStatement(Book book) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String insertSQL = "INSERT INTO book (name, author, publisher, price) VALUES(?, ?, ?, ?)";
	try {
		connection = ConnectionFactory.getConnection();
		prepareStatement = connection.prepareStatement(insertSQL);
		prepareStatement.setString(1, book.getName());
		prepareStatement.setString(2, book.getAuthor());
		prepareStatement.setString(3, book.getPublisher());
		prepareStatement.setInt(4, book.getPrice());
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
	
	public ArrayList<Book> findBookByName(String bookName){
		ArrayList<Book> listBook = new ArrayList<Book>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM jspseverlet.book WHERE name = '" + bookName + "';");
			while(resultSet.next()) {
				listBook.add(convertToBook(resultSet));
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
		return listBook;
	}
	public void deleteBook(Integer bookId) {
		Connection connection = null;
		Statement statement = null;
		String deleteColumn = "DELETE FROM book WHERE id = " + bookId;
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
	public void updateBook(Book book) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE book SET name = ?, author = ?, publisher = ?, price = ? WHERE id = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, book.getName());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setString(3, book.getPublisher());
			preparedStatement.setInt(4, book.getPrice());
			preparedStatement.setInt(5, book.getId());
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
	
}