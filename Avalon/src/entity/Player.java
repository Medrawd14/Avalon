package entity;


import javax.servlet.http.HttpSession;
/**
 * ��ҵ�ʵ����
 * @author o
 *
 */
public class Player {
	private HttpSession session;//����session
	private String name;//�ǳ�
	private String id;//����cookie�е�id
	private Role js;//��Ϸ��ɫ
	private int gameid;//��ϷID
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
