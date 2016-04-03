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
		// 특정회수 전투후는 승패 결정, 진격,후퇴
		// 기병 야전용, 보병, 궁병에 강
		// 창병 공성, 농성용
		// 궁병 야전및 공성 농성시 피해없는 공격력, 선공 및 적 혼란도 증가, 보병, 기병이 없으면 피해가 심각
		// 야전에서 보병 궁병은 기병에 혼란도 크게 증가
		// 기병 유지비 많이 듬
		// 전투 우선순서 : 기병-기병, 기병-보병, 기병-궁병, 보병-궁병 
		t1.getCavalyPower();
		
		// 혼란도 적용  => 변경 전투력 비교에 따른 전투참여율적용
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
