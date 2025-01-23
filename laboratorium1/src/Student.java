import java.util.ArrayList;
import java.util.List;

public class Student extends Person {


    public enum Major {
        MATEMATYKA,
        INFORMATYKA,
        TELEKOMUNIKACJA
    }

    private long index;
    private double avgGrade;
    private Major vocation;
    private List<Short> grades;


    private static long indexNumerator = 1;


    public Student(String name, Major vocation) {
        super(name);
        this.vocation = vocation;
        this.index = indexNumerator++;
        this.grades = new ArrayList<>();
        this.avgGrade = 0.0;
    }

    public long getIndex() {
        return index;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public Major getVocation() {
        return vocation;
    }

    public List<Short> getGrades() {
        return grades;
    }


    public void addGrade(short grade) {
        grades.add(grade);
        double sum = 0.0;
        for (Short g : grades) {
            sum += g;
        }
        this.avgGrade = sum / grades.size();
    }


    @Override
    public String toString() {
        return "Student: " + getName() + "\n"
                + "Index: " + index + "\n"
                + "Kierunek: " + vocation + "\n"
                + "Średnia ocen: " + String.format("%.2f", avgGrade) + "\n"
                + "Oceny: " + grades + "\n";
    }
}
