package cn.edu.pzhu.pojo;

import java.util.Date;

public class FileMsg {
	private Integer fileid;
	private String username;
	private String filename;
	private String classification;
	private String filepath;
	private Date relesaedate;
	private Double rating; 
	private String description;
	public FileMsg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileMsg(Integer fileid, String username, String filename, String classification, String filepath,
			Date relesaedate, Double rating, String description) {
		super();
		this.fileid = fileid;
		this.username = username;
		this.filename = filename;
		this.classification = classification;
		this.filepath = filepath;
		this.relesaedate = relesaedate;
		this.rating = rating;
		this.description = description;
	}
	public Integer getFileid() {
		return fileid;
	}
	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public Date getRelesaedate() {
		return relesaedate;
	}
	public void setRelesaedate(Date relesaedate) {
		this.relesaedate = relesaedate;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "FlieMsg [fileid=" + fileid + ", username=" + username + ", filename=" + filename + ", classification="
				+ classification + ", filepath=" + filepath + ", relesaedate=" + relesaedate + ", rating=" + rating
				+ ", description=" + description + "]";
	}
	
	

}
