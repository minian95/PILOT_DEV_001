package cmn;

import info.General;

public class GradeManager {
	
	public static int getBasePower(General general)
	{
		Grade grade = general.getBattleMain();
		int basePower = 0;
		
		switch(grade)
		{
			case M_SSS:
				basePower = 970;
				break;
			case M_SS:
				basePower = 940;
				break;
			case M_S:
				basePower = 900;
				break;
			case M_AAA:
				basePower = 870;
				break;
			case M_AA:
				basePower = 840;
				break;
			case M_A:
				basePower = 800;
				break;
			case M_BBB:
				basePower = 770;
				break;
			case M_BB:
				basePower = 740;
				break;
			case M_B:
				basePower = 700;
				break;
			case M_CCC:
				basePower = 670;
				break;
			case M_CC:
				basePower = 640;
				break;
			case M_C:
				basePower = 600;
				break;
			case M_DDD:
				basePower = 570;
				break;
			case M_DD:
				basePower = 540;
				break;
			case M_D:
				basePower = 500;
				break;
			case M_N:
				basePower = 0;
				break;
			default:
				basePower = 0;
				break;	
		}
		
		return basePower;
	}
	
	public static int getExtraPower(General general)
	{
		boolean minusFlag = false;
		int randomMin = 0;
		int randomMax = 0;
		
		Grade grade = general.getBattleExtra();
		int randomTry = 0;
		switch(grade)
		{
			case E_PPP:
				randomTry = 3;
				randomMin = 0;
				randomMax = 40;
				break;
			case E_PP:
				randomTry = 2;
				randomMin = 0;
				randomMax = 30;
				break;
			case E_P:
				randomTry = 1;
				randomMin = 0;
				randomMax = 20;
				break;
			case E_MMM:
				randomTry = 3;
				randomMin = 0;
				randomMax = 40;
				minusFlag = true;
				break;
			case E_MM:
				randomTry = 2;
				randomMin = 0;
				randomMax = 30;
				minusFlag = true;
				break;
			case E_M:
				randomTry = 1;
				randomMin = 0;
				randomMax = 20;
				minusFlag = true;
				break;
			case E_N:
				randomTry = 0;
				break;
			default:
				randomTry = 0;
				break;
		}

		int extraPower = 0;
		int temp = 0;
		// �������� �õ��Ҷ����� �� ���� ������ ��ü
		for (int i=0;i < randomTry*2;i++)
		{
			//temp = randomRange(0, 30);
			temp = randomRange(randomMin, randomMax);
			if (temp > extraPower)
			{
				extraPower = temp;
			}
		}
		
		if (minusFlag)
			extraPower = -extraPower;
		
		return extraPower;
	}
	
	public static int getPowerValue(General general)
	{
		// �ֵ�� �Ŀ�
		int basePower = getBasePower(general); // ��޺� �⺻ �Ŀ�
		int basePowerBy10 = basePower/10%10*10;	// �⺻�Ŀ� 10������ ���۰�
		int randomPower = randomRange(basePowerBy10, 100); // ���� �߰� �Ŀ�, 10���� ���۰� - 100 ���� ������
		
		// �ε�� �Ŀ�
		int extraPower = getExtraPower(general);
		
		// ���� �߰��ջ�
		int addPower = randomPower + extraPower;
		//System.out.println("b:"+basePower+", by:"+basePowerBy10+", r:"+randomPower+", e:"+extraPower);

		if (addPower > 100)
		{
			// �߰����� ���� ����� �ʰ��� ���, ����� max������ ���� 
			addPower = 100;
		}
		else if(addPower < 0)
		{
			// �߰����� '-'���� ���, 0 ���� ���� 
			addPower = 0;
		}
		
		return (basePower-basePowerBy10) + addPower;
	}
	
	public static int randomRange(int n1, int n2) 
	{
		return (int)(Math.random() * (n2 - n1 + 1)) + n1;
	}
	
	public static void checkAvgPower(General general, int count)
	{
		int total = 0;
		int power = 0;
		for (int i=0;i < count;i++)
		{
			power = getPowerValue(general);
			System.out.println(power);
			
			total += power;
		}
		System.out.println(total/count);
	}
}
