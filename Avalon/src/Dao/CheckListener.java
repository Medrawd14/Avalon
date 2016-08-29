package Dao;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session监听器，在玩家关掉页面后，从玩家列表中删除角色
 * @author o
 *
 */
public class CheckListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("回话创建");
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
		System.out.println(sdf.format(d));
	}
	
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("回话销毁");
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
		//PlayerDao pd=new PlayerDao();
		System.out.println(sdf.format(d));
		PlayerDao.delete(arg0.getSession().getId());
		//System.out.println(arg0.getSession().getId());
	}

}
