package Week7.Abstract;

public class MotorBike extends Vehicle {
    private boolean hasSidecar;

    public MotorBike(String brand, String model, String registrationNumber,
                     Person owner, boolean hasSidecar) {
        super(brand, model, registrationNumber, owner);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public String getInfo() {
        return "Motor Bike:\n" + "\tBrand: " + brand + "\n\t" + "Model: " + model + "\n\t"
                + "Registration Number: " + registrationNumber + "\n\t" + "Has Side Week7.Abstract.Car: "
                + hasSidecar + "\n\t" + "Belongs to " + owner.getName()
                + " - " + owner.getAddress();
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }
}
