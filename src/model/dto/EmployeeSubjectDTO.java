package model.dto;

public class EmployeeSubjectDTO {
	private int emp_id;
	private int sub_id;
	private int empsub_rate;
	private String empsub_desc;
	private SubjectDTO subjectDTO;
	private int newSubject;
	
	
	public int getNewSubject() {
		return newSubject;
	}
	public void setNewSubject(int newSubject) {
		this.newSubject = newSubject;
	}
	public SubjectDTO getSubjectDTO() {
		return subjectDTO;
	}
	public void setSubjectDTO(SubjectDTO subjectDTO) {
		this.subjectDTO = subjectDTO;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public int getEmpsub_rate() {
		return empsub_rate;
	}
	public void setEmpsub_rate(int empsub_rate) {
		this.empsub_rate = empsub_rate;
	}
	public String getEmpsub_desc() {
		return empsub_desc;
	}
	public void setEmpsub_desc(String empsub_desc) {
		this.empsub_desc = empsub_desc;
	}
	
	
}
