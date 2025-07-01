<%-- 
    Document   : register
    Created on : 30 thg 6, 2025, 21:37:03
    Author     : legion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.min.js" integrity="sha384-RuyvpeZCxMJCqVUGFI0Do1mQrods/hhxYlcVfGPOfQtPJh0JCw12tUAZ/Mv10S7D" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <style>
            .rq{
                color: red ;
            }
        </style>
        <!-- Custom fonts for this template-->
        <link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">
    </head>
    
    <body>
        <%  
            String e_hoVaTen = (String) request.getSession().getAttribute("e_hoVaTen");
            String e_tenDangNhap = (String) request.getSession().getAttribute("e_tenDangNhap");
            String e_matKhau = (String) request.getSession().getAttribute("e_matKhau");
            String e_soDienThoai = (String) request.getSession().getAttribute("e_soDienThoai");
            String e_email = (String) request.getSession().getAttribute("e_email");
            String e_diaChi = (String) request.getSession().getAttribute("e_diaChi");
            String v_tenDangNhap = (String) request.getSession().getAttribute("v_tenDangNhap");
            String v_matKhau = (String) request.getSession().getAttribute("v_matKhau");
            String v_soDienThoai = (String) request.getSession().getAttribute("v_soDienThoai");
            String v_email = (String) request.getSession().getAttribute("v_email");
            String v_diaChi = (String) request.getSession().getAttribute("v_diaChi");
       
            String v_hoVaTen = (String) request.getSession().getAttribute("v_hoVaTen");
            




             
               if (v_tenDangNhap == null ) {
                    v_tenDangNhap = "";
                        }
               if (e_hoVaTen == null ) {
                    e_hoVaTen = "";
                        }

                   
                if (v_matKhau == null ) {
                    v_matKhau = "";
                }

                
                if (v_soDienThoai == null) {
                    v_soDienThoai = "";
                }

               
                if (v_email == null ) {
                    v_email = "";
                }

               
                if (v_diaChi == null ) {
                    v_diaChi = "";
                  }
                        if (e_tenDangNhap == null ) {
                            e_tenDangNhap = "";
                        }
                        if (e_matKhau == null ) {
                            e_matKhau = "";
                        }
                        if (e_soDienThoai == null ) {
                            e_soDienThoai = "";
                        }
                        if (e_email == null ) {
                            e_email = "";
                        }
                        if (e_diaChi == null ) {
                            e_diaChi = "";
                        }
                        if (v_hoVaTen == null ) {
                            v_hoVaTen = "";
                        }
 
        %>
        
         <!-- header-top-area-start -->
        <jsp:include page="../user/header-top-area.jsp"></jsp:include>
                <!-- header-top-area-end -->
            <jsp:include page="../user/header-mid-area.jsp"></jsp:include>

                <!-- header-mid-area-start -->

                <!-- header-mid-area-end -->
                <!-- main-menu-area-start -->
            <jsp:include page="../user/main-menu.jsp"></jsp:include>
                <!-- main-menu-area-end -->
                <!-- mobile-menu-area-start -->
            <jsp:include page="../user/mobile-menu.jsp"></jsp:include>
        <h1 style='text-align: center'>Đăng kí</h1>
        <div class="container ">
            <form class="row g-3 "  action="authen?action=register" id="myForm" method="post">

                <div class="col-12">
                    <label for="hoVaTen" class="form-label">Họ và tên:<font style="color: red">*</font></label>
                    <input type="text" class="form-control" id="hoVaTen" name="hoVaTen" value="<%= v_hoVaTen %>" >
                    <div class="rq"> <%= e_hoVaTen %>  </div>
                </div>
                <div class="col-md-6">
                    <label for="tenDangNhap" class="form-label">Tên đăng nhập:<font style="color: red">*</font></label>
                    <input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap" value="<%= v_tenDangNhap %>" >
                    <div class="rq"> <%= e_tenDangNhap %>  </div>
                </div>
                <div class="col-md-6">
                    <label for="matKhau" class="form-label">Mật khẩu:</label>
                    <input type="text" class="form-control" id="matKhau" name="matKhau" value="<%= v_matKhau  %>" >
             <div class="rq"><%= e_matKhau %></div>
                </div>
                <div class="col-md-6">
                    <label for="soDienThoai" class="form-label">Số điện thoại: </label>
                    <input type="text"  class="form-control" id="soDienThoai" name="soDienThoai" value="<%= v_soDienThoai  %>" >
                   <div class="rq"><%= e_soDienThoai %></div>
                </div>
                <div class="col-md-6">
                    <label for="email" class="form-label">Email:</label>
                    <input type="text" class="form-control" id="email" name="email" value="<%= v_email  %>" >
                    <div class="rq"><%= e_email %></div>
                </div>

                <div class="col-12">
                    <label for="diaChi" class="form-label" >Địa chỉ:</label>
                    <textarea id="diaChi" name="diaChi" rows="5" cols="100" class="form-control" ><%= v_diaChi  %></textarea>
                    <div class="rq"><%= e_diaChi %></div>
                    

                </div>

                <div class="col-12">
                    <button class="btn btn-primary" type="submit" >Đăng kí</button>
                </div>
            </div>
                    
                    <jsp:include page="../user/footer.jsp"></jsp:include>


        <!-- Bootstrap core JavaScript-->
        <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

                </body>
                </html>
