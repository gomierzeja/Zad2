package com.company;

import java.util.Scanner;

public class LibrarySave {

    public static void main(String[] args) {
        Book book = new Book();
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Podaj tytuł: ");
        book.setTitle(odczyt.nextLine());

        System.out.println("Podaj autora: ");
        book.setAuthor(odczyt.nextLine());

        System.out.println("Podaj year: ");
        book.setYear(odczyt.nextInt());

        System.out.println("Podaj ISBN: ");
        book.setIsbn(odczyt.nextInt());

        BookDao bookDao = new BookDao();
        bookDao.save(book);
        bookDao.close();
        System.out.println("Książka została zapisana. ");

    }
}

