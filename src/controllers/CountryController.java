/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Ressica Ayu Elhas
 */

    
import daos.CountryDAO;
import icontrollers.ICountryController;
import idaos.ICountryDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import models.Country;


public class CountryController implements ICountryController {
    private ICountryDAO icdao;
    
    public CountryController(Connection connection)
    {
        icdao = new CountryDAO(connection);
    }    

    @Override
    public List<Country> getAll() {
        return icdao.getAll();
    }

    @Override
    public Country getById(String id) {
        Country coun = new Country(0, "0");
        try{
            if(id.isEmpty()){
                System.out.println("No Input");
            } else {
                coun = icdao.getById(id);
                System.out.println("id: " + coun.getId() + "," +
                                   "name: " + coun.getName() + ", id region: " + coun.getIdr()) ;
            } 
        } catch (NumberFormatException nfe){
            System.out.println("Failed");
        } return coun;
    }

    @Override
    public List<Country> search(String keyword) {
        List<Country> coun = new ArrayList<Country>();
        try {
        //data kosong
        if (keyword.isEmpty()) {
            System.out.println("Invalid entry");
        } else {
            coun = icdao.search(keyword);

        }
        } catch (NullPointerException npe) {
            System.out.println("There is an error!!");
            npe.printStackTrace();
        }
        return coun;
    }
    
    
    @Override
    public Country insert(String id, String name, int idr) {
        Country coun = new Country(id, name, idr);
        try {
            if (name.isEmpty()) {
                System.out.println("There is an error!!");
            }  
            else if (name.length() < 3) {
                System.out.println("There is an error!!");
            } else {
                coun = icdao.insert(coun);
                System.out.println("Data Successfully entered");
            }
        } catch (NullPointerException npe) {
            System.out.println("There is an error!!");
            npe.printStackTrace();
        }
        return coun;
    }

    @Override
    public Country update(String id, String name, int idr) {
        Country coun = new Country(id , name, idr);
        try {
            if (name.isEmpty()) {
                System.out.println("Data cannot be empty!!");
            } 
            else if (name.length() < 3) {
                System.out.println("less name lenght");
            } else {
                coun = icdao.update(coun);
                System.out.println("Data successfully updated");
            }
        } catch (NullPointerException npe) {
            System.out.println("There is an error!!");
            npe.printStackTrace();
        }
        return coun;
    }

    @Override
    public void delete(String id) {
        String result = "";
        try {
            if (id.isEmpty()){
                System.out.println("Error");
                System.out.println("ID tidak boleh kosong!!");
            } 
//            else if (id != icdao.getById(id).getId()) {
//                System.out.println("ID doesn't exist");
//            }
            else if (!id.equals(icdao.getById(id).getId())) {
                 System.out.println("Error");
                System.out.println("ID tidak ditemukan");
            }
            else {
                icdao.delete(id);
                System.out.println("Data sukses dihapus" );
            }
        } catch (Exception e){
            e.getStackTrace();
            result = "Failed!!";
        }
    }
     
    
    
}
