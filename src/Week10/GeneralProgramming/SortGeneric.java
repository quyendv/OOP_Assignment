package Week10.GeneralProgramming;

import java.util.ArrayList;
import java.util.List;

//public class SortGeneric<T extends Comparable<T>> {
//    public List<T> sortGeneric(List<T> arr) {       // class template thì phương thức k static được
//        for (int i = 0; i < arr.size() - 1; i++) {
//            int minIndex = i;
//            for (int j = i + 1; j < arr.size(); j++) {
//                if (arr.get(j).compareTo(arr.get(minIndex)) < 0) minIndex = j;
//            }
//            swap(arr, i, minIndex);
//        }
//        return arr;
//    }
//
//    public void swap(List<T> arr, int i, int j) {
//        T temp = arr.get(i);
//        arr.set(i, arr.get(j));
//        arr.set(j, temp);
//    }
//}

public class SortGeneric { // mẫu lớp: public static T void nameFunc(...) {...}, nếu <T extends Comparable<T>> thì k cần thêm T nữa
    // 1 class chứa nhiều templateFunc thì có thể thay bằng template class như trên
    // được dùng cho class nameClass implements Comparable<nameClass>
    // nếu chỉ cần template để in mảng hay làm gì đó k cần so sánh thì k cần extend..., còn dùng ss phải như trên
    public static <T extends Comparable<T>> List<T> sortGeneric(List<T> arr) {  // có thể static, khác với bên trên
        for (int i = 0; i < arr.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j).compareTo(arr.get(minIndex)) < 0) minIndex = j;
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    public static <T extends Comparable<T>> void swap(List<T> arr, int i, int j) {
        T temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < 10; i++) a.add(10 - i - 1);
        // a = new Week12.Week12.Week10.GeneralProgramming.SortGeneric<Integer>().sortGeneric(a);
        a = sortGeneric(a);
        System.out.println(a);
    }
}
