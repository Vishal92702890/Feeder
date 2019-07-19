
<%@page import="com.kulchuri.feeder.student.StudentDto"%>
<%@page import="com.kulchuri.feeder.branch.BranchDto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="dao" class="com.kulchuri.feeder.branch.BranchDao"></jsp:useBean>
<jsp:useBean id="sdao" class="com.kulchuri.feeder.student.StudentDao"></jsp:useBean>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="head.html" %>
        <!--for calender-->
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
    </head>

    <%
        if (request.getMethod().equalsIgnoreCase("post")) {
    %>
    <jsp:useBean id="sdto" class="com.kulchuri.feeder.student.StudentDto"></jsp:useBean>
    <jsp:setProperty name="sdto" property="*"></jsp:setProperty>
    <%
            if (sdao.updateStudent(sdto)) {
                response.sendRedirect("admin_viewAllStudents.jsp");
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
                    <h3 class="title-w3 mb-5 text-center text-wh font-weight-bold">Update Student</h3>
                    <%
                        String eno = request.getParameter("eno");
                        if (eno != null) {
                            StudentDto dto = sdao.getStudent(eno);
                            if (dto != null) {
                                ArrayList<BranchDto> al = dao.getAllBranches();
                                if (al != null) {

                    %>
                    <form action="admin_editStudent.jsp" method="post">
                        <div class="form-group">
                            <select name="bid" required="" class="form-control">
                                <option value="<%=dto.getBid()%>"><%=dao.getBranch(dto.getBid()).getBname()%></option>
                                <%                                for (BranchDto bd : al) {
                                        if (bd.getBid() != dto.getBid()) {
                                %>
                                <option value="<%=bd.getBid()%>"><%=bd.getBname()%></option>
                                <%}
                                    }%>
                            </select>
                        </div>
                        <div class="form-group">
                            <select name="sem" required="" class="form-control">
                                <option value="<%=dto.getSem()%>"><%=dto.getSem()%></option>
                                <%                                for (int i = 1; i <= 8; i++) {
                                        if (dto.getSem() != i) {
                                %>
                                <option value="<%=i%>"><%=i%></option>
                                <%}
                                    }%>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="hidden" value="<%=dto.getEno()%>"  name="eno">

                        </div>

                        <div class="form-group">

                            <input type="text" required pattern="[A-z|\s]*" onclick="this.setCustomValidity(validity.patternMismatch ? 'Please Insert Only Alphabet' : '');" class="form-control" placeholder="Enter name" name="name" value="<%=dto.getName()%>" required="">
                            <span style="color: red" id="bc"></span>
                        </div>
                        <div class="form-group">

                            <input value="<%=dto.getEmail()%>" type="email" required="" class="form-control" placeholder="Enter email" name="email" required="">

                        </div>
                        <div class="form-group">

                            <input type="text" required="" class="form-control" placeholder="Enter mno" name="mno" value="<%=dto.getMno()%>" required="">
                            <span style="color: red" id="bc"></span>
                        </div>
                        <div class="form-group">
                            <input type="text" required="" class="form-control" placeholder="Select DOB" id="dob" value="<%=dto.getDob()%>" name="dob" required="">
                        </div>
                        <div class="form-group">
                            <%
                                if (dto.getGender().equalsIgnoreCase("male")) {
                            %>
                            <input type="radio" checked="" name="gender" value="Male"><span style="color: white; margin-left: 2%">Male</span>
                            <input type="radio" name="gender" value="Female"><span style="color: white; margin-left: 2%">Female</span>
                            <%} else {%>
                            <input type="radio" name="gender" value="Male"><span style="color: white; margin-left: 2%">Male</span>
                            <input type="radio" checked="" name="gender" value="Female"><span style="color: white; margin-left: 2%">Female</span>
                            <%}%>
                        </div>

                        <button type="submit" class="btn button-style-w3">Update</button>
                    </form>
                    <%}
                            }
                        }%>
                </div>
            </div>
        </div>
        <!-- //inner banner -->
    </body>
</html>
