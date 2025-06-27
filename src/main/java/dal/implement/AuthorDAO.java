  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import java.util.LinkedHashMap;
import java.util.List;
import model.Authors;

/**
 *
 * @author legion
 */
public class AuthorDAO extends GenericDAO<Authors>{

    @Override
    public List<Authors> findAll() {
        return queryGenericDAO(Authors.class);
    }

    @Override
    public int insert(Authors t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public Authors findByName(String authorName) {
        String sql = "SELECT [author_id]\n" +
"      ,[author_name]\n" +
"      ,[biography]\n" +
"      ,[created_at]\n" +
"  FROM [dbo].[Authors] WHERE author_name = ?";

        parameterMap = new LinkedHashMap<>();
         parameterMap.put("author_name", authorName);
         
        
        List<Authors> list = queryGenericDAO(Authors.class, sql, parameterMap);
        return list.isEmpty() ? null : list.get(0);
    }
    public int insertIfNotExists(String authorName) {
        // Kiểm tra tác giả đã tồn tại chưa
        Authors existingAuthor = findByName(authorName);
        if (existingAuthor != null) {
            return existingAuthor.getAuthor_id()  ;
        }
        
        // Nếu chưa tồn tại, thêm mới
        String sql = "INSERT INTO Authors (author_name) VALUES (?)";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("author_name", authorName);
        
        return insertGenericDAO(sql, parameterMap);
    }
   
    
}