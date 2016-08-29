package entity;

import java.util.ArrayList;
import java.util.List;

import Util.VoteUtil;

import Dao.PlayerDao;
/**
 * �����Ϸ���ò�������
 */
public class GameConfig {
	public static int sum;//��Ϸ����
	public static int[] lun=new int[5];//ÿ�ֵ�����μ�����
	public static int captain=1;//�ӳ�ID
	public static int success=0;//������Ϸ������ɹ�����
	public static int back=0;//������Ϸ������ʧ�ܴ���
	public static List<String> gamelog=new ArrayList<String>();//�����Ϸ�ռǵ�list
	public static List<String> team=new ArrayList<String>();//��Ųμ�������������list
	/**
	 * ��ԭ������ز���
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
	 * ��������������������Ϸ����
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
	 * ������ϷID�ж�ĳλ����Ƿ�ѡ��ȥ�μ�����
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
		return "��ʼ����Ϸ��������ǰ��Ϸ����Ϊ"+sum+"��ÿ���������Ҳμ���Ϊ"+lun;
	}
}
