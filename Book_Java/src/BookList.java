
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookList {
	Connection con; // 멤버변수

	public BookList() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "madang"; // c##추가
		String pwd = "madang"; // c##추가

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

	private void sqlRun() { // 생성자
		String query = "SELECT * FROM book";
		try {
			Statement stmt = con.createStatement(); // 2
			ResultSet rs = stmt.executeQuery(query); // 3
			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \t\t\tPRICE");
			while (rs.next()) {
				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t\t\t" + rs.getString(3));
				System.out.println("\t\t\t\t" + rs.getInt(4));

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) { // 메소드이면서 프로그램실행에 관여함
		BookList so = new BookList();
		so.sqlRun();
	}
}