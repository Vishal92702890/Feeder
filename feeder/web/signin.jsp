<%@page import="com.kulchuri.feeder.student.StudentDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include  file="head.html" %>
    </head>
    <%
        if (request.getMethod().equalsIgnoreCase("post")) {
            String uname = request.getParameter("uname");
            String pwd = request.getParameter("pwd");
            String ltype = request.getParameter("ltype");
            if (ltype.equalsIgnoreCase("admin")) {
                
            } else if (ltype.equalsIgnoreCase("student")) {
                if (new StudentDao().login(uname, pwd)) {
                    session.setAttribute("eno", uname);
                    response.sendRedirect("student_Home.jsp");
                } else {
                    out.print("<script>alert('Please Enter Valid Login Details')</script>");
                }
            } else {
                
            }
        }
    %>

    <body>
        <%@include file="main_header.html" %>
        <!-- inner banner -->
        <div class="inner-banner-w3ls py-5">
            <div class="container py-xl-5 py-lg-3">
                <!-- register  -->
                <div class="modal-body mt-md-2 mt-5">
                    <h3 class="title-w3 mb-5 text-center text-wh font-weight-bold">Login</h3>
                    <form action="signin.jsp" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Enter email" name="uname" required="">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Enter password" name="pwd" required="">
                        </div>
                        <div class="form-group">
                            <select class="form-control" name="ltype">
                                <option value="Admin">Admin</option>
                                <option value="Student">Student</option>
                                <option value="Faculty">Faculty</option>
                            </select>
                        </div>
                        <button type="submit" class="btn button-style-w3">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
