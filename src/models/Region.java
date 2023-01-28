/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Ressica Ayu Elhas
 */
public class Region {
    private int id;
    private String name;
    
    public Region() {
    }
    public Region (int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId (int id) {
        this.id = id;
        
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    //Menggunakan method to String untuk menampilkan object berbentuk string
    //jika tidak menggunakan toString maka akan muncul hashcode values nya 
    //seperti berikut ini models.Region@134593bf, models.Region@4bb4de6a
    //models.Region@7ba18f1b, models.Region@2f8f5f62
//    public String toString() {
//        return "id = " + id + "\t " + ", name = " + name; //untuk getAll
//    }

    public void print() {
        System.out.println("id = " + id + "\t " + ", name = " + name  );
        
    }
}
