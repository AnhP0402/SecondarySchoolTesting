package Test.Lecturer;

import java.lang.reflect.Method;
import java.sql.SQLException;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Common.CommonFunction;
import Common.DBUtil;
import Common.VariableUtil;
import Common.FileUtil;
import Object.Lecturer;
import io.restassured.response.Response;

public class EditLecturer {
	static String token;
	static String tokenLecturer;
    static String testcaseName;
    static String lecturerID;
	
    static Class<?> clazz = EditLecturer.class; // Lấy đối tượng Class của lớp hiện tại
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
	public void setUpTC(Method method) throws SQLException {
		testcaseName = method.getName();
		lecturerID = DBUtil.getLecturerID();
	}
	
	@Test
	public void CNGV_01() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, VariableUtil.NULL_VALUE, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNGV_02() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, VariableUtil.EMPTY_VALUE, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNGV_03() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, VariableUtil.ENCODE_FULL_SPACE_VALUE, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNGV_04() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, VariableUtil.SPECIAL_CHARS_VALUE, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNGV_05() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, VariableUtil.ENCODE_SPECIAL_CHARS_VALUE, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNGV_06() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, VariableUtil.CONTAIN_SPACE_CHAR_VALUE, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNGV_07() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, VariableUtil.NOT_EXIST_VALUE, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNGV_08() throws SQLException {
		Lecturer lecturer = new Lecturer(VariableUtil.NULL_VALUE, "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void CNGV_09() throws SQLException {
		Lecturer lecturer = new Lecturer(VariableUtil.EMPTY_VALUE, "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_10() throws SQLException {
		Lecturer lecturer = new Lecturer(VariableUtil.FULL_SPACE_VALUE, "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_11() throws SQLException {
		Lecturer lecturer = new Lecturer(VariableUtil.NULL_VALUE, "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer2(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_12() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", VariableUtil.NULL_VALUE, "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void CNGV_13() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", VariableUtil.EMPTY_VALUE, "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_14() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", VariableUtil.FULL_SPACE_VALUE, "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_15() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", VariableUtil.NULL_VALUE, "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer2(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_16() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", VariableUtil.NULL_VALUE, "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}

	@Test
	public void CNGV_17() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", VariableUtil.EMPTY_VALUE, "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void CNGV_18() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", VariableUtil.FULL_SPACE_VALUE, "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void CNGV_19() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", VariableUtil.NULL_VALUE, "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer2(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void CNGV_20() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", VariableUtil.NULL_VALUE, "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}

	@Test
	public void CNGV_21() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", VariableUtil.EMPTY_VALUE, "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void CNGV_22() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", VariableUtil.FULL_SPACE_VALUE, "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void CNGV_23() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", VariableUtil.NULL_VALUE, "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer2(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void CNGV_24() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", VariableUtil.NULL_VALUE, "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void CNGV_25() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", VariableUtil.EMPTY_VALUE, "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_26() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", VariableUtil.FULL_SPACE_VALUE, "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_27() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", VariableUtil.NULL_VALUE, "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer2(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_28() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", VariableUtil.NULL_VALUE, 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void CNGV_29() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", VariableUtil.EMPTY_VALUE, 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_30() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", VariableUtil.FULL_SPACE_VALUE, 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_31() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", VariableUtil.NULL_VALUE, 1, "Abcd1234");
		Response response = CommonFunction.editLecturer2(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_32() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", VariableUtil.NULL_INTEGER, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void CNGV_33() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", VariableUtil.NULL_INTEGER, "Abcd1234");
		Response response = CommonFunction.editLecturer2(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_34() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", VariableUtil.NOT_EXIST_NUMBER, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_35() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, VariableUtil.NULL_VALUE);
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void CNGV_36() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, VariableUtil.EMPTY_VALUE);
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_37() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, VariableUtil.FULL_SPACE_VALUE);
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_38() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, VariableUtil.NULL_VALUE);
		Response response = CommonFunction.editLecturer2(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_39() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void CNGV_40() throws SQLException {
		Lecturer lecturer = null;
		Response response = CommonFunction.editLecturer(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_41() throws SQLException {
		Lecturer lecturer = null;
		Response response = CommonFunction.editLecturer2(token, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGV_42() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(VariableUtil.INVALID_TOKEN, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void CNGV_43() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(VariableUtil.EXPIRED_TOKEN, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void CNGV_44() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(tokenLecturer, lecturerID, lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}

	@Test
	public void CNGV_45() throws SQLException {
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		Response response = CommonFunction.editLecturer(tokenLecturer, "6", lecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
}
