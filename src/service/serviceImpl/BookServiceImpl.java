package service.serviceImpl;

import model.Book;
import model.User;
import service.BookService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookServiceImpl implements BookService {
    private static Scanner scanner= new Scanner(System.in);
    private  List<Book>books= new ArrayList<>();



    @Override
    public List<Book> createBooks(List<Book> books) {


        return books;
    }

    @Override
    public List<Book> getAllBooks() {

        return books;
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        for (Book b:books) {
            if (genre.equals(b.getGenre())){
                System.out.println( b.getGenre());
            }
        }

        return null;


    }

    @Override
    public Book removeBookById(Long id) {


        System.out.println("Id: ");
        id=scanner.nextLong();
        for (Book b:books) {
            if (id == b.getId()) {

                books.remove(b);
            }



        }
        return null;
    }

    @Override
    public List<Book> sortBooksByPriceInDescendingOrder() {

        List<Book> sortedList = books.stream().sorted().collect(Collectors.toList());

        sortedList.forEach(System.out::println);


        return null;
    }

    @Override
    public List<Book> filterBooksByPublishedYear() {



        return null;
    }

    @Override
    public List<Book> getBookByInitialLetter() {
        System.out.println("Name Book: ");
        String nameBook= scanner.nextLine();
        for (Book b:books) {
            if (nameBook.contains(b.getName())){
                System.out.println(b);

            }

        }
        return null;
    }

    @Override
    public Book maxPriceBook() {

     books.stream().sorted(Comparator.comparing(Book::getPrice)).forEach(System.out::println);





        return null ;
    }


}
