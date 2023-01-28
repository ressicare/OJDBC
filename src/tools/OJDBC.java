/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.CountryController;
import controllers.RegionController;
import daos.CountryDAO;
import daos.RegionDAO;
import idaos.IRegionDAO;
import static java.util.Collections.list;
import java.util.List;
import java.util.Scanner;
import models.Country;
import models.Region;

/**
 *
 * @author Ressica Ayu Elhas
 */
public class OJDBC {
    
    public static void main(String[] args) {
          DBConnection connection = new DBConnection () ;
          //Connect RegionDAO
          RegionDAO rdao = new RegionDAO(connection.getConnection());
          //Connect RegionController
          RegionController rc = new RegionController (connection.getConnection());
          //Connect CountryDAO
          CountryDAO cdao = new CountryDAO(connection.getConnection());
          //Connect CountryController
          CountryController ccon = new CountryController (connection.getConnection());
          System.out.println(connection.getConnection());
          //getall, insert, getbyid,search,update,delete
          int input = 0;
          
        while (true) {
                System.out.println(
                        " \n"
                        + " ===================================================\n"
                        + "                     MENU: \n "
                        +"===================================================\n"
                        + " 1. \t Menampilkan semua id dan nama Region   \n "
                        + "2. \t Memasukkan data Region (id dan name) \n "
                        + "3. \t Mencari data Region berdasarkan id \n "
                        + "4. \t Mencari data Region berdasarkan nama \n "
                        + "5. \t Mengupdate data Region \n "
                        + "6. \t Menghapus data Region \n "
                        + "===================================================\n"
                        + " 7. \t Menampilkan semua id dan nama Country   \n "
                        + "8. \t Memasukkan data Country (id dan name) \n "
                        + "9. \t Mencari data Country berdasarkan id \n "
                        + "10. \t Mencari data Country berdasarkan nama \n "
                        + "11. \t Mengupdate data Country \n "
                        + "12. \t Menghapus data Country \n"
                        + " 13. \t Exit \n"
                        + "===================================================");
                System.out.print(" \n"
                        + "\t >>Masukkan Pilihan Anda: ");
                
                
                Scanner scrInt = new Scanner(System.in);
                Scanner scrStr = new Scanner(System.in);
                input = scrInt.nextInt();                            
      

                switch (input) {
                    /**getAll Region*/
                    case 1: 
                        System.out.println("Berikut Ditampilkan Data Region yang anda Minta: \n");
                        
                        List<Region> rcon = rc.getAll();
                        for (Region rcons :rcon) {
                        rcons.print();
                            System.out.println("\n");
                        }
                        break;
                    /**insert*/
                    case 2: 
                        System.out.println("Silahkan masukkan id dan nama Region yang akan diinput: ");
                       
                        System.out.println("Masukkan id: "); 
                        String id = scrStr.nextLine();
                        System.out.print("Masukkan nama: ");
                        String name = scrStr.nextLine();
                        rc.insert(id , name);
                        break;
                    /**getById*/
                    case 3: 
                        System.out.println("Silahkan masukkan id Region yang anda cari:");
                        System.out.println("Masukkan id: ");
                        String idi = scrStr.nextLine();
                        rc.getById(idi);                      
                        break;
                    /**search*/
                    case 4: 
                        System.out.println("Silahkan masukkan nama Region yang anda cari:");
                        System.out.println("Masukkan nama: ");
                        String src = scrStr.nextLine();
                        List <Region> rcon1 = rc.search(src);
                            for(Region rcons1 : rcon1){
                            rcons1.print();
                            }
                        break;
                    /**update*/
                    case 5: 
                        System.out.println("Masukkan id: "); 
                        String idup = scrStr.nextLine();
                        System.out.print("Masukkan nama: ");
                        String upName = scrStr.nextLine();
                        rc.update(idup , upName);
                        break;
                    /**delete*/
                    case 6: 
                        System.out.println("Masukkan id Region yang akan dihapus");
                        System.out.println("Masukkan id: ");
                        String idDel = scrStr.nextLine();                      
                        rc.delete(idDel);
                        break;
                    /**getAll Country*/
                    case 7: 
                        System.out.println("Berikut Ditampilkan Data Country yang anda Minta: \n");
                        List<Country> coun = ccon.getAll();
                        for (Country couns :coun) {
                        couns.display();
                        }
                        
                        break;
                    /**insert*/    
                    case 8: 
                        System.out.println("Silahkan masukkan id dan nama Region yang akan diinput: ");
                       
                        System.out.println("Masukkan id Country: "); 
                        String idCr = scrStr.nextLine();
                        System.out.print("Masukkan nama Country: ");
                        String nameCr = scrStr.nextLine();
                        System.out.print("Masukkan id Region: ");
                        int idReg = scrInt.nextInt();
                        ccon.insert(idCr , nameCr, idReg);
                        break;
                    /**getById*/
                    case 9: 
                        System.out.println("Silahkan masukkan id Country yang dicari: ");
                        System.out.println("Masukkan id Country: "); 
                        String idCr1 = scrStr.nextLine();
                        ccon.getById(idCr1);                        
                        break;
                    /**search*/
                    case 10: 
                        System.out.println("Silahkan masukkan nama Country yang dicari: ");
                       
                        System.out.println("Masukkan nama Country: "); 
                        String idSrc = scrStr.nextLine();
                        List<Country> country = ccon.search(idSrc);
                        for(Country couns1 : country){
                        couns1.display();
                        }                        
                        break;
                    /**update*/
                    case 11: 
                        System.out.println("Masukkan ID Country");
                        String idCru = scrStr.nextLine();
                        System.out.print("Masukkan nama Country: ");
                        String nameCru = scrStr.nextLine();
                        System.out.print("Masukkan id Region: ");
                        int idRegs = scrInt.nextInt();
                        ccon.update(idCru , nameCru, idRegs);
                        break;
                    /**delete*/
                    case 12: 
                        System.out.print("ID country yang akan di hapus : ");
                        String delId = scrStr.nextLine();
                        ccon.delete(delId);
                        break;
                    /**Exit*/
                    case 13: 
                        System.out.println("\t Exit");
                        System.exit(0);
                        break;                        
                    default:
                        if(input < 13);
                        System.out.println("Menu tidak tersedia");
                        System.out.println("Masukkan pilihan 1-13");
                        break;
                }
            }           

          
          
//            Region region = new Region() ;
//            region.setId(0);
//            region.setName("Eropa");
//            System.out.println(region.getId() + " " + region.getName());
//            Region r = new Region(1, "Region new");
//            System.out.println(r.getId() + " " +r.getName());
 


            /**INSERT */
//            Region region = new Region(10, "Jember") ;
//            System.out.println(rdao.insert(region));



            
          /**GET ALL RegionDAO */
//            List<Region> reg = rdao.getAll();
//            for (Region regs :reg) {
//              regs.print();
              

           /**DELETE*/
//           rdao.delete(58); 

          /**UPDATE*/
//          Region region = new Region(6, "Jonggol");
//          System.out.println(rdao.update(region));

          /**getById*/
//          Region coba = rdao.getById(10);
//          System.out.println(coba);

            /**SEARCH*/
//          List<Region> sdao = rdao.search("G");
//          System.out.println(sdao);

            /**SEARCH atau ini pake for*/
//            RegionDAO rdao = new RegionDAO(connection.getConnection());
//            List<Region> sc = rdao.search("G");
//            for(Region reg : sc){
//            System.out.println(reg);
//            }
           
//        Manual Test DAO insert
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        Region r = new Region(58, "My Region 58");
//        System.out.println(r);
//        System.out.println(r.getId());
//        System.out.println(r.getName());
//        System.out.println(irdao.insert(r));
//
//
//        }


//          KHUSUS REGION CONTROLLER

          /**GET ALL RegionController */
//            List<Region> rcon = rc.getAll();
//            for (Region rcons :rcon) {
//              rcons.print();
//            }

            /**INSERT RegionController */
//            rc.insert("10","Aus");
            /**getById RegionController */
//            rc.getById("6");
            /**DELETE RegionController */
//            rc.delete(" ");
            /**UPDATE RegionController */
//            rc.update("6", "Ausi");

//            /**SEARCH*/
//            List<Region> rcon = rc.search("G");
//            for(Region rcons : rcon){
//            rcons.print();
//    }
            




//          KHUSUS COUNTRY

             /**COUNTRY CONTROLLER*/

             /**getAll CountryController*/
//            List<Country> coun = ccon.getAll();
//            for (Country couns :coun) {
//              couns.display();
//            }
//            
            /**INSERT CountryController */
//            ccon.insert("DB","Dubai", 9);
            /**getById CountryController */
//            ccon.getById(" ");
            /**DELETE CountryController */
//            ccon.delete("DB");
            /**UPDATE CountryController */
//            ccon.update("DB", "SLOKAVIA", 7);
            /**SEARCH*/
//            List<Country> coun = ccon.search("Ar");
//            for(Country couns : coun){
//            couns.display();
//    }


             /**COUNTRY DAO*/
             // getAll
//            List<Country> count = cdao.getAll();
//            for (Country  cou : count){
//                cou.display();
//            }

            //Insert
//            Country c = new Country("ID", "Indonesia", 2);
//            System.out.println(cdao.insert(c)); 
     

            //update
//            Country c = new Country("ID", "Indo", 2); 
//            System.out.println(cdao.update(c));


            //search
//            List<Country> coba = cdao.search("Indo");
//            for(Country c : coba){
//                c.display();
//            }

            //delete
//            cdao.delete("ID");

            //getById
//            Country coba = cdao.getById("AR");
//            coba.display();
            
}
    
}
    

    


    
    
    
    

