package Week9.Exception2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Week8Task2 {
    public void nullPointerEx() throws NullPointerException {
        Integer[] a = new Integer[1];
        a[0] += 1;
    }

    /**
     * Catch NullPointerEx.
     * @return string
     */
    public String nullPointerExTest() {
        try {
            nullPointerEx();
        } catch (NullPointerException e) {
            return "Lỗi Null Pointer";
        }
        return "Không có lỗi";
    }

    public void arrayIndexOutOfBoundsEx() throws ArrayIndexOutOfBoundsException {
        int[] a = new int[1];
        a[1]++;
    }

    /**
     * Catch Array Index Out Of Bounds.
     * @return string
     */
    public String arrayIndexOutOfBoundsExTest() {
        try {
            arrayIndexOutOfBoundsEx();
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Lỗi Array Index Out of Bounds";
        }
        return "Không có lỗi";
    }

    public void arithmeticEx() throws ArithmeticException {
        throw new ArithmeticException();
    }

    /**
     * Catch Arithmetic Ex.
     * @return
     */
    public String arithmeticExTest() {
        try {
            arithmeticEx();
        } catch (ArithmeticException e) {
            return "Lỗi Arithmetic";
        }
        return "Không có lỗi";
    }

    /**
     * Throws FileNotFoundEx.
     * @throws FileNotFoundException Ex
     */
    public void fileNotFoundEx() throws FileNotFoundException {
        File file = new File("abcdef.txt");
        Scanner sc = new Scanner(file);
        String s = sc.nextLine();
    }

    /**
     * Catch fileNotFound.
     * @return string
     */
    public String fileNotFoundExTest() {
        try {
            fileNotFoundEx();
        } catch (FileNotFoundException e) {
            return "Lỗi File Not Found";
        }
        return "Không có lỗi";
    }

    public void ioEx() throws IOException {
        throw new IOException("");
    }

    /**
     * Catch IOEx.
     * @return string
     */
    public String ioExTest() {
        try {
            ioEx();
        } catch (IOException e) {
            return "Lỗi IO";
        }
        return "Không có lỗi";
    }

    public static void main(String[] args) {
        System.out.println(new Week8Task2().nullPointerExTest());
    }
}
