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
 * 用来响应玩家的游戏日记请求，将写入的游戏日记发送到客户端
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
		String info="<h2>当前为游戏第"+VoteUtil.lun+"轮，任务执行的总结果：成功"+GameConfig.success+"次，失败"+GameConfig.back+"次</h2>";
		if(GameConfig.back>=3){
			info="<h2>游戏结束，红方胜利</h2>";
			PlayerDao.by=true;
		}
		if(GameConfig.success>=3){
			info="<h2>游戏结束，刺客选择玩家刺杀</h2>";
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
