package Week7.Abstract;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, String registrationNumber, Person owner,
               int numberOfDoors) {
        super(brand, model, registrationNumber, owner);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String getInfo() {
        return "Week7.Abstract.Car:\n" + "\tBrand: " + brand + "\n" + "\tModel: " + model + "\n"
                + "\tRegistration Number: " + registrationNumber + "\n" + "\tNumber of Doors: "
                + numberOfDoors + "\n" + "\tBelongs to " + owner.getName()
                + " - " + owner.getAddress();
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
