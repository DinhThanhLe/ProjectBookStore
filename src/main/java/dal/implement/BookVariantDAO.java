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
public class BookVariantDAO extends GenericDAO<Book_Variants> {

    public List<Book_Variants> getVariantsByBookId(Books book) {
        String sql = " SELECT bv.variant_id, bv.book_id, b.title,   \n" +
"              bv.material_id, m.material_type,  \n" +
"              bv.language_id, l.language_name,  \n" +
"              bv.price, bv.stock_quantity, bv.weight,  \n" +
"              c.category_id, c.category_name,    \n" +
"              a.author_id, a.author_name         \n" +
"              FROM Book_Variants bv  \n" +
"              JOIN Books b ON bv.book_id = b.book_id  \n" +
"              JOIN Materials m ON bv.material_id = m.material_id  \n" +
"              JOIN Languages l ON bv.language_id = l.language_id  \n" +
"              JOIN Categories c on c.category_id = b.category_id  \n" +
"              JOIN Authors a on a.author_id = b.author_id   \n" +
"			  where bv.book_id = ? \n" +
"              ORDER BY bv.variant_id ;";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("id", book.getBook_id());
        return queryGenericDAO(Book_Variants.class, sql, parameterMap);


    }

    @Override
    public List<Book_Variants> findAll() {
        String sql = "SELECT bv.variant_id, bv.book_id, b.title, \n" +
            " bv.material_id, m.material_type,\n" +
            " bv.language_id, l.language_name,\n" +
            " bv.price, bv.stock_quantity, bv.weight,\n" +
            " c.category_id, c.category_name,\n" +  
            " a.author_id, a.author_name\n" +       
            " FROM Book_Variants bv\n" +
            " JOIN Books b ON bv.book_id = b.book_id\n" +
            " JOIN Materials m ON bv.material_id = m.material_id\n" +
            " JOIN Languages l ON bv.language_id = l.language_id\n" +
            " JOIN Categories c on c.category_id = b.category_id\n" +
            " JOIN Authors a on a.author_id = b.author_id \n" +
            " ORDER BY bv.variant_id";  
              parameterMap = new LinkedHashMap<>();
              return queryGenericDAO(Book_Variants.class, sql, parameterMap);


    }

    @Override
    public int insert(Book_Variants t) {

              return insertGenericDAO(t) ;

    }

    public void deleteBookById(int id) {
        
        String sql ="DELETE FROM [dbo].[Book_Variants]\n" +
                "      WHERE variant_id  = ? " ;
        parameterMap = new LinkedHashMap<>() ;
         parameterMap.put("id", id);

        
         deleteGenericDAO(sql, parameterMap);

    }

    public boolean checkExitBook(int idBook) {
  String sql = "SELECT [variant_id]\n" +
"      ,[book_id]\n" +
"      ,[material_id]\n" +
"      ,[language_id]\n" +
"      ,[price]\n" +
"      ,[stock_quantity]\n" +
"      ,[weight]\n" +
"  FROM [dbo].[Book_Variants] where book_id = ? " ;

 parameterMap = new LinkedHashMap<>() ;
         parameterMap.put("idBook", idBook);
         
 return queryGenericDAO(Book_Variants.class, sql, parameterMap).size() == 0 ? false : true ;

    }

}
