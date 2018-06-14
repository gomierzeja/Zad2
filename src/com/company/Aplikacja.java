package com.company;

import java.util.Scanner;

public class Aplikacja {

    public static void main(String[] args) {
        System.out.println("Wybierz opcje: ");
        System.out.println("1 - Dodaj nowy rekord");
        System.out.println("2 - Wyświetl wszystkie książki");
        System.out.println("3 - Usuwanie");
        System.out.println("4 - Aktualizacja");

        Scanner scanner = new Scanner(System.in);
        switch(scanner.nextInt()) {
            case 1:
                LibrarySave.main(args);
                break;
            case 2:
                LibraryReadAll.main(args);
                break;
            case 3:
                LibraryDelete.main(args);
                break;
            case 4:
                LibraryUpdate.main(args);
                break;
        }
        Aplikacja.main(args);

        }

}
