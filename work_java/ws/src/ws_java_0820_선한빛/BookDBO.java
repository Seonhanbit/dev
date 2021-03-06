package ws_java_0820_선한빛;

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
		String str = "insert into books(isbn, title, publisher, price, description) values(?,?,?,?,?)";
		try {
			pst = con.prepareStatement(str);
			pst.setString(1, book.getIsbn());
			pst.setString(2, book.getTitle());
			pst.setString(3, book.getPublisher());
			pst.setInt(4, book.getPrice());
			pst.setString(5, book.getDescription());
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertAuthor(Author author) {
		String str = "insert into author(authorno, name, phone) values(?,?,?)";
		try {
			pst = con.prepareStatement(str);
			pst.setInt(1, author.getAuthorno());
			pst.setString(2, author.getName());
			pst.setString(3, author.getPhone());
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateBook(Book book) {
		String str = "update books set title =?, publisher =?, price =?, description =?, authorno=? where isbn = ?";
		try {
			pst = con.prepareStatement(str);
			pst.setString(1, book.getTitle());
			pst.setString(2, book.getPublisher());
			pst.setInt(3, book.getPrice());
			pst.setString(4, book.getDescription());
			pst.setString(5, book.getIsbn());
			pst.setInt(6, book.getAuthorno());
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
	
	public String find() {
		String str = "select book.title, book.price, author.name from book, author where book.authorno = author.authorno";
		StringBuilder sb = new StringBuilder();
		try {
			pst = con.prepareStatement(str);
			rs = pst.executeQuery();
			while (rs.next()) {
				sb.append(rs.getString("title") +"\t");
				sb.append(rs.getInt("price")+"\t");
				sb.append(rs.getString("name")+"\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public String findAuthor(String name) {
		String str = "select title, isbn, publisher from book where authorno = (select authorno from author where name = ?)";
		StringBuilder sb = new StringBuilder();
		try {
			pst = con.prepareStatement(str);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while(rs.next()) {
				sb.append(rs.getString("title") +"\t");
				sb.append(rs.getString("isbn")+"\t");
				sb.append(rs.getString("publisher")+"\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public String printAuthor() {
		String str = "select title, publisher, price, name "
				+ "from book, author group by name";
		StringBuilder sb = new StringBuilder();
		try {
			pst = con.prepareStatement(str);
			rs = pst.executeQuery();
			while(rs.next()) {
				sb.append(rs.getString("title") +"\t");
				sb.append(rs.getString("publisher")+"\t");
				sb.append(rs.getInt("price")+"\t");
				sb.append(rs.getString("name")+"\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public String query() {
		String str = "select concat(title,'은 ', publisher,'에서 출판했다.\n') as str "
				+ "from book";
		StringBuilder sb = new StringBuilder();
		try {
			pst = con.prepareStatement(str);
			rs = pst.executeQuery();
			while(rs.next()) {
				sb.append(rs.getString("str"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
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
	
	public List<Author> listAuthor(){
		String str= "select * from author";
		ArrayList<Author> list = null;
		try {
			pst = con.prepareStatement(str);
			rs = pst.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				Author author = new Author();
				author.setAuthorno(rs.getInt("authorno"));
				author.setName(rs.getString("name"));
				author.setPhone(rs.getString("phone"));
				list.add(author);
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
