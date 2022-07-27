package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//此程式的功能為將放置於C:\Users\User\Pictures\alpha.jpg 圖片顯示給前端瀏覽器
//瀏覽器可以透過http://localhost:8080/JavaWeb_20220705/servlet/image/alpha 得到圖片

//@WebServlet(urlPatterns = "/servlet/image/alpha") → 只有urlPatterns的情況下可以不用加{}，甚至可省略成下列寫法
@WebServlet("/servlet/image/alpha")
public class AlphaImageServlet extends HttpServlet {
	
	//瀏覽器網址列按enter後得到資源極為get請求，因此這邊使用doGet()
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 因為資源為圖片，因此不用設定utf-8
		resp.setContentType("image/jpg"); //部分瀏覽器甚至不需要此行程式，會自行判斷資源為圖片格式 "image/*"
		String imgePath = "C:\\Users\\User\\Pictures\\alpha.jpg";
		File file = new File(imgePath);
		//PrintWriter使用來傳輸【文字類】的資訊，要傳輸【非文字類】的資訊需要使用ServletOutputStream
		//這裡的需求為傳圖片，因此要使用ServletOutputStream
		ServletOutputStream out = resp.getOutputStream();//回應的二進制通道
		//        (圖片來源端      , 目的端)
		Files.copy(file.toPath(), out);
		out.close();
	}
	/* ※補充事項
	 * 1.若圖片直接放在webapp資料夾底下，就可以視為網路資源直接執行(run on server)了
	 * 2.一個servlet只能有一個輸出(out)， ServletOutputStream、PrintWriter不能混用
	 */	
}
