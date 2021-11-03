package Week5.Inheritance2;

public class Student extends Person {
    private String program;
    private int year;
    private double fee;

    /**
     * Constructor.
     *
     * @param name n
     * @param address a
     * @param program p
     * @param year y
     * @param fee f
     */
    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    /**
     * Override convert student to String.
     * @return res
     */
    @Override
    public String toString() {
        return "Student[" + super.toString() + ",program="
                + program + ",year=" + year + ",fee=" + fee + "]";
    }

    // getter, setter
    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
