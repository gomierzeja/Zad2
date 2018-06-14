package com.company;

import java.util.List;
import java.util.Scanner;

public class LibraryRead {

    //wczytaj od użytkownika numer isbn książki i wczytaj na tej podstawie
    //książkę z bazy danych oraz wyświetl inforacje o niej w konsoli

    public static void main(String[] args) {
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Podaj ISBN: ");
        BookDao bookDao = new BookDao();
        Book book  =  bookDao.readByIsbn(odczyt.nextInt());
        bookDao.close();
        if (book != null) {
            System.out.println("Szukana książka: " + book);
        } else {
            System.out.println("Szukana książka nie istnieje w bazie. ");
        }
    }

}
