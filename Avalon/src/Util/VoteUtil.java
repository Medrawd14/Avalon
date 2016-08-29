package Util;

import java.util.Map;
import java.util.Set;

import entity.GameConfig;
/**
 * 投票的工具类
 * @author o
 *
 */
public class VoteUtil {
	public static int lun=1;//记录当前游戏轮数
	public static int ci=1;//记录当前轮下的第几次提案
	/**
	 * 返回任务的投票结果，
	 * @param map
	 * @return
	 */
	public static String taskResult(Map<String, String> map){
		Set<String >set=map.keySet();
		int z=0;
		int f=0;
		String res="";
		for(String key:set){
			if(map.get(key).equals("true")){
				z++;
			}else{
				f++;
			}
		}
		if(lun==4&&f<2){
			res="任务成功";
			GameConfig.success++;
		}
		if(lun==4&&f>=2){
			res="任务失败";
			GameConfig.back++;
		}
		if(f<=0){
			res="任务成功";
			GameConfig.success++;
		}else{
			res="任务失败";
			GameConfig.back++;
		}
		res= "第"+(lun-1)+"轮任务结果： "+z+"票赞成，"+f+"票反对,"+res;
		return res;
	}
	/**
	 * 返回提案的投票结果
	 * @param map
	 * @return
	 */
	public static String voteResult(Map<String, String> map){
		Set<String >set=map.keySet();
		int z=0;
		int f=0;
		String res="";
		for(String key:set){
			if(map.get(key).equals("true")){
				z++;
			}else{
				f++;
			}
		}
		if(z>f){
			lun++;
			//res="可进行";
			GameConfig.captain++;
			if(GameConfig.captain>GameConfig.sum){
				//System.out.println("玩家人数"+GameConfig.sum);
				GameConfig.captain=1;
			}
			res= "task 第"+(lun-1)+"轮第"+ci+"次的投票结果： "+z+"票赞成，"+f+"票反对,任务可进行";
			ci=1;
		}else{
			//res="不进行";
			res= "第"+lun+"轮第"+ci+"次的投票结果： "+z+"票赞成，"+f+"票反对,任务不进行";
			ci++;
			GameConfig.captain++;
			if(GameConfig.captain>GameConfig.sum){
				//System.out.println("玩家人数"+GameConfig.sum);
				GameConfig.captain=1;
			}
			if(ci==6){
				ci=1;
				GameConfig.back++;
				res= "第"+lun+"轮第5次的投票结果： "+z+"票赞成，"+f+"票反对,任务不进行";
				lun++;
			}
		}
		return res;
	}
}
