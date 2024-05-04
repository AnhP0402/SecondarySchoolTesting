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
import io.restassured.response.Response;

public class GetDetailClassSubject {
	static String token;
	static String tokenLecturer;
    static String testcaseName;
    static String classSubjectID;
	
    static Class<?> clazz = GetDetailClassSubject.class; // Lấy đối tượng Class của lớp hiện tại
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
		classSubjectID = DBUtil.getClassSubjectID();
	}
	
	@Test
	public void XTTCTGD_01() throws SQLException {
		Response response = CommonFunction.getDetailClassSubject(token, VariableUtil.NULL_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XTTCTGD_02() throws SQLException {
		Response response = CommonFunction.getDetailClassSubject(token, VariableUtil.EMPTY_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void XTTCTGD_03() throws SQLException {
		Response response = CommonFunction.getDetailClassSubject(token, VariableUtil.ENCODE_FULL_SPACE_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void XTTCTGD_04() throws SQLException {
		Response response = CommonFunction.getDetailClassSubject(token, VariableUtil.SPECIAL_CHARS_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XTTCTGD_05() throws SQLException {
		Response response = CommonFunction.getDetailClassSubject(token, VariableUtil.ENCODE_SPECIAL_CHARS_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XTTCTGD_06() throws SQLException {
		Response response = CommonFunction.getDetailClassSubject(token, VariableUtil.CONTAIN_SPACE_CHAR_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XTTCTGD_07() throws SQLException {
		Response response = CommonFunction.getDetailClassSubject(token, VariableUtil.NOT_EXIST_VALUE);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_NOT_FOUND, VariableUtil.NOT_FOUND_MSG);
	}
	
	@Test
	public void XTTCTGD_08() throws SQLException {
		Response response = CommonFunction.getDetailClassSubject(token, classSubjectID);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void XTTCTGD_09() throws SQLException
	{
		Response response = CommonFunction.getDetailClassSubject(VariableUtil.INVALID_TOKEN, classSubjectID);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void XTTCTGD_10() throws SQLException
	{
		Response response = CommonFunction.getDetailClassSubject(VariableUtil.EXPIRED_TOKEN, classSubjectID);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void XTTCTGD_11() throws SQLException
	{
		Response response = CommonFunction.getDetailClassSubject(tokenLecturer, classSubjectID);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void XTTCTGD_12() throws SQLException
	{
		Response response = CommonFunction.getDetailClassSubject(tokenLecturer, classSubjectID);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
}
