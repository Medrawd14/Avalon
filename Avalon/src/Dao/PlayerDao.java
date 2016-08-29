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
 * 一个和玩家相关的工具类
 * @author o
 *
 */
public class PlayerDao {
	public static List<Player> list=new ArrayList<Player>();//玩家列表
	public static List<Role> list2=new ArrayList<Role>();//游戏角色列表
	public static boolean by=true;//用来初始化游戏参数的key，初始化后为false
	/**
	 * 测试用方法
	 */
	public static void test() {
		list.clear();
		Player p=new Player();
		p.setName("张三");
		list.add(p);
		p=new Player();
		p.setName("李四");
		list.add(p);
		p=new Player();
		p.setName("王五");
		list.add(p);
		p=new Player();
		p.setName("赵六");
		list.add(p);
		p=new Player();
		p.setName("田七");
		list.add(p);
		p=new Player();
		p.setName("阿西八");
		list.add(p);
	}
	/**
	 * 根据在线玩家数，初始化游戏角色，并把游戏角色赋予玩家，若在线人数超过游戏人数上限，默认赋予前是个玩家游戏角色
	 */
	public  static synchronized void getAllJs(int i) {
		// TODO Auto-generated method stub
		if(by){
			list2.clear();
			System.out.println("初始化游戏玩家数："+i);
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
	 * 根据cookie获得玩家昵称
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
	 * 根据cookie获得玩家游戏角色名
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
	 * 根据cookie获得玩家游戏ID，
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
	 * 根据游戏ID返回玩家昵称
	 */
	public static String getNameByGameId(String id) {
		// TODO Auto-generated method stub
		for (Player p:list) {
			System.out.println(p.getGameid()+",要寻找的id："+id);
			if(id.trim().equals(p.getGameid()+"")){
				return p.getName();
			}
		}
		return "???";
	}
	/**
	 * 根据玩家的sessionID删除角色，用于在玩家关闭列表后，从玩家列表中删除
	 */
	public static void delete(String id) {
		// TODO Auto-generated method stub
		System.out.println("要删除的id："+id);
		if(list==null||list.size()==0){
			
		}else{
			for(Player p:list){
				if(p.getId().equals(id)){
					list.remove(p);
					System.out.println("删除玩家");
					break;
				}
			}
			
		}
	}
}
