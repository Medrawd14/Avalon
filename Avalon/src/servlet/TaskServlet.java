package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.GameConfig;

import Dao.PlayerDao;
import Util.VoteUtil;

/**
 * �����������ͶƱ�����servlet������ñ��浽��Ϸ�ռ�
 * @author o
 *
 */
public class TaskServlet extends HttpServlet {
	static Map<String, String> map=new HashMap<String, String>();
//	static{
//		
//				map.put("����", "false");
//			
//				map.put("����", "true");
//			
//		
//	}
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/plain;charset=utf-8");
			String info=request.getParameter("info");
			String key=request.getParameter("key");
			map.put(key, info);
			System.out.println("���񻷽�");
			System.out.println("�Ѿ��ύ����"+map.size());
			System.out.println("Ӧ���ύ����"+GameConfig.lun[VoteUtil.lun-1]);
			if(map.size()==GameConfig.lun[VoteUtil.lun-1]){
				String result=VoteUtil.taskResult(map);
				GameConfig.gamelog.add(result);
				map.clear();
			}
			

}
}
