package entity;
/**
 * ��Ϸ��ɫ��ʵ����
 * @author o
 *
 */
public class Role {
	private String name;//��ɫ����
	private int type;//��ɫ�����Ӫ��
	private String info;//��ɫ��Ϣ
	private String img;//ͼƬ·��
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
