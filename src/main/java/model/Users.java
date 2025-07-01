/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import lombok.AllArgsConstructor ;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter ;
import lombok.ToString;

/**
 *
 * @author legion
 */
@ToString
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Users {
    
    private String user_id  ;
    private String username ;
    private String password_hash ;
    private String email  ;
    private String full_name ;
    private String address ;
    private String phone_number ;
    private String role ;
    
   
    
}
