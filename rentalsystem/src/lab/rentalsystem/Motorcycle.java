package lab.rentalsystem;

public class Motorcycle extends Vehicle implements Rentable{
    private int engineCapacity;

    public Motorcycle(int id, String name, VehicleStatus status, int engineCapacity) {
        super(id, name, status);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    @Override
    public String displayDetails() {
        return "Motorcycle [ID: " + getId() + ", Name: " + getName() +
                ", Status: " + getStatus() + ", Engine Capacity: " + engineCapacity + " cc]";
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
