package entity;


import javax.servlet.http.HttpSession;
/**
 * 玩家的实体类
 * @author o
 *
 */
public class Player {
	private HttpSession session;//保存session
	private String name;//昵称
	private String id;//保存cookie中的id
	private Role js;//游戏角色
	private int gameid;//游戏ID
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public Player(HttpSession session, String name,String id) {
		this.session = session;
		this.name = name;
		this.id=id;
	}
	
	public int getGameid() {
		return gameid;
	}
	public void setGameid(int gameid) {
		this.gameid = gameid;
	}
	public Role getJs() {
		return js;
	}
	public void setJs(Role js) {
		this.js = js;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", session="
				+ session + "]";
	}
	
}
