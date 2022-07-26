package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//當 TodayServlet 繼承了 HttpServlet(HTTP 型 Web 服務) 代表 TodayServlet 是一個 HTTP Web 服務
public class TodayServlet extends HttpServlet{

	// GET 請求過來時，就會由 doGET 服務回應
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E");
		//a 顯示上下午   E 顯示星期   HH 24小時制   hh 12小時制
		String today =sdf.format(date);
		System.out.println(today);//顯示於Server的Console中 (debug用)
		
		req.setCharacterEncoding("utf-8");//告知Server接收到的請求編碼
		resp.setCharacterEncoding("utf-8");	//告知Server回應時的編碼
		resp.setContentType("text/html; charset=utf-8"); //告知瀏覽器，Server回應過來時的文件格式與編碼
		PrintWriter out = resp.getWriter();
		out.print("<h1/>");
		out.print(today);
//		out.print("</h1>");
	}
	
}
