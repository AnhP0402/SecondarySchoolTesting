package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class DBUtil {
	private static Connection conn;
	private static final String DB_URL = "jdbc:mysql://45.32.106.84:3306/secondary_school";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "";

	public static Connection getConnection() {
		conn = getConnection(DB_URL, USER_NAME, PASSWORD);
		return conn;
	}
	
	public static Connection getConnection(String dbURL, String userName, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			conn = DriverManager.getConnection(dbURL, userName, password);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	public static void executeSQL(String sql) throws SQLException {
		conn = getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		conn.close();
	}
	
	public static void deleteLecturer() throws SQLException {
		executeSQL("DELETE FROM users WHERE position = 'Giáo viên'");
	}
		
	public static void deleteLecturer(String phone) throws SQLException {
        PreparedStatement preparedStatement = null;
    	conn = getConnection();
        String sql = "DELETE FROM users " +
                     "WHERE phone = ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, phone);
        preparedStatement.executeUpdate();
	}
	
	public static void insertLecturer(String fullName, String phone, String email, String address, String specialize, String position, int departmentId, String password) {
        PreparedStatement preparedStatement = null;
        try {
        	conn = getConnection();
            String sql = "INSERT INTO users (full_name, phone, email, address, specialize, position, created_at, updated_at, department_id, password) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, specialize);
            preparedStatement.setString(6, position);
            preparedStatement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setInt(9, departmentId);
            preparedStatement.setString(10, password);
            
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
//                System.out.println("Dữ liệu đã được chèn thành công vào bảng users.");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi chèn dữ liệu vào bảng users: " + e.getMessage());
        }
	}
	
	public static String getLecturerID() throws SQLException {
		int lastId = 0;
		insertLecturer("Nguyễn Văn A", "0123456789", "nguyenvana@gmail.com", "Hà Nội", "Giáo viên", "Toán", 1, "Abcd1234");
		String query = "SELECT MAX(id) AS last_id FROM users"; 
	    Statement statement = conn.createStatement();
	    ResultSet resultSet = statement.executeQuery(query);
	
	    if (resultSet.next()) {
	        lastId = resultSet.getInt("last_id");
//	        System.out.println("Last ID in table A: " + lastId);
	    } else {
//	        System.out.println("Table A is empty.");
	    }
	    return Integer.toString(lastId);
	}
	
	// Phải call API tạo giáo viên rồi dùng hàm này để lấy id của giáo viên thì mới phân công giáo viên giảng dạy được 
	public static String getLecturerID2() throws SQLException {
		int lastId = 0;
		String query = "SELECT MAX(id) AS last_id FROM users"; 
		conn = getConnection();
	    Statement statement = conn.createStatement();
	    ResultSet resultSet = statement.executeQuery(query);
	
	    if (resultSet.next()) {
	        lastId = resultSet.getInt("last_id");
//	        System.out.println("Last ID in table A: " + lastId);
	    } else {
//	        System.out.println("Table A is empty.");
	    }
	    return Integer.toString(lastId);
	}
	
	public static void insertStudent(String full_name, String gender, String birthday, String address, String nation, String religion, String father_name, 
			String father_job, String mother_name, String mother_job, Integer classes_id, Integer school_year_id) {
        PreparedStatement preparedStatement = null;
        try {
        	conn = getConnection();
            String sql = "INSERT INTO students (full_name, gender, birthday, address, nation, religion, " +
                    "father_name, father_job, mother_name, mother_job, classes_id, school_year_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, full_name);
            preparedStatement.setString(2, gender);
            preparedStatement.setString(3, birthday);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, nation);
            preparedStatement.setString(6, religion);
            preparedStatement.setString(7, father_name);
            preparedStatement.setString(8, father_job);
            preparedStatement.setString(9, mother_name);
            preparedStatement.setString(10, mother_job);
            preparedStatement.setInt(11, classes_id);
            preparedStatement.setInt(12, school_year_id);
            
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
//                System.out.println("Dữ liệu đã được chèn thành công vào bảng students.");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi chèn dữ liệu vào bảng students: " + e.getMessage());
        }
	}
	
	public static String getStudentID() throws SQLException {
		int lastId = 0;
		insertStudent("Bùi Minh Anh", "Nam", "2012-10-10", "Đồng Nai", "Kinh", "Không", "Bùi Minh Anh Bố", "Bác sĩ", "Nguyễn Minh Anh Mẹ", "Y tá", 1, 2);
		String query = "SELECT MAX(id) AS last_id FROM students"; 
	    Statement statement = conn.createStatement();
	    ResultSet resultSet = statement.executeQuery(query);
	
	    if (resultSet.next()) {
	        lastId = resultSet.getInt("last_id");
//	        System.out.println("Last ID in table A: " + lastId);
	    } else {
//	        System.out.println("Table A is empty.");
	    }
	    return Integer.toString(lastId);
	}
	
	public static void insertClassSubject(Integer classes_id, Integer subject_id, Integer school_year_id, Integer user_id, Boolean can_teach_section_1, Boolean can_teach_section_2) {
        PreparedStatement preparedStatement = null;
        try {
        	conn = getConnection();
            String sql = "INSERT INTO class_subjects (classes_id, subject_id, school_year_id, user_id, can_teach_section_1, can_teach_section_2) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, classes_id);
            preparedStatement.setInt(2, subject_id);
            preparedStatement.setInt(3, school_year_id);
            preparedStatement.setInt(4, user_id);
            preparedStatement.setBoolean(5, can_teach_section_1);
            preparedStatement.setBoolean(6, can_teach_section_2);
            
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
//                System.out.println("Dữ liệu đã được chèn thành công vào bảng class_subjects.");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi chèn dữ liệu vào bảng class_subjects: " + e.getMessage());
        }
	}
	
	public static void deleteClassSubject(Integer classes_id, Integer subject_id, Integer school_year_id, Integer user_id) throws SQLException {
        PreparedStatement preparedStatement = null;
    	conn = getConnection();
        String sql = "DELETE FROM class_subjects " +
                     "WHERE classes_id = ? AND subject_id = ? AND school_year_id = ? AND user_id = ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, classes_id);
        preparedStatement.setInt(2, subject_id);
        preparedStatement.setInt(3, school_year_id);
        preparedStatement.setInt(4, user_id);
        preparedStatement.executeUpdate();
	}
	
	public static String getClassSubjectID() throws SQLException {
		int lastId = 0;
		int user_id = Integer.valueOf(getLecturerID()); // tạo giáo viên mới rồi lấy id của giáo viên
		deleteClassSubject(1, 1, 1, user_id); // xóa bản ghi đã tồn tại
		insertClassSubject(1, 1, 1, user_id, false, true); // thêm bản ghi mới rồi lấy id của phân công giảng dạy
		String query = "SELECT MAX(id) AS last_id FROM class_subjects"; 
	    Statement statement = conn.createStatement();
	    ResultSet resultSet = statement.executeQuery(query);
	
	    if (resultSet.next()) {
	        lastId = resultSet.getInt("last_id");
//	        System.out.println("Last ID in table A: " + lastId);
	    } else {
//	        System.out.println("Table A is empty.");
	    }
	    return Integer.toString(lastId);
	}
	
	public static void deletePoint(int studentID, int classSubjectID) throws SQLException {
        PreparedStatement preparedStatement = null;
    	conn = getConnection();
        String sql = "DELETE FROM points " +
                     "WHERE student_id = ? AND class_subject_id = ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, studentID);
        preparedStatement.setInt(2, classSubjectID);
        preparedStatement.executeUpdate();
	}
	
	public static void insertPoint(int student_id, int class_subject_id, double exam_quick, double exam_15_no_1, double exam_15_no_2,
			double exam_15_no_3, double exam_15_no_4, double exam_45_no_1, double exam_45_no_2, double exam_finally, boolean is_section_1, boolean is_section_2) {
        PreparedStatement preparedStatement = null;
        try {
        	conn = getConnection();
        	String sql = "INSERT INTO points (student_id, class_subject_id, exam_quick, exam_15_no_1, exam_15_no_2, " +
                    "exam_15_no_3, exam_15_no_4, exam_45_no_1, exam_45_no_2, exam_finally, avg_point, is_section_1, is_section_2) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0.0, ?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, student_id);
            preparedStatement.setInt(2, class_subject_id);
            preparedStatement.setDouble(3, exam_quick);
            preparedStatement.setDouble(4, exam_15_no_1);
            preparedStatement.setDouble(5, exam_15_no_2);
            preparedStatement.setDouble(6, exam_15_no_3);
            preparedStatement.setDouble(7, exam_15_no_4);
            preparedStatement.setDouble(8, exam_45_no_1);
            preparedStatement.setDouble(9, exam_45_no_2);
            preparedStatement.setDouble(10, exam_finally);
            preparedStatement.setBoolean(11, is_section_1);
            preparedStatement.setBoolean(12, is_section_2);
            
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
//                System.out.println("Dữ liệu đã được chèn thành công vào bảng points.");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi chèn dữ liệu vào bảng points: " + e.getMessage());
        }
	}
}