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
import io.restassured.response.Response;

public class EditClassSubject {
	static String token;
	static String tokenLecturer;
    static String testcaseName;
    static int lecturerID;
    static String classSubjectID;
	
    static Class<?> clazz = EditClassSubject.class; // Lấy đối tượng Class của lớp hiện tại
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
		lecturerID = Integer.valueOf(DBUtil.getLecturerID());
		classSubjectID = DBUtil.getClassSubjectID();
	}
	
	@Test
	public void CNGD_01() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(token, VariableUtil.NULL_VALUE, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNGD_02() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(token, VariableUtil.EMPTY_VALUE, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNGD_03() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(token, VariableUtil.ENCODE_FULL_SPACE_VALUE, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNGD_04() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(token, VariableUtil.SPECIAL_CHARS_VALUE, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNGD_05() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(token, VariableUtil.ENCODE_SPECIAL_CHARS_VALUE, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNGD_06() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(token, VariableUtil.CONTAIN_SPACE_CHAR_VALUE, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNGD_07() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(token, VariableUtil.NOT_EXIST_VALUE, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void CNGD_08() throws SQLException {
		ClassSubject classSubject = new ClassSubject(VariableUtil.NULL_INTEGER, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.CLASS_NOT_EXIST_MSG);
	}

	@Test
	public void CNGD_09() throws SQLException {
		ClassSubject classSubject = new ClassSubject(VariableUtil.NULL_INTEGER, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject2(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.CLASS_NOT_EXIST_MSG);
	}
	
	@Test
	public void CNGD_10() throws SQLException {
		ClassSubject classSubject = new ClassSubject(VariableUtil.NOT_EXIST_NUMBER, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.CLASS_NOT_EXIST_MSG);
	}
	
	@Test
	public void CNGD_11() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, VariableUtil.NULL_INTEGER, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.SUBJECT_NOT_EXIST_MSG);
	}

	@Test
	public void CNGD_12() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, VariableUtil.NULL_INTEGER, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject2(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.SUBJECT_NOT_EXIST_MSG);
	}
	
	@Test
	public void CNGD_13() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, VariableUtil.NOT_EXIST_NUMBER, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.SUBJECT_NOT_EXIST_MSG);
	}
	
	@Test
	public void CNGD_14() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, VariableUtil.NULL_INTEGER, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.SCHOOL_YEAR_NOT_EXIST_MSG);
	}

	@Test
	public void CNGD_15() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, VariableUtil.NULL_INTEGER, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject2(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.SCHOOL_YEAR_NOT_EXIST_MSG);
	}
	
	@Test
	public void CNGD_16() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, VariableUtil.NOT_EXIST_NUMBER, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.SCHOOL_YEAR_NOT_EXIST_MSG);
	}
	
	@Test
	public void CNGD_17() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, VariableUtil.NULL_INTEGER, false, true);
		Response response = CommonFunction.editClassSubject(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.TEACHER_NOT_EXIST_MSG);
	}

	@Test
	public void CNGD_18() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, VariableUtil.NULL_INTEGER, false, true);
		Response response = CommonFunction.editClassSubject2(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.TEACHER_NOT_EXIST_MSG);
	}
	
	@Test
	public void CNGD_19() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, VariableUtil.NOT_EXIST_NUMBER, false, true);
		Response response = CommonFunction.editClassSubject(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.TEACHER_NOT_EXIST_MSG);
	}
	
	@Test
	public void CNGD_20() throws SQLException {
		DBUtil.insertClassSubject(1, 1, 1, lecturerID, false, true);
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.CLASS_SUBJECT_EXIST_MSG);
	}
	
	@Test
	public void CNGD_21() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, VariableUtil.NULL_BOOLEAN, true);
		Response response = CommonFunction.editClassSubject(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGD_22() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, VariableUtil.NULL_BOOLEAN, true);
		Response response = CommonFunction.editClassSubject2(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGD_23() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, VariableUtil.NULL_BOOLEAN);
		Response response = CommonFunction.editClassSubject(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGD_24() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, VariableUtil.NULL_BOOLEAN);
		Response response = CommonFunction.editClassSubject2(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGD_25() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void CNGD_26() throws SQLException {
		ClassSubject classSubject = null;
		Response response = CommonFunction.editClassSubject(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGD_27() throws SQLException {
		ClassSubject classSubject = null;
		Response response = CommonFunction.editClassSubject2(token, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void CNGD_28() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(VariableUtil.INVALID_TOKEN, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void CNGD_29() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(VariableUtil.EXPIRED_TOKEN, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void CNGD_30() throws SQLException {
		ClassSubject classSubject = new ClassSubject(1, 1, 1, lecturerID, false, true);
		Response response = CommonFunction.editClassSubject(tokenLecturer, classSubjectID, classSubject);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
}
