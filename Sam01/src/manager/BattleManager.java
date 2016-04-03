package manager;

import info.Troops;

public class BattleManager 
{
	static int baseBattleRate = 1;
	public static int CAVALY_MEN_POWER = 10;
	public static int INFANTRY_MEN_POWER = 2;
	public static int BOW_MEN_POWER = 1;
	
	public void battle(Troops t1, Troops t2)
	{
		// Ư��ȸ�� �����Ĵ� ���� ����, ����,����
		// �⺴ ������, ����, �ú��� ��
		// â�� ����, �󼺿�
		// �ú� ������ ���� �󼺽� ���ؾ��� ���ݷ�, ���� �� �� ȥ���� ����, ����, �⺴�� ������ ���ذ� �ɰ�
		// �������� ���� �ú��� �⺴�� ȥ���� ũ�� ����
		// �⺴ ������ ���� ��
		// ���� �켱���� : �⺴-�⺴, �⺴-����, �⺴-�ú�, ����-�ú� 
		t1.getCavalyPower();
		
		// ȥ���� ����  => ���� ������ �񱳿� ���� ��������������
		t1.addConfusion(t2);
		t2.addConfusion(t1);
		
		//System.out.println("t1:" + t1.getConfusionRate() + ", t2:" + t2.getConfusionRate());
				
		int t1_BattlePower = t1.getCavalyPower();
		int t2_BattlePower = t2.getCavalyPower();
		
		t1.beAttacked(t2_BattlePower);
		t2.beAttacked(t1_BattlePower);
		
		System.out.println("t1_p:"+t1_BattlePower+", t1_m:"+t1.getCavalrymen()+", t2_p:"+t2_BattlePower+", t2_m:"+t2.getCavalrymen());
	}
}
