
<%@page import="com.kulchuri.feeder.branch.BranchDto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="dao" class="com.kulchuri.feeder.branch.BranchDao"></jsp:useBean>

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="head.html" %>
    </head>

    <body>
        <%@include file="admin_header.html" %>
        <!-- inner banner -->
        <div class="inner-banner-w3ls py-5">
            <div class="container py-xl-5 py-lg-3">
                <!-- register  -->
                <div class="modal-body mt-md-2 mt-5">
                    <h3 class="title-w3 mb-5 text-center text-wh font-weight-bold">New Branch</h3>
                    <%
                        ArrayList<BranchDto> al = dao.getAllBranches();
                        if (al != null) {

                    %>
                    <form action="StudentControllerServlet" enctype="multipart/form-data" method="post">
                        <div class="form-group">
                            <select name="bid" required="" class="form-control">
                                <option value="">---Select Branch---</option>
                                <%                                for (BranchDto bd : al) {
                                %>
                                <option value="<%=bd.getBid()%>"><%=bd.getBname()%></option>
                                <%}%>
                            </select>
                        </div>
                        <div class="form-group">
                            <select name="sem" required="" class="form-control">
                                <option value="">---Select Semester---</option>
                                <%                                for (int i = 1; i <= 8; i++) {
                                %>
                                <option value="<%=i%>"><%=i%></option>
                                <%}%>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="text" required class="form-control" placeholder="Enter eno" name="eno" required="">
                            <span style="color: red" id="bc"></span>
                        </div>

                        <div class="form-group">

                            <input type="text" required pattern="[A-z|\s]*" onclick="this.setCustomValidity(validity.patternMismatch ? 'Please Insert Only Alphabet' : '');" class="form-control" placeholder="Enter name" name="name" required="">
                            <span style="color: red" id="bc"></span>
                        </div>
                        <div class="form-group">

                            <input type="email" required="" class="form-control" placeholder="Enter email" name="email" required="">
                            <span style="color: red" id="bc"></span>
                        </div>
                        <div class="form-group">

                            <input type="password" required class="form-control" placeholder="Enter password" name="pwd" required="">
                            <span style="color: red" id="bc"></span>
                        </div>
                        <div class="form-group">

                            <input type="text" required="" class="form-control" placeholder="Enter mno" name="mno" required="">
                            <span style="color: red" id="bc"></span>
                        </div>
                        <div class="form-group">
                            <input type="text" required="" class="form-control" placeholder="Select DOB" name="dob" required="">
                        </div>
                        <div class="form-group">
                            <input type="radio" name="gender" value="Male"><span style="color: white; margin-left: 2%">Male</span>
                            <input type="radio" name="gender" value="Female"><span style="color: white; margin-left: 2%">Female</span>
                        </div>
                        <div class="form-group">
                            <input type="file" name="photo" class="form-control" required=""/>
                        </div>
                </div>
                <button type="submit" class="btn button-style-w3">Add</button>
                </form>
                <%}%>
            </div>
        </div>
    </div>
    <!-- //inner banner -->
</body>
</html>
