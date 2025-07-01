/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import jakarta.jws.soap.SOAPBinding;
import java.util.LinkedHashMap;
import java.util.List;
import model.Users;

/**
 *
 * @author legion
 */
public class UserDao extends GenericDAO<Users> {

    @Override
    public List<Users> findAll() {

        return queryGenericDAO(Users.class);
    }

    @Override
    public int insert(Users t) {
        return insertGenericDAO(t);
    }

    public Users findByUsernameAndPass(Users user) {
        String sql = "SELECT [user_id]\n"
                + "      ,[username]\n"
                + "      ,[password_hash]\n"
                + "      ,[email]\n"
                + "      ,[full_name]\n"
                + "      ,[address]\n"
                + "      ,[phone_number]\n"
                + "      ,[role]\n"
                + "  FROM [dbo].[Users] where username = ? and password_hash = ? ";

        parameterMap = new LinkedHashMap<>();
        parameterMap.put("userName", user.getUsername());
        parameterMap.put("password", user.getPassword_hash());
        List<Users> list = queryGenericDAO(Users.class, sql, parameterMap);
        return list.size() == 0 ? null : list.get(0);

    }

    public Users timKiemTaiKhoanTonTai(String tenDangNhap) {

        String sql = "SELECT [user_id]\n"
                + "      ,[username]\n"
                + "      ,[password_hash]\n"
                + "      ,[email]\n"
                + "      ,[full_name]\n"
                + "      ,[address]\n"
                + "      ,[phone_number]\n"
                + "      ,[role]\n"
                + "  FROM [dbo].[Users] where username = ? ";

        parameterMap = new LinkedHashMap<>();
        parameterMap.put("userName", tenDangNhap);

        List<Users> list = queryGenericDAO(Users.class, sql, parameterMap);
        return list.size() == 0 ? null : list.get(0);

    }

 

}
