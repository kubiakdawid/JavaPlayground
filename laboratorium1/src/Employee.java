public class Employee extends Person {

    public enum Position {
        ASYSTENT,
        ADIUNKT,
        PROFESOR
    }

    private int salary;
    private Position occupation;


    public Employee(String name, int salary) {
        super(name);
        this.salary = salary;
        this.occupation = Position.ASYSTENT;
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return occupation;
    }


    public void promote() {
        switch (this.occupation) {
            case ASYSTENT:
                this.occupation = Position.ADIUNKT;
                break;
            case ADIUNKT:
                this.occupation = Position.PROFESOR;
                break;

            default:
                break;
        }
    }


    @Override
    public String toString() {
        return "Pracownik: " + getName() + "\n"
                + "Pensja: " + salary + "\n"
                + "Etat: " + occupation + "\n";
    }
}