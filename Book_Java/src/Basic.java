
public class Basic {
	public static void main(String args[]) { // 메소드이면서 프로그램실행에 관여함
		
		BookStore bs1 = new BookStore();
		
//		bs1.getConn();		
//		bs1.getCustomerList();
		
//		bs1.getConn();		
//		bs1.getBookList();
//		
//		bs1.getConn();		
//		bs1.getOrderList();
//		
		//1)변수
//		bs1.getConn();		
//		bs1.getBookList();
		
		//2)배열
//		bs1.getConn();
//		bs1.getBookList();//DB -> java배열에 넣음
//		bs1.printBookArr();//출력함
//		bs1.printBookArr();//출력함
//		bs1.printBookArr();//출력함
		
		//3)객체
//		bs1.getConn();
//		bs1.getBookList();
		
		//4)객체 배열
		bs1.getConn();
		bs1.getBookList();
		
//		for(int i=0; i<bs1.book_arr.length; i++)//private 적용으로 이제 안됨!
//			bs1.book_arr[i].printBook_obj();
		
		for(int i=0; i<bs1.getBook_arr().length; i++)
			bs1.getBook_arr()[i].printBook_obj();
		
	}
}
