<%-- 
    Document   : main-menu
    Created on : 15 thg 6, 2025, 00:29:55
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
        <div class="main-menu-area d-md-none d-none d-lg-block sticky-header-1" id="header-sticky">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="menu-area">
                                <nav>
                                    <ul>
                                        <li class="active"><a href="index.html">Home<i class="fa fa-angle-down"></i></a>
                                            <div class="sub-menu">
                                                <ul>
                                                    <li><a href="index.html">Home-1</a></li>
                                                    <li><a href="index-2.html">Home-2</a></li>
                                                    <li><a href="index-3.html">Home-3</a></li>
                                                    <li><a href="index-4.html">Home-4</a></li>
                                                    <li><a href="index-5.html">Home-5</a></li>
                                                    <li><a href="index-6.html">Home-6</a></li>
                                                    <li><a href="index-7.html">Home-7</a></li>
                                                </ul>
                                            </div>
                                        </li>
                                        <li><a href="product-details.html">Book<i class="fa fa-angle-down"></i></a>
                                            <div class="mega-menu">
                                                <span>
                                                    <a href="#" class="title">Jackets</a>
                                                    <a href="shop.html">Tops & Tees</a>
                                                    <a href="shop.html">Polo Short Sleeve</a>
                                                    <a href="shop.html">Graphic T-Shirts</a>
                                                    <a href="shop.html">Jackets & Coats</a>
                                                    <a href="shop.html">Fashion Jackets</a>
                                                </span>
                                                <span>
                                                    <a href="#" class="title">weaters</a>
                                                    <a href="shop.html">Crochet</a>
                                                    <a href="shop.html">Sleeveless</a>
                                                    <a href="shop.html">Stripes</a>
                                                    <a href="shop.html">Sweaters</a>
                                                    <a href="shop.html">hoodies</a>
                                                </span>
                                                <span>
                                                    <a href="#" class="title">Bottoms</a>
                                                    <a href="shop.html">Heeled sandals</a>
                                                    <a href="shop.html">Polo Short Sleeve</a>
                                                    <a href="shop.html">Flat sandals</a>
                                                    <a href="shop.html">Short Sleeve</a>
                                                    <a href="shop.html">Long Sleeve</a>
                                                </span>
                                                <span>
                                                    <a href="#" class="title">Jeans Pants</a>
                                                    <a href="shop.html">Polo Short Sleeve</a>
                                                    <a href="shop.html">Sleeveless</a>
                                                    <a href="shop.html">Graphic T-Shirts</a>
                                                    <a href="shop.html">Hoodies</a>
                                                    <a href="shop.html">Jackets</a>
                                                </span>
                                            </div>
                                        </li>
                                        <li><a href="product-details.html">Audio books<i class="fa fa-angle-down"></i></a>
                                            <div class="mega-menu">
                                                <span>
                                                    <a href="#" class="title">Shirts</a>
                                                    <a href="shop.html">Tops & Tees</a>
                                                    <a href="shop.html">Sweaters </a>
                                                    <a href="shop.html">Hoodies</a>
                                                    <a href="shop.html">Jackets & Coats</a>
                                                </span>
                                                <span>
                                                    <a href="#" class="title">Tops & Tees</a>
                                                    <a href="shop.html">Long Sleeve </a>
                                                    <a href="shop.html">Short Sleeve</a>
                                                    <a href="shop.html">Polo Short Sleeve</a>
                                                    <a href="shop.html">Sleeveless</a>
                                                </span>
                                                <span>
                                                    <a href="#" class="title">Jackets</a>
                                                    <a href="shop.html">Sweaters</a>
                                                    <a href="shop.html">Hoodies</a>
                                                    <a href="shop.html">Wedges</a>
                                                    <a href="shop.html">Vests</a>
                                                </span>
                                                <span>
                                                    <a href="#" class="title">Jeans Pants</a>
                                                    <a href="shop.html">Polo Short Sleeve</a>
                                                    <a href="shop.html">Sleeveless</a>
                                                    <a href="shop.html">Graphic T-Shirts</a>
                                                    <a href="shop.html">Hoodies</a>
                                                </span>
                                            </div>
                                        </li>
                                        <li><a href="product-details.html">children’s books<i class="fa fa-angle-down"></i></a>
                                            <div class="mega-menu mega-menu-2">
                                                <span>
                                                    <a href="#" class="title">Tops</a>
                                                    <a href="shop.html">Shirts</a>
                                                    <a href="shop.html">Florals</a>
                                                    <a href="shop.html">Crochet</a>
                                                    <a href="shop.html">Stripes</a>
                                                </span>
                                                <span>
                                                    <a href="#" class="title">Bottoms</a>
                                                    <a href="shop.html">Shorts</a>
                                                    <a href="shop.html">Dresses</a>
                                                    <a href="shop.html">Trousers</a>
                                                    <a href="shop.html">Jeans</a>
                                                </span>
                                                <span>
                                                    <a href="#" class="title">Shoes</a>
                                                    <a href="shop.html">Heeled sandals</a>
                                                    <a href="shop.html">Flat sandals</a>
                                                    <a href="shop.html">Wedges</a>
                                                    <a href="shop.html">Ankle boots</a>
                                                </span>
                                            </div>
                                        </li>
                                        <li><a href="#">blog<i class="fa fa-angle-down"></i></a>
                                            <div class="sub-menu sub-menu-2">
                                                <ul>
                                                    <li><a href="blog.html">blog</a></li>
                                                    <li><a href="blog-details.html">blog-details</a></li>
                                                </ul>
                                            </div>
                                        </li>
                                        <li><a href="#">pages<i class="fa fa-angle-down"></i></a>
                                            <div class="sub-menu sub-menu-2">
                                                <ul>
                                                    <li><a href="shop.html">shop</a></li>
                                                    <li><a href="shop-list.html">shop list view</a></li>
                                                    <li><a href="product-details.html">product-details</a></li>
                                                    <li><a href="product-details-affiliate.html">product-affiliate</a></li>
                                                    <li><a href="blog.html">blog</a></li>
                                                    <li><a href="blog-details.html">blog-details</a></li>
                                                    <li><a href="contact.html">contact</a></li>
                                                    <li><a href="about.html">about</a></li>
                                                    <li><a href="login.html">login</a></li>
                                                    <li><a href="register.html">register</a></li>
                                                    <li><a href="my-account.html">my-account</a></li>
                                                    <li><a href="cart.html">cart</a></li>
                                                    <li><a href="compare.html">compare</a></li>
                                                    <li><a href="checkout.html">checkout</a></li>
                                                    <li><a href="wishlist.html">wishlist</a></li>
                                                    <li><a href="404.html">404 Page</a></li>
                                                </ul>
                                            </div>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                            <div class="safe-area">
                                <a href="product-details.html">sales off</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>
