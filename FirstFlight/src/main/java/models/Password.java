package models;

public class Password {
	
	private static String pwd;
	
	public Password() {
		pwd = "admin";
	}

	public static String getPwd() {
		return pwd;
	}

	public static void setPwd(String pwd) {
		Password.pwd = pwd;
	}

}
