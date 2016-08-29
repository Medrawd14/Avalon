package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.VoteUtil;

import entity.GameConfig;

import Dao.PlayerDao;

/**
 * ������Ӧ��ҵ���Ϸ�ռ����󣬽�д�����Ϸ�ռǷ��͵��ͻ���
 * @author o
 *
 */
public class LogServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		String info="<h2>��ǰΪ��Ϸ��"+VoteUtil.lun+"�֣�����ִ�е��ܽ�����ɹ�"+GameConfig.success+"�Σ�ʧ��"+GameConfig.back+"��</h2>";
		if(GameConfig.back>=3){
			info="<h2>��Ϸ�������췽ʤ��</h2>";
			PlayerDao.by=true;
		}
		if(GameConfig.success>=3){
			info="<h2>��Ϸ�������̿�ѡ����Ҵ�ɱ</h2>";
			PlayerDao.by=true;
		}
		String end="";
		for (int i = 0; i < GameConfig.gamelog.size(); i++) {
			String str=GameConfig.gamelog.get(i);
			synchronized (this) {
				
				if(i==(GameConfig.gamelog.size()-1)&&str.matches("task.*")){
					str=str.split("task ")[1];
					end="--do";
					GameConfig.gamelog.set(i, str);
				}
			}
			info+="<li>"+str+"</li>";
		}
		info+=end;
		pw.println(info);
		pw.close();
	}
}
