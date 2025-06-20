/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import java.awt.print.Book;
import java.util.LinkedHashMap;
import java.util.List;
import model.Books;
import model.Categories;

/**
 *
 * @author legion
 */
public class ProductDAO extends GenericDAO<Books>{

    @Override
    public List<Books> findAll() {
      return  queryGenericDAO(Books.class) ;
    }

    @Override
    public int insert(Books t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Books findById(Books t) {
         String sql = "SELECT [book_id]\n" +
"      ,[title]\n" +
"      ,[description]\n" +
"      ,[cover_image_url]\n" +
"      ,[publication_year]\n" +
"      ,[page_count]\n" +
"      ,[category_id]\n" +
"      ,[publisher_id]\n" +
"      ,[author_id]\n" +
"  FROM [dbo].[Books] where book_id = ?" ;

   parameterMap = new LinkedHashMap<>() ;
   parameterMap.put("id", t.getBook_id()) ; 
        List<Books> list =  queryGenericDAO(Books.class, sql, parameterMap) ;
        
        return list.isEmpty() ? null : list.get(0) ;
 
    }

    public List<Books> findByCategoryID(String categoryID) {

String sql = "SELECT [book_id]\n" +
"      ,[title]\n" +
"      ,[description]\n" +
"      ,[cover_image_url]\n" +
"      ,[publication_year]\n" +
"      ,[page_count]\n" +
"      ,[category_id]\n" +
"      ,[publisher_id]\n" +
"      ,[author_id]\n" +
"  FROM [dbo].[Books] where category_id = ?" ;

 parameterMap = new LinkedHashMap<>() ;
   parameterMap.put("id", categoryID) ; 

 return queryGenericDAO(Books.class, sql, parameterMap) ; 


    }

    public List<Books> findByKeyword(String keyword) {

String sql = "SELECT [book_id]\n" +
"      ,[title]\n" +
"      ,[description]\n" +
"      ,[cover_image_url]\n" +
"      ,[publication_year]\n" +
"      ,[page_count]\n" +
"      ,[category_id]\n" +
"      ,[publisher_id]\n" +
"      ,[author_id]\n" +
"  FROM [dbo].[Books] where title like   ?" ;

parameterMap = new LinkedHashMap<>() ;
   parameterMap.put("nameContain", "%" +keyword +"%") ; 
   
return  queryGenericDAO(Books.class, sql, parameterMap) ; 
    }
    
}
