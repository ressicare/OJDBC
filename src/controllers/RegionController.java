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



import daos.RegionDAO;
import icontrollers.IRegionController;
import idaos.IRegionDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import models.Region;

/**
 *
 * @author hp
 */
public class RegionController implements IRegionController {
    private IRegionDAO irdao;
    
    public RegionController(Connection connection)
    {
        
        irdao = new RegionDAO(connection);
    }

    @Override
    public List<Region> getAll() {
    return irdao.getAll();
    }

    @Override
    public Region getById(String id) {
        Region r = new Region(0, "0");
        try {
            //data kosong
            if (id.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Infailed entry");
            } //data 0 atau negatif
            else if (Integer.parseInt(id) < 1) {
                System.out.println("Error!!");
                System.out.println("ID number is zero or negative , please enter the appropriate ID");
            } //data tidak ada
            else if (Integer.parseInt(id) != irdao.getById(Integer.parseInt(id)).getId()) {
                System.out.println("Error!!");
                System.out.println("ID doesn't exist");
            } else {
                r = irdao.getById(Integer.parseInt(id));
                r.print();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error!!");
            System.out.println("Enter ID correctly");
        }
        return r;
    }

    @Override
    public List<Region> search(String key) {
        List<Region> region = new ArrayList<Region>();
        try {
        //name kosong
        if (key.isEmpty()) {
            System.out.println("Error!!");
            System.out.println("Infailed entry");
        } //length name > 15
        else if (key.length() > 15) {
            System.out.println("Error!!");
            System.out.println("Name length is more than 15, please enter the appropriate name");
        } else {
            region = irdao.search(key);
        }
        } catch (NullPointerException npe) {
            System.out.println("Error!!");
            System.out.println("Enter data correctly");
            npe.printStackTrace();
        }
        return region;
    }

    @Override
    public Region insert(String id, String name) {
                Region region = new Region(Integer.parseInt(id), name);
        try {
            //name kosong
            if (name.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Invalid entry");
            } //length name > 15
            else if (name.length() > 15) {
                System.out.println("Error!!");
                System.out.println("Name length is more than 15, please enter the appropriate name");
            } //length name < 3 
            else if (name.length() < 3) {
                System.out.println("Error!!");
                System.out.println("Name length is less than 3, please enter the appropriate name");
            } else {
                region = irdao.insert(region);
                System.out.println("Data Successfully inserted");
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!!");
            System.out.println("Enter data correctly");
            npe.printStackTrace();
        }
        return region;
    }

    @Override
    public Region update(String id, String name) {
        Region region = new Region(Integer.parseInt(id), name);
        try {
            //name kosong
            if (name.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Infailed entry");
            } //length name > 15
            else if (name.length() > 15) {
                System.out.println("Error!!");
                System.out.println("Name length is more than 15, please enter the appropriate name");
            } //length name < 3 
            else if (name.length() < 3) {
                System.out.println("Error!!");
                System.out.println("Name length is less than 3, please enter the appropriate name");
            } else {
                region = irdao.update(region);
                System.out.println("Data successfully updated");
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!!");
            System.out.println("Enter data correctly");
            npe.printStackTrace();
        }
        return region;
    }

    @Override
    public void delete(String id) {
       String result = "";
        try {
            //id kosong
            if (id.isEmpty()){
                System.out.println("Error!!");
                System.out.println("Infailed entry");
            } //data tidak ada di tabel
            else if (Integer.parseInt(id) != irdao.getById(Integer.parseInt(id)).getId()) {
                System.out.println("Error!!");
                System.out.println("ID doesn't exist");
            } //id 0 atau negatif 
            else if (Integer.parseInt(id) < 1) {
                System.out.println("Error!!");
                System.out.println("ID number is zero or negative , please enter the appropriate ID");
            } else {
                irdao.delete(Integer.parseInt(id));
                System.out.println("Data successfully deleted");
            }
        } catch (Exception e){
            e.getStackTrace();
            result = "Failed!!";
        }
    
    }
}    