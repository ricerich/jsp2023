<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%> 
<%
	Connection conn = null;

// 	String url = "jdbc:mysql://localhost:3306/JSPBookDB";//mysql 연결문자열
	String url = "jdbc:oracle:thin:@localhost:1521:XE";//오라클 연결문자열
	String user = "webmarket";
	String password = "webmarket1234";

// 	Class.forName("com.mysql.jdbc.Driver");//mysql 연결시
	Class.forName("oracle.jdbc.driver.OracleDriver");//오라클 연결시, 드라이버 로딩
	conn = DriverManager.getConnection(url, user, password);
%>