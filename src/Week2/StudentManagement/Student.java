
public class Student {
    // Khai bao cac thuoc tinh cho Student
    private String name;
    private String id;
    private String group;
    private String email;

    /**
     * Constructor mac dinh.
     */
    public Student() {
        this.name = "Student";
        this.id = "000";
        this.group = "K62CB";
        this.email = "uet@vnu.edu.vn";
    }

    /**
     * set 3 tham so.
     * @param name ten
     * @param id maSV
     * @param email emailSV
     */
    public Student(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.group = "K62CB";
        this.email = email;
    }

    /**
     * Set 4 tham so.
     * @param name ten
     * @param id maSV
     * @param group lop
     * @param email email
     */
    public Student(String name, String id, String group, String email) {
        this(name, id, email);
        this.setGroup(group);
    }

    /**
     * Khoi tao tư 1 Student khac.
     * @param s student can khoi tao
     */
    public Student(Student s) {
        this.name = s.name;
        this.id = s.id;
        this.group = s.group;
        this.email = s.email;
    }

    // getter/setter method
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // get Information's Student
    public String getInfo() {
        return (name + " - " + id + " - " + group + " - " + email);
    }
}
