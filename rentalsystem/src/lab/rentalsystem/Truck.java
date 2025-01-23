package lab.rentalsystem;

public class Truck extends Vehicle implements Rentable{
    private double loadCapacity;

    public Truck(int id, String name, VehicleStatus status, double loadCapacity) {
        super(id, name, status);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public String displayDetails() {
        return "Truck [ID: " + getId() + ", Name: " + getName() +
                ", Status: " + getStatus() + ", Load Capacity: " + loadCapacity + " tons]";
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