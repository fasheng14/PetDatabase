/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petdatabase;

/**
 *
 * @author fashe
 */
public class Pet {
    private String name;
    private int age;
    
    public Pet(){
    }
    
    public Pet(String name,int age){
        this.name=name;
        this.age=age;
    }
    
    //Setters
    public void setName(String name){
        this.name=name;
    }
    
    public void setAge(int age){
        this.age=age;
    }
    
    //Getters
    public String getName(){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }
}
