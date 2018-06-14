package com.company;

import java.util.List;

public class LibraryReadAll {

    public static void main(String[] args) {
        BookDao bookDao = new BookDao();
        List<Book> list = bookDao.readAllRecords();
        if (list == null) {
            System.out.println("Brak książek w bazie. ");
            return;
        }
        for (Book book : list) {
            System.out.println(book);
        }
        bookDao.close();
    }
}
