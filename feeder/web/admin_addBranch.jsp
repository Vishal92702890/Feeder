
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="head.html" %>

        <script>

            function checkDuplicateBranch() {
                var obj = new XMLHttpRequest();
                var bname = document.getElementById("bname").value;
                obj.onreadystatechange = function () {
                    if (obj.readyState == 4 && obj.status == 200) {
                        var data = obj.responseText;
                        document.getElementById("bc").innerHTML = data;
                    }
                }
                obj.open("POST", "checkDuplicate.jsp?bname=" + bname + "&opn=bname", true);
                obj.send();
            }
        </script>


    </head>
    <%
        if (request.getMethod().equalsIgnoreCase("post")) {
    %>
    <jsp:useBean id="dto" class="com.kulchuri.feeder.branch.BranchDto"></jsp:useBean>
    <jsp:setProperty name="dto" property="*"></jsp:setProperty>
    <jsp:useBean id="dao" class="com.kulchuri.feeder.branch.BranchDao"></jsp:useBean>
    <%
        if (dao.addBranch(dto)) {
    %>
    <%="<script> alert('Success')</script>"%>
    <%
    } else {
    %>
    "<script> alert('Failed')</script>"
    <%
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
                    <form action="admin_addBranch.jsp" method="post">
                        <div class="form-group">
                            <label class="col-form-label">Branch name</label>
                            <input type="text" onchange="checkDuplicateBranch()" id="bname" required pattern="[A-z|\s]*" onclick="this.setCustomValidity(validity.patternMismatch ? 'Please Insert Only Alphabet' : '');" class="form-control" placeholder="Branch name" name="bname" required="">
                            <span style="color: red" id="bc"></span>
                        </div>
                        <button type="submit" class="btn button-style-w3">Add</button>
                    </form>
                </div>
            </div>
        </div>
        <!-- //inner banner -->
    </body>
</html>
