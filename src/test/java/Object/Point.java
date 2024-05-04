package Object;

public class Point {
	private Integer student_id;
	private Integer class_subject_id;
	private Double exam_quick;
	private Double exam_15_no_1;
	private Double exam_15_no_2;
	private Double exam_15_no_3;
	private Double exam_15_no_4;
	private Double exam_45_no_1;
	private Double exam_45_no_2;
	private Double exam_finally;
	private Boolean is_section_1;
	private Boolean is_section_2;
	
	public Point() {

	}

	public Point(Integer student_id, Integer class_subject_id, Double exam_quick, Double exam_15_no_1,
			Double exam_15_no_2, Double exam_15_no_3, Double exam_15_no_4, Double exam_45_no_1, Double exam_45_no_2,
			Double exam_finally, Boolean is_section_1, Boolean is_section_2) {
		this.student_id = student_id;
		this.class_subject_id = class_subject_id;
		this.exam_quick = exam_quick;
		this.exam_15_no_1 = exam_15_no_1;
		this.exam_15_no_2 = exam_15_no_2;
		this.exam_15_no_3 = exam_15_no_3;
		this.exam_15_no_4 = exam_15_no_4;
		this.exam_45_no_1 = exam_45_no_1;
		this.exam_45_no_2 = exam_45_no_2;
		this.exam_finally = exam_finally;
		this.is_section_1 = is_section_1;
		this.is_section_2 = is_section_2;
	}

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public Integer getClass_subject_id() {
		return class_subject_id;
	}

	public void setClass_subject_id(Integer class_subject_id) {
		this.class_subject_id = class_subject_id;
	}

	public Double getExam_quick() {
		return exam_quick;
	}

	public void setExam_quick(Double exam_quick) {
		this.exam_quick = exam_quick;
	}

	public Double getExam_15_no_1() {
		return exam_15_no_1;
	}

	public void setExam_15_no_1(Double exam_15_no_1) {
		this.exam_15_no_1 = exam_15_no_1;
	}

	public Double getExam_15_no_2() {
		return exam_15_no_2;
	}

	public void setExam_15_no_2(Double exam_15_no_2) {
		this.exam_15_no_2 = exam_15_no_2;
	}

	public Double getExam_15_no_3() {
		return exam_15_no_3;
	}

	public void setExam_15_no_3(Double exam_15_no_3) {
		this.exam_15_no_3 = exam_15_no_3;
	}

	public Double getExam_15_no_4() {
		return exam_15_no_4;
	}

	public void setExam_15_no_4(Double exam_15_no_4) {
		this.exam_15_no_4 = exam_15_no_4;
	}

	public Double getExam_45_no_1() {
		return exam_45_no_1;
	}

	public void setExam_45_no_1(Double exam_45_no_1) {
		this.exam_45_no_1 = exam_45_no_1;
	}

	public Double getExam_45_no_2() {
		return exam_45_no_2;
	}

	public void setExam_45_no_2(Double exam_45_no_2) {
		this.exam_45_no_2 = exam_45_no_2;
	}

	public Double getExam_finally() {
		return exam_finally;
	}

	public void setExam_finally(Double exam_finally) {
		this.exam_finally = exam_finally;
	}

	public Boolean getIs_section_1() {
		return is_section_1;
	}

	public void setIs_section_1(Boolean is_section_1) {
		this.is_section_1 = is_section_1;
	}

	public Boolean getIs_section_2() {
		return is_section_2;
	}

	public void setIs_section_2(Boolean is_section_2) {
		this.is_section_2 = is_section_2;
	}
}
