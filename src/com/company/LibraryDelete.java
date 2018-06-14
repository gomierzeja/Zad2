package com.company;

import java.util.Scanner;

public class LibraryDelete {

    public static void main(String[] args) {
        Book book = new Book();
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Podaj ISBN książki do usunięcia: ");

        BookDao bookDao = new BookDao();
        bookDao.deleteByIsbn(odczyt.nextInt());
        bookDao.close();
        System.out.println("Książka została usunięta.");

    }

}
