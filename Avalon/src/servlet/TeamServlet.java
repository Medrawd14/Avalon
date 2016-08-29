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
 * 用来响应队长玩家发来的组队请求，如果任务不相符合，则要求队长重新组队，否则将组队信息保存到游戏日记
 * @author o
 *
 */
public class TeamServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String msg=request.getParameter("info");
		String[] info=msg.split(",");
		PrintWriter pw=response.getWriter();
		System.out.println("选择了  "+(info.length-1)+"  个人参加任务");
		System.out.println("当前为第"+VoteUtil.lun+"轮,实际要求任务人数：  "+GameConfig.lun[VoteUtil.lun-1]);
		if((info.length-1)!=GameConfig.lun[VoteUtil.lun-1]){
			pw.println("选择人数和实际要求人数不符，请重新选择");
		}else{
			
			String res="本次队长为： "+PlayerDao.getNameByGameId((GameConfig.captain+"").trim())+" 本次提案选择：";
			for (int i = 1; i < info.length; i++) {
				//System.out.println("得到被选中的value"+info[i]);
				System.out.println(info[i]);
				String name=PlayerDao.getNameByGameId(info[i].trim());
				GameConfig.team.clear();
				System.gc();
				GameConfig.team.add(info[i]);
				res=res+name+" ";
			}
			res+="去参加任务";
			GameConfig.gamelog.add(res);
			
			pw.println("true");
		}
		pw.close();
	}
}
