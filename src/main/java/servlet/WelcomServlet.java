package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "welcome", urlPatterns = {"/servlet/welcome"})
public class WelcomServlet extends HttpServlet {
	//網址列按enter後前往，就是doGet()，可以用這個特性進行測試
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//設定utf-8編碼
		req.setCharacterEncoding("utf-8");//告知Server接收到的請求編碼
		resp.setCharacterEncoding("utf-8");//告知Server回應時的編碼
		resp.setContentType("text/html; charset=utf-8");//告知瀏覽器，Server回應過來時的文件格式與編碼
		//建立PrintWriter物件
		PrintWriter out = resp.getWriter();
		out.print("<h1>Welcome！</h1>");
		out.close();
	}

}
