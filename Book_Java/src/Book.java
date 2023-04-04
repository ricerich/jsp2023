
public class Book {
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	
	public Book(){ }

	public Book(int bookid, String bookname, String publisher, int price) {
		this.bookid = bookid;
		this.bookname = bookname;
		this.publisher = publisher;
		this.price = price;
	}


	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPrice(int price) {
		this.price = price;
	}



	void printBook_obj()
	{
		System.out.println(bookid + "\t " + bookname + "\t " + publisher + "\t " + price);
	}

}
