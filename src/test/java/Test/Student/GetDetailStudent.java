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
import io.restassured.response.Response;

public class GetDetailStudent {
	static String token;
	static String tokenLecturer;
    static String testcaseName;
	
    static Class<?> clazz = GetDetailStudent.class; // Lấy đối tượng Class của lớp hiện tại
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
	public void XTTCTHS_01() throws SQLException {
		Response response = CommonFunction.getDetailStudent(token, VariableUtil.NULL_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XTTCTHS_02() throws SQLException {
		Response response = CommonFunction.getDetailStudent(token, VariableUtil.EMPTY_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void XTTCTHS_03() throws SQLException {
		Response response = CommonFunction.getDetailStudent(token, VariableUtil.ENCODE_FULL_SPACE_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void XTTCTHS_04() throws SQLException {
		Response response = CommonFunction.getDetailStudent(token, VariableUtil.SPECIAL_CHARS_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XTTCTHS_05() throws SQLException {
		Response response = CommonFunction.getDetailStudent(token, VariableUtil.ENCODE_SPECIAL_CHARS_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XTTCTHS_06() throws SQLException {
		Response response = CommonFunction.getDetailStudent(token, VariableUtil.CONTAIN_SPACE_CHAR_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XTTCTHS_07() throws SQLException {
		Response response = CommonFunction.getDetailStudent(token, VariableUtil.NOT_EXIST_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XTTCTHS_08() throws SQLException {
		Response response = CommonFunction.getDetailStudent(token, "5");
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void XTTCTHS_09() throws SQLException
	{
		Response response = CommonFunction.getDetailStudent(VariableUtil.INVALID_TOKEN, "5");
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void XTTCTHS_10() throws SQLException
	{
		Response response = CommonFunction.getDetailStudent(VariableUtil.EXPIRED_TOKEN, "5");
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void XTTCTHS_11() throws SQLException
	{
		Response response = CommonFunction.getDetailStudent(tokenLecturer, "5");
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
}
