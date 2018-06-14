package com.company;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "gomierzeja";
    private static final String PASS = "Nusianusia123@";
    private Connection connection;

    public BookDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }
    }

    public Book readByIsbn(int isbn) {
        final String sql = "select idbooks, author, title, year, isbn from books where isbn = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setLong(1, isbn);
            ResultSet result = prepStmt.executeQuery();
            if (result.next()) {
                return convertResultToBook(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not get book");
        }
        return null;
// lub ElementNotFoundException
    }

    private Book convertResultToBook(ResultSet result) throws SQLException{
        Book book = new Book();
        book.setId(result.getInt("idbooks"));
        book.setAuthor(result.getString("author"));
        book.setTitle(result.getString("title"));
        book.setYear(result.getInt("year"));
        book.setIsbn(result.getInt("isbn"));
        return book;
    }

    public void save(Book book) {
        final String sql = "insert into books(author, title, year, isbn) values(?, ?, ?, ?)";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, book.getAuthor());
            prepStmt.setString(2, book.getTitle());
            prepStmt.setInt(3, book.getYear());
            prepStmt.setInt(4, book.getIsbn());

            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not save record");
            e.printStackTrace();
        }
    }

    public void updateByIsbn(Book book) {
        final String sql = "update books set author=?, title=?, year=?, isbn=? where isbn = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, book.getAuthor());
            prepStmt.setString(2, book.getTitle());
            prepStmt.setInt(3, book.getYear());
            prepStmt.setInt(4, book.getIsbn());
            prepStmt.setLong(5, book.getIsbn());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not update record");
        }
    }

    public void deleteByIsbn(int isbn) {
        final String sql = "delete from books where isbn = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setLong(1, isbn);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not delete row");
        }
    }

    public List readAllRecords() {
        final String sql = "select * from books";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            //zwraca obiekt na ktorym trzeba wykonac .executeQuery aby dostac dane z bazy
            ResultSet result = prepStmt.executeQuery();
            ArrayList<Book> list = new ArrayList<>();
            while(result.next()) {
                list.add(convertResultToBook(result));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not get book");
        }
        return null;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
