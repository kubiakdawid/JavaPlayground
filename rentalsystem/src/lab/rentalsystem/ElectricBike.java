package lab.rentalsystem;

public class ElectricBike extends Vehicle implements Rentable {
    private int maxRange;

    public ElectricBike(int id, String name, VehicleStatus status, int maxRange) {
        super(id, name, status);
        this.maxRange = maxRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    @Override
    public String displayDetails() {
        return "Electric Bike [ID: " + getId() + ", Name: " + getName() +
                ", Status: " + getStatus() + ", Max Range: " + maxRange + " km]";
    }

    @Override
    public String rent() {
        if (getStatus() == VehicleStatus.AVAILABLE) {
            setStatus(VehicleStatus.RENTED);
            return getName() + " has been rented.";
        } else {
            return getName() + " is not available for rent.";
        }
    }
}
