<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include  file="head.html" %>
    </head>
    <body>
        <%@include file="main_header.html" %>
        <!-- banner -->
        <div class="main-w3pvt mian-content-wthree text-center" id="home">
            <div class="container">
                <div class="style-banner mx-auto">
                    <h3 class="text-wh font-weight-bold">Welcome to <span>Feeder</span> </h3>
                    <!-- form -->
                    <div class="home-form-w3ls mt-5">
                        <form action="#" method="post">
                            <div class="row" style="margin-left: 25%; width: 100%">
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <input class="form-control" type="text" name="uname" placeholder="Username" required="">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" type="password" name="pwd" placeholder="Password" required="">
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn_apt btn">Signin</button>
                        </form>
                    </div>
                    <!-- //form -->
                </div>
            </div>
        </div>
        <!-- //banner -->

    </body>
</html>
