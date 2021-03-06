import cmn.GradeExtra;
import cmn.GradeMain;
import cmn.GradeManager;
import info.General;
import info.Troops;
import manager.BattleManager;

public class test {

	public static void main(String[] args) {
		
//		BattleManager battleMgr = new BattleManager();
//		battleMgr.battle(t1, t2);
		// ....
		//testGrade();
		
		testBattle();
		
		//System.out.println(Math.round(999));
		//System.out.println((double)99*7/100);
		//System.out.println((int)Math.round((double)1000*30/100));
	}
	
	public static void testBattle()
	{
		BattleManager battleManager = new BattleManager();
		
		General g1 = new General();
		g1.setName("G1");
		g1.setBattleMain(GradeMain.B);
		g1.setBattleExtra(GradeExtra.N);
		g1.setLeadershipMain(GradeMain.S);
		g1.setTacticsMain(GradeMain.B);
		
		General g2 = new General();
		g2.setName("G2");
		g2.setBattleMain(GradeMain.D);
		g2.setBattleExtra(GradeExtra.N);
		g2.setLeadershipMain(GradeMain.A);
		g2.setTacticsMain(GradeMain.B);
		
		Troops t1 = new Troops();
		t1.setCommander(g1);
		t1.setCavalrymen(1000);
		
		Troops t2 = new Troops();
		t2.setCommander(g2);
		t2.setCavalrymen(2000);
		
		for(int i=0;i < 20;i++)
		{
			battleManager.battle(t1, t2);
		}
	}
	
	
	public static void testGrade()
	{
		General g1 = new General();
		GradeManager gradeMgr = new GradeManager();
		
//		g1.setBattleMain(Grade.SSS);
//		g1.setBattleExtra(Grade.N);
//		gradeMgr.checkAvgPower(g1, 300);
//		
//		g1.setBattleMain(Grade.SSS);
//		g1.setBattleExtra(Grade.P);
//		gradeMgr.checkAvgPower(g1, 300);
//		
//		g1.setBattleMain(Grade.SSS);
//		g1.setBattleExtra(Grade.PP);
//		gradeMgr.checkAvgPower(g1, 300);
		
		g1.setBattleMain(GradeMain.S);
		g1.setBattleExtra(GradeExtra.P); 
		gradeMgr.checkAvgPower(g1, 500);
	}
}
