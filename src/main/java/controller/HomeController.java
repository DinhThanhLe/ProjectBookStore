/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.implement.CategoryDao;
import dal.implement.ProductDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.Books;
import model.Categories;

/**
 *
 * @author legion
 */
public class HomeController extends HttpServlet {
    
     ProductDAO productDAO = new ProductDAO() ;
     CategoryDao categoryDao = new  CategoryDao() ;
        
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Books> listBook = findBookDoGet(request , response)  ;
        
        List<Categories> listCategory = categoryDao.findAll() ;
        
         HttpSession session = request.getSession() ;
         session.setAttribute("listBook", listBook);
         session.setAttribute("listCategory", listCategory);
         
         
         String url="/view/common/home.jsp" ;
      
               RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
               rq.forward(request, response);
    }

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

    private List<Books> findBookDoGet(HttpServletRequest request, HttpServletResponse response) {
        List<Books> listBook ;
           String actionSearch = request.getParameter("search")== null ? "default" : request.getParameter("search") ;
        switch (actionSearch) {
            case "category":
                 String categoryID = request.getParameter("categoryID") ;
                 listBook = productDAO.findByCategoryID(categoryID) ;
                break;
            case "keyword": 
                String keyword = request.getParameter("keyword") ;
                listBook = productDAO.findByKeyword(keyword) ;
                 break;
            default:
                listBook = productDAO.findAll() ;
        }
        return listBook ;

    }

}
