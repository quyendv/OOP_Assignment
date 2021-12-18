package Week12;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Utils {
    public static String readContentFromFile(String _path) {
        Path path = Paths.get(_path).toAbsolutePath();
        // System.out.println(path);
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path.toString()/*_path*/));
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    /**
     * Ghi đè vào file (xóa nội dung cũ)
     */
    public static void writeContentToFile(String _path) {
        System.out.print("Content: ");
        String content = new Scanner(System.in).nextLine();

        Path path = Paths.get(_path).toAbsolutePath();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path.toString(), false));
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ghi tiếp vào cuối file
     */
    public static void writeContentToFile2(String fileName) {
        System.out.print("Content: ");
        String content = new Scanner(System.in).nextLine();

        Path path = Paths.get(fileName).toAbsolutePath();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path.toString(), true));
            bw.write(content + '\n');
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Trả về file có tên fileName trong folder. (Giả sử fileName đã chứa đuôi .txt)
     */
    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        File[] fList = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.equals(fileName);
            }
        });
        if (fList == null || fList.length == 0) return null;
        // System.out.println(fList[0].getAbsolutePath());
        return fList[0];
    }

    /**
     * Test: .../src/Week12: text.txt, Utils, (2 file writeHere.txt, writeHere2.txt tự tạo khi chạy các hàm ghi file)
     */
    public static void main(String[] args) {
        String content = readContentFromFile("src/Week12/text.txt");
        System.out.println(content);
        writeContentToFile("src/Week12/writeHere.txt");
        writeContentToFile2("src/Week12/writeHere2.txt");
        System.out.println(findFileByName("src/Week12", "text.txt"));
    }
}
