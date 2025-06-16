/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import java.util.List;
import model.Materials;

/**
 *
 * @author legion
 */
public class MaterialsDAO extends GenericDAO<Materials>{

    @Override
    public List<Materials> findAll() {

      return  queryGenericDAO(Materials.class) ;
    }

    

    @Override
    public int insert(Materials t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
