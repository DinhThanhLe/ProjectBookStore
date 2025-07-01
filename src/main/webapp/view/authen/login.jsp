<%-- 
    Document   : login
    Created on : 27 thg 6, 2025, 22:10:47
    Author     : legion
--%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Admin - Login</title>

        <!-- Custom fonts for this template-->
        <link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">

    </head>

    <body class="bg-light">
        
        
        
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

        <div class="container">
            <div class="card card-login mx-auto mt-5">
                <div class="card-header">Login</div>
                <div class="card-body">
                    <form action="authen?action=login" method="post">
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="text" id="username" name="username" class="form-control" placeholder="username" required="required" autofocus="autofocus">
                                <label for="username">Username</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="required">
                                <label for="inputPassword">Password</label>
                            </div>
                        </div>
                      
                        <input class="btn btn-primary btn-block"  type="submit" value="login"/>
                        <span style="color: red">${error}</span>
                    </form>
                    <div class="text-center">
                        <a class="d-block small mt-3" href="register.html">Register an Account</a>
                       
                    </div>
                </div>
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

