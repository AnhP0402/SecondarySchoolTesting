package Object;

public class ClassSubject {
	private Integer class_id;
	private Integer subject_id;
	private Integer school_year_id;
	private Integer user_id;
	private Boolean can_teach_section_1;
	private Boolean can_teach_section_2;
	
	public ClassSubject() {

	}

	public ClassSubject(Integer class_id, Integer subject_id, Integer school_year_id, Integer user_id,
			Boolean can_teach_section_1, Boolean can_teach_section_2) {
		this.class_id = class_id;
		this.subject_id = subject_id;
		this.school_year_id = school_year_id;
		this.user_id = user_id;
		this.can_teach_section_1 = can_teach_section_1;
		this.can_teach_section_2 = can_teach_section_2;
	}

	public Integer getClass_id() {
		return class_id;
	}

	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}

	public Integer getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Integer subject_id) {
		this.subject_id = subject_id;
	}

	public Integer getSchool_year_id() {
		return school_year_id;
	}

	public void setSchool_year_id(Integer school_year_id) {
		this.school_year_id = school_year_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Boolean getCan_teach_section_1() {
		return can_teach_section_1;
	}

	public void setCan_teach_section_1(Boolean can_teach_section_1) {
		this.can_teach_section_1 = can_teach_section_1;
	}

	public Boolean getCan_teach_section_2() {
		return can_teach_section_2;
	}

	public void setCan_teach_section_2(Boolean can_teach_section_2) {
		this.can_teach_section_2 = can_teach_section_2;
	}
}
