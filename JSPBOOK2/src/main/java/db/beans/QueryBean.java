package db.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryBean {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public QueryBean() {

		conn = null;
		stmt = null;
		rs = null;
	}
	
	public void getConnection() {
		
		try {
			conn = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		
		if(rs != null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		if(stmt != null)
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList getUserInfo(String user_id) throws Exception
	{
		StringBuffer sb1 = new StringBuffer();
		
		sb1.append(" select "); 
		sb1.append("         u_id, u_name, u_phone, u_grade, write_time  ");
		sb1.append(" from  ");
		sb1.append("         user_info_sample  ");
		sb1.append(" where  ");
		sb1.append("         u_id like '%"+ user_id +"%' ");
		sb1.append(" order by  ");
		sb1.append("         u_name ");
		
		System.out.println("쿼리 문장: "+sb1.toString());
		
		rs = stmt.executeQuery(sb1.toString());
		
		ArrayList ar1 = new ArrayList();		
		while(rs.next())
		{
			ar1.add(rs.getString(1));
			ar1.add(rs.getString(2));
			ar1.add(rs.getString(3));
			ar1.add(rs.getString(4));
			ar1.add(rs.getString(5));
		}
		
		return ar1;
	}

}











