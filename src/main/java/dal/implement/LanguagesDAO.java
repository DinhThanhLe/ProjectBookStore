/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import java.util.LinkedHashMap;
import java.util.List;
import model.Languages;

/**
 *
 * @author legion
 */
public class LanguagesDAO extends GenericDAO<Languages> {

    @Override
    public List<Languages> findAll() {
        return queryGenericDAO(Languages.class);
    }

    @Override
    public int insert(Languages t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Languages findByName(String languageName) {
        String sql = "SELECT * FROM Languages WHERE language_name = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("language_name", languageName);

        List<Languages> list = queryGenericDAO(Languages.class, sql, parameterMap);
        return list.isEmpty() ? null : list.get(0);
    }

    public int insertIfNotExists(String languageName) {
        // Kiểm tra ngôn ngữ đã tồn tại chưa
        Languages existingLanguage = findByName(languageName);
        if (existingLanguage != null) {
            return existingLanguage.getLanguage_id();
        }

        // Nếu chưa tồn tại, thêm mới
        String sql = "INSERT INTO Languages (language_name) VALUES (?)";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("language_name", languageName);

        return insertGenericDAO(sql, parameterMap);
    }
}
