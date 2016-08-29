package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.GameConfig;

import Dao.PlayerDao;
/**
 * 用来响应，玩家是否被选中去参加任务
 * @author o
 *
 */
public class ToTaskServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		String id=request.getParameter("id");
		pw.print(GameConfig.toTask(id));
		pw.close();
		
	}
}
