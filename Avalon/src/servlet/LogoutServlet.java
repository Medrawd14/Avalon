package servlet;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 处理玩家退出请求
 * @author o
 *
 */
public class LogoutServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5537934251884615284L;
	

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		arg1.setContentType("text/plain");
		HttpSession hs=arg0.getSession();
		hs.invalidate();
		System.out.println("删除成功");
	}
}
