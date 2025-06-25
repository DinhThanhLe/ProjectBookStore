/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class Book_Variants {
    // Core fields từ bảng Book_Variants
    private Integer variant_id;
    private Integer book_id;
    private Integer material_id;
    private Integer language_id;
    private double price;
    private Integer stock_quantity;
    private double weight;
    
//     Display fields từ JOIN
    private String title;           // Từ Books
    private String material_type;   // Từ Materials
    private String language_name;   // Từ Languages
    private String category_name;   // Từ Categories (qua Books)
    private String author_name;     // Từ Authors (qua Books)
//    private String description;
   private String cover_image_url;

    
}
