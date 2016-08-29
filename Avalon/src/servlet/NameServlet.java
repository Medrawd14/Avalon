package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Player;

import Dao.PlayerDao;

/**
 * 返回在线玩家列表
 * @author o
 *
 */
public class NameServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
		//System.out.println("这里是num");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String info="";
		PrintWriter pw=response.getWriter();
		for (int i = 0; i < PlayerDao.list.size(); i++) {
			Player p=PlayerDao.list.get(i);
			info=info+p.getName()+",";
		}
		info=info+"over";
		pw.println(info);
		pw.close();
	}
}
