/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.petdatabase;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fashe
 */
public class PetDatabase {
    
    private ArrayList<Pet> petList = new ArrayList<>();
    private int rowsPrinted = 0;
    
    //load file and save contents into petList
    public void loadFile(String fileName){
        try {
            File myLoadFile = new File(fileName);
            Scanner fileLoadScanner = new Scanner(myLoadFile);
            while (fileLoadScanner.hasNextLine()){
                String data = fileLoadScanner.nextLine();
                System.out.println(data);
                addPet(data);
            }
            fileLoadScanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PetDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //truncate/delete contents in file then save pets to file
    public void saveFile(String fileName){
        try {
            File mySaveFile = new File(fileName);
            PrintWriter writer = new PrintWriter(fileName);
            for(int i=0;i<this.petList.size();i++){
                writer.println(this.petList.get(i).getName() + " " + this.petList.get(i).getAge());
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PetDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
    
    //run program
    public void run(){
        boolean repeat = true;
        loadFile("petFile.txt");
        while (repeat==true){
            Scanner myScanner = new Scanner(System.in);
            System.out.println("""
                               What would you like to do? 
                               1) View all pets 
                               2) Add more pets 
                               3) Remove an existing pet 
                               4) Exit prgram 
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
                
                //delete pet
                case 3:
                    int delPet;
                    Scanner delScanner = new Scanner(System.in);
                    System.out.println("Enter the pet ID to remove: ");
                    delPet = delScanner.nextInt();
                    System.out.println(this.petList.get(delPet).getName() + " " + this.petList.get(delPet).getAge() + " is removed.");
                    this.petList.remove(this.petList.get(delPet));
                    break;
                    
                //end program
                case 4:
                    repeat = false;
                    break;
                
/*                    
                //update existing pet
                case 4:
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
*/
            }
        }
        saveFile("petFile.txt");
    }

    //MAIN
    public static void main(String[] args) {
        System.out.println("Hello World!");
        new PetDatabase().run();
    }
}
