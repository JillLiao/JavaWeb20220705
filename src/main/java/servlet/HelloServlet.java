package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//GenericServlet → 通用型servlet
public class HelloServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset= utf-8");//必背！文件型態標準(制式)撰寫法，分號前面是類型，後面表示編碼方式
		//  文字/文字類型; 文件編碼方式= utf-8
		PrintWriter out = res.getWriter();
		out.print("Hello Servlet  "+ new Date());
		out.print("<p />");
		out.print("prints 1~10:");
		out.print("<br />");
		for(int i=1;i<=10;i++) {
			out.print(i);
		}
	}
}
