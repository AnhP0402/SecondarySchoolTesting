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

public class GetAllStudents {
	static String token;
	static String tokenLecturer;
    static String testcaseName;
	
    static Class<?> clazz = GetAllStudents.class; // Lấy đối tượng Class của lớp hiện tại
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
	public void XDSHS_01() throws SQLException {
		Response response = CommonFunction.getAllStudents(token);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void XDSHS_02() throws SQLException
	{
		Response response = CommonFunction.getAllStudents(token);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
		
	@Test
	public void XDSHS_03() throws SQLException
	{
		Response response = CommonFunction.getAllStudents(VariableUtil.INVALID_TOKEN);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void XDSHS_04() throws SQLException
	{
		Response response = CommonFunction.getAllStudents(VariableUtil.EXPIRED_TOKEN);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void XDSHS_05() throws SQLException
	{
		Response response = CommonFunction.getAllStudents(tokenLecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
}
