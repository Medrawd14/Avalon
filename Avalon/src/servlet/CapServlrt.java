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
 * ���������ӳ���ҷ������������
 * �������������Ϸ�ռ������ÿ����ҵ���ҳ��
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
		//System.out.println("���id:"+id+",�ӳ�id"+GameConfig.captain);
		if(GameConfig.captain==Integer.parseInt(id)){
			//pw.println(GameConfig.captain==Integer.parseInt(id));
			String s="<h3>��ǰΪ��<span>"+VoteUtil.lun+"</span>�ֵ�<span>"+VoteUtil.ci+"</span>����������Ҫѡ��<span>"+GameConfig.lun[VoteUtil.lun-1]+"</span>λ���ȥ�μ�����</h3>";
//	  		for(int i=0;i<GameConfig.sum;i++){
//	  			Player p=PlayerDao.list.get(i);
//	  			s+="<h4><label><input type='checkbox' name='check' class='check' value='"+p.getGameid()+"'><span>"+p.getName()+"</span></label></h4> ";
//	  		};
	  		//s+="<button  class='submit' onclick='f4'>�ύ</button>";
	  		//System.out.println("���Ƕӳ�");
			pw.println(s);
		}else{
			pw.print("null");
		}
		
		pw.close();
	}
}
