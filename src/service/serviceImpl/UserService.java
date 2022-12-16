package service.serviceImpl;

import enums.Gender;
import model.Book;
import model.User;

import javax.xml.crypto.dsig.XMLObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService implements service.UserService {

    private List<User>userList= new ArrayList<>();

    @Override
    public String createUser(List<User> users) {

        return "Adam koshuldu";
    }

    @Override
    public List<User> findAllUsers() {

        userList.forEach(System.out::println);
        return null;
    }

    @Override
    public User findUserById(Long id) {
        Scanner scanner = new Scanner(System.in);
        id =scanner.nextLong();
        for (User u:userList) {
            if (id==u.getId())
                System.out.println(u);

        }
        return null;
    }

    @Override
    public String removeUserByName(String name) {
        Scanner scanner= new Scanner(System.in);
        String name1= scanner.nextLine();
        for (User u:userList) {
            if (name1==u.getName()){
                userList.remove(u);
            }
        }

        return null;
    }

    @Override
    public void updateUser(Long id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                1.name
                2.surname
                3.emial
                4.Phone Number
                5.gender 
                6.money 
                7.books 
                """);
        int num= scanner.nextInt();
        switch (num){
            case 1:
                for (User u:userList) {


                }
                break;

        }

    }

    @Override
    public void groupUsersByGender() {

    }

    @Override
    public String buyBooks(String name, List<Book> books) {
        Scanner scanner= new Scanner(System.in);
        name=scanner.nextLine();
        for (Book b:books){
            if(name.contains(b.getName())){
                System.out.println(b);
            }
        }
        return null;
    }
}
