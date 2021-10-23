public class Person {
    private String name;
    private String address;

    /**
     * Constructor.
     *
     * @param name    n
     * @param address a
     */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Convert to String.
     *
     * @return res
     */
    public String toString() {
        return "Person[name=" + name + ",address=" + address + "]";
    }

    // getter, setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
