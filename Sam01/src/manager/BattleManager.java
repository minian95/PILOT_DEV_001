package manager;

import info.Troops;

public class BattleManager 
{
	static int baseBattleRate = 1;
	
	public void battle(Troops t1, Troops t2)
	{
		// Ư��ȸ�� �����Ĵ� ���� ����, ����,����
		// �⺴ ������, ����, �ú��� ��
		// â�� ����, �󼺿�
		// �ú� ������ ���� �󼺽� ���ؾ��� ���ݷ�, ���� �� �� ȥ���� ����, ����, �⺴�� ������ ���ذ� �ɰ�
		// �������� ���� �ú��� �⺴�� ȥ���� ũ�� ����
		// �⺴ ������ ���� ��
		// ���� �켱���� : �⺴-�⺴, �⺴-����, �⺴-�ú�, ����-�ú� 
		
		// ȥ���� ����
		t1.applyConfusion(t2);
		t2.applyConfusion(t1);
		
		// ��� ����
		
		//System.out.println("t1:" + t1.getConfusionRate() + ", t2:" + t2.getConfusionRate());
				
		int t1_cavalyPower = t1.getCavalyPower(t2);
		int t2_cavalyPower = t2.getCavalyPower(t1);
		
		t1.beAttacked(t2_cavalyPower);
		t2.beAttacked(t1_cavalyPower);
		
		System.out.println("t1_p:"+t1_cavalyPower+", t1_m:"+t1.getCavalrymen()+", t2_p:"+t2_cavalyPower+", t2_m:"+t2.getCavalrymen());
	}
}
