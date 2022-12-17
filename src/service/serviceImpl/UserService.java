package service.serviceImpl;

import enums.Gender;
import enums.Genre;
import model.Book;
import model.User;

import javax.xml.crypto.dsig.XMLObject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class UserService implements service.UserService {
    private static Scanner scanner = new Scanner(System.in);

    private List<User> userList = new ArrayList<>();


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String createUser(List<User> users) {

            System.out.println("Write  id:");
            long id = scanner.nextLong();
            System.out.println("Write user name:");
            String name = scanner.nextLine();
            System.out.println("Write surname:");
            String surname = scanner.nextLine();
            System.out.println("Write email :");
            String email = scanner.nextLine();
            System.out.println("Write phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.println("Write gender:");
            String gender = scanner.nextLine();
            System.out.println("Write money:");
            BigDecimal bigDecimal = scanner.nextBigDecimal();



                for (User user1 : userList) {
                    if (phoneNumber.trim().startsWith("+996") && phoneNumber.length() == 13) {
                        if (!(email.trim().equalsIgnoreCase(user1.getEmail()))) {
                            if (email.contains("@")) {
                                if (!(id == user1.getId())) {
                                    userList.add(new User(id, name, surname, email, phoneNumber, Gender.valueOf(gender.toLowerCase()), bigDecimal));


                                }
                            }
                        }

                    }
                }


                return "Successfully saved!";
            }


    @Override
    public List<User> findAllUsers() {


        return userList;
    }

    @Override
    public User findUserById(Long id) {

        for (User u : userList) {
            if (id.equals(u.getId()))
                System.out.println(u);

        }
        return null;
    }

    @Override
    public String removeUserByName(String name) {
        for (User u : userList) {
            if (name.equalsIgnoreCase(u.getName())) {
                userList.remove(u);
                break;
            }
        }

        return "user removed";
    }

    @Override
    public void updateUser(Long id) {
        for (User user : userList) {
            if (id.equals(user.getId())) {
                System.out.println("""
                1.name
                2.surname
                3.email
                4.Phone Number
                5.gender 
                6.money 
               
                """);
                System.out.print(".");
                int num = scanner.nextInt();

                switch (num) {
                    case 1:
                        String name1 = scanner.next();
                        user.setName(name1);
                        break;
                    case 2:
                        String surname= scanner.next();
                        user.setSurname(surname);
                        break;
                    case 3:
                        String email= scanner.next();
                        if (email.contains("@")){
                              user.setEmail(email);
                        }
                        break;
                    case 4:
                        String number= scanner.next();
                        if (number.startsWith("+996")){
                            user.setPhoneNumber(number);
                        }
                        break;
                    case 5:
                        String gender= scanner .next();
                        user.setGender(Gender.valueOf(gender.toUpperCase()));
                        break;
                    case 6:
                        double price= scanner.nextDouble();
                        user.setMoney(new BigDecimal(price));
                        break;
                }
            }
        }
    }

    @Override
    public void groupUsersByGender() {
        System.out.println("Female");
             userList.stream().filter(a -> a.getGender().equals(Gender.FEMALE)).forEach(System.out::println);
        System.out.println("Male");
           userList.stream().filter(a -> a.getGender().equals(Gender.MALE)).forEach(System.out::println);

    }

    @Override
    public String buyBooks(String name, List<Book> books) {
        for (User u: userList) {
            if (name.equalsIgnoreCase(u.getName())) {
                   for (Book b:books ){
                       System.out.println(books);
                       System.out.println("Algyn kelgen kiteptin atyn jaz");
                       String name1=scanner.next();
                       if(name1.equalsIgnoreCase(b.getName())){
                           u.getBooks().add(b);
                       }
                   }
               }
        }
        return "Successfully by added!";
    }
}
