import java.util.*;

public class MyPhoneBook {

    Map<String, HashSet<String>> phoneBook = new HashMap<>();
    HashSet<String> phoneNumbers;


    public void addToPhoneBook(String surname, String phoneNumber) {
        if (phoneBook.containsKey(surname)) {
            phoneNumbers = phoneBook.get(surname);
            phoneNumbers.add(phoneNumber);
            phoneBook.put(surname, phoneNumbers);
        } else {
            phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(surname, phoneNumbers);
        }
    }

    public HashSet<String> getPhoneNumbers(String surname) {
        return phoneBook.get(surname);
    }


    public static void main(String[] args) {

        MyPhoneBook phoneBook = new MyPhoneBook();

        phoneBook.addToPhoneBook("Иванов", "+7 928 2010000");
        phoneBook.addToPhoneBook("Иванов", "+7 918 1111111");
        phoneBook.addToPhoneBook("Иванов", "+7 968 2222222");
        phoneBook.addToPhoneBook("Сидоров", "+7 928 3333333");
        phoneBook.addToPhoneBook("Сидоров", "+7 918 4444444");
        phoneBook.addToPhoneBook("Петров", "+7 928 5555555");


        System.out.println(phoneBook.getPhoneNumbers("Иванов"));
        System.out.println(phoneBook.getPhoneNumbers("Сидоров"));
        System.out.println(phoneBook.getPhoneNumbers("Петров"));


    }


}



