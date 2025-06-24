/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import constant.CommonConst;
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
public class ProductDAO extends GenericDAO<Books> {

    @Override
    public List<Books> findAll() {
        return queryGenericDAO(Books.class);
    }
    
    public List<Books> findAll(int page) {
       String sql = "select * from Books \n"
               
                + "order by book_id \n"
                + "offset ?  rows\n"
                + "fetch next ? rows only";

        parameterMap = new LinkedHashMap<>();
       
        parameterMap.put("offset", (page - 1) * CommonConst.RECORD_PER_PAGE);
        parameterMap.put("fetch", CommonConst.RECORD_PER_PAGE);

        return queryGenericDAO(Books.class, sql, parameterMap);
    }

    @Override
    public int insert(Books t) {

       return insertGenericDAO(t) ;
    }

    public Books findById(Books t) {
        String sql = "SELECT [book_id]\n"
                + "      ,[title]\n"
                + "      ,[description]\n"
                + "      ,[cover_image_url]\n"
                + "      ,[publication_year]\n"
                + "      ,[page_count]\n"
                + "      ,[category_id]\n"
                + "      ,[publisher_id]\n"
                + "      ,[author_id]\n"
                + "  FROM [dbo].[Books] where book_id = ?";

        parameterMap = new LinkedHashMap<>();
        parameterMap.put("id", t.getBook_id());
        List<Books> list = queryGenericDAO(Books.class, sql, parameterMap);

        return list.isEmpty() ? null : list.get(0);

    }

    public List<Books> findByCategoryID(String categoryID, int page) {

        String sql = "select * from Books \n"
                + "where category_id = ?\n"
                + "order by book_id \n"
                + "offset ?  rows\n"
                + "fetch next ? rows only";

        parameterMap = new LinkedHashMap<>();
        parameterMap.put("id", categoryID);
        parameterMap.put("offset", (page - 1) * CommonConst.RECORD_PER_PAGE);
        parameterMap.put("fetch", CommonConst.RECORD_PER_PAGE);

        return queryGenericDAO(Books.class, sql, parameterMap);

    }

    public List<Books> findByKeyword(String keyword , int page ) {

       String sql = "SELECT [book_id]\n"
                + "      ,[title]\n"
                + "      ,[description]\n"
                + "      ,[cover_image_url]\n"
                + "      ,[publication_year]\n"
                + "      ,[page_count]\n"
                + "      ,[category_id]\n"
                + "      ,[publisher_id]\n"
                + "      ,[author_id]\n"
                + "  FROM [dbo].[Books] where title like  ?" 
               + "order by book_id \n"
                + "offset ?  rows\n"
                + "fetch next ? rows only";
             
       
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("nameContain", "%" + keyword + "%");
        parameterMap.put("offset", (page - 1) * CommonConst.RECORD_PER_PAGE);
        parameterMap.put("fetch", CommonConst.RECORD_PER_PAGE);

        return queryGenericDAO(Books.class, sql, parameterMap);
        

    }
    public List<Books> findByKeyword(String keyword) {

        String sql = "SELECT [book_id]\n"
                + "      ,[title]\n"
                + "      ,[description]\n"
                + "      ,[cover_image_url]\n"
                + "      ,[publication_year]\n"
                + "      ,[page_count]\n"
                + "      ,[category_id]\n"
                + "      ,[publisher_id]\n"
                + "      ,[author_id]\n"
                + "  FROM [dbo].[Books] where title like  ?" 
             ;
       
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("nameContain", "%" + keyword + "%");

        return queryGenericDAO(Books.class, sql, parameterMap);
    }

    public int findTotalRecordByCategory(String category_id) {

        String sql = "select count(*) from Books \n"
                + "where category_id = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("category_id", category_id);
        return findTotalRecordGenericDAO(Books.class, sql, parameterMap);
    }

    public void deleteBookById(int idBook) {
    String sql ="DELETE FROM [dbo].[Books]\n" +
"      WHERE book_id = ?" ;
    
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("idBook", idBook);

        deleteGenericDAO(sql, parameterMap) ;

    }

}
