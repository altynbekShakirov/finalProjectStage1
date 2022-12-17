package service.serviceImpl;

import enums.Genre;
import enums.Language;
import model.Book;
import service.BookService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class BookServiceImpl implements BookService {
    private static Scanner scanner = new Scanner(System.in);
    private List<Book> books = new ArrayList<>();


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public List<Book> createBooks(List<Book> books) {
        System.out.println("Id: ");
        Long id = scanner.nextLong();
        System.out.println("Name: ");
        String name = scanner.next();
        System.out.println("Genre: ");
        String genre = scanner.next();
        System.out.println("Price: ");
        double price = scanner.nextDouble();
        System.out.println("Author: ");
        String author = scanner.next();
        System.out.println("Language: ");
        String language = scanner.next();
        System.out.println("Published Year: ");
        LocalDate publishedYear = LocalDate.parse(scanner.next());
        for (Book book : books) {
            if (!(id.equals(book.getId()))) {
                books.add(new Book(id, name, Genre.valueOf(genre.toUpperCase()), new BigDecimal(price), author, Language.valueOf(language.toUpperCase()), publishedYear));
            }
        }


        return books;
    }

    @Override
    public List<Book> getAllBooks() {

        return books;
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {

        System.out.println("Genre: ");
        genre = scanner.nextLine();
        for (Book b : books) {
            if (genre.equals(b.getGenre())) {
                System.out.println(b);
            }
        }
        return null;
    }

    @Override
    public Book removeBookById(Long id) {
        for (Book b : books) {
            if (id== b.getId()) {
                System.out.println(b+"removed");
                books.remove(b);
               break;
            }
        }
        return null;
    }

    @Override
    public List<Book> sortBooksByPriceInDescendingOrder() {
        Comparator<Book> bookComparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        };
        return books.stream().sorted(bookComparator).toList();

    }

    @Override
    public List<Book> filterBooksByPublishedYear() {
        return books.stream().filter(x -> x.getPublishedYear().isAfter(LocalDate.now().minusYears(10))).toList();
    }

    @Override
    public List<Book> getBookByInitialLetter() {
        System.out.println("Name Book: ");
        String nameBook = scanner.nextLine();
        return books.stream().filter(x -> x.getName().startsWith(nameBook)).toList();
    }

    @Override
    public Book maxPriceBook() {
        Optional<Book> book=books.stream().max(Comparator.comparing(Book::getPrice));
        return (Book)books;

    }


}
