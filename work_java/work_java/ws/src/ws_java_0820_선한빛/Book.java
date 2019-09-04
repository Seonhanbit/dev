package ws_java_0820_선한빛;

public class Book {
	private String isbn;
	private String title;
	private String publisher;
	private int price;
	private String description;
	private int authorno;
	
	public Book() {
	}

	public Book(String isbn, String title, String publisher, int price, String description, int authorno) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.description = description;
		this.authorno = authorno;
	}

	

	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", publisher=" + publisher + ", price=" + price
				+ ", description=" + description + ", authorno=" + authorno + "]";
	}

	public int getAuthorno() {
		return authorno;
	}

	public void setAuthorno(int authorno) {
		this.authorno = authorno;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
