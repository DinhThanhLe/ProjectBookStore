/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import java.util.List;
import model.Languages;

/**
 *
 * @author legion
 */
public class LanguagesDAO extends GenericDAO<Languages>{

    @Override
    public List<Languages> findAll() {
      return queryGenericDAO(Languages.class) ;
    }

    @Override
    public int insert(Languages t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
