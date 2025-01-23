package lab.rentalsystem;

public class Car extends Vehicle implements Rentable {
    private int numberOfSeats;

    public Car(int id, String name, VehicleStatus status, int numberOfSeats) {
        super(id, name, status);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public String displayDetails() {
        return "Car [ID: " + getId() + ", Name: " + getName() +
                ", Status: " + getStatus() + ", Seats: " + numberOfSeats + "]";
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
