package model.dto;


import configuration.Validation;


public class ExperienceDTO{
	private int id;
	private String place;
	private String postion;
	private String start;
	private String end;
	private int type;
	private String skill;
	private String desc;
	private int empid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPostion() {
		return postion;
	}
	public void setPostion(String postion)throws Exception {
		if(Validation.isTextOnly(postion)){
			this.postion = postion;
		}else throw new Exception("Invalid Position!!!");
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start)throws Exception {
		if(Validation.isTextOnly(start)){
			this.start = start;
		}else throw new Exception("Invalid Start Date!!!");
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
}

