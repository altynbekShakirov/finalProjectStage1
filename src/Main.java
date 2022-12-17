import enums.Gender;
import enums.Genre;
import enums.Language;
import model.Book;
import model.User;
import service.BookService;
import service.serviceImpl.BookServiceImpl;
import service.serviceImpl.UserService;

import java.awt.*;
import java.math.BigDecimal;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private  static  List<Book>books= new ArrayList<>();
    private  static  List<User>users= new ArrayList<>();
    private static  List<Book>userBook=new ArrayList<>();
    private static BookServiceImpl book= new BookServiceImpl();
    private static UserService user= new UserService();
    private static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) {

        // Бардык Id лер уникальный болуш керек. Эгер уникальный болбосо озубуз тузгон UniqueConstraintException класс ыргытсын.
        // User дин email адресси уникальный болуш керек жана @ болуусу керек. Эгер уникальный болбосо UniqueConstraintException класс,
        // @ болбосо озубуз тузгон BadRequestException класс ыргытсын.
        // User дин телефон номери +996 дан башталып 13 символдон турсун. Болбосо BadRequestException класс ыргытсын.
        // Китептин баасы терс сан болбошу керек. Болбосо NegativeNumberException ыргытсын.
        // Китептин чыккан жылы келечек убакыт болбошу керек.Болбосо DateTimeException ыргытсын.
        // Китептин автору бош болбошу керек. Болбосо EmptyStackException ыргытсын.

        users= new ArrayList<>(Arrays.asList(
                new User(11L,"Altynbek","Shakirov","Altynbek@gmail.com","+996507017588", Gender.MALE,new BigDecimal(900000000)),
                new User(13L,"Yryskeldi","Alymbekov","Yrskeldi@gmail,com","+99655555555", Gender.MALE,new BigDecimal(10000000)),
                new User(88888L,"Aigerim","Bektenova","Aika@gmail.com","+99677777777", Gender.FEMALE ,new BigDecimal(400000)),
                new User(1243121L,"Kurstan","Erikinbev","Kurstan@gmail.com","+99690999999", Gender.MALE,new BigDecimal(2000000)),
                new User(1243121L,"Aijamal ","Asangazieva","aijamal@gmail.com","+9963333333", Gender.FEMALE,new BigDecimal(20000)),
                new User(1243121L,"Rakhim","Bazarbaiev","Rakhim@gmail.com","+9966066666", Gender.MALE,new BigDecimal(5000000)),
                new User(1243121L,"Mukhammed","Toichubau uulu","Asantegin@gmail.com","+99602222222", Gender.MALE,new BigDecimal(3000000))
        ));
        books= new ArrayList<>(Arrays.asList(
                new Book(62623453L,"Syngan Kylych", Genre.ROMANCE,new BigDecimal(5000),"Tologon Kasymbekov", Language.KYRGYZ, LocalDate.of(1990,9,12)),
                new Book(3535523L,"Prisluga", Genre.DETECTIVE,new BigDecimal(2000),"Кэтрин Стокетт", Language.RUSSIAN, LocalDate.of(2020,9,12)),
                new Book(234525243L,"Kanybek", Genre.HISTORICAL,new BigDecimal(6000),"Касымалы Жантошев", Language.KYRGYZ, LocalDate.of(2014,9,12)),
                new Book(744656174L,"Ak Keme", Genre.ROMANCE,new BigDecimal(4000),"Chyngyz Aiytmatov", Language.KYRGYZ, LocalDate.of(1990,9,12)),
                new Book(568545675L,"Svita koralya", Genre.DETECTIVE,new BigDecimal(3000),"Nora Skavich", Language.ENGLISH, LocalDate.of(2000,9,12)),
                new Book(986438673L,"Gari Poter", Genre.FANTASY,new BigDecimal(2000),"Joan Rouling", Language.ENGLISH, LocalDate.of(2016,9,12)),
                new Book(135232111L,"Sherlok Holms", Genre.FANTASY,new BigDecimal(10000),"Artur Konan Doil", Language.ENGLISH, LocalDate.of(1990,9,12)),
                new Book(125743253L,"Remark", Genre.DETECTIVE,new BigDecimal(2500),"Tologon Kasymbekov", Language.ENGLISH, LocalDate.of(2013,9,12)),
                new Book(797989999L,"Zelonaya milya", Genre.HISTORICAL,new BigDecimal(5500),"Stiven King", Language.RUSSIAN, LocalDate.of(2022,9,12))
        ));
        command();

    }
    public static void command(){
        book.setBooks(books);
        user.setUserList(users);
        while (true) {
            System.out.println("""
                            COMANDS
                    1.Create User
                    2.Create Book
                    3.Get all books
                    4.Find all users
                    5.Find user by id
                    6.Remove user by name
                    7.Update user
                    8.Group users by gender
                    9.Buy books
                    10.Get all books
                    11.Get books by genre
                    12.Remove book by id
                    13.Sort books by price in descending order
                    14.Filter books by published year
                    15. Get book by initial letter
                    16.Max price book
                    """);

            int knopka = scanner.nextInt();
            switch (knopka) {
                case 1 -> {
                    System.out.println(user.createUser(users));
                }
                case 2 -> {
                    System.out.println(book.createBooks(books));
                }
                case 3 -> {
                    book.getAllBooks().forEach(System.out::println);
                }
                case 4 -> {
                    user.findAllUsers().forEach(System.out::println);
                }
                case 5 -> {
                    System.out.println("id: ");
                    Long id = scanner.nextLong();
                    user.findUserById(id);
                }
                case 6 -> {
                    System.out.println("Name: ");
                    String name = scanner.next();
                    System.out.println(user.removeUserByName(name));
                }
                case 7 -> {
                    System.out.println("Id: ");
                    Long id = scanner.nextLong();
                    user.updateUser(id);
                }
                case 8 -> {
                    user.groupUsersByGender();
                }
                case 9 -> {
                    String name = scanner.next();
                    System.out.println(user.buyBooks(name, userBook));
                }
                case 10 -> {
                    System.out.println(book.getAllBooks());
                }
                case 11 -> {
                    String genre = scanner.nextLine();
                    book.getBooksByGenre(genre);
                }
                case 12 -> {
                    System.out.print("id:");
                    Long id = scanner.nextLong();
                    System.out.println(book.removeBookById(id));
                }
                case 13 -> {
                    System.out.println(book.sortBooksByPriceInDescendingOrder());
                }
                case 14 -> {
                    System.out.println(book.filterBooksByPublishedYear());
                }
                case 15 -> {
                    System.out.println(book.getBookByInitialLetter());
                }
                case 16 -> {
                    System.out.println(book.maxPriceBook());
                }
            }
        }






    }

}