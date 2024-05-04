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
import io.restassured.response.Response;

public class GetAllLecturers {
	static String token;
	static String tokenLecturer;
    static String testcaseName;
	
    static Class<?> clazz = GetAllLecturers.class; // Lấy đối tượng Class của lớp hiện tại
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
	public void XDSGV_01() throws SQLException {
//		DBUtil.deleteLecturer();
		Response response = CommonFunction.getAllLecturers(token);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void XDSGV_02() throws SQLException
	{
//		DBUtil.insertLecturer("John Doe", "0321234567", "john.doe@example.com", "123 Main Street", "IT", "Developer", 1, "password123");
		Response response = CommonFunction.getAllLecturers(token);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
//		DBUtil.deleteLecturer("0321234567");
	}
		
	@Test
	public void XDSGV_03() throws SQLException
	{
		Response response = CommonFunction.getAllLecturers(VariableUtil.INVALID_TOKEN);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void XDSGV_04() throws SQLException
	{
		Response response = CommonFunction.getAllLecturers(VariableUtil.EXPIRED_TOKEN);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void XDSGV_05() throws SQLException
	{
		Response response = CommonFunction.getAllLecturers(tokenLecturer);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
}
