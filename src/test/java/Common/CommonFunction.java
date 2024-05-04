package Common;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;

import Object.ClassSubject;
import Object.Lecturer;
import Object.Point;
import Object.Student;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CommonFunction {
	public static String getToken(String phone, String password) {
		RestAssured.baseURI = VariableUtil.URL_LOGIN;
		JSONObject jsonData = new JSONObject();
		jsonData.put("phone", phone);
		jsonData.put("password", password);
        Response response = RestAssured.given().header("Content-type", "application/json").contentType(ContentType.JSON).body(jsonData)
        							   .when().post();
        String token = response.jsonPath().getString("results.data.token");
        return token;
	}
	
	public static String getTokenAdmin() {
		return getToken(VariableUtil.PHONE_ADMIN, VariableUtil.PASSWORD_ADMIN);
	}
	
	public static String getTokenLecturer() {
		return getToken(VariableUtil.PHONE_LECTURER, VariableUtil.PASSWORD_LECTURER);
	}
		
	public static Response getAllLecturers(String token) {
		RestAssured.baseURI = VariableUtil.URL_LECTURER;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON)
				   .when().get();
		return response;
	}
	
	public static Response getDetailLecturer(String token, String lecturerID) {
		RestAssured.baseURI = VariableUtil.URL_LECTURER + "/" + lecturerID;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON)
				   .when().get();
		return response;
	}
	
	public static Response createLecturer(String token, Lecturer lecturer) {
		RestAssured.baseURI = VariableUtil.URL_LECTURER_CREATE;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(VariableUtil.gson.toJson(lecturer))
				   					   .when().post();
		return response;
	}
	
	public static Response createLecturer2(String token, Lecturer lecturer) {
		RestAssured.baseURI = VariableUtil.URL_LECTURER_CREATE;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(VariableUtil.gson2.toJson(lecturer))
				   					   .when().post();
		return response;
	}
	
	public static Response editLecturer(String token, String lecturerID, Lecturer lecturer) {
		RestAssured.baseURI = VariableUtil.URL_LECTURER_EDIT + "/" + lecturerID;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(VariableUtil.gson.toJson(lecturer))
				   					   .when().put();
		return response;
	}
	
	public static Response editLecturer2(String token, String lecturerID, Lecturer lecturer) {
		RestAssured.baseURI = VariableUtil.URL_LECTURER_EDIT + "/" + lecturerID;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(VariableUtil.gson2.toJson(lecturer))
				   					   .when().put();
		return response;
	}
	
	public static Response deleteLecturer(String token, String lecturerID) {
		RestAssured.baseURI = VariableUtil.URL_LECTURER_DELETE + "/" + lecturerID;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON)
				   .when().delete();
		return response;
	}

	public static Response getAllStudents(String token) {
		RestAssured.baseURI = VariableUtil.URL_STUDENT;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON)
				   .when().get();
		return response;
	}
	
	public static Response getDetailStudent(String token, String studentID) {
		RestAssured.baseURI = VariableUtil.URL_STUDENT + "/" + studentID;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON)
				   .when().get();
		return response;
	}

	public static Response createStudent(String token, Student student) {
		RestAssured.baseURI = VariableUtil.URL_STUDENT_CREATE;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(VariableUtil.gson.toJson(student))
										  .when().post();
		return response;
	}

	public static Response createStudent2(String token, Student student) {
		RestAssured.baseURI = VariableUtil.URL_STUDENT_CREATE;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(VariableUtil.gson2.toJson(student))
										  .when().post();
		return response;
	}

	public static Response editStudent(String token, String studentID, Student student) {
		RestAssured.baseURI = VariableUtil.URL_STUDENT_EDIT + "/" + studentID;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(VariableUtil.gson.toJson(student))
										  .when().put();
		return response;
	}

	public static Response editStudent2(String token, String studentID, Student student) {
		RestAssured.baseURI = VariableUtil.URL_STUDENT_EDIT + "/" + studentID;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(VariableUtil.gson2.toJson(student))
										  .when().put();
		return response;
	}

	public static Response deleteStudent(String token, String studentID) {
		RestAssured.baseURI = VariableUtil.URL_STUDENT_DELETE + "/" + studentID;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON)
				   .when().delete();
		return response;
	}

	public static Response getAllClassSubjects(String token) {
		RestAssured.baseURI = VariableUtil.URL_STUDENT;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON)
				   .when().get();
		return response;
	}

	public static Response getDetailClassSubject(String token, String classSubjectID) {
		RestAssured.baseURI = VariableUtil.URL_STUDENT + "/" + classSubjectID;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON)
				   .when().get();
		return response;
	}

	public static Response createClassSubject(String token, ClassSubject classSubject) {
		RestAssured.baseURI = VariableUtil.URL_CLASS_SUBJECT_CREATE;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(VariableUtil.gson.toJson(classSubject))
										  .when().post();
		return response;
	}

	public static Response createClassSubject2(String token, ClassSubject classSubject) {
		RestAssured.baseURI = VariableUtil.URL_CLASS_SUBJECT_CREATE;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(VariableUtil.gson2.toJson(classSubject))
										  .when().post();
		return response;
	}

	public static Response editClassSubject(String token, String classSubjectID, ClassSubject classSubject) {
		RestAssured.baseURI = VariableUtil.URL_CLASS_SUBJECT_EDIT + "/" + classSubjectID;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(VariableUtil.gson.toJson(classSubject))
										  .when().put();
		return response;
	}

	public static Response editClassSubject2(String token, String classSubjectID, ClassSubject classSubject) {
		RestAssured.baseURI = VariableUtil.URL_CLASS_SUBJECT_EDIT + "/" + classSubjectID;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(VariableUtil.gson2.toJson(classSubject))
										  .when().put();
		return response;
	}

	public static Response deleteClassSubject(String token, String classSubjectID) {
		RestAssured.baseURI = VariableUtil.URL_CLASS_SUBJECT_DELETE + "/" + classSubjectID;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON)
				   .when().delete();
		return response;
	}
	
	public static Response inputPoint(String token, Point point) {
		RestAssured.baseURI = VariableUtil.URL_POINT_INPUT;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(VariableUtil.gson.toJson(point))
				   					   .when().post();
		return response;
	}
	
	public static Response inputPoint2(String token, Point point) {
		RestAssured.baseURI = VariableUtil.URL_POINT_INPUT;
		Response response = RestAssured.given().header("Content-type", "application/json").header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(VariableUtil.gson2.toJson(point))
				   					   .when().post();
		return response;
	}
	
	public static void assertResponse(Response response, int httpStatus) {
		assertEquals(response.statusCode(), httpStatus);
	}
	
	public static void assertResponse(Response response, int httpStatus, String message) {
		assertEquals(response.statusCode(), httpStatus);
		assertEquals(response.jsonPath().getString("detail"), message);
	}
	
	public static void assertResponse2(Response response, int httpStatus, String message) {
		assertEquals(response.statusCode(), httpStatus);
		assertEquals(response.jsonPath().getString("error.code"), Integer.toString(httpStatus));
		assertEquals(response.jsonPath().getString("error.message"), message);
	}
}
