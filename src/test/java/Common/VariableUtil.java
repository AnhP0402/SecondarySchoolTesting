package Common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VariableUtil {
	// Khai báo các API
	public static final String URL_COMMON = "http://45.32.106.84:3088/api/";
	public static final String URL_LOGIN = URL_COMMON + "personal/login";
	
	public static final String URL_LECTURER = URL_COMMON + "users";
	public static final String URL_LECTURER_CREATE = URL_COMMON + "users/create";
	public static final String URL_LECTURER_EDIT = URL_COMMON + "users/edit";
	public static final String URL_LECTURER_DELETE = URL_COMMON + "users/delete";
	
	public static final String URL_STUDENT = URL_COMMON + "students";
	public static final String URL_STUDENT_CREATE = URL_COMMON + "students/create";
	public static final String URL_STUDENT_EDIT = URL_COMMON + "students/edit";
	public static final String URL_STUDENT_DELETE = URL_COMMON + "students/delete";
	
	public static final String URL_CLASS_SUBJECT = URL_COMMON + "class-subjects";
	public static final String URL_CLASS_SUBJECT_CREATE = URL_COMMON + "class-subjects/create";
	public static final String URL_CLASS_SUBJECT_EDIT = URL_COMMON + "class-subjects/edit";
	public static final String URL_CLASS_SUBJECT_DELETE = URL_COMMON + "class-subjects/delete";
	
	public static final String URL_POINT_INPUT = URL_COMMON + "points/create";
	
	// Khai báo người dùng
	public static final String PHONE_ADMIN = "0321234560";
	public static final String PASSWORD_ADMIN = "123456";
	
	public static final String PHONE_LECTURER = "0987654321";
	public static final String PASSWORD_LECTURER = "123456";
	
	// Khai báo token
	public static final String INVALID_TOKEN = "Abcd1234";
	public static final String EXPIRED_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6NCwiZnVsbF9uYW1lIjoiTmd1eVx1MWVjNW4gVlx1MDEwM24gRCIsInBob25lIjoiMDMzMTIzNDU2MCIsImVtYWlsIjoibmd1eWVudmFuZEBnbWFpbC5jb20iLCJleHAiOjE3MTQ2NTk3MDl9.Xbk29WtsT-DnRMD86zDS8_vjHHZI7bTXDiO2XrBEeK8";
	
	// Khai báo message
	public static final String AUTHEN_FAILED_MSG = "Authentication failed";
	public static final String NOT_FOUND_MSG = "Không tìm thấy.";
	public static final String INVALID_PARAM_MSG = "Invalid parameters";
	
	public static final String INVALID_CLASS_MSG = "class_id is invalid";
	public static final String INVALID_SCHOOL_YEAR_MSG = "school_year_id is invalid";
	
	public static final String CLASS_NOT_EXIST_MSG = "Class does not exist";
	public static final String SUBJECT_NOT_EXIST_MSG = "Subject does not exist";
	public static final String SCHOOL_YEAR_NOT_EXIST_MSG = "School year does not exist";
	public static final String TEACHER_NOT_EXIST_MSG = "Teacher does not exist";
	public static final String CLASS_SUBJECT_EXIST_MSG = "Class - Subject - School year and Teacher are exist";
	
	public static final String STUDENT_NOT_EXIST_MSG = "Student does not exist";
	public static final String CLASS_SUBJECT_NOT_EXIST_MSG = "Class subject does not exist";
	public static final String POINT_EXIST_MSG = "Point does exist";
		
	// Khai báo các giá trị hay sử dụng
	public static final Integer NULL_INTEGER = null;
	public static final Integer NOT_EXIST_NUMBER = 1000;
	
	public static final Double NULL_DOUBLE = null;
	public static final Double SMALLER_THAN_MIN_VALUE = -0.1;
	public static final Double GREATER_THAN_MAX_VALUE = 10.1;
	
	public static final Boolean NULL_BOOLEAN = null;
	
	public static final String NULL_VALUE = null;
	public static final String EMPTY_VALUE = "";
	public static final String FULL_SPACE_VALUE = "          ";
	public static final String ENCODE_FULL_SPACE_VALUE = "%20%20%20%20%20%20%20%20%20%20";
	public static final String SPECIAL_CHARS_VALUE = "@#$%^&*()";
	public static final String ENCODE_SPECIAL_CHARS_VALUE = "%2526%253F%2523";
	public static final String CONTAIN_SPACE_CHAR_VALUE = "0%201";
	public static final String NOT_EXIST_VALUE = "1000";
	
	public static Gson gson = new GsonBuilder().serializeNulls().create(); // use with param in body = null
	public static Gson gson2 = new Gson(); // use with param in body = missing
	
	public static final String RESULT_FOLDER = "result";
}
