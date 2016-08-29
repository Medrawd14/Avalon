package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.GameConfig;

import Util.VoteUtil;

import Dao.PlayerDao;

/**
 * ��������ͶƱ��servlet�����浽��Ϸ�ռ�
 * @author o
 *
 */
public class VoteServlet extends HttpServlet {
		static Map<String, String> map=new HashMap<String, String>();
		static{
			for(int i=0;i<6;i++){
				if(i<3){
					map.put(i+"", "false");
					
				}else{
					map.put(i+"", "true");
				}
			}
		}
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/plain;charset=utf-8");
			//System.out.println("����ͶƱ");
			String info=request.getParameter("info");
			String key=request.getParameter("key");
			map.put(key, info);
			//System.out.println("����vote�Ľ��"+(map.size()==PlayerDao.list.size()));
			if(map.size()==PlayerDao.list.size()){
				String result=VoteUtil.voteResult(map);
				GameConfig.gamelog.add(result);
			}

		}
	}

