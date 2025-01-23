package lab.rentalsystem;

import java.util.*;

public class RentalSystemApp {
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            showMenu();
            int choice = getValidChoice(scanner, 1, 7);

            switch (choice) {
                case 1 -> addVehicle(scanner);
                case 2 -> removeVehicle(scanner);
                case 3 -> displayAllVehicles();
                case 4 -> displayVehiclesByType(scanner);
                case 5 -> searchVehiclesByName(scanner);
                case 6 -> rentAllRentableVehicles();
                case 7 -> running = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\nRental System Menu:");
        System.out.println("1. Add Vehicle");
        System.out.println("2. Remove Vehicle by ID");
        System.out.println("3. Display All Vehicles");
        System.out.println("4. Display Vehicles by Type");
        System.out.println("5. Search Vehicles by Name");
        System.out.println("6. Rent All Rentable Vehicles");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getValidChoice(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice < min || choice > max) {
                    throw new IllegalArgumentException("Invalid value. Please enter a number between " + min + " and " + max + ".");
                }
                return choice;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.print("Try again: ");
            }
        }
    }

    private static void addVehicle(Scanner scanner) {
        System.out.println("Select the type of vehicle to add:");
        System.out.println("1. Car");
        System.out.println("2. Truck");
        System.out.println("3. Motorcycle");
        System.out.println("4. Electric Car");
        System.out.println("5. Electric Bike");
        System.out.println("6. Scooter");
        System.out.print("Your choice: ");
        int typeChoice = getValidChoice(scanner, 1, 6);

        int id = nextId++;
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Status (AVAILABLE, RENTED, UNDER_MAINTENANCE): ");
        VehicleStatus status;
        try {
            status = VehicleStatus.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status. Defaulting to AVAILABLE.");
            status = VehicleStatus.AVAILABLE;
        }

        switch (typeChoice) {
            case 1 -> {
                System.out.print("Enter Number of Seats: ");
                int seats = getValidChoice(scanner, 1, 100);
                vehicles.add(new Car(id, name, status, seats));
            }
            case 2 -> {
                System.out.print("Enter Load Capacity (in tons): ");
                double loadCapacity = getValidPositiveDouble(scanner);
                vehicles.add(new Truck(id, name, status, loadCapacity));
            }
            case 3 -> {
                System.out.print("Enter Engine Capacity (in cc): ");
                int engineCapacity = getValidChoice(scanner, 50, 5000);
                vehicles.add(new Motorcycle(id, name, status, engineCapacity));
            }
            case 4 -> {
                System.out.print("Enter Number of Seats: ");
                int seats = getValidChoice(scanner, 1, 100);
                System.out.print("Enter Battery Capacity (in kWh): ");
                int batteryCapacity = getValidChoice(scanner, 1, 1000);
                vehicles.add(new ElectricCar(id, name, status, seats, batteryCapacity));
            }
            case 5 -> {
                System.out.print("Enter Max Range (in km): ");
                int maxRange = getValidChoice(scanner, 1, 1000);
                vehicles.add(new ElectricBike(id, name, status, maxRange));
            }
            case 6 -> {
                System.out.print("Enter Speed Limit (in km/h): ");
                int speedLimit = getValidChoice(scanner, 1, 200);
                vehicles.add(new Scooter(id, name, status, speedLimit));
            }
        }
        System.out.println("Vehicle added successfully: ID " + id);
    }

    private static double getValidPositiveDouble(Scanner scanner) {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine());
                if (value <= 0) {
                    throw new IllegalArgumentException("Value must be greater than zero.");
                }
                return value;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.print("Try again: ");
            }
        }
    }

    private static void removeVehicle(Scanner scanner) {
        System.out.print("Enter ID of vehicle to remove: ");
        int id = getValidChoice(scanner, 1, Integer.MAX_VALUE);
        boolean removed = vehicles.removeIf(v -> v.getId() == id);
        System.out.println(removed ? "Vehicle removed successfully." : "Vehicle with ID " + id + " not found.");
    }

    private static void displayAllVehicles() {
        System.out.println("\nAll Vehicles:");
        vehicles.forEach(v -> System.out.println(v.displayDetails()));
    }

    private static void displayVehiclesByType(Scanner scanner) {
        System.out.print("Enter type (Car, Truck, etc.): ");
        String type = scanner.nextLine();
        vehicles.stream().filter(v -> v.getClass().getSimpleName().equalsIgnoreCase(type)).forEach(v -> System.out.println(v.displayDetails()));
    }

    private static void searchVehiclesByName(Scanner scanner) {
        System.out.print("Enter name fragment to search: ");
        String fragment = scanner.nextLine();
        vehicles.stream().filter(v -> v.getName().toLowerCase().contains(fragment.toLowerCase())).forEach(v -> System.out.println(v.displayDetails()));
    }

    private static void rentAllRentableVehicles() {
        vehicles.stream().filter(v -> v instanceof Rentable).forEach(v -> System.out.println(((Rentable) v).rent()));
    }
}
    /*W tej wersji ulepszyliśmy walidacje wprowadzanych danych
    względem tego co pokazywaliśmy na spotkaniu */