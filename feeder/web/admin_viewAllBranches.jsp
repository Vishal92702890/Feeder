
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
        <div>
            <%@include file="admin_header.html" %>
        </div>
        <div style="width: 50%; margin-left: 25%">
            <div >
                <table id="customers"  >
                    <tr>
                        <th>S.NO.</th>
                        <th>Name</th>
                        <th>Action</th>
                    </tr>
                    <%
                        String bid = request.getParameter("bid");
                        if (bid != null) {
                            dao.deleteBranch(Integer.parseInt(bid));
                        }
                        ArrayList<BranchDto> al = dao.getAllBranches();
                        if (al != null) {
                            int s = 0;
                            for (BranchDto dto : al) {
                    %>
                    <tr>
                        <td><%=++s%></td>
                        <td><%=dto.getBname()%></td>
                        <td>
                            <a href="admin_editBranch.jsp?bid=<%=dto.getBid()%>">Edit</a>
                            <a href="admin_viewAllBranches.jsp?bid=<%=dto.getBid()%>">Delete</a>
                        </td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <center>
                        <h1 style="color: red">There are no data in database</h1>
                    </center>
                    <%        
                        }
                    %>
                </table>
            </div>
        </div>

    </body>
</html>
