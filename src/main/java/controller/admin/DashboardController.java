/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import constant.CommonConst;
import dal.implement.BookVariantDAO;
import dal.implement.CategoryDao;
import dal.implement.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.Book_Variants;
import model.Books;
import model.Categories;


/**
 *
 * @author legion
 */
public class DashboardController extends HttpServlet {

    
    CategoryDao categoryDao = new CategoryDao();
    BookVariantDAO bookVariantDao = new  BookVariantDAO() ;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        HttpSession session = request.getSession();
        
        List<Book_Variants> listBookVariant = bookVariantDao.findAll();
        System.out.println("Số lượng sách là :" + listBookVariant.size());
        List<Categories> listCategory = categoryDao.findAll();
        request.setAttribute("listBookVariant", listBookVariant );
        request.setAttribute(CommonConst.SESSION_CATEGORY, listCategory);
        System.out.println("Số lượng thể loại là :" + listCategory.size());
        request.getRequestDispatcher("../view/admin/dashboard.jsp").forward(request, response) ;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
