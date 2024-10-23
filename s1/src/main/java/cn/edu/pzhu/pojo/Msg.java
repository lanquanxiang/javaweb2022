package cn.edu.pzhu.pojo;

public class Msg {
	private boolean success;
	private String message;
	public Msg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Msg(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
