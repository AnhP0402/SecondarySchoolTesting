package Test.ClassSubject;

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
import Object.ClassSubject;
import Object.Lecturer;
import io.restassured.response.Response;

public class CreateClassSubject {
	static String token;
	static String tokenLecturer;
    static String testcaseName;
    static int lecturerID;
	
    static Class<?> clazz = CreateClassSubject.class; // Lấy đối tượng Class của lớp hiện tại
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
		Lecturer lecturer = new Lecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		CommonFunction.createLecturer(token, lecturer);
		lecturerID = Integer.valueOf(DBUtil.getLecturerID2());
		DBUtil.deleteClassSubject(1, 1, 1, lecturerID);
	}
	
	@Test
	public void TGD_01() throws SQLException {
		ClassSubject classSubject = new ClassSubject(VariableUtil.NULL_INTEGER, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.createClassSubject(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.CLASS_NOT_EXIST_MSG);
	}

	@Test
	public void TGD_02() throws SQLException {
		ClassSubject classSubject = new ClassSubject(VariableUtil.NULL_INTEGER, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.createClassSubject2(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.CLASS_NOT_EXIST_MSG);
	}
	
	@Test
	public void TGD_03() throws SQLException {
		ClassSubject classSubject = new ClassSubject(VariableUtil.NOT_EXIST_NUMBER, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.createClassSubject(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.CLASS_NOT_EXIST_MSG);
	}
	
	@Test
	public void TGD_04() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, VariableUtil.NULL_INTEGER, 1, lecturerID, false, true);
		Response response = CommonFunction.createClassSubject(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.SUBJECT_NOT_EXIST_MSG);
	}

	@Test
	public void TGD_05() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, VariableUtil.NULL_INTEGER, 1, lecturerID, false, true);
		Response response = CommonFunction.createClassSubject2(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.SUBJECT_NOT_EXIST_MSG);
	}
	
	@Test
	public void TGD_06() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, VariableUtil.NOT_EXIST_NUMBER, 1, lecturerID, false, true);
		Response response = CommonFunction.createClassSubject(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.SUBJECT_NOT_EXIST_MSG);
	}
	
	@Test
	public void TGD_07() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, VariableUtil.NULL_INTEGER, lecturerID, false, true);
		Response response = CommonFunction.createClassSubject(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.SCHOOL_YEAR_NOT_EXIST_MSG);
	}

	@Test
	public void TGD_08() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, VariableUtil.NULL_INTEGER, lecturerID, false, true);
		Response response = CommonFunction.createClassSubject2(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.SCHOOL_YEAR_NOT_EXIST_MSG);
	}
	
	@Test
	public void TGD_09() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, VariableUtil.NOT_EXIST_NUMBER, lecturerID, false, true);
		Response response = CommonFunction.createClassSubject(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.SCHOOL_YEAR_NOT_EXIST_MSG);
	}
	
	@Test
	public void TGD_10() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, VariableUtil.NULL_INTEGER, false, true);
		Response response = CommonFunction.createClassSubject(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.TEACHER_NOT_EXIST_MSG);
	}

	@Test
	public void TGD_11() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, VariableUtil.NULL_INTEGER, false, true);
		Response response = CommonFunction.createClassSubject2(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.TEACHER_NOT_EXIST_MSG);
	}
	
	@Test
	public void TGD_12() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, VariableUtil.NOT_EXIST_NUMBER, false, true);
		Response response = CommonFunction.createClassSubject(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.TEACHER_NOT_EXIST_MSG);
	}
	
	@Test
	public void TGD_13() throws SQLException {
		DBUtil.insertClassSubject(1, 1, 1, lecturerID, false, true);
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.createClassSubject(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.CLASS_SUBJECT_EXIST_MSG);
	}
	
	@Test
	public void TGD_14() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, VariableUtil.NULL_BOOLEAN, true);
		Response response = CommonFunction.createClassSubject(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGD_15() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, VariableUtil.NULL_BOOLEAN, true);
		Response response = CommonFunction.createClassSubject2(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGD_16() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, VariableUtil.NULL_BOOLEAN);
		Response response = CommonFunction.createClassSubject(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGD_17() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, VariableUtil.NULL_BOOLEAN);
		Response response = CommonFunction.createClassSubject2(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGD_18() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.createClassSubject(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void TGD_19() throws SQLException {
		ClassSubject classSubject = null;
		Response response = CommonFunction.createClassSubject(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGD_20() throws SQLException {
		ClassSubject classSubject = null;
		Response response = CommonFunction.createClassSubject2(token, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void TGD_21() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.createClassSubject(VariableUtil.INVALID_TOKEN, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void TGD_22() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.createClassSubject(VariableUtil.EXPIRED_TOKEN, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void TGD_23() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.createClassSubject(tokenLecturer, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
}
