package Common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import io.restassured.response.Response;

public class FileUtil {
	public static void deleteFolder(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                	deleteFolder(file); // Đệ quy để xóa thư mục con
                } else {
                    file.delete(); // Xóa tệp tin
                }
            }
        }
        dir.delete(); // Xóa thư mục sau khi đã xóa toàn bộ thư mục con và tệp tin
	}
	
    public static void createFolder(String folderPath) {
    	// Xóa folder test-output để nó có thể ghi được kết quả ra file index.html
    	File dir = new File("test-output");
    	deleteFolder(dir);
    	
    	// Tách các phần của đường dẫn
        String[] pathParts = folderPath.split("/");
        String currentPath = "."; // Đường dẫn hiện tại bắt đầu từ thư mục gốc của project
        
        // Tạo từng thư mục trong đường dẫn
        for (String part : pathParts) {
            currentPath += "/" + part; // Cập nhật đường dẫn hiện tại
            File folder = new File(currentPath);

            // Kiểm tra nếu thư mục chưa tồn tại
            if (!folder.exists()) {
                boolean created = folder.mkdir(); // Tạo thư mục mới
                if (created) {
                    System.out.println("Thư mục '" + currentPath + "' đã được tạo thành công.");
                } else {
                    System.err.println("Không thể tạo thư mục '" + currentPath + "'.");
                }
            } else {
                System.out.println("Thư mục '" + currentPath + "' đã tồn tại.");
            }
        }
    }
    

    public static void createFile (String filePath) {
        try {
            // Tạo đối tượng File
            File file = new File(filePath);

            // Kiểm tra nếu file đã tồn tại
            if (file.createNewFile()) {
                System.out.println("File đã được tạo thành công: " + file.getAbsolutePath());
            } else {
            	file.delete();
            	file.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi tạo file: " + e.getMessage());
        }
    }
    
    public static void appendToFile(String filePath, String testcaseName, Response response) {
        try {
            // Tạo đối tượng FileWriter với tham số true để cho phép ghi thêm vào cuối file
            FileWriter fileWriter = new FileWriter(filePath, true);
            
            // Tạo đối tượng BufferedWriter để ghi dữ liệu
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            // Ghi dữ liệu vào file
            bufferedWriter.write("[" + testcaseName + "]");
            bufferedWriter.newLine();
            bufferedWriter.write("HTTPStatusCode: " + response.getStatusCode());
            bufferedWriter.newLine();
            bufferedWriter.write(response.asString());
            bufferedWriter.newLine(); // Thêm dòng mới sau mỗi lần ghi
            
            // Đóng BufferedWriter
            bufferedWriter.close();
            
//            System.out.println("Dữ liệu đã được ghi thêm vào file thành công.");
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi ghi thêm dữ liệu vào file: " + e.getMessage());
        }
    }
}
