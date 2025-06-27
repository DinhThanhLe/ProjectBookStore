
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import java.util.LinkedHashMap;
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
    public Materials findByType(String materialType) {
        String sql = "SELECT * FROM Materials WHERE material_type = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("material_type", materialType);
        
        List<Materials> list = queryGenericDAO(Materials.class, sql, parameterMap);
        return list.isEmpty() ? null : list.get(0);
    }
    
    public int insertIfNotExists(String materialType) {
        // Kiểm tra chất liệu đã tồn tại chưa
        Materials existingMaterial = findByType(materialType);
        if (existingMaterial != null) {
            return existingMaterial.getMaterial_id();
        }
        
        // Nếu chưa tồn tại, thêm mới
        String sql = "INSERT INTO Materials (material_type) VALUES (?)";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("material_type", materialType);
        
        return insertGenericDAO(sql, parameterMap);
    }
    
}
