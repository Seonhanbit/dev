package ws_java_0819_선한빛;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDBO {
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	
	static {
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BookDBO() throws SQLException {
		con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/testdb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy",
				"ssafy");
	}
	
	
	public void close() {
		try {
			if(con !=null)
				con.close();
			if(pst != null)
				pst.close();
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertBook(Book book) {
		String str = "insert into books(isbn, title, author, publisher, price, description) values(?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(str);
			pst.setString(1, book.getIsbn());
			pst.setString(2, book.getTitle());
			pst.setString(3, book.getAuthor());
			pst.setString(4, book.getPublisher());
			pst.setInt(5, book.getPrice());
			pst.setString(6, book.getDescription());
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateBook(Book book) {
		String str = "update books set title =?, author = ?, publisher =?, price =?, description =? where isbn = ?";
		try {
			pst = con.prepareStatement(str);
			pst.setString(1, book.getTitle());
			pst.setString(2, book.getAuthor());
			pst.setString(3, book.getPublisher());
			pst.setInt(4, book.getPrice());
			pst.setString(5, book.getDescription());
			pst.setString(6, book.getIsbn());
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteBook(String isbn) {
		String str = "delete from books where isbn =?";
		try {
			pst = con.prepareStatement(str);
			pst.setString(1, isbn);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Book findBook(String isbn) {
		String str = "select * from books where isbn = ?";
		Book book = null;
		try {
			pst = con.prepareStatement(str);
			pst.setString(1, isbn);
			rs = pst.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				book.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	
	public List<Book> listBooks(){
		String str= "select * from books";
		ArrayList<Book> list = null;
		try {
			pst = con.prepareStatement(str);
			rs = pst.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				Book book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				book.setDescription(rs.getString("description"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int count() {
		return listBooks().size();
	}
}
