
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
    <%
        if (request.getMethod().equalsIgnoreCase("POST")) {
    %>
    <jsp:useBean id="sdto" class="com.kulchuri.feeder.subject.SubjectDto"></jsp:useBean>
    <jsp:setProperty name="sdto" property="*"></jsp:setProperty>
    <jsp:useBean id="sdao" class="com.kulchuri.feeder.subject.SubjectDao"></jsp:useBean>
    <%        
            if (sdao.addSubject(sdto)) {
                response.sendRedirect("admin_viewAllSubjects.jsp");
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
                    <h3 class="title-w3 mb-5 text-center text-wh font-weight-bold">New Branch</h3>
                    <%                    
                        ArrayList<BranchDto> al = dao.getAllBranches();
                        if (al != null) {

                    %>

                    <form action="admin_addSubject.jsp" method="post">
                        <div class="form-group">
                            <select name="bid" required="">
                                <option value="">---Select Branch---</option>
                                <%                                for (BranchDto bd : al) {
                                %>
                                <option value="<%=bd.getBid()%>"><%=bd.getBname()%></option>
                                <%}%>
                            </select>
                        </div>
                        <div class="form-group">
                            <select name="sem" required="">
                                <option value="">---Select Semester---</option>
                                <%                                for (int i = 1; i <= 8; i++) {
                                %>
                                <option value="<%=i%>"><%=i%></option>
                                <%}%>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="col-form-label">Subject Name</label>
                            <input type="text" required pattern="[A-z|\s]*" onclick="this.setCustomValidity(validity.patternMismatch ? 'Please Insert Only Alphabet' : '');" class="form-control" placeholder="Subject name" name="sname" required="">
                            <span style="color: red" id="bc"></span>
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
