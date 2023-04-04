
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookStore {
	//1.멤버변수(DB 관련)
	Connection con; 
	Statement stmt;
	ResultSet rs;
	
	//1.멤버변수(DAO 데이터 객체 관련)
	
	//4가지 방법
	//1)변수
	//2)배열
	//3)객체
	//4)객체배열
	
	//1)변수 
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	
	//2)배열
	private int bookid_Arr[];
	private String bookname_Arr[];
	private String publisher_Arr[];
	private int price_Arr[];
	
	//3)객체 - 내부클래스 아니고, 객체 변수로
	private Book book_obj;
	
	//4)객체 배열
	private Book book_arr[];
	

	public BookStore() {
		con = null;
		stmt = null;
		rs = null;
		
		//2)배열 - 초기화
		bookid_Arr = new int[10];
		bookname_Arr= new String[10];
		publisher_Arr= new String[10];
		price_Arr = new int[10];
		
		//3)객체 - 초기화
//		book_obj = new Book();//생략
		
		//4)객체 배열 - 초기화
		book_arr = new Book[10] ;
	}
	
	
	//4)객체 배열용
	public Book[] getBook_arr() {
		return book_arr;
	}



	//3.메소드
	public void getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "madang"; // 
		String pwd = "madang"; // 

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("데이터베이스 연결 준비 .....");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getBookList() { // 생성자
		String query = "SELECT bookid, bookname, publisher, price FROM book";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \t\t\tPRICE");
			
			//2)배열용, 4)객체배열용
			int index=0;
			while (rs.next()) {
//				System.out.print("\t" + rs.getInt(1));
//				System.out.print("\t" + rs.getString(2));
//				System.out.print("\t\t\t" + rs.getString(3));
//				System.out.println("\t\t\t\t" + rs.getInt(4));
				
				//1)변수 
//				bookid    = rs.getInt(1);
//				bookname  = rs.getString(2);
//				publisher = rs.getString(3);
//				price 	  = rs.getInt(4);
//				printBook();
				
				//2)배열
//				bookid_Arr[index]    = rs.getInt(1);
//				bookname_Arr[index]  = rs.getString(2);
//				publisher_Arr[index] = rs.getString(3);
//				price_Arr[index]     = rs.getInt(4);
//				index++;
//				printBookArr();//반복해서 실행할 필요가 없어짐
				
				//3)객체
//				book_obj = new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
//				book_obj.printBook_obj();
				
				//4)객체배열
				//book_arr[index]= new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));//세터로 변경
				book_arr[index] = new Book();
				book_arr[index].setBookid(rs.getInt(1));
				book_arr[index].setBookname(rs.getString(2));
				book_arr[index].setPublisher(rs.getString(3));
				book_arr[index].setPrice(rs.getInt(4));
				
				//book_arr[index].printBook_obj();//이거는 바로 바로 출력하는거임, 이렇게 굳이 안해도 됨
				index++;

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//1)변수
	private void printBook()
	{
		System.out.println(bookid + "\t " + bookname + "\t " + publisher + "\t " + price);
	}
	
	//2)배열
	public void printBookArr()
	{
		for(int i=0; i<bookid_Arr.length;i++)
			System.out.println(bookid_Arr[i] + "\t " + bookname_Arr[i] + "\t " + publisher_Arr[i] + "\t " + price_Arr[i]);
	}
	
	
	
	
	public void getCustomerList() { // 생성자
		String query = "SELECT custid, name, address, phone FROM customer";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("고객ID \t 고객이름 \t\t주소 \t\t\t전화번호");
			while (rs.next()) {
				System.out.print("\t" + rs.getString(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t\t\t" + rs.getString(3));
				System.out.println("\t\t\t\t" + rs.getString(4));

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getOrderList() { // 주문목록
		
		String query = "";
		query += "";
		query += " select "; 
		query += "        name, bookname, price, saleprice  ";  
		query += " from  ";
		query += "        customer, orders, book  ";
		query += " where ";
		query += "       customer.custid = orders.custid ";
		query += " and orders.bookid = book.bookid ";
		query += "   and name like '박지성' ";
		
		System.out.println("쿼리문장:"+query);
		
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("고객ID \t 책이름 \t\t정가 \t\t\t판매가");
			while (rs.next()) {
				System.out.print("\t" + rs.getString(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t\t\t" + rs.getString(3));
				System.out.println("\t\t\t\t" + rs.getString(4));

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}