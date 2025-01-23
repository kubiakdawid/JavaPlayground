package lab.rentalsystem;

public class Scooter extends Vehicle implements Rentable {
    private int speedLimit;

    public Scooter(int id, String name, VehicleStatus status, int speedLimit) {
        super(id, name, status);
        this.speedLimit = speedLimit;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    @Override
    public String displayDetails() {
        return "Scooter [ID: " + getId() + ", Name: " + getName() +
                ", Status: " + getStatus() + ", Speed Limit: " + speedLimit + " km/h]";
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
