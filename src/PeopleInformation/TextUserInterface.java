/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeopleInformation;

import java.util.Scanner;

/**
 *
 * @author Davor
 */
public class TextUserInterface {

    private Scanner scan;
    private People people;

    public TextUserInterface(Scanner command) {
        this.scan = command;
        this.people = new People();
    }

    public void start() {
        System.out.println("phone search\n"
                + "available operations:\n"
                + " 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit");

        while (true) {
            System.out.println("");
            System.out.print("command: ");
            String command = this.scan.nextLine();
            if (command.trim().toLowerCase().equals("x")) {
                break;
            }
            if (command.trim().toLowerCase().equals("1")) {
                this.addNumber();
            }
            if (command.trim().toLowerCase().equals("2")) {
                this.findNumber();
            }
            if (command.trim().toLowerCase().equals("3")) {
                this.findPerson();
            }
            if (command.trim().toLowerCase().equals("4")) {
                this.addAddress();
            }
            if (command.trim().toLowerCase().equals("5")) {
                this.findInformation();
            }
            if (command.trim().toLowerCase().equals("6")) {
                this.deleteInformation();
            }
            if (command.trim().toLowerCase().equals("7")) {
                this.findKeyword();
            }
        }
    }

    public void addNumber() {
        System.out.print("whose number: ");
        String personName = this.scan.nextLine();
        System.out.print("number: ");
        String personNumber = this.scan.nextLine();
        this.people.addPhone(personName, personNumber);
    }

    public void findNumber() {
        System.out.print("whose number: ");
        String personName = this.scan.nextLine();
        this.people.findNumber(personName);
    }
    
    public void findPerson() {
        System.out.print("number: ");
        String number = this.scan.nextLine();
        this.people.findPerson(number);        
    }
    
    public void addAddress() {
        System.out.print("whose address: ");
        String personName = this.scan.nextLine();
        System.out.print("street: ");
        String street = this.scan.nextLine();
        System.out.print("city: ");
        String city = this.scan.nextLine();
        this.people.addAddress(personName, street, city);
    }
    
    public void findInformation() {
        System.out.print("whose information: ");
        String personName = this.scan.nextLine();
        this.people.findPersonAddress(personName);
        this.people.findPersonNumberEdited(personName);
    }
    
    public void deleteInformation() {
        System.out.print("whose information: ");
        String personName = this.scan.nextLine();
        this.people.removeInformation(personName);
    }
    
    public void findKeyword() {
        System.out.print("keyword (if empty, all listed: ");
        String keyword = this.scan.nextLine();
        this.people.findKeyword(keyword);
    }

}
