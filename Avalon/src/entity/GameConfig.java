package entity;

import java.util.ArrayList;
import java.util.List;

import Util.VoteUtil;

import Dao.PlayerDao;
/**
 * 相关游戏配置参数设置
 */
public class GameConfig {
	public static int sum;//游戏人数
	public static int[] lun=new int[5];//每轮的任务参加人数
	public static int captain=1;//队长ID
	public static int success=0;//整个游戏的任务成功次数
	public static int back=0;//整个游戏的任务失败次数
	public static List<String> gamelog=new ArrayList<String>();//存放游戏日记的list
	public static List<String> team=new ArrayList<String>();//存放参加任务的玩家名称list
	/**
	 * 还原该类相关参数
	 */
	public void clear(){
		captain=1;
		success=0;
		back=0;
		gamelog.clear();
		team.clear();
		VoteUtil.lun=1;
		VoteUtil.ci=1;
	};
	/**
	 * 根据在线人数，加载游戏参数
	 */
	public GameConfig(int num) {
		// TODO Auto-generated constructor stub
		if(num==7){
			clear();
			sum=7;
			lun[0]=2;
			lun[1]=3;
			lun[2]=3;
			lun[3]=4;
			lun[4]=4;
			PlayerDao.getAllJs(num);
			System.out.println(toString());
		}
		if(num==8){
			clear();
			sum=8;
			lun[0]=3;
			lun[1]=4;
			lun[2]=4;
			lun[3]=5;
			lun[4]=5;
			PlayerDao.getAllJs(num);
			System.out.println(toString());
		}
		if(num==9){
			clear();
			sum=9;
			lun[0]=3;
			lun[1]=4;
			lun[2]=4;
			lun[3]=5;
			lun[4]=5;
			PlayerDao.getAllJs(num);
			System.out.println(toString());
		}
		if(num==10){
			clear();
			sum=10;
			lun[0]=3;
			lun[1]=4;
			lun[2]=4;
			lun[3]=5;
			lun[4]=5;
			PlayerDao.getAllJs(num);
			System.out.println(toString());
		}
	}
	/**
	 * 根据游戏ID判断某位玩家是否被选中去参加任务
	 * 
	 */
	public static boolean toTask(String id){
		if("".equals(id)||team.size()==0){
			return false;
		}
		for(String s:team){
			if(s.equals(id)){
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "初始化游戏人数，当前游戏人数为"+sum+"，每轮任务的玩家参加数为"+lun;
	}
}
