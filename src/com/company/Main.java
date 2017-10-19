package com.company;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.lang.*;

public class Main {

    public static void main(String[] args) {

        //instantiate an AddressBook object
        AddressBook addressBook = new AddressBook();


        File file = new File("/home/student/IdeaProjects/SampleClassProject/src/com/company/AddressBook.txt");


        String answer = "";

        Scanner fileScanner;
        Scanner keyboard = new Scanner(System.in);

        try {
            fileScanner = new Scanner(file);
            int counter = 0;

            do {

                // create a person
                Person newPerson = new Person();

                //System.out.print("Enter person's first name: ");
                //newPerson.setFirstName(keyboard.nextLine());
                //System.out.print("Enter person's last name: ");
                //newPerson.setLastName(keyboard.nextLine());
                //System.out.print("Enter person's address: ");
                //newPerson.setAddress(keyboard.nextLine());
                //System.out.print("Enter person's phone number: ");
                //newPerson.setPhoneNumber(keyboard.nextLine());
                //System.out.print("Enter person's email: ");
                //newPerson.setEmail(keyboard.nextLine());

                newPerson.setFirstName(fileScanner.nextLine());
                //System.out.print("Enter person's last name: ");
                newPerson.setLastName(fileScanner.nextLine());
                //System.out.print("Enter person's address: ");
                newPerson.setAddress(fileScanner.nextLine());
                //System.out.print("Enter person's phone number: ");
                newPerson.setPhoneNumber(fileScanner.nextLine());
                //System.out.print("Enter person's email: ");
                newPerson.setEmail(fileScanner.nextLine());

                counter++;
                System.out.println("Read person record number " + counter);

                // add the person to the address book
                addressBook.add(newPerson);

                // ask the person if he want to continue
                System.out.print("Do you to continue (Y/N)?");
                // make sure that the user answer is valid
                do {
                    // get the answer from the user
                    answer = keyboard.next();
                    keyboard.nextLine();
                } while (!checkIfAnswerValid(answer));


            } while (answer.equalsIgnoreCase("y") && (fileScanner.hasNextLine()));

            fileScanner.close();

        } catch (Exception ex) {
            System.out.println("file AddressBook.txt not found");
        }


        // print the person's records stored in the personDirectory list
        for (Person person : addressBook.getPersonsList()) {

            System.out.println("-----------------------------------------------------");

            System.out.println(person.toString());
        }

        //search the lis by first name, last name, address, email, phoneNumber
        System.out.println("Do you want to search the address book (Y/N)");
        answer = keyboard.next();
        keyboard.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            do {
                System.out.println("Press (S) to search by a matching string or");
                System.out.println("press (F) to search by first name, press (L) to search by last name,");
                System.out.println("press (A) to search by address, press (P) to search by phone number, ");
                System.out.println("press (E) to search by email or (Q) to quit.");

                answer = keyboard.next();
                keyboard.nextLine();

                if (answer.equalsIgnoreCase("f")) {
                    ArrayList<Person> personList = new ArrayList<Person>();
                    System.out.println("Enter first name to be searched: ");
                    String firstName = keyboard.nextLine();
                    personList = addressBook.searchByFirstName(firstName);
                    if (personList.size() == 0) {
                        System.out.println("\n****No match found to the first name + (" + firstName + ") you entred.\n");
                    } else {
                        for (Person person : personList) {
                            System.out.println("-----------------------------------------------------");

                            System.out.println(person.toString());
                        }


                    }

                } else if (answer.equalsIgnoreCase("l")) {
                    ArrayList<Person> personList = new ArrayList<Person>();
                    System.out.println("Enter last name to be searched: ");
                    String lastName = keyboard.nextLine();
                    personList = addressBook.searchByLastName(lastName);
                    if (personList.size() == 0) {
                        System.out.println("\n*****No match found to the last name + (" + lastName + ") you entred.\n");
                    } else {
                        for (Person person : personList) {
                            System.out.println("-----------------------------------------------------");

                            System.out.println(person.toString());
                        }


                    }

                } else if (answer.equalsIgnoreCase("a")) {
                    ArrayList<Person> personList = new ArrayList<Person>();
                    System.out.println("Enter address to be searched: ");
                    String address = keyboard.nextLine();
                    personList = addressBook.searchByAddress(address);
                    if (personList.size() == 0) {
                        System.out.println("\n*****No match found to the address + (" + address + ") you entred.\n");
                    } else {
                        for (Person person : personList) {
                            System.out.println("-----------------------------------------------------");

                            System.out.println(person.toString());
                        }


                    }

                } else if (answer.equalsIgnoreCase("p")) {
                    ArrayList<Person> personList = new ArrayList<Person>();
                    System.out.println("Enter phone number to be searched: ");
                    String phoneNumber = keyboard.nextLine();
                    personList = addressBook.searchByPhoneNumber(phoneNumber);
                    if (personList.size() == 0) {
                        System.out.println("\n*****No match found to the phone number + (" + phoneNumber + ") you entred.\n");
                    } else {
                        for (Person person : personList) {
                            System.out.println("-----------------------------------------------------");

                            System.out.println(person.toString());
                        }


                    }

                } else if (answer.equalsIgnoreCase("e")) {
                    ArrayList<Person> personList = new ArrayList<Person>();
                    System.out.println("Enter email address to be searched: ");
                    String email = keyboard.nextLine();
                    personList = addressBook.searchByEmail(email);
                    if (personList.size() == 0) {
                        System.out.println("\n*****No match found to the email address + " + email + " you entred.\n");
                    } else {
                        for (Person person : personList) {
                            System.out.println("-----------------------------------------------------");

                            System.out.println(person.toString());
                        }


                    }

                } else if (answer.equalsIgnoreCase("s")) {
                    ArrayList<Person> personList = new ArrayList<Person>();
                    System.out.println("Enter string to be searched: ");
                    String str = keyboard.nextLine();
                    personList = addressBook.searchAll(str);
                    if (personList.isEmpty()) {
                        System.out.println("\n*****No match found to the string + " + str + " you entred.\n");
                    } else {
                        for (Person person : personList) {
                            System.out.println("-----------------------------------------------------");

                            System.out.println(person.toString());
                        }


                    }

                }
            } while (!answer.equalsIgnoreCase("q"));


        }
    }

    // check if the answer is Yes [y,Y] or no [n,N]
    public static boolean checkIfAnswerValid(String answer) {

        if ((answer.equalsIgnoreCase("y")) || (answer.equalsIgnoreCase("n"))) {
            return true;
        } else {
            // ask the user to enter a valid answer
            System.out.println("Please, answer [y]or[Y] for Yes or [n]or[N] for No.\n");
            return false;
        }
    }


}
