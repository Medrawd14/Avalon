package entity;
/**
 * 游戏角色的实体类
 * @author o
 *
 */
public class Role {
	private String name;//角色名称
	private int type;//角色类别（阵营）
	private String info;//角色信息
	private String img;//图片路径
	public Role() {
		// TODO Auto-generated constructor stub
	}
	public Role(String name, int type, String info,String img) {
		this.name = name;
		this.type = type;
		this.info = info;
		this.img=img;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Role [info=" + info + ", name=" + name + "]";
	}
	
}
