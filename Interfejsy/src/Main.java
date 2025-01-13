import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MyList myList = new MyList(0);

        BinarySearchTree bst = new BinarySearchTree("BST1", 0);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n__ Wybierz program __ ");
            System.out.println("1. Operacje na liście");
            System.out.println("2. Operacje na drzewie BST");
            System.out.println("3. Koniec");
            System.out.print(">>> ");

            int mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    listMenu(myList, scanner);
                    break;

                case 2:
                    bstMenu(bst, scanner);
                    break;

                case 3:
                    running = false;
                    System.out.println("Koniec");
                    break;

                default:
                    System.out.println("Nie ma takiego numeru");
            }
        }

        scanner.close();
    }


    private static void listMenu(MyList myList, Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("\n__ Operacje na liście __");
            System.out.println("1. Dodaj element na koniec listy");
            System.out.println("2. Wyświetl aktualny stan listy");
            System.out.println("3. Posortuj listę");
            System.out.println("4. Wyświetl największy element na liście");
            System.out.println("5. Wyświetl najmniejszy element na liście");
            System.out.println("6. Wyczyść listę (i ustaw pierwszy element)");
            System.out.println("7. Powrót do głównego menu");
            System.out.print(">>> ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Podaj liczbę, którą chcesz dodać: ");
                    double val = scanner.nextDouble();
                    myList.add(val);
                    System.out.println("Dodano " + val + " do listy.");
                    break;

                case 2:
                    System.out.println("Aktualny stan listy: " + myList);
                    break;

                case 3:
                    myList.sort();
                    System.out.println("Lista została posortowana.");
                    break;

                case 4:
                    System.out.println("Największy element na liście: " + myList.max());
                    break;

                case 5:
                    System.out.println("Najmniejszy element na liście: " + myList.min());
                    break;

                case 6:
                    System.out.print("Podaj nową wartość dla pierwszego elementu listy: ");
                    double newFirstValue = scanner.nextDouble();
                    myList.clear(newFirstValue);
                    System.out.println("Lista została wyczyszczona i ustawiono: " + newFirstValue);
                    break;

                case 7:
                    running = false;
                    break;

                default:
                    System.out.println("Nie ma takiego numeru");
            }
        }
    }


    private static void bstMenu(BinarySearchTree bst, Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("\n__ Drzewo BST __");
            System.out.println("1. Dodaj element do drzewa BST");
            System.out.println("2. Wyświetl aktualny stan drzewa");
            System.out.println("3. Wyświetl największy element w BST");
            System.out.println("4. Wyświetl najmniejszy element w BST");
            System.out.println("5. Sprawdź, czy wartość istnieje w BST");
            System.out.println("6. Wyczyść drzewo (i ustaw wartość korzenia)");
            System.out.println("7. Powrót do głównego menu");
            System.out.print(">>> ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Podaj liczbę, którą chcesz dodać do BST: ");
                    double bstVal = scanner.nextDouble();
                    bst.add(bstVal);
                    System.out.println("Dodano " + bstVal + " do drzewa BST.");
                    break;

                case 2:
                    System.out.println("Aktualny stan drzewa BST: " + bst.toString());
                    break;

                case 3:
                    System.out.println("Największy element w BST: " + bst.max());
                    break;

                case 4:
                    System.out.println("Najmniejszy element w BST: " + bst.min());
                    break;

                case 5:
                    System.out.print("Podaj wartość, której chcesz szukać w BST: ");
                    double searchVal = scanner.nextDouble();
                    System.out.println("Wynik: " + bst.contains(searchVal));
                    break;

                case 6:
                    System.out.print("Podaj nową wartość dla korzenia drzewa BST: ");
                    double newRootValue = scanner.nextDouble();
                    bst.clear(newRootValue);
                    System.out.println("Wyczyszczono drzewo. Korzeń ma teraz wartość: " + newRootValue);
                    break;

                case 7:
                    running = false;
                    break;

                default:
                    System.out.println("Nie ma takiego numeru");
            }
        }
    }
}
