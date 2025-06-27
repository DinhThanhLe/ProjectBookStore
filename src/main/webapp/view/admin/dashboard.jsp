<%-- 
    Document   : dashboard
    Created on : 22 thg 6, 2025, 18:03:21
    Author     : legion
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SB Admin - Dashboard</title>

        <!-- Custom fonts for this template-->
        <link href="<%= request.getContextPath() %>/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="<%= request.getContextPath() %>/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="<%= request.getContextPath() %>/css/sb-admin.css" rel="stylesheet">

        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/colReorder-bootstrap4.css">

        <style>
            .error{
                Add commentMore actions
                color:red;
            }
        </style>
    </head>
    <% 
    
         request.setCharacterEncoding("UTF-8");
         response.setCharacterEncoding("UTF-8");
         response.setContentType("text/html; charset=UTF-8");
    %>

    <body id="page-top">

        <!--Navbar-->
        <jsp:include page="navbar.jsp"></jsp:include>

            <div id="wrapper">
                <!-- Sidebar -->
            <jsp:include page="sideBar.jsp"></jsp:include>



                <div id="content-wrapper">

                    <div class="container-fluid">

                        <!-- Breadcrumbs-->
                    <jsp:include page="breadcrumbs.jsp"></jsp:include>

                        <!-- Icon Cards-->
                    <jsp:include page="iconCard.jsp"></jsp:include>



                        <!-- DataTables Example -->
                        <div class="card mb-3">
                            <div class="card-header">
                                <i class="fas fa-table"></i>
                                Data Table Example
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Id Book</th>
                                                <th>Id Variant</th>
                                                
                                                <th>Title</th>
                                                <th>Image</th>
                                                <th>Category</th>
                                                <th>Author</th>
                                                <th>Language</th>
                                                <th>Material</th>
                                                <th>Stock</th>
                                                <th>Price</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                        <c:forEach items="${listBookVariant}" var="b" > 
                                            <tr>
                                                <td name="idBook">${b.book_id}</td>
                                                <td name="idVar">${b.variant_id}</td>
                                                <td name ="title">${b.title}</td>
                                                <td name="image">
                                             <img src="${pageContext.request.contextPath}/img/product/${b.cover_image_url}" width="100" height="100" alt="alt"/>
      

                                                </td>
                                                <td name ="category">${b.category_name}</td>
                                                <td name="author">${b.author_name}</td>
                                                <td name="language">${b.language_name}</td>
                                                <td name="material">${b.material_type}</td>
                                                <td name="stock">${b.stock_quantity}</td>
                                                <td name="price">${b.price}</td>
                                                <td>
                                                    <button type="button" class="btn btn-primary"
                                                            data-toggle="modal" 
                                                            data-target="#editProductModal"
                                                            onclick="editProductModal(this)">
                                                        Edit
                                                    </button>
                                                    <button type="button" class="btn btn-danger" 
                                                            data-toggle="modal" data-target="#delete-product-modal"
                                                            onclick="deleteProductModal(${b.book_id} ,${b.variant_id} )">
                                                        Delete
                                                    </button>
                                                </td>

                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                    </div>

                </div>
                <!-- /.container-fluid -->

                <!-- Sticky Footer -->
                <jsp:include page="footer.jsp"></jsp:include>

                </div>
                <!-- /.content-wrapper -->


                <!-- /#wrapper -->

                <!-- Scroll to Top Button-->
                <a class="scroll-to-top rounded" href="<%= request.getContextPath() %>/#page-top">
                <i class="fas fa-angle-up"></i>
            </a>

            
            
            
            <script>
  console.log("EDIT_MODAL LOADED:", typeof window.editProductModal);
</script>
                <!-- Bootstrap core JavaScript-->
                <script src="<%= request.getContextPath() %>/vendor/jquery/jquery.min.js"></script>
            <script src="<%= request.getContextPath() %>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="<%= request.getContextPath() %>/vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Page level plugin JavaScript-->
            <script src="<%= request.getContextPath() %>/vendor/chart.js/Chart.min.js"></script>
            <script src="<%= request.getContextPath() %>/vendor/datatables/jquery.dataTables.js"></script>
            <script src="<%= request.getContextPath() %>/vendor/datatables/dataTables.bootstrap4.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="<%= request.getContextPath() %>/js/sb-admin.min.js"></script>
            
           

            <!-- Demo scripts for this page-->
            <script src="<%= request.getContextPath() %>/js/demo/datatables-demo.js"></script>
            <script src="<%= request.getContextPath() %>/js/demo/chart-area-demo.js"></script>
            <script src="<%= request.getContextPath() %>/js/colReorder-dataTables-min.js"></script>
            <script src="<%= request.getContextPath() %>/js/colReorder-bootstrap4-min.js"></script>
          <!-- Logout Modal-->
            <jsp:include page="logoutModal.jsp"></jsp:include>
            
            <jsp:include page="addProductModal.jsp"></jsp:include>
            
            <jsp:include page="deleteProductModal.jsp"></jsp:include>
            <jsp:include page="editProductModal.jsp"></jsp:include>
           
           
    </body>

</html>
