package cmn;

import info.General;

public class GradeManager {
	
	public static int getBasePower(General general)
	{
		GradeMain gradeMain = general.getBattleMain();
		int basePower = 0;
		
		switch(gradeMain)
		{
			case SSS:
				basePower = 970;
				break;
			case SS:
				basePower = 940;
				break;
			case S:
				basePower = 900;
				break;
			case AAA:
				basePower = 870;
				break;
			case AA:
				basePower = 840;
				break;
			case A:
				basePower = 800;
				break;
			case BBB:
				basePower = 770;
				break;
			case BB:
				basePower = 740;
				break;
			case B:
				basePower = 700;
				break;
			case CCC:
				basePower = 670;
				break;
			case CC:
				basePower = 640;
				break;
			case C:
				basePower = 600;
				break;
			case DDD:
				basePower = 570;
				break;
			case DD:
				basePower = 540;
				break;
			case D:
				basePower = 500;
				break;
			case N:
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
		
		GradeExtra gradeExtra = general.getBattleExtra();
		int randomTry = 0;
		switch(gradeExtra)
		{
			case PPP:
				randomTry = 3;
				randomMin = 0;
				randomMax = 40;
				break;
			case PP:
				randomTry = 2;
				randomMin = 0;
				randomMax = 30;
				break;
			case P:
				randomTry = 1;
				randomMin = 0;
				randomMax = 20;
				break;
			case MMM:
				randomTry = 3;
				randomMin = 0;
				randomMax = 40;
				minusFlag = true;
				break;
			case MM:
				randomTry = 2;
				randomMin = 0;
				randomMax = 30;
				minusFlag = true;
				break;
			case M:
				randomTry = 1;
				randomMin = 0;
				randomMax = 20;
				minusFlag = true;
				break;
			case N:
				randomTry = 0;
				break;
			default:
				randomTry = 0;
				break;
		}

		int extraPower = 0;
		int temp = 0;
		// 랜덤값을 시도할때마다 더 높은 값으로 교체
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
	
	public static int getPower(General general)
	{
		// 주등급 파워
		int basePower = getBasePower(general); // 등급별 기본 파워
		int basePowerBy10 = basePower/10%10*10;	// 기본파워 10단위값 시작값
		int randomPower = randomRange(basePowerBy10, 100); // 랜덤 추가 파워, 10단위 시작값 - 100 사이 랜덤값
		
		// 부등급 파워
		int extraPower = getExtraPower(general);
		
		// 최종 추가합산
		int addPower = randomPower + extraPower;
		//System.out.println("b:"+basePower+", by:"+basePowerBy10+", r:"+randomPower+", e:"+extraPower);

		if (addPower > 100)
		{
			// 추가값이 현재 등급을 초과할 경우, 현등급 max값으로 설정 
			addPower = 100;
		}
		else if(addPower < 0)
		{
			// 추가값이 '-'값인 경우, 0 으로 설정 
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
			power = getPower(general);
			System.out.println(power);
			
			total += power;
		}
		System.out.println(total/count);
	}
}
