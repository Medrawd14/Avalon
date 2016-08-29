package Util;

import java.util.List;

import entity.Player;
import entity.Role;
import Dao.PlayerDao;

/**
 * 游戏角色的工具类
 * @author o
 *
 */
public class RoleUtil {
	/**
	 * 初始化游戏角色
	 */
	public static void loadAllRole(int num){
		PlayerDao.list2.clear();
		Role role=new Role("平民", 11, "", "img/pm1.png");
		PlayerDao.list2.add(role);
		role=new Role("平民", 11, "", "img/pm2.png");
		PlayerDao.list2.add(role);
		role=new Role("派西维尔", 13, "能看到两个梅林,他们是：", "img/pxwr.png");
		PlayerDao.list2.add(role);
		role=new Role("梅林", 30, "知道坏人是谁（除了莫德雷格），但是要保护自己不被刺客杀害:", "img/ml.png");
		PlayerDao.list2.add(role);
		role=new Role("爪牙", 21, "知道你的同伴是谁:", "img/zy.png");
		PlayerDao.list2.add(role);
		role=new Role("刺客", 22, "知道你的同伴是谁:", "img/ck.png");
		PlayerDao.list2.add(role);
		role=new Role("莫甘娜", 29, "以梅林的形象出现,知道你的队友是谁:", "img/mgn.png");
		PlayerDao.list2.add(role);
		if(num>=8){
			role=new Role("平民", 11, "", "img/pm3.png");
			PlayerDao.list2.add(role);
		}
		if(num>=9){
			role=PlayerDao.list2.get(4);
			role.setImg("img/medrawd.png");
			role.setInfo("红方首领，身份不被梅林所知");
			role.setName("莫德雷德");
			role.setType(19);
			role=new Role("平民", 11, "", "img/pm4.png");
			PlayerDao.list2.add(role);
		}
		if(num==10){
			role=new Role("爪牙", 21, "知道你的同伴是谁", "img/zy.png");
			PlayerDao.list2.add(role);
		}
		if(num>10){
			PlayerDao.list2.clear();
			System.out.println("程序出错，加入的玩家数超过上限");
		}
	}
	/**
	 * 记录人物信息
	 */
	public static void setInfo(List<Player> list){
		Player p;
		Role r;
		String redView="";//坏人相互看到队友
		String blueView="";//派西维尔视角
		String mlView="";//梅林视角
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
