package cmn;

public class Grade {
	public static String M_S = "S";
	public static String M_A = "A";
	public static String M_B = "B";
	public static String M_C = "C";
	public static String M_D = "D";
	
	public static String E_P = "D";

	public static String N = "N";
	
	private String main1 = "";	
	private String main2 = "";
	private String main3 = "";
	
	private String extra1 = "";
	private String extra2 = "";
	private String extra3 = "";
	
	public Grade(String main1, String main2, String main3, String extra1, String extra2, String extra3)
	{
		this.main1 = main1;
		this.main2 = main2;
		this.main3 = main3;
		this.extra1 = extra1;
		this.extra2 = extra2;
		this.extra3 = extra3;
	}
	
	
}
