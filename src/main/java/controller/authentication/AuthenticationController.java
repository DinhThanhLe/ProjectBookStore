/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.authentication;

import dal.implement.UserDao;
import jakarta.jms.Session;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;
import model.Users;

/**
 *
 * @author legion
 */
public class AuthenticationController extends HttpServlet {
    UserDao userDao = new UserDao() ;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
 response.setContentType("text/html; charset=UTF-8");
       //get ve action
       String action = request.getParameter("action") == null ? "" : request.getParameter("action");
       String url ;
        switch (action) {
            case "login":
                 url ="view/authen/login.jsp" ;
                break;
          case "logout":
                url =  logOut(request,response) ;
                break;
          case "register":
                url =  "view/authen/register.jsp" ;
                break;
            default:
               url="home" ;
        }
       request.getRequestDispatcher(url).forward(request, response);
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
 response.setContentType("text/html; charset=UTF-8");
        
         String action = request.getParameter("action") == null ? "" : request.getParameter("action");
       String url ;
       switch (action) {
            case "login":
                url =  login(request,response) ;
                break;
            case "register":
                url =  register(request,response) ;
                break;
            
            default:
               url="home" ;
        }
      response.sendRedirect(url);
       
        
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

    private String login(HttpServletRequest request, HttpServletResponse response) {
 // get ve thong tin 
 String username = request.getParameter("username") ;
 String password = request.getParameter("password") ;
 
 String url ;
 
 //kiem tra thong tin co trong db khong
        Users user = Users.builder()
                .username(username)
                .password_hash(password)
                .build()  ;
        
        
        Users useFindByUsernameAndPass = userDao.findByUsernameAndPass(user) ;
        if (useFindByUsernameAndPass != null && useFindByUsernameAndPass.getRole().equals("admin")) {
            return  request.getContextPath() + "/admin/dashboard" ;
        }
        
        if (useFindByUsernameAndPass != null) {
            // trang home (set acc vao sesion)
            HttpSession session = request.getSession() ;
            session.setAttribute("accountSesion", useFindByUsernameAndPass);
            url ="home" ;
        }else{
             //false -> quay ve login

            request.getSession().setAttribute("error", "Sai tài khoản hoặc mật khẩu");
            url = "authen?action=login" ;
        }
        
 
 
 
 
 
 




         return url ;

    }

    private String logOut(HttpServletRequest request, HttpServletResponse response) {
         request.getSession().removeAttribute("accountSesion");
         return "home" ;


    }

    private String register(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
      
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
   String hoVaTen = request.getParameter("hoVaTen") ;
   String tenDangNhap = request.getParameter("tenDangNhap") ;
   String matKhau = request.getParameter("matKhau") ;
   String soDienThoai = request.getParameter("soDienThoai") ;
   String email = request.getParameter("email") ;
   String diaChi = request.getParameter("diaChi") ;
        UserDao userDao = new UserDao() ;
   
    String e_hoVaTen ="" ;
        if (hoVaTen.trim().isEmpty()) {
            e_hoVaTen = "Không được để trống tên đăng nhập" ; 
        }
    String e_tenDangNhap ="" ;
        if (tenDangNhap.trim().isEmpty()) {
            e_tenDangNhap = "Không được để trống tên đăng nhập" ; 
        }
        
              
       
      String e_matKhau ="" ;
        if (matKhau.trim().isEmpty()) {
            e_matKhau = "Không được để trống mật khẩu" ; 
        }
        if (matKhau.trim().length() < 5) {
            e_matKhau = "Mật khẩu phải nhiều hơn 5 kí tự" ; 
        }
        String e_soDienThoai="" ;
        if (!Pattern.matches("^0\\d+$", soDienThoai)) {
            e_soDienThoai = "Số điện thoại không hợp lệ" ;
        }
        String e_email = "" ;
        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email)) {
            e_email = "Email không hợp lệ" ;
        }
         String e_diaChi ="" ;
        if (diaChi.trim().isEmpty()) {
            e_diaChi = "Không được để trống địa chỉ" ; 
        }
        
        if (userDao.timKiemTaiKhoanTonTai(tenDangNhap) != null) {
            e_tenDangNhap = "Tên đăng nhập đã tồn tại" ;
        }
        
         request.getSession().setAttribute("v_tenDangNhap", tenDangNhap);
         request.getSession().setAttribute("v_hoVaTen", hoVaTen);
         request.getSession().setAttribute("v_matKhau", matKhau);
         request.getSession().setAttribute("v_soDienThoai", soDienThoai);
         request.getSession().setAttribute("v_email", email);
         request.getSession().setAttribute("v_diaChi", diaChi);
         
         
         request.getSession().setAttribute("e_hoVaTen", e_hoVaTen);
         request.getSession().setAttribute("e_tenDangNhap", e_tenDangNhap);
         request.getSession().setAttribute("e_matKhau",e_matKhau );
         request.getSession().setAttribute("e_soDienThoai",e_soDienThoai );
         request.getSession().setAttribute("e_email",e_email );
         request.getSession().setAttribute("e_diaChi",e_diaChi );
         String url = "/user/dangnhap.jsp";
                   if (e_tenDangNhap.length() > 0 || e_diaChi.length() >0 
                 || e_email.length() > 0 || e_soDienThoai.length() > 0 || e_matKhau.length() > 0   || e_hoVaTen.length() > 0 )
              {
                 return  "authen?action=register";
              } else {
                       Users newUser  = Users.builder()
                               .username(tenDangNhap)
                               .password_hash(matKhau)
                               .email(email)
                               .full_name(hoVaTen)
                               .address(diaChi)
                               .phone_number(soDienThoai)
                               .role("user").build() ;
                       
                       userDao.insert(newUser) ;
                       request.getSession().setAttribute("accountSesion", newUser);
                       return "home" ;
                   }
              
               
         
          




    }

}
