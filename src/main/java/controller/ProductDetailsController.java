/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.implement.BookVariantDAO;
import dal.implement.LanguagesDAO;
import dal.implement.MaterialsDAO;
import dal.implement.ProductDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.Book_Variants;
import model.Books;
import model.Languages;
import model.Materials;

/**
 *
 * @author legion
 */
public class ProductDetailsController extends HttpServlet {

   
    ProductDAO productDao = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //get ve id product
      int id = Integer.parseInt(request.getParameter("id")) ;
       Books book = Books.builder()
               .book_id(id).build();
      //lay product tu database
       Books bookFoundById = productDao.findById(book) ;
       // Lấy danh sách biến thể
       List<Book_Variants> variantList = new BookVariantDAO().getVariantsByBookId(book);
    // Lấy danh sách chất liệu bìa và ngôn ngữ 
       List<Materials> materialList = new MaterialsDAO().findAll() ;
       List<Languages> languageList = new LanguagesDAO().findAll();
    


      //set product vao request chuyen sang product-details.jsp
      request.setAttribute("book", bookFoundById);
      request.setAttribute("variantList", variantList);
    request.setAttribute("materialList", materialList);
    request.setAttribute("languageList", languageList);
    RequestDispatcher rq = getServletContext().getRequestDispatcher("/view/user/product-details.jsp");
               rq.forward(request, response);
     // request.getRequestDispatcher("product-details.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    

}
