
<%@page import="com.kulchuri.feeder.student.StudentDto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="dao" class="com.kulchuri.feeder.student.StudentDao"></jsp:useBean>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="head.html" %>
    </head>
    <body>
        <%@include file="admin_header.html" %>
        <div>
            <table id="customers">
                <tr>
                    <th>S.NO.</th>
                    <th>E.NO.</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Mobile</th>
                    <th>Gender</th>
                    <th>Semester</th>

                    <th>D.O.B</th>
                    <th>Photo</th>
                    <th>Action</th>
                </tr>
                <%
                    String eno = request.getParameter("eno");
                    if (eno != null) {
                        dao.deleteStudent(eno);
                    }
                    ArrayList<StudentDto> al = dao.getAllStudents();
                    if (al != null) {
                        int s = 0;
                        for (StudentDto sd : al) {
                %>
                <tr>
                    <td><%=++s%></td>
                    <td><%=sd.getEno()%></td>
                    <td><%=sd.getName()%></td>
                    <td><%=sd.getEmail()%></td>
                    <td><%=sd.getMno()%></td>
                    <td><%=sd.getGender()%></td>
                    <td><%=sd.getSem()%></td>
                    <td><%=sd.getDob()%></td>
                    <td>
                        <img src="data:image/jpeg;base64,<%=sd.getPhoto()%>" width="50" height="50">
                <br><center><a href="admin_changeStudentPhoto.jsp?eno=<%=sd.getEno()%>"><span>Change</span></a></center>
                </td>  
                <td>
                    <a href="admin_editStudent.jsp?eno=<%=sd.getEno()%>">Edit</a>
                    <a href="admin_viewAllStudents.jsp?eno=<%=sd.getEno()%>">Delete</a>
                </td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
        </div>
    </body>
</html>
