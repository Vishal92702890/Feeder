
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
                    <h3 class="title-w3 mb-5 text-center text-wh font-weight-bold">Add Photo</h3>

                    <form action="FacultyController" enctype="multipart/form-data" method="post">
                        <div class="form-group">
                            <input type="hidden" value="<%=request.getParameter("fid")%>"  name="fid" >
                        </div>
                        <div class="form-group">
                            <input type="file" name="photo" class="form-control" required=""/>
                        </div>

                        <button type="submit" name="opn" value="Update" class="btn button-style-w3">Add Photo</button>
                    </form>
                    <%}%>
                </div>
            </div>
        </div>
        <!-- //inner banner -->
    </body>
</html>
