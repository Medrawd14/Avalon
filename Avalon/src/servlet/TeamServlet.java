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
 * ������Ӧ�ӳ���ҷ�����������������������ϣ���Ҫ��ӳ�������ӣ����������Ϣ���浽��Ϸ�ռ�
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
		System.out.println("ѡ����  "+(info.length-1)+"  ���˲μ�����");
		System.out.println("��ǰΪ��"+VoteUtil.lun+"��,ʵ��Ҫ������������  "+GameConfig.lun[VoteUtil.lun-1]);
		if((info.length-1)!=GameConfig.lun[VoteUtil.lun-1]){
			pw.println("ѡ��������ʵ��Ҫ������������������ѡ��");
		}else{
			
			String res="���ζӳ�Ϊ�� "+PlayerDao.getNameByGameId((GameConfig.captain+"").trim())+" �����᰸ѡ��";
			for (int i = 1; i < info.length; i++) {
				//System.out.println("�õ���ѡ�е�value"+info[i]);
				System.out.println(info[i]);
				String name=PlayerDao.getNameByGameId(info[i].trim());
				GameConfig.team.clear();
				System.gc();
				GameConfig.team.add(info[i]);
				res=res+name+" ";
			}
			res+="ȥ�μ�����";
			GameConfig.gamelog.add(res);
			
			pw.println("true");
		}
		pw.close();
	}
}
