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
import io.restassured.response.Response;

public class GetDetailLecturer {
	static String token;
	static String tokenLecturer;
    static String testcaseName;
    static String lecturerID;
	
    static Class<?> clazz = GetDetailLecturer.class; // Lấy đối tượng Class của lớp hiện tại
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
	public void XTTCTGV_01() throws SQLException {
		Response response = CommonFunction.getDetailLecturer(token, VariableUtil.NULL_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XTTCTGV_02() throws SQLException {
		Response response = CommonFunction.getDetailLecturer(token, VariableUtil.EMPTY_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void XTTCTGV_03() throws SQLException {
		Response response = CommonFunction.getDetailLecturer(token, VariableUtil.ENCODE_FULL_SPACE_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void XTTCTGV_04() throws SQLException {
		Response response = CommonFunction.getDetailLecturer(token, VariableUtil.SPECIAL_CHARS_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XTTCTGV_05() throws SQLException {
		Response response = CommonFunction.getDetailLecturer(token, VariableUtil.ENCODE_SPECIAL_CHARS_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XTTCTGV_06() throws SQLException {
		Response response = CommonFunction.getDetailLecturer(token, VariableUtil.CONTAIN_SPACE_CHAR_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XTTCTGV_07() throws SQLException {
		Response response = CommonFunction.getDetailLecturer(token, VariableUtil.NOT_EXIST_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XTTCTGV_08() throws SQLException {
		Response response = CommonFunction.getDetailLecturer(token, lecturerID);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void XTTCTGV_09() throws SQLException
	{
		Response response = CommonFunction.getDetailLecturer(VariableUtil.INVALID_TOKEN, lecturerID);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void XTTCTGV_10() throws SQLException
	{
		Response response = CommonFunction.getDetailLecturer(VariableUtil.EXPIRED_TOKEN, lecturerID);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void XTTCTGV_11() throws SQLException
	{
		Response response = CommonFunction.getDetailLecturer(tokenLecturer, lecturerID);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void XTTCTGV_12() throws SQLException
	{
		Response response = CommonFunction.getDetailLecturer(tokenLecturer, lecturerID);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
}
