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
                case 1:
                    printHeader();
                    for(int i=0; i<this.petList.size();i++){
                        printPet(this.petList.get(i));
                    }
                    printFooter();
                    break;
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
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
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
