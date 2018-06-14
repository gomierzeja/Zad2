package com.company;

import java.util.Scanner;

public class LibraryUpdate {

    public static void main(String[] args) {

        Book book1 = new Book();

        Scanner odczyt = new Scanner(System.in);
        System.out.println("Podaj ISBN książki do aktualizacji:");
        book1.setIsbn(odczyt.nextInt());
        odczyt.nextLine();

        System.out.println("Podaj tytuł książki do aktualizacji: ");
        book1.setTitle(odczyt.nextLine());

        System.out.println("Podaj autora książki do aktualizacji: ");
        book1.setAuthor(odczyt.nextLine());

        System.out.println("Podaj rok wydania książki do aktualizacji: ");
        book1.setYear(odczyt.nextInt());

        BookDao bookDao = new BookDao();
        bookDao.updateByIsbn(book1);

        System.out.println("Książka zaktualizowana.");

    }
}
