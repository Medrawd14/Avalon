package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Player;

import Dao.PlayerDao;
/**
 * ��¼�����servlet
 * @author o
 *
 */
public class ActionServlet extends HttpServlet {
	int i=0;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//new CheckThread().start();
		System.out.println("service����");
		String s=request.getRequestURI();
		String url=s.substring(s.lastIndexOf("/")+1, s.lastIndexOf("."));
		if("login".equals(url)){
			//������
//			if(i==0){
//				PlayerDao.test();
//				i++;
//			}
			//ceshi
			
			HttpSession session=request.getSession();
			String name=request.getParameter("name");
			Cookie[] coo=request.getCookies();
				
			//
			session.setMaxInactiveInterval(300000);
			//������ͨ�����øú������ж�����ڵ�½�Ժ��Ƿ��Ѿ��뿪����ҳ���������ֲ������룬�д��о�
			
			session.setAttribute("name", name);
			System.out.println("��session����������");
			Player p=new Player(session, name,session.getId());
			System.out.println(p);
			PlayerDao.list.add(p);
			response.sendRedirect("main.jsp");

		}
	}
}
