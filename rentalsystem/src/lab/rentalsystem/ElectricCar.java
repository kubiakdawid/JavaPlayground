package lab.rentalsystem;

public class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(int id, String name, VehicleStatus status, int numberOfSeats, int batteryCapacity) {
        super(id, name, status, numberOfSeats);
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public String displayDetails() {
        return "Electric Car [ID: " + getId() + ", Name: " + getName() +
                ", Status: " + getStatus() + ", Seats: " + getNumberOfSeats() +
                ", Battery Capacity: " + batteryCapacity + " kWh]";
    }
}
