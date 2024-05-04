package Test.Point;

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
import Object.Point;
import io.restassured.response.Response;

public class InputPoint {
	static String token;
	static String tokenLecturer;
    static String testcaseName;
	
    static Class<?> clazz = InputPoint.class; // Lấy đối tượng Class của lớp hiện tại
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
		DBUtil.deletePoint(1, 2);
	}
	
	@Test
	public void ND_01() throws SQLException {
		Point Point = new Point(VariableUtil.NULL_INTEGER, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}

	@Test
	public void ND_02() throws SQLException {
		Point Point = new Point(VariableUtil.NULL_INTEGER, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint2(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_03() throws SQLException {
		Point Point = new Point(VariableUtil.NOT_EXIST_NUMBER, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint2(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.STUDENT_NOT_EXIST_MSG);
	}
	
	@Test
	public void ND_04() throws SQLException {
		Point Point = new Point(1, VariableUtil.NULL_INTEGER, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_05() throws SQLException {
		Point Point = new Point(1, VariableUtil.NULL_INTEGER, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint2(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_06() throws SQLException {
		Point Point = new Point(1, VariableUtil.NOT_EXIST_NUMBER, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.CLASS_SUBJECT_NOT_EXIST_MSG);
	}
	
	@Test
	public void ND_07() throws SQLException {
		DBUtil.insertPoint(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse2(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.POINT_EXIST_MSG);
	}
	
	@Test
	public void ND_08() throws SQLException {
		Point Point = new Point(1, 2, VariableUtil.NULL_DOUBLE, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_09() throws SQLException {
		Point Point = new Point(1, 2, VariableUtil.NULL_DOUBLE, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint2(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_10() throws SQLException {
		Point Point = new Point(1, 2, VariableUtil.SMALLER_THAN_MIN_VALUE, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_11() throws SQLException {
		Point Point = new Point(1, 2, VariableUtil.GREATER_THAN_MAX_VALUE, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_12() throws SQLException {
		Point Point = new Point(1, 2, 8.5, VariableUtil.NULL_DOUBLE, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void ND_13() throws SQLException {
		Point Point = new Point(1, 2, 8.5, VariableUtil.NULL_DOUBLE, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint2(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void ND_14() throws SQLException {
		Point Point = new Point(1, 2, 8.5, VariableUtil.SMALLER_THAN_MIN_VALUE, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_15() throws SQLException {
		Point Point = new Point(1, 2, 8.5, VariableUtil.GREATER_THAN_MAX_VALUE, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_16() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, VariableUtil.NULL_DOUBLE, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void ND_17() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, VariableUtil.NULL_DOUBLE, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint2(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void ND_18() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, VariableUtil.SMALLER_THAN_MIN_VALUE, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_19() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, VariableUtil.GREATER_THAN_MAX_VALUE, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_20() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, VariableUtil.NULL_DOUBLE, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void ND_21() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, VariableUtil.NULL_DOUBLE, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint2(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void ND_22() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, VariableUtil.SMALLER_THAN_MIN_VALUE, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_23() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, VariableUtil.GREATER_THAN_MAX_VALUE, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_24() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, VariableUtil.NULL_DOUBLE, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void ND_25() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, VariableUtil.NULL_DOUBLE, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint2(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void ND_26() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, VariableUtil.SMALLER_THAN_MIN_VALUE, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_27() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, VariableUtil.GREATER_THAN_MAX_VALUE, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_28() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, VariableUtil.NULL_DOUBLE, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void ND_29() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, VariableUtil.NULL_DOUBLE, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint2(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void ND_30() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, VariableUtil.SMALLER_THAN_MIN_VALUE, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_31() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, VariableUtil.GREATER_THAN_MAX_VALUE, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_32() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, VariableUtil.NULL_DOUBLE, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void ND_33() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, VariableUtil.NULL_DOUBLE, 9.0, false, true);
		Response response = CommonFunction.inputPoint2(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void ND_34() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, VariableUtil.SMALLER_THAN_MIN_VALUE, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_35() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, VariableUtil.GREATER_THAN_MAX_VALUE, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_36() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, VariableUtil.NULL_DOUBLE, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void ND_37() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, VariableUtil.NULL_DOUBLE, false, true);
		Response response = CommonFunction.inputPoint2(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void ND_38() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, VariableUtil.SMALLER_THAN_MIN_VALUE, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_39() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, VariableUtil.GREATER_THAN_MAX_VALUE, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_40() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, VariableUtil.NULL_BOOLEAN, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_41() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, VariableUtil.NULL_BOOLEAN, true);
		Response response = CommonFunction.inputPoint2(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_42() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, VariableUtil.NULL_BOOLEAN);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_43() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, VariableUtil.NULL_BOOLEAN);
		Response response = CommonFunction.inputPoint2(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_44() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_OK);
	}
	
	@Test
	public void ND_45() throws SQLException {
		Point Point = null;
		Response response = CommonFunction.inputPoint(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_46() throws SQLException {
		Point Point = null;
		Response response = CommonFunction.inputPoint2(token, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_BAD_REQUEST, VariableUtil.INVALID_PARAM_MSG);
	}
	
	@Test
	public void ND_47() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(VariableUtil.INVALID_TOKEN, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void ND_48() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(VariableUtil.EXPIRED_TOKEN, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
	
	@Test
	public void ND_49() throws SQLException {
		Point Point = new Point(1, 2, 8.5, 9.0, 9.0, 9.0, 9.0, 9.0, 8.5, 9.0, false, true);
		Response response = CommonFunction.inputPoint(tokenLecturer, Point);
		FileUtil.appendToFile(filePath, testcaseName, response);
		CommonFunction.assertResponse(response, HttpStatus.SC_UNAUTHORIZED, VariableUtil.AUTHEN_FAILED_MSG);
	}
}
