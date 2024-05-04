package Object;

public class Student {
	private String full_name;
	private String gender;
	private String birthday;
	private String address;
	private String nation;
	private String religion;
	private String father_name;
	private String father_job;
	private String mother_name;
	private String mother_job;
	private Integer class_id;
	private Integer school_year_id;
	
	public Student() {

	}

	public Student(String full_name, String gender, String birthday, String address, String nation, String religion,
			String father_name, String father_job, String mother_name, String mother_job, Integer class_id,
			Integer school_year_id) {
		this.full_name = full_name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.nation = nation;
		this.religion = religion;
		this.father_name = father_name;
		this.father_job = father_job;
		this.mother_name = mother_name;
		this.mother_job = mother_job;
		this.class_id = class_id;
		this.school_year_id = school_year_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getFather_job() {
		return father_job;
	}

	public void setFather_job(String father_job) {
		this.father_job = father_job;
	}

	public String getMother_name() {
		return mother_name;
	}

	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	public String getMother_job() {
		return mother_job;
	}

	public void setMother_job(String mother_job) {
		this.mother_job = mother_job;
	}

	public Integer getClass_id() {
		return class_id;
	}

	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}

	public Integer getSchool_year_id() {
		return school_year_id;
	}

	public void setSchool_year_id(Integer school_year_id) {
		this.school_year_id = school_year_id;
	}
}
