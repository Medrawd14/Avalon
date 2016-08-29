package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.PlayerDao;
import Util.VoteUtil;

import entity.GameConfig;
import entity.Player;


/**
 * 用来处理，队长玩家发来的组队请求
 * 将组队情况变成游戏日记输出到每个玩家的网页上
 * @author o
 *
 */
public class CapServlrt extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id=request.getParameter("id");
		PrintWriter pw=response.getWriter();
		//System.out.println("你的id:"+id+",队长id"+GameConfig.captain);
		if(GameConfig.captain==Integer.parseInt(id)){
			//pw.println(GameConfig.captain==Integer.parseInt(id));
			String s="<h3>当前为第<span>"+VoteUtil.lun+"</span>轮第<span>"+VoteUtil.ci+"</span>次任务，你需要选择<span>"+GameConfig.lun[VoteUtil.lun-1]+"</span>位玩家去参加任务</h3>";
//	  		for(int i=0;i<GameConfig.sum;i++){
//	  			Player p=PlayerDao.list.get(i);
//	  			s+="<h4><label><input type='checkbox' name='check' class='check' value='"+p.getGameid()+"'><span>"+p.getName()+"</span></label></h4> ";
//	  		};
	  		//s+="<button  class='submit' onclick='f4'>提交</button>";
	  		//System.out.println("你是队长");
			pw.println(s);
		}else{
			pw.print("null");
		}
		
		pw.close();
	}
}
