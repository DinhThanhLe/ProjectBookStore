/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import constant.CommonConst;
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
import model.PageControl;

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
          PageControl pageControl =new PageControl() ;

        List<Books> listBook = findBookDoGet(request , response ,pageControl)  ;
        
        List<Categories> listCategory = categoryDao.findAll() ;

         HttpSession session = request.getSession() ;
         session.setAttribute("listBook", listBook);
         session.setAttribute(CommonConst.SESSION_CATEGORY, listCategory);
         request.setAttribute("pageControl", pageControl );
         
         String url="/view/user/home.jsp" ;
      
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

    private List<Books> findBookDoGet(HttpServletRequest request, HttpServletResponse response, PageControl pageControl) {
        
        //get ve page 
        String pageRaw = request.getParameter("page") ;
        int page ;
        try {
            page = Integer.parseInt(pageRaw) ;
            if (page <= 0) {
                            page = 1 ;

            }
        } catch (Exception e) {
            page = 1 ;
        }
                List<Books> listBook ;
           String actionSearch = request.getParameter("search")== null ? "default" : request.getParameter("search") ;
            int totalRecord = 0  ;
        switch (actionSearch) {
            case "category":
                 String categoryID = request.getParameter("categoryID") ;
                 listBook = productDAO.findByCategoryID(categoryID , page) ;
                 pageControl.setUrlPattern(request.getRequestURI() + "?search=category&categoryID=" +  categoryID  + "&" );
                      totalRecord = productDAO.findTotalRecordByCategory(categoryID) ;
                break;
            case "keyword": 
                String keyword = request.getParameter("keyword") ;
                listBook = productDAO.findByKeyword(keyword , page) ;
               pageControl.setUrlPattern(request.getRequestURI() + "?search=keyword&keyword=" +  keyword + "&" );
                totalRecord = productDAO.findByKeyword(keyword).size() ;

                 break;
            default:
                listBook = productDAO.findAll(page) ;
                pageControl.setUrlPattern(request.getRequestURI() + "?");
                totalRecord = productDAO.findAll().size() ;
        }
        
        //total record

        //total page
        int totalPage = (totalRecord % CommonConst.RECORD_PER_PAGE == 0)
                ? (totalRecord / CommonConst.RECORD_PER_PAGE ) :(totalRecord / CommonConst.RECORD_PER_PAGE ) + 1 ;
        //set total record , total page ,page vao pageControl
        pageControl.setPage(page);
        pageControl.setTotalPage(totalPage);
        pageControl.setTotalRecord(totalRecord);
        
        return listBook ;

    }

}
