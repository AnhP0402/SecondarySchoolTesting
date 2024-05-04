package Object;

public class Lecturer {
	private String full_name;
	private String phone;
	private String email;
	private String address;
	private String position;
	private String specialize;
	private Integer department_id;
	private String password;
	
	public Lecturer() {

	}

	public Lecturer(String full_name, String phone, String email, String address, String position, String specialize,
			int department_id, String password) {
		this.full_name = full_name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.position = position;
		this.specialize = specialize;
		this.department_id = department_id;
		this.password = password;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSpecialize() {
		return specialize;
	}

	public void setSpecialize(String specialize) {
		this.specialize = specialize;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
