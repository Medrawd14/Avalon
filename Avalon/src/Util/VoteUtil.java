package Util;

import java.util.Map;
import java.util.Set;

import entity.GameConfig;
/**
 * ͶƱ�Ĺ�����
 * @author o
 *
 */
public class VoteUtil {
	public static int lun=1;//��¼��ǰ��Ϸ����
	public static int ci=1;//��¼��ǰ���µĵڼ����᰸
	/**
	 * ���������ͶƱ�����
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
			res="����ɹ�";
			GameConfig.success++;
		}
		if(lun==4&&f>=2){
			res="����ʧ��";
			GameConfig.back++;
		}
		if(f<=0){
			res="����ɹ�";
			GameConfig.success++;
		}else{
			res="����ʧ��";
			GameConfig.back++;
		}
		res= "��"+(lun-1)+"���������� "+z+"Ʊ�޳ɣ�"+f+"Ʊ����,"+res;
		return res;
	}
	/**
	 * �����᰸��ͶƱ���
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
			//res="�ɽ���";
			GameConfig.captain++;
			if(GameConfig.captain>GameConfig.sum){
				//System.out.println("�������"+GameConfig.sum);
				GameConfig.captain=1;
			}
			res= "task ��"+(lun-1)+"�ֵ�"+ci+"�ε�ͶƱ����� "+z+"Ʊ�޳ɣ�"+f+"Ʊ����,����ɽ���";
			ci=1;
		}else{
			//res="������";
			res= "��"+lun+"�ֵ�"+ci+"�ε�ͶƱ����� "+z+"Ʊ�޳ɣ�"+f+"Ʊ����,���񲻽���";
			ci++;
			GameConfig.captain++;
			if(GameConfig.captain>GameConfig.sum){
				//System.out.println("�������"+GameConfig.sum);
				GameConfig.captain=1;
			}
			if(ci==6){
				ci=1;
				GameConfig.back++;
				res= "��"+lun+"�ֵ�5�ε�ͶƱ����� "+z+"Ʊ�޳ɣ�"+f+"Ʊ����,���񲻽���";
				lun++;
			}
		}
		return res;
	}
}
