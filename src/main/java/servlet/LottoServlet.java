package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//當 LottoServlet 繼承了GenericServlet，就從 java(地端) 服務轉變為 web(雲端) 服務了
public class LottoServlet extends GenericServlet{

	/**
	 * 通常會加入版本號碼(serialVersionUID)供內部工程師管理
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//1.撰寫服務商業邏輯: 自動產生四星彩號碼
		Random r = new Random();
		List<Integer> lotto = new ArrayList<>();
		lotto.add(r.nextInt(10));//生成0~9的隨機數
		lotto.add(r.nextInt(10));//生成0~9的隨機數
		lotto.add(r.nextInt(10));//生成0~9的隨機數
		lotto.add(r.nextInt(10));//生成0~9的隨機數
		//2.將lotto回應給client端
		res.setContentType("text/html; charset= utf-8");//回應的文件格式
		PrintWriter out = res.getWriter();//產生可寫入的回應物件
		out.print(lotto);
		//3.關閉
		out.close();
	}

}
