
<%@page import="com.kulchuri.feeder.utility.FeederUtility"%>
<%@page import="com.mysql.jdbc.StringUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="head.html" %>
    </head>
    <jsp:useBean id="dto" class="com.kulchuri.feeder.branch.BranchDto"></jsp:useBean>
    <jsp:useBean id="dao" class="com.kulchuri.feeder.branch.BranchDao"></jsp:useBean>

    <%
        if (request.getMethod().equalsIgnoreCase("post")) {
    %>
    <jsp:setProperty name="dto" property="*"></jsp:setProperty>
    <%
            if (dao.updateBranch(dto)) {
                response.sendRedirect("admin_viewAllBranches.jsp");
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
                    <h3 class="title-w3 mb-5 text-center text-wh font-weight-bold">Update Branch</h3>
                    <%
                        String bid = request.getParameter("bid");
                        if (bid != null && FeederUtility.isNumeric(bid)) {
                            dto = dao.getBranch(Integer.parseInt(bid));
                            if (dto != null) {
                    %>                    
                    <form action="admin_editBranch.jsp" method="post">
                        <div class="form-group">
                            <label class="col-form-label">Branch name</label>
                            <input type="hidden" name="bid" value="<%=bid%>"/>
                            <input type="text" value="<%=dto.getBname()%>" onchange="checkDuplicateBranch()" id="bname" required pattern="[A-z|\s]*" onclick="this.setCustomValidity(validity.patternMismatch ? 'Please Insert Only Alphabet' : '');" class="form-control" placeholder="Branch name" name="bname" required="">
                            <span style="color: red" id="bc"></span>
                        </div>
                        <button type="submit" class="btn button-style-w3">Update</button>
                    </form>
                    <%} else {
                    %>
                    <center>
                        <h1 style="color: white">This Branch is not available in DB.

                            <a href="admin_viewAllBranches.jsp">Click Here</a>

                        </h1>

                    </center>

                    <%
                        }
                    } else {%>
                    <center>
                        <h1 style="color: white">Please select branch first to update
                            <a href="admin_viewAllBranches.jsp">Click Here</a>
                        </h1>
                    </center>
                    <%}%>
                </div>
            </div>
        </div>
        <!-- //inner banner -->
    </body>
</html>
