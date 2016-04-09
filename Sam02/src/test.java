import cmn.Grade;
import info.General;

public class test {

	public static void main(String[] args) {
		System.out.println((int)Math.round((double)334*30/100));
		
	}
	
	public static void testBattle()
	{
		General g1 = new General();
		g1.setName("G1");
		g1.setBattlePower(new Grade(Grade.M_A, Grade.N, Grade.N, Grade.N, Grade.N, Grade.N));
		g1.setTacticPower(new Grade(Grade.M_C, Grade.N, Grade.N, Grade.N, Grade.N, Grade.N));
		g1.setLeadership(new Grade(Grade.M_B, Grade.N, Grade.N, Grade.N, Grade.N, Grade.N));
		
		General g2 = new General();
		g2.setName("G2");
		g2.setBattlePower(new Grade(Grade.M_C, Grade.N, Grade.N, Grade.N, Grade.N, Grade.N));
		g2.setTacticPower(new Grade(Grade.M_C, Grade.N, Grade.N, Grade.N, Grade.N, Grade.N));
		g2.setLeadership(new Grade(Grade.M_B, Grade.N, Grade.N, Grade.N, Grade.N, Grade.N));

//		Troops t1 = new Troops();
//		t1.setCommander(g1);
//		t1.setCavalrymen(1000);
//		
//		Troops t2 = new Troops();
//		t2.setCommander(g2);
//		t2.setCavalrymen(2000);
//		
//		for(int i=0;i < 20;i++)
//		{
//			battleManager.battle(t1, t2);
//		}
	}
	
	
	public static void testGrade()
	{
//		General g1 = new General();
//		GradeManager gradeMgr = new GradeManager();
//		
////		g1.setBattleMain(Grade.SSS);
////		g1.setBattleExtra(Grade.N);
////		gradeMgr.checkAvgPower(g1, 300);
////		
////		g1.setBattleMain(Grade.SSS);
////		g1.setBattleExtra(Grade.P);
////		gradeMgr.checkAvgPower(g1, 300);
////		
////		g1.setBattleMain(Grade.SSS);
////		g1.setBattleExtra(Grade.PP);
////		gradeMgr.checkAvgPower(g1, 300);
//		
//		g1.setBattleMain(GradeMain.S);
//		g1.setBattleExtra(GradeExtra.P); 
//		gradeMgr.checkAvgPower(g1, 500);
	}
}
