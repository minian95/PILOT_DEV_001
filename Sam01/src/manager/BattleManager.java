package manager;

import cmn.GradeManager;
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
		t1.getCavarlyPower();
		
		// ȥ���� ����  => ���� ������ �񱳿� ���� ��������������
		t1.addConfusionRate(t2);
		t2.addConfusionRate(t1);
		
		//System.out.println("t1:" + t1.getConfusionRate() + ", t2:" + t2.getConfusionRate());
				
		int t1_BattlePower = t1.getCavarlyPower();
		int t2_BattlePower = t2.getCavarlyPower();
		
		t1.beAttacked(t2_BattlePower);
		t2.beAttacked(t1_BattlePower);
		
		System.out.println("t1_p:"+t1_BattlePower+", t1_m:"+t1.getCavarlryman()+", t2_p:"+t2_BattlePower+", t2_m:"+t2.getCavarlryman());
	}
}
