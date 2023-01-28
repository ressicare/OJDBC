/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Country;


/**
 *
 * @author Ressica Ayu Elhas
 */
public interface ICountryController {
    public List<Country> getAll(); 
    //query like

    public Country getById(String id);

    public List<Country> search(String keyword);
    //return null jika gagal

    public Country insert(String id, String name, int idr);
    //return null jika gagal

    public Country update(String id, String name, int idr);

    public void delete(String id);
    
}
