package Test.Lecturer;

import java.lang.reflect.Method;
import java.sql.SQLException;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Common.CommonFunction;
import Common.VariableUtil;
import Common.FileUtil;
import Object.Lecturer;
import io.restassured.response.Response;

public class CreateLecturer {
	static String token;
	static String tokenLecturer;
    static String testcaseName;
	
    static Class<?> clazz = CreateLecturer.class; // Lấy đối tượng Class của lớp hiện tại
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
	public void TGV_01() throws SQLException {
		Lecturer lecturer = new Lecturer(VariableUtil.NULL_VALUE, "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void TGV_02() throws SQLException {
		Lecturer lecturer = new Lecturer(VariableUtil.EMPTY_VALUE, "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_03() throws SQLException {
		Lecturer lecturer = new Lecturer(VariableUtil.FULL_SPACE_VALUE, "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_04() throws SQLException {
		Lecturer lecturer = new Lecturer(VariableUtil.NULL_VALUE, "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer2(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_05() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", VariableUtil.NULL_VALUE, "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void TGV_06() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", VariableUtil.EMPTY_VALUE, "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_07() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", VariableUtil.FULL_SPACE_VALUE, "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_08() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", VariableUtil.NULL_VALUE, "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer2(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_09() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", VariableUtil.NULL_VALUE, "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}

	@Test
	public void TGV_10() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", VariableUtil.EMPTY_VALUE, "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void TGV_11() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", VariableUtil.FULL_SPACE_VALUE, "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void TGV_12() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", VariableUtil.NULL_VALUE, "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer2(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void TGV_13() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", VariableUtil.NULL_VALUE, "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}

	@Test
	public void TGV_14() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", VariableUtil.EMPTY_VALUE, "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void TGV_15() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", VariableUtil.FULL_SPACE_VALUE, "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void TGV_16() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", VariableUtil.NULL_VALUE, "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer2(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void TGV_17() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", VariableUtil.NULL_VALUE, "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void TGV_18() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", VariableUtil.EMPTY_VALUE, "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_19() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", VariableUtil.FULL_SPACE_VALUE, "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_20() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", VariableUtil.NULL_VALUE, "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer2(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_21() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", VariableUtil.NULL_VALUE, 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void TGV_22() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", VariableUtil.EMPTY_VALUE, 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_23() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", VariableUtil.FULL_SPACE_VALUE, 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_24() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", VariableUtil.NULL_VALUE, 1, "Abcd1234");
		Response response = CommonFunction.createLecturer2(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_25() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", VariableUtil.NULL_INTEGER, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void TGV_26() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", VariableUtil.NULL_INTEGER, "Abcd1234");
		Response response = CommonFunction.createLecturer2(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_27() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", VariableUtil.NOT_EXIST_NUMBER, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_28() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, VariableUtil.NULL_VALUE);
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void TGV_29() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, VariableUtil.EMPTY_VALUE);
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_30() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, VariableUtil.FULL_SPACE_VALUE);
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_31() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, VariableUtil.NULL_VALUE);
		Response response = CommonFunction.createLecturer2(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_32() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void TGV_33() throws SQLException {
		Lecturer lecturer = null;
		Response response = CommonFunction.createLecturer(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_34() throws SQLException {
		Lecturer lecturer = null;
		Response response = CommonFunction.createLecturer2(token, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGV_35() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(VariableUtil.INVALID_TOKEN, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void TGV_36() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(VariableUtil.EXPIRED_TOKEN, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void TGV_37() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.createLecturer(tokenLecturer, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
}
