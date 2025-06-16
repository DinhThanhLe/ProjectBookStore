/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import java.util.LinkedHashMap;
import java.util.List;
import model.Book_Variants;
import model.Books;

/**
 *
 * @author legion
 */
public class BookVariantDAO extends GenericDAO<Book_Variants>{

    public  List<Book_Variants> getVariantsByBookId(Books book) {
 String sql = "SELECT [variant_id]\n" +
"      ,[book_id]\n" +
"      ,[material_id]\n" +
"      ,[language_id]\n" +
"      ,[price]\n" +
"      ,[stock_quantity]\n" +
"      ,[weight]\n" +
"  FROM [dbo].[Book_Variants] where book_id = ? " ;
  parameterMap = new LinkedHashMap<>() ;
  parameterMap.put("id", book.getBook_id()) ; 
   return queryGenericDAO(Book_Variants.class, sql, parameterMap) ;


    }

    @Override
    public List<Book_Variants> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(Book_Variants t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
