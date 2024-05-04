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

public class CreateStudent {
	static String token;
	static String tokenLecturer;
    static String testcaseName;
	
    static Class<?> clazz = CreateStudent.class; // Lấy đối tượng Class của lớp hiện tại
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
	public void THS_01() throws SQLException {
		Student student = new Student(VariableUtil.NULL_VALUE, "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void THS_02() throws SQLException {
		Student student = new Student(VariableUtil.EMPTY_VALUE, "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_03() throws SQLException {
		Student student = new Student(VariableUtil.FULL_SPACE_VALUE, "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_04() throws SQLException {
		Student student = new Student(VariableUtil.NULL_VALUE, "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent2(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_05() throws SQLException {
		Student student = new Student("Bùi Minh Anh", VariableUtil.NULL_VALUE, "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void THS_06() throws SQLException {
		Student student = new Student("Bùi Minh Anh", VariableUtil.EMPTY_VALUE, "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_07() throws SQLException {
		Student student = new Student("Bùi Minh Anh", VariableUtil.FULL_SPACE_VALUE, "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_08() throws SQLException {
		Student student = new Student("Bùi Minh Anh", VariableUtil.NULL_VALUE, "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent2(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_09() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", VariableUtil.NULL_VALUE, "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void THS_10() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", VariableUtil.EMPTY_VALUE, "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_11() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", VariableUtil.FULL_SPACE_VALUE, "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_12() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", VariableUtil.NULL_VALUE, "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent2(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_13() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", VariableUtil.NULL_VALUE, "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void THS_14() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", VariableUtil.EMPTY_VALUE, "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_15() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", VariableUtil.FULL_SPACE_VALUE, "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_16() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", VariableUtil.NULL_VALUE, "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent2(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_17() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", VariableUtil.NULL_VALUE, "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void THS_18() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", VariableUtil.EMPTY_VALUE, "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_19() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", VariableUtil.FULL_SPACE_VALUE, "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_20() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", VariableUtil.NULL_VALUE, "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent2(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_21() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", VariableUtil.NULL_VALUE, "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void THS_22() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", VariableUtil.EMPTY_VALUE, "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_23() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", VariableUtil.FULL_SPACE_VALUE, "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_24() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", VariableUtil.NULL_VALUE, "Y tá", 1, 2);
		Response response = CommonFunction.createStudent2(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_25() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", VariableUtil.NULL_INTEGER, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void THS_26() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", VariableUtil.NULL_INTEGER, 2);
		Response response = CommonFunction.createStudent2(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_27() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", VariableUtil.NOT_EXIST_NUMBER, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_CLASS_MSG);
	}
	
	@Test
	public void THS_28() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, VariableUtil.NULL_INTEGER);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void THS_29() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, VariableUtil.NULL_INTEGER);
		Response response = CommonFunction.createStudent2(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_30() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, VariableUtil.NOT_EXIST_NUMBER);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_SCHOOL_YEAR_MSG);
	}
		
	@Test
	public void THS_31() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void THS_32() throws SQLException {
		Student student = null;
		Response response = CommonFunction.createStudent(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_33() throws SQLException {
		Student student = null;
		Response response = CommonFunction.createStudent2(token, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void THS_34() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(VariableUtil.INVALID_TOKEN, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void THS_35() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(VariableUtil.EXPIRED_TOKEN, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void THS_36() throws SQLException {
		Student student = new Student("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		Response response = CommonFunction.createStudent(tokenLecturer, student);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
}
