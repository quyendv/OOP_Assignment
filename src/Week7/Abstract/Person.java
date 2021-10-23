package Week7.Abstract;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String address;
    private List<Vehicle> vehicleList = new ArrayList<>();

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Add.
     * @param vehicle v
     */
    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            return;
        }
        vehicleList.add(vehicle);
    }

    /**
     * Remove.
     *
     * @param registrationNumber rN
     */
    public void removeVehicle(String registrationNumber) {
        for (int i = 0; i < vehicleList.size(); ) {
            if (vehicleList.get(i).getRegistrationNumber().equals(registrationNumber)) {
                vehicleList.remove(i);
            } else {
                i++;
            }
        }
    }

    /**
     * GetInfo.
     *
     * @return string
     */
    public String getVehiclesInfo() {
        if (vehicleList.size() == 0) {
            return name + " has no vehicle!";
        }
        StringBuilder ans = new StringBuilder(name + " has:\n\n");
        for (Vehicle v : vehicleList) {
            ans.append(v.getInfo()).append('\n');
        }
        return ans.toString();
    }

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
