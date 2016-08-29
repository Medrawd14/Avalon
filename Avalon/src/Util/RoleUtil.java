package Util;

import java.util.List;

import entity.Player;
import entity.Role;
import Dao.PlayerDao;

/**
 * ��Ϸ��ɫ�Ĺ�����
 * @author o
 *
 */
public class RoleUtil {
	/**
	 * ��ʼ����Ϸ��ɫ
	 */
	public static void loadAllRole(int num){
		PlayerDao.list2.clear();
		Role role=new Role("ƽ��", 11, "", "img/pm1.png");
		PlayerDao.list2.add(role);
		role=new Role("ƽ��", 11, "", "img/pm2.png");
		PlayerDao.list2.add(role);
		role=new Role("����ά��", 13, "�ܿ�������÷��,�����ǣ�", "img/pxwr.png");
		PlayerDao.list2.add(role);
		role=new Role("÷��", 30, "֪��������˭������Ī���׸񣩣�����Ҫ�����Լ������̿�ɱ��:", "img/ml.png");
		PlayerDao.list2.add(role);
		role=new Role("צ��", 21, "֪�����ͬ����˭:", "img/zy.png");
		PlayerDao.list2.add(role);
		role=new Role("�̿�", 22, "֪�����ͬ����˭:", "img/ck.png");
		PlayerDao.list2.add(role);
		role=new Role("Ī����", 29, "��÷�ֵ��������,֪����Ķ�����˭:", "img/mgn.png");
		PlayerDao.list2.add(role);
		if(num>=8){
			role=new Role("ƽ��", 11, "", "img/pm3.png");
			PlayerDao.list2.add(role);
		}
		if(num>=9){
			role=PlayerDao.list2.get(4);
			role.setImg("img/medrawd.png");
			role.setInfo("�췽���죬��ݲ���÷����֪");
			role.setName("Ī���׵�");
			role.setType(19);
			role=new Role("ƽ��", 11, "", "img/pm4.png");
			PlayerDao.list2.add(role);
		}
		if(num==10){
			role=new Role("צ��", 21, "֪�����ͬ����˭", "img/zy.png");
			PlayerDao.list2.add(role);
		}
		if(num>10){
			PlayerDao.list2.clear();
			System.out.println("�������������������������");
		}
	}
	/**
	 * ��¼������Ϣ
	 */
	public static void setInfo(List<Player> list){
		Player p;
		Role r;
		String redView="";//�����໥��������
		String blueView="";//����ά���ӽ�
		String mlView="";//÷���ӽ�
		for (int i = 0; i < list.size(); i++) {
			p=list.get(i);
			r=p.getJs();
			if(r.getType()>=19&&r.getType()<=29){
				redView=redView+p.getName()+" ";
				if(r.getType()!=19){
					mlView=mlView+p.getName()+" ";
				}
			}
			if(r.getType()>=29){
				blueView=blueView+p.getName()+" ";
			}
		}
		for (int i = 0; i < list.size(); i++) {
			p=list.get(i);
			r=p.getJs();
			if(r.getType()==13){
				r.setInfo(r.getInfo()+" "+blueView);
			}
			if(r.getType()==30){
				r.setInfo(r.getInfo()+" "+mlView);
			}
			if(r.getType()>=19&&r.getType()<=29){
				String f=redView.replace(p.getName(), "");
				r.setInfo(r.getInfo()+" "+f);
			}
		}
		
	}
}
