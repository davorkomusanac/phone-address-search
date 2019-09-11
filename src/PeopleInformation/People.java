/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeopleInformation;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Davor
 */
public class People {

    private Map<String, Set<String>> peopleNumbers;
    private Map<String, Set<String>> peopleAddress;

    public People() {
        peopleNumbers = new HashMap<String, Set<String>>();
        peopleAddress = new HashMap<String, Set<String>>();
    }

    public void addPhone(String numberOwner, String number) {
        if (!this.peopleNumbers.containsKey(numberOwner)) {
            this.peopleNumbers.put(numberOwner, new HashSet<String>());
        }
        this.peopleNumbers.get(numberOwner).add(number);
    }

    public void findNumber(String numberOwner) {
        if (this.peopleNumbers.containsKey(numberOwner)) {
            for (String number : this.peopleNumbers.get(numberOwner)) {
                System.out.println(" " + number);
            }
        } else {
            System.out.print("  not found");
        }
    }

    public void findPerson(String number) {
        for (String person : this.peopleNumbers.keySet()) {
            if (this.peopleNumbers.get(person).contains(number)) {
                System.out.println(" " + person);
                return;
            }
        }
        System.out.println(" not found");
    }

    public void addAddress(String person, String street, String city) {
        if (!this.peopleAddress.containsKey(person)) {
            this.peopleAddress.put(person, new HashSet<String>());
        }
        this.peopleAddress.get(person).add(street + " " + city);
    }

    public void findPersonAddress(String person) {
        if (this.peopleAddress.containsKey(person)) {
            for (String address : this.peopleAddress.get(person)) {
                System.out.println("  " + "address: " + address);
            }
        } else if (!this.peopleAddress.containsKey(person) && !this.peopleNumbers.containsKey(person)) {
            System.out.println("  not found");
        } else if (!this.peopleAddress.containsKey(person)) {
            System.out.println("  address unknown");
        }
    }

    public void findPersonNumberEdited(String person) {
        if (this.peopleNumbers.containsKey(person)) {
            System.out.println("  " + "phone numbers:");
            for (String number : this.peopleNumbers.get(person)) {
                System.out.println("   " + number);
            }
        } else if (!this.peopleAddress.containsKey(person) && !this.peopleNumbers.containsKey(person)) {
            return;
        } else {
            System.out.println("  phone number not found");
        }
    }

    public void removeInformation(String person) {
        if (this.peopleNumbers.containsKey(person)) {
            this.peopleNumbers.remove(person);
        }
        if (this.peopleAddress.containsKey(person)) {
            this.peopleAddress.remove(person);
        }
    }

    public void findKeyword(String keyword) {
        Set<String> foundResults = new HashSet<String>();
        for (String person : this.peopleNumbers.keySet()) {
            if (person.contains(keyword)) {
                foundResults.add(person);
            }
        }
        for (String person : this.peopleAddress.keySet()) {
            if (person.contains(keyword)) {
                foundResults.add(person);
            }
        }
        for (String person : this.peopleAddress.keySet()) {
            for (String address : this.peopleAddress.get(person)) {
                if (address.contains(keyword)) {
                    foundResults.add(person);
                }                
            }
        }        
        if (foundResults.isEmpty()) {
            System.out.println(" keyword not found");
            return;
        }
        List<String> foundPeople = new ArrayList<String>(foundResults);
        Collections.sort(foundPeople);
        for (String person : foundPeople) {
            System.out.println("");
            System.out.println(" " + person);
            this.findPersonAddress(person);
            this.findPersonNumberEdited(person);
        }
    }

}
