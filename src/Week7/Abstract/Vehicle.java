package Week7.Abstract;

public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected String registrationNumber;
    protected Person owner;

    /**
     * Constructor.
     *
     * @param brand              b
     * @param model              m
     * @param registrationNumber rN
     * @param owner              o
     */
    public Vehicle(String brand, String model, String registrationNumber, Person owner) {
        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.owner = owner;
    }

    public abstract String getInfo();

    /**
     * Implement.
     * @param newOwner nO
     */
    public void transferOwnership(Person newOwner) {
        if (newOwner != null) {
            this.owner = newOwner;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Person getOwner() {
        return owner;
    }

    /**
     * setter.
     * @param owner o
     */
    public void setOwner(Person owner) {
        if (owner != null) {
            this.owner = owner;
        }
    }
}
