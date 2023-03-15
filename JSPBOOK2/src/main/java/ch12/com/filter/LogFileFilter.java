package ch12.com.filter;

import javax.servlet.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class LogFileFilter implements Filter  {
	
	PrintWriter writer;

	public void init(FilterConfig f1) throws ServletException {		
		String filename = f1.getInitParameter("filename");
        if(filename==null) throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");
        try {
        	
            writer = new PrintWriter(new FileWriter(filename, true), true);
            
        } catch (IOException e) {
            throw new ServletException("로그 파일을 열 수 없습니다.");
        }
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)	throws IOException, ServletException {			
		writer.println("현재일시 : "+getCurrentTime()+" 입니다 \n"  );
		String clientAddr = request.getRemoteAddr();
		writer.printf("클라이언트 주소 : "+clientAddr+" \n" );
       
        filterChain.doFilter(request, response);    

        String contentType = response.getContentType();
        writer.printf("문서의 콘텐츠 유형 : %s %n", contentType);
        writer.println("----------------------------------------------");
	}

	public void destroy( ){
		writer.close();
	}

	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}
}
