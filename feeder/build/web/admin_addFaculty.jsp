
<%@page import="com.kulchuri.feeder.branch.BranchDto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="dao" class="com.kulchuri.feeder.branch.BranchDao"></jsp:useBean>

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" type="text/css" media="all" href="calander/jsDatePick_ltr.min.css" />
            <script type="text/javascript" src="calander/jsDatePick.min.1.3.js"></script>
            <script type="text/javascript">
                window.onload = function () {
                    new JsDatePick({
                        useMode: 2,
                        target: "dob",
                        dateFormat: "%Y-%M-%d"
                    });
                };
            </script>
        <%@include file="head.html" %>
    </head>

    <%
        if (request.getMethod().equalsIgnoreCase("post")) {
    %>
    <jsp:useBean id="dto" class="com.kulchuri.feeder.faculty.FacultyDto"></jsp:useBean>
    <jsp:setProperty name="dto" property="*"></jsp:setProperty>
    <jsp:useBean id="fdao" class="com.kulchuri.feeder.faculty.FacultyDao"></jsp:useBean>
    <%        
            String fid = fdao.addFaculty(dto);
            if (fid != null) {
                response.sendRedirect("admin_addPhotoFaculty.jsp?fid=" + fid);
            }
        }
    %>




    <body>
        <%@include file="admin_header.html" %>
        <!-- inner banner -->
        <div class="inner-banner-w3ls py-5">
            <div class="container py-xl-5 py-lg-3">
                <!-- register  -->
                <div class="modal-body mt-md-2 mt-5">
                    <h3 class="title-w3 mb-5 text-center text-wh font-weight-bold">New Faculty</h3>
                    <%                    
                        ArrayList<BranchDto> al = dao.getAllBranches();
                        if (al != null) {
                    %>
                    <form action="admin_addFaculty.jsp" method="post">
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
                        </div>
                        <div class="form-group">
                            <input type="text" required="" class="form-control" placeholder="Select DOB" id="dob" name="dob" required="">
                        </div>
                        <div class="form-group">
                            <input type="radio" name="gender" value="Male"><span style="color: white; margin-left: 2%">Male</span>
                            <input type="radio" name="gender" value="Female"><span style="color: white; margin-left: 2%">Female</span>
                        </div>
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
                            <input type="text" required="" class="form-control" placeholder="Enter experience" name="exp" required="">
                        </div>
                        <div class="form-group">
                            <input type="text" required="" class="form-control" placeholder="Enter address" name="address" required="">
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
