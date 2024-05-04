package Test.Student;

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
import io.restassured.response.Response;

public class DeleteStudent {
	static String token;
	static String tokenLecturer;
    static String testcaseName;
    static String studentID;
	
    static Class<?> clazz = DeleteStudent.class; // Lấy đối tượng Class của lớp hiện tại
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
		studentID = DBUtil.getStudentID();
	}
	
	@Test
	public void XHS_01() throws SQLException {
		Response response = CommonFunction.deleteStudent(token, VariableUtil.NULL_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XHS_02() throws SQLException {
		Response response = CommonFunction.deleteStudent(token, VariableUtil.EMPTY_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XHS_03() throws SQLException {
		Response response = CommonFunction.deleteStudent(token, VariableUtil.ENCODE_FULL_SPACE_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XHS_04() throws SQLException {
		Response response = CommonFunction.deleteStudent(token, VariableUtil.SPECIAL_CHARS_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XHS_05() throws SQLException {
		Response response = CommonFunction.deleteStudent(token, VariableUtil.ENCODE_SPECIAL_CHARS_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XHS_06() throws SQLException {
		Response response = CommonFunction.deleteStudent(token, VariableUtil.CONTAIN_SPACE_CHAR_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XHS_07() throws SQLException {
		Response response = CommonFunction.deleteStudent(token, VariableUtil.NOT_EXIST_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XHS_08() throws SQLException {
		Response response = CommonFunction.deleteStudent(token, studentID);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void XHS_09() throws SQLException
	{
		Response response = CommonFunction.deleteStudent(VariableUtil.INVALID_TOKEN, studentID);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void XHS_10() throws SQLException
	{
		Response response = CommonFunction.deleteStudent(VariableUtil.EXPIRED_TOKEN, studentID);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void XHS_11() throws SQLException
	{
		Response response = CommonFunction.deleteStudent(tokenLecturer, studentID);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
}
