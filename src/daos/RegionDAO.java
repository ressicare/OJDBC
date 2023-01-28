/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IRegionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getString;
import models.Region;

/**
 *
 * @author Ressica Ayu Elhas
 */
public class RegionDAO implements IRegionDAO {
    
    private Connection connection;
    
    public RegionDAO (Connection connection) {
        this.connection = connection;
    }

//    @Override
//    public List<Region> getAll() {
//        List<Region> listRegion = new ArrayList<Region>();
//        String query = "SELECT * FROM HR.REGIONS";
//        try {
//            PreparedStatement ps = connection.prepareStatement (query);
//            ResultSet resultSet = ps.executeQuery();
//            while (resultSet.next()) {
//                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
//                r.setId(resultSet.getInt(1));
//                r.setName(resultSet.getString(2));
//                listRegion.add(r);
//                //Dibawah ini ditampilkan resultnya, selain di sout 
//                //("id= " + resultSet.getInt(1) + "\t" + ", name= " + resultSet.getString(2) ); juga dapat 
//                //menggunakan method toString() seperti yang ada di models.Region
//                //System.out.println("id= " + resultSet.getInt(1) + "\t" + ", name= " + resultSet.getString(2) );
//            }
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return listRegion;
//    }
//    @Override
//    public boolean insert (Region r) {
//        //boolean result = false;
//        String query = "INSERT INTO HR.REGIONS(region_id, region_name) VALUES (?,?)" ;
//        try {
//            PreparedStatement ps = connection.prepareStatement (query);
//            ps.setInt(1, r.getId());
//            ps.setString(2, r.getName());
//            ps.executeQuery();
//            
//            //result = true ;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//            
//    }
//
//    @Override
//    public List<Region> getById(int id) {
//        List<Region> listRegion = new ArrayList<Region>();
//         String query = "SELECT * FROM HR.REGIONS WHERE REGION_ID = ?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setInt(1, id); //kurang ini doang wkowkowkwo ngakak
//            
//            ResultSet resultSet = ps.executeQuery();
//            if(resultSet.next()){
//                Region r = new Region();
//                r.setId(resultSet.getInt(1));
//                r.setName(resultSet.getString(2));
//                listRegion.add(r);
//            }
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return listRegion;
//    }
//
//    @Override
//    public List<Region> search(String key) {
//        List<Region> listRegion = new ArrayList<Region>();
//         String query = "SELECT * FROM HR.REGIONS WHERE REGION_NAME = ?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, key); 
//            
//            ResultSet resultSet = ps.executeQuery();
//            if(resultSet.next()){
//                Region r = new Region();
//                r.setId(resultSet.getInt(1));
//                r.setName(resultSet.getString(2));
//                listRegion.add(r);
//            }
//        } catch (Exception e) {
//            System.out.println("Data Not Found");
//            e.getStackTrace();
//        }
//        return listRegion;
//    }
//
//    @Override
//    public boolean delete(int id) {
//        boolean result = false;
//        String query = "DELETE FROM HR.REGIONS WHERE REGION_ID = ?" ;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1,id);            
//            preparedStatement.execute();
//       //    preparedStatement.addBatch();
//        //   preparedStatement.executeBatch();
//            //preparedStatement.close();
//            //connection.close();
//            result = true ;
//            System.out.println("The procedure succesfully deleteddd");
//        //    connection.commit();
//        } catch (Exception e) {
////            System.out.println("Error");
////            System.out.println("See the details below");
//            e.printStackTrace();
//            //return false;
//            
//            
//        }
//        return true;
//        
//    }
//
//  
//
//     public boolean update(Region r) {
//        String query = "UPDATE HR.REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, r.getName());
//            ps.setInt(2, r.getId());
//
//            ps.executeQuery();
////           return ps.executeUpdate() > 0;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }

    @Override
    public Region getById(int id) {
        Region r = new Region();
        String query = "SELECT * FROM HR.REGIONS WHERE REGION_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                
                r.setId(resultSet.getInt(1));
                r.setName(resultSet.getString(2));
                
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
       return r;
    }

    @Override
    public List<Region> getAll() {
        List<Region> listRegion = new ArrayList<Region>();
        String query = "SELECT * FROM HR.REGIONS";
        try {
            PreparedStatement ps = connection.prepareStatement (query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
                r.setId(resultSet.getInt(1));
                r.setName(resultSet.getString(2));
                listRegion.add(r);
                //Dibawah ini ditampilkan resultnya, selain di sout 
                //("id= " + resultSet.getInt(1) + "\t" + ", name= " + resultSet.getString(2) ); juga dapat 
                //menggunakan method toString() seperti yang ada di models.Region
                //System.out.println("id= " + resultSet.getInt(1) + "\t" + ", name= " + resultSet.getString(2) );
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listRegion;
    }

    @Override
    public List<Region> search(String keyword) {
        List<Region> listRegion = new ArrayList<Region>();
        String query = "SELECT * FROM HR.REGIONS WHERE REGION_NAME LIKE ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%"+keyword+"%"); 
            
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                Region r = new Region();
                r.setId(resultSet.getInt(1));
                r.setName(resultSet.getString(2));
                listRegion.add(r);
            }
        } catch (Exception e) {
            //System.out.println("Data Not Found");
            e.getStackTrace();
        }
        return listRegion;
    }

    @Override
    public Region insert(Region r) {
        //boolean result = false;
        String query = "INSERT INTO HR.REGIONS(REGION_ID, REGION_NAME) VALUES (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, r.getId());
            ps.setString(2, r.getName());
            ps.executeQuery();

            //result = true ;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return r;
    }

    @Override
    public Region update(Region r) {
        String query = "UPDATE HR.REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, r.getName());
            ps.setInt(2, r.getId());
            ps.executeQuery();
//           return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            //return null;
        }
        return r;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM HR.REGIONS WHERE REGION_ID = ?  ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();
//            System.out.println("The procedure succesfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("Error");
//            System.out.println("See the details below");
            
        }
}
}

   