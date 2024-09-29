package cn.edu.pzhu.pojo;

public class Num {
	private static int visitor = 0; //访问量
	private static int online = 0; //在线人数
	public static int getVisitor() {
		return visitor;
	}
	public static void setVisitor(int visitor) {
		Num.visitor = visitor;
	}
	public static int getOnline() {
		return online;
	}
	public static void setOnline(int online) {
		Num.online = online;
	}
	

}
