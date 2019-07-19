
<%
    String fid = (String) session.getAttribute("fid");
    if (fid == null) {
%>
<jsp:forward page="signin.jsp"></jsp:forward>

<%
    }
%>
<!-- header -->
<header>
    <div class="container">
        <div class="header d-lg-flex justify-content-between align-items-center py-2 px-sm-2 px-1">
            <!-- logo -->
            <div id="logo">
                <h1><a href="admin_home.jsp">Feeder</a></h1>
            </div>
            <div class="nav_w3ls ml-lg-5">
                <nav>
                    <ul>
                        <li><a href="faculty_home.jsp">Home</a></li>
                        <li>
                            <label for="drop-2" class="toggle toogle-2">Pages <span class="fa fa-angle-down"
                                                                                    aria-hidden="true"></span>
                            </label>
                            <a href="#">Attendance <span class="fa fa-angle-down" aria-hidden="true"></span></a>
                            <input type="checkbox" id="drop-2" />
                            <ul>
                                <li><a href="faculty_takeAttendance.jsp" class="drop-text">Take</a></li>
                                <li><a href="faculty_viewAttendance.jsp" class="drop-text">View</a></li>
                                <li><a href="faculty_editAttendance.jsp" class="drop-text">Edit</a></li>
                            </ul>
                        </li>
                        <li><a href="faculty_resetPassword.jsp">Reset Password</a></li>
                        <li><a href="#">Signout</a></li>
                    </ul>
                </nav>
            </div>
            <!-- //nav -->
        </div>
    </div>
</header>