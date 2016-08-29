package Dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Util.RoleUtil;

import entity.Player;
import entity.Role;
/**
 * һ���������صĹ�����
 * @author o
 *
 */
public class PlayerDao {
	public static List<Player> list=new ArrayList<Player>();//����б�
	public static List<Role> list2=new ArrayList<Role>();//��Ϸ��ɫ�б�
	public static boolean by=true;//������ʼ����Ϸ������key����ʼ����Ϊfalse
	/**
	 * �����÷���
	 */
	public static void test() {
		list.clear();
		Player p=new Player();
		p.setName("����");
		list.add(p);
		p=new Player();
		p.setName("����");
		list.add(p);
		p=new Player();
		p.setName("����");
		list.add(p);
		p=new Player();
		p.setName("����");
		list.add(p);
		p=new Player();
		p.setName("����");
		list.add(p);
		p=new Player();
		p.setName("������");
		list.add(p);
	}
	/**
	 * �����������������ʼ����Ϸ��ɫ��������Ϸ��ɫ������ң�����������������Ϸ�������ޣ�Ĭ�ϸ���ǰ�Ǹ������Ϸ��ɫ
	 */
	public  static synchronized void getAllJs(int i) {
		// TODO Auto-generated method stub
		if(by){
			list2.clear();
			System.out.println("��ʼ����Ϸ�������"+i);
			RoleUtil.loadAllRole(i);
			Collections.shuffle(list2);
			int k=0;
			for(Role info:list2){
				list.get(k).setJs(info);
				k++;
				list.get(k-1).setGameid(k);
			}
			RoleUtil.setInfo(list);
			by=false;
		}
		
		
	}
	/**
	 * ����cookie�������ǳ�
	 */
	public static String getNameByCookie(String key) {
		// TODO Auto-generated method stub
		for (Player p:list) {
			if(key.equals(p.getId())){
				return p.getName();
			}
		}
		return "???";
	}
	/**
	 * ����cookie��������Ϸ��ɫ��
	 */
	public static Role getJsByCookie(String key) {
		// TODO Auto-generated method stub
		for (Player p:list) {
			if(key.equals(p.getId())){
				return p.getJs();
			}
		}
		return null;
	}
	/**
	 * ����cookie��������ϷID��
	 */
	public static int getGameIdByCookie(String key) {
		// TODO Auto-generated method stub
		for (Player p:list) {
			if(key.equals(p.getId())){
				return p.getGameid();
			}
		}
		return 999999;
	}
	/**
	 * ������ϷID��������ǳ�
	 */
	public static String getNameByGameId(String id) {
		// TODO Auto-generated method stub
		for (Player p:list) {
			System.out.println(p.getGameid()+",ҪѰ�ҵ�id��"+id);
			if(id.trim().equals(p.getGameid()+"")){
				return p.getName();
			}
		}
		return "???";
	}
	/**
	 * ������ҵ�sessionIDɾ����ɫ����������ҹر��б�󣬴�����б���ɾ��
	 */
	public static void delete(String id) {
		// TODO Auto-generated method stub
		System.out.println("Ҫɾ����id��"+id);
		if(list==null||list.size()==0){
			
		}else{
			for(Player p:list){
				if(p.getId().equals(id)){
					list.remove(p);
					System.out.println("ɾ�����");
					break;
				}
			}
			
		}
	}
}
