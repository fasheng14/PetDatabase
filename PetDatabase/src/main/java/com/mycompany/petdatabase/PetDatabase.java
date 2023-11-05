/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.petdatabase;

import java.util.*;

/**
 *
 * @author fashe
 */
public class PetDatabase {
    
    private ArrayList<Pet> petList = new ArrayList<>();
    private int rowsPrinted = 0;
   
    
    //add pet method
    public void addPet(String input){
        //split input by white space, create pet object with info from user, and add to hashmap.
        String[] splitInput = input.split("\\s+");
        this.petList.add(new Pet(splitInput[0], Integer.parseInt(splitInput[1])));
    }
    
    //print table header
    public void printHeader(){
        System.out.println("+-------------------------+");
        System.out.print("| ");
        System.out.printf("%3.3s","ID");
        System.out.print(" | ");
        System.out.printf("%10.10s","NAME");
        System.out.print(" | ");
        System.out.printf("%4.4s","AGE");
        System.out.print(" |\n");
        System.out.println("+-------------------------+");
    }
    
    //print pet row given
    public void printPet(Pet pet){
        System.out.print("| ");
        System.out.printf("%3.3s",petList.indexOf(pet));
        System.out.print(" | ");
        System.out.printf("%10.10s",pet.getName());
        System.out.print(" | ");
        System.out.printf("%4.4s",pet.getAge());
        System.out.print(" |\n");
        this.rowsPrinted++;
    }
    
    //print table footer
    public void printFooter(){
        System.out.println("+-------------------------+");
        System.out.println(this.rowsPrinted + " rows in set.");
        this.rowsPrinted = 0;
    }
    
    public void run(){
        boolean repeat = true;
        while (repeat==true){
            Scanner myScanner = new Scanner(System.in);
            System.out.println("""
                               What would you like to do? 
                               1) View all pets 
                               2) Add more pets 
                               3) Update an existing pet 
                               4) Remove an existing pet 
                               5) Search pets by name 
                               6) Search pets by age 
                               7) Exit prgram 
                               Your choice: """);
            
            int choice = myScanner.nextInt();
            
            switch (choice) {
                //print all pets
                case 1:
                    printHeader();
                    for(int i=0; i<this.petList.size();i++){
                        printPet(this.petList.get(i));
                    }
                    printFooter();
                    break;
                    
                //add pets
                case 2:
                    boolean addMore = true;
                    String userInput;
                    //get user input
                    while(addMore==true){
                        Scanner userScanner = new Scanner(System.in);
                        System.out.println("add pet (name, age): ");
                        userInput = userScanner.nextLine();
                        if(userInput.equals("done")){
                            addMore=false;
                        }
                        else{
                            addPet(userInput);
                        }
                    }
                    break;
                    
                //update existing pet
                case 3:
                    int updatePet;
                    String newInfo;
                    Scanner updateScanner = new Scanner(System.in);
                    Scanner infoScanner = new Scanner(System.in);
                    System.out.println("Enter the pet ID to update: ");
                    updatePet = updateScanner.nextInt();
                    
                    System.out.println("Enter new name and new age: ");
                    newInfo = infoScanner.nextLine();
                    String[] splitInfo = newInfo.split("\\s+");
                    this.petList.get(updatePet).setName(splitInfo[0]);
                    this.petList.get(updatePet).setAge(Integer.parseInt(splitInfo[1]));
                    break;

                    
                //delete pet
                case 4:
                    int delPet;
                    Scanner delScanner = new Scanner(System.in);
                    System.out.println("Enter the pet ID to remove: ");
                    delPet = delScanner.nextInt();
                    System.out.println(this.petList.get(delPet).getName() + " " + this.petList.get(delPet).getAge() + " is removed.");
                    this.petList.remove(this.petList.get(delPet));
                    break;
                    
                //search by name
                case 5:
                    String nameInput;
                    Scanner nameScanner = new Scanner(System.in);
                    System.out.println("Enter a name to search: ");
                    nameInput = nameScanner.nextLine();
                    printHeader();
                    for(int i=0;i<this.petList.size();i++){
                        if(this.petList.get(i).getName().equals(nameInput)){
                            printPet(this.petList.get(i));
                        }
                    }
                    printFooter();
                    break;
                
                //search by age
                case 6:
                    int ageInput;
                    Scanner ageScanner = new Scanner(System.in);
                    System.out.println("Enter an age to search: ");
                    ageInput = ageScanner.nextInt();
                    printHeader();
                    for(int i=0;i<this.petList.size();i++){
                        if(this.petList.get(i).getAge()==ageInput){
                            printPet(this.petList.get(i));
                        }
                    }
                    printFooter();
                    break;
                case 7:
                    repeat = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        new PetDatabase().run();
    }
}
