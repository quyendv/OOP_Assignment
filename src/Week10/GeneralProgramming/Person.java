package Week10.GeneralProgramming;

import java.util.Arrays;
import java.util.List;

public class Person implements Comparable<Person> {  // class Name implements Comparable<Name> -> compareTo
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person() {
    }

    @Override
    public int compareTo(Person o) {
        if (getName().compareTo(o.getName()) < 0) return -1;
        if (getName().compareTo(o.getName()) > 0) return 1;
        return Integer.compare(getAge(), ((Person) o).getAge());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
        Person A = new Person("Nguyen A", 22, "vasv");
        Person B = new Person("Nguyen A", 20, "faf");
        Person C = new Person("Le B", 20, "");
        List<Person> list = Arrays.asList(A, B, C);
        // list = new Week10.GeneralProgramming.SortGeneric<Week10.GeneralProgramming.Person>().sortGeneric(list);
        list = SortGeneric.sortGeneric(list);
        for (Person p : list) {
            System.out.println(p.getName() + " " + p.getAge() + " " + p.getAddress());
        }
    }
}
