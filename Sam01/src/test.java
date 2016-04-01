import cmn.Grade;
import cmn.GradeManager;
import info.General;
import info.Troops;
import manager.BattleManager;

public class test {

	public static void main(String[] args) {
		
//		BattleManager battleMgr = new BattleManager();
//		battleMgr.battle(t1, t2);
		
		//testGrade();
		
		testBattle();
		
		//System.out.println(Math.round(999));
		//System.out.println((double)99*7/100);
		//System.out.println(Math.round((double)99*7/100));
	}
	
	public static void testBattle()
	{
		BattleManager battleManager = new BattleManager();
		
		General g1 = new General();
		g1.setBattleMain(Grade.M_SS);
		g1.setBattleExtra(Grade.M_N);
		g1.setLeadership(Grade.M_S);
		g1.setTacticsMain(Grade.M_B);
		
		General g2 = new General();
		g2.setBattleMain(Grade.M_A);
		g2.setBattleExtra(Grade.M_N);
		g2.setLeadership(Grade.M_A);
		g2.setTacticsMain(Grade.M_B);
		
		Troops t1 = new Troops();
		t1.setCommander(g1);
		t1.setCavarlryman(1000);
		
		Troops t2 = new Troops();
		t2.setCommander(g2);
		t2.setCavarlryman(2000);
		
		for(int i=0;i < 10;i++)
		{
			battleManager.battle(t1, t2);
		}
	}
	
	
	public static void testGrade()
	{
		General g1 = new General();
		GradeManager gradeMgr = new GradeManager();
		
//		g1.setBattleMain(Grade.M_SSS);
//		g1.setBattleExtra(Grade.E_N);
//		gradeMgr.checkAvgPower(g1, 300);
//		
//		g1.setBattleMain(Grade.M_SSS);
//		g1.setBattleExtra(Grade.E_P);
//		gradeMgr.checkAvgPower(g1, 300);
//		
//		g1.setBattleMain(Grade.M_SSS);
//		g1.setBattleExtra(Grade.E_PP);
//		gradeMgr.checkAvgPower(g1, 300);
		
		g1.setBattleMain(Grade.M_S);
		g1.setBattleExtra(Grade.E_P); 
		gradeMgr.checkAvgPower(g1, 500);
	}
}
