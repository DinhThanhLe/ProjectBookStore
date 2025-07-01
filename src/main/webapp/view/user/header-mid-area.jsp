<%-- 
    Document   : header-mid-area
    Created on : 14 thg 6, 2025, 23:57:17
    Author     : legion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Koparion – Book Shop HTML5 Template</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">

        <!-- all css here -->
        <!-- bootstrap v3.3.6 css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <!-- animate css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
        <!-- meanmenu css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/meanmenu.min.css">
        <!-- owl.carousel css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.css">
        <!-- font-awesome css -->
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- flexslider.css-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/flexslider.css">
        <!-- chosen.min.css-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/chosen.min.css">
        <!-- style css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        <!-- responsive css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css">
        <!-- modernizr css -->
        <script src="${pageContext.request.contextPath}/${pageContext.request.contextPath}/js/vendor/modernizr-2.8.3.min.js"></script>
    </head>
    <body>
         <div class="header-mid-area ptb-40">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-5 col-12">
                            <div class="header-search">
                                
                                <form action="${pageContext.request.contextPath}/home">
                                     <input type="hidden" name="search" value="keyword"/>
                                    <input type="text" placeholder="Search entire store here..." name="keyword"/>
                                    <a href="#" onclick="return this.closest('form').submit()"><i class="fa fa-search"></i></a>
                                </form>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-4 col-12">
                            <div class="logo-area text-center logo-xs-mrg">
                                <a href="${pageContext.request.contextPath}/home"><img src="${pageContext.request.contextPath}/img/logo/logo.jpg" alt="logo" /></a>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-12">
                            <div class="my-cart">
                                <ul>
                                    <li><a href="#"><i class="fa fa-shopping-cart"></i>My Cart</a>
                                        <span>2</span>
                                        <div class="mini-cart-sub">
                                            <div class="cart-product">
                                                <div class="single-cart">
                                                    <div class="cart-img">
                                                        <a href="#"><img src="${pageContext.request.contextPath}/img/product/1.jpg" alt="book" /></a>
                                                    </div>
                                                    <div class="cart-info">
                                                        <h5><a href="#">Joust Duffle Bag</a></h5>
                                                        <p>1 x £60.00</p>
                                                    </div>
                                                    <div class="cart-icon">
                                                        <a href="#"><i class="fa fa-remove"></i></a>
                                                    </div>
                                                </div>
                                                <div class="single-cart">
                                                    <div class="cart-img">
                                                        <a href="#"><img src="${pageContext.request.contextPath}/img/product/3.jpg" alt="book" /></a>
                                                    </div>
                                                    <div class="cart-info">
                                                        <h5><a href="#">Chaz Kangeroo Hoodie</a></h5>
                                                        <p>1 x £52.00</p>
                                                    </div>
                                                    <div class="cart-icon">
                                                        <a href="#"><i class="fa fa-remove"></i></a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="cart-totals">
                                                <h5>Total <span>£12.00</span></h5>
                                            </div>
                                            <div class="cart-bottom">
                                                <a class="view-cart" href="cart.html">view cart</a>
                                                <a href="checkout.html">Check out</a>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>
