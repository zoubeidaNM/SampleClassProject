package com.company;

import java.util.ArrayList;

public class AddressBook {

    private ArrayList<Person> personsList;

    public AddressBook() {
        personsList = new ArrayList<Person>();
    }

    public AddressBook(ArrayList<Person> personsList) {
        this.personsList = personsList;
    }


    public ArrayList<Person> getPersonsList() {
        return personsList;
    }

    public void setPersonsList(ArrayList<Person> personsList) {
        this.personsList = personsList;
    }

    public void add(Person person) {
        personsList.add(person);
    }

    // search by first name
    public ArrayList<Person> searchByFirstName(String firstName) {
        ArrayList<Person> retList = new ArrayList<Person>();
        for (Person person : personsList) {
            if (person.getFirstName().contains(firstName)) {
                retList.add(person);
            }
        }
        return retList;


    }

    //serach by last name
    public ArrayList<Person> searchByLastName(String lastName) {
        ArrayList<Person> retList = new ArrayList<Person>();
        for (Person person : personsList) {
            if (person.getLastName().contains(lastName)) {
                retList.add(person);
            }
        }
        return retList;

    }

    //search by address
    public ArrayList<Person> searchByAddress(String address) {

        ArrayList<Person> retList = new ArrayList<Person>();
        for (Person person : personsList) {
            if (person.getAddress().contains(address)) {
                retList.add(person);
            }
        }
        return retList;
    }

    //search by phone number
    public ArrayList<Person> searchByPhoneNumber(String phoneNumber) {

        ArrayList<Person> retList = new ArrayList<Person>();
        for (Person person : personsList) {
            if (person.getPhoneNumber().contains(phoneNumber)) {
                retList.add(person);
            }
        }
        return retList;
    }

    //search by email
    public ArrayList<Person> searchByEmail(String email) {

        ArrayList<Person> retList = new ArrayList<Person>();
        for (Person person : personsList) {
            if (person.getEmail().contains(email)) {
                retList.add(person);
            }
        }
        return retList;
    }

    //search any string
    public ArrayList<Person> searchAll(String str) {

        ArrayList<Person> retList = new ArrayList<Person>();
        retList.addAll(searchByFirstName(str));
        retList.addAll(searchByLastName(str));
        retList.addAll(searchByAddress(str));
        retList.addAll(searchByPhoneNumber(str));
        retList.addAll(searchByEmail(str));

        return retList;
    }

}
