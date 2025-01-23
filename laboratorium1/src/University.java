public class University {
    public static void main(String[] args) {

        Person[] People = new Person[5];



        People[0] = new Student("Nowak", Student.Major.INFORMATYKA);
        People[1] = new Student("Kowalska", Student.Major.TELEKOMUNIKACJA);
        People[2] = new Student("Biernacki", Student.Major.MATEMATYKA);



        People[3] = new Employee("Kowalski", 3500);
        People[4] = new Employee("Nowak", 4200);


        for (int i = 0; i < People.length; i++) {
            if (People[i] instanceof Student) {
                Student s = (Student) People[i];
                short grade = (short) (6 - i);
                s.addGrade(grade);
            }
        }


        System.out.println("__pętla foreach__");
        for (Person p : People) {
            if (p instanceof Student) {
                System.out.println(p);
            }
        }

        System.out.println("__pętla while__");
        int index = 0;
        while (index < People.length) {
            if (People[index] instanceof Student) {
                System.out.println(People[index]);
            }
            index++;
        }
    }
}
