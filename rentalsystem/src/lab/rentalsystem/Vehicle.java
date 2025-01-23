package lab.rentalsystem;

public abstract class Vehicle {
    private int id;
    private String name;
    private VehicleStatus status;

    public Vehicle(int id, String name, VehicleStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public abstract String displayDetails();
}
