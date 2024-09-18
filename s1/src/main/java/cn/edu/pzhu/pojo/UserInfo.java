package cn.edu.pzhu.pojo;

public class UserInfo {
	private String username;
	private String email;
	private Integer gender;
	private String type;
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(String username, String email, Integer gender, String type) {
		super();
		this.username = username;
		this.email = email;
		this.gender = gender;
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", email=" + email + ", gender=" + gender + ", type=" + type + "]";
	}
	
	
	

}
