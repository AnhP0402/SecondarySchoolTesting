package Test.Student;

import java.lang.reflect.Method;
import java.sql.SQLException;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Common.CommonFunction;
import Common.VariableUtil;
import Common.FileUtil;
import Object.Student;
import io.restassured.response.Response;

public class EditStudent {
	static String token;
	static String tokenLecturer;
    static String testcaseName;
	
    static Class<?> clazz = EditStudent.class; // Lấy đối tượng Class của lớp hiện tại
    static String fileName = clazz.getSimpleName();
    static String packageName = clazz.getPackageName();
    static String folderPath = VariableUtil.RESULT_FOLDER + "/" + packageName;
    static String filePath = folderPath + "/" + fileName + ".txt";
	
	@BeforeClass
	public static void setUp() {
		token = CommonFunction.getTokenAdmin();
		tokenLecturer = CommonFunction.getTokenLecturer();
		
		FileUtil.createFolder(folderPath);
		FileUtil.createFile(filePath);
	}
	
	@BeforeMethod
	public void setUpTC(Method method) {
		testcaseName = method.getName();
	}
	
	@Test
	public void CNHS_01() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, VariableUtil.NULL_VALUE, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNHS_02() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, VariableUtil.EMPTY_VALUE, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNHS_03() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, VariableUtil.ENCODE_FULL_SPACE_VALUE, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNHS_04() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, VariableUtil.SPECIAL_CHARS_VALUE, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNHS_05() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, VariableUtil.ENCODE_SPECIAL_CHARS_VALUE, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNHS_06() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, VariableUtil.CONTAIN_SPACE_CHAR_VALUE, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNHS_07() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, VariableUtil.NOT_EXIST_VALUE, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNHS_08() throws SQLException {
		Student student = new Student(VariableUtil.NULL_VALUE, "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void CNHS_09() throws SQLException {
		Student student = new Student(VariableUtil.EMPTY_VALUE, "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_10() throws SQLException {
		Student student = new Student(VariableUtil.FULL_SPACE_VALUE, "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_11() throws SQLException {
		Student student = new Student(VariableUtil.NULL_VALUE, "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent2(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_12() throws SQLException {
		Student student = new Student("Bùi Minh Anh", VariableUtil.NULL_VALUE, "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void CNHS_13() throws SQLException {
		Student student = new Student("Bùi Minh Anh", VariableUtil.EMPTY_VALUE, "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_14() throws SQLException {
		Student student = new Student("Bùi Minh Anh", VariableUtil.FULL_SPACE_VALUE, "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_15() throws SQLException {
		Student student = new Student("Bùi Minh Anh", VariableUtil.NULL_VALUE, "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent2(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_16() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", VariableUtil.NULL_VALUE, "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void CNHS_17() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", VariableUtil.EMPTY_VALUE, "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_18() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", VariableUtil.FULL_SPACE_VALUE, "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_19() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", VariableUtil.NULL_VALUE, "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent2(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_20() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", VariableUtil.NULL_VALUE, "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void CNHS_21() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", VariableUtil.EMPTY_VALUE, "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_22() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", VariableUtil.FULL_SPACE_VALUE, "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_23() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", VariableUtil.NULL_VALUE, "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent2(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_24() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", VariableUtil.NULL_VALUE, "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void CNHS_25() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", VariableUtil.EMPTY_VALUE, "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_26() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", VariableUtil.FULL_SPACE_VALUE, "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_27() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", VariableUtil.NULL_VALUE, "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent2(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_28() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", VariableUtil.NULL_VALUE, "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void CNHS_29() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", VariableUtil.EMPTY_VALUE, "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_30() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", VariableUtil.FULL_SPACE_VALUE, "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_31() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", VariableUtil.NULL_VALUE, "Y tá", 1, 2);
		Response response = CommonFunction.editStudent2(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_32() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", VariableUtil.NULL_INTEGER, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void CNHS_33() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", VariableUtil.NULL_INTEGER, 2);
		Response response = CommonFunction.editStudent2(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_34() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", VariableUtil.NOT_EXIST_NUMBER, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_CLASS_MSG);
	}
	
	@Test
	public void CNHS_35() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, VariableUtil.NULL_INTEGER);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void CNHS_36() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, VariableUtil.NULL_INTEGER);
		Response response = CommonFunction.editStudent2(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_37() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, VariableUtil.NOT_EXIST_NUMBER);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_SCHOOL_YEAR_MSG);
	}
		
	@Test
	public void CNHS_38() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void CNHS_39() throws SQLException {
		Student student = null;
		Response response = CommonFunction.editStudent(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_40() throws SQLException {
		Student student = null;
		Response response = CommonFunction.editStudent2(token, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNHS_41() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(VariableUtil.INVALID_TOKEN, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void CNHS_42() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(VariableUtil.EXPIRED_TOKEN, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void CNHS_43() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.editStudent(tokenLecturer, "5", student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
}
