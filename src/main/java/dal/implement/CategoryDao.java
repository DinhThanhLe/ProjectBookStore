/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import java.util.List;
import model.Categories;

/**
 *
 * @author legion
 */
public class CategoryDao extends GenericDAO<Categories>{

    @Override
    public List<Categories> findAll() {
   return  queryGenericDAO(Categories.class) ;

    }

    @Override
    public int insert(Categories t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
